package com.example.getlocationmvvm.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.databinding.ActivityLoginBinding
import com.example.getlocationmvvm.sys.utils.PrettyToast
import com.example.getlocationmvvm.sys.utils.TypePrettyToast
import com.example.getlocationmvvm.sys.di.DaggerComponentPrettyToast
import com.example.getlocationmvvm.viewmodel.LoginViewModel
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(LoginViewModel::class.java) }

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
        viewModel.loggingUser.observeForever {
                dataBindingUtil.apply {
                    if(it){
                        login.visibility = View.GONE
                        txtUser.visibility = View.GONE
                        txtPass.visibility = View.GONE
                        loading.visibility = View.VISIBLE
                    }else{
                        login.visibility = View.VISIBLE
                        txtUser.visibility = View.VISIBLE
                        txtPass.visibility = View.VISIBLE
                        loading.visibility = View.GONE
                    }
                }
        }
        viewModel.onRequestLoginSuccessful.observeForever{auth ->
            if(auth.authCorrect){
                prettyToast.showToast("Correct", TypePrettyToast.SUCCESS_TOAST, this)
                startActivity(Intent(this, InicioActivity::class.java))
                finish()
            }else{
                prettyToast.showToast("Verifique los datos", TypePrettyToast.ERROR_TOAST, this)
            }
        }

    }
    private fun logging(){
        val user = dataBindingUtil.txtUser.text.toString().trim()
        val pass = dataBindingUtil.txtPass.text.toString().trim()
        if(user.isEmpty() || pass.isEmpty()){
          return prettyToast.showToast("Vacio", TypePrettyToast.WARNING_TOAST, this)
        }
        viewModel.requestLogin(user, pass)
        viewModel.loggingUser.postValue(true)
    }

    fun startSession(view: View) {
        logging()
    }

}