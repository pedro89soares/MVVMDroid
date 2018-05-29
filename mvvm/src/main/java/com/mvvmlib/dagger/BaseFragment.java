package com.mvvmlib.dagger;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends DaggerFragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    protected T viewDataBinding;
    protected V viewModel;
    protected String mTitle;
    protected ViewModelProvider viewModelProvider;

    @LayoutRes
    public abstract int getLayoutId();

    public abstract V getViewModel();

    public abstract int getViewModelVariable();

    public int getViewModelBindingVariable() {
        return getViewModelVariable();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        this.viewModelProvider = ViewModelProviders.of(getActivity(), viewModelFactory);
        this.viewModel = viewModel == null ? getViewModel() : viewModel;
        this.viewDataBinding.setVariable(getViewModelBindingVariable(), viewModel);
        return this.viewDataBinding.getRoot();
    }

    public String getTitle() {
        return mTitle;
    }
}
