package com.alexmumo.repository.di

import com.alexmumo.domain.repository.BookMarkRepository
import com.alexmumo.domain.repository.NewsRepository
import com.alexmumo.repository.repository.BookMarkRepositoryImpl
import com.alexmumo.repository.repository.NewsRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    single<NewsRepository> { NewsRepositoryImpl(newsApi = get()) }
    single<BookMarkRepository> { BookMarkRepositoryImpl(bookMarkDao = get()) }
}
