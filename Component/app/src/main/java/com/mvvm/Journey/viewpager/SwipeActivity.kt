package com.mvvm.Journey.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.mvvm.Journey.R

class SwipeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)

        val images = listOf(
            R.drawable.album_mots_journey,
            R.drawable.album_mots_7,
            R.drawable.album_be,
            R.drawable.album_the_best,
            R.drawable.album_love_yourself,
            R.drawable.album_wings,
            R.drawable.album_face_yourself,
            R.drawable.album_forever_young,
            R.drawable.album_persona
        )

        val adapter = SwipeViewPagerAdaptor(images)
        val viewPager = findViewById<ViewPager2>(R.id.viewPagerSwipe)
        viewPager.adapter = adapter

//        orientation
        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

//        offscreenPageLimit
        viewPager.offscreenPageLimit = 3

//        DRAG
        viewPager.beginFakeDrag()
        viewPager.fakeDragBy(-10f)
    }
}