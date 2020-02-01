package com.example.music.model.lastfm

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Trackmatches(
    @SerializedName("track")
    @Expose
    var track: List<Track>? = null
)
