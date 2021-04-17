package org.supersoniclegend.glider.model

import org.supersoniclegend.glider.activities.DataHolder
import org.supersoniclegend.glider.api.interestingness.getList.Photo

class PhotoViewModel {
    val photo: Photo
        get() = DataHolder.currentPhoto
}