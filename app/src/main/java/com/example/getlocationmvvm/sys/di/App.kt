package com.example.getlocationmvvm.sys.di

import android.app.Application

class App : Application(){
    override fun onCreate() {
        super.onCreate()
        DaggerComponentPrettyToast.builder().build()
    }
}