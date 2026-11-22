package com.example.jessica_tia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class TutorialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.tutorialToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        val pager = findViewById<ViewPager2>(R.id.tutorialPager)
        pager.adapter = TutorialFragmentAdapter(this)
        findViewById<DotsIndicator>(R.id.tutorialDots).attachTo(pager)
    }
}

class TutorialFragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment = TutorialPageFragment.newInstance(position)
}

class TutorialPageFragment : Fragment(R.layout.item_tutorial_page) {
    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pages = listOf(
            Triple("🌍", "Welcome to LinguaLoop", "Learn a new language one little step at a time."),
            Triple("📚", "Learn every day", "Explore vocabulary, grammar, listening, and speaking practice."),
            Triple("🏆", "Track your progress", "Complete quizzes, build your streak, and collect XP points!")
        )
        val page = pages[requireArguments().getInt(ARG_PAGE, 0)]
        view.findViewById<android.widget.TextView>(R.id.txtTutorialIcon).text = page.first
        view.findViewById<android.widget.TextView>(R.id.txtTutorialTitle).text = page.second
        view.findViewById<android.widget.TextView>(R.id.txtTutorialDesc).text = page.third
    }

    companion object {
        private const val ARG_PAGE = "page"
        fun newInstance(page: Int) = TutorialPageFragment().apply {
            arguments = Bundle().apply { putInt(ARG_PAGE, page) }
        }
    }
}
