package com.mvvmlib.example.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.example.databinding.ActivityHomeBinding;
import com.example.example.R;
import com.mvvmlib.activities.BaseActivity;
import com.mvvmlib.example.viewmodels.HomeViewModel;

public class HomeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        HomeViewModel viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        binding.setViewModel(viewModel);
    }
}
