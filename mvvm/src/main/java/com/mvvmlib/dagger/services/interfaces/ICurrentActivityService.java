package com.mvvmlib.dagger.services.interfaces;

import android.app.Application;

import com.mvvmlib.dagger.BaseActivity;
import com.mvvmlib.services.interfaces.IActivityBackPressedListener;
import com.mvvmlib.services.interfaces.IActivityChangedListener;
import com.mvvmlib.services.interfaces.IService;

public interface ICurrentActivityService extends IService {

    Application.ActivityLifecycleCallbacks getActivityMonitor();

    BaseActivity getCurrentActivity();

    /**
     * @param listener
     */
    void registerActivityChangedNotification(IActivityChangedListener listener);

    /**
     * @param listener
     */
    void removeActivityChangedNotification(IActivityChangedListener listener);

    /**
     * @param activity
     * @param listener
     */
    void registerActivityBackPressedNotification(Class activity, IActivityBackPressedListener listener);

    /**
     * @param listener
     */
    void removeActivityBackPressedNotification(IActivityBackPressedListener listener);

    boolean backPressed();

    void clear();
}
