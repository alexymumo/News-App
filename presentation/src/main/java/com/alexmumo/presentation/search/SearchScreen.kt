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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alexmumo.presentation.components.NewsCard

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val searchState = viewModel.searchState.value
    SearchContent(
        searchViewModel = viewModel,
        onSearch = { search ->
            viewModel.searchNews(search)
        },
        currentString = viewModel.searchString.value,
        onSearchTextChange = { text ->
            viewModel.setSearchString(text)
        },
        searchState = searchState
    )
}

@Composable
fun SearchContent(
    searchViewModel: SearchViewModel,
    onSearch: (String) -> Unit,
    currentString: String,
    onSearchTextChange: (String) -> Unit,
    searchState: SearchState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("search_screen_test_tag")
    ) {
        CustomSearchBar(
            modifier = Modifier.fillMaxWidth().padding(all = 5.dp).wrapContentHeight(),
            onSearch = onSearch,
            onSearchTextChange = onSearchTextChange,
            currentString = currentString
        )
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumn {
            items(searchState.data) { article ->
                NewsCard(onNavigate = {}, article = article)
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {},
    onSearchTextChange: (String) -> Unit,
    currentString: String
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = currentString,
        onValueChange = { onSearchTextChange(it) },
        placeholder = { Text(text = "Search News..") },
        modifier = modifier
            .fillMaxWidth()
            .testTag("search_text_tag")
            .shadow(4.dp, CircleShape),
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            autoCorrect = true,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        trailingIcon = {
            IconButton(onClick = {
                onSearch(currentString)
                keyboardController?.hide()
            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search")
            }
        },
        keyboardActions = KeyboardActions {
            keyboardController?.hide()
            onSearch(currentString)
        }
    )
}

@Preview
@Composable
fun SearchScreenPreview() {
    val navController = rememberNavController()
}
