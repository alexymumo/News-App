package com.alexmumo.datastore

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun getTheme(): Flow<Int>
    suspend fun setTheme(theme: Int)
}
