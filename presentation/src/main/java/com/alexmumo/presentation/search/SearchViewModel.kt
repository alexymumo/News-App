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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchRepository: SearchRepository) : ViewModel() {
    private val _searchUiState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    val searchUiState: StateFlow<UiState<List<Article>>> = _searchUiState

    private val query = MutableStateFlow("")

    init {
        searchNews()
    }

    fun searchNewsByQuery(queryString: String) {
        query.value = queryString
    }

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    fun searchNews() {
        viewModelScope.launch {
            query.debounce(20).filter {
                if (it.isNotEmpty() && it.length >= 10) {
                    return@filter true
                } else {
                    _searchUiState.value = UiState.Success(emptyList())
                    return@filter false
                }
            }
                .distinctUntilChanged().flatMapLatest {
                    _searchUiState.value = UiState.Loading
                    return@flatMapLatest searchRepository.searchNews(it).catch { e ->
                        _searchUiState.value = UiState.Error(e.toString())
                    }
                }.flowOn(Dispatchers.IO)
                .collect {
                    if (it.isEmpty()) {
                        _searchUiState.value = UiState.Error("Not Found")
                    } else {
                        _searchUiState.value = UiState.Success(it)
                    }
                }
        }
    }
}
