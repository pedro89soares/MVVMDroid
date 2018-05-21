package com.mvvmlib.Services;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mvvmlib.Activities.BaseActivity;
import com.mvvmlib.Models.FragmentView;
import com.mvvmlib.Services.Interfaces.IViewLocatorService;

import java.util.HashMap;


public class ViewLocatorService extends BaseService implements IViewLocatorService {

    private HashMap<String, Class> locator;
    private HashMap<String, FragmentView> fragmentLocator;

    public ViewLocatorService() {
        locator = new HashMap<>();
        fragmentLocator = new HashMap<>();
    }

    @Override
    public void registerView(String key, Class activity) {
        if (locator == null)
            locator = new HashMap<>();
        if (key != null && !key.trim().isEmpty())
            locator.put(key, activity);
    }

    @Override
    public void registerView(String key, Class fragment, String parentActivity, int container) {
        if (key == null || !Fragment.class.isAssignableFrom(fragment) || !locator.containsKey(parentActivity))
            return;
        if (fragmentLocator == null)
            fragmentLocator = new HashMap<>();

        FragmentView fv = new FragmentView(parentActivity, key, container, fragment);
        fragmentLocator.put(key, fv);
    }

    @Override
    public Class<BaseActivity> getView(String key) {
        if (locator.containsKey(key)) {
            Class c = locator.get(key);
            return BaseActivity.class.isAssignableFrom(c) ? c : null;
        }
        return null;
    }

    @Override
    public FragmentView getFragmentView(String key) {
        if (fragmentLocator.containsKey(key))
            return fragmentLocator.get(key);
        return null;
    }

    @Override
    public boolean containsView(String key) {
        return locator.containsKey(key);
    }

    @Override
    public boolean containsFragmentView(String key) {
        return fragmentLocator.containsKey(key);
    }

    @Override
    public AppCompatActivity getActivityInstanceOf(String view) {
        if (containsView(view)) {
            Class c = locator.get(view);
            if (BaseActivity.class.isAssignableFrom(c)) {
                try {
                    return (BaseActivity) c.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public Fragment getFragmentInstanceOf(String view) {
        if (containsFragmentView(view)) {
            FragmentView fv = fragmentLocator.get(view);
            Class c = fv.getType();
            if (Fragment.class.isAssignableFrom(c)) {
                try {
                    return (Fragment) c.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
