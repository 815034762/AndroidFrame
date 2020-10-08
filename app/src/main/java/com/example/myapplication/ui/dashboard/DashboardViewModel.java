package com.example.myapplication.ui.dashboard;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.demo.BaseData;
import com.example.myapplication.repository.RemoteRepository;
import com.example.myapplication.viewmodel.model.Book;
import com.example.myapplication.viewmodel.model.JokeModel;

public class DashboardViewModel extends ViewModel {

    private RemoteRepository remoteRepository;
    private MutableLiveData<BaseData<Book>> mResult;

    public DashboardViewModel() {
        remoteRepository = new RemoteRepository();
    }

    public void getBookList() {
        mResult = remoteRepository.getBookList();
    }

    public MutableLiveData<BaseData<Book>> getResult() {
        return mResult;
    }
}