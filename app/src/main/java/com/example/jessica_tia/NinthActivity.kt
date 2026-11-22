package com.example.jessica_tia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class NinthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ninth)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarNinth)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        val chips = listOf(R.id.chipEnglish, R.id.chipJapanese, R.id.chipKorean, R.id.chipSpanish)
        findViewById<com.google.android.material.chip.ChipGroup>(R.id.chipGroupLanguage)
            .setOnCheckedStateChangeListener { group, ids ->
                val id = ids.firstOrNull()
                if (id != null) {
                    val chip = group.findViewById<Chip>(id)
                    Toast.makeText(this, "Language: ${chip.text}", Toast.LENGTH_SHORT).show()
                }
            }

        val menuIds = listOf(R.id.btnGridVocabulary, R.id.btnGridQuiz, R.id.btnGridGrammar,
            R.id.btnGridListening, R.id.btnGridSpeaking, R.id.btnGridProgress)
        menuIds.forEach { id ->
            findViewById<MaterialButton>(id).setOnClickListener {
                Toast.makeText(this, "${(it as MaterialButton).text} selected", Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<MaterialButton>(R.id.btnSavePractice).setOnClickListener {
            val name = findViewById<TextInputEditText>(R.id.etLearnerName).text?.toString()?.trim().orEmpty()
            if (name.isEmpty()) Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            else {
                getSharedPreferences("LinguaLoopPrefs", MODE_PRIVATE).edit().putString("username", name).apply()
                Toast.makeText(this, "Preferences saved", Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<MaterialButton>(R.id.btnOpenTutorial).setOnClickListener {
            startActivity(Intent(this, TutorialActivity::class.java))
        }
    }
}
