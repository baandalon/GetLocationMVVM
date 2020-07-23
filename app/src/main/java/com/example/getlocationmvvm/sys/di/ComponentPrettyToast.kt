package com.example.getlocationmvvm.sys.di

import com.example.getlocationmvvm.domain.LoginRepository
import com.example.getlocationmvvm.ui.InicioActivity
import com.example.getlocationmvvm.ui.LoginActivity
import com.example.getlocationmvvm.viewmodel.InicioViewModel
import com.example.getlocationmvvm.viewmodel.LoginViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModulePrettyToast::class])
interface ComponentPrettyToast {
        fun inject(loginActivity: LoginActivity)
        fun inject(inicioActivity: InicioActivity)
        fun inject(loginViewModel: LoginViewModel)
        fun inject(loginRepository: LoginRepository)
        fun inject(inicioViewModel: InicioViewModel)
}