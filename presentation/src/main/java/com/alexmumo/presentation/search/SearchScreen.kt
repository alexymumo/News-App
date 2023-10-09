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
package com.alexmumo.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alexmumo.domain.model.Article
import com.alexmumo.presentation.components.NewsCard
import com.alexmumo.presentation.search.view.SearchBar
import com.alexmumo.presentation.search.view.SearchCard
import com.alexmumo.presentation.state.SearchState
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = getViewModel()
) {
    val context = LocalContext.current
    val state = viewModel.searchState.value
    SearchScreenContent(
        searchState = state,
        onSearch = { search ->
            viewModel.searchNews(search)
        },
        searchString = viewModel.searchString.value,
        previousString = { searchParam ->
            viewModel.setSearchString(searchParam)
        }
    )
}

@Composable
private fun SearchScreenContent(
    searchState: SearchState,
    onSearch: (String) -> Unit,
    searchString: String,
    previousString: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        SearchBar(
            searchString = searchString,
            previousString = previousString,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onSearch = onSearch
        )
        Spacer(modifier = Modifier.height(4.dp))
        LazyColumn(
            content = {
            }
        )
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    val navController = rememberNavController()

}

