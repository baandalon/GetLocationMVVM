package com.example.getlocationmvvm.exampleModel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.databinding.ActivityMainKotlinBinding
import com.example.getlocationmvvm.exampleModel.viewmodel.MainViewModel


class MainActivityKotlin : AppCompatActivity() {
    val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kotlin)
        lifecycle.addObserver(viewModel)
        DataBindingUtil.setContentView<ActivityMainKotlinBinding>(this,
                R.layout.activity_main_kotlin).apply {
            this.lifecycleOwner = this@MainActivityKotlin
            this.viewModel2 = viewModel
        }
    }
}