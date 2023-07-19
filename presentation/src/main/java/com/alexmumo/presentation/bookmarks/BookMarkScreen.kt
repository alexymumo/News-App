package com.alexmumo.presentation.bookmarks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alexmumo.presentation.bookmarks.components.BookMarkItem
import org.koin.androidx.compose.getViewModel

@Composable
fun BookMarkScreen(
    navController: NavController,
    viewModel: BookMarkViewModel = getViewModel()
) {
    val bookmarks = viewModel.bookMarkedNews.collectAsState(emptyList())
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "BookMarks",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LazyColumn {
                items(items = bookmarks.value) { bookMark ->
                    BookMarkItem(bookMarkEntity = bookMark)
                }
            }
        }
    }
}

@Preview
@Composable
fun BookMarkScreenPreview() {
    val navController = rememberNavController()
    BookMarkScreen(navController = navController)
}
