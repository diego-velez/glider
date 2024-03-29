package com.digital.construction.glider.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.digital.construction.glider.R
import com.digital.construction.glider.fragments.GalleryFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentContainer = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragmentContainer == null) {
            supportFragmentManager.commit {
                val fragment = GalleryFragment.newInstance()
                replace(R.id.fragment_container, fragment)
            }
        }
    }
}