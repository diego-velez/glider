package com.digital.construction.glider.api.photos.getInfo

import com.google.gson.annotations.SerializedName

data class Urls(
    @SerializedName("url") val urlItems: List<Url>
)
