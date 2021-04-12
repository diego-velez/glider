package org.supersoniclegend.glider.api.interestingness.getList

import com.google.gson.annotations.SerializedName

data class Photo(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: String,
    val title: String,

    @SerializedName("ispublic") val isPublic: Int,
    @SerializedName("isfriend") val isFriend: Int,
    @SerializedName("isfamily") val isFamily: Int,

    @SerializedName("url_s") val urlSmallThumbnail: String,
    @SerializedName("height_s") val heightSmallThumbnail: Int,
    @SerializedName("width_s") val widthSmallThumbnail: Int
) {
    val webPageUrl: String
        get() = "https://www.flickr.com/photos/$owner/$id"
}