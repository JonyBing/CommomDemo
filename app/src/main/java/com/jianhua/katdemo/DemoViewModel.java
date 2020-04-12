package com.jianhua.katdemo;

import androidx.lifecycle.MutableLiveData;

import com.jianhua.common.base.BaseViewModel;

public class DemoViewModel extends BaseViewModel {

    private MutableLiveData<String> times = new MutableLiveData<>();

    public DemoViewModel(){
        times.setValue("ad");
    }

    public MutableLiveData<String> getTimes(){
        return times;
    }



}
