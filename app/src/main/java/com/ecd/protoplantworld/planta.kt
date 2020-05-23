package com.ecd.protoplantworld

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_planta.*
import android.graphics.Bitmap
import android.graphics.Color


import android.graphics.drawable.BitmapDrawable
import android.os.Parcelable


class planta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planta)
        val intent = intent
        if (intent.extras!!.getString("plantaN") == "Heuchera micrantha"){
            val bitmap = intent.getParcelableExtra<Parcelable>("foto") as Bitmap
            val d = BitmapDrawable(resources, bitmap)

            coll.title= intent.extras!!.getString("plantaN")
            coll.setExpandedTitleColor(Color.WHITE)
            coll.setCollapsedTitleTextColor((Color.WHITE))
            app_bar_image.background = d


        } else if (intent.extras!!.getString("plantaN") == "Callisia fragrans"){
            val bitmap = intent.getParcelableExtra<Parcelable>("foto") as Bitmap
            val d = BitmapDrawable(resources, bitmap)

            coll.title= intent.extras!!.getString("plantaN")
            coll.setExpandedTitleColor(Color.WHITE)
            coll.setCollapsedTitleTextColor((Color.WHITE))
            app_bar_image.background = d

        }
    }
}
