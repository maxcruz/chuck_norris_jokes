package com.example.max.chucknorristest.presentation.showPhrase

import com.example.max.chucknorristest.domain.GetJoke

class MainPresenter(val view: MainContract.View, val jokeUseCase: GetJoke) : MainContract.Presenter {

    override fun onCreate() {
        getPhrase()
    }

    override fun onDestroy() {
    }

    override fun getPhrase() {
        view.disableButton(false)
        view.showProgress(true)

        jokeUseCase.execute().subscribe(
            { emitter ->
                view.putPhrase(emitter.joke)
                view.disableButton(true)
                view.showProgress(false)
            },
            { error ->
                error.printStackTrace()
                view.showError()
                view.disableButton(true)
                view.showProgress(false)
            }
        )
    }

}