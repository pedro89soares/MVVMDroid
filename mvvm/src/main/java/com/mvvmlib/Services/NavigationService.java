package com.mvvmlib.Services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mvvmlib.Adapters.MVVMViewPager;
import com.mvvmlib.Models.FragmentView;
import com.mvvmlib.Models.PendingOperation;
import com.mvvmlib.Services.Enums.NavigationMode;
import com.mvvmlib.Services.Interfaces.IActivityChangedListener;
import com.mvvmlib.Services.Interfaces.ICurrentActivityService;
import com.mvvmlib.Services.Interfaces.INavigationService;
import com.mvvmlib.Services.Interfaces.IViewLocatorService;

import java.io.Serializable;
import java.util.HashMap;

public class NavigationService extends BaseService implements INavigationService, IActivityChangedListener {


    private static final String HASH_MAP_KEY = "mapKey";
    private PendingOperation pendingOperation;
    private String backDestinationView;

    public NavigationService() {
        super();
    }

    @Override
    public void navigateTo(String view) {
        navigateTo(view, true, NavigationMode.Normal);
    }

    @Override
    public void navigateTo(String view, boolean addToBackStack) {
        navigateTo(view, addToBackStack, NavigationMode.Normal);
    }

    @Override
    public void navigateTo(String view, boolean addToBackStack, NavigationMode navigationMode) {
        navigateWithContent(view, null, addToBackStack, navigationMode);
    }

    @Override
    public void navigateWithContent(String view, HashMap<String, Object> map) {
        navigateWithContent(view, map, true, NavigationMode.Normal);
    }

    @Override
    public void navigateWithContent(String view, HashMap<String, Object> map, boolean addToBackStack) {
        navigateWithContent(view, map, addToBackStack, NavigationMode.Normal);
    }

    @Override
    public void navigateWithContent(String view, HashMap<String, Object> map, boolean addToBackStack, NavigationMode navigationMode) {
        AppCompatActivity currentActivity = getCurrentActivity();
        IViewLocatorService locator = ServiceLocator.getInstance().getService(IViewLocatorService.class);
        Class activity;
        if (locator.containsView(view)) {
            activity = locator.getView(view);
            if (activity != null && currentActivity != null && currentActivity.getClass() != activity) {
                Intent intent = new Intent(currentActivity, activity);

                if (map != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(HASH_MAP_KEY, map);
                    intent.putExtras(bundle);
                }
                switch (navigationMode) {
                    case Normal:
                        currentActivity.startActivity(intent);
                        break;
                    case ClearTop:
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        currentActivity.startActivity(intent);
                        currentActivity.finish();
                        break;
                    case ClearStack:
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        currentActivity.startActivity(intent);
                        currentActivity.finish();
                        break;
                }
            }
        } else if (locator.containsFragmentView(view)) {
            FragmentView fv = locator.getFragmentView(view);
            activity = locator.getView(fv.getActivity());
            if (currentActivity.getClass() != activity) {
                pendingOperation = new PendingOperation(fv, map);
                getCurrentActivityService().registerActivityChangedNotification(this);
                navigateTo(fv.getActivity(), true, navigationMode);
            } else {
                changeFragmentView(fv, map, addToBackStack);
            }
        }
    }


