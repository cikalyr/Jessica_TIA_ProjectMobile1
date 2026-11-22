package com.example.jessica_tia

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "LinguaLoop"

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        if (savedInstanceState == null) showFragment(HomeFragment())
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> showFragment(HomeFragment())
                R.id.nav_vocabulary -> showFragment(VocabularyFragment())
                R.id.nav_profile -> showFragment(ProfileFragment())
                R.id.nav_more -> showFragment(MoreFragment())
            }
            true
        }
    }

    private fun showFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_tutorial -> {
                startActivity(Intent(this, TutorialActivity::class.java)); true
            }
            R.id.menu_learning_info -> {
                startActivity(Intent(this, WebViewActivity::class.java)); true
            }
            R.id.menu_logout -> { showLogoutDialog(); true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showLogoutDialog() {
        AlertDialog.Builder(this)
            .setTitle("Keluar dari LinguaLoop?")
            .setMessage("Progres belajar lokal tetap tersimpan di perangkat ini. Kamu yakin ingin logout?")
            .setNegativeButton("Batal", null)
            .setPositiveButton("Logout") { _, _ ->
                getSharedPreferences("LinguaLoopPrefs", MODE_PRIVATE).edit()
                    .putBoolean("isLoggedIn", false).apply()
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }.show()
    }
}
