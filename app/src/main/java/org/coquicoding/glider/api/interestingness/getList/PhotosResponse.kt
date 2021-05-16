package org.coquicoding.glider.api.interestingness.getList

data class PhotosResponse(
    val photos: Photos,
    val extra: Extra,
    val stat: String
)