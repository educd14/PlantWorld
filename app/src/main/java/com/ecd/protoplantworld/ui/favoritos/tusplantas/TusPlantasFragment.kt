package com.ecd.protoplantworld.ui.favoritos.tusplantas



import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import com.ecd.protoplantworld.Planta
import com.ecd.protoplantworld.R
import kotlinx.android.synthetic.main.fragment_tusplantas.*


class TusPlantasFragment : Fragment() {
    private lateinit var mBitmap: Bitmap
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tusplantas, container, false)

        val fav1 = root.findViewById<ImageView>(R.id.fav1)
        val fav2 = root.findViewById<ImageView>(R.id.fav2)
        val fav3 = root.findViewById<ImageView>(R.id.fav3)
        fav1.setImageResource(R.drawable.heuchera)
        fav2.setImageResource(R.drawable.callisia)
        fav3.setImageResource(R.drawable.clivia_miniata)

        fav1.setOnClickListener{
            val myIntent = Intent(this.activity, Planta::class.java)
            var plantaN = "Heuchera micrantha"
            var foto = fav1.drawable
            mBitmap = fav1.drawToBitmap()
            myIntent.putExtra("plantaN", plantaN)
            myIntent.putExtra("foto", mBitmap)

            this.activity!!.startActivity(myIntent)
        }

        fav2.setOnClickListener{
            val myIntent = Intent(this.activity, Planta::class.java)
            var plantaN = "Callisia fragrans"
            mBitmap = fav2.drawToBitmap()
            myIntent.putExtra("plantaN", plantaN)
            myIntent.putExtra("foto", mBitmap)

            this.activity!!.startActivity(myIntent)
        }
        return root
    }

}