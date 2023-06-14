package com.alexmumo.database.datastore

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsRepositoryImpl constructor(private val context: Context): SettingsRepository {
    private val NEWS_THEME = intPreferencesKey(name = "theme")
    override suspend fun setTheme(theme: Int) {
        context.dataStore.edit { settings ->
            settings[NEWS_THEME] = theme
        }
    }

    override suspend fun getTheme(): Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[NEWS_THEME] ?: AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        }
}