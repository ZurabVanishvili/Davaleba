package com.example.davaleba.adapter

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.davaleba.Fragments.FragmentFirst
import com.example.davaleba.Fragments.FragmentSecond
import com.example.davaleba.Fragments.FragmentThird

class ViewPagerFragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter (activity){
    override fun getItemCount() = 3


    override fun createFragment(position: Int): Fragment {
       return  when(position){
            0 -> FragmentFirst()
            1 -> FragmentSecond()
            2 -> FragmentThird()
            else -> FragmentFirst()
        }

    }
}