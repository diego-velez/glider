package org.supersoniclegend.glider.views.viewholders

import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.supersoniclegend.glider.R
import org.supersoniclegend.glider.model.PhotoItem

private const val TAG = "GalleryItemViewHolder"

class GalleryItemViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private lateinit var photo: PhotoItem
    private var imageView: AppCompatImageView = itemView.findViewById(R.id.photo)

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(photo: PhotoItem) {
        this.photo = photo

        Picasso.get()
            .load(photo.urlSmallThumbnail)
            .fit()
            .centerCrop()
            .into(imageView)
    }

    override fun onClick(view: View) {
        Log.i(TAG, "Photo onClick: ${photo.webPageUrl}")
    }
}