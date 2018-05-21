package com.mvvmlib.example.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.example.R;
import com.example.example.databinding.ActivityTestBinding;
import com.mvvmlib.Activities.BaseActivity;
import com.mvvmlib.example.viewmodels.TestViewModel;

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestBinding binding  = DataBindingUtil.setContentView(this,R.layout.activity_test);
        TestViewModel viewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        binding.setViewModel(viewModel);
    }
}
