package org.coquicoding.glider

import android.app.Application
import org.coquicoding.glider.model.ImageRepository

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        ImageRepository.initialize(this)
    }
}