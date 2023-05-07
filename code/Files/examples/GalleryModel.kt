package com.udemy.photogallery.mvp.main.fragments.gallery

import android.os.Handler
import com.udemy.photogallery.R
import com.udemy.photogallery.persistence.entities.ImageData
import com.udemy.photogallery.persistence.sqllite.SqlLiteDatabaseManager
import com.udemy.photogallery.persistence.webapi.ImagesService
import com.udemy.photogallery.persistence.webapi.ImagesServiceResponse
import com.udemy.photogallery.persistence.webapi.ServiceBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response


class GalleryModel(private var galleryPresenter:IGallery.Presenter):IGallery.Model {




    override fun getImagesFromServer() {

        val webApi=ServiceBuilder.buildService(ImagesService::class.java )
        val requestCall=webApi.getImages()

                requestCall.enqueue(object:retrofit2.Callback<ImagesServiceResponse>{
                    override fun onResponse(
                        call: Call<ImagesServiceResponse>,
                        httpResponse: Response<ImagesServiceResponse>
                    ) {

                        var responseImages=httpResponse.body()
                        if(responseImages!=null) {


                            GlobalScope.launch (Dispatchers.IO) {
                                for (i in 0 until responseImages.images.size) {
                                    var dbManager =
                                        SqlLiteDatabaseManager.getDatabase(galleryPresenter.getContext())
                                    var favoriteImage = dbManager.getFavoriteImageDAO()
                                        .getFavoriteImage(responseImages.images[i].imageId)

                                    if (favoriteImage != null) {
                                        responseImages.images[i].hasUserLike = true
                                    }
                                }


                                withContext(Dispatchers.Main) {
                                    galleryPresenter.onServerResponse(responseImages.images as ArrayList<ImageData>)
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<ImagesServiceResponse>, t: Throwable) {

                    }


                 }


                )








       /* Handler().postDelayed({

            var images= mutableListOf<ImageData>()
            images.add(ImageData(0, R.drawable.image_1,"Katy"))
            images.add(ImageData(1, R.drawable.image_2,"Gio"))
            images.add(ImageData(3, R.drawable.image_1,"Hello"))

            galleryPresenter.onServerResponse(images as ArrayList<ImageData>)
        },3000)*/





    }


}