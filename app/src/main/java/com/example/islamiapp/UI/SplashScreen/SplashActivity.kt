package com.example.islamiapp.UI.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.UI.MainActivity.MainActivity
import com.example.islamiapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        enableEdgeToEdge(navigationBarStyle= SystemBarStyle.dark(0))
     Handler().postDelayed({
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
            }
            finish()
        }, 2000)



    }
}