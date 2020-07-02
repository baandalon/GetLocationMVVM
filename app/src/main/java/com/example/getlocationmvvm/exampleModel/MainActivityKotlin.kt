package com.example.getlocationmvvm.exampleModel

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.getlocationmvvm.R
import com.example.getlocationmvvm.databinding.ActivityMainKotlinBinding
import com.example.getlocationmvvm.exampleModel.viewmodel.MainViewModel
import com.gurutouchlabs.kenneth.elegantdialog.ElegantDialog


class MainActivityKotlin : AppCompatActivity() {
    val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kotlin)
        lifecycle.addObserver(viewModel)
        DataBindingUtil.setContentView<ActivityMainKotlinBinding>(this,
                R.layout.activity_main_kotlin).apply {
            this.lifecycleOwner = this@MainActivityKotlin
            this.viewModel2 = viewModel
        }

    }

    fun start(view: View) {
        val dialog = ElegantDialog(this)
                .setTitleIcon(resources.getDrawable( R.drawable.dialog))//Set title icon drawable if your not loading with Glide or Picasso )//Set title icon drawable if your not loading with Glide or Picasso
                .setTitleIconBackgroundColor(resources.getColor(R.color.topImage)) //Set title icon drawable background color
                .setBackgroundTopColor(resources.getColor(R.color.white))// Set top color//                .setBackgroundBottomColor(backgroundBottomColor) // Set bottom color
                .setTitleIconColor(resources.getColor(R.color.white))
                .setCustomView(R.layout.activity_start_share_location)//Set custom layout
                .setCornerRadius(10f) //Set dialog corner radius
                .setCanceledOnTouchOutside(true) // Dismiss on tap outside
                .show()  // Finally don't forget to call show()
        dialog.getNegativeButton()!!.visibility = View.INVISIBLE
        dialog.getPositiveButton()!!.visibility = View.INVISIBLE
        dialog.getGotItButtonTextView()!!.text = "ACEPTAR"
        dialog.getGotItButtonIconView()!!.visibility = View.GONE
        dialog.getNegativeButtonIconView()!!.visibility = View.GONE
        dialog.getPositiveButtonIconView()!!.visibility = View.GONE
        dialog.getNegativeButtonTextView()!!.visibility = View.GONE
        dialog.getPositiveButtonTextView()!!.visibility = View.GONE
        dialog.getGotItButton()!!.setOnClickListener {
            dialog.dismiss()
        }
        // access your customView
        val contentView: View? = dialog.getCustomView()
    }
}