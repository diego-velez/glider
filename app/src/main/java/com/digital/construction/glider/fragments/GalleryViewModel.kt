package com.digital.construction.glider.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.digital.construction.glider.model.ImageRepository
import com.digital.construction.glider.utils.Resource

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