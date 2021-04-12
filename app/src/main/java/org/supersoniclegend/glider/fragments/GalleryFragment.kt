package org.supersoniclegend.glider.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.supersoniclegend.glider.R
import org.supersoniclegend.glider.views.adapters.GalleryListItemsAdapter

private const val TAG = "GalleryFragment"

class GalleryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val galleryViewModel: GalleryViewModel by lazy {
        ViewModelProvider(this).get(GalleryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_gallery, container, false).apply {
            recyclerView = findViewById(R.id.gallery_recycler_view)
            recyclerView.layoutManager = GridLayoutManager(context, 3)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        galleryViewModel.photoItemsLiveData.observe(viewLifecycleOwner) { photoItems ->
            recyclerView.adapter = GalleryListItemsAdapter(photoItems)
        }
    }

    companion object {
        fun newInstance(): GalleryFragment {
            return GalleryFragment()
        }
    }
}