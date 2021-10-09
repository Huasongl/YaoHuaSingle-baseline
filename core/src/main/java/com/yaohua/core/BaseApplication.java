package com.yaohua.core;

import android.app.Application;

public class BaseApplication extends Application {

    protected static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static BaseApplication getInstance(){
        return instance;
    }
}
