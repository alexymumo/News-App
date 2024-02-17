package com.alexmumo.repository.util

import kotlinx.coroutines.flow.Flow

interface NetworkMonitor {
  val isOnline: Flow<Boolean>
}