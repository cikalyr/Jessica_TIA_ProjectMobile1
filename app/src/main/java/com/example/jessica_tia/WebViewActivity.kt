package com.example.jessica_tia

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        val toolbar = findViewById<Toolbar>(R.id.webToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Tips Belajar"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        val appBar = findViewById<AppBarLayout>(R.id.webAppBar)
        val webView = findViewById<WebView>(R.id.webView)
        webView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) appBar.setExpanded(false, true)
            else if (scrollY < oldScrollY) appBar.setExpanded(true, true)
        }
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = false
        webView.loadDataWithBaseURL(null, """
            <html><body style='font-family:sans-serif;padding:20px;color:#4b2634'>
            <h1>Tips Belajar Bahasa</h1>
            <p>Belajar sedikit demi sedikit setiap hari.</p>
            <ol><li>Hafalkan 5 kosakata baru.</li><li>Ucapkan kosakata dengan suara keras.</li><li>Buat satu kalimat sederhana.</li><li>Ulangi materi yang sudah dipelajari.</li></ol>
            <p><b>Keep learning with LinguaLoop!</b></p>
            </body></html>
        """.trimIndent(), "text/html", "UTF-8", null)
    }
}
