package com.dannyose.bootcampattendeesapp.splashui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dannyose.bootcampattendeesapp.R
import com.dannyose.bootcampattendeesapp.splashui.introslides.IntroActivity

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_SCREEN_DELAY_TIME:Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this, IntroActivity::class.java))
            finish()
        }, SPLASH_SCREEN_DELAY_TIME)
    }
}