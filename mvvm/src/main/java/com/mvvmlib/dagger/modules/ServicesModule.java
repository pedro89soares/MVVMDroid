package com.mvvmlib.dagger.modules;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.mvvmlib.services.CurrentActivityService;
import com.mvvmlib.services.DialogService;
import com.mvvmlib.services.SharedPreferencesService;
import com.mvvmlib.services.interfaces.ICurrentActivityService;
import com.mvvmlib.services.interfaces.IDialogService;
import com.mvvmlib.services.interfaces.INavigationService;
import com.mvvmlib.services.interfaces.ISharedPreferences;
import com.mvvmlib.services.interfaces.IViewLocatorService;
import com.mvvmlib.services.NavigationService;
import com.mvvmlib.services.ViewLocatorService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {

    @Provides
    @NonNull
    @Singleton
    public Context providesContext(Application app) {
        return app.getApplicationContext();
    }

    @Provides
    @NonNull
    @Singleton
    public ICurrentActivityService providesCurrentActivityService() {
        return new CurrentActivityService();
    }

    @Provides
    @NonNull
    @Singleton
    public INavigationService providesNavigationService() {
        return new NavigationService();
    }

    @Provides
    @NonNull
    @Singleton
    public IDialogService providesDialogService() {
        return new DialogService();
    }

    @Provides
    @NonNull
    @Singleton
    public IViewLocatorService providesViewLocatorService() {
        return new ViewLocatorService();
    }

    @Provides
    @NonNull
    @Singleton
    public ISharedPreferences providesSharePreferencesService() {
        return new SharedPreferencesService();
    }
}
