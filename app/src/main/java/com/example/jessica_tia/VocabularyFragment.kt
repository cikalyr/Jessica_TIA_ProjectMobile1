package com.example.jessica_tia

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.jessica_tia.adapter.VocabularyAdapter
import com.example.jessica_tia.model.Vocabulary

class VocabularyFragment : Fragment(R.layout.fragment_vocabulary) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vocabulary = listOf(
            Vocabulary("Hello", "Halo", "Hello, how are you?", "https://i.pravatar.cc/120?img=1"),
            Vocabulary("Thank you", "Terima kasih", "Thank you for your help.", "https://i.pravatar.cc/120?img=2"),
            Vocabulary("Apple", "Apel", "I eat an apple.", "https://i.pravatar.cc/120?img=3"),
            Vocabulary("Book", "Buku", "This is my book.", "https://i.pravatar.cc/120?img=4"),
            Vocabulary("Friend", "Teman", "She is my friend.", "https://i.pravatar.cc/120?img=5"),
            Vocabulary("Good morning", "Selamat pagi", "Good morning, everyone.", "https://i.pravatar.cc/120?img=6")
        )
        val listView = view.findViewById<ListView>(R.id.listVocabulary)
        listView.adapter = VocabularyAdapter(requireContext(), vocabulary)
        listView.setOnItemClickListener { _, _, position, _ ->
            val selected = vocabulary[position]
            Toast.makeText(requireContext(), "${selected.word} = ${selected.meaning}", Toast.LENGTH_SHORT).show()
        }
    }
}
