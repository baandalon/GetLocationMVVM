package com.example.getlocationmvvm.domain

import com.example.getlocationmvvm.data.datasource.web.LoginWebDS
import com.example.getlocationmvvm.sys.di.DaggerComponentPrettyToast
import javax.inject.Inject

class LoginRepository{

    @Inject lateinit var loginWebDS: LoginWebDS

    init {
        DaggerComponentPrettyToast.create().inject(this)
    }

    fun requestUserNetwork(user: String, password: String) {
        loginWebDS.requestUserNetwork(user, password)
    }

}