package com.example.myapplication.ui.notifications;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class RecyclerPagingAdapter extends PagedListAdapter<Notifications.ResultBean.DataBean, RecyclerPagingAdapter.MyRecyclerViewHolder> {

    // TODO 比较的行为
    private static DiffUtil.ItemCallback<Notifications.ResultBean.DataBean> DIFF_STUDNET = new
            DiffUtil.ItemCallback<Notifications.ResultBean.DataBean>() {

                // 一般是比较 唯一性的内容， ID
                @Override
                public boolean areItemsTheSame(@NonNull Notifications.ResultBean.DataBean oldItem, @NonNull Notifications.ResultBean.DataBean newItem) {
                    return oldItem.getContent().equals(newItem.getContent());
                }

                // 对象本身的比较
                @Override
                public boolean areContentsTheSame(@NonNull Notifications.ResultBean.DataBean oldItem, @NonNull Notifications.ResultBean.DataBean newItem) {
                    return oldItem.equals(newItem);
                }
            };

    protected RecyclerPagingAdapter() {
        super(DIFF_STUDNET);
    }

    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new MyRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {
        Notifications.ResultBean.DataBean notifications = getItem(position);

        // 分页库还在加载数据中，我就显示 Id加载中，比如获取了总数，但是他获取网络数据还没有。
        if (null == notifications) {
            holder.tvId.setText("内容加载中");
            holder.tvName.setText("内容加载中");
            holder.tvSex.setText("内容加载中");
        } else {
            holder.tvId.setText(notifications.getContent());
            holder.tvName.setText(notifications.getUpdatetime());
            holder.tvSex.setText(notifications.getUpdatetime());
        }
    }

    // Item 优化的 ViewHolder
    public static class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tvId;
        TextView tvName;
        TextView tvSex;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id); // ID
            tvName = itemView.findViewById(R.id.tv_name); // 名称
            tvSex = itemView.findViewById(R.id.tv_sex); // 性别
        }
    }

}
