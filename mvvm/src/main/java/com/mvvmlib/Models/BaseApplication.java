package com.mvvmlib.Models;

import android.app.Application;

import com.mvvmlib.Services.CurrentActivityService;
import com.mvvmlib.Services.DialogService;
import com.mvvmlib.Services.Interfaces.ICurrentActivityService;
import com.mvvmlib.Services.Interfaces.IDialogService;
import com.mvvmlib.Services.Interfaces.INavigationService;
import com.mvvmlib.Services.Interfaces.ISharedPreferences;
import com.mvvmlib.Services.Interfaces.IViewLocatorService;
import com.mvvmlib.Services.NavigationService;
import com.mvvmlib.Services.ServiceLocator;
import com.mvvmlib.Services.SharedPreferencesService;
import com.mvvmlib.Services.ViewLocatorService;

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
