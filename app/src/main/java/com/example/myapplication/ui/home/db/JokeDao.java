package com.example.myapplication.ui.home.db;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.viewmodel.model.JokeModel;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface JokeDao {
    @Query("SELECT * FROM JokeModel ORDER BY unixtime ASC")
    Observable<List<JokeModel.ResultBean.DataBean>> getAllJoke();

    @Insert
    void insert(List<JokeModel.ResultBean.DataBean> dataBeans);

    @Insert
    void insert(JokeModel.ResultBean.DataBean dataBean);
}
