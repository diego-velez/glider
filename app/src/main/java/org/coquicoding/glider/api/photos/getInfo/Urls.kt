package org.coquicoding.glider.api.photos.getInfo

import com.google.gson.annotations.SerializedName

data class Urls(
    @SerializedName("url") val urlItems: List<Url>
)
