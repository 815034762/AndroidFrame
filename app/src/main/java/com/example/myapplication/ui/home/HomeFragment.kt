package com.example.myapplication.ui.home;

import android.annotation.SuppressLint
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.JokeAdapter;
import com.example.myapplication.ui.home.db.JokeDb;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: JokeAdapter
    private lateinit var homeViewModel: HomeViewModel

    @SuppressLint("CheckResult")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = JokeAdapter()
        recyclerView.adapter = adapter
        homeViewModel.getJokeList()
        homeViewModel.getResult().observe(viewLifecycleOwner, Observer { jokeModel ->
            if (jokeModel == null || jokeModel.data == null) {
                JokeDb.instance.jokeDao?.getAllJoke()?.subscribeOn(Schedulers.io())
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.subscribe {
                            adapter.datas = it
                        }
            } else {
                if (jokeModel.data?.result?.data != null) {
                    Observable.create(ObservableOnSubscribe<String> {
                        JokeDb.instance?.jokeDao?.insert(jokeModel.data.result!!.data!!)
                    }).subscribeOn(Schedulers.newThread())
                    adapter.datas = jokeModel.data.result!!.data!!
                }
            }
        })
        return root
    }

}