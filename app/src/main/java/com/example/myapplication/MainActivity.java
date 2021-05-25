package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.databind.DataBindingActivity;
import com.example.myapplication.databind.User;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.demo.DemoActivity;
import com.example.myapplication.utils.DateUtils;
import com.example.myapplication.viewmodel.ViewModelActivity;
import com.example.myapplication.viewmodel.vm.MainViewModel;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.observable.ObservableInterval;
import rx.functions.Action1;

/**
 * @author ly-zhangty
 * 主页面
 */
public class MainActivity extends RxAppCompatActivity {

    ActivityMainBinding activityMainBinding;
    final ArrayList<User> userList = new ArrayList<>();

    MainViewModel model = new MainViewModel(getApplication());

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.addLast("10");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add("6");
        linkedList.add("7");

//        linkedList.clear();
        linkedList.poll(); // 检索第一个元素并删除
        linkedList.peek();// 仅仅检索第一个原因,它和getFirest的区别是，如果第一个peek第一个元素是null，那么就返回，而getFirst则是抛出nullPointer异常
        Log.e("zty",linkedList.peek()  + "  " +linkedList.getFirst() + " <---> " + linkedList.getLast() + "   " + linkedList.get(0));


        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.put(1,"1");
        sparseArray.put(2,"2");
        Log.e("zty", "---sparseArray size----" + sparseArray.size());
        sparseArray.delete(1);
        // size操作会把
        Log.e("zty", "---sparseArray2 size----" + sparseArray.size());
//        sparseArray.clear();

        HashMap hashMap = new HashMap(1);
        String key = "a";
        hashMap.put(key, "测试2");
        hashMap.put(key, "测试3");
        hashMap.put(key, "测试4");
        hashMap.put(key, "测试5");
        hashMap.putIfAbsent(key, "测试1");
        int h = 0;
        int hash1 = (h = key.hashCode()) ^ (h >>> 16);
        int hash4 = (h = key.hashCode()) ^ (h >>> 16);
        int hash2 = (h = "a".hashCode()) ^ (h >>> 16);
        int hash3 = (h = "a".hashCode()) ^ (h >>> 16);
        Log.e("zty", hash1+ "    " + hash2 + "   " + hash3 + "    " + hash4 + "  " + hashMap.size() + " ---------------- " + hashMap.get(key));
//        HashSet hashSet;

//        startActivity();
//        DateUtils.getAA();
//        User user = new User();
//        for(int i = 0;i < 5; i++) {
////            user = new User();
//            user.setAge("18: " + i);
//            user.setName("ZhangTy: " + i);
//            user.setSchool("大学名称: " + i);
//            userList.add(user);
//        }
//        for (User user1 : userList) {
//            Log.e("tag", user1.getName() + "======userInfo is======" + user1.getAge() + "    " + user1.getSchool());
//        }
//
//        activityMainBinding.setMain(model);
//        model.content.set("设置字符串");
        startActivity();
    }

    private void startActivity() {
        activityMainBinding.btDataBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DataBindingActivity.class));
            }
        });

        activityMainBinding.btViewModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewModelActivity.class));
            }
        });

        activityMainBinding.btDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DemoActivity.class));
            }
        });
    }

}