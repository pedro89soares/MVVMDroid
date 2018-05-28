package com.mvvmlib.services.interfaces;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mvvmlib.models.FragmentView;

public interface IViewLocatorService extends IService {

    /**
     *
     * @param key
     * @param activity
     */
    public void registerView(String key, Class activity);

    /**
     *
     * @param key
     * @param fragment
     * @param parentActivity
     * @param container
     */
    public void registerView(String key, Class fragment, String parentActivity, int container);

    /**
     *
     * @param view
     * @return
     */
    Class getView(String view);

    /**
     *
     * @param view
     * @return
     */
    FragmentView getFragmentView(String view);

    /**
     *
     * @param view
     * @return
     */
    public boolean containsView(String view);

    /**
     *
     * @param view
     * @return
     */
    public boolean containsFragmentView(String view);

    /**
     *
     * @param view
     * @return
     */
    public Fragment getFragmentInstanceOf(String view);

    /**
     *
     * @param view
     * @return
     */
    public AppCompatActivity getActivityInstanceOf(String view);
}
