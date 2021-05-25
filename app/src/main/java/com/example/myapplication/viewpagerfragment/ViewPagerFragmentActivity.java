package com.example.myapplication.viewpagerfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.viewpagerfragment.adapter.MyViewPagerAdapter;
import com.example.myapplication.viewpagerfragment.fragment.BaseFragment;
import com.example.myapplication.viewpagerfragment.fragment.OneFragment;
import com.example.myapplication.viewpagerfragment.fragment.ThreeFragment;
import com.example.myapplication.viewpagerfragment.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ly-zhangty
 */
public class ViewPagerFragmentActivity extends AppCompatActivity {

    private ViewPager viewPager;
    MyViewPagerAdapter adapter;
    String[] title = {"测试一", "测试二", "测试三"};
    List<BaseFragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_fragment);
        viewPager = findViewById(R.id.viewPager);

        fragmentList.add(new OneFragment());
        fragmentList.add(new TwoFragment());
        fragmentList.add(new ThreeFragment());

        adapter = new MyViewPagerAdapter(getSupportFragmentManager(), title, fragmentList);
        viewPager.setAdapter(adapter);
    }
}