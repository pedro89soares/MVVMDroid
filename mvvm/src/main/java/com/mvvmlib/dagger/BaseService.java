package com.mvvmlib.dagger;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.mvvmlib.services.interfaces.ICurrentActivityService;

import javax.inject.Inject;

public class BaseService {

    @Inject
    Context context;

    @Inject
    ICurrentActivityService activityService;

    protected AppCompatActivity getCurrentActivity() {
        return activityService.getCurrentActivity();
    }

    protected Context getContext() {
        return context;
    }
}
