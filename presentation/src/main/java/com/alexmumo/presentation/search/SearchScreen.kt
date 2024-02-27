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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alexmumo.domain.model.Article
import com.alexmumo.presentation.components.NewsCard

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val uiState: UiState<List<Article>> by viewModel.searchUiState.collectAsStateWithLifecycle()
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        androidx.compose.material3.SearchBar(
            query = text,
            onQueryChange = {
                text = it
                viewModel.searchNewsByQuery(it)
            },
            onSearch = {
                active = false
            },
            active = active,
            onActiveChange ={
                active = it
            },
            content = {
                SearchContent(uiState = uiState, searchViewModel = viewModel)
            }
        )
    }
}


@Composable
fun SearchContent(
    uiState: UiState<List<Article>>,
    searchViewModel: SearchViewModel
) {
    when(uiState) {
        is UiState.Success -> {
            ArticleList(articles = uiState.data)
        }
        is UiState.Error -> {

        }
        is UiState.Loading ->{

        }
    }
}

@Composable
fun ArticleList(articles: List<Article>) {
    LazyColumn {
        items(articles.size) {index ->
            NewsCard(onNavigate = {}, article = articles[index])
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    val navController = rememberNavController()
}
