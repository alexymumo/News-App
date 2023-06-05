package com.alexmumo.database.db

import androidx.room.Database
import com.alexmumo.database.dao.ArticleDao
import com.alexmumo.database.dao.RemoteKeyDao
import com.alexmumo.database.entity.ArticleEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1,
    exportSchema = false
)

abstract class ArticleDatabase {
    abstract fun articleDao(): ArticleDao
    abstract fun remoteKeyDao(): RemoteKeyDao
}