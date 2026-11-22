package com.example.jessica_tia
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class VocabularyLessonActivity : AppCompatActivity() { override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_vocabulary_lesson); findViewById<Button>(R.id.btnUnderstand).setOnClickListener { startActivity(Intent(this, QuizActivity::class.java)) } } }