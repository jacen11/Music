package com.example.music.model.itunes

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class ITunesResponce(
    @SerializedName("resultCount")
    @Expose
    var resultCount: Int? = null,
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
)