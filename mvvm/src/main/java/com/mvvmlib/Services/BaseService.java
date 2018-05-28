package com.mvvmlib.services;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.mvvmlib.services.interfaces.ICurrentActivityService;

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
