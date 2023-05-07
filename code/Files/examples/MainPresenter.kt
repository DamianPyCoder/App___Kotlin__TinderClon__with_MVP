package com.udemy.photogallery.mvp.main

import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.udemy.photogallery.R
import com.udemy.photogallery.mvp.main.fragments.favorites.FavoritesFragment
import com.udemy.photogallery.mvp.main.fragments.gallery.GalleryFragment
import com.udemy.photogallery.mvp.main.fragments.settings.SettingsFragment

class MainPresenter(private var mainView:IMain.View):IMain.Presenter {



    private var currentIndex=0
    private var fragmentIsLoading=false
    override fun onBottomClick(menuItem: MenuItem) {
        if(fragmentIsLoading) return

        fragmentIsLoading=true
        mainView.showProgressBar()
        var fragment:Fragment?=null
        var fragmentIndex=0
        when(menuItem.itemId){

            R.id.navigationFavorites->{

                fragment=FavoritesFragment(this)
                fragmentIndex=0
            }

            R.id.navigationGallery->{

                fragment=GalleryFragment(this)
                fragmentIndex=1
            }
            R.id.navigationSettings->{

                fragment=SettingsFragment(this)
                fragmentIndex=2
            }
        }


        if(fragment!=null&&currentIndex!=fragmentIndex){
            mainView.showFragment(fragment,fragmentIndex)

        }else if(currentIndex==fragmentIndex){

            mainView.hideProgressBar()
            fragmentIsLoading=false
        }


        currentIndex=fragmentIndex

    }

    override fun fragmentWasLoaded() {
        android.os.Handler().postDelayed({

            mainView.hideProgressBar()
            mainView.showFrame()
            fragmentIsLoading=false
        },300)
    }

    override fun configureView() {
       var fragment=FavoritesFragment(this)
        mainView.showFragment(fragment,0)

    }


}