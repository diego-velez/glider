package org.supersoniclegend.glider.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.supersoniclegend.glider.api.FlickrApi
import org.supersoniclegend.glider.api.interestingness.getList.PhotosResponse
import org.supersoniclegend.glider.api.interestingness.getList.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "ImageRepository"

class ImageRepository {

    private val flickrApi: FlickrApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create())
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
                        Log.d(TAG, "Response received")

                        val flickrResponse = response.body()
                        val photoResponse = flickrResponse?.photos

                        responseLiveData.value = photoResponse?.photos ?: emptyList()
                    }

                    override fun onFailure(call: Call<PhotosResponse>, error: Throwable) {
                        Log.e(TAG, "onFailure: $call", error)
                    }
                }
            )
        }

        return responseLiveData
    }
}