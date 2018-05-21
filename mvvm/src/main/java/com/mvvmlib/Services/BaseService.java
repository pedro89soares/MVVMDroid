package com.mvvmlib.Services;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.mvvmlib.Services.Interfaces.ICurrentActivityService;

public class BaseService {

    private Context context;

    protected AppCompatActivity getCurrentActivity() {
        ICurrentActivityService activityService = ServiceLocator.getInstance().getService(ICurrentActivityService.class);
        if (activityService != null)
            return activityService.getCurrentActivity();
        return null;
    }

    protected Context getContext(){
        if(context==null && getCurrentActivity()!=null)
            context = getCurrentActivity().getApplicationContext();
        return context;
    }
}
