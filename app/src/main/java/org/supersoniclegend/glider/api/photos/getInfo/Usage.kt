package org.supersoniclegend.glider.api.photos.getInfo

import com.google.gson.annotations.SerializedName

data class Usage(
    @SerializedName("candownload") val canDownload: Int,
    @SerializedName("canblog") val canBlog: Int,
    @SerializedName("canprint") val canPrint: Int,
    @SerializedName("canshare") val canShare: Int
)
