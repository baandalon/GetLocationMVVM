package com.example.getlocationmvvm.data.datasource.web

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

interface FirebaseAuthInterfaces {
    fun LoginCorrect(user: FirebaseUser, result: AuthResult)
    fun LoginFailed(boolean: Boolean)
}