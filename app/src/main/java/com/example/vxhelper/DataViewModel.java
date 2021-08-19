package com.example.vxhelper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DataViewModel extends ViewModel {
    private MutableLiveData<List<String>> useList;

    public LiveData<List<String>> getData() {
        if (useList == null) {
            useList = new MutableLiveData<>();
            loadData();
        }
        return useList;
    }


    public void updateNewData(String value) {
        useList.getValue().add(value);
        useList.postValue(useList.getValue());
    }

    private void loadData() {
        List<String> temp = new ArrayList<>();
        temp.add("li11");
        temp.add("2222");
        temp.add("222");
        useList.setValue(temp);
    }
}
