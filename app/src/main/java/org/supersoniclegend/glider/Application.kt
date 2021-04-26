package org.supersoniclegend.glider

import android.app.Application
import org.supersoniclegend.glider.model.ImageRepository

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        ImageRepository.initialize(this)
    }
}