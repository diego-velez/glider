package org.supersoniclegend.glider.api.interestingness.getList

import com.google.gson.annotations.SerializedName

data class Photos(
    @SerializedName("photo")
    val photos: List<Photo>,
    val total: Int,
    @SerializedName("perpage") val photosPerPage: Int,
    val pages: Int,
    val page: Int
)
