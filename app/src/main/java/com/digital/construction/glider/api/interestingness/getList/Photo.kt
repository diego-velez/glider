package com.digital.construction.glider.api.interestingness.getList

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
    @SerializedName("width_s") val widthSmallThumbnail: Int,

    @SerializedName("url_o") val urlOriginal: String?,
    @SerializedName("height_o") val heightOriginal: Int,
    @SerializedName("width_o") val widthOriginal: Int,

    @SerializedName("url_l") val urlLarge: String,
    @SerializedName("height_l") val heightLarge: Int,
    @SerializedName("width_l") val widthLarge: Int,

    @SerializedName("ownername") val ownerUsername: String,
) {
    val webPageUrl: String
        get() = "https://www.flickr.com/photos/$owner/$id"
}