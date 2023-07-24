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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.alexmumo.presentation.search.view.CustomSearchBar
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel = getViewModel()
) {
    val searchState =  searchViewModel.article.value
    val search by searchViewModel.search
    Scaffold(
        topBar = {
            CustomSearchBar(text = search,
                onTextChange = {
                searchViewModel.setSearchString(it)
            }, onSearch = {
                searchViewModel.searchArticle(it.trim())
                }
            )
        }, content ={paddingValues ->
            Column(modifier = Modifier.fillMaxSize().testTag("search_tag")) {
                LazyColumn(contentPadding = paddingValues) {
                }
            }
        }
    )
}

@Composable
fun SearchList(

) {

}



@Preview
@Composable
fun SearchScreenPreview() {
    // SearchScreen()
}
