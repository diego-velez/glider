package com.digital.construction.glider.views.viewholders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.digital.construction.glider.api.interestingness.getList.Photo
import com.digital.construction.glider.databinding.GalleryImageItemBinding
import com.digital.construction.glider.model.GalleryItemViewModel

private const val TAG = "GalleryItemViewHolder"

@SuppressLint("ClickableViewAccessibility")
class GalleryItemViewHolder(
    private val binding: GalleryImageItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.apply {
            viewModel = GalleryItemViewModel(itemView.context)

            root.setOnClickListener {
                binding.viewModel!!.onClick()
            }
        }
    }

    fun bind(photo: Photo) {
        binding.apply {
            viewModel?.photo = photo
            executePendingBindings()
        }
    }
}