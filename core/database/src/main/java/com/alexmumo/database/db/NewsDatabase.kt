/*
 * Copyright 2023 News-App
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
