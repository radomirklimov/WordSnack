package com.example.wordsnack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.wordsnack.room.WordViewModel
import com.example.wordsnack.ui_components.MainPage
import com.example.wordsnack.ui_components.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: WordViewModel by viewModels()
        val mainPage = MainPage

        enableEdgeToEdge()
        setContent {
            Navigation(viewModel)
        }
    }

}
