package com.example.getlocationmvvm.sys.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        utilComponent = DaggerUtilComponent.builder()
                .contextModule(ContextModule(applicationContext)).build()
        ConnectivityManager.NetworkCallback()
    }

    companion object {
        lateinit var utilComponent: UtilComponent

        fun getAppContext(): Context {
            return utilComponent.getAppContext()
        }
    }
}
