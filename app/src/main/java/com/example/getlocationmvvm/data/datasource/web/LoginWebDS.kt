package com.example.getlocationmvvm.data.datasource.web

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class LoginWebDS{

    lateinit var authValues:FirebaseAuthInterfaces

    fun setInterfaces(dataInterfaces: FirebaseAuthInterfaces){
        this.authValues = dataInterfaces
    }
    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    fun requestUserNetwork(user: String, pass: String){
        auth.signInWithEmailAndPassword(user, pass)
                .addOnCompleteListener{
                    if (it.isSuccessful) {
                        authValues.LoginCorrect(auth.currentUser!!, it.result!!)
                    } else {
                        authValues.LoginFailed(true)
                    }
                }
    }
}