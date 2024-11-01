package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.data.Book
import com.example.myapplication.viewmodel.BookViewModel
import java.util.UUID

class CreateBookActivity : AppCompatActivity() {

    private lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)

        bookViewModel = (application as BookApp).bookViewModel

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            val name = findViewById<EditText>(R.id.nameInput).text.toString()
            val author = findViewById<EditText>(R.id.authorInput).text.toString()
            val genre = findViewById<EditText>(R.id.genreInput).text.toString()
            val reviews = findViewById<EditText>(R.id.reviewsInput).text.toString().toDoubleOrNull()

            if (name.isBlank() || author.isBlank() || genre.isBlank() || reviews == null || reviews !in 0.0..5.0) {
                Toast.makeText(this, "Please fill in all fields correctly", Toast.LENGTH_SHORT).show()
            } else {
                val newBook = Book(UUID.randomUUID().toString(), name, author, genre, reviews)
                bookViewModel.addBook(newBook)
                finish()
            }
        }
    }
}

