package com.example.max.chucknorristest.presentation.showPhrase

import com.example.max.chucknorristest.data.ChuckNorrisService
import com.example.max.chucknorristest.models.Joke
import io.reactivex.Observable

class MainRepository(val chuckNorrisService: ChuckNorrisService) : MainContract.Model {

    override fun requestPhrase(): Observable<Joke> {
        return chuckNorrisService.getJokeRandom().map { response ->
            when (response.code()) {
                200 -> {
                    response.body()
                }
                else -> {
                    throw Exception()
                }
            }
        }
    }

}