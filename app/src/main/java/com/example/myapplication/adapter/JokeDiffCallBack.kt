package com.example.myapplication.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.viewmodel.model.JokeModel

/**
 * @author zhangty
 */
class JokeDiffCallBack() : DiffUtil.Callback() {

    private lateinit var mNewData: List<JokeModel.ResultBean.DataBean>
    private lateinit var mOldData: List<JokeModel.ResultBean.DataBean>

    constructor(newData: List<JokeModel.ResultBean.DataBean>, oldData: List<JokeModel.ResultBean.DataBean>) : this() {
        this.mNewData = newData
        this.mOldData = oldData
    }

    override fun getOldListSize(): Int {
        return mOldData.size
    }

    override fun getNewListSize(): Int {
        return mNewData.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldData.get(oldItemPosition).id.equals(mNewData.get(newItemPosition).id)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldData.get(oldItemPosition).equals(mNewData.get(newItemPosition))
    }

}