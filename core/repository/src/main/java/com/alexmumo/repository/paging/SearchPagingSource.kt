package com.alexmumo.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexmumo.common.Constants.NEWS_API_KEY
import com.alexmumo.domain.model.Article
import com.alexmumo.network.api.NewsApi
import com.alexmumo.repository.mappers.toDomain
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException


private const val STARTING_KEY = 1
class SearchPagingSource constructor(
    private val newsApi: NewsApi,
    private val queryString: String
): PagingSource<Int, Article>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: STARTING_KEY
        return try {
            val searchResponse = newsApi.searchNews(
                q = queryString,
                pageSize = 20,
                page = page,
                apiKey = NEWS_API_KEY
            )

            val searchedArticles = searchResponse.body()?.articles ?: listOf()
            val nextKey = if (searchedArticles.isEmpty()) {
                null
            } else {
                page + 1
            }

            LoadResult.Page(
                data = searchedArticles.map { it.toDomain() },
                nextKey = nextKey,
                prevKey = if (page == STARTING_KEY) null else page
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            Timber.d("Http", e.printStackTrace())
            return LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }
}