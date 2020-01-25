package com.example.music.model.lastfm

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image (
    @SerializedName("#text")
    @Expose
    var url: String? = null,
    @SerializedName("size")
    @Expose
    var size: String? = null
) : Parcelable