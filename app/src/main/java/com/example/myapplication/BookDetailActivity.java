package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.demo.BaseData;
import com.example.myapplication.glide.GlideImageLoader;
import com.example.myapplication.viewmodel.model.BookDetail;

import java.util.ArrayList;

/**
 * @author ly-zhangty
 * description: 图书详情界面
 */
public class BookDetailActivity extends AppCompatActivity {

    private TextView mTvTitle,mTvDescription,mTvTime;
    private ImageView mImageView;
    private BookDetailViewModel bookDetailViewModel;
    public static final String BOOK_ID = "bookId";
    private String bookId = "";

    public static void start(Context context,String id) {
        Intent intent = new Intent(context, BookDetailActivity.class);
        intent.putExtra(BOOK_ID,id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        mTvTitle = findViewById(R.id.tv_title);
        mTvDescription = findViewById(R.id.tv_desc);
        mTvTime = findViewById(R.id.tv_time);
        mImageView = findViewById(R.id.iv_img);

        bookId = getIntent().getStringExtra(BOOK_ID);
        bookDetailViewModel = ViewModelProviders.of(this).get(BookDetailViewModel.class);
        bookDetailViewModel.getBookDetail(bookId);
        bookDetailViewModel.getBookDetailResult().observe(this, new Observer<BaseData<BookDetail>>() {
            @Override
            public void onChanged(BaseData<BookDetail> bookDetailBaseData) {
                Log.e("tag", "===onChange===" + bookDetailBaseData.getData().getResult().getTotalNum());
                if(bookDetailBaseData.getData() != null && !bookDetailBaseData.getData().getResult().getData().isEmpty()) {
                    ArrayList<BookDetail.ResultBean.DataBean> dataBeans = (ArrayList<BookDetail.ResultBean.DataBean>) bookDetailBaseData.getData().getResult().getData();
                    if(!dataBeans.isEmpty()) {
                        BookDetail.ResultBean.DataBean dataBean = dataBeans.get(0);
                        mTvTime.setText(dataBean.getTitle());
                        GlideImageLoader.get(BookDetailActivity.this).displayImage(dataBean.getImg(),mImageView);
                        mTvTime.setText(dataBean.getBytime());
                        mTvDescription.setText(dataBean.getSub1());
                    }
                }
            }
        });
    }
}