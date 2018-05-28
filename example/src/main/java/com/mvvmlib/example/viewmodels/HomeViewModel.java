package com.mvvmlib.example.viewmodels;

import com.mvvmlib.viewModels.BaseViewModel;
import com.mvvmlib.example.App;

public class HomeViewModel extends BaseViewModel {


    public void navigateToTest(){
        getNavigationService().navigateTo(App.TestView);
    }
}
