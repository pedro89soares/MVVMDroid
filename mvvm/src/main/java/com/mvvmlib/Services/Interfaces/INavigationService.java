package com.mvvmlib.services.interfaces;

import android.content.Intent;

import com.mvvmlib.services.enums.NavigationMode;

import java.util.HashMap;

public interface INavigationService extends IService {

    /**
     *
     * @param view
     */
    void navigateTo(String view);

    /**
     *
     * @param view
     * @param addToBackStack
     */
    void navigateTo(String view, boolean addToBackStack);

    /**
     *
     * @param view
     * @param addToBackStack
     * @param navigationMode
     */
    void navigateTo(String view, boolean addToBackStack, NavigationMode navigationMode);

    /**
     *
     * @param view
     * @param map
     */
    void navigateWithContent(String view, HashMap<String, Object> map);

    /**
     *
     * @param view
     * @param map
     * @param addToBackStack
     */
    void navigateWithContent(String view, HashMap<String, Object> map, boolean addToBackStack);

    /**
     *
     * @param view
     * @param map
     * @param addToBackStack
     * @param navigationMode
     */
    void navigateWithContent(String view, HashMap<String, Object> map, boolean addToBackStack, NavigationMode navigationMode);

    /**
     *
     * @param intent
     * @return
     */
    HashMap getContents(Intent intent);

    void back();

    /**
     *
     * @param view
     */
    void backTo(String view);

}
