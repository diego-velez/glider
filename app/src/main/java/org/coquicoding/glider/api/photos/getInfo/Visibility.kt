package org.coquicoding.glider.api.photos.getInfo

import com.google.gson.annotations.SerializedName

data class Visibility(
    @SerializedName("ispublic") val isPublic: Int,
    @SerializedName("isfriend") val isFriend: Int,
    @SerializedName("isfamily") val isFamily: Int
)
