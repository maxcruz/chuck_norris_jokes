package com.example.max.chucknorristest.presentation.showPhrase

import com.example.max.chucknorristest.domain.GetJoke
import rx.lang.kotlin.subscribeWith
import rx.subscriptions.CompositeSubscription

class MainPresenter(val view: MainContract.View, val jokeUseCase: GetJoke) : MainContract.Presenter {

    lateinit var subscriptions: CompositeSubscription

    override fun onCreate() {
        subscriptions = CompositeSubscription()
        getPhrase()
    }

    override fun onDestroy() {
        subscriptions.clear()
    }

    override fun getPhrase() {
        view.disableButton(false)
        view.showProgress(true)

        jokeUseCase.execute().subscribeWith {
            onNext {
                view.putPhrase(it.joke)
                view.disableButton(true)
                view.showProgress(false)
            }
            onError {
                it.printStackTrace()
                view.showError()
                view.disableButton(true)
                view.showProgress(false)
            }
        }
    }

}