package com.trendster.slidingdrawer

import android.graphics.Color
import android.os.Bundle
import android.system.Os.close
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerLayout
import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerToggle


class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var content1 : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        content1 = findViewById(R.id.content1)

        drawerLayout.setScrimColor(Color.TRANSPARENT)

//        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL;


        var actionBar : ActionBarDrawerToggle = object  : ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_close, R.string.navigation_drawer_open){

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val slideX: Float = drawerView.width * slideOffset

                content1.translationX = -slideX
                content1.scaleX = 1-(slideOffset/ 3f)      //width
                content1.scaleY = 1-(slideOffset/10f)       //height
            }
        }

        drawerLayout.addDrawerListener(actionBar)
    }

}

