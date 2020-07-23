package com.example.getlocationmvvm.domain

import androidx.lifecycle.Observer
import com.example.getlocationmvvm.data.datasource.web.LoginWebDS
import com.example.getlocationmvvm.model.AuthResult
import com.example.getlocationmvvm.sys.di.DaggerComponentPrettyToast
import javax.inject.Inject

class LoginRepository @Inject constructor(){

    @Inject lateinit var loginWebDS: LoginWebDS

    init {
        DaggerComponentPrettyToast.create().inject(this)
    }

    fun requestUserNetwork(user: String, password: String, observer: Observer<AuthResult>) {
        loginWebDS.requestUserNetwork(user, password, observer)
    }

}