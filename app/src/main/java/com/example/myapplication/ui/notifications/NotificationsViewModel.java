package com.example.myapplication.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.myapplication.ui.notifications.data.NotificationsDataSourceFactory;
import com.example.myapplication.ui.notifications.data.model.Notifications;

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
    private final LiveData<PagedList<Notifications.DataBean.InfoBean>> listLiveData;

    public NotificationsViewModel() {
        NotificationsDataSourceFactory factory = new NotificationsDataSourceFactory();

        // 初始化 ViewModel
        this.listLiveData = new LivePagedListBuilder<Integer, Notifications.DataBean.InfoBean>(factory, new PagedList.Config.Builder()
                .setPageSize(20)
                .setEnablePlaceholders(false) // 配置是否启动PlaceHolders
                .setPrefetchDistance(5)   //初始化加载的数量
                .build()).build();
    }

    // TODO 暴露数据出去
    public LiveData<PagedList<Notifications.DataBean.InfoBean>> getListLiveData() {
        return listLiveData;
    }
}
