package com.alexmumo.network.di

import com.alexmumo.common.Constants.BASE_URL
import com.alexmumo.network.api.NewsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkhttpClient())
            .build()
            .create(NewsApi::class.java)

    }
}

fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().setLevel(level = HttpLoggingInterceptor.Level.BODY)
}

fun provideOkhttpClient(): OkHttpClient {
    val client = OkHttpClient.Builder()
        .callTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30 , TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(providesHttpLoggingInterceptor())
    return client.build()
}