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
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.repository.SearchRepository
import com.alexmumo.presentation.state.SearchState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel constructor(private val searchRepository: SearchRepository) : ViewModel() {

    private var _search = mutableStateOf<Flow<PagingData<Article>>>(emptyFlow())
    var searchState: State<Flow<PagingData<Article>>> = _search

    var searchParam = mutableStateOf("")
    var _prevSearch = mutableStateOf("")
    var searchParamState: State<String> = searchParam

    init {
        searchParam.value = ""
    }

    fun searchArticle() {
        viewModelScope.launch {
            if (searchParam.value.isNotEmpty()) {
                _search.value = searchRepository.searchNews(queryString = searchParam.value).map { articles ->
                    articles.filter {
                        ((it.author != null || it.source != null || it.content != null || it.description != null))
                    }
                }.cachedIn(viewModelScope)
            }
        }
    }
}
