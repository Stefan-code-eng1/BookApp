package com.example.myapplication

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.Book

class BookAdapter(
    private val onItemClick: (Book) -> Unit,
    private val onDeleteClick: (Book) -> Unit
) : ListAdapter<Book, BookAdapter.BookViewHolder>(BookDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view, onItemClick, onDeleteClick)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BookViewHolder(
        itemView: View,
        private val onItemClick: (Book) -> Unit,
        private val onDeleteClick: (Book) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView: TextView = itemView.findViewById(R.id.bookName)
        private val authorTextView: TextView = itemView.findViewById(R.id.bookAuthor)
        private val genreTextView: TextView = itemView.findViewById(R.id.bookGenre)
        private val reviewsTextView: TextView = itemView.findViewById(R.id.bookReviews)
        private val updateButton: Button = itemView.findViewById(R.id.updateButton)

        fun bind(book: Book) {
            nameTextView.text = book.title
            authorTextView.text = book.author
            genreTextView.text = book.genre
            reviewsTextView.text = String.format(book.reviews.toString())

            updateButton.setOnClickListener {
                onItemClick(book)
            }

            itemView.setOnLongClickListener {
                showDeleteConfirmation(book)
                true
            }
        }

        private fun showDeleteConfirmation(book: Book) {
            AlertDialog.Builder(itemView.context)
                .setTitle("Delete Book")
                .setMessage("Are you sure you want to delete ${book.title}?")
                .setPositiveButton("Yes") { _, _ ->
                    onDeleteClick(book)
                }
                .setNegativeButton("No", null)
                .show()
        }
    }

    class BookDiffCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Book, newItem: Book) = oldItem == newItem
    }
}
