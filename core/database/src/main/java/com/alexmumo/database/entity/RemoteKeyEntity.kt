package com.alexmumo.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_key_table")
data class RemoteKeyEntity(
    @PrimaryKey
    val url: String,
    val nextKey: Int?,
    val prevKey: Int?
)
