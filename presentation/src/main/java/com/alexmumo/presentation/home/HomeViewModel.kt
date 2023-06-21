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
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch


class HomeViewModel constructor(private val newsRepository: NewsRepository): ViewModel() {

    private val _category = mutableStateOf("")
    val category: State<String> = _category

    private var _news = mutableStateOf<Flow<PagingData<Article>>>(emptyFlow())
    val news: State<Flow<PagingData<Article>>> = _news

    fun setCategory(category: String) {
        _category.value = category
    }

    fun getBreakingNews(category: String) {
        viewModelScope.launch {
            try {
                val results = newsRepository.fetchNews(category = "business").cachedIn(viewModelScope)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    private fun fetchTrending(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.fetchNews(category).launchIn(viewModelScope)
        }

    }


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