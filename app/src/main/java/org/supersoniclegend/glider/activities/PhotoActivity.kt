package org.supersoniclegend.glider.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.supersoniclegend.glider.R
import org.supersoniclegend.glider.api.interestingness.getList.Photo
import org.supersoniclegend.glider.databinding.ActivityPhotoBinding
import org.supersoniclegend.glider.model.DataHolder
import org.supersoniclegend.glider.model.PhotoViewModel

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
    }

    companion object {
        fun start(context: Context, photo: Photo) {
            DataHolder.currentPhoto = photo
            context.let {
                it.startActivity(Intent(it, PhotoActivity::class.java))
            }
        }
    }
}