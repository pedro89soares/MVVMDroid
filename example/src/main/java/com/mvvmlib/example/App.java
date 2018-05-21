package com.mvvmlib.example;

import com.mvvmlib.Models.BaseApplication;
import com.mvvmlib.Services.Interfaces.IViewLocatorService;
import com.mvvmlib.Services.ServiceLocator;
import com.mvvmlib.example.activities.DetailActivity;
import com.mvvmlib.example.activities.HomeActivity;
import com.mvvmlib.example.activities.TestActivity;

public class App extends BaseApplication {

    public static final String HomeView = "HomeView";
    public static final String TestView = "TestView";
    public static final String DetailView = "DetailView";

    @Override
    public void onCreate() {
        super.onCreate();
        IViewLocatorService viewLocator = ServiceLocator.getInstance().getService(IViewLocatorService.class);
        viewLocator.registerView(HomeView, HomeActivity.class);
        viewLocator.registerView(TestView, TestActivity.class);
        viewLocator.registerView(DetailView, DetailActivity.class);
    }
}
