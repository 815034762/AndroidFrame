package com.example.myapplication;

import android.app.Application;

public class JetPackApplication extends Application {

    public static JetPackApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static JetPackApplication getmInstance() {
        return mInstance;
    }

}
