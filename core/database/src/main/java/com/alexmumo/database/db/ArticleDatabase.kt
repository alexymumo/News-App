package com.alexmumo.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexmumo.database.dao.ArticleDao
import com.alexmumo.database.dao.RemoteKeyDao
import com.alexmumo.database.entity.ArticleEntity
import com.alexmumo.database.entity.RemoteKeyEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
    //abstract fun remoteKeyDao(): RemoteKeyDao
}