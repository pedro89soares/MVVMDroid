package com.mvvmlib.example.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.example.R;
import com.example.example.databinding.ActivityDetailBinding;
import com.mvvmlib.Activities.BaseActivity;
import com.mvvmlib.example.viewmodels.DetailViewModel;

public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        DetailViewModel viewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        binding.setViewModel(viewModel);
    }
}
