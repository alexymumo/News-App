/*
 * Copyright 2023 News-App
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alexmumo.presentation.activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.alexmumo.presentation.common.theme.NewsAppTheme
import com.alexmumo.presentation.main.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                MainScreen()
            }
        }
    }
}

/*
    /*
                Surface(
                    modifier = Modifier.fillMaxSize()

                ) {
                    MainScreen()
                }
                */
//color = MaterialTheme.colorScheme.background
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

 */

@Preview
@Composable
fun MainScreenPreview() {
    // MainScreen()
}
