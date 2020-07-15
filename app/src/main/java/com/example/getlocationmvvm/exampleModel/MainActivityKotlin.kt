package com.example.getlocationmvvm.exampleModel

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.databinding.ActivityMainKotlinBinding
import com.example.getlocationmvvm.exampleModel.viewmodel.MainViewModel


class MainActivityKotlin : AppCompatActivity() {
    val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    lateinit var dataBindingUtil: ActivityMainKotlinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kotlin)
        lifecycle.addObserver(viewModel)
        dataBindingUtil = DataBindingUtil.setContentView<ActivityMainKotlinBinding>(this,
                R.layout.activity_main_kotlin).apply {
            //*** Con el apply puedes acceder a lo que está dentro del elemento ***
            this.lifecycleOwner = this@MainActivityKotlin
            this.viewModelMain = viewModel
        }

    }

    fun start(view: View) {

    }

    fun notTimed(view: View) {
        viewModel.timedChanged(false)
//        dataBindingUtil.apply {
//            roundableNotTimed.backgroundColor = R.color.purple_light
//            roundableTimed.backgroundColor = R.color.white
//        }

    }

    fun timed(view: View) {
        viewModel.timedChanged(true)
//        dataBindingUtil.apply {
//            roundableTimed.backgroundColor = R.color.purple_light
//            roundableNotTimed.backgroundColor = R.color.white
//        }
    }
}