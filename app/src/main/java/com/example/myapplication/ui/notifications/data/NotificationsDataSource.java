package com.example.myapplication.ui.notifications.data;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.example.myapplication.demo.NetUtil;
import com.example.myapplication.repository.RemoteRepository;
import com.example.myapplication.ui.notifications.data.model.Notifications;
import com.google.gson.Gson;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 数据的来源（room，网络，...）
 * <p>
 * 同学们：这里是数据源，获取数据目前是在这里完成的
 * <p>
 * 官方文档上，继承的是ItemKeyedDataSource, 而这里实现的是PositionalDataSource
 * <p>
 * PositionalDataSource<Notifications>: 适用于目标数据总数的固定，通过特别的位置加载数据(0-10)
 * 比如从数据库中的1200条开始加在20条数据。
 */

/**
 * 数据源 第三种
 */
public class NotificationsDataSource extends PositionalDataSource<Notifications.DataBean.InfoBean> {

    private NetUtil mNetUtil = new NetUtil();
    private RemoteRepository remoteRepository;

    public NotificationsDataSource() {
        remoteRepository = new RemoteRepository();
        mNetUtil = new NetUtil();
    }

    /**
     * 同学们可以理解是加载第一页数据的时候，会执行此函数来完成
     * 加载初始化数据，可以这么来理解，加载的是第一页的数据。
     * 形象的说，当我们第一次打开页面，需要回调此方法来获取数据。
     *
     * @param params
     * @param callback
     */
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, final @NonNull LoadInitialCallback<Notifications.DataBean.InfoBean> callback) {
        // @1 数据源     @2 位置     @3 总大小
        mNetUtil.getKgHttpService().getMusic(9108,"em","你好",30)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Notifications>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Notifications results) {
                        Log.e("result", new Gson().toJson(results));
                        if (results != null && results.getData() != null) {
                            callback.onResult(results.getData().getInfo(), 0, results.getData().getInfo().size());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("result", e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

//        remoteRepository.getNotificationList()
    }

    /**
     * 当有了初始化数据之后，滑动的时候如果需要加载数据的话，会调用此方法。
     *
     * @param params
     * @param callback
     */
    @Override
    public void loadRange(@NonNull LoadRangeParams params, final @NonNull LoadRangeCallback<Notifications.DataBean.InfoBean> callback) {
        // @1 从哪里开始加载(位置 内部算的)     @2 size(size 内部算的)
//        callback.onResult();
        mNetUtil.getHttpService().getNotificationList(NetUtil.KEY, "asc", 1418816972, params.loadSize, params.startPosition)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Notifications>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Notifications results) {
                        Log.e("result", new Gson().toJson(results));
                        if (results != null && results.getData() != null) {
                            callback.onResult(results.getData().getInfo());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
//        getNotifications(params.startPosition, params.loadSize, callback);
    }

    /**
     * 同学们，可以理解这里是数据源，数据的来源（数据库，文件，网络服务器响应  等等）
     *
     * @param startPosition
     * @param pageSize
     * @return
     */
//    private void getNotifications(int startPosition, int pageSize,LoadInitialCallback<Notifications.ResultBean.DataBean> callback) {
//        List<Notifications.ResultBean.DataBean> beanList = new ArrayList<>();
//        MutableLiveData<BaseData<Notifications>> mResult = remoteRepository.getNotificationList(startPosition, pageSize,callback);
//
//        if (mResult.getValue() != null) {
//            Notifications result = mResult.getValue().getData();
//            if (result != null && result.getResult() != null) {
//                beanList.addAll(result.getResult().getData());
////                return beanList;
//            }
//        }
////        return beanList;
////        List<Notifications> list = new ArrayList<>();
////        for (int i = startPosition; i < startPosition + pageSize; i++) {
////            Notifications notifications = new Notifications();
////            notifications.setId("ID号是:" + i);
////            notifications.setName("我名称:" + i);
////            notifications.setSex("我性别:" + i);
////            list.add(notifications);
////        }
////        return list;
//    }
}
