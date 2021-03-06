package com.mvvmlib.viewModels;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.support.v7.app.AppCompatActivity;

import com.mvvmlib.services.interfaces.ICurrentActivityService;
import com.mvvmlib.services.interfaces.IDialogService;
import com.mvvmlib.services.interfaces.INavigationService;
import com.mvvmlib.services.ServiceLocator;


public class BaseViewModel extends ViewModel {

    public ObservableBoolean isLoading;

    protected BaseViewModel() {
        isLoading = new ObservableBoolean(false);
    }

    protected INavigationService getNavigationService() {
        return ServiceLocator.getInstance().getService(INavigationService.class);
    }

    protected IDialogService getDialogService() {
        return ServiceLocator.getInstance().getService(IDialogService.class);
    }

    protected ICurrentActivityService getCurrentActivityService() {
        return ServiceLocator.getInstance().getService(ICurrentActivityService.class);
    }

    protected AppCompatActivity getCurrentActivity() {
        return getCurrentActivityService().getCurrentActivity();
    }

    protected void navigateBack() {
        getNavigationService().back();
    }
}
