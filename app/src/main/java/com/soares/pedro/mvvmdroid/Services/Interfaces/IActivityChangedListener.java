package com.soares.pedro.mvvmdroid.Services.Interfaces;

import android.support.v7.app.AppCompatActivity;

public interface IActivityChangedListener {
    void notifyActivityChanged(AppCompatActivity activity);

    void notifyActivityStarted(AppCompatActivity activity);
}
