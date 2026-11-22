package com.example.jessica_tia
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class QuizActivity : AppCompatActivity() { override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_quiz); findViewById<Button>(R.id.btnCheckAnswer).setOnClickListener { val selected = findViewById<RadioGroup>(R.id.quizOptions).checkedRadioButtonId; if (selected == -1) { Toast.makeText(this, "Pilih jawaban dulu ya!", Toast.LENGTH_SHORT).show() } else { val correct = selected == R.id.optionB; startActivity(Intent(this, ResultActivity::class.java).putExtra("correct", correct)); finish() } } } }