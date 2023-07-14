package com.alexmumo.presentation.di

import com.alexmumo.presentation.bookmarks.BookMarkViewModel
import com.alexmumo.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        BookMarkViewModel(get())
    }
}
