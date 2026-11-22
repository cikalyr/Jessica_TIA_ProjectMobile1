package com.example.jessica_tia

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lifecycleScope.launch {
            delay(900)
            val prefs = getSharedPreferences("LinguaLoopPrefs", MODE_PRIVATE)
            val target = if (prefs.getBoolean("isLoggedIn", false)) MainActivity::class.java else LoginActivity::class.java
            startActivity(Intent(this@SplashActivity, target))
            finish()
        }
    }
}
