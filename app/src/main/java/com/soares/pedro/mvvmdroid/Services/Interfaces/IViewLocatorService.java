package com.soares.pedro.mvvmdroid.Services.Interfaces;

import android.support.v4.app.Fragment;

import com.soares.pedro.mvvmdroid.Activities.BaseActivity;
import com.soares.pedro.mvvmdroid.Models.FragmentView;

public interface IViewLocatorService<F extends Class<Fragment>, A extends Class<BaseActivity>> extends IService {

    public void registerView(String key, A activity);

    public void registerView(String key, F fragment, String parentActivity, int container);

    Class<A> getView(String key);

    FragmentView getFragmentView(String key);

    public boolean containsView(String key);

    public boolean containsFragmentView(String key);

    public <f extends Fragment> f getFragmentInstanceOf(String view);

    public <a extends BaseActivity> a getActivityInstanceOf(String view);
}
