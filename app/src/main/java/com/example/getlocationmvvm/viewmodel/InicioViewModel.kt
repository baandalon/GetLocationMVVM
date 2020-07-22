package com.example.getlocationmvvm.viewmodel

import android.app.Activity
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.model.ModelMenu
import com.example.getlocationmvvm.sys.di.DaggerComponentPrettyToast
import com.example.getlocationmvvm.sys.utils.MethodMenu
import com.example.getlocationmvvm.sys.utils.menusliding.DrawerAdapter
import com.example.getlocationmvvm.ui.DashboardFragment
import com.example.getlocationmvvm.ui.InicioActivity
import com.example.getlocationmvvm.ui.UsersFragment
import com.yarolegovich.slidingrootnav.SlidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder
import java.util.*
import javax.inject.Inject


class InicioViewModel : ViewModel(){

    @Inject lateinit var methodMenu: MethodMenu
    var slidingRootNav: MutableLiveData<SlidingRootNav> = MutableLiveData()
    var fragments: MutableLiveData<ArrayList<Fragment>> = MutableLiveData()
    val activity: MutableLiveData<ModelMenu> = MutableLiveData()
    val adapter: MutableLiveData<DrawerAdapter> = MutableLiveData()
    val list: MutableLiveData<RecyclerView> = MutableLiveData()

    init {
        DaggerComponentPrettyToast.create().inject(this)
        fragments.value?.apply {
            add(DashboardFragment())
            add(UsersFragment())
        }
        observerActivity()
    }

    private fun observerActivity(){
        activity.observeForever{
            Log.e("activity","changed")
            Log.e("activity","changed2")
            slidingRootNav.value = SlidingRootNavBuilder(it.activity)
                    .withMenuOpened(true)
                    .withContentClickableWhenMenuOpened(true)
                    .withMenuLayout(R.layout.menu_left_drawer)
                    .inject()
            list.value = it.activity.findViewById(R.id.list)
            adapter.value = DrawerAdapter(listOf(
                    methodMenu.createItemFor(0, loadScreenTitles(), loadScreenIcons(), it.activity).setChecked(true),
                    methodMenu.createItemFor(1,loadScreenTitles(), loadScreenIcons(), it.activity)))
            adapter.value!!.setSelected(0)
            list.value!!.isNestedScrollingEnabled = false
            list.value!!.layoutManager = LinearLayoutManager(activity.value!!.activity)
            list.value!!.adapter = adapter.value
        }
    }
    fun loadScreenTitles(): Array<String> {
        return activity.value!!.activity.resources.getStringArray(R.array.ld_activityScreenTitles)
    }

    fun loadScreenIcons(): Array<Drawable?> {
        val ta = activity.value!!.activity.resources.obtainTypedArray(R.array.ld_activityScreenIcons)
        val icons = arrayOfNulls<Drawable>(ta.length())
        for (i in 0 until ta.length()) {
            val id = ta.getResourceId(i, 0)
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(activity.value!!.activity, id)
            }
        }
        ta.recycle()
        return icons
    }

}