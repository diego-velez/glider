package org.supersoniclegend.glider.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.squareup.picasso.Picasso
import org.supersoniclegend.glider.R
import org.supersoniclegend.glider.databinding.ActivityPhotoBinding
import org.supersoniclegend.glider.model.ImageRepository
import org.supersoniclegend.glider.model.PhotoViewModel

private const val TAG = "PhotoActivity"

private const val PHOTO_ID = "photo_id"
private const val PHOTO_URL = "photo_url"

class PhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityPhotoBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_photo
        )

        binding.viewModel = PhotoViewModel()

        val photoId = intent.getStringExtra(PHOTO_ID)
            ?: throw IllegalStateException("Use start function")
        val photoUrl = intent.getStringExtra(PHOTO_URL)
            ?: throw IllegalStateException("Use start function")

        binding.viewModel!!.photoUrl = photoUrl
    }

    companion object {
        @JvmStatic
        fun start(context: Context, photoId: String, photoUrl: String) {
            val starter = Intent(context, PhotoActivity::class.java).apply {
                putExtra(PHOTO_ID, photoId)
                putExtra(PHOTO_URL, photoUrl)
            }
            context.startActivity(starter)
        }
    }
}