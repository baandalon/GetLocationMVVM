package com.example.getlocationmvvm.exampleModel.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.getlocationmvvm.exampleModel.interfaces.DataInterfaces
import com.example.getlocationmvvm.exampleModel.model.Action
import com.example.getlocationmvvm.exampleModel.model.Data
import com.example.getlocationmvvm.exampleModel.model.ModelStructure
import com.example.getlocationmvvm.exampleModel.repository.RepoWebDS
import com.google.firebase.database.DataSnapshot

class MainViewModel: ViewModel(){

    val repo: RepoWebDS? = null
    var dataModel: MutableLiveData<ModelStructure>? = null
    init {
        dataModel = MutableLiveData()
    }
    fun onDataRequest(path: String){
        repo?.getData(path, object : DataInterfaces {
            override fun onDataChanged(data: DataSnapshot) {
                val modelAction = data.child("action").getValue(Action::class.java)
                val modelData = data.child("data").getValue(Data::class.java)
                Log.e("action1", modelAction?.action1.toString() + "${modelAction?.action2}")
//                val modelStructure = ModelStructure(modelAction!!, modelData!!)
//                dataModel!!.postValue(modelStructure)
            }
        })
    }
}