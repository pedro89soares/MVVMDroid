package com.soares.pedro.mvvmdroid.Models;

import android.app.Application;

import com.soares.pedro.mvvmdroid.Services.CurrentActivityService;
import com.soares.pedro.mvvmdroid.Services.DialogService;
import com.soares.pedro.mvvmdroid.Services.Interfaces.ICurrentActivityService;
import com.soares.pedro.mvvmdroid.Services.Interfaces.IDialogService;
import com.soares.pedro.mvvmdroid.Services.Interfaces.INavigationService;
import com.soares.pedro.mvvmdroid.Services.Interfaces.IViewLocatorService;
import com.soares.pedro.mvvmdroid.Services.NavigationService;
import com.soares.pedro.mvvmdroid.Services.ServiceLocator;
import com.soares.pedro.mvvmdroid.Services.ViewLocatorService;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceLocator.getInstance().registerService(ICurrentActivityService.class, CurrentActivityService.class);
        ServiceLocator.getInstance().registerService(INavigationService.class, NavigationService.class);
        ServiceLocator.getInstance().registerService(IDialogService.class, DialogService.class);
        ServiceLocator.getInstance().registerService(IViewLocatorService.class, ViewLocatorService.class);


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
