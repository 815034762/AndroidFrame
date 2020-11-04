package com.example.myapplication.adapter;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.viewmodel.model.JokeModel


/**
 * @author ly-zhangty
 * description: RecyclerView适配器
 */
class JokeAdapter() : RecyclerView.Adapter<JokeAdapter.UserManualHomeHolder>() {
    // 对于java和Kotlin的，要统一
    var datas: List<JokeModel.ResultBean.DataBean> = ArrayList<JokeModel.ResultBean.DataBean>()
        set(value) {
            // 调用Adapter.datas时，会执行这个方法
//          Log.e("tag","=========执行set方法=========")
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserManualHomeHolder {
        val view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_joke, parent, false);
        //将view传递给我们自定义的ViewHolder
        val holder = UserManualHomeHolder(view);
        //返回这个MyHolder实体
        return holder;
    }

    override fun onBindViewHolder(holder: UserManualHomeHolder, position: Int) {
        holder.mTvContent.text = datas.get(position).content
        holder.mTvTime.text = datas.get(position).updatetime
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    /**
     * 自定义的ViewHolder
     */
    class UserManualHomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         var mTvContent: TextView = itemView.findViewById(R.id.tv_content)
         var mTvTime: TextView = itemView.findViewById(R.id.tv_time)
    }

}