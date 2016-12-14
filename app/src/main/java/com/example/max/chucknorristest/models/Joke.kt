package com.example.max.chucknorristest.models

import com.squareup.moshi.Json

class Joke(iconUrl: String, id: String, url: String, value: String) {

    @Json(name = "icon_url")
    val iconUrl: String
    @Json(name = "id")
    val id: String
    @Json(name = "url")
    val url: String
    @Json(name = "value")
    val value: String

    init {
        this.iconUrl = iconUrl
        this.id = id
        this.url = url
        this.value = value
    }

}