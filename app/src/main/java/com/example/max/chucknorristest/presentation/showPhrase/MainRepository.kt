package com.example.max.chucknorristest.presentation.showPhrase

import com.example.max.chucknorristest.data.ChuckNorrisService
import com.example.max.chucknorristest.models.Joke
import rx.Observable

class MainRepository(val chuckNorrisService: ChuckNorrisService) : MainContract.Model {

    override fun requestPhrase(): Observable<Joke> {
        return chuckNorrisService.getJokeRandom()
    }

}