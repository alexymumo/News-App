package com.alexmumo.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.alexmumo.database.data.remoteKeyEntity
import com.alexmumo.database.db.NewsDatabase
import com.google.common.truth.Truth
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RemoteKeyDaoTest {

    private lateinit var newsDatabase: NewsDatabase
    private lateinit var remoteKeyDao: RemoteKeyDao

    @Before
    fun setUpDatabase() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        newsDatabase = Room.inMemoryDatabaseBuilder(
            context,NewsDatabase::class.java
        ).build()

        remoteKeyDao = newsDatabase.remoteKeyDao()
    }


    @Test
    fun `test save remote key`() = runTest{
        val remotekeys = listOf(remoteKeyEntity)
        remoteKeyDao.saveRemoteKey(remotekeys)
        val result = remoteKeyDao.getRemoteKeys("test")
        Truth.assertThat(result).isEqualTo(result)

    }

    @Test
    fun `test delete remote key`() = runTest{
        remoteKeyDao.saveRemoteKey(listOf(remoteKeyEntity))
        remoteKeyDao.deleteRemoteKey()
    }


    @After
    fun close() {
        newsDatabase.close()
    }
}