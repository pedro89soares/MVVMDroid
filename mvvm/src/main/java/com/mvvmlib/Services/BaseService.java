package com.mvvmlib.Services;

import android.support.v7.app.AppCompatActivity;

import com.mvvmlib.Services.Interfaces.ICurrentActivityService;

public class BaseService {

    protected AppCompatActivity getCurrentActivity() {
        ICurrentActivityService activityService = ServiceLocator.getInstance().getService(ICurrentActivityService.class);
        if (activityService != null)
            return activityService.getCurrentActivity();
        return null;
    }
}
