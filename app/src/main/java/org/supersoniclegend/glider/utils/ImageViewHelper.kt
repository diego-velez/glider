package org.supersoniclegend.glider.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

interface ImageViewHelper {
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