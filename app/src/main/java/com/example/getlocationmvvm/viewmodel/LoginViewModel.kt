package com.example.getlocationmvvm.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.getlocationmvvm.domain.LoginRepository
import com.example.getlocationmvvm.model.AuthResult
import com.example.getlocationmvvm.sys.di.DaggerComponentPrettyToast
import javax.inject.Inject

class LoginViewModel: ViewModel(), LifecycleObserver {

    @Inject lateinit var loginRepository: LoginRepository
    var onRequestLoginSuccessful: MutableLiveData<AuthResult> = MutableLiveData()

    init {
        DaggerComponentPrettyToast.create().inject(this)
//        loginRepository.loginWebDS.setInterfaces(this)
    }
    var loggingUser: MutableLiveData<Boolean> = MutableLiveData(false)

    fun requestLogin(user: String, password: String) {
        loginRepository.requestUserNetwork(user, password, buildGetLoginResponseObserve())
    }

    private fun buildGetLoginResponseObserve(): Observer<AuthResult> {
        return Observer { response ->
            if (response != null) {
                onRequestLoginSuccessful.postValue(response)
                if (!response.authCorrect){loggingUser.postValue(false)}
            }
        }
    }
}