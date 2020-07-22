package com.example.getlocationmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.getlocationmvvm.R

/**
 * Created by Baudelio Andalon on 22.07.2020.
 */
  class UsersFragment : Fragment() {
        @Nullable
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_usuarios, container, false)
    }

        override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {

        }

}