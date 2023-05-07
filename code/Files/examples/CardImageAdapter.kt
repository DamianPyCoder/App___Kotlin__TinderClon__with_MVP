package com.udemy.photogallery.mvp.main.fragments.gallery.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.udemy.photogallery.R
import com.udemy.photogallery.persistence.entities.FavoriteImageData
import com.udemy.photogallery.persistence.entities.ImageData
import com.udemy.photogallery.persistence.sqllite.FavoriteImagesDbManager
import kotlinx.android.synthetic.main.item_card_image.view.*
import java.lang.Exception

class CardImageAdapter(val context: Context, val data:ArrayList<ImageData>) :BaseAdapter()
{
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(index: Int): ImageData {
        return data[index]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(index: Int, container: View?, parent: ViewGroup?): View {

        var view=container
        var holder:DataViewHolder
        if(view==null) {
            view =LayoutInflater.from(parent!!.context).inflate(R.layout.item_card_image,parent,false)
            holder=DataViewHolder(view)
            view?.tag=holder


        }else{
            holder=view?.tag as DataViewHolder

        }
        holder.bindData(context,getItem(index))


        return view!!
    }

    class DataViewHolder(var view:View):RecyclerView.ViewHolder(view){

        internal  fun bindData(context:Context,data:ImageData){
            view.imageNameTextView.text=data.imageName


            if(data.hasUserLike){
                view.likeButton.setColorFilter(ContextCompat.getColor(view.context,R.color.colorPrimaryDark))

            }else{
                view.likeButton.setColorFilter(ContextCompat.getColor(view.context,R.color.grey_40))
            }

            view.shareButton.setOnClickListener {
                var intent= Intent()
                intent.action= Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,"${data.imageUrl} You can find more images like this in this app ... ")
                intent.type="text/plain"
                try {

                    view.context.startActivity( Intent.createChooser( intent,"Compartir con "))
                }catch(ex: Exception){
                    ex.printStackTrace()

                }
            }
            view.likeButton.setOnClickListener {

                FavoriteImagesDbManager.saveFavoriteImage(view.context, FavoriteImageData(data) ){

                    Log.d("UDEMY","DATABASE FINISHED")
                    view.likeButton.setColorFilter(ContextCompat.getColor(view.context,R.color.colorPrimaryDark))


                }


            }

            Glide.with(context)
                .load(data.imageUrl)
                .into(view.imageHolderView)
        }

    }


}