package com.example.myapplication.ui.home.datasource;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.example.myapplication.demo.NetUtil;
import com.example.myapplication.viewmodel.model.JokeModel;

/**
 * @author ly-zhangty
 * 分页用到的dataSource
 */
public class JokeDataSource extends PositionalDataSource<JokeModel.ResultBean.DataBean> {

    private NetUtil mNetUtil;

    public JokeDataSource() {
        this.mNetUtil = new NetUtil();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<JokeModel.ResultBean.DataBean> callback) {

        this.mNetUtil.getJoke("asc", 1, 20, 1418816972);
//        callback.onResult();
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<JokeModel.ResultBean.DataBean> callback) {

    }
}
