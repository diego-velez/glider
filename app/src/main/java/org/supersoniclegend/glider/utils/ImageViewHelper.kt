package org.supersoniclegend.glider.utils

import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

private const val TAG = "ImageViewHelper"

@BindingAdapter("image_url")
fun loadImage(view: AppCompatImageView, url: String) {
    Log.i(TAG, "loadImage: $url")

    Picasso.get()
        .load(url)
        .noPlaceholder()
        .noFade()
        .into(view)
}