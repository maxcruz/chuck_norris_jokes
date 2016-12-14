package com.example.max.chucknorristest.data.client

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ServiceFactory {

    companion object {

        fun <T> create(clazz: Class<T>, endPoint: String): T {
            val retrofit = Retrofit.Builder()
                    .baseUrl(endPoint)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            return retrofit.create(clazz)
        }
    }

}