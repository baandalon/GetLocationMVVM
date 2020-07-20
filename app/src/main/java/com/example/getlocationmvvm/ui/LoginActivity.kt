package com.example.getlocationmvvm.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.databinding.ActivityLoginBinding
import com.example.getlocationmvvm.sys.PrettyToast
import com.example.getlocationmvvm.sys.TypePrettyToast
import com.example.getlocationmvvm.sys.di.DaggerComponentPrettyToast
import com.example.getlocationmvvm.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
//    val viewModel by lazy { ViewModelProvider(this).get(LoginViewModel::class.java) }
    private val viewModel: LoginViewModel by viewModels()

    lateinit var dataBindingUtil: ActivityLoginBinding

    @Inject lateinit var prettyToast: PrettyToast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        DaggerComponentPrettyToast.create().inject(this)
        lifecycle.addObserver(viewModel)
        dataBindingUtil = DataBindingUtil.setContentView<ActivityLoginBinding>(this,
                R.layout.activity_login).apply {
            //*** Con el apply puedes acceder a lo que está dentro del elemento ***
            this.lifecycleOwner = this@LoginActivity
            this.viewModelLogin = viewModelLogin
        }
    }
    private fun logging(){
        viewModel.txtUser.postValue(dataBindingUtil.txtUser.text.toString().trim())
        viewModel.txtPass.postValue(dataBindingUtil.txtPass.text.toString().trim())
        if(viewModel.txtUser.value!!.isEmpty() || viewModel.txtPass.value!!.isEmpty()){
          return prettyToast.ShowToast("Vacio", TypePrettyToast.WARNING_TOAST, this)
        }
        viewModel.requestLogin(viewModel.txtUser.value!!, viewModel.txtPass.value!!)
    }

    fun startSession(view: View) {
        logging()
    }

}