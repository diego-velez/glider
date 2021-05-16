package org.coquicoding.glider.api.photos.getInfo

import com.google.gson.annotations.SerializedName

data class Editability(
    @SerializedName("cancomment") val canComment: Int,
    @SerializedName("canaddmeta") val canAddMetadata: Int
)
