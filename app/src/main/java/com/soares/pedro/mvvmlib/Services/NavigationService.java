package com.soares.pedro.mvvmlib.Services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.soares.pedro.mvvmlib.Services.Interfaces.IActivityChangedListener;
import com.soares.pedro.mvvmlib.Services.Interfaces.ICurrentActivityService;
import com.soares.pedro.mvvmlib.Services.Interfaces.INavigationService;

import java.io.Serializable;
import java.util.HashMap;

public class NavigationService extends BaseService implements INavigationService, IActivityChangedListener {


    private static final String HASH_MAP_KEY = "mapKey";
    private HashMap<String, Class> locator;
    private HashMap<String, FragmentView> fragmentLocator;
    private PendingOperation pendingOperation;

    @Override
    public void register(String view, Class type) {
        if (locator == null)
            locator = new HashMap<>();
        if (view != null && !view.trim().isEmpty())
            locator.put(view, type);
    }

    @Override
    public void register(String view, String activity, int container, Class type) {
        if (view == null || type == null || !locator.containsKey(activity)) return;
        if (fragmentLocator == null)
            fragmentLocator = new HashMap<>();

        FragmentView fv = new FragmentView(activity, view, container, type);
        fragmentLocator.put(view, fv);
    }

    @Override
    public void navigateTo(String view) {
        navigateTo(view, true);
    }

    @Override
    public void navigateTo(String view, boolean addToBackStack) {
        navigateWithContent(view, null, addToBackStack);
    }

    @Override
    public void navigateWithContent(String view, HashMap<String, Object> map) {
        navigateWithContent(view, map, true);
    }

    @Override
    public void navigateWithContent(String view, HashMap<String, Object> map, boolean addToBackStack) {
        AppCompatActivity currentActivity = getCurrentActivity();
        Class activity;
        if (locator.containsKey(view)) {
            activity = locator.get(view);
            if (activity != null && currentActivity != null && currentActivity.getClass() != activity) {
                Intent intent = new Intent(currentActivity, activity);
                if (map != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(HASH_MAP_KEY, map);
                    intent.putExtras(bundle);
                }
                currentActivity.startActivity(intent);
            }
        } else if (fragmentLocator.containsKey(view)) {
            FragmentView fv = fragmentLocator.get(view);
            activity = locator.get(fv.activity);
            if (currentActivity.getClass() != activity) {
                pendingOperation = new PendingOperation(fv, map);
                getCurrentActivityService().registerActivityChangedNotification(this);
                navigateTo(fv.activity, true);
            } else {
                View rootView = currentActivity.findViewById(android.R.id.content);
                if (rootView != null && rootView.findViewById(fv.container) != null) {
                    changeFragmentView(fv, map, addToBackStack);
                }
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
        Fragment frag = getFragmentInstance(currentActivity.getSupportFragmentManager(), fv.view, fv.type);
        if (frag != null) {
            if (map != null) {
                Bundle b = new Bundle();
                b.putSerializable(HASH_MAP_KEY, map);
                frag.setArguments(b);
            }
            replaceFragment(frag, fv.container, fv.view, addToBackStack);
        }
    }

    @Override
    public void notifyActivityChanged(AppCompatActivity activity) {
        if (activity == null) return;
        if (pendingOperation == null) {
            getCurrentActivityService().removeActivityChangedNotification(this);
            return;
        }
        if (activity.getClass() == locator.get(pendingOperation.fragmentView.activity)) {
            changeFragmentView(pendingOperation.fragmentView, pendingOperation.map, false);
        }
    }

    private ICurrentActivityService getCurrentActivityService() {
        return ServiceLocator.getInstance().getService(ICurrentActivityService.class);
    }

    private class PendingOperation {
        private FragmentView fragmentView;
        private HashMap<String, Object> map;

        private PendingOperation(FragmentView framentView, HashMap<String, Object> map) {
            this.fragmentView = framentView;
            this.map = map;
        }
    }

    private class FragmentView {
        private String activity, view;
        private int container;
        private Class type;

        private FragmentView(String activity, String view, int container, Class type) {
            this.activity = activity;
            this.view = view;
            this.container = container;
            this.type = type;
        }
    }
}
