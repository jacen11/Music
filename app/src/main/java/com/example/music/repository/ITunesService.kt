package com.example.music.repository

import com.example.music.model.itunes.ITunesResponce
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesService{
    @GET("?entity=musicTrack")
    fun getTrack(@Query("term") nameTrack: String): Single<ITunesResponce>
}