package com.alexmumo.repository.di

import com.alexmumo.domain.repository.BookMarkRepository
import com.alexmumo.domain.repository.NewsRepository
import com.alexmumo.domain.repository.SearchRepository
import com.alexmumo.repository.repository.BookMarkRepositoryImpl
import com.alexmumo.repository.repository.NewsRepositoryImpl
import com.alexmumo.repository.repository.SearchRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    single<NewsRepository> { NewsRepositoryImpl(newsDatabase = get(),newsApi = get()) }
    single<SearchRepository> { SearchRepositoryImpl(newsApi =  get())  }
    single<BookMarkRepository> { BookMarkRepositoryImpl(get()) }
}
