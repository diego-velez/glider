package org.supersoniclegend.glider.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.supersoniclegend.glider.api.interestingness.getList.Photo
import org.supersoniclegend.glider.api.photos.getInfo.PhotoResponse
import org.supersoniclegend.glider.model.ImageRepository

class GalleryViewModel : ViewModel() {
    private val imageRepository = ImageRepository()

    val photoItemsLiveData: LiveData<List<Photo>> = imageRepository.fetchPhotos()

    fun getPhotoInfo(photoId: String): LiveData<PhotoResponse> {
        return imageRepository.getPhotoInfo(photoId)
    }
}