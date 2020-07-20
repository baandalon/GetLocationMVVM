package com.example.getlocationmvvm.sys.di

import com.example.getlocationmvvm.sys.PrettyToast
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
class ModulePrettyToast{

    @Provides
    @Singleton
    fun providesPrettyToast(): PrettyToast {
        return PrettyToast()
    }
}