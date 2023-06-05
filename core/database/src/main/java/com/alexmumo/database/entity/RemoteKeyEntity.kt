package com.alexmumo.database.entity

import androidx.room.Entity

@Entity(tableName = "remote_table")
data class RemoteKeyEntity(
    val nextKey: Int,
    val prevKey: Int
)
