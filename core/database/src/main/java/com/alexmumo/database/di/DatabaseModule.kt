package com.alexmumo.database.di

import androidx.room.Room
import com.alexmumo.database.db.ArticleDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            ArticleDatabase::class.java,
            "article.db").fallbackToDestructiveMigration().build()
    }
}
