package com.soares.pedro.mvvmlib.Services.Interfaces;

import android.content.Intent;

import java.util.HashMap;

public interface INavigationService extends IService {

    void register(String view, Class viewInstanceClass);

    void register(String view, String activity, int container, Class viewInstanceClass);

    void navigateTo(String view);

    void navigateTo(String view, boolean addToBackStack);

    void navigateWithContent(String view, HashMap<String, Object> map);

    void navigateWithContent(String view, HashMap<String, Object> map, boolean addToBackStack);

    HashMap getContents(Intent intent);

    void back();

}
