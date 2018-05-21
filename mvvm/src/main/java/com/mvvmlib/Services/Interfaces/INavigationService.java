package com.mvvmlib.Services.Interfaces;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.mvvmlib.Services.Enums.NavigationMode;

import java.util.HashMap;

public interface INavigationService extends IService {

    void navigateTo(String view);

    void navigateTo(String view, boolean addToBackStack);

    void navigateTo(String view, boolean addToBackStack, NavigationMode navigationMode);

    void navigateWithContent(String view, HashMap<String, Object> map);

    void navigateWithContent(String view, HashMap<String, Object> map, boolean addToBackStack);

    void navigateWithContent(String view, HashMap<String, Object> map, boolean addToBackStack, NavigationMode navigationMode);

    HashMap getContents(Intent intent);

    void back();

    void backTo(String view);

}
