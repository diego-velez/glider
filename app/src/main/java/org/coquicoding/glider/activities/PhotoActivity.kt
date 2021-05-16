package org.coquicoding.glider.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import org.coquicoding.glider.R
import org.coquicoding.glider.api.interestingness.getList.Photo
import org.coquicoding.glider.databinding.ActivityPhotoBinding
import org.coquicoding.glider.model.DataHolder
import org.coquicoding.glider.model.PhotoViewModel

private const val TAG = "PhotoActivity"

class PhotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityPhotoBinding>(
            this,
            R.layout.activity_photo
        ).apply {
            viewModel = PhotoViewModel()
            executePendingBindings()
        }

        loadImage()
    }

    private fun loadImage() {
        val imageUrl = if (DataHolder.currentPhoto.urlOriginal.isNullOrBlank()) {
            DataHolder.currentPhoto.urlLarge
        } else {
            DataHolder.currentPhoto.urlOriginal
        }

        binding.apply {
            Picasso.get()
                .load(imageUrl)
                .into(
                    photoImage,

                    object : Callback {
                        override fun onSuccess() {
                            linearLayout.visibility = View.VISIBLE
                            progressBar.visibility = View.INVISIBLE
                        }

                        override fun onError(error: Exception) {
                            Log.e(TAG, "onError: Image failed to load", error)

                            progressBar.visibility = View.INVISIBLE
                            errorTextView.apply {
                                visibility = View.VISIBLE
                                text = getString(R.string.error, error.localizedMessage)
                            }
                        }
                    }
                )
        }
    }

    companion object {
        fun start(context: Context, photo: Photo) {
            Log.i(TAG, "start: $photo")

            DataHolder.currentPhoto = photo
            context.let {
                it.startActivity(Intent(it, PhotoActivity::class.java))
            }
        }
    }
}