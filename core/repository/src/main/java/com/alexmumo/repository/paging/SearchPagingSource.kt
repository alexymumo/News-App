package com.alexmumo.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexmumo.domain.model.Article
import com.alexmumo.network.api.NewsApi

class SearchPagingSource(
    private val newsApi: NewsApi,
    private val searchString: String
): PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        TODO("Not yet implemented")
    }
}