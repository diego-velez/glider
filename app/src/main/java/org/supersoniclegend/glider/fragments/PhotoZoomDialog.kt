package org.supersoniclegend.glider.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import org.supersoniclegend.glider.model.DataHolder
import org.supersoniclegend.glider.api.interestingness.getList.Photo
import org.supersoniclegend.glider.databinding.DialogPhotoZoomBinding

class PhotoZoomDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogPhotoZoomBinding.inflate(layoutInflater).apply {
            photo = DataHolder.currentPhoto
        }

        return AlertDialog.Builder(requireContext())
            .setTitle(DataHolder.currentPhoto.title)
            .setView(binding.root)
            .create()
    }

    companion object {
        fun newInstance(photo: Photo): PhotoZoomDialog {
            DataHolder.currentPhoto = photo
            return PhotoZoomDialog()
        }
    }
}