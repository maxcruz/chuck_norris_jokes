package com.example.max.chucknorristest.presentation.showPhrase.injector

import com.example.max.chucknorristest.data.ChuckNorrisService
import com.example.max.chucknorristest.domain.GetJoke
import com.example.max.chucknorristest.presentation.showPhrase.MainContract
import com.example.max.chucknorristest.presentation.showPhrase.MainPresenter
import com.example.max.chucknorristest.presentation.showPhrase.MainRepository
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class MainModule(val view: MainContract.View) {

    @Provides
    @Singleton
    fun providesRepository(service: ChuckNorrisService): MainContract.Model {
        return MainRepository(service)
    }

    @Provides
    @Singleton
    fun providesGetJoke(repository: MainContract.Model): GetJoke {
        val observeOn = AndroidSchedulers.mainThread()
        val subscribeOn = Schedulers.io()
        return GetJoke(repository, subscribeOn, observeOn)
    }

    @Provides
    @Singleton
    fun providesPresenter(getJoke: GetJoke): MainContract.Presenter {
        return MainPresenter(view, getJoke)
    }

}