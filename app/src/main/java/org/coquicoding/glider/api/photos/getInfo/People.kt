package org.coquicoding.glider.api.photos.getInfo

import com.google.gson.annotations.SerializedName

data class People(
    @SerializedName("haspeople") val hasPeople: Int
)
