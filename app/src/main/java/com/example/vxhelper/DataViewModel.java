package com.example.vxhelper;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DataViewModel extends ViewModel {
    private MutableLiveData<List<String>> useList = new MutableLiveData();

    public MutableLiveData<List<String>> getData() {
        return useList;
    }

}
