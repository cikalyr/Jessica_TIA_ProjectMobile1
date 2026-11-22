package com.example.jessica_tia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val prefs = getSharedPreferences("LinguaLoopPrefs", MODE_PRIVATE)
        if (prefs.getBoolean("isLoggedIn", false)) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }
        setContentView(R.layout.activity_login)

        val usernameInput = findViewById<EditText>(R.id.edtUsername)
        val passwordInput = findViewById<EditText>(R.id.edtPassword)
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan password wajib diisi", Toast.LENGTH_SHORT).show()
            } else {
                prefs.edit().putString("username", username).putBoolean("isLoggedIn", true).apply()
                Toast.makeText(this, "Selamat datang, $username!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}
