package com.example.jessica_tia.Note

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jessica_tia.R

class NoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.noteToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "My Learning Notes"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
        if (savedInstanceState == null) supportFragmentManager.beginTransaction()
            .replace(R.id.noteContainer, NoteFragment()).commit()
    }
}
