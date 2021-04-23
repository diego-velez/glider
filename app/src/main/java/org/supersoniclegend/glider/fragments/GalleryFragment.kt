package org.supersoniclegend.glider.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import org.supersoniclegend.glider.databinding.FragmentGalleryBinding
import org.supersoniclegend.glider.views.adapters.GalleryListItemsAdapter

private const val TAG = "GalleryFragment"

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding

    private val galleryViewModel: GalleryViewModel by lazy {
        ViewModelProvider(this).get(GalleryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        galleryViewModel.photoItemsLiveData.observe(viewLifecycleOwner) { photoItems ->
            Log.d(TAG, "onViewCreated: Received ${photoItems.size} photos")

            binding.galleryRecyclerView.apply {
                layoutManager = GridLayoutManager(context, 3)
                adapter = GalleryListItemsAdapter(photoItems)
            }
        }

        binding.swipeToRefreshLayout.setOnRefreshListener {
            refreshPhotoItems()
        }
    }

    private fun refreshPhotoItems() {
        Log.d(TAG, "refreshPhotoItems")

        galleryViewModel.refreshPhotoItems()
        binding.swipeToRefreshLayout.isRefreshing = false
    }

    companion object {
        fun newInstance(): GalleryFragment {
            return GalleryFragment()
        }
    }
}