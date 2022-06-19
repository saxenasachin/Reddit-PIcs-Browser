package com.saxenasachin.remote.services

import com.saxenasachin.remote.services.github.RedditService
import com.google.gson.Gson
import okhttp3.Dns
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RedditServiceFactory {

    fun create(isDebugMode: Boolean, baseUrl: String): RedditService {
        val client =
            createOkHttp(
                isDebugMode
            )

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        return retrofit.create(RedditService::class.java)
    }

    private fun createOkHttp(isDebugMode: Boolean): OkHttpClient {
        val logging = HttpLoggingInterceptor()

        logging.level = if (isDebugMode)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .dns(Dns.SYSTEM)
            .cache(null)
            .connectTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    private const val OK_HTTP_TIMEOUT = 60L
}
