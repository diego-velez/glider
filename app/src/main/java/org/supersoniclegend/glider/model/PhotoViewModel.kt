package org.supersoniclegend.glider.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import org.supersoniclegend.glider.utils.ImageViewHelper

class PhotoViewModel : BaseObservable(), ImageViewHelper {
    @get:Bindable
    var photoUrl: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.photoUrl)
        }
}