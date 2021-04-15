package org.supersoniclegend.glider.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.OkHttpClient
import org.supersoniclegend.glider.api.FlickrApi
import org.supersoniclegend.glider.api.FlickrInterceptor
import org.supersoniclegend.glider.api.interestingness.getList.Photo
import org.supersoniclegend.glider.api.interestingness.getList.PhotosResponse
import org.supersoniclegend.glider.api.photos.getInfo.PhotoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "ImageRepository"

class ImageRepository private constructor() {

    private val flickrApi: FlickrApi

    init {
        val client = OkHttpClient.Builder()
            .addInterceptor(FlickrInterceptor())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        flickrApi = retrofit.create(FlickrApi::class.java)
    }

    fun fetchPhotos(): LiveData<List<Photo>> {
        val responseLiveData: MutableLiveData<List<Photo>> = MutableLiveData()

        flickrApi.fetchPhotos().apply {
            enqueue(
                object : Callback<PhotosResponse> {
                    override fun onResponse(
                        call: Call<PhotosResponse>,
                        response: Response<PhotosResponse>
                    ) {
                        Log.d(TAG, "(fetchPhotos) Response received")

                        val photosResponse = response.body()
                        val photos = photosResponse?.photos

                        responseLiveData.value = photos?.photos ?: emptyList()
                    }

                    override fun onFailure(call: Call<PhotosResponse>, error: Throwable) {
                        Log.e(TAG, "(fetchPhotos) onFailure: $call", error)
                    }
                }
            )
        }

        return responseLiveData
    }

    fun getPhotoInfo(photoId: String): LiveData<PhotoResponse> {
        val responseLiveData: MutableLiveData<PhotoResponse> = MutableLiveData()

        flickrApi.getPhotoInfo(photoId).apply {
            enqueue(
                object : Callback<PhotoResponse> {
                    override fun onResponse(
                        call: Call<PhotoResponse>,
                        response: Response<PhotoResponse>
                    ) {
                        Log.d(TAG, "(getPhotoInfo) Response received")

                        responseLiveData.value = response.body()
                    }

                    override fun onFailure(call: Call<PhotoResponse>, error: Throwable) {
                        Log.e(TAG, "(getPhotoInfo) onFailure: $call", error)
                    }
                }
            )
        }

        return responseLiveData
    }

    companion object Singleton {
        private val INSTANCE = ImageRepository()

        fun get(): ImageRepository {
            return INSTANCE
        }
    }
}