package com.mvvmlib.dagger;

import android.Manifest;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.mvvmlib.services.interfaces.ICurrentActivityService;


import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends DaggerAppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    protected T viewDataBinding;
    protected V viewModel;

    @LayoutRes
    public abstract int getLayoutId();

    public abstract V getViewModel();

    public abstract int getViewModelVariable();

    private static final String[] neededPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE};

    @Inject
    Context applicationContext;

    @Inject
    ICurrentActivityService currentActivityService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkAppPermissions();
        performDataBinding();
    }

    private void performDataBinding() {
        this.viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.viewModel = viewModel == null ? getViewModel() : viewModel;
        this.viewDataBinding.setVariable(getViewModelVariable(), viewModel);
    }

    @Override
    public void onBackPressed() {
        if (!currentActivityService.backPressed()) {
            super.onBackPressed();
        }
    }

    protected void checkAppPermissions() {
        for (String permission : neededPermissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{permission}, 1);
            }
        }

    }
}
