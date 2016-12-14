package com.example.max.chucknorristest.presentation.showPhrase

import com.example.max.chucknorristest.models.Joke
import rx.Observable

interface MainContract {

    interface View {

        fun disableButton(enabled: Boolean)
        fun showProgress(show: Boolean)
        fun putPhrase(message: String)
        fun showError()

    }

    interface Presenter {

        fun onCreate()
        fun onDestroy()
        fun getPhrase()

    }

    interface Model {

        fun requestPhrase(): Observable<Joke>

    }

}