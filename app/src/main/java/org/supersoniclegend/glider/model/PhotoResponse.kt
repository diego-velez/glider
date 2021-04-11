package org.supersoniclegend.glider.model

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("photo")
    var photoItems: List<PhotoItem>
)
