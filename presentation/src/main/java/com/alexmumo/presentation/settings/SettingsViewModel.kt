package com.alexmumo.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.database.datastore.SettingsRepository
import kotlinx.coroutines.launch


class SettingsViewModel constructor(private val settingsRepository: SettingsRepository) : ViewModel() {
    fun setTheme(theme: Int) {
        viewModelScope.launch {
            settingsRepository.setTheme(theme)
        }
    }

    fun getTheme() {
        viewModelScope.launch {
            settingsRepository.getTheme()
        }
    }
}