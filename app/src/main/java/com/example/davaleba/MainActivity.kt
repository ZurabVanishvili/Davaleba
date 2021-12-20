package com.example.davaleba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.davaleba.Fragments.FragmentThird
import com.example.davaleba.adapter.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var tablayouts : TabLayout
    private lateinit var viewpager2 : ViewPager2
    private lateinit var ViewPagerFragmentAdapter : ViewPagerFragmentAdapter
    private lateinit var thirdLayout : FragmentThird
    private lateinit var addButton : Button
    private lateinit var note :EditText
    private lateinit var notes :TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("Helicopter" , MODE_PRIVATE)
        val text =  sharedPreferences.getString("Zuka" , "")
        notes.text = text
        init()
        addButton.setOnClickListener{
            var notee = note.text.toString()
            var text = notes.text.toString()
            var resultt = notee + '\n' + text
            notes.text = resultt
            sharedPreferences.edit().putString("Zuka" , resultt).apply()



        }

        viewpager2.adapter = ViewPagerFragmentAdapter
        TabLayoutMediator(tablayouts , viewpager2){tab ,position ->
            tab.text = "tab ${position+1}"
        }.attach()

    }
    private fun init(){
        tablayouts = findViewById(R.id.tablayouts)
        viewpager2 = findViewById(R.id.viewpager2)
        ViewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)
        addButton = findViewById(R.id.addButton)
        note = findViewById(R.id.Note)
        notes = findViewById(R.id.Notes)

    }

}