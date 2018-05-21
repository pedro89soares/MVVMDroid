package com.mvvmlib.Services.Interfaces;

import android.app.Application;

import com.mvvmlib.Activities.BaseActivity;

public interface ICurrentActivityService extends IService {

    Application.ActivityLifecycleCallbacks getActivityMonitor();

    BaseActivity getCurrentActivity();

    /**
     *
     * @param listener
     */
    void registerActivityChangedNotification(IActivityChangedListener listener);

    /**
     *
     * @param listener
     */
    void removeActivityChangedNotification(IActivityChangedListener listener);

    /**
     *
     * @param activity
     * @param listener
     */
    void registerActivityBackPressedNotification(Class activity, IActivityBackPressedListener listener);

    /**
     *
     * @param listener
     */
    void removeActivityBackPressedNotification(IActivityBackPressedListener listener);

    boolean backPressed();

    void clear();
}
