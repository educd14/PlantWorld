package com.ecd.protoplantworld.ui.favoritos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager

import com.ecd.protoplantworld.R
import com.google.android.material.tabs.TabLayout


class FavoritosFragment : Fragment() {

    private lateinit var favoritosViewModel: FavoritosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoritosViewModel = ViewModelProviders.of(this).get(FavoritosViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoritosViewModel =
            ViewModelProviders.of(this).get(FavoritosViewModel::class.java)
        val root = inflater.inflate(R.layout.viewpage_favoritos, container, false)

        val vp = root.findViewById<ViewPager>(R.id.view_pager)
        val tabs = root.findViewById<TabLayout>(R.id.tabs)
        val fragmentAdapter = SectionsPagerAdapter(childFragmentManager)
        vp.adapter = fragmentAdapter

        tabs.setupWithViewPager(vp)


      //  val tab = tabs.getTabAt(1)
      //  tab?.select()

       // val textView: TextView = root.findViewById(R.id.text_notifications)
       // favoritosViewModel.text.observe(this, Observer {
       //     textView.text = it
      //  })
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): FavoritosFragment{
            return FavoritosFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}