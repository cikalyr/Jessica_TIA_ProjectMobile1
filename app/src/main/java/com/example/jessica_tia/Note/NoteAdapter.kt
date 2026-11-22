package com.example.jessica_tia.Note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jessica_tia.R
import com.example.jessica_tia.data.entity.NoteEntity

class NoteAdapter(
    private val onClick: (NoteEntity) -> Unit,
    private val onLongClick: (NoteEntity) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private val items = mutableListOf<NoteEntity>()
    fun submitList(data: List<NoteEntity>) { items.clear(); items.addAll(data); notifyDataSetChanged() }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size
    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.txtNoteTitle)
        private val content: TextView = view.findViewById(R.id.txtNoteContent)
        fun bind(note: NoteEntity) {
            title.text = (if (note.isPinned) "★ " else "") + note.title
            content.text = note.content
            itemView.setOnClickListener { onClick(note) }
            itemView.setOnLongClickListener { onLongClick(note); true }
        }
    }
}
