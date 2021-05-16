package org.coquicoding.glider.api.photos.getInfo

import com.google.gson.annotations.SerializedName

data class Title(
    @SerializedName("_content") val title: String
)
