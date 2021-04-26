package org.supersoniclegend.glider.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import org.supersoniclegend.glider.model.ImageRepository
import org.supersoniclegend.glider.utils.Resource

class GalleryViewModel : ViewModel() {
    private val imageRepository = ImageRepository.get()

    fun photoItemsLiveData() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(data = imageRepository.fetchPhotos()))
        } catch (error: Exception) {
            emit(Resource.Error(error = error, data = null))
        }
    }
}