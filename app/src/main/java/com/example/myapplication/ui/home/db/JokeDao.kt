package com.example.myapplication.ui.home.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.myapplication.viewmodel.model.JokeModel;
import io.reactivex.Observable;

@Dao
interface JokeDao {
    @Query("SELECT * FROM JokeModel ORDER BY unixtime ASC")
    fun getAllJoke(): Observable<List<JokeModel.ResultBean.DataBean>>

    @Insert
    fun insert(dataBeans: List<JokeModel.ResultBean.DataBean>)

    @Insert
    fun insert(dataBean: JokeModel.ResultBean.DataBean)
}
