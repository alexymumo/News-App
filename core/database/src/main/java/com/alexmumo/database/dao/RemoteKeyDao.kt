package com.alexmumo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmumo.database.entity.RemoteKeyEntity

@Dao
interface RemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRemoteKey(remoteKeyEntity: List<RemoteKeyEntity>)

    @Query("SELECT * FROM remote_key_table WHERE url LIKE :query")
    suspend fun getRemoteKeys(query: String): RemoteKeyEntity

    @Query("DELETE FROM remote_key_table")
    suspend fun deleteRemoteKey()
}
