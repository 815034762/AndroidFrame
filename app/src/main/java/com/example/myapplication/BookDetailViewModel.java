package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.demo.BaseData;
import com.example.myapplication.repository.RemoteRepository;
import com.example.myapplication.viewmodel.model.BookDetail;

public class BookDetailViewModel extends AndroidViewModel {

    private RemoteRepository remoteRepository;
    private MutableLiveData<BaseData<BookDetail>> bookDetailResult = new MutableLiveData<>();

    public BookDetailViewModel(@NonNull Application application) {
        super(application);
        remoteRepository = new RemoteRepository();
    }

    /**
     * 获取书本详情
     * @param catalogId 书本ID
     */
    public void getBookDetail(String catalogId) {
        bookDetailResult = remoteRepository.getBookDetail(catalogId);
    }

    public MutableLiveData<BaseData<BookDetail>> getBookDetailResult() {
        return bookDetailResult;
    }
}
