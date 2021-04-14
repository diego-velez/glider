package org.supersoniclegend.glider.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.supersoniclegend.glider.R
import org.supersoniclegend.glider.api.interestingness.getList.Photo
import org.supersoniclegend.glider.databinding.GalleryImageItemBinding
import org.supersoniclegend.glider.views.viewholders.GalleryItemViewHolder

class GalleryListItemsAdapter(
    var list: List<Photo>
) : RecyclerView.Adapter<GalleryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryItemViewHolder {

        val binding: GalleryImageItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.gallery_image_item,
            parent,
            false
        )
        return GalleryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryItemViewHolder, position: Int) {
        val image = list[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int = list.size
}