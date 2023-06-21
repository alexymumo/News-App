package com.alexmumo.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SearchViewModel constructor(private val newsRepository: NewsRepository): ViewModel() {

    private var _search = mutableStateOf<Flow<PagingData<Article>>>(emptyFlow())
    val search: State<Flow<PagingData<Article>>> = _search

    fun searchArticle(queryString: String) {
        viewModelScope.launch {
            newsRepository.searchNews(queryString).map { articles ->
                articles.filter {
                    it.title.contains(queryString)
                }
            }.cachedIn(viewModelScope)
        }
    }
}