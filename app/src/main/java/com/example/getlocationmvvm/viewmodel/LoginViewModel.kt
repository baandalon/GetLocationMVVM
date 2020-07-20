package com.example.getlocationmvvm.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel(), LifecycleObserver {

    val logging: MutableLiveData<Boolean> = MutableLiveData(false)
    val txtUser: MutableLiveData<String> = MutableLiveData("")
    val txtPass: MutableLiveData<String> = MutableLiveData("")
    fun loggingUser(){
        logging.postValue(true)
    }
    fun fillDataUser(){

    }
}