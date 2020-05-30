package com.ecd.protoplantworld.ui.enfermedades

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
import com.ecd.protoplantworld.Enfermedades
import com.ecd.protoplantworld.Neuronal.Classifier
import com.ecd.protoplantworld.R
import com.ecd.protoplantworld.Planta
import com.ecd.protoplantworld.ui.inicio.InicioViewModel
import java.io.IOException

class EnfermedadesFragment : Fragment() {

    private lateinit var enfermedadesViewModel: EnfermedadesViewModel
    var enfermedad: String = ""
    private lateinit var inicioViewModel: InicioViewModel


    private lateinit var mClassifier: Classifier
    private lateinit var mBitmap: Bitmap
    private lateinit var mBitmap1: Bitmap

    private val mCameraRequestCode2 = 1
    private val mGalleryRequestCode2 = 3

    private val ancho = 224
    private val alto = 224
    private val mModelPath = "enfermedades.tflite"
    private val mLabelPath = "enfermedades_labels.txt"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_enfermedades, container, false)

        val btncamera2 = root.findViewById<Button>(R.id.btncamera2)
        btncamera2.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(callCameraIntent, mCameraRequestCode2)
        }

        val btngaleria2 = root.findViewById<Button>(R.id.btngaleria2)
        btngaleria2.setOnClickListener {
            val callGalleryIntent = Intent(Intent.ACTION_PICK)
            callGalleryIntent.type = "image/*"
            startActivityForResult(callGalleryIntent, mGalleryRequestCode2)
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
        if(requestCode == mCameraRequestCode2){

            if(resultCode == Activity.RESULT_OK && data != null) {
                mBitmap = data.extras!!.get("data") as Bitmap
                mBitmap1 = scaleImage(mBitmap)
                val results = mClassifier.recognizeImage(mBitmap1).firstOrNull()
                if (results?.title == "apple black rot") {

                    enfermedad = "apple black rot"
                    val myIntent = Intent(this.activity, Enfermedades::class.java)
                    myIntent.putExtra("enfermedad", enfermedad)
                    myIntent.putExtra("foto", mBitmap)

                    val fav2 = view.findViewById<ImageView>(R.id.fav2)
                    val d = BitmapDrawable(resources, mBitmap1)
                    fav2.background = d
                    this.activity!!.startActivity(myIntent)
                }else if (results?.title == "squash powdery mildew"){

                    enfermedad = "squash powdery mildew"
                    val myIntent = Intent(this.activity, Enfermedades::class.java)
                    myIntent.putExtra("enfermedad", enfermedad)
                    myIntent.putExtra("foto", mBitmap)
                    this.activity!!.startActivity(myIntent)
                }
            } else {
                Toast.makeText(this.activity, "Camera cancel..", Toast.LENGTH_LONG).show()
            }
        } else if(requestCode == mGalleryRequestCode2) {
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
                if (results?.title == "apple black rot") {

                    enfermedad = "apple black rot"
                    val myIntent = Intent(this.activity, Enfermedades::class.java)
                    myIntent.putExtra("enfermedad", enfermedad)
                    myIntent.putExtra("foto", mBitmap1)
                    this.activity!!.startActivity(myIntent)
                }else if (results?.title == "squash powdery mildew"){

                    enfermedad = "squash powdery mildew"
                    val myIntent = Intent(this.activity, Enfermedades::class.java)
                    myIntent.putExtra("enfermedad", enfermedad)
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