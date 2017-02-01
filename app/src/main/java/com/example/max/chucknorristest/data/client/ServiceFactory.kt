package com.example.max.chucknorristest.data.client

import com.example.max.chucknorristest.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ServiceFactory {

    companion object {

        fun <T> create(clazz: Class<T>, endPoint: String): T {
            val httpClientBuilder = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                val logger = HttpLoggingInterceptor()
                logger.level = HttpLoggingInterceptor.Level.BODY
                httpClientBuilder.addInterceptor(logger)
            }
            val retrofit = Retrofit.Builder()
                    .baseUrl(endPoint)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(EmptyConverterFactory())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(httpClientBuilder.build())
                    .build()
            return retrofit.create(clazz)
        }
    }

}