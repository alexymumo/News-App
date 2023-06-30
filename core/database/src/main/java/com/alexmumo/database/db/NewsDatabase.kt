package com.alexmumo.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexmumo.database.dao.BookMarkDao
import com.alexmumo.database.entity.BookMarkEntity

@Database(
    entities = [BookMarkEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun bookMarkDao(): BookMarkDao
}