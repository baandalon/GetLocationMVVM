package com.example.getlocationmvvm.exampleModel.repository

import android.util.Log
import com.example.getlocationmvvm.exampleModel.interfaces.DataInterfaces
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RepoWebDS {
//    val listener: DataInterfaces? = null
    var valueEventListener: ValueEventListener? = null
    var reference = FirebaseDatabase.getInstance().reference
    var setInterfaces: DataInterfaces? = null

    fun setDataInterfaces(dataInterfaces: DataInterfaces){
        this.setInterfaces = dataInterfaces
    }
    fun getData(path: String){
        reference = FirebaseDatabase.getInstance().getReference(path)
        valueEventListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                setInterfaces?.onDataChanged(snapshot)
                Log.e("data", "changed")
            }
        }
        reference.addValueEventListener(valueEventListener as ValueEventListener)
    }
}