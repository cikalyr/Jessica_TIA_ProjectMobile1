package com.example.jessica_tia

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jessica_tia.databinding.FragmentTabCBinding
import com.google.android.material.chip.Chip

class TabCFragment : Fragment(R.layout.fragment_tab_c) {
    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    private val lessons = listOf(
        ProductModel("Basic Greetings", "Learn hello, goodbye, and polite greetings", "Beginner", "https://picsum.photos/seed/lingua01/500/350"),
        ProductModel("Introducing Yourself", "Introduce your name and background", "Beginner", "https://picsum.photos/seed/lingua02/500/350"),
        ProductModel("Numbers and Time", "Practice numbers, dates, and time", "Beginner", "https://picsum.photos/seed/lingua03/500/350"),
        ProductModel("Family Members", "Talk about your family", "Beginner", "https://picsum.photos/seed/lingua04/500/350"),
        ProductModel("Food and Drinks", "Useful words for ordering food", "Beginner", "https://picsum.photos/seed/lingua05/500/350"),
        ProductModel("At the Restaurant", "Practice ordering a meal", "Intermediate", "https://picsum.photos/seed/lingua06/500/350"),
        ProductModel("Travel Vocabulary", "Words for trips and transport", "Intermediate", "https://picsum.photos/seed/lingua07/500/350"),
        ProductModel("Asking Directions", "Ask for places and directions", "Intermediate", "https://picsum.photos/seed/lingua08/500/350"),
        ProductModel("Daily Activities", "Describe your daily routine", "Beginner", "https://picsum.photos/seed/lingua09/500/350"),
        ProductModel("At School", "Classroom and study vocabulary", "Beginner", "https://picsum.photos/seed/lingua10/500/350"),
        ProductModel("At Work", "Common workplace expressions", "Intermediate", "https://picsum.photos/seed/lingua11/500/350"),
        ProductModel("Shopping", "Ask prices and sizes", "Beginner", "https://picsum.photos/seed/lingua12/500/350"),
        ProductModel("Weather", "Describe the weather", "Beginner", "https://picsum.photos/seed/lingua13/500/350"),
        ProductModel("Feelings", "Express emotions and opinions", "Intermediate", "https://picsum.photos/seed/lingua14/500/350"),
        ProductModel("Hobbies", "Talk about free-time activities", "Beginner", "https://picsum.photos/seed/lingua15/500/350"),
        ProductModel("Body Parts", "Learn vocabulary about the body", "Beginner", "https://picsum.photos/seed/lingua16/500/350"),
        ProductModel("Health", "Explain simple health problems", "Intermediate", "https://picsum.photos/seed/lingua17/500/350"),
        ProductModel("Transportation", "Learn transport vocabulary", "Beginner", "https://picsum.photos/seed/lingua18/500/350"),
        ProductModel("Hotel Check-in", "Useful phrases at a hotel", "Intermediate", "https://picsum.photos/seed/lingua19/500/350"),
        ProductModel("Making Friends", "Start a friendly conversation", "Beginner", "https://picsum.photos/seed/lingua20/500/350"),
        ProductModel("Present Tense", "Build simple present sentences", "Grammar", "https://picsum.photos/seed/lingua21/500/350"),
        ProductModel("Past Tense", "Talk about past experiences", "Grammar", "https://picsum.photos/seed/lingua22/500/350"),
        ProductModel("Future Tense", "Talk about future plans", "Grammar", "https://picsum.photos/seed/lingua23/500/350"),
        ProductModel("Articles", "Understand a, an, and the", "Grammar", "https://picsum.photos/seed/lingua24/500/350"),
        ProductModel("Prepositions", "Use in, on, at, and more", "Grammar", "https://picsum.photos/seed/lingua25/500/350"),
        ProductModel("Adjectives", "Describe people and things", "Grammar", "https://picsum.photos/seed/lingua26/500/350"),
        ProductModel("Adverbs", "Describe how actions happen", "Grammar", "https://picsum.photos/seed/lingua27/500/350"),
        ProductModel("Pronouns", "Use subject and object pronouns", "Grammar", "https://picsum.photos/seed/lingua28/500/350"),
        ProductModel("Question Words", "Ask who, what, where, and why", "Grammar", "https://picsum.photos/seed/lingua29/500/350"),
        ProductModel("Comparatives", "Compare two things", "Grammar", "https://picsum.photos/seed/lingua30/500/350"),
        ProductModel("Listening: Greetings", "Listen to short introductions", "Listening", "https://picsum.photos/seed/lingua31/500/350"),
        ProductModel("Listening: Numbers", "Recognize spoken numbers", "Listening", "https://picsum.photos/seed/lingua32/500/350"),
        ProductModel("Listening: Directions", "Understand simple directions", "Listening", "https://picsum.photos/seed/lingua33/500/350"),
        ProductModel("Listening: At a Cafe", "Listen to a cafe conversation", "Listening", "https://picsum.photos/seed/lingua34/500/350"),
        ProductModel("Speaking: Introduction", "Practice introducing yourself", "Speaking", "https://picsum.photos/seed/lingua35/500/350"),
        ProductModel("Speaking: Small Talk", "Practice short conversations", "Speaking", "https://picsum.photos/seed/lingua36/500/350"),
        ProductModel("Speaking: Ordering", "Practice ordering politely", "Speaking", "https://picsum.photos/seed/lingua37/500/350"),
        ProductModel("Speaking: Directions", "Ask and answer directions", "Speaking", "https://picsum.photos/seed/lingua38/500/350"),
        ProductModel("Writing: Short Message", "Write a simple message", "Writing", "https://picsum.photos/seed/lingua39/500/350"),
        ProductModel("Writing: Email", "Write a friendly email", "Writing", "https://picsum.photos/seed/lingua40/500/350"),
        ProductModel("Writing: Daily Journal", "Describe your day in writing", "Writing", "https://picsum.photos/seed/lingua41/500/350"),
        ProductModel("Writing: Invitations", "Invite someone to an event", "Writing", "https://picsum.photos/seed/lingua42/500/350"),
        ProductModel("Travel Conversation", "Practice common travel dialogs", "Intermediate", "https://picsum.photos/seed/lingua43/500/350"),
        ProductModel("Airport English", "Useful phrases at an airport", "Intermediate", "https://picsum.photos/seed/lingua44/500/350"),
        ProductModel("Job Interview", "Answer basic interview questions", "Advanced", "https://picsum.photos/seed/lingua45/500/350"),
        ProductModel("Presentation Skills", "Present an idea clearly", "Advanced", "https://picsum.photos/seed/lingua46/500/350"),
        ProductModel("Idioms", "Understand common expressions", "Advanced", "https://picsum.photos/seed/lingua47/500/350"),
        ProductModel("Phrasal Verbs", "Learn useful phrasal verbs", "Advanced", "https://picsum.photos/seed/lingua48/500/350"),
        ProductModel("Pronunciation Basics", "Practice clear pronunciation", "Speaking", "https://picsum.photos/seed/lingua49/500/350"),
        ProductModel("Review Challenge", "Review what you have learned", "Beginner", "https://picsum.photos/seed/lingua50/500/350")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTabCBinding.bind(view)
        binding.rvProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        showLessons(lessons)
        binding.chipGroup.setOnCheckedStateChangeListener { group, _ ->
            val selected = group.findViewById<Chip>(group.checkedChipId)?.text?.toString() ?: "All"
            val filtered = if (selected == "All") lessons else lessons.filter { it.category == selected }
            showLessons(filtered)
        }
    }

    private fun showLessons(items: List<ProductModel>) {
        binding.rvProducts.adapter = ProductAdapter(items) { item ->
            Toast.makeText(requireContext(), "You selected: ${item.name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
