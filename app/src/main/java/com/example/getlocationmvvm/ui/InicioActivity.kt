package com.example.getlocationmvvm.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.databinding.ActivityStartBinding
import com.example.getlocationmvvm.sys.di.DaggerComponentPrettyToast
import com.example.getlocationmvvm.sys.utils.MethodMenu
import com.example.getlocationmvvm.sys.utils.menusliding.DrawerAdapter
import com.example.getlocationmvvm.viewmodel.InicioViewModel
import com.yarolegovich.slidingrootnav.SlidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder
import org.jetbrains.annotations.NotNull
import javax.inject.Inject

class InicioActivity : AppCompatActivity(), DrawerAdapter.OnItemSelectedListener {

    @Inject
    lateinit var methodMenu: MethodMenu
    private val viewModel by lazy { ViewModelProvider(this).get(InicioViewModel::class.java) }
    lateinit var dataBindingUtil: ActivityStartBinding
    lateinit var slidingRootNav: SlidingRootNav

    override fun onCreate(@NotNull savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        DaggerComponentPrettyToast.create().inject(this)
        dataBindingUtil = DataBindingUtil.setContentView<ActivityStartBinding>(this,
                R.layout.activity_start).apply {
            //*** Con el apply puedes acceder a lo que está dentro del elemento ***
            this.lifecycleOwner = this@InicioActivity
            this.viewModel = viewModel
        }
        setSupportActionBar(dataBindingUtil.toolbar)

        //Inicializacion del MENU
        slidingRootNav = SlidingRootNavBuilder(this)
                .withMenuOpened(false)
//                .withSavedState(savedInstanceState)
                .withContentClickableWhenMenuOpened(true)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject()
        val adapter = DrawerAdapter(listOf(
                methodMenu.createItemFor(0, loadScreenTitles(), loadScreenIcons(), this).setChecked(true),
                methodMenu.createItemFor(1,loadScreenTitles(), loadScreenIcons(), this)))
        adapter.setListener(this)
        val list: RecyclerView = findViewById(R.id.list)
        list.isNestedScrollingEnabled = false
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
        adapter.setSelected(viewModel.position.value!!)

        //INICIALIZACION DE LOS OBSERVERS
        viewModel.position.observe(this, Observer {
            showFragment(viewModel.fragmentsInicio.value!![it])
        })

    }
    private fun loadScreenTitles(): Array<String> {
        return resources.getStringArray(R.array.ld_activityScreenTitles)
    }

    private fun loadScreenIcons(): Array<Drawable?> {
        val ta = resources.obtainTypedArray(R.array.ld_activityScreenIcons)
        val icons = arrayOfNulls<Drawable>(ta.length())
        for (i in 0 until ta.length()) {
            val id = ta.getResourceId(i, 0)
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id)
            }
        }
        ta.recycle()
        return icons
    }
    override fun onItemSelected(position: Int) {
        slidingRootNav.closeMenu()
        viewModel.position.postValue(position)
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

}