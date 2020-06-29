package com.example.getlocationmvvm.exampleModel.interfaces

import com.google.firebase.database.DataSnapshot

interface DataInterfaces {
    fun onDataChanged(data: DataSnapshot)
}