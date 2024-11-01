package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.Book
import com.example.myapplication.viewmodel.BookViewModel

class UpdateBookActivity : AppCompatActivity() {

    private lateinit var bookViewModel: BookViewModel
    private lateinit var bookId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_book)

        bookViewModel = (application as BookApp).bookViewModel

        bookId = intent.getStringExtra("BOOK_ID") ?: return
        val book = bookViewModel.books.value?.find { it.id == bookId }

        book?.let {
            findViewById<EditText>(R.id.nameInput).setText(it.title)
            findViewById<EditText>(R.id.authorInput).setText(it.author)
            findViewById<EditText>(R.id.genreInput).setText(it.genre)
            findViewById<EditText>(R.id.reviewsInput).setText(String.format(it.reviews.toString()))
        }

        findViewById<Button>(R.id.updateButton).setOnClickListener {
            val name = findViewById<EditText>(R.id.nameInput).text.toString()
            val author = findViewById<EditText>(R.id.authorInput).text.toString()
            val genre = findViewById<EditText>(R.id.genreInput).text.toString()
            val reviews = findViewById<EditText>(R.id.reviewsInput).text.toString().toDoubleOrNull()

            if (name.isBlank() || author.isBlank() || genre.isBlank() || reviews == null || reviews !in 0.0..5.0) {
                Toast.makeText(this, "Please fill in all fields correctly", Toast.LENGTH_SHORT).show()
            } else {
                val updatedBook = Book(bookId, name, author, genre, reviews)
                bookViewModel.updateBook(updatedBook)
                finish()
            }
        }
    }
}
