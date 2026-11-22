package com.example.jessica_tia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.jessica_tia.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class TenthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Explore LinguaLoop"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { finish() }

        binding.viewPager.adapter = TenthTabsAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Discover"
                    tab.icon = ContextCompat.getDrawable(this, android.R.drawable.ic_menu_view)
                    tab.getOrCreateBadge().apply { isVisible = true }
                }
                1 -> {
                    tab.text = "Study Tips"
                    tab.icon = ContextCompat.getDrawable(this, android.R.drawable.ic_menu_info_details)
                    tab.getOrCreateBadge().apply { isVisible = true; number = 3 }
                }
                2 -> {
                    tab.text = "Lessons"
                    tab.icon = ContextCompat.getDrawable(this, android.R.drawable.ic_menu_agenda)
                }
            }
        }.attach()
    }
}
