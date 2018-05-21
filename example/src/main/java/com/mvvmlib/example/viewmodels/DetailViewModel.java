package com.mvvmlib.example.viewmodels;

import com.mvvmlib.ViewModels.BaseViewModel;
import com.mvvmlib.example.App;

public class DetailViewModel extends BaseViewModel {

    public void back(){
        getNavigationService().back();
    }

    public void backToRoot(){
        getNavigationService().backTo(App.HomeView);
    }

}
