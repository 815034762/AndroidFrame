package com.example.myapplication.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.PositionalDataSource;

import com.example.myapplication.demo.BaseData;
import com.example.myapplication.demo.NetUtil;
import com.example.myapplication.ui.notifications.data.model.Notifications;
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
    // TODO 需要把这些去掉
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
    public MutableLiveData<BaseData<Notifications>> getNotificationList(int page, int pageSize, final PositionalDataSource.LoadRangeCallback<Notifications.DataBean.InfoBean> callback) {

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
                        if(results != null && results.getData() != null) {
                            callback.onResult(results.getData().getInfo());
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
    public void getJokeList(final MutableLiveData<BaseData<JokeModel>> jokeResult) {

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
                        jokeResult.setValue(new BaseData<JokeModel>(null,null));
                        Log.e("error", e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
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
