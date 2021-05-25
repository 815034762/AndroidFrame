package com.example.myapplication.viewpagerfragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

/**
 * @author ly-zhangty
 */
public class OtherFragment extends BaseFragment {

    /**
     * @return
     */
    public static OtherFragment onNewInstance() {
        OtherFragment otherFragment = new OtherFragment();
        return otherFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_other, container, false);
        root.findViewById(R.id.tv_previous).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchToPreFragment();
            }
        });

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

    private void switchToPreFragment() {
        if (null != getPrevFragmentListener()) {
            getPrevFragmentListener().onBackToPrevFragment(OneFragment.newInstance());
        }
    }
}
