package org.coquicoding.glider.api.photos.getInfo

import com.google.gson.annotations.SerializedName

data class Url(
    val type: String,
    @SerializedName("_content") val content: String
)
