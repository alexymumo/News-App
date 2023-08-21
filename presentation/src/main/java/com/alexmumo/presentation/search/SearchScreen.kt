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

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SearchScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
        }
    ) {

    }
}



@Preview
@Composable
fun SearchScreenPreview() {
    val navController = rememberNavController()
    SearchScreen(navController = navController)
}

/*
  searchViewModel: SearchViewModel = getViewModel(),
  article: Article


  val result = searchViewModel.searchState.value.collectAsLazyPagingItems()

  Column(
      modifier = Modifier.fillMaxSize()
  ) {
      SearchBar(
          onSearch = { searchViewModel.searchArticle() }
      )

      LazyColumn(
          modifier = Modifier.fillMaxSize(),
          contentPadding = PaddingValues(5.dp)
      ) {
          when(result.loadState.refresh) {
              is LoadState.NotLoading -> {
                  items(result.itemCount) {
                      NewsCard(onNavigate = {}, article = article)
                  }
              }
              is LoadState.Loading -> {

              }
              is LoadState.Error -> {


              }
              else -> {}
          }
      }
  }
  */


