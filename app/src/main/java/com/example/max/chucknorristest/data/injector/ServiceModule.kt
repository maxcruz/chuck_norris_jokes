package com.example.max.chucknorristest.data.injector

import com.example.max.chucknorristest.data.ChuckNorrisService
import com.example.max.chucknorristest.data.client.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun providesService(): ChuckNorrisService {
        return ServiceFactory.create(ChuckNorrisService::class.java,
                ChuckNorrisService.SERVICE_ENDPOINT)
    }

}