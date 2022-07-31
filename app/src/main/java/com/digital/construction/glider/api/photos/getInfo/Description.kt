package com.digital.construction.glider.api.photos.getInfo

import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("_content") val description: String
)
