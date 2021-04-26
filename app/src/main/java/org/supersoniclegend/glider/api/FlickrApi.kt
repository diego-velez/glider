package org.supersoniclegend.glider.api

import org.supersoniclegend.glider.api.interestingness.getList.PhotosResponse
import org.supersoniclegend.glider.api.photos.getInfo.PhotoResponse
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