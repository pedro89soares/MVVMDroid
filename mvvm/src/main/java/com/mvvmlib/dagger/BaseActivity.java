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

    protected String[] getPermitions() {
        return new String[0];
    }

    protected void checkAppPermissions() {
        String[] needPermissions = getPermitions();
        if (needPermissions == null || needPermissions.length == 0) return;
        for (String permission : needPermissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{permission}, 1);
            }
        }
    }
}
