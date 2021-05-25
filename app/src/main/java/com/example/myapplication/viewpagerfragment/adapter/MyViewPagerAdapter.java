package com.example.myapplication.viewpagerfragment.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.viewpagerfragment.fragment.BaseFragment;
import com.example.myapplication.viewpagerfragment.fragment.OneFragment;

import java.util.List;

/**
 * @author ly-zhangty
 */
public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    private BaseFragment tab1Fragment, tab2Fragment, tab3Fragment;
    private FragmentManager fragmentManager;
    //定义显示在界面上的标题文字
    private String[] titles;
    private List<BaseFragment> fragmentList;
    private boolean isTab1Switched = false, isTab2Switched = false, isTab3Switched = false;

    public MyViewPagerAdapter(@NonNull FragmentManager fm, String[] titles, List<BaseFragment> fragmentList) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fragmentManager = fm;
        this.titles = titles;
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(final int position) {
        switch (position) {
            case 0: {
                //第一个页卡车辆状况
                if (tab1Fragment == null) {
                    OneFragment carCenterMainReplaceableFragment = (OneFragment) fragmentList.get(position);
                    carCenterMainReplaceableFragment.setSwitchToNextFragmentListener(new SwitchToNextFragmentListener() {
                        @Override
                        public void onSwitchToNextFragment(BaseFragment nextFragment) {

                            nextFragment.setPrevFragmentListener(new BackToPrevFragmentListener() {
                                @Override
                                public void onBackToPrevFragment(BaseFragment prevFragment) {
                                    performTab1Switch(position, prevFragment);
                                }
                            });
                            nextFragment.setSwitchToNextFragmentListener(new SwitchToNextFragmentListener() {
                                @Override
                                public void onSwitchToNextFragment(BaseFragment prevFragment) {
                                    performTab1Switch(position, prevFragment);
                                }
                            });
//                        nextFragment.setSwitchToNextFragmentListener(nextFragment1 -> {
//                            nextFragment1.setPrevFragment(tab2Fragment);
//                            nextFragment1.setSwitchToNextFragmentListener(nextFragment2 -> {
//                                nextFragment2.setPrevFragment(tab2Fragment);
//                                nextFragment2.setBackToPrevFragmentListener(prevFragment -> {
//                                    performTab2Switch(position, prevFragment);
//                                });
//                                performTab2Switch(position, nextFragment2);
//                            });
//                            nextFragment1.setBackToPrevFragmentListener(prevFragment -> {
//                                performTab2Switch(position, prevFragment);
//                            });
//                            performTab2Switch(position, nextFragment1);
//                        });
                            performTab1Switch(position, nextFragment);
                        }
                    });
                    carCenterMainReplaceableFragment.setPrevFragmentListener(new BackToPrevFragmentListener() {
                        @Override
                        public void onBackToPrevFragment(BaseFragment prevFragment) {
                            performTab1Switch(position, prevFragment);
                            Log.e("zty", "--------onBackToPrevFragment-------");
                        }
                    });
                    tab1Fragment = carCenterMainReplaceableFragment;
                }
                return tab1Fragment;
            }
            case 1:
                //第二个页卡行车信息
                if (tab2Fragment == null) {
                    BaseFragment carCenterMainReplaceableFragment = fragmentList.get(position);
                    carCenterMainReplaceableFragment.setSwitchToNextFragmentListener(new SwitchToNextFragmentListener() {
                        @Override
                        public void onSwitchToNextFragment(BaseFragment nextFragment) {
                            Log.e("zty", "==========onSwitchToNextFragment=========");
                        }
                    });

                    carCenterMainReplaceableFragment.setPrevFragmentListener(new BackToPrevFragmentListener() {
                        @Override
                        public void onBackToPrevFragment(BaseFragment prevFragment) {
                            Log.e("zty", "==========onBackToPrevFragment=========");
                        }
                    });
//                    carCenterMainReplaceableFragment.setSwitchToNextFragmentListener(nextFragment -> {
//                        nextFragment.setPrevFragment(tab2Fragment);
//                        nextFragment.setSwitchToNextFragmentListener(nextFragment1 -> {
//                            nextFragment1.setPrevFragment(tab2Fragment);
//                            nextFragment1.setSwitchToNextFragmentListener(nextFragment2 -> {
//                                nextFragment2.setPrevFragment(tab2Fragment);
//                                nextFragment2.setBackToPrevFragmentListener(prevFragment -> {
//                                    performTab2Switch(position, prevFragment);
//                                });
//                                performTab2Switch(position, nextFragment2);
//                            });
//                            nextFragment1.setBackToPrevFragmentListener(prevFragment -> {
//                                performTab2Switch(position, prevFragment);
//                            });
//                            performTab2Switch(position, nextFragment1);
//                        });
//                    });
                    isTab1Switched = true;
                    tab2Fragment = carCenterMainReplaceableFragment;
                }
                return tab2Fragment;
            case 2: //第三个页卡流量套餐
                if (tab3Fragment == null) {
                    BaseFragment carCenterMainReplaceableFragment = fragmentList.get(position);
//                    carCenterMainReplaceableFragment.setSwitchToNextFragmentListener(nextFragment -> {
//                        nextFragment.setPrevFragment(tab3Fragment);
//                        nextFragment.setSwitchToNextFragmentListener(nextFragment1 -> {
//                            nextFragment1.setPrevFragment(tab3Fragment);
//                            nextFragment1.setSwitchToNextFragmentListener(nextFragment2 -> {
//                                nextFragment2.setPrevFragment(tab3Fragment);
//                                nextFragment2.setBackToPrevFragmentListener(prevFragment -> {
//                                    performTab3Switch(position, prevFragment);
//                                });
//                                performTab3Switch(position, nextFragment2);
//                            });
//                            nextFragment1.setBackToPrevFragmentListener(prevFragment -> {
//                                performTab3Switch(position, prevFragment);
//                            });
//                            performTab3Switch(position, nextFragment1);
//                        });
//
//                        nextFragment.setBackToPrevFragmentListener(prevFragment -> {
//                            performTab3Switch(position, prevFragment);
//                        });
//                        performTab3Switch(position, nextFragment);
//                    });
                    tab3Fragment = carCenterMainReplaceableFragment;
                }
                return tab3Fragment;
        }
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (isTab1Switched || isTab2Switched || isTab3Switched) {
            return POSITION_NONE;
        }

        return POSITION_UNCHANGED;
    }


    private void performTab2Switch(int position, BaseFragment toSwitchFragment) {
        Log.e("zty", fragmentList.size() + "========performTab2Switch position======" + position);
        fragmentManager.beginTransaction().remove(tab2Fragment).commit();
        fragmentList.set(position, toSwitchFragment);
        tab2Fragment = toSwitchFragment;
        Log.e("zty", fragmentList.size() + "========performTab2Switch afterRemove======");
        setTabSwitchedVariables(position);
        notifyDataSetChanged();
    }

    private void performTab1Switch(int position, BaseFragment toSwitchFragment) {

        Log.e("zty", fragmentList.size() + "========position======" + position);
        fragmentManager.beginTransaction().remove(tab1Fragment).commitNow();
        Log.e("zty", fragmentList.size() + "========afterRemove======");
        fragmentList.set(position, toSwitchFragment);
        setTabSwitchedVariables(position);
        tab1Fragment = toSwitchFragment;
        notifyDataSetChanged();
    }

    private void setTabSwitchedVariables(int tabIndex) {
        switch (tabIndex) {
            case 0:
                isTab1Switched = true;
                isTab2Switched = false;
                isTab3Switched = false;
                break;
            case 1:
                isTab1Switched = false;
                isTab2Switched = true;
                isTab3Switched = false;
                break;
            case 2:
                isTab1Switched = false;
                isTab2Switched = false;
                isTab3Switched = true;
                break;
            default:
                break;
        }
    }

    public interface SwitchToNextFragmentListener {
        void onSwitchToNextFragment(BaseFragment nextFragment);
    }

    public interface BackToPrevFragmentListener {
        void onBackToPrevFragment(BaseFragment prevFragment);
    }
}
