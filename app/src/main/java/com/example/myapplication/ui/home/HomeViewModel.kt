package com.example.myapplication.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.demo.BaseData;
import com.example.myapplication.repository.RemoteRepository;
import com.example.myapplication.viewmodel.model.JokeModel;

class HomeViewModel : ViewModel() {

    private var navigationRepository: RemoteRepository = RemoteRepository()
    private var mResult: MutableLiveData<BaseData<JokeModel>> = MutableLiveData()

    fun getJokeList() {
        navigationRepository.getJokeList(mResult)
    }

    fun getResult(): MutableLiveData<BaseData<JokeModel>> {
        return mResult
    }

}