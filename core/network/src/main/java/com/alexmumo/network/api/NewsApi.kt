package com.alexmumo.network.api

import com.alexmumo.common.Constants.BASE_URL
import com.alexmumo.common.Constants.NEWS_API_KEY
import com.alexmumo.common.Resource
import com.alexmumo.network.response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun searchNews(
        @Query("q") q: String,
        @Query("pageSize") pageSize: Int = 100,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = NEWS_API_KEY
    ): Response<NewsResponse>

    @GET("top-headlines")
    suspend fun getTopHeadLines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("pageSize") pageSize: Int = 100,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = NEWS_API_KEY
    ): Response<NewsResponse>
}