package com.udemy.photogallery.persistence.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="favorte_image")
class FavoriteImageData() {

    @PrimaryKey(autoGenerate =false)
    @ColumnInfo(name="imageId")
    var imageId:Int=0
    @ColumnInfo(name="imageUrl")
    var imageUrl=""
    @ColumnInfo(name="imageName")
    var imageName=""


    constructor(imageData:ImageData) : this() {
        this.imageId=imageData.imageId
        this.imageUrl=imageData.imageUrl
        this.imageName=imageData.imageName

    }
}