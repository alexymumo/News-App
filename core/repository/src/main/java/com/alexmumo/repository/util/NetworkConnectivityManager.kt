package com.alexmumo.repository.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest.Builder
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.getSystemService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.conflate
import javax.inject.Inject

internal  class NetworkConnectivityManager @Inject constructor(@ApplicationContext context: Context): NetworkMonitor {
  override val isOnline: Flow<Boolean> = callbackFlow {
    val connectivityManager = context.getSystemService<ConnectivityManager>()
    if (connectivityManager == null) {
      channel.trySend(false)
      channel.close()
      return@callbackFlow
    }

    val callback = object : NetworkCallback() {
      private val networks = mutableSetOf<Network>()
      override fun onAvailable(network: Network) {
        networks += network
        channel.trySend(true)
      }

      override fun onLost(network: Network) {
        channel.trySend(networks.isNotEmpty())
      }
    }

    val request = Builder()
      .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
      .build()
    connectivityManager.registerNetworkCallback(request, callback)
    //channel.trySend(connectivityManager.isCurrentlyConnected())
    awaitClose {
      connectivityManager.unregisterNetworkCallback(callback)
    }
  }.conflate()

}