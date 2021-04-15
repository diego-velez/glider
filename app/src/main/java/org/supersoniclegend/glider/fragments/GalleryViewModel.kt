package org.supersoniclegend.glider.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.supersoniclegend.glider.api.interestingness.getList.Photo
import org.supersoniclegend.glider.api.photos.getInfo.PhotoResponse
import org.supersoniclegend.glider.model.ImageRepository

class GalleryViewModel : ViewModel() {
    private val imageRepository = ImageRepository.get()

    val photoItemsLiveData: LiveData<List<Photo>> = imageRepository.fetchPhotos()
}