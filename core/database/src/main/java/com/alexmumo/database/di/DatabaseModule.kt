package com.alexmumo.database.di

import androidx.room.Room
import com.alexmumo.database.dao.BookMarkDao
import com.alexmumo.database.db.NewsDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            NewsDatabase::class.java,
            "article.db").fallbackToDestructiveMigration().build()
    }

    single<BookMarkDao> {
        val db = get<NewsDatabase>()
        db.bookMarkDao()

    }
}
