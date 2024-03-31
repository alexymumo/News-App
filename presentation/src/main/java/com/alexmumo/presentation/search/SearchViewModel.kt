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
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchRepository: SearchRepository) : ViewModel() {
    // private val _searchUiState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    // val searchUiState: StateFlow<UiState<List<Article>>> = _searchUiState

    private val _searchString = mutableStateOf("")
    val searchString: State<String> = _searchString

    private val _searchState = mutableStateOf(SearchState())
    val searchState: State<SearchState> = _searchState

    fun setSearchString(value: String) {
        _searchString.value = value
        _searchState.value = searchState.value.copy(
            error = null,
            data = emptyList()
        )
    }

    fun searchNews(searchString: String) {
        viewModelScope.launch {
//            _searchState.value = searchState.value.copy(
//                isLoading = true
//            )
            val response = searchRepository.searchNews(searchString)
            _searchState.value = searchState.value.copy(
                isLoading = false,
                data = response ?: emptyList()
            )
        }
    }

//
//    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
//    fun searchNews() {
//        viewModelScope.launch {
//            query.debounce(20).filter {
//                if (it.isNotEmpty() && it.length >= 10) {
//                    return@filter true
//                } else {
//                    _searchUiState.value = UiState.Success(emptyList())
//                    return@filter false
//                }
//            }
//                .distinctUntilChanged().flatMapLatest {
//                    _searchUiState.value = UiState.Loading
//                    return@flatMapLatest searchRepository.searchNews(it).catch { e ->
//                        _searchUiState.value = UiState.Error(e.toString())
//                    }
//                }.flowOn(Dispatchers.IO)
//                .collect {
//                    if (it.isEmpty()) {
//                        _searchUiState.value = UiState.Error("Not Found")
//                    } else {
//                        _searchUiState.value = UiState.Success(it)
//                    }
//                }
//        }
//    }
}

data class SearchState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: List<Article> = emptyList()
)
