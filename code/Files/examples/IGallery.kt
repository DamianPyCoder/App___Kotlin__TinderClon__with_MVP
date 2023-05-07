package com.udemy.photogallery.mvp.main.fragments.gallery

import android.content.Context
import com.udemy.photogallery.persistence.entities.ImageData
import com.yalantis.library.Koloda

interface IGallery {

    interface  View{

        fun getContext():Context
        fun getFragmentView():android.view.View

        fun getImagesHolder(): Koloda
        fun onImagesLoaded()
    }
    interface  Presenter{
        fun configureView()
        fun getContext():Context
        fun onServerResponse(images:ArrayList<ImageData>)

    }

    interface  Model{
        fun getImagesFromServer()

    }

}