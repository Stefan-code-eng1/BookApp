package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.viewmodel.BookViewModel


class MainActivity : ComponentActivity() {

    private lateinit var bookViewModel: BookViewModel
    private lateinit var bookAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.setTheme(R.style.Theme_MyApplication)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookAdapter = BookAdapter(
            onItemClick = { book ->
                // Navigate to update activity
                val intent = Intent(this, UpdateBookActivity::class.java)
                intent.putExtra("BOOK_ID", book.id)
                startActivity(intent)
            },
            onDeleteClick = { book ->
                // Remove the book from the ViewModel and notify the adapter
                bookViewModel.removeBook(book.id)  // Use the ID to remove the book
            }
        )

        val recyclerView: RecyclerView = findViewById(R.id.bookRecyclerView)
        recyclerView.adapter = bookAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        bookViewModel = (application as BookApp).bookViewModel

        bookViewModel.books.observe(this) { books ->
            bookAdapter.submitList(books)
        }

        findViewById<Button>(R.id.addBookButton).setOnClickListener {
            startActivity(Intent(this, CreateBookActivity::class.java))
        }
    }

}
