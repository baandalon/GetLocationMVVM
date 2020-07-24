package com.example.getlocationmvvm.sys.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/example/getlocationmvvm/sys/di/ComponentPrettyToast;", "", "inject", "", "loginRepository", "Lcom/example/getlocationmvvm/domain/LoginRepository;", "inicioActivity", "Lcom/example/getlocationmvvm/ui/InicioActivity;", "loginActivity", "Lcom/example/getlocationmvvm/ui/LoginActivity;", "usersFragment", "Lcom/example/getlocationmvvm/ui/UsersFragment;", "inicioViewModel", "Lcom/example/getlocationmvvm/viewmodel/InicioViewModel;", "loginViewModel", "Lcom/example/getlocationmvvm/viewmodel/LoginViewModel;", "app_debug"})
@dagger.Component(modules = {com.example.getlocationmvvm.sys.di.ModulePrettyToast.class})
@javax.inject.Singleton()
public abstract interface ComponentPrettyToast {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.getlocationmvvm.ui.LoginActivity loginActivity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.getlocationmvvm.ui.InicioActivity inicioActivity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.getlocationmvvm.viewmodel.LoginViewModel loginViewModel);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.getlocationmvvm.domain.LoginRepository loginRepository);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.getlocationmvvm.viewmodel.InicioViewModel inicioViewModel);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.getlocationmvvm.ui.UsersFragment usersFragment);
}