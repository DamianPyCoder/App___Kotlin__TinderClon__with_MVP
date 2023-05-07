package com.udemy.photogallery.mvp.splash

import android.os.Handler

class SplashModel(private var splashPresenter:ISplash.Presenter):ISplash.Model {



    override fun checkUserLogin() {
        Handler().postDelayed({

            splashPresenter.onValidateUser(true)

        },3000)
    }


}