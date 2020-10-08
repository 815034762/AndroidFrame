package com.example.myapplication.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.demo.BaseData;
import com.example.myapplication.repository.RemoteRepository;
import com.example.myapplication.viewmodel.model.JokeModel;

public class HomeViewModel extends ViewModel {
    private RemoteRepository navigationRepository;
    private MutableLiveData<BaseData<JokeModel>> mResult;
    private MutableLiveData<String> mText;
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        navigationRepository = new RemoteRepository();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void getJokeList() {
        mResult = navigationRepository.getJokeList();
    }

    public MutableLiveData<BaseData<JokeModel>> getResult() {
        return mResult;
    }
}