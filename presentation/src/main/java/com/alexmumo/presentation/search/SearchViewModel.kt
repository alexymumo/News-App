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
import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import com.alexmumo.domain.repository.SearchRepository
import com.alexmumo.presentation.state.SearchState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel constructor(private val searchRepository: SearchRepository) : ViewModel() {

    private val _searchState = MutableStateFlow(SearchState())
    val searchState: StateFlow<SearchState> = _searchState.asStateFlow()

    private val _search = mutableStateOf("")
    val search: State<String> = _search

    fun setSearch(searched: String) {
        _search.value = searched
    }

    fun searchArticles(search: String) {
        viewModelScope.launch {
            try {
                val response = searchRepository.searchNews(queryString = search).cachedIn(viewModelScope)
                _searchState.update { it.copy(articles = response, isLoading = false) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun searchArticle(queryString: String) {
        viewModelScope.launch {
            searchRepository.searchNews(queryString).map { articles ->
                articles.filter {
                    it.title!!.contains(queryString)
                }
            }.cachedIn(viewModelScope)
        }
    }
}
