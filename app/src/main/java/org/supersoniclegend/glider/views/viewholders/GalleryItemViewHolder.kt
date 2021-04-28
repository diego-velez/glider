package org.supersoniclegend.glider.views.viewholders

import android.annotation.SuppressLint
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import androidx.recyclerview.widget.RecyclerView
import org.supersoniclegend.glider.api.interestingness.getList.Photo
import org.supersoniclegend.glider.databinding.GalleryImageItemBinding
import org.supersoniclegend.glider.fragments.PhotoZoomDialog
import org.supersoniclegend.glider.model.GalleryItemViewModel

private const val TAG = "GalleryItemViewHolder"

@SuppressLint("ClickableViewAccessibility")
class GalleryItemViewHolder(
    private val binding: GalleryImageItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    private var currentAction = ""

    private val photoZoomDialog: PhotoZoomDialog by lazy {
        PhotoZoomDialog.newInstance(binding.viewModel!!.photo!!)
    }

    init {
        binding.apply {
            viewModel = GalleryItemViewModel(itemView.context)
        }

        GestureDetectorCompat(itemView.context, GestureListener()).apply {
            itemView.setOnTouchListener { _, event ->
                val result = onTouchEvent(event)

                when (event.action) {
                    MotionEvent.ACTION_UP -> {
                        when (currentAction) {
                            "onLongPress" -> {
                                Log.i(TAG, "Finished onLongPress")
                                photoZoomDialog.requireDialog().dismiss()
                            }
                        }
                    }
                }

                result
            }
        }
    }

    fun bind(photo: Photo) {
        binding.apply {
            viewModel?.photo = photo
            executePendingBindings()
        }
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(event: MotionEvent): Boolean {
            currentAction = "onDown"
            return true
        }

        override fun onLongPress(event: MotionEvent) {
            Log.d(TAG, "onLongPress: $event")
            currentAction = "onLongPress"
            photoZoomDialog.show(
                (itemView.context as AppCompatActivity).supportFragmentManager,
                null
            )
        }

        override fun onShowPress(event: MotionEvent) {
            Log.d(TAG, "onShowPress: $event")
        }

        override fun onSingleTapUp(event: MotionEvent): Boolean {
            Log.d(TAG, "onSingleTapUp: $event")
            binding.viewModel!!.onClick()
            return true
        }

        override fun onScroll(
            event1: MotionEvent,
            event2: MotionEvent,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            Log.d(TAG, "onScroll: $event1, $event2")
            return true
        }

        override fun onFling(
            event1: MotionEvent,
            event2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            Log.d(TAG, "onFling: $event1, $event2")
            return true
        }

        override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
            Log.d(TAG, "onSingleTapConfirmed: $event")
            return true
        }

        override fun onDoubleTap(event: MotionEvent): Boolean {
            Log.d(TAG, "onDoubleTap: $event")
            return true
        }

        override fun onDoubleTapEvent(event: MotionEvent): Boolean {
            Log.d(TAG, "onDoubleTapEvent: $event")
            return true
        }

        override fun onContextClick(event: MotionEvent): Boolean {
            Log.d(TAG, "onContextClick: $event")
            return true
        }
    }
}