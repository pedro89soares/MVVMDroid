package com.soares.pedro.mvvmdroid.Adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public abstract class MVVMViewPager extends FragmentStatePagerAdapter {
    public MVVMViewPager(FragmentManager fm) {
        super(fm);
    }

    public abstract int getPagePositonForKey(String key);
}
