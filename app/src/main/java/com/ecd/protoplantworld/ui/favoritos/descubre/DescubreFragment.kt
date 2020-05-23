package com.ecd.protoplantworld.ui.favoritos.descubre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.ecd.protoplantworld.R


class DescubreFragment : Fragment(){

    lateinit var mPager: ViewPager
    var path: IntArray = intArrayOf(R.drawable.ic_dashboard_black_24dp,R.drawable.ic_home_black_24dp,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,R.drawable.ic_notifications_black_24dp)

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
                Toast.makeText(context, path[position], Toast.LENGTH_LONG).show()
            }
        })
    }






    }


