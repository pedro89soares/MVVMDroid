package com.soares.pedro.mvvmlib.Services;

import android.support.v7.app.AppCompatActivity;


import com.soares.pedro.mvvmlib.Services.Interfaces.ICurrentActivityService;

class BaseService {

    protected AppCompatActivity getCurrentActivity() {
        ICurrentActivityService activityService = ServiceLocator.getInstance().getService(ICurrentActivityService.class);
        if (activityService != null)
            return activityService.getCurrentActivity();
        return null;
    }


}
