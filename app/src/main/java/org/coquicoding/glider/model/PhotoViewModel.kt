package org.coquicoding.glider.model

import org.coquicoding.glider.api.interestingness.getList.Photo

class PhotoViewModel {
    val photo: Photo
        get() = DataHolder.currentPhoto
}