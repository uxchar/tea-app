package com.example.teaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BrewTimer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brew_timer)

        val actionBar = supportActionBar
        actionBar!!.title = "Tea Brewing Info"

        actionBar.setDisplayHomeAsUpEnabled(true)
    }

}