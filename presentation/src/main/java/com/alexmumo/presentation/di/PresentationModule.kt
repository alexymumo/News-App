package com.alexmumo.presentation.di

import com.alexmumo.presentation.home.HomeViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::HomeViewModel)
}