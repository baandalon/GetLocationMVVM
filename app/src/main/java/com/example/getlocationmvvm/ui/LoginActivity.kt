package com.example.getlocationmvvm.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.databinding.ActivityLoginBinding
import com.example.getlocationmvvm.databinding.ActivityMainKotlinBinding
import com.example.getlocationmvvm.exampleModel.viewmodel.MainViewModel
import com.example.getlocationmvvm.viewmodel.LoginViewModel


class LoginActivity : AppCompatActivity() {
    val viewModel by lazy { ViewModelProvider(this).get(LoginViewModel::class.java) }
    lateinit var dataBindingUtil: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        lifecycle.addObserver(viewModel)
        dataBindingUtil = DataBindingUtil.setContentView<ActivityLoginBinding>(this,
                R.layout.activity_main_kotlin).apply {
            //*** Con el apply puedes acceder a lo que está dentro del elemento ***
            this.lifecycleOwner = this@LoginActivity
            this.viewModelLogin = viewModelLogin
        }
    }


}