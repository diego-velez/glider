package org.supersoniclegend.glider.model

import com.google.gson.annotations.SerializedName

data class PhotoItem(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: String,
    val title: String,

    @SerializedName("ispublic") val isPublic: Int,
    @SerializedName("isfriend") val isFriend: Int,
    @SerializedName("isfamily") val isFamily: Int,

    @SerializedName("url_s") val url_small_thumbnail: String,
    @SerializedName("height_s") val height_small_thumbnail: Int,
    @SerializedName("width_s") val width_small_thumbnail: Int
) {
    val image_url: String
        get() = "$server/${id}_${secret}_s.jpg"
}