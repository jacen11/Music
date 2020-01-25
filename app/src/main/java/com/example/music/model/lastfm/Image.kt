package com.example.music.model.lastfm

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Image (
    @SerializedName("#text")
    @Expose
    var url: String? = null,
    @SerializedName("size")
    @Expose
    var size: String? = null
)