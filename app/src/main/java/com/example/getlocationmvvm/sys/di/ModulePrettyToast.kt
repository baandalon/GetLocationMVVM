package com.example.getlocationmvvm.sys.di

import com.example.getlocationmvvm.data.datasource.web.LoginWebDS
import com.example.getlocationmvvm.domain.LoginRepository
import com.example.getlocationmvvm.sys.utils.PrettyToast
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModulePrettyToast{

    @Provides
    @Singleton
    fun providesPrettyToast(): PrettyToast {
        return PrettyToast()
    }

    @Provides
    @Singleton
    fun providesLoginRepository(): LoginRepository{
        return LoginRepository()
    }

    @Provides
    @Singleton
    fun providesLoginWebDS(): LoginWebDS{
        return LoginWebDS()
    }
}