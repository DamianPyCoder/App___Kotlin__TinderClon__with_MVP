package com.udemy.photogallery.mvp.main.fragments.settings

import android.content.Context
import android.view.LayoutInflater

interface ISettings {



    interface  View{
        fun getContext():Context
        fun getFragmentView():android.view.View
        fun getFragmentLayoutInflater():LayoutInflater
    }

    interface  Presenter{
        fun onAboutButtonClick()
        fun onRateAppButtonClick()
        fun onShareAppButtonClick()

    }

}