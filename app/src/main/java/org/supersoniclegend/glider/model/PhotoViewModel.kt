package org.supersoniclegend.glider.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class PhotoViewModel : BaseObservable() {
    @get:Bindable
    var photoUrl: String? = null
}