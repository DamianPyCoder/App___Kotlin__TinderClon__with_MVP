package com.udemy.photogallery.mvp.main.fragments.gallery

import android.content.Context
import com.udemy.photogallery.mvp.main.fragments.gallery.adapters.CardImageAdapter
import com.udemy.photogallery.persistence.entities.ImageData

class GalleryPresenter(private var galleryView:IGallery.View):IGallery.Presenter {


    private var galleryModel:IGallery.Model=GalleryModel(this)


    override fun configureView() {

        galleryModel.getImagesFromServer()


    }

    override fun getContext(): Context {
        return galleryView.getContext()
    }

    override fun onServerResponse(images: ArrayList<ImageData>) {

        galleryView.getImagesHolder().adapter=CardImageAdapter(
            galleryView.getContext(),
            images

        )

        galleryView.onImagesLoaded()

    }


}