package com.saxenasachin.redditpics.ui

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.saxenasachin.redditpics.databinding.ActivitySplashBinding

/**
Created by Sachin Saxena on 19/06/22.
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToMainActivity()
    }

    private fun goToMainActivity() {
        Handler().postDelayed({
            DashboardActivity.getStartIntent(this).apply {
                startActivity(this)
            }
            finish()
        },
            SPLASH_WAITING_TIME
        )
    }

    companion object {
        private const val SPLASH_WAITING_TIME = 2000L // 2 seconds.
    }
}