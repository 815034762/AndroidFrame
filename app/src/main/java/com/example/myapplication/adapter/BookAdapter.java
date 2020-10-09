package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.BookDetailActivity;
import com.example.myapplication.R;
import com.example.myapplication.viewmodel.model.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ly-zhangty
 * description: RecyclerView适配器
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {

    private List<Book.ResultBean> datas = new ArrayList<>();

    public BookAdapter() {
    }

    public BookAdapter(List<Book.ResultBean> datas) {
        this.datas.addAll(datas);
    }

    public void setDatas(List<Book.ResultBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //将我们自定义的item布局R.layout.item_one转换为View
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_books, parent, false);
        //将view传递给我们自定义的ViewHolder
        BookHolder holder = new BookHolder(view);
        //返回这个MyHolder实体
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final BookHolder holder, final int position) {
        holder.mTvTitle.setText(datas.get(position).getCatalog());
        holder.mTvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookDetailActivity.start(holder.mTvTitle.getContext(),datas.get(position).getId());
            }
        });
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    /**
     * 自定义的ViewHolder
     */
    class BookHolder extends RecyclerView.ViewHolder {

        Button mTvTitle;

        public BookHolder(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

}