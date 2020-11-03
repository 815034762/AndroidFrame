package com.example.myapplication.ui.notifications.data;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.example.myapplication.ui.notifications.data.model.Notifications;

/**
 * 数据的工厂
 */
public class NotificationsDataSourceFactory extends DataSource.Factory<Integer, Notifications.DataBean.InfoBean> {

    @NonNull
    @Override
    public DataSource<Integer, Notifications.DataBean.InfoBean> create() {
        NotificationsDataSource notificationsDataSource = new NotificationsDataSource();
        return notificationsDataSource;
    }
}
