package com.alexmumo.network.api

import com.alexmumo.common.Constants.BASE_URL
import com.alexmumo.network.response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun searchNews(
        @Query("q") q: String,
        @Query("from") from: String = "2023-06-01",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("pageSize") pageSize: Int = 100,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = BASE_URL
    ): Response<NewsResponse>

    @GET("top-headlines")
    suspend fun getTopHeadLines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("pageSize") pageSize: Int = 100,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = BASE_URL
    ): Response<NewsResponse>
}