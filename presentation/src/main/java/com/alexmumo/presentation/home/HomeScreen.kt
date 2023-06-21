package com.alexmumo.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    onNavigate:() -> Unit,
    navController: NavController,
    homeViewModel: HomeViewModel = koinViewModel()
) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("News App") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)

        ) {
            LazyColumn() {
                //ArticleCard()
            }

        }
    }
}

@Preview
@Composable
fun HomeScreePreview() {
    //HomeScreen()
}