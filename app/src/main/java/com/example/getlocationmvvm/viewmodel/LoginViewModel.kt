package com.example.getlocationmvvm.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.getlocationmvvm.domain.LoginRepository
import javax.inject.Inject

class LoginViewModel @ViewModelInject constructor(): ViewModel(), LifecycleObserver {

    @Inject
    lateinit var loginRepository: LoginRepository

    val txtUser: MutableLiveData<String> = MutableLiveData("")
    val txtPass: MutableLiveData<String> = MutableLiveData("")

    fun requestLogin(user: String, password: String) {
        loginRepository.requestUserNetwork(user, password)
    }
}