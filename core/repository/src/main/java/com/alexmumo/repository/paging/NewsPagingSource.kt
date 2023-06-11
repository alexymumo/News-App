package com.alexmumo.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexmumo.domain.model.Article
import com.alexmumo.network.api.NewsApi


class NewsPagingSource(private val category:String, private val newsApi: NewsApi):
    PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        TODO("Not yet implemented")
    }
}