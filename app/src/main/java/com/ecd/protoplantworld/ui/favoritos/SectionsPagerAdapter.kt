package com.ecd.protoplantworld.ui.favoritos

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ecd.protoplantworld.ui.favoritos.descubre.DescubreFragment
import com.ecd.protoplantworld.ui.favoritos.tusplantas.TusPlantasFragment


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fm: FragmentManager?) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        return when(position){
            0 -> {TusPlantasFragment()}
            else -> {
                return DescubreFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return when(position){
            0-> "Tus plantas"
            else-> {
                return "Descubre"
            }
        }
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}