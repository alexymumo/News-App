package com.alexmumo.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class SourceDto(
    val id: String?,
    val name: String
)
