package com.udemy.photogallery.persistence.sqllite

import android.content.Context
import android.util.Log
import com.udemy.photogallery.persistence.entities.FavoriteImageData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object FavoriteImagesDbManager {




    fun saveFavoriteImage(context: Context, favoriteImage:FavoriteImageData, listener:()->Unit){

        GlobalScope.launch (Dispatchers.IO){
            var dbManager=SqlLiteDatabaseManager.getDatabase(context).getFavoriteImageDAO()

            var favoriteImageInDb=dbManager.getFavoriteImage(favoriteImage.imageId)
            Log.d("UDEMY","START SAVING FAVORITE IMAGE")

            if(favoriteImageInDb!=null){
                dbManager.updateFavoriteImage(favoriteImage)

            }else{
                dbManager.insertFavoriteImage(favoriteImage)


            }

            withContext(Dispatchers.Main){
                Log.d("UDEMY","IMAGE WAS SAVED")

                listener()

            }



        }


    }


}