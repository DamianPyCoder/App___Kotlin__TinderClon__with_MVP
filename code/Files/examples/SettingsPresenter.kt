package com.udemy.photogallery.mvp.main.fragments.settings

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import com.udemy.photogallery.R
import java.lang.Exception

class SettingsPresenter(private var settingsView:ISettings.View):ISettings.Presenter {


    override fun onAboutButtonClick() {

        val dialog=AlertDialog.Builder(settingsView.getContext())
        val inflater=settingsView.getFragmentLayoutInflater()

        dialog.setView(inflater.inflate(R.layout.about_dialog,null))

        dialog.create()
        dialog.show()

    }

    override fun onRateAppButtonClick() {
         val uri= Uri.parse("market://details?id=com.udemy.photogallery")
        var intent=Intent(Intent.ACTION_VIEW,uri)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        )
        try {

            settingsView.getContext().startActivity(intent)
        }catch(ex:Exception){
            ex.printStackTrace()

        }
    }

    override fun onShareAppButtonClick() {
        var intent=Intent()
        intent.action=Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT,"Checa este curso de MVP en kotlin")
        intent.type="text/plain"
        try {

            settingsView.getContext().startActivity( Intent.createChooser( intent,"Compartir con "))
        }catch(ex:Exception){
            ex.printStackTrace()

        }

    }


}