package com.alexmumo.presentation.activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.alexmumo.presentation.common.theme.NewsAppTheme
import com.alexmumo.presentation.navigation.BottomNav
import com.alexmumo.presentation.navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Navigation(navController = navController)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNav(navController = navController)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Navigation(navController = navController)
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
