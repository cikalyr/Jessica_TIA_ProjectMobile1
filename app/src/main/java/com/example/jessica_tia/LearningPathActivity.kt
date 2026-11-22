package com.example.jessica_tia
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class LearningPathActivity : AppCompatActivity() { override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_learning_path); findViewById<Button>(R.id.btnPathStart).setOnClickListener { startActivity(Intent(this, VocabularyLessonActivity::class.java)) } } }