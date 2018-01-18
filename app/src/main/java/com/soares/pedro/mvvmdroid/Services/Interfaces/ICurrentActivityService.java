package com.soares.pedro.mvvmdroid.Services.Interfaces;

import android.app.Application;

import com.soares.pedro.mvvmdroid.Activities.BaseActivity;

public interface ICurrentActivityService extends IService {

    Application.ActivityLifecycleCallbacks getActivityMonitor();

    BaseActivity getCurrentActivity();

    void registerActivityChangedNotification(IActivityChangedListener listener);

    void removeActivityChangedNotification(IActivityChangedListener listener);

    void registerActivityBackPressedNotification(Class activity, IActivityBackPressedListener listener);

    void removeActivityBackPressedNotification(IActivityBackPressedListener listener);

    boolean backPressed();

    void clear();
}
