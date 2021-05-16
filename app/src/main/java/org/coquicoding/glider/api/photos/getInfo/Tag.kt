package org.coquicoding.glider.api.photos.getInfo

import com.google.gson.annotations.SerializedName

data class Tag(
    val id: String,
    val author: String,
    @SerializedName("authorname") val authorName: String,
    val raw: String,
    @SerializedName("_content") val content: String,
    @SerializedName("machine_tag") val machineTag: Int
)
