package com.example.getlocationmvvm.domain

import android.util.Log
import com.example.getlocationmvvm.data.datasource.web.FirebaseAuthInterfaces
import com.example.getlocationmvvm.data.datasource.web.LoginWebDS
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class LoginRepository @Inject constructor(): FirebaseAuthInterfaces{

    @Inject
    lateinit var loginWebDS: LoginWebDS

    init {
        loginWebDS.setInterfaces(this)
    }

    fun requestUserNetwork(user: String, password: String) {
        loginWebDS.requestUserNetwork(user, password)
    }

    override fun LoginCorrect(user: FirebaseUser, result: AuthResult) {
        Log.e("login", "${user.uid}${result.credential.toString()}")
    }

    override fun LoginFailed(boolean: Boolean) {
        Log.e("login","$boolean")
    }


}