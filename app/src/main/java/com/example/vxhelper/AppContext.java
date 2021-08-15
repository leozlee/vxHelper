package com.example.vxhelper;

import android.app.Application;

public class AppContext extends Application {

    private static Application context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Application getAppContext() {
        return context;
    }
}
