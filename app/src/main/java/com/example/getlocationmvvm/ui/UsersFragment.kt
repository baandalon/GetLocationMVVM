package com.example.getlocationmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.databinding.ActivityStartBinding
import com.example.getlocationmvvm.databinding.FragmentUsuariosBinding
import com.example.getlocationmvvm.sys.di.DaggerComponentPrettyToast
import com.example.getlocationmvvm.viewmodel.InicioViewModel
import com.example.getlocationmvvm.viewmodel.UsersFragmentViewModel
import javax.inject.Inject

/**
 * Created by Baudelio Andalon on 22.07.2020.
 */
  class UsersFragment : Fragment() {

    @Inject
    lateinit var viewModel: UsersFragmentViewModel
    lateinit var dataBindingUtil: FragmentUsuariosBinding

        @Nullable
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            DaggerComponentPrettyToast.create().inject(this)
//            viewModel =  ViewModelProvider(this).get(UsersFragmentViewModel::class.java)
            dataBindingUtil = FragmentUsuariosBinding.inflate(inflater, container,false)
        return  dataBindingUtil.root
    }

        override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {

        }

}