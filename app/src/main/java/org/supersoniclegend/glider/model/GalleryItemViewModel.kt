package org.supersoniclegend.glider.model

import android.content.Context
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import org.supersoniclegend.glider.activities.PhotoActivity
import org.supersoniclegend.glider.api.interestingness.getList.Photo

private const val TAG = "GalleryItemViewModel"

class GalleryItemViewModel(private val context: Context) : BaseObservable() {

    var photo: Photo? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.imageUrl)
        }

    @get:Bindable
    val imageUrl: String?
        get() = photo?.urlSmallThumbnail

    fun onClick() {
        Log.i(TAG, "onClick: ${photo!!.webPageUrl}")
        PhotoActivity.start(context, photo!!)
    }
}