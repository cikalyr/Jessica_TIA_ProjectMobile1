package com.example.jessica_tia

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefs = requireActivity().getSharedPreferences("LinguaLoopPrefs", android.content.Context.MODE_PRIVATE)
        val username = prefs.getString("username", "Learner") ?: "Learner"
        view.findViewById<TextView>(R.id.txtWelcome).text = "Hai, $username! 👋"
        view.findViewById<Button>(R.id.btnStartLesson).setOnClickListener {
            startActivity(Intent(requireContext(), LearningPathActivity::class.java))
        }
        view.findViewById<Button>(R.id.btnPracticeComponents).setOnClickListener {
            startActivity(Intent(requireContext(), NinthActivity::class.java))
        }
        view.findViewById<Button>(R.id.btnHomeTutorial).setOnClickListener {
            startActivity(Intent(requireContext(), TutorialActivity::class.java))
        }
        view.findViewById<Button>(R.id.btnToTenth).setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }
    }
}
