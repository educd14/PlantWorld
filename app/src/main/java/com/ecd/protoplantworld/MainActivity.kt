package com.ecd.protoplantworld

import android.app.Activity
import android.content.Intent
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.ecd.protoplantworld.Neuronal.Classifier
import kotlinx.android.synthetic.main.fragment_inicio.*
import java.io.IOException

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)


        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_enfermedades, R.id.navigation_inicio, R.id.navigation_favoritos
            )
        )
        navView.setupWithNavController(navController)
    }

}