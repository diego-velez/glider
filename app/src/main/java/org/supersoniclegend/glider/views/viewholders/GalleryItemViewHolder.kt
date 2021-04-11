package org.supersoniclegend.glider.views.viewholders

import android.graphics.drawable.ShapeDrawable
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.supersoniclegend.glider.R
import org.supersoniclegend.glider.model.PhotoItem

class GalleryItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var imageView: AppCompatImageView = itemView.findViewById(R.id.photo)

    fun bind(photo: PhotoItem) {
        Picasso.get()
            .load(photo.url_s)
            .placeholder(ShapeDrawable())
            .into(imageView)
    }
}