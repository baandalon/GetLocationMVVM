package com.example.getlocationmvvm.sys.di

import com.example.getlocationmvvm.ui.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModulePrettyToast::class])
interface ComponentPrettyToast {
        fun inject(loginActivity: LoginActivity)
}