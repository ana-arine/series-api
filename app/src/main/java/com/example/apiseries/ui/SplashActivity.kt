package com.example.apiseries.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.apiseries.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(ActivitySplashBinding.inflate(layoutInflater).root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, SeriesListActivity::class.java))
        }, 3000)
    }
}