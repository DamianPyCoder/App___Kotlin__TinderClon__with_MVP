package com.udemy.photogallery.mvp.splash

import android.app.Activity
import android.content.Context

interface ISplash {

    interface  View{

        fun getContext():Context
        fun getActivity():Activity
    }
    interface  Presenter{
        fun launchNextActivity()
        fun onValidateUser(isValid:Boolean)

    }
    interface  Model{

        fun checkUserLogin()
    }

}