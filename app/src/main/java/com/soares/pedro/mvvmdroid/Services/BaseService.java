package com.soares.pedro.mvvmdroid.Services;

import android.support.v7.app.AppCompatActivity;

import com.soares.pedro.mvvmdroid.Services.Interfaces.ICurrentActivityService;

class BaseService {

    protected AppCompatActivity getCurrentActivity() {
        ICurrentActivityService activityService = ServiceLocator.getInstance().getService(ICurrentActivityService.class);
        if (activityService != null)
            return activityService.getCurrentActivity();
        return null;
    }


}
