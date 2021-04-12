package org.supersoniclegend.glider.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.supersoniclegend.glider.model.ImageRepository
import org.supersoniclegend.glider.api.interestingness.getList.Photo

class GalleryViewModel : ViewModel() {
    val photoItemsLiveData: LiveData<List<Photo>> = ImageRepository().fetchPhotos()
}