package org.supersoniclegend.glider.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.supersoniclegend.glider.api.FlickrApi
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

    fun fetchPhotos(): LiveData<List<PhotoItem>> {
        val responseLiveData: MutableLiveData<List<PhotoItem>> = MutableLiveData()

        flickrApi.fetchPhotos().apply {
            enqueue(
                object : Callback<FlickrResponse> {
                    override fun onResponse(
                        call: Call<FlickrResponse>,
                        response: Response<FlickrResponse>
                    ) {
                        Log.d(TAG, "Response received")

                        val flickrResponse = response.body()
                        val photoResponse = flickrResponse?.photos

                        responseLiveData.value = photoResponse?.photoItems ?: emptyList()
                    }

                    override fun onFailure(call: Call<FlickrResponse>, error: Throwable) {
                        Log.e(TAG, "onFailure: $call", error)
                    }
                }
            )
        }

        return responseLiveData
    }
}