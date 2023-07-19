package com.alexmumo.presentation.di

import com.alexmumo.presentation.bookmarks.BookMarkViewModel
import com.alexmumo.presentation.home.HomeViewModel
import com.alexmumo.presentation.search.SearchViewModel
import com.alexmumo.presentation.settings.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        BookMarkViewModel(get())
    }
    viewModel {
        SearchViewModel(get())
    }

    viewModel {
        SettingsViewModel(get())
    }
}
