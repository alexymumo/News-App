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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.alexmumo.presentation.search.SearchViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchBar(
    onSearch: () -> Unit,
    searchViewModel: SearchViewModel = getViewModel(),
    modifier: Modifier = Modifier
) {
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
    )
}