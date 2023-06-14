package com.alexmumo.database.datastore

import kotlinx.coroutines.flow.Flow


interface SettingsRepository {
    suspend fun setTheme(theme: Int)
    suspend fun getTheme(): Flow<Int>
}