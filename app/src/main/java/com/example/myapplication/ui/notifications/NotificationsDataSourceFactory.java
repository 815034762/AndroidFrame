package com.example.myapplication.ui.notifications;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

/**
 * 数据的工厂
 */
public class NotificationsDataSourceFactory extends DataSource.Factory<Integer, Notifications.ResultBean.DataBean> {

    @NonNull
    @Override
    public DataSource<Integer, Notifications.ResultBean.DataBean> create() {
        NotificationsDataSource notificationsDataSource = new NotificationsDataSource();
        return notificationsDataSource;
    }
}
