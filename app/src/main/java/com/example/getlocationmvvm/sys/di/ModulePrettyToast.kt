package com.example.getlocationmvvm.sys.di

import com.example.getlocationmvvm.data.datasource.web.LoginWebDS
import com.example.getlocationmvvm.databinding.ActivityStartBinding
import com.example.getlocationmvvm.domain.LoginRepository
import com.example.getlocationmvvm.sys.utils.MethodMenu
import com.example.getlocationmvvm.sys.utils.PrettyToast
import com.example.getlocationmvvm.viewmodel.InicioViewModel
import com.example.getlocationmvvm.viewmodel.UsersFragmentViewModel
import com.yarolegovich.slidingrootnav.SlidingRootNav
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

    @Provides
    @Singleton
    fun providesMethodMenu(): MethodMenu{
        return MethodMenu()
    }

    @Provides
    @Singleton
    fun providesInicioViewModel(): InicioViewModel{
        return InicioViewModel()
    }

    @Provides
    @Singleton
    fun providesUsersFragmentViewModel(): UsersFragmentViewModel{
        return UsersFragmentViewModel()
    }

}