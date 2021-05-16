package org.coquicoding.glider.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import org.coquicoding.glider.R
import org.coquicoding.glider.api.interestingness.getList.Photo
import org.coquicoding.glider.databinding.GalleryImageItemBinding
import org.coquicoding.glider.views.viewholders.GalleryItemViewHolder

class GalleryListItemsAdapter : ListAdapter<Photo, GalleryItemViewHolder>(PhotoComparator()) {

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
        val photo = getItem(position)
        holder.bind(photo)
    }

    class PhotoComparator : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }
}