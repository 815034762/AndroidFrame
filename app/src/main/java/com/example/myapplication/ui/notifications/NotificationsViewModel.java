package com.example.myapplication.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

/**
 * Time: 2020/4/2
 * Author: Liudeli
 * Description:
 *
 * PagedList: 数据源获取的数据最终靠PagedList来承载。
 * 对于PagedList,我们可以这样来理解，它就是一页数据的集合。
 * 每请求一页，就是新的一个PagedList对象。
 */
public class NotificationsViewModel extends ViewModel {

    // 看源码：@1 listLiveData 数据怎么来的
    private final LiveData<PagedList<Notifications.ResultBean.DataBean>> listLiveData;

    public NotificationsViewModel() {
        NotificationsDataSourceFactory factory = new NotificationsDataSourceFactory();

        // 初始化 ViewModel
        this.listLiveData = new LivePagedListBuilder<Integer, Notifications.ResultBean.DataBean>(factory, 20).build();
    }

    // TODO 暴露数据出去
    public LiveData<PagedList<Notifications.ResultBean.DataBean>> getListLiveData() {
        return listLiveData;
    }
}
