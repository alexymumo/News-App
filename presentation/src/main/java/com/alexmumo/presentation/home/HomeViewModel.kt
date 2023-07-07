package com.alexmumo.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.alexmumo.domain.repository.NewsRepository
import com.alexmumo.presentation.state.ArticleState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewModel constructor(private val newsRepository: NewsRepository): ViewModel() {

    private val _category = MutableStateFlow<String?>(null)
    val category = _category.asStateFlow()

    private val _uiState = MutableStateFlow(ArticleState())
    val uiState = _uiState.asStateFlow()

    private val _technology = MutableStateFlow(ArticleState())
    val technology = _technology.asStateFlow()

    private val _sports = MutableStateFlow(ArticleState())
    val sports = _sports.asStateFlow()

    private val _entertainment = MutableStateFlow(ArticleState())
    val entertainment = _entertainment.asStateFlow()

    private val _trending = MutableStateFlow(ArticleState())
    val trending = _trending.asStateFlow()

    private val _health = MutableStateFlow(ArticleState())
    val health = _health.asStateFlow()

    private val _business = MutableStateFlow(ArticleState())
    val business = _business.asStateFlow()

    init {
        getTechnologyNews("technology")
        getScienceNews("science")
        getSportsNews("sports")
        getBusinessNews("business")
        getGeneralNews("general")
    }

    private fun getTechnologyNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val tech = newsRepository.fetchNews(category).cachedIn(viewModelScope)
                _technology.update { it.copy(articles = tech, isLoading = false) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    private fun getScienceNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val trending = newsRepository.fetchNews(category).cachedIn(viewModelScope)
                _trending.update { it.copy(articles = trending, isLoading = false) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getGeneralNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val breaking = newsRepository.fetchNews(category).cachedIn(viewModelScope)
                _uiState.update { it.copy(articles = breaking, isLoading = false) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    private fun getSportsNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val sports = newsRepository.fetchNews(category).cachedIn(viewModelScope)
                _sports.update { it.copy(articles = sports, isLoading = false) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getBusinessNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val business = newsRepository.fetchNews(category).cachedIn(viewModelScope)
                _business.update { it.copy(articles = business, isLoading = false) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}