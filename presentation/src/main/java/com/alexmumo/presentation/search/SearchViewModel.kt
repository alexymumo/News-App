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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch

class SearchViewModel constructor(private val searchRepository: SearchRepository) : ViewModel() {
    private val _searchState = MutableStateFlow(SearchState())
    val searchState: StateFlow<SearchState> = _searchState.asStateFlow()

    private val _news = mutableStateOf("")
    val news: State<String> = _news

    fun setSearchString(search: String) {
        _news.value = search
    }

    fun searchNews() {
        _searchState.value = searchState.value.copy(
            isLoading = false
        )
        val searchNews = news.value
        if (searchNews.isNotEmpty()) {
            viewModelScope.launch {
                searchRepository.searchNews(queryString = searchNews).collect { response ->
                    _searchState.value = searchState.value.copy(
                        isLoading = false,
                        articles = emptyFlow()
                    )
                }
            }
        }
    }
}
