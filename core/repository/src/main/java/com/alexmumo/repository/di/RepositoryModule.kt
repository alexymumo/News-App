package com.alexmumo.repository.di

import com.alexmumo.domain.repository.NewsRepository
import com.alexmumo.repository.repository.NewsRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    single<NewsRepository> { NewsRepositoryImpl(newsApi = get()) }
}
