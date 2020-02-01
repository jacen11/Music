package com.example.music.model.lastfm

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Results(
//    @SerializedName("opensearch:Query")
//    @Expose
//    var opensearchQuery: OpensearchQuery? = null
    @SerializedName("opensearch:totalResults")
    @Expose
    var opensearchTotalResults: String? = null,
    @SerializedName("opensearch:startIndex")
    @Expose
    var opensearchStartIndex: String? = null,
    @SerializedName("opensearch:itemsPerPage")
    @Expose
    var opensearchItemsPerPage: String? = null,
    @SerializedName("trackmatches")
    @Expose
    var trackmatches: Trackmatches? = null
//    @SerializedName("@attr")
//    @Expose
//    var attr: Attr? = null
)
