package org.supersoniclegend.glider.api.photos.getInfo

import com.google.gson.annotations.SerializedName

data class Photo(
    val id: String,
    val secret: String,
    val server: String,
    val farm: Int,
    @SerializedName("dateuploaded") val dateUploaded: String,
    @SerializedName("isfavorite") val isFavorite: Int,
    val license: String,
    @SerializedName("safety_level") val safetyLevel: String,
    val rotation: Int,
    val owner: Owner,
    val title: Title,
    val description: Description,
    val visibility: Visibility,
    val dates: Dates,
    val views: String,
    val editability: Editability,
    @SerializedName("publiceditability") val publicEditability: Editability,
    val usage: Usage,
    val comments: Comments,
    val notes: Notes,
    val people: People,
    val tags: Tags,
    val urls: Urls,
    val media: String
)
