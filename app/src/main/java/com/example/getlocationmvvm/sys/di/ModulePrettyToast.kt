package com.example.getlocationmvvm.sys.di

import com.example.getlocationmvvm.sys.PrettyToast
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class ModulePrettyToast @Inject constructor() {

    @Singleton
    @Provides
    fun providesPrettyToast(): PrettyToast {
        return PrettyToast()
    }
}