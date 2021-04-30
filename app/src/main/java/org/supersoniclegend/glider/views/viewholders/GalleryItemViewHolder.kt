package org.supersoniclegend.glider.views.viewholders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import org.supersoniclegend.glider.api.interestingness.getList.Photo
import org.supersoniclegend.glider.databinding.GalleryImageItemBinding
import org.supersoniclegend.glider.model.GalleryItemViewModel

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