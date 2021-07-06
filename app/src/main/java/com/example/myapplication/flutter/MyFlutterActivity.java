package com.example.myapplication.flutter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import io.flutter.embedding.android.FlutterActivity;

/**
 * @author ly-zhangty
 */
public class MyFlutterActivity extends FlutterActivity {

    public static void start(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, MyFlutterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFlutterEngine().getNavigationChannel().pushRoute("dksaf");
    }

    @Override
    public String getInitialRoute() {
        return "router1";
    }
}
