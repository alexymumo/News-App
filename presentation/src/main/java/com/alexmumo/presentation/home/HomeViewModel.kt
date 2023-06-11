package com.alexmumo.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val newsRepository: NewsRepository): ViewModel() {

    init {
        fetchTrending("health")
        fetchSports("sports")
        fetchBusiness("business")
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