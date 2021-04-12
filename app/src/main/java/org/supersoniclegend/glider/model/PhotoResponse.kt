package org.supersoniclegend.glider.model

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("photo")
    val photoItems: List<PhotoItem>,
    val total: Int,
    @SerializedName("perpage") val perPage: Int,
    val pages: Int,
    val page: Int
)
