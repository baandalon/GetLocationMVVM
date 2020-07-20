package com.example.getlocationmvvm.sys.di

import com.example.getlocationmvvm.data.datasource.web.LoginWebDS
import com.example.getlocationmvvm.domain.LoginRepository
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class ModuleLogin {

    @Singleton
    @Provides
    fun providesLoginRepository(): LoginRepository {
        return LoginRepository()
    }
    @Singleton
    @Provides
    fun providesLoginWebDS(): LoginWebDS {
        return LoginWebDS()
    }


}