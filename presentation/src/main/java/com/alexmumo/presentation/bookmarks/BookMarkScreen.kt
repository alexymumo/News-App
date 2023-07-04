package com.alexmumo.presentation.bookmarks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alexmumo.presentation.bookmarks.components.BookMarkItem
import org.koin.androidx.compose.getViewModel

@Composable
fun BookMarkScreen(
    viewModel: BookMarkViewModel = getViewModel()
){
    val bookmarks = viewModel.bookMarkedNews.collectAsState(emptyList())
    Scaffold { paddingValues ->
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
    BookMarkScreen()
}


