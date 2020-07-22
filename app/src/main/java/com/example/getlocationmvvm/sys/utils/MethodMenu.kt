package com.example.getlocationmvvm.sys.utils

import android.app.Activity
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.sys.utils.menusliding.SimpleItem

class MethodMenu {

    fun createItemFor(position: Int, screenTitles: Array<String>, screenIcons: Array<Drawable?>, activity: Activity): SimpleItem {
        return SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.colorPrimaryDark, activity))
                .withTextTint(color(R.color.colorPrimary, activity))
                .withSelectedIconTint(color(R.color.colorAccent, activity))
                .withSelectedTextTint(color(R.color.colorAccent, activity))
    }



    @ColorInt
    private fun color(@ColorRes res: Int, activity: Activity): Int {
        return ContextCompat.getColor(activity, res)
    }
}