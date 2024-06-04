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
package com.alexmumo.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
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
fun SearchBarPreview() {
    // SearchBar()
}
