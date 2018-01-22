package com.soares.pedro.mvvmdroid.Services;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.soares.pedro.mvvmdroid.Activities.BaseActivity;
import com.soares.pedro.mvvmdroid.Services.Interfaces.IActivityBackPressedListener;
import com.soares.pedro.mvvmdroid.Services.Interfaces.IActivityChangedListener;
import com.soares.pedro.mvvmdroid.Services.Interfaces.ICurrentActivityService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CurrentActivityService implements ICurrentActivityService {

    private BaseActivity currentActivity;
    private ArrayList<IActivityChangedListener> activityChangedListeners;
    private HashMap<Class, ArrayList<IActivityBackPressedListener>> activityBackPressedListeners;

    @Override
    public Application.ActivityLifecycleCallbacks getActivityMonitor() {
        return CurrentActivityMonitor;
    }

    public BaseActivity getCurrentActivity() {
        return currentActivity;
    }

    @Override
    public void registerActivityChangedNotification(IActivityChangedListener listener) {
        if (activityChangedListeners == null)
            activityChangedListeners = new ArrayList<>();
        if (listener != null && !activityChangedListeners.contains(listener))
            activityChangedListeners.add(listener);
    }

    @Override
    public void removeActivityChangedNotification(IActivityChangedListener listener) {
        if (listener != null && activityChangedListeners != null && activityChangedListeners.contains(listener))
            activityChangedListeners.remove(listener);
    }

    @Override
    public void registerActivityBackPressedNotification(Class activity, IActivityBackPressedListener listener) {
        if (activityBackPressedListeners == null)
            activityBackPressedListeners = new HashMap<>();
        if (listener != null && activity != null) {
            if (!activityBackPressedListeners.containsKey(activity))
                activityBackPressedListeners.put(activity, new ArrayList<IActivityBackPressedListener>());

            if (!activityBackPressedListeners.get(activity).contains(listener))
                activityBackPressedListeners.get(activity).add(listener);
        }
    }

    @Override
    public void removeActivityBackPressedNotification(IActivityBackPressedListener listener) {
        if (listener != null && activityBackPressedListeners != null && activityBackPressedListeners.size() > 0) {
            Set<Map.Entry<Class, ArrayList<IActivityBackPressedListener>>> entries = activityBackPressedListeners.entrySet();
            for (Map.Entry<Class, ArrayList<IActivityBackPressedListener>> entry : entries) {
                if (entry.getValue() != null && entry.getValue().contains(listener)) {
                    entry.getValue().remove(listener);
                }
            }
        }
    }

    @Override
    public boolean backPressed() {
        boolean wasHandled = false;
        if (currentActivity != null && activityBackPressedListeners != null && activityBackPressedListeners.containsKey(currentActivity.getClass())) {
            ArrayList<IActivityBackPressedListener> listeners = activityBackPressedListeners.get(currentActivity.getClass());
            for (IActivityBackPressedListener listener : listeners) {
                wasHandled = listener.notifyActivityBackPressed();
                if (wasHandled)
                    break;
            }
        }
        return wasHandled;
    }

    private void notifyActivityChanged(AppCompatActivity currentActivity) {
        if (activityChangedListeners == null) return;
        for (IActivityChangedListener listener : activityChangedListeners) {
            listener.notifyActivityChanged(currentActivity);
        }
    }

    private void notifyActivityStarted(AppCompatActivity currentActivity) {
        if (activityChangedListeners == null) return;
        for (IActivityChangedListener listener : activityChangedListeners) {
            listener.notifyActivityStarted(currentActivity);
        }
    }

    @Override
    public void clear() {
        currentActivity = null;
    }

    private Application.ActivityLifecycleCallbacks CurrentActivityMonitor = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            if (currentActivity != activity) {
                currentActivity = (BaseActivity) activity;
                notifyActivityChanged(currentActivity);
            }
        }

        @Override
        public void onActivityStarted(Activity activity) {
            if (currentActivity != activity) {
                currentActivity = (BaseActivity) activity;
            }
            notifyActivityStarted(currentActivity);
        }

        @Override
        public void onActivityResumed(Activity activity) {
            if (currentActivity != activity) {
                currentActivity = (BaseActivity) activity;
            }
        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            if (activity == currentActivity) {
                currentActivity = null;
                notifyActivityChanged(null);
            }
        }
    };
}
