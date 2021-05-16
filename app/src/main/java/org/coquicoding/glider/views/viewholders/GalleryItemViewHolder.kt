package org.coquicoding.glider.views.viewholders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import org.coquicoding.glider.api.interestingness.getList.Photo
import org.coquicoding.glider.databinding.GalleryImageItemBinding
import org.coquicoding.glider.model.GalleryItemViewModel

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