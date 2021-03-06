package com.example.music.model.lastfm

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("artist")
    @Expose
    var artist: String? = null,
    @SerializedName("url")
    @Expose
    var url: String? = null,
    @SerializedName("streamable")
    @Expose
    var streamable: String? = null,
    @SerializedName("listeners")
    @Expose
    var listeners: String? = null,
    @SerializedName("image")
    @Expose
    var image: List<Image>? = null,
    @SerializedName("mbid")
    @Expose
    var mbid: String? = null
)
