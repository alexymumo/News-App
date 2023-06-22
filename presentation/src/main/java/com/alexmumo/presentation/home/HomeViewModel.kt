package com.alexmumo.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.alexmumo.common.Resource
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.repository.NewsRepository
import com.alexmumo.presentation.state.ArticleState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber


class HomeViewModel constructor(private val newsRepository: NewsRepository): ViewModel() {

    private val _category = MutableStateFlow<String?>(null)
    val category = _category.asStateFlow()

    private val _uiState = MutableStateFlow(ArticleState())
    val uiState = _uiState.asStateFlow()

    fun setCategory(category: String) {
        _category.value = category
    }

    init {
        getBreakingNews("business")
    }

    private fun getBreakingNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val breaking = newsRepository.fetchNews(category = category).cachedIn(viewModelScope)
                _uiState.update { it.copy(articles = breaking, isLoading = false) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    /*
    private fun fetchTrending(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val trending  = newsRepository.fetchNews(category).cachedIn(viewModelScope)
                trending.collectLatest {
                    _news.value
                }
            } catch (e: Exception) {
                Timber.d("Error", e.localizedMessage)
            }
        }
    }
    */


    private fun fetchSports(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.fetchNews(category).launchIn(viewModelScope)
        }

    }

    private fun fetchBusiness(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.fetchNews(category)
        }
    }

}