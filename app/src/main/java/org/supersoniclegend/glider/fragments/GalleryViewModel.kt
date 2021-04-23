package org.supersoniclegend.glider.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.supersoniclegend.glider.api.interestingness.getList.Photo
import org.supersoniclegend.glider.model.ImageRepository

class GalleryViewModel : ViewModel() {
    private val imageRepository = ImageRepository.get()

    var photoItemsLiveData: LiveData<List<Photo>> = imageRepository.fetchPhotos()
        private set

    fun refreshPhotoItems() {
        photoItemsLiveData = imageRepository.fetchPhotos()
    }
}