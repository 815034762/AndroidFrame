package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.JokeAdapter;
import com.example.myapplication.demo.BaseData;
import com.example.myapplication.ui.home.db.JokeDb;
import com.example.myapplication.viewmodel.model.JokeModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new JokeAdapter();
        recyclerView.setAdapter(adapter);
        homeViewModel.getJokeList();
        homeViewModel.getResult().observe(getViewLifecycleOwner(), new Observer<BaseData<JokeModel>>() {
            @Override
            public void onChanged(final BaseData<JokeModel> jokeModelBaseData) {
                if (jokeModelBaseData == null || jokeModelBaseData.getData() == null) {// 无网络获取缓存
                    JokeDb.getInstance().getJokeDao().getAllJoke().subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<JokeModel.ResultBean.DataBean>>() {
                        @Override
                        public void accept(List<JokeModel.ResultBean.DataBean> dataBeans) {
                            adapter.setDatas(dataBeans);
                        }
                    });
                } else {
                    if (!jokeModelBaseData.getData().getResult().getData().isEmpty()) {
                        Observable.create(new ObservableOnSubscribe<String>() {
                            @Override
                            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                                JokeDb.getInstance().getJokeDao().insert(jokeModelBaseData.getData().getResult().getData());
                            }
                        }).subscribeOn(Schedulers.newThread())
                                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
                            @Override
                            public void accept(String s) throws Exception {

                            }
                        });
                        adapter.setDatas(jokeModelBaseData.getData().getResult().getData());
                    }
                }
            }
        });
        return root;
    }
}