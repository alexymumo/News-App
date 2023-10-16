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

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.domain.repository.SearchRepository
import com.alexmumo.presentation.state.SearchState
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchViewModel constructor(private val searchRepository: SearchRepository) : ViewModel() {
    private val _searchState = mutableStateOf(SearchState())
    val searchState: State<SearchState> = _searchState

    private val _searchString = mutableStateOf("")
    val searchString: State<String> = _searchString

    fun setSearchString(search: String) {
        _searchString.value = search
        _searchState.value = searchState.value.copy(
            articles = emptyFlow(),
            errors = null
        )
    }

    fun searchNews(value: String) {
        viewModelScope.launch {
            if (value.isBlank()) {
                Timber.e("Failed")
            }
            _searchState.value = searchState.value.copy(
                articles = emptyFlow(),
                isLoading = false
            )
        }
    }
}

/*val searchNews = news.value
    if (searchNews.isNotEmpty()) {
        viewModelScope.launch {
            searchRepository.searchNews(queryString = searchNews).collect { response ->
                _searchState.value = searchState.value.copy(
                    isLoading = false,
                    articles = emptyFlow()
                )
            }
        }
    }*/