    @Override
    public HashMap getContents(Intent intent) {
        if (intent == null) return null;
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable(HASH_MAP_KEY);
            if (serializable != null && serializable instanceof HashMap) {
                return (HashMap) serializable;
            }
        }
        return null;
    }

    @Override
    public void back() {
        AppCompatActivity currentActivity = getCurrentActivity();
        FragmentManager fragmentManager = currentActivity.getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 1)
            fragmentManager.popBackStack();
        else
            currentActivity.onBackPressed();
    }

    @Override
    public void backTo(String view) {
        IViewLocatorService locator = ServiceLocator.getInstance().getService(IViewLocatorService.class);
        if (locator.containsView(view)) {
            backDestinationView = view;
            getCurrentActivityService().registerActivityChangedNotification(this);
            getCurrentActivity().onBackPressed();
        }
    }

    private void replaceFragment(Fragment frag, int container, String tag, boolean addToBackStack) {
        AppCompatActivity currentActivity = getCurrentActivity();
        if (currentActivity == null) return;
        FragmentManager manager = currentActivity.getSupportFragmentManager();
        int index = manager.getBackStackEntryCount() - 1;
        if (index >= 0) {
            FragmentManager.BackStackEntry backEntry = manager.getBackStackEntryAt(index);
            String currentFragmentTag = backEntry.getName();
            if (currentFragmentTag != null && currentFragmentTag.equalsIgnoreCase(tag)) return;
        }
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, frag, tag);
        if (addToBackStack)
            transaction.addToBackStack(tag);
        transaction.commit();
    }

    private Fragment getFragmentInstance(FragmentManager fm, String view, Class type) {
        Fragment frag = fm.findFragmentByTag(view);
        if (frag == null) {
            try {
                frag = (Fragment) type.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return frag;
    }

    private void changeFragmentView(FragmentView fv, HashMap<String, Object> map, boolean addToBackStack) {
        AppCompatActivity currentActivity = getCurrentActivity();

        View rootView = currentActivity.findViewById(android.R.id.content);
        if (rootView != null) {
            View container = rootView.findViewById(fv.getContainer());
            if (container != null && ViewPager.class.isAssignableFrom(container.getClass())) {
                ViewPager pager = (ViewPager) container;
                PagerAdapter adpt = pager.getAdapter();
                if (adpt != null && MVVMViewPager.class.isAssignableFrom(adpt.getClass())) {
                    MVVMViewPager adapter = (MVVMViewPager) adpt;
                    pager.setCurrentItem(adapter.getPagePositonForKey(fv.getView()), true);
                }
            } else {
                Fragment frag = getFragmentInstance(currentActivity.getSupportFragmentManager(), fv.getView(), fv.getType());
                if (frag != null) {
                    if (map != null) {
                        Bundle b = new Bundle();
                        b.putSerializable(HASH_MAP_KEY, map);
                        frag.setArguments(b);
                    }
                    replaceFragment(frag, fv.getContainer(), fv.getView(), addToBackStack);
                }
            }
        }
    }

    @Override
    public void notifyActivityChanged(AppCompatActivity activity) {
        IViewLocatorService locator = ServiceLocator.getInstance().getService(IViewLocatorService.class);
        if (activity == null) return;
        if (backDestinationView != null) {
            if (activity.getClass() == locator.getView(backDestinationView)) {
                backDestinationView = null;
                getCurrentActivityService().removeActivityChangedNotification(this);
            } else
                activity.onBackPressed();
            return;
        }
        if (pendingOperation == null) {
            getCurrentActivityService().removeActivityChangedNotification(this);
            return;
        }
        if (activity.getClass() == locator.getView(pendingOperation.getFragmentView().getActivity()) && !pendingOperation.isApplyAfterLayout()) {
            changeFragmentView(pendingOperation.getFragmentView(), pendingOperation.getMap(), false);
            pendingOperation = null;
        }
    }

    @Override
    public void notifyActivityStarted(AppCompatActivity activity) {
        IViewLocatorService locator = ServiceLocator.getInstance().getService(IViewLocatorService.class);
        if (activity == null) return;
        if (backDestinationView != null) {
            if (activity.getClass() == locator.getView(backDestinationView)) {
                backDestinationView = null;
                getCurrentActivityService().removeActivityChangedNotification(this);
            } else
                activity.onBackPressed();
            return;
        }
        if (pendingOperation == null) {
            getCurrentActivityService().removeActivityChangedNotification(this);
            return;
        }
        if (activity.getClass() == locator.getView(pendingOperation.getFragmentView().getActivity()) && pendingOperation.isApplyAfterLayout()) {
            changeFragmentView(pendingOperation.getFragmentView(), pendingOperation.getMap(), false);
            pendingOperation = null;
        }
    }

    @Override
    public void notifyActivityResumed(AppCompatActivity activity) {
        if (activity == null) return;
        if (pendingOperation == null) {
            getCurrentActivityService().removeActivityChangedNotification(this);
        }
    }

    private ICurrentActivityService getCurrentActivityService() {
        return ServiceLocator.getInstance().getService(ICurrentActivityService.class);
    }
}
