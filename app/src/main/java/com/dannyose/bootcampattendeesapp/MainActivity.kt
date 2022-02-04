package com.dannyose.bootcampattendeesapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Button
import com.dannyose.bootcampattendeesapp.alllearners.am.AmHomeActivity
import com.dannyose.bootcampattendeesapp.alllearners.pm.PmHomeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var amSection: Button
    private lateinit var pmSection: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // why
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        amSection = findViewById(R.id.am_section)
        pmSection = findViewById(R.id.pm_section)

        amSection.setOnClickListener{
            val intent = Intent(this, AmHomeActivity::class.java)
            startActivity(intent)
        }

        pmSection.setOnClickListener {
            val intent = Intent(this, PmHomeActivity::class.java)
            startActivity(intent)
        }
    }
}