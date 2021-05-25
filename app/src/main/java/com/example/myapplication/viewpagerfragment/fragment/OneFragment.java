package com.example.myapplication.viewpagerfragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.viewpagerfragment.adapter.MyViewPagerAdapter;

/**
 * @author ly-zhangty
 */
public class OneFragment extends BaseFragment {


    public static OneFragment newInstance() {
        OneFragment oneFragment = new OneFragment();
        return oneFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test, container, false);
        root.findViewById(R.id.tv_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchToNextFragment();
            }
        });

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void switchToNextFragment() {
        if (null != getSwitchToNextFragmentListener()) {
            getSwitchToNextFragmentListener().onSwitchToNextFragment(OtherFragment.onNewInstance());
        }
    }
}