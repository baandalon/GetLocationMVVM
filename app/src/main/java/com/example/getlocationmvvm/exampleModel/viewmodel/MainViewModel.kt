package com.example.getlocationmvvm.exampleModel.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.getlocationmvvm.exampleModel.interfaces.DataInterfaces
import com.example.getlocationmvvm.exampleModel.model.Action
import com.example.getlocationmvvm.exampleModel.model.Data
import com.example.getlocationmvvm.exampleModel.model.ModelStructure
import com.example.getlocationmvvm.exampleModel.repository.RepoWebDS
import com.google.firebase.database.DataSnapshot

class MainViewModel: ViewModel(), LifecycleObserver, DataInterfaces{

    var repo = RepoWebDS()
    var dataModel= MutableLiveData<ModelStructure>(null)
    var isTimed: MutableLiveData<Boolean> = MutableLiveData(true)

    init {
        dataModel = MutableLiveData()
        repo.setDataInterfaces(this)
    }
    fun onDataRequest(path: String){
        repo.getData(path)
    }

    fun timedChanged(timedValue: Boolean){
        isTimed.value?.let {
            isTimed.postValue(timedValue)
            Log.e("data", timedValue.toString())
        }
    }

    override fun onDataChanged(data: DataSnapshot) {
        val modelAction: Action = data.child("action").getValue(Action::class.java)!!
        val modelData: Data = data.child("data").getValue(Data::class.java)!!
                val modelStructure = ModelStructure(modelAction, modelData)
                dataModel.postValue(modelStructure)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreated(){
        onDataRequest("ExampleMutableLiveDataModel")
    }
}