package com.ecd.protoplantworld

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_planta.*
import android.graphics.Bitmap
import android.graphics.Color


import android.graphics.drawable.BitmapDrawable
import android.os.Parcelable
import kotlinx.android.synthetic.main.content_planta.*


class Planta : AppCompatActivity() {

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

            txtBotanico.text = "Heuchera micrantha"
            txtComun.text = "Heuchera, Campanillas de coral"
            txtSuelo.text = "Arena, arcilla, buen drenaje, neutral"
            txtAgua.text = "Húmeda, regularmente"
            txtSol.text = "Sombra parcial"
            txtAbono.text = "Otoño, primavera, verano cada 15 días"
            txtFloracion.text = "Primavera, verano"
            txtPoda.text = "Hojas viejas, flores marchitadas"
            txtEnfermedades.text = "Moho, gorgojos de la vid"


        } else if (intent.extras!!.getString("plantaN") == "Callisia fragrans"){
            val bitmap = intent.getParcelableExtra<Parcelable>("foto") as Bitmap
            val d = BitmapDrawable(resources, bitmap)

            coll.title= intent.extras!!.getString("plantaN")
            coll.setExpandedTitleColor(Color.WHITE)
            coll.setCollapsedTitleTextColor((Color.WHITE))
            app_bar_image.background = d

            txtBotanico.text = "Callisia fragrans"
            txtComun.text = "Falsa bromelia"
            txtSuelo.text = "Arcilloso, fértil, buen drenaje, neutral"
            txtAgua.text = "Promedio, regularmente sin acumulación"
            txtSol.text = "Sombra parcial"
            txtAbono.text = "Primavera, verano cada 30 días"
            txtFloracion.text = "Primavera, verano, otoño"
            txtPoda.text = "Invierno"
            txtEnfermedades.text = "Resistente, cochinillas"

        }
    }
}
