package com.alexmumo.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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

    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(
            query = text,
            onQueryChange = {text = it},
            onSearch = {active = false},
            active = active,
            onActiveChange = {active = it},
            placeholder = {
                Text(text = "Search Articles")
            },
            trailingIcon = {
                Icon(Icons.Default.Search, contentDescription = "search")
            },
            modifier = Modifier.fillMaxWidth()
        ) {

        }
    }
}


@Preview
@Composable
fun SearchScreenPreview() {
    //SearchScreen()
}