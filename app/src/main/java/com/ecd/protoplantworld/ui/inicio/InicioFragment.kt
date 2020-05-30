package com.ecd.protoplantworld.ui.inicio

import android.app.Activity
import android.content.Intent
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

import android.widget.Toast
import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProviders
import com.ecd.protoplantworld.Neuronal.Classifier
import com.ecd.protoplantworld.R
import com.ecd.protoplantworld.Planta

import java.io.IOException







class InicioFragment : Fragment() {

    var plantaN: String = ""
    private lateinit var inicioViewModel: InicioViewModel


    private lateinit var mClassifier: Classifier
    private lateinit var mBitmap: Bitmap
    private lateinit var mBitmap1: Bitmap

    private val mCameraRequestCode = 0
    private val mGalleryRequestCode = 2

    private val ancho = 168
    private val alto = 300
    private val mModelPath = "Plantworld.tflite"
    private val mLabelPath = "plant_labels.txt"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicioViewModel =
            ViewModelProviders.of(this).get(InicioViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_inicio, container, false)

        val btncamera = root.findViewById<Button>(R.id.btncamera)
        btncamera.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(callCameraIntent, mCameraRequestCode)
        }

        val btngaleria = root.findViewById<Button>(R.id.btngaleria)
        btngaleria.setOnClickListener {
            val callGalleryIntent = Intent(Intent.ACTION_PICK)
            callGalleryIntent.type = "image/*"
            startActivityForResult(callGalleryIntent, mGalleryRequestCode)
        }


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val assetManager: AssetManager
        assetManager = this.activity!!.assets

        mClassifier = Classifier(assetManager, mModelPath, mLabelPath, ancho, alto)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val view = LayoutInflater.from(this.activity).inflate(R.layout.fragment_tusplantas, null)
        if(requestCode == mCameraRequestCode){

            if(resultCode == Activity.RESULT_OK && data != null) {
                mBitmap = data.extras!!.get("data") as Bitmap
                mBitmap1 = scaleImage(mBitmap)
                val results = mClassifier.recognizeImage(mBitmap1).firstOrNull()
                if (results?.title == "Callisia fragrans") {

                    plantaN = "Callisia fragrans"
                    val myIntent = Intent(this.activity, Planta::class.java)
                    myIntent.putExtra("plantaN", plantaN)
                    myIntent.putExtra("foto", mBitmap)

                    this.activity!!.startActivity(myIntent)
                }else if (results?.title == "Heuchera micrantha"){

                    plantaN = "Heuchera micrantha"
                    val myIntent = Intent(this.activity, Planta::class.java)
                    myIntent.putExtra("plantaN", plantaN)
                    myIntent.putExtra("foto", mBitmap)
                    this.activity!!.startActivity(myIntent)
                }
            } else {
                Toast.makeText(this.activity, "Camera cancel..", Toast.LENGTH_LONG).show()
            }
        } else if(requestCode == mGalleryRequestCode) {
            if (data != null) {
                val uri = data.data

                try {
                    mBitmap = MediaStore.Images.Media.getBitmap(this.activity!!.contentResolver, uri)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                println("Success!!!")
                mBitmap1 = scaleImage(mBitmap)
                val results = mClassifier.recognizeImage(mBitmap1).firstOrNull()
                if (results?.title == "Callisia fragrans") {

                    plantaN = "Callisia fragrans"
                    val myIntent = Intent(this.activity, Planta::class.java)
                    myIntent.putExtra("plantaN", plantaN)
                    myIntent.putExtra("foto", mBitmap1)
                    this.activity!!.startActivity(myIntent)
                }else if (results?.title == "Heuchera micrantha"){

                    plantaN = "Heuchera micrantha"
                    val myIntent = Intent(this.activity, Planta::class.java)
                    myIntent.putExtra("plantaN", plantaN)
                    myIntent.putExtra("foto", mBitmap1)

                    this.activity!!.startActivity(myIntent)
                }

            }
        } else {
            Toast.makeText(this.activity, "Unrecognized request code", Toast.LENGTH_LONG).show()

        }
    }

    fun scaleImage(bitmap: Bitmap?): Bitmap {
        val orignalWidth = bitmap!!.width
        val originalHeight = bitmap.height
        val scaleWidth = ancho.toFloat() / orignalWidth
        val scaleHeight = alto.toFloat() / originalHeight
        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)
        return Bitmap.createBitmap(bitmap, 0, 0, orignalWidth, originalHeight, matrix, true)
    }

}

