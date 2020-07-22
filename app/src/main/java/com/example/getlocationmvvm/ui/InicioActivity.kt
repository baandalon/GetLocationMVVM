package com.example.getlocationmvvm.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.sys.utils.menusliding.DrawerAdapter
import com.example.getlocationmvvm.sys.utils.menusliding.SimpleItem
import com.yarolegovich.slidingrootnav.SlidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder
import java.util.*
import kotlin.collections.ArrayList

class InicioActivity : AppCompatActivity(), DrawerAdapter.OnItemSelectedListener {
    private val POS_DASHBOARD = 0
    private val POS_ACCOUNT = 1

    private lateinit var screenTitles: Array<String>
    private lateinit var screenIcons: Array<Drawable?>

    private var slidingRootNav: SlidingRootNav? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        slidingRootNav = SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject()
        screenIcons = loadScreenIcons()
        screenTitles = loadScreenTitles()
        val adapter = DrawerAdapter(Arrays.asList(
                createItemFor(POS_DASHBOARD).setChecked(true),
                createItemFor(POS_ACCOUNT)))
        adapter.setListener(this)
        val list: RecyclerView = findViewById(R.id.list)
        list.setNestedScrollingEnabled(false)
        list.setLayoutManager(LinearLayoutManager(this))
        list.setAdapter(adapter)
        adapter.setSelected(POS_DASHBOARD)
    }

    override fun onItemSelected(position: Int) {
        var fragments: ArrayList<Fragment> = ArrayList()
        fragments.add(DashboardFragment())
        fragments.add(UsersFragment())
        slidingRootNav!!.closeMenu()
        showFragment(fragments[position])
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    private fun createItemFor(position: Int): SimpleItem {
        return SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.colorPrimaryDark))
                .withTextTint(color(R.color.colorPrimary))
                .withSelectedIconTint(color(R.color.colorAccent))
                .withSelectedTextTint(color(R.color.colorAccent))
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

    @ColorInt
    private fun color(@ColorRes res: Int): Int {
        return ContextCompat.getColor(this, res)
    }
}