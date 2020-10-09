package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.JokeAdapter;
import com.example.myapplication.demo.BaseData;
import com.example.myapplication.viewmodel.model.JokeModel;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private JokeAdapter adapter;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        adapter = new JokeAdapter();
        recyclerView.setAdapter(adapter);
        homeViewModel.getJokeList();
        homeViewModel.getResult().observe(getViewLifecycleOwner(), new Observer<BaseData<JokeModel>>() {
            @Override
            public void onChanged(BaseData<JokeModel> jokeModelBaseData) {
                if(!jokeModelBaseData.getData().getResult().getData().isEmpty()) {
                    adapter.setDatas(jokeModelBaseData.getData().getResult().getData());
                }
            }
        });

//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}