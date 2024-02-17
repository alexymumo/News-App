package com.alexmumo.repository.di

import com.alexmumo.repository.util.NetworkConnectivityManager
import com.alexmumo.repository.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UtilModule {

    @Binds
    internal abstract fun bindsNetworkMonitor(networkConnectivityManager: NetworkConnectivityManager) : NetworkMonitor
}