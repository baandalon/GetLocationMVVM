package com.example.getlocationmvvm.ui

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.databinding.ActivityStartBinding
import com.example.getlocationmvvm.model.ModelMenu
import com.example.getlocationmvvm.sys.utils.menusliding.DrawerAdapter
import com.example.getlocationmvvm.viewmodel.InicioViewModel
import org.jetbrains.annotations.NotNull

class InicioActivity : AppCompatActivity(), DrawerAdapter.OnItemSelectedListener {

    private val viewModel by lazy { ViewModelProvider(this).get(InicioViewModel::class.java) }
    lateinit var dataBindingUtil: ActivityStartBinding

    override fun onCreate(@NotNull savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        dataBindingUtil = DataBindingUtil.setContentView<ActivityStartBinding>(this,
                R.layout.activity_start).apply {
            //*** Con el apply puedes acceder a lo que está dentro del elemento ***
            this.lifecycleOwner = this@InicioActivity
            this.viewModel = viewModel
        }
        setSupportActionBar(dataBindingUtil.toolbar)
            viewModel.activity.postValue(ModelMenu(this))

    }
    override fun onItemSelected(position: Int) {
        viewModel.slidingRootNav.value!!.closeMenu()
        viewModel.fragments.value?.get(position)?.let { showFragment(it) }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

}