package com.soares.pedro.mvvmdroid.Services.Interfaces;

import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.HashMap;

public interface INavigationService extends IService {

    void navigateTo(String view);

    void navigateTo(String view, boolean addToBackStack);

    void navigateTo(String view, boolean addToBackStack, boolean clearStack);

    void navigateWithContent(String view, HashMap<String, Object> map);

    void navigateWithContent(String view, HashMap<String, Object> map, boolean addToBackStack);

    void navigateWithContent(String view, HashMap<String, Object> map, boolean addToBackStack, boolean clearStack);

    HashMap getContents(Intent intent);

    void back();

}
