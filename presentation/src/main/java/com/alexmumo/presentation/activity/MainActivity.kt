package com.alexmumo.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.alexmumo.presentation.common.theme.NewsAppTheme
import com.alexmumo.presentation.navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                val nav = rememberNavController()
                Navigation(navController = nav)
            }
        }
    }
}



