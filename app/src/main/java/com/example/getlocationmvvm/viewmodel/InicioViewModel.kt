package com.example.getlocationmvvm.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.getlocationmvvm.ui.DashboardFragment
import com.example.getlocationmvvm.ui.UsersFragment
import java.util.*
import javax.inject.Inject

class InicioViewModel @Inject constructor(): ViewModel(){

    var fragmentsInicio: MutableLiveData<ArrayList<Fragment>> = MutableLiveData(arrayListOf(DashboardFragment(), UsersFragment()))
    var position: MutableLiveData<Int> = MutableLiveData(0)

}