package com.example.getlocationmvvm.sys

import android.app.Activity
import android.view.Gravity
import com.example.getlocationmvvm.sys.di.App
import com.onurkaganaldemir.ktoastlib.KToast

class PrettyToast {

    fun ShowToast(text: String, type: TypePrettyToast, activity: Activity){
        when(type){
            TypePrettyToast.SUCCESS_TOAST -> KToast.successToast(activity, text, Gravity.BOTTOM, KToast.LENGTH_AUTO)
            TypePrettyToast.WARNING_TOAST -> KToast.warningToast(activity, text, Gravity.BOTTOM, KToast.LENGTH_AUTO)
            TypePrettyToast.ERROR_TOAST -> KToast.errorToast(activity, text, Gravity.BOTTOM, KToast.LENGTH_AUTO)
        }
    }
}