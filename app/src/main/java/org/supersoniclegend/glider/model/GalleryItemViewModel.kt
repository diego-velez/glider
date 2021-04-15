package org.supersoniclegend.glider.model

import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import com.squareup.picasso.Picasso
import org.supersoniclegend.glider.api.interestingness.getList.Photo

private const val TAG = "GalleryItemViewModel"

class GalleryItemViewModel : BaseObservable() {

    var photo: Photo? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.imageUrl)
        }

    @get:Bindable
    val imageUrl: String?
        get() = photo?.urlSmallThumbnail

    fun onClick() {
        Log.i(TAG, "Photo onClick: ${photo!!.webPageUrl}")
    }

    companion object {
        @JvmStatic
        @BindingAdapter("image_url")
        fun loadImage(view: AppCompatImageView, url: String) {
            Picasso.get()
                .load(url)
                .fit()
                .centerCrop()
                .into(view)
        }
    }
}