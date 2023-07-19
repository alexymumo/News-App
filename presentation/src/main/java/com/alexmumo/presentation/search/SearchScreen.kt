package com.alexmumo.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel = getViewModel()
) {
    val searchState = searchViewModel.searchState.collectAsState().value
    val searched = searchViewModel.search.value
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    // SearchScreen()
}
