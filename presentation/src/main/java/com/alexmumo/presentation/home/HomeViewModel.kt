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
package com.alexmumo.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.alexmumo.common.Resource
import com.alexmumo.domain.repository.NewsRepository
import com.alexmumo.presentation.state.ArticleState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val newsRepository: NewsRepository) : ViewModel() {

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
                val health = newsRepository.fetchNews(category = category)
                _health.update { it.copy(articles = health, isLoading = false) }
            } catch (e: Exception) {
                //Resource.Error(message = "Error occurred")
            }
        }
    }

    /*general business, tech, entertainment health*/

    private fun getTechnologyNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val tech = newsRepository.fetchNews(category)
                //Resource.Success(data = tech)
                _technology.update { it.copy(articles = tech, isLoading = false) }
            } catch (e: Exception) {
                //Resource.Error(error(e))
            }
        }
    }

    private fun getGeneralNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val general = newsRepository.fetchNews(category)
                //Resource.Success(data = general)
                _general.update { it.copy(articles = general, isLoading = false) }
            } catch (e: Exception) {
                //Resource.Error(error(e))
            }
        }
    }

    private fun getSportsNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val sports = newsRepository.fetchNews(category)
                //Resource.Success(data = sports)
                _sports.update { it.copy(articles = sports, isLoading = false) }
            } catch (e: Exception) {
                //Resource.Error(error(e))
                //e.printStackTrace()
            }
        }
    }

    private fun getBusinessNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val business = newsRepository.fetchNews(category)
                //Resource.Success(data = business)
                _business.update { it.copy(articles = business, isLoading = false) }
            } catch (e: Exception) {
                //Resource.Error(error(e))
            }
        }
    }
}
