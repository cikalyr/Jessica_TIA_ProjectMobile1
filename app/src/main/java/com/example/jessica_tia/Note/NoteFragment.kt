package com.example.jessica_tia.Note

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jessica_tia.R
import com.example.jessica_tia.data.AppDatabase
import com.example.jessica_tia.data.entity.NoteEntity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class NoteFragment : Fragment(R.layout.fragment_notes) {
    private lateinit var dao: com.example.jessica_tia.data.dao.NoteDao
    private lateinit var adapter: NoteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dao = AppDatabase.getInstance(requireContext()).noteDao()
        adapter = NoteAdapter(::showEditDialog, ::showDeleteDialog)
        view.findViewById<RecyclerView>(R.id.recyclerNotes).apply {
            layoutManager = LinearLayoutManager(requireContext()); adapter = this@NoteFragment.adapter
        }
        view.findViewById<FloatingActionButton>(R.id.fabAddNote).setOnClickListener { showAddDialog() }
        viewLifecycleOwner.lifecycleScope.launch {
            dao.getAllNotes().collect { notes ->
                adapter.submitList(notes)
                view.findViewById<android.widget.TextView>(R.id.txtEmptyNotes).visibility =
                    if (notes.isEmpty()) View.VISIBLE else View.GONE
            }
        }
    }

    private fun showAddDialog() = showNoteForm(null)
    private fun showEditDialog(note: NoteEntity) = showNoteForm(note)
    private fun showNoteForm(note: NoteEntity?) {
        val layout = layoutInflater.inflate(R.layout.dialog_note_form, null)
        val title = layout.findViewById<EditText>(R.id.edtNoteTitle)
        val content = layout.findViewById<EditText>(R.id.edtNoteContent)
        if (note != null) { title.setText(note.title); content.setText(note.content) }
        AlertDialog.Builder(requireContext()).setTitle(if (note == null) "Tambah Catatan" else "Edit Catatan")
            .setView(layout).setNegativeButton("Batal", null)
            .setPositiveButton("Simpan", null).create().also { dialog ->
                dialog.setOnShowListener { dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                    val t = title.text.toString().trim(); val c = content.text.toString().trim()
                    if (t.isEmpty() || c.isEmpty()) { Toast.makeText(requireContext(), "Judul dan isi wajib diisi", Toast.LENGTH_SHORT).show(); return@setOnClickListener }
                    viewLifecycleOwner.lifecycleScope.launch {
                        if (note == null) dao.insert(NoteEntity(title = t, content = c))
                        else dao.update(note.copy(title = t, content = c))
                    }; dialog.dismiss()
                } }
                dialog.show()
            }
    }
    private fun showDeleteDialog(note: NoteEntity) {
        AlertDialog.Builder(requireContext()).setTitle("Hapus catatan?")
            .setMessage("Catatan '${note.title}' akan dihapus.")
            .setNegativeButton("Batal", null).setPositiveButton("Hapus") { _, _ ->
                viewLifecycleOwner.lifecycleScope.launch { dao.delete(note) }
            }.show()
    }
}
