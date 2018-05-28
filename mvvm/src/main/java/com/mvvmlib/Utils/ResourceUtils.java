package com.mvvmlib.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.mvvmlib.services.interfaces.ICurrentActivityService;
import com.mvvmlib.services.ServiceLocator;

public class ResourceUtils {

    private static Context context() {
        ICurrentActivityService currentActivityService = ServiceLocator.getInstance().getService(ICurrentActivityService.class);
        if (currentActivityService == null) return null;
        return currentActivityService.getCurrentActivity();
    }

    public static String getString(int resourceId) {
        if (context() != null) {
            return context().getString(resourceId);
        } else
            return null;
    }

    public static int getInt(int resourceId) {
        if (context() != null) {
            return context().getResources().getInteger(resourceId);
        } else
            return -1;
    }

    public static String[] getStringArray(int resourceId) {
        if (context() != null) {
            return context().getResources().getStringArray(resourceId);
        } else
            return null;
    }

    public static float getDimen(int resourceId) {
        if (context() != null) {
            return context().getResources().getDimension(resourceId);
        } else
            return -1;
    }

    public static int getDimenPixelSize(int resourceId) {
        if (context() != null) {
            return context().getResources().getDimensionPixelSize(resourceId);
        } else
            return -1;
    }

    public static Drawable getDrawable(int resourceId) {
        if (context() != null) {
            return context().getResources().getDrawable(resourceId, context().getTheme());
        } else
            return null;
    }
}
