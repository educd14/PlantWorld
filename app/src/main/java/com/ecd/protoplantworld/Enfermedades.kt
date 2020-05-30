package com.ecd.protoplantworld

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.Parcelable
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enfermedades.*
import kotlinx.android.synthetic.main.content_enfermedades.*

class Enfermedades : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enfermedades)
        val intent = intent
        if (intent.extras!!.getString("enfermedad") == "apple black rot"){
            val bitmap = intent.getParcelableExtra<Parcelable>("foto") as Bitmap
            val d = BitmapDrawable(resources, bitmap)

            collf.title= "Podredumbre negra"
            collf.setExpandedTitleColor(Color.WHITE)
            collf.setCollapsedTitleTextColor((Color.WHITE))
            app_bar_image.background = d

            txtBotanico.text = "Botryosphaeria obtusa"
            txtComun.text = "Roña, Podredumbre negra"
            txtTipo.text = "Hongo"
            txtSintoma.text = "Zonas negras en hojas y racimos"
            txtSensibilidad.text = "Cultivares y frutales"
            txtTmpInfeccion.text = "10-30 ºC con humedad"
            txtGravedad.text = "Casos severos daños permanentes y muerte de planta"
            txtCultural.text = "Retiro zonas de afectadas y enterrar. Buen drenaje, rotación de cultivos"
            txtEcologico.text = "N/A"
            txtGenetico.text = "Híbridos resistentes"
            txtQuimico.text = "AZOXISTROBIN, DIFENOCONAZOL, FOLPET"


        } else if (intent.extras!!.getString("enfermedad") == "squash powdery mildew"){
            val bitmap = intent.getParcelableExtra<Parcelable>("foto") as Bitmap
            val d = BitmapDrawable(resources, bitmap)

            collf.title= "Oídio"
            collf.setExpandedTitleColor(Color.WHITE)
            collf.setCollapsedTitleTextColor((Color.WHITE))
            app_bar_image.background = d

            txtBotanico.text = "Oidium spp."
            txtComun.text = "Oídio, Blanquilla, Cenicilla, Ceniza"
            txtTipo.text = "Hongo"
            txtSintoma.text = "Manchas polvorientas gris-blancas en hojas, brotes, flores y frutos"
            txtSensibilidad.text = "Cultivares, frutales y rosales"
            txtTmpInfeccion.text = "10-20 ºC con humedad"
            txtGravedad.text = "Planta y fruto muy débil"
            txtCultural.text = "Retiro zonas de afectadas y quemar, zonas ventiladas"
            txtEcologico.text = "Extracto cola de caballo, 'Oidio stop', Propolis"
            txtGenetico.text = "Variedades resistentes"
            txtQuimico.text = "AZOXISTROBIN, BOSCALI, CIFLUFENAMID"

        }
    }
}
