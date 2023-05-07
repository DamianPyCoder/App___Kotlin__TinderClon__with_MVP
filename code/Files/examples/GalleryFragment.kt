package com.udemy.photogallery.mvp.main.fragments.gallery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udemy.photogallery.R
import com.udemy.photogallery.mvp.main.IMain
import com.yalantis.library.Koloda
import kotlinx.android.synthetic.main.fragment_images.*

class GalleryFragment(var mainPresenter: IMain.Presenter):Fragment(),IGallery.View {



    private lateinit var  fragmentView: View

    private var galleryPresenter:IGallery.Presenter=GalleryPresenter(this)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view=inflater.inflate(R.layout.fragment_images,container,false)
        fragmentView=view



        galleryPresenter.configureView()


        return view
    }

    override fun getContext(): Context {
        return fragmentView.context
    }

    override fun getFragmentView(): View {
      return fragmentView
    }

    override fun getImagesHolder(): Koloda {
        return imagesHolder
    }

    override fun onImagesLoaded() {
        mainPresenter.fragmentWasLoaded()
    }


}