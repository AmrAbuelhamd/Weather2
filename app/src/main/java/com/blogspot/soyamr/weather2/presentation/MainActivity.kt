package com.blogspot.soyamr.weather2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blogspot.soyamr.weather2.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}