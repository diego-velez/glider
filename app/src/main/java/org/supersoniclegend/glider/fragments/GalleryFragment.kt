package org.supersoniclegend.glider.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import org.supersoniclegend.glider.databinding.FragmentGalleryBinding
import org.supersoniclegend.glider.utils.Resource
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

        binding.apply {
            galleryRecyclerView.apply {
                adapter = GalleryListItemsAdapter()
                
                layoutManager =
                    if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        GridLayoutManager(context, 5)
                    } else {
                        GridLayoutManager(context, 3)
                    }
            }

            setupLiveData()

            swipeToRefreshLayout.setOnRefreshListener {
                refreshPhotoItems()
            }
        }
    }

    private fun refreshPhotoItems() {
        Log.d(TAG, "refreshPhotoItems")

        setupLiveData()
        binding.swipeToRefreshLayout.isRefreshing = false
    }

    private fun setupLiveData() {
        binding.apply {
            galleryViewModel.photoItemsLiveData().observe(viewLifecycleOwner) { status ->
                when (status) {
                    is Resource.Error -> {
                        Log.e(TAG, "onViewCreated", status.error)

                        progressBar.visibility = View.INVISIBLE
                        galleryRecyclerView.visibility = View.INVISIBLE
                        errorText.apply {
                            visibility = View.VISIBLE
                            text = status.error?.message
                        }
                    }
                    is Resource.Loading -> {
                        progressBar.visibility = View.VISIBLE
                        galleryRecyclerView.visibility = View.INVISIBLE
                        errorText.visibility = View.INVISIBLE
                    }
                    is Resource.Success -> {
                        progressBar.visibility = View.INVISIBLE
                        galleryRecyclerView.visibility = View.VISIBLE
                        errorText.visibility = View.INVISIBLE

                        (galleryRecyclerView.adapter as GalleryListItemsAdapter)
                            .submitList(status.data?.photos?.photos)
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance(): GalleryFragment {
            return GalleryFragment()
        }
    }
}