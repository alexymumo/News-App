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
package com.alexmumo.presentation.search.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.alexmumo.presentation.search.SearchViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchBar(
    onSearch: () -> Unit,
    searchViewModel: SearchViewModel = getViewModel(),
    modifier: Modifier = Modifier
) {
    /*
    var text: String by remember { mutableStateOf("") }
    TextField(
        value = text,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        maxLines = 1,
        keyboardActions = KeyboardActions(
            onSearch ={
                if (searchViewModel.searchParamState.value.isNotEmpty()) {
                    searchViewModel.searchParam.value = text
                    onSearch()
                }
            }
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        singleLine = true,
        placeholder = {

        },
        onValueChange = { value ->
            text = if (value.trim().isNotEmpty())  value else ""
                searchViewModel.searchParam.value = text

        },
        trailingIcon = {
            IconButton(onClick = {
                if (searchViewModel.searchParam.value.trim().isNotEmpty()) {
                    searchViewModel.searchParam.value = text
                    onSearch()
                }
            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
        }
    )*/
}
