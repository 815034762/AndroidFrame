package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;

import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class WebActivity extends AppCompatActivity {

    private FlutterEngine flutterEngine;
    private FlutterView flutterView;
    private final static String PATH
            = Environment.getExternalStorageDirectory() + "/";

    /**
     * 从flutter这边传递数据到Android
     */
    public static final String FLUTTER_TO_ANDROID_CHANNEL = "flutter.to.android/battery";
    /**
     * 从Android这边传递数据到flutter
     */
    public static final String ANDROID_TO_FLUTTER_CHANNEL = "android.to.flutter/plugin";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_web);

        flutterEngine = new FlutterEngine(this);
//        跳转到指定页面 否则跳转到首页
//        flutterEngine.getNavigationChannel().setInitialRoute("/second");
        flutterEngine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());

        FlutterEngineCache.getInstance().put("my_engine_id", flutterEngine);
        GeneratedPluginRegistrant.registerWith(flutterEngine);

        flutterView = new FlutterView(WebActivity.this);
        FrameLayout.LayoutParams layout = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        layout.leftMargin = 0;
        layout.topMargin = 0;

        flutterView.attachToFlutterEngine(flutterEngine);
        addContentView(flutterView, layout);
//        FlutterFromAndroid();
//        androidFromFlutter();
    }

    private BroadcastReceiver createChargingStateChangeReceiver(final EventChannel.EventSink events) {
        return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

                if (status == BatteryManager.BATTERY_STATUS_UNKNOWN) {
                    events.error("UNAVAILABLE", "Charging status unavailable", null);
                } else {
                    boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                            status == BatteryManager.BATTERY_STATUS_FULL;
                    events.success(isCharging ? "charging" : "discharging");
                }
            }
        };
    }

    private void FlutterFromAndroid(){
        new EventChannel(flutterEngine.getDartExecutor(), ANDROID_TO_FLUTTER_CHANNEL).setStreamHandler(
                new EventChannel.StreamHandler(){
                    private BroadcastReceiver chargingStateChangeReceiver;
                    @Override
                    public void onListen(Object arguments, EventChannel.EventSink events) {
                        chargingStateChangeReceiver = createChargingStateChangeReceiver(events);
                        registerReceiver(
                                chargingStateChangeReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
//                        events.success("你好，我来自原生的Android");
                    }

                    @Override
                    public void onCancel(Object arguments) {
                        unregisterReceiver(chargingStateChangeReceiver);
                        chargingStateChangeReceiver = null;
                    }
                }
        );
    }

    public void dianji(View view){
        flutterView = new FlutterView(WebActivity.this);
        FrameLayout.LayoutParams layout = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        layout.leftMargin = 0;
        layout.topMargin = 0;
        flutterView.attachToFlutterEngine(flutterEngine);
        addContentView(flutterView, layout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        flutterEngine.getLifecycleChannel().appIsResumed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        flutterEngine.getLifecycleChannel().appIsInactive();
    }

    @Override
    protected void onStop() {
        super.onStop();
        flutterEngine.getLifecycleChannel().appIsPaused();
    }

    //    private void androidFromFlutter(){
//        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), FLUTTER_TO_ANDROID_CHANNEL)
//                .setMethodCallHandler((call, result) -> {
//                    if(call.method.equals("flutterToAndroid")){
//                        Object text = call.argument("flutter");
//                        if (text instanceof String){
//                            //带参数跳转到指定Activity
//                            Intent intent = new Intent(WebActivity.this, FlutterAndroid.class);
//                            intent.putExtra("params", (String) text);
//                            startActivity(intent);
//                        }
////                        result.success(100);
//                    }
//                    if(call.method.equals("getBatteryLevel")){
//                        int batteryLevel = 555;//getBatteryLevel();
//                        result.success(batteryLevel);
//                    }
//                    if(call.method.equals("getDrawable")){
////                        byte[] bytes = getDrawable();
////                        result.success(bytes);
//                    }
//                });
//    }
    //    WebView webView;
//    public final static String CSS_STYLE ="<style>p {color:green !important;}</style>";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_web);
//        webView = findViewById(R.id.webView);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        StringBuilder sb = new StringBuilder();
//        // 拼接一段HTML代码
//        sb.append("");
//        sb.append("");
//        sb.append("");
//        sb.append("<html>\n" +
//                "  <head>标题</head>\n" +
//                "  <title>内容</title>\n" +
//                "  <body style=\"background:red;\">\n" +
//                "      <p style=\"font-family: 微软雅黑,\"Microsoft YhHei\";font-size:47px;color:rgb(255,255,255);\">\n" +
//                "\t    这是白色第一个段落\n" +
//                "\t\t这是第一个段落\n" +
//                "\t\t这是第一个段落\n" +
//                "\t  </p>\n" +
//                "\t    <p style=\"font-family: 微软雅黑,Microsoft YhHei;font-size:47px;color:rgb(255,255,255);\">\n" +
//                "\t    这是黑色第一个段落\n" +
//                "\t  </p>\n" +
//                "  </body>\n" +
//                "</html>");
//        sb.append("");
//        sb.append("");
//        // 使用简单的loadData方法会导致乱码
//        webView.loadData(sb.toString(), "text/html", "utf-8");
//        // 加载并显示HTML代码
//        webView.loadDataWithBaseURL(null, sb.toString()+CSS_STYLE, "text/html", "utf-8", null);
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
}