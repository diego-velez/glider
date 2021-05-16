package org.coquicoding.glider.api.photos.getInfo

import com.google.gson.annotations.SerializedName

data class Dates(
    val posted: String,
    val taken: String,
    @SerializedName("takengranularity") val takenGranularity: Int,
    @SerializedName("takenunknown") val takenUnknown: String,
    @SerializedName("lastupdate") val lastUpdate: String
)
