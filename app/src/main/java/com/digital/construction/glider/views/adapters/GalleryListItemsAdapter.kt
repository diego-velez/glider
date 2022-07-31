package com.digital.construction.glider.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.digital.construction.glider.R
import com.digital.construction.glider.api.interestingness.getList.Photo
import com.digital.construction.glider.databinding.GalleryImageItemBinding
import com.digital.construction.glider.views.viewholders.GalleryItemViewHolder

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