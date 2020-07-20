package com.example.getlocationmvvm.sys.di

import android.content.Context
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class])
interface UtilComponent {
    fun getAppContext(): Context
}