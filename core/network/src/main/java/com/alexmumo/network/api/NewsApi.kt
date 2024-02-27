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
package com.alexmumo.network.api

import com.alexmumo.common.Constants.NEWS_API_KEY
import com.alexmumo.common.Constants.PAGE
import com.alexmumo.common.Constants.PAGE_SIZE
import com.alexmumo.network.response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {
    @GET("everything")
    suspend fun searchNews(
        @Query("q") q: String,
        //@Query("pageSize") pageSize: Int = PAGE_SIZE,
        //@Query("page") page: Int = PAGE,
        @Query("apiKey") apiKey: String = NEWS_API_KEY
    ): Response<NewsResponse>

    @GET("top-headlines")
    suspend fun getTopHeadLines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("pageSize") pageSize: Int = PAGE_SIZE,
        @Query("page") page: Int = PAGE,
        @Query("apiKey") apiKey: String = NEWS_API_KEY
    ): Response<NewsResponse>
}
