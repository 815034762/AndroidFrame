package com.example.myapplication.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.demo.BaseData;
import com.example.myapplication.demo.NetUtil;
import com.example.myapplication.viewmodel.model.Book;
import com.example.myapplication.viewmodel.model.JokeModel;
import com.google.gson.Gson;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author ly-zhangty
 * description: 用于获取远程数据的代理
 */
public class RemoteRepository {

    private NetUtil netUtil = new NetUtil();
    private MutableLiveData<BaseData<JokeModel>> jokeResult = new MutableLiveData<>();
    private MutableLiveData<BaseData<Book>> bookResult = new MutableLiveData<>();

    /**
     * 获取笑话全集
     *
     * @return
     */
    public MutableLiveData<BaseData<JokeModel>> getJokeList() {
        //                .enqueue(new Callback<ImageBean>() {
//            @Override
//            public void onResponse(Call<ImageBean> call, Response<ImageBean> response) {
//                if (response.body() != null) {
//                    Log.d(TAG, "onResponse: " + idx);
//                    imageBean1.setValue(new BaseData<>(response.body(), null));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ImageBean> call, Throwable t) {
//                Log.d(TAG, "onFailure: " + t.toString());
//            }
//        });
        netUtil.getJoke("asc", 1, 20, 1418816972)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokeModel results) {
                        Log.e("result", new Gson().toJson(results));
                        jokeResult.setValue(new BaseData<JokeModel>(results, null));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return jokeResult;
    }

    /**
     * 获取图书电商数据
     *
     * @return
     */
    public MutableLiveData<BaseData<Book>> getBookList() {
        netUtil.getBook()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Book results) {
                        Log.e("result", new Gson().toJson(results));
                        bookResult.setValue(new BaseData<Book>(results, null));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return bookResult;
    }

}
