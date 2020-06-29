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

class MainViewModel: ViewModel(), DataInterfaces{

    var repo: RepoWebDS? = null
    var dataModel: MutableLiveData<ModelStructure>? = null

    init {
        repo = RepoWebDS()
        dataModel = MutableLiveData()
        repo?.setDataInterfaces(this)
    }
    fun onDataRequest(path: String){
        repo?.getData(path)
    }

    override fun onDataChanged(data: DataSnapshot) {
        val modelAction: Action = data.child("action").getValue(Action::class.java)!!
        val modelData: Data = data.child("data").getValue(Data::class.java)!!
                val modelStructure = ModelStructure(modelAction, modelData)
                dataModel!!.postValue(modelStructure)
    }

}