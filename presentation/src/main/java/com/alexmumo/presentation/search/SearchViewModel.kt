package com.alexmumo.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.filter
import com.alexmumo.domain.repository.SearchRepository
import com.alexmumo.presentation.state.ArticleState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SearchViewModel constructor(private val searchRepository: SearchRepository) : ViewModel() {

    private val _search = MutableStateFlow(ArticleState())
    val search = _search.asStateFlow()

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
