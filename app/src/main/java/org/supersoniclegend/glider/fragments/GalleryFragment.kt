package org.supersoniclegend.glider.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.supersoniclegend.glider.R
import org.supersoniclegend.glider.model.FlickrResponse
import org.supersoniclegend.glider.model.ImageRepository
import org.supersoniclegend.glider.views.adapters.GalleryListItemsAdapter
import retrofit2.Call
import retrofit2.Response

class GalleryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val adapter = GalleryListItemsAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_gallery, container, false).apply {
            recyclerView = findViewById(R.id.gallery_recycler_view)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ImageRepository().fetchPhotos().enqueue(
            object : retrofit2.Callback<FlickrResponse> {
                override fun onResponse(
                    call: Call<FlickrResponse>,
                    response: Response<FlickrResponse>
                ) {
                    recyclerView.adapter = adapter.apply {
                        list = response.body()!!.photos.photoItems
                    }
                }

                override fun onFailure(call: Call<FlickrResponse>, t: Throwable) {
                }
            }
        )

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = adapter
    }

    companion object {
        fun newInstance(): GalleryFragment {
            return GalleryFragment()
        }
    }
}