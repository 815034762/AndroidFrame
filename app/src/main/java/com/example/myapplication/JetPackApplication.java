package com.example.myapplication;

import android.app.Application;
import android.content.Context;

import androidx.core.app.ActivityCompat;

public class JetPackApplication extends Application {

    public static JetPackApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        // 异常测试
//        JetPackApplication.test(null);
    }

    public static JetPackApplication getmInstance() {
        return mInstance;
    }

    public static int test(Context context) {
        if(context == null) {
            // throw 会导致程序异常
            throw new NullPointerException("the context is null");
        }
         // 直接导致程序崩溃
        throw new IllegalArgumentException("不合法的参数");
    }

}
