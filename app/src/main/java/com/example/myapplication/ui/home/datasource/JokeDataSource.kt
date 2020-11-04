package com.example.myapplication.ui.home.datasource;

import androidx.paging.PositionalDataSource
import com.example.myapplication.demo.NetUtil
import com.example.myapplication.viewmodel.model.JokeModel

/**
 * @author ly-zhangty
 * 分页用到的dataSource
 */
class JokeDataSource : PositionalDataSource<JokeModel.ResultBean.DataBean>() {

    private var mNetUtil:NetUtil = NetUtil()

    /**
     * Load initial list data.
     *
     *
     * This method is called to load the initial page(s) from the DataSource.
     *
     *
     * Result list must be a multiple of pageSize to enable efficient tiling.
     *
     * @param params Parameters for initial load, including requested start position, load size, and
     * page size.
     * @param callback Callback that receives initial load data, including
     * position and total data set size.
     */
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<JokeModel.ResultBean.DataBean>) {
        this.mNetUtil.getJoke("asc", 1, 20, 1418816972);
    }

    /**
     * Called to load a range of data from the DataSource.
     *
     *
     * This method is called to load additional pages from the DataSource after the
     * LoadInitialCallback passed to dispatchLoadInitial has initialized a PagedList.
     *
     *
     * Unlike [.loadInitial], this method must return
     * the number of items requested, at the position requested.
     *
     * @param params Parameters for load, including start position and load size.
     * @param callback Callback that receives loaded data.
     */
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<JokeModel.ResultBean.DataBean>) {
        TODO("Not yet implemented")
    }

}
