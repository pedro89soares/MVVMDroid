package com.mvvmlib.Services.Interfaces;


public interface ISharedPreferences extends IService {

    String getString(String key, String defaultValue);

    int getInt(String key, int defaultValue);

    boolean getBoolean(String key, boolean defaultValue);

    void setString(String key, String value);

    void setInt(String key, int value);

    void setBoolean(String key, boolean value);
}
