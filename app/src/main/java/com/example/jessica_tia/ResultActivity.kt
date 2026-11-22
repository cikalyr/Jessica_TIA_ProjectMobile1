package com.example.jessica_tia
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class ResultActivity : AppCompatActivity() { override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_result); val correct = intent.getBooleanExtra("correct", false); findViewById<TextView>(R.id.txtResultScore).text = if (correct) "1/1 correct answer     +20 XP earned" else "0/1 correct answer     Keep practicing!"; findViewById<Button>(R.id.btnContinueResult).setOnClickListener { val i = Intent(this, MainActivity::class.java); i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP; startActivity(i); finish() } } }