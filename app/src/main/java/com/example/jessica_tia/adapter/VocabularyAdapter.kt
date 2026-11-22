package com.example.jessica_tia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.jessica_tia.R
import com.example.jessica_tia.model.Vocabulary

class VocabularyAdapter(context: Context, private val items: List<Vocabulary>) : ArrayAdapter<Vocabulary>(context, 0, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_vocabulary, parent, false)
        val item = items[position]
        view.findViewById<TextView>(R.id.txtWord).text = item.word
        view.findViewById<TextView>(R.id.txtMeaning).text = item.meaning
        view.findViewById<TextView>(R.id.txtExample).text = "Example: ${item.example}"
        Glide.with(context).load(item.avatarUrl).circleCrop().placeholder(android.R.drawable.sym_def_app_icon).error(android.R.drawable.sym_def_app_icon).into(view.findViewById<ImageView>(R.id.imgVocabularyAvatar))
        return view
    }
}
