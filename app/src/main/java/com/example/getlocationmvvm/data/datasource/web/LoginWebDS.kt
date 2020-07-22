package com.example.getlocationmvvm.data.datasource.web

import androidx.lifecycle.Observer
import com.example.getlocationmvvm.model.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginWebDS{

    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    fun requestUserNetwork(user: String, pass: String, observer: Observer<AuthResult>){
        auth.signInWithEmailAndPassword(user, pass)
                .addOnCompleteListener{
                    if (it.isSuccessful) {
                         observer.onChanged(AuthResult(auth.currentUser,it.result, true))
                    } else {
                        observer.onChanged(AuthResult(null,null, false))
                    }
                }
    }
}