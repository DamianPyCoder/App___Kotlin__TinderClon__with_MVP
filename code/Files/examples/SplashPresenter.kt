package com.udemy.photogallery.mvp.splash

import android.content.Intent
import com.udemy.photogallery.mvp.main.MainActivity

class SplashPresenter(private var splashActivity: ISplash.View):ISplash.Presenter {

    private var splashModel:ISplash.Model=SplashModel(this)

    override fun launchNextActivity() {

        splashModel.checkUserLogin()

    }

    override fun onValidateUser(isValid: Boolean) {
        var intent= Intent(splashActivity.getContext(),MainActivity::class.java)
        splashActivity.getContext().startActivity(intent)
        splashActivity.getActivity().finish()

    }


}