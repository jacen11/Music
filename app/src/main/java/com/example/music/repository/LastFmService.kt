package com.example.music.repository

import com.example.music.model.lastfm.Lastfm
import retrofit2.http.GET
import io.reactivex.Single
import retrofit2.http.Query

private const val API_KEY_LAST_FM: String = "ce6f68ae5078cb151778907dc9f5b24d"

interface LastFmService {
    @GET("?method=track.search&api_key=$API_KEY_LAST_FM&format=json")
    fun getTrack(@Query("track") nameTrack: String): Single<Lastfm>
}
