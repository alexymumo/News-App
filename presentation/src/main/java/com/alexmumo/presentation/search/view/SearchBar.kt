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

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {},
    searchString: String,
    previousString: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = searchString,
        onValueChange = {
            previousString(it)
        },
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = "Search..") },
        trailingIcon = {
            IconButton(onClick = {
                onSearch(searchString)
            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search")
            }
        },
        keyboardActions = KeyboardActions {
            keyboardController?.hide()
            onSearch(searchString)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search,
            autoCorrect = true
        ),
        maxLines = 1,
        shape = RoundedCornerShape(size = 8.dp),
        singleLine = true,
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    // SearchBar()
}
