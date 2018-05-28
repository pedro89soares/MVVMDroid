package com.mvvmlib.services.interfaces;


public interface ISharedPreferences extends IService {

    /**
     *
     * @param key
     * @param defaultValue
     * @return value
     */
    String getString(String key, String defaultValue);

    /**
     *
     * @param key
     * @param defaultValue
     * @return value
     */
    int getInt(String key, int defaultValue);

    /**
     *
     * @param key
     * @param defaultValue
     * @return value
     */
    boolean getBoolean(String key, boolean defaultValue);

    /**
     *
     * @param key
     * @param value
     */
    void setString(String key, String value);

    /**
     *
     * @param key
     * @param value
     */
    void setInt(String key, int value);

    /**
     *
     * @param key
     * @param value
     */
    void setBoolean(String key, boolean value);
}
