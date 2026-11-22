package com.example.jessica_tia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.jessica_tia.Note.NoteActivity

class MoreFragment : Fragment(R.layout.fragment_more) {
    private val topics = listOf("Greetings", "Introducing Yourself", "Numbers & Time", "Daily Conversation", "Travel English", "Food & Drinks")
    private val descriptions = listOf("Basic hello and goodbye expressions", "Tell people your name", "Learn numbers and time", "Practice everyday sentences", "Useful phrases when travelling", "Vocabulary about meals")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = view.findViewById<ListView>(R.id.listMoreTopics)
        val btnArray = view.findViewById<Button>(R.id.btnArrayAdapter)
        val btnSimple = view.findViewById<Button>(R.id.btnSimpleAdapter)
        view.findViewById<Button>(R.id.btnOpenNotes).setOnClickListener {
            startActivity(Intent(requireContext(), NoteActivity::class.java))
        }

        fun showArrayAdapter() {
            list.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, topics)
            list.setOnItemClickListener { _, _, position, _ ->
                Toast.makeText(requireContext(), topics[position], Toast.LENGTH_SHORT).show()
            }
        }
        fun showSimpleAdapter() {
            val rows = topics.indices.map { i ->
                hashMapOf<String, String>("title" to topics[i], "description" to descriptions[i])
            }
            val adapter = SimpleAdapter(requireContext(), rows, android.R.layout.simple_list_item_2,
                arrayOf("title", "description"), intArrayOf(android.R.id.text1, android.R.id.text2))
            list.adapter = adapter
            list.setOnItemClickListener { _, _, position, _ ->
                Toast.makeText(requireContext(), descriptions[position], Toast.LENGTH_SHORT).show()
            }
        }
        btnArray.setOnClickListener { showArrayAdapter() }
        btnSimple.setOnClickListener { showSimpleAdapter() }
        showArrayAdapter()
    }
}
