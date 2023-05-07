package com.udemy.photogallery.mvp.main

import android.app.Activity
import android.content.Context
import android.view.MenuItem
import androidx.fragment.app.Fragment
interface IMain {

    interface  View {
        fun getContext(): Context
        fun getActivity():Activity
        fun showFragment(fragment:Fragment, fragmentIndex:Int)
        fun showFrame()

        fun showProgressBar()
        fun hideProgressBar()
    }

    interface Presenter{
        fun onBottomClick(menuItem:MenuItem)
        fun fragmentWasLoaded()
        fun configureView()


    }

    interface  Model{}

}