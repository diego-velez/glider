package org.supersoniclegend.glider.model

data class FlickrResponse(
    val photos: PhotoResponse,
    val extra: ExtraResponse,
    val stat: String
)