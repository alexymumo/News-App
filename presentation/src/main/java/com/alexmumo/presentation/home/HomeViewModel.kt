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

class HomeViewModel constructor(private val newsRepository: NewsRepository) : ViewModel() {

    private val _category = MutableStateFlow<String?>(null)
    val category = _category.asStateFlow()

    private val _general = MutableStateFlow(ArticleState())
    val general = _general.asStateFlow()

    private val _technology = MutableStateFlow(ArticleState())
    val technology = _technology.asStateFlow()

    private val _sports = MutableStateFlow(ArticleState())
    val sports = _sports.asStateFlow()


    private val _business = MutableStateFlow(ArticleState())
    val business = _business.asStateFlow()

    private val _health = MutableStateFlow(ArticleState())
    val health = _health.asStateFlow()

    init {
        getTechnologyNews("technology")
        getSportsNews("sports")
        getBusinessNews("business")
        getGeneralNews("general")
        getHealthNews("health")
    }

    private fun getHealthNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val health = newsRepository.fetchNews(category=category).cachedIn(viewModelScope)
                _health.update { it.copy(articles = health, isLoading = false) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    /*general business, tech, entertainment health*/

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

    private fun getGeneralNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val general = newsRepository.fetchNews(category).cachedIn(viewModelScope)
                _general.update { it.copy(articles = general, isLoading = false) }
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
