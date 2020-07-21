package com.example.getlocationmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.getlocationmvvm.data.datasource.web.FirebaseAuthInterfaces
import com.example.getlocationmvvm.domain.LoginRepository
import com.example.getlocationmvvm.sys.di.DaggerComponentPrettyToast
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class LoginViewModel: ViewModel(), LifecycleObserver, FirebaseAuthInterfaces {

    @Inject lateinit var loginRepository: LoginRepository

    init {
        DaggerComponentPrettyToast.create().inject(this)
        loginRepository.loginWebDS.setInterfaces(this)
    }
    val txtUser: MutableLiveData<String> = MutableLiveData("")
    val txtPass: MutableLiveData<String> = MutableLiveData("")
    var loggingUser: MutableLiveData<Boolean> = MutableLiveData(false)

    fun requestLogin(user: String, password: String) {
        loginRepository.requestUserNetwork(user, password)
        txtUser.postValue(user)
        txtPass.postValue(password)
        loggingUser.postValue(true)
        Log.e("login", loggingUser.value.toString())
    }

    override fun LoginCorrect(user: FirebaseUser, result: AuthResult) {
        Log.e("login","correct")
    }

    override fun LoginFailed(boolean: Boolean) {
        Log.e("login","failed")
        txtUser.postValue("")
        txtPass.postValue("")
    }

}