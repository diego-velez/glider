package com.digital.construction.glider

import android.app.Application
import com.digital.construction.glider.model.ImageRepository

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        ImageRepository.initialize(this)
    }
}