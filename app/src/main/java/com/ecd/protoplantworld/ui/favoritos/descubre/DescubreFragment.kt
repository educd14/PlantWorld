package com.ecd.protoplantworld.ui.favoritos.descubre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.ecd.protoplantworld.R


class DescubreFragment : Fragment(){

    lateinit var mPager: ViewPager
    var path: IntArray = intArrayOf(R.drawable.clivia_miniata,R.drawable.agapanto,R.drawable.ficus_benjamina_5_0,R.drawable.crisantemo,R.drawable.hiedra,R.drawable.abelia_grandiflora,R.drawable.juniperus_squamata,R.drawable.hyacinthus_orientalis,R.drawable.rhododendron)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_descubre, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPager = view.findViewById(R.id.view1) as ViewPager
        var adapter: PagerAdapter = PageView(context!!,path)
        mPager.adapter = adapter
        mPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int){

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int){

            }
            override fun onPageSelected(position: Int) {

            }

        })
    }






    }


