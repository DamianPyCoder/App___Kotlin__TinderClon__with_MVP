package com.udemy.photogallery.mvp.main

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.udemy.photogallery.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),IMain.View {


    private var mainPresenter:IMain.Presenter=MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeBottom()
        mainPresenter.configureView()

    }

    private fun initializeBottom(){

        bottomNavigation.setOnNavigationItemSelectedListener {
            mainPresenter.onBottomClick(it)
            false
        }

    }


    override fun getContext(): Context {
        return this
    }

    override fun getActivity(): Activity {
        return this
    }

    override fun showFragment(fragment: Fragment, fragmentIndex: Int) {
        frameContent.visibility=View.GONE
        supportFragmentManager.beginTransaction().replace(R.id.frameContent,fragment).commit()

        bottomNavigation.menu.getItem(fragmentIndex).setChecked(true)


    }

    override fun showFrame() {
        frameContent.visibility=View.VISIBLE
    }

    override fun showProgressBar() {
        mainProgressBar.visibility= View.VISIBLE
    }

    override fun hideProgressBar() {
        mainProgressBar.visibility= View.GONE

    }
}