package com.example.max.chucknorristest.data

import com.example.max.chucknorristest.models.Joke
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ChuckNorrisService {

    companion object {
        val SERVICE_ENDPOINT = "https://api.chucknorris.io/"
    }

    @GET("jokes/random")
    fun getJokeRandom(): Observable<Response<Joke>>

}