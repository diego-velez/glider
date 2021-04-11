package org.supersoniclegend.glider.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.supersoniclegend.glider.R
import org.supersoniclegend.glider.model.FlickrResponse
import org.supersoniclegend.glider.model.PhotoItem
import org.supersoniclegend.glider.views.viewholders.GalleryItemViewHolder

class GalleryListItemsAdapter(
    var list: List<PhotoItem>
) : RecyclerView.Adapter<GalleryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryItemViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.gallery_image_item, parent, false)
        return GalleryItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryItemViewHolder, position: Int) {
        val image = list[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int = list.size
}