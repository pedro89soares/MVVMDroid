package com.mvvmlib.Services;

import android.content.Context;
import android.content.SharedPreferences;

import com.mvvmlib.Services.Interfaces.ISharedPreferences;
import com.mvvmlib.Utils.ResourceUtils;
import com.soares.pedro.mvvmlib.R;


public class SharedPreferencesService extends BaseService implements ISharedPreferences {

    public SharedPreferencesService(){
        super();
    }

    private SharedPreferences getSharedPreferences(){
        Context context = getCurrentActivity();
        if(context==null) return null;
        return context.getSharedPreferences(ResourceUtils.getString(R.string.sharedPreferences),Context.MODE_PRIVATE);
    }

    @Override
    public String getString(String key, String defaultValue) {
        SharedPreferences preferences = getSharedPreferences();
        if(preferences!=null)
            return preferences.getString(key,defaultValue);
        return null;
    }

    @Override
    public int getInt(String key, int defaultValue) {
        SharedPreferences preferences = getSharedPreferences();
        if(preferences!=null)
            return preferences.getInt(key,defaultValue);
        return -1;
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        SharedPreferences preferences = getSharedPreferences();
        if(preferences!=null)
            return preferences.getBoolean(key,defaultValue);
        return false;
    }

    @Override
    public void setString(String key, String value) {
        SharedPreferences editor = getSharedPreferences();
        if(editor!=null)
            editor.edit().putString(key,value).apply();
    }

    @Override
    public void setInt(String key, int value) {
        SharedPreferences editor = getSharedPreferences();
        if(editor!=null)
            editor.edit().putInt(key,value).apply();
    }

    @Override
    public void setBoolean(String key, boolean value) {
        SharedPreferences editor = getSharedPreferences();
        if(editor!=null)
            editor.edit().putBoolean(key,value).apply();
    }
}
