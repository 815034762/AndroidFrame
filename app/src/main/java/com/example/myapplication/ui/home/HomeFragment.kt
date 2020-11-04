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
import androidx.lifecycle.ViewModelProvider
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
import java.util.zip.Inflater

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: JokeAdapter
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = JokeAdapter()
        recyclerView.adapter = adapter
        homeViewModel.getJokeList()
        homeViewModel.getResult().observe(viewLifecycleOwner, Observer {
            val temp = it
            if (temp == null || temp.data == null) {
                JokeDb.getInstance().getJokeDao().getAllJoke().subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            adapter.datas = it
                            adapter.notifyDataSetChanged()
                        }
            } else {
                if(temp.data?.result?.data != null){
                    Observable.create(ObservableOnSubscribe<String> {
                        JokeDb.getInstance().getJokeDao().insert(temp.data.result.data);
                    }).subscribeOn(Schedulers.newThread())

                    adapter.datas = temp.data.result.data
                    adapter.notifyDataSetChanged()
                }
            }
        })

        return root
    }

}