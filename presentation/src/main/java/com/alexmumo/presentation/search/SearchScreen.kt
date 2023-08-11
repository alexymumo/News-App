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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexmumo.domain.model.Article
import com.alexmumo.presentation.components.NewsCard
import com.alexmumo.presentation.search.view.SearchBar
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel = getViewModel(),
    article: Article
) {
    //val searchState =  searchViewModel.searchState.value
    val result = searchViewModel.searchState.value.collectAsLazyPagingItems()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchBar(
            onSearch = {
                searchViewModel.searchArticle()
            }
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            when(result.loadState.refresh) {
                is LoadState.NotLoading -> {
                    items(result.itemCount) {
                        NewsCard(onNavigate = {}, article = article)
                    }
                }
                else -> {}
            }
        }
    }
}



@Preview
@Composable
fun SearchScreenPreview() {
    // SearchScreen()
}


