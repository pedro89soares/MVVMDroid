package com.mvvmlib.Services.Interfaces;

import android.support.v7.app.AppCompatActivity;

public interface IActivityChangedListener {
    /**
     *
     * @param activity
     */
    void notifyActivityChanged(AppCompatActivity activity);

    /**
     *
     * @param activity
     */
    void notifyActivityStarted(AppCompatActivity activity);

    /**
     *
     * @param activity
     */
    void notifyActivityResumed(AppCompatActivity activity);
}
