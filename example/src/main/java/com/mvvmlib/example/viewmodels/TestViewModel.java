package com.mvvmlib.example.viewmodels;

import com.mvvmlib.viewModels.BaseViewModel;
import com.mvvmlib.example.App;

public class TestViewModel extends BaseViewModel {


    public void back(){
        getNavigationService().back();
    }

    public void navigateToDetail(){
        getNavigationService().navigateTo(App.DetailView);
    }
}
