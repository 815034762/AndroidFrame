package com.example.myapplication.viewpagerfragment.fragment;

import androidx.fragment.app.Fragment;

import com.example.myapplication.viewpagerfragment.adapter.MyViewPagerAdapter;


/**
 * @author ly-zhangty
 */
public class BaseFragment extends Fragment {

    private MyViewPagerAdapter.SwitchToNextFragmentListener switchToNextFragmentListener;
    private MyViewPagerAdapter.BackToPrevFragmentListener prevFragmentListener;

    public MyViewPagerAdapter.SwitchToNextFragmentListener getSwitchToNextFragmentListener() {
        return switchToNextFragmentListener;
    }

    public void setSwitchToNextFragmentListener(MyViewPagerAdapter.SwitchToNextFragmentListener switchToNextFragmentListener) {
        this.switchToNextFragmentListener = switchToNextFragmentListener;
    }

    public MyViewPagerAdapter.BackToPrevFragmentListener getPrevFragmentListener() {
        return prevFragmentListener;
    }

    public void setPrevFragmentListener(MyViewPagerAdapter.BackToPrevFragmentListener prevFragmentListener) {
        this.prevFragmentListener = prevFragmentListener;
    }
}