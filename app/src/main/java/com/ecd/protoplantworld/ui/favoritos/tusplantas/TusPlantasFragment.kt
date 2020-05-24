package com.ecd.protoplantworld.ui.favoritos.tusplantas



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.ecd.protoplantworld.R
import kotlinx.android.synthetic.main.fragment_tusplantas.*


class TusPlantasFragment : Fragment() {
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
        return root
    }

}