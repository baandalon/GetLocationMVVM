package com.example.getlocationmvvm.exampleModel

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.exampleModel.viewmodel.MainViewModel

class MainActivityKotlin : AppCompatActivity() {
    private var txtdata: TextView? = null
    private var txtaction: TextView? = null
    private var viewModel : MainViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kotlin)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel!!.dataModel?.observe(this, Observer {
            Log.e("data", it.data.name)
        })
        viewModel!!.onDataRequest("ExampleMutableLiveDataModel")
        txtdata = findViewById(R.id.txtdata)
        txtaction = findViewById(R.id.txtaction)
    }
}