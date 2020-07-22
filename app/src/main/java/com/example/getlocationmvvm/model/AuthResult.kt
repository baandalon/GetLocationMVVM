package com.example.getlocationmvvm.model

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

class AuthResult(val firebaseUser: FirebaseUser?,
                 val authResult: AuthResult?, var authCorrect: Boolean) {
}