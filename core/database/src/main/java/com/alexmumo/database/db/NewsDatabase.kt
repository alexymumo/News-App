package com.alexmumo.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexmumo.database.dao.ArticleDao
import com.alexmumo.database.dao.BookMarkDao
import com.alexmumo.database.dao.RemoteKeyDao
import com.alexmumo.database.entity.ArticleEntity
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.database.entity.RemoteKeyEntity

@Database(
    entities = [BookMarkEntity::class, ArticleEntity::class, RemoteKeyEntity::class],
    version = 2,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun bookMarkDao(): BookMarkDao
    abstract fun articleDao(): ArticleDao
    abstract fun remoteKeyDao(): RemoteKeyDao
}
