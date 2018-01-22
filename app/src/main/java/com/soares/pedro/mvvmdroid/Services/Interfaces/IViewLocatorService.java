package com.soares.pedro.mvvmdroid.Services.Interfaces;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.soares.pedro.mvvmdroid.Models.FragmentView;

public interface IViewLocatorService extends IService {

    public void registerView(String key, Class activity);

    public void registerView(String key, Class fragment, String parentActivity, int container);

    Class getView(String key);

    FragmentView getFragmentView(String key);

    public boolean containsView(String key);

    public boolean containsFragmentView(String key);

    public Fragment getFragmentInstanceOf(String view);

    public AppCompatActivity getActivityInstanceOf(String view);
}
