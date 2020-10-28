package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.databind.DataBindingActivity;
import com.example.myapplication.databind.User;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.demo.DemoActivity;
import com.example.myapplication.utils.DateUtils;
import com.example.myapplication.viewmodel.ViewModelActivity;

import java.util.ArrayList;

/**
 * @author ly-zhangty
 * 主页面
 */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    final ArrayList<User> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        startActivity();
        DateUtils.getAA();
        User user = new User();
        for(int i = 0;i < 5; i++) {
//            user = new User();
            user.setAge("18: " + i);
            user.setName("ZhangTy: " + i);
            user.setSchool("大学名称: " + i);
            userList.add(user);
        }
        for (User user1 : userList) {
            Log.e("tag", user1.getName() + "======userInfo is======" + user1.getAge() + "    " + user1.getSchool());
        }
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