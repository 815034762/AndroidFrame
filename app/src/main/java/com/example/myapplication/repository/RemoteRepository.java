package com.example.myapplication.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.PositionalDataSource;

import com.example.myapplication.demo.BaseData;
import com.example.myapplication.demo.NetUtil;
import com.example.myapplication.ui.notifications.Notifications;
import com.example.myapplication.viewmodel.model.Book;
import com.example.myapplication.viewmodel.model.BookDetail;
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
    private MutableLiveData<BaseData<Notifications>> notificationResult = new MutableLiveData<>();
    private MutableLiveData<BaseData<Book>> bookResult = new MutableLiveData<>();
    private MutableLiveData<BaseData<BookDetail>> bookDetailResult = new MutableLiveData<>();

    public RemoteRepository() {
    }

    public static RemoteRepository getInstance() {
        RemoteRepository repository = new RemoteRepository();
        return repository;
    }

    /**
     * 获取笑话全集
     *
     * @return
     */
    public MutableLiveData<BaseData<Notifications>> getNotificationList(int page, int pageSize, final PositionalDataSource.LoadRangeCallback<Notifications.ResultBean.DataBean> callback) {

        netUtil.getHttpService().getNotificationList(NetUtil.KEY,"asc", 1418816972,pageSize, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Notifications>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Notifications results) {
                        Log.e("result", new Gson().toJson(results));
                        if(results != null && results.getResult() != null) {
                            callback.onResult(results.getResult().getData());
                        }
                        notificationResult.setValue(new BaseData<Notifications>(results, null));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return notificationResult;
    }

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
        netUtil.getHttpService().getJokeList(NetUtil.KEY,"asc", 1418816972,50, 1)
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
        netUtil.getApiHttpService().getBookList(NetUtil.BOOK_KEY)
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

    /**
     * 获取图书电商数据详情
     *
     * @return
     */
    public MutableLiveData<BaseData<BookDetail>> getBookDetail(String catalogId) {
        netUtil.getApiHttpService().getBookDetail(NetUtil.BOOK_KEY,catalogId,1,30)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookDetail>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BookDetail results) {
                        Log.e("result", new Gson().toJson(results));
                        bookDetailResult.setValue(new BaseData<BookDetail>(results, null));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return bookDetailResult;
    }
}
