package com.mvvmlib.models;

import android.app.Application;

import com.mvvmlib.services.CurrentActivityService;
import com.mvvmlib.services.DialogService;
import com.mvvmlib.services.interfaces.ICurrentActivityService;
import com.mvvmlib.services.interfaces.IDialogService;
import com.mvvmlib.services.interfaces.INavigationService;
import com.mvvmlib.services.interfaces.ISharedPreferences;
import com.mvvmlib.services.interfaces.IViewLocatorService;
import com.mvvmlib.services.NavigationService;
import com.mvvmlib.services.ServiceLocator;
import com.mvvmlib.services.SharedPreferencesService;
import com.mvvmlib.services.ViewLocatorService;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceLocator.getInstance().registerService(ICurrentActivityService.class, CurrentActivityService.class);
        ServiceLocator.getInstance().registerService(INavigationService.class, NavigationService.class);
        ServiceLocator.getInstance().registerService(IDialogService.class, DialogService.class);
        ServiceLocator.getInstance().registerService(IViewLocatorService.class, ViewLocatorService.class);
        ServiceLocator.getInstance().registerService(ISharedPreferences.class, SharedPreferencesService.class);

        ICurrentActivityService currentActivityService = ServiceLocator.getInstance().getService(ICurrentActivityService.class);
        registerActivityLifecycleCallbacks(currentActivityService.getActivityMonitor());
    }

    @Override
    public void onTerminate() {
        ICurrentActivityService currentActivityService = ServiceLocator.getInstance().getService(ICurrentActivityService.class);
        unregisterActivityLifecycleCallbacks(currentActivityService.getActivityMonitor());
        super.onTerminate();
    }
}
