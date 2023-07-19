package com.alexmumo.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import com.alexmumo.domain.repository.SearchRepository
import com.alexmumo.presentation.state.ArticleState
import com.alexmumo.presentation.state.SearchState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
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
