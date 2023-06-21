package com.alexmumo.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.datastore.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SettingsViewModel constructor(private val settingsRepository: SettingsRepository): ViewModel() {
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