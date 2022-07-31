package com.digital.construction.glider.api

import com.digital.construction.glider.api.interestingness.getList.PhotosResponse
import com.digital.construction.glider.api.photos.getInfo.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    @GET("services/rest/?method=flickr.interestingness.getList")
    suspend fun fetchPhotos(): PhotosResponse

    @GET("services/rest/?method=flickr.photos.getInfo")
    fun getPhotoInfo(@Query("photo_id") photoId: String): Call<PhotoResponse>

    companion object {
        const val BASE_URL = "https://api.flickr.com/"
    }
}