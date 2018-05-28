package com.mvvmlib.dagger;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableBoolean;
import android.support.v7.app.AppCompatActivity;

import com.mvvmlib.services.interfaces.ICurrentActivityService;
import com.mvvmlib.services.interfaces.IDialogService;
import com.mvvmlib.services.interfaces.INavigationService;

import javax.inject.Inject;


public class BaseViewModel extends ViewModel {

    public ObservableBoolean isLoading;

    @Inject
    INavigationService navigationService;
    @Inject
    IDialogService dialogService;
    @Inject
    ICurrentActivityService currentActivityService;
    @Inject
    Context context;

    protected BaseViewModel() {
        isLoading = new ObservableBoolean(false);
    }

    protected INavigationService getNavigationService() {
        return navigationService;
    }

    protected IDialogService getDialogService() {
        return dialogService;
    }

    protected ICurrentActivityService getCurrentActivityService() {
        return currentActivityService;
    }

    protected AppCompatActivity getCurrentActivity() {
        return currentActivityService.getCurrentActivity();
    }
    protected void navigateBack() {
        getNavigationService().back();
    }
}
