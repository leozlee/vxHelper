package com.example.vxhelper;

import android.app.Application;

import com.tencent.mmkv.MMKV;

public class AppContext extends Application {

    private static Application context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        MMKV.initialize(this);

    }

    public static Application getAppContext() {
        return context;
    }
}
