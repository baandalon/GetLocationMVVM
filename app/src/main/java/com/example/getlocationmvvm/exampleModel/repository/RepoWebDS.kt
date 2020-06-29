package com.example.getlocationmvvm.exampleModel.repository

import com.example.getlocationmvvm.exampleModel.interfaces.DataInterfaces
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RepoWebDS {
//    val listener: DataInterfaces? = null
    var valueEventListener: ValueEventListener? = null
    var reference = FirebaseDatabase.getInstance().reference
    fun getData(path: String,  s : DataInterfaces){
        reference = FirebaseDatabase.getInstance().getReference(path)
        valueEventListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                s.onDataChanged(snapshot)
//                listener?.onDataChanged(snapshot)
            }
        }
        reference.addValueEventListener(valueEventListener as ValueEventListener)
    }
}