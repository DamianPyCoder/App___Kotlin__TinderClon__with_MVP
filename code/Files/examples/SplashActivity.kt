package com.udemy.photogallery.mvp.splash

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udemy.photogallery.R

class SplashActivity : AppCompatActivity(),ISplash.View {



    private var splashPresenter:ISplash.Presenter=SplashPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


       splashPresenter.launchNextActivity()

    }

    override fun getContext(): Context {
        return this
    }

    override fun getActivity(): Activity {
        return this
    }
}