package com.udemy.photogallery.mvp.main.fragments.settings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.udemy.photogallery.R
import com.udemy.photogallery.mvp.main.IMain
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_settings.view.*

class SettingsFragment(var mainPresenter: IMain.Presenter):Fragment() ,ISettings.View{



    private lateinit var  fragmentView: View

    private var settingsPresenter:ISettings.Presenter=SettingsPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view=inflater.inflate(R.layout.fragment_settings,container,false)
        fragmentView=view
        mainPresenter.fragmentWasLoaded()

        initButtons()

        return view
    }


    private fun initButtons(){
        fragmentView.aboutButton.setOnClickListener {
            settingsPresenter.onAboutButtonClick()
        }
        fragmentView.shareAppButton.setOnClickListener {
            settingsPresenter.onShareAppButtonClick()
        }
        fragmentView.rateAppButton.setOnClickListener {
            settingsPresenter.onRateAppButtonClick()
        }
    }

    override fun getContext(): Context {
      return fragmentView.context
    }

    override fun getFragmentView():View {
      return fragmentView
    }
    override fun getFragmentLayoutInflater():LayoutInflater {
        return requireActivity().layoutInflater
    }
}