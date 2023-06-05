package com.alexmumo.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmumo.database.entity.RemoteKeyEntity

@Dao
interface RemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRemoteKey(remoteKeyEntity: RemoteKeyEntity)

    @Query("SELECT * FROM remote_table")
    suspend fun getRemoteKey(): RemoteKeyEntity

    @Query("DELETE FROM remote_table")
    suspend fun deleteRemoteKey()
}