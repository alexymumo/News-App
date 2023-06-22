package com.alexmumo.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    navController: NavController
    //searchViewModel: SearchViewModel = koinViewModel()
) {
    //val searchState by searchViewModel.search
    //val searched = searchViewModel.search.value.collectAsLazyPagingItems()
    Column(modifier = Modifier.fillMaxSize()) {

    }
}


@Preview
@Composable
fun SearchScreenPreview() {
    //SearchScreen()
}