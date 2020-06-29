package com.example.getlocationmvvm.exampleModel

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.exampleModel.viewmodel.MainViewModel

class MainActivityKotlin : AppCompatActivity() {
    private val txtData: TextView? = null
    private val txtAction: TextView? = null
    val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.onDataRequest("ExampleMutableLiveDataModel")
    }
}