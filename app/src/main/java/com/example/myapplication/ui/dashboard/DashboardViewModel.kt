package com.example.myapplication.ui.dashboard;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.demo.BaseData;
import com.example.myapplication.repository.RemoteRepository;
import com.example.myapplication.viewmodel.model.Book;
import com.example.myapplication.viewmodel.model.JokeModel;

 class DashboardViewModel : ViewModel() {

    private var remoteRepository:RemoteRepository = RemoteRepository()
    private lateinit var mResult:MutableLiveData<BaseData<Book>>

    fun getBookList(){
        mResult = remoteRepository.bookList
    }

    fun getResult() : MutableLiveData<BaseData<Book>>{
         return mResult
    }
}