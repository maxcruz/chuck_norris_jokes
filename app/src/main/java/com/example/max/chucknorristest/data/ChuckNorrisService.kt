package com.example.max.chucknorristest.data

import com.example.max.chucknorristest.models.Joke
import retrofit2.http.GET
import rx.Observable

interface ChuckNorrisService {

    companion object {
        val SERVICE_ENDPOINT = "https://api.chucknorris.io/"
    }

    @GET("jokes/random")
    fun getJokeRandom(): Observable<Joke>

}