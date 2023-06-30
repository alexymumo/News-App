package com.alexmumo.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmumo.database.entity.BookMarkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookMarkDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveBookMark(bookMarkEntity: BookMarkEntity)

    @Query("DELETE FROM bookmark_table")
    suspend fun deleteBookMark()

    @Query("SELECT * FROM bookmark_table")
    fun getBookMarks() : Flow<List<BookMarkEntity>>
}