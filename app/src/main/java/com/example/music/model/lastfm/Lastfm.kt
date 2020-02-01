package com.example.music.model.lastfm

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Lastfm(
    @SerializedName("results")
    @Expose
    var results: Results? = null
)
