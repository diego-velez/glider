package org.supersoniclegend.glider.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import org.supersoniclegend.glider.api.interestingness.getList.Photo
import org.supersoniclegend.glider.databinding.GalleryImageItemBinding

private const val TAG = "GalleryItemViewHolder"

class GalleryItemViewHolder(
    private val binding: GalleryImageItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.viewModel = GalleryItemViewModel()
    }

    fun bind(photo: Photo) {
        binding.apply {
            viewModel?.photo = photo
            executePendingBindings()
        }
    }
}