package com.mvvmlib.example;

import com.mvvmlib.example.activities.DetailActivity;
import com.mvvmlib.example.activities.HomeActivity;
import com.mvvmlib.example.activities.TestActivity;
import com.mvvmlib.models.BaseApplication;
import com.mvvmlib.services.interfaces.IViewLocatorService;
import com.mvvmlib.services.ServiceLocator;

public class App extends BaseApplication {

    public static final String HomeView = "HomeView";
    public static final String TestView = "TestView";
    public static final String DetailView = "DetailView";

    @Override
    public void onCreate() {
        super.onCreate();

        IViewLocatorService viewLocatorService = ServiceLocator.getInstance().getService(IViewLocatorService.class);
        viewLocatorService.registerView(HomeView, HomeActivity.class);
        viewLocatorService.registerView(TestView, TestActivity.class);
        viewLocatorService.registerView(DetailView, DetailActivity.class);
    }
}
