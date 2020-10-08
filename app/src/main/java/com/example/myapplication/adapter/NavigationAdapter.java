package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.viewmodel.model.JokeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ly-zhangty
 * description: RecyclerView适配器
 */
public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.UserManualHomeHolder> {

    private List<JokeModel.ResultBean.DataBean> datas = new ArrayList<>();

    public NavigationAdapter() {
    }

    public NavigationAdapter(List<JokeModel.ResultBean.DataBean> datas) {
        this.datas = datas;
    }

    public List<JokeModel.ResultBean.DataBean> getDatas() {
        return datas;
    }

    public void setDatas(List<JokeModel.ResultBean.DataBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserManualHomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //将我们自定义的item布局R.layout.item_one转换为View
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_joke, parent, false);
        //将view传递给我们自定义的ViewHolder
        UserManualHomeHolder holder = new UserManualHomeHolder(view);
        //返回这个MyHolder实体
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserManualHomeHolder holder, int position) {
            holder.mTvContent.setText(datas.get(position).getContent());
            holder.mTvTime.setText(datas.get(position).getUpdatetime());
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    /**
     * 自定义的ViewHolder
     */
    class UserManualHomeHolder extends RecyclerView.ViewHolder {

        TextView mTvContent;
        TextView mTvTime;

        public UserManualHomeHolder(View itemView) {
            super(itemView);
            mTvContent = itemView.findViewById(R.id.tv_content);
            mTvTime = itemView.findViewById(R.id.tv_time);
        }
    }

}