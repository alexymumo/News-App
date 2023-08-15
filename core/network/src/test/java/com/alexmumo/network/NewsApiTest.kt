package com.alexmumo.network

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.alexmumo.network.api.NewsApi
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream
import java.net.HttpURLConnection


@RunWith(RobolectricTestRunner::class)
class NewsApiTest {
    private var context: Context? = null
    private lateinit var mockWebServer: MockWebServer
    private lateinit var newsApi: NewsApi
    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start(8080)

        context = InstrumentationRegistry.getInstrumentation().context


        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        newsApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(NewsApi::class.java)

        val jsonStream: InputStream = context!!.resources.assets.open("news.json")
        val jsonBytes: ByteArray = jsonStream.readBytes()

        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(String(jsonBytes))
        mockWebServer.enqueue(response)
    }

    @Test
    fun `test 200 response`() = runBlocking {
        val result = newsApi.getTopHeadLines("","",1, 20,"test")
        Truth.assertThat(result.body()).isEqualTo(result.body())
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}