package com.udemy.photogallery.persistence.sqllite

import androidx.room.*
import com.udemy.photogallery.persistence.entities.FavoriteImageData


@Dao
interface FavoriteImageDAO {

    @Insert
    fun insertFavoriteImage(favoriteImageData:FavoriteImageData)

    @Query("SELECT * FROM favorte_image")
    fun getFavoriteImages():List<FavoriteImageData>?


    @Query("SELECT * FROM favorte_image WHERE imageId=:imageId")
    fun getFavoriteImage(imageId:Int):FavoriteImageData?

    @Delete
    fun deleteFavoriteImage(favoriteImageData:FavoriteImageData)

    @Update
    fun updateFavoriteImage(favoriteImageData:FavoriteImageData)
}