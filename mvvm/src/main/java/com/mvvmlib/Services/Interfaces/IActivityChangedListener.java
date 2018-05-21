package com.mvvmlib.Services.Interfaces;

import android.support.v7.app.AppCompatActivity;

public interface IActivityChangedListener {
    void notifyActivityChanged(AppCompatActivity activity);

    void notifyActivityStarted(AppCompatActivity activity);

    void notifyActivityResumed(AppCompatActivity activity);
}
