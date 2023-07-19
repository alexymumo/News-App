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
package com.alexmumo.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.datastore.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SettingsViewModel constructor(private val settingsRepository: SettingsRepository) : ViewModel() {
    private val _theme = MutableStateFlow<Int?>(null)
    val theme = _theme.asStateFlow()

    init {
        getTheme()
    }

    fun setTheme(theme: Int) {
        viewModelScope.launch {
            settingsRepository.setTheme(theme = theme)
        }
    }

    private fun getTheme() {
        viewModelScope.launch {
            settingsRepository.getTheme().collectLatest { theme ->
                _theme.value = theme
            }
        }
    }
}
