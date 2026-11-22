package com.example.jessica_tia

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefs = requireActivity().getSharedPreferences("LinguaLoopPrefs", android.content.Context.MODE_PRIVATE)
        view.findViewById<TextView>(R.id.txtProfileName).text = prefs.getString("username", "Learner")
        view.findViewById<Button>(R.id.btnProfileLogout).setOnClickListener {
            (requireActivity() as MainActivity).showLogoutDialog()
        }
    }
}
