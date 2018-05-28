package com.mvvmlib.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.mvvmlib.services.interfaces.ICurrentActivityService;
import com.mvvmlib.services.ServiceLocator;
import com.mvvmlib.viewModels.BaseViewModel;

public class BaseActivity extends AppCompatActivity {
    protected BaseViewModel viewModel;

    private static final String[] needPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkAppPermissions();
    }

    @Override
    public void onBackPressed() {
        if (!ServiceLocator.getInstance().getService(ICurrentActivityService.class).backPressed()) {
            super.onBackPressed();
        }
    }

    public BaseViewModel getViewModel() {
        return viewModel;
    }

    protected void checkAppPermissions() {
        for (String permission : needPermissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{permission}, 1);
            }
        }

    }
}
