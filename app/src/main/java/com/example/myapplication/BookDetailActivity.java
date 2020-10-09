package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.demo.BaseData;
import com.example.myapplication.viewmodel.model.BookDetail;

import java.util.ArrayList;

/**
 * @author ly-zhangty
 * description: 图书详情界面
 */
public class BookDetailActivity extends AppCompatActivity {

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
        bookId = getIntent().getStringExtra(BOOK_ID);
        bookDetailViewModel = ViewModelProviders.of(this).get(BookDetailViewModel.class);
        bookDetailViewModel.getBookDetail(bookId);
        bookDetailViewModel.getBookDetailResult().observe(this, new Observer<BaseData<BookDetail>>() {
            @Override
            public void onChanged(BaseData<BookDetail> bookDetailBaseData) {
                Log.e("tag", "===onChange===" + bookDetailBaseData.getData().getResult().getTotalNum());
                if(bookDetailBaseData.getData() != null && !bookDetailBaseData.getData().getResult().getData().isEmpty()) {
                    ArrayList<BookDetail.ResultBean.DataBean> dataBeans = (ArrayList<BookDetail.ResultBean.DataBean>) bookDetailBaseData.getData().getResult().getData();
                    for(BookDetail.ResultBean.DataBean dataBean : dataBeans) {

                    }
                }
            }
        });
    }
}