package org.supersoniclegend.glider.api

import org.supersoniclegend.glider.api.interestingness.getList.PhotosResponse
import retrofit2.Call
import retrofit2.http.GET

interface FlickrApi {
    @GET("services/rest/?method=flickr.interestingness.getList")
    fun fetchPhotos(): Call<PhotosResponse>
}