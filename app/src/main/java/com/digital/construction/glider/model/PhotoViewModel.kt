package com.digital.construction.glider.model

import com.digital.construction.glider.api.interestingness.getList.Photo

class PhotoViewModel {
    val photo: Photo
        get() = DataHolder.currentPhoto
}