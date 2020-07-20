package com.example.getlocationmvvm.sys.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class ContextModule @Inject constructor(private val context: Context) {
    @Provides
    fun provideContext(): Context { return context }
}