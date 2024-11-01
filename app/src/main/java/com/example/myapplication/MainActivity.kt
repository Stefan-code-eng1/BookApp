package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.repository.BookRepository
import com.example.myapplication.viewmodel.BookViewModel


class MainActivity : ComponentActivity() {

    private lateinit var bookViewModel: BookViewModel
    private lateinit var bookAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.setTheme(R.style.Theme_MyApplication)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookAdapter = BookAdapter { book ->
            val intent = Intent(this, UpdateBookActivity::class.java)
            intent.putExtra("BOOK_ID", book.id)
            startActivity(intent)
        }

        val recyclerView: RecyclerView = findViewById(R.id.bookRecyclerView)
        recyclerView.adapter = bookAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        bookViewModel = ViewModelProvider(this)[BookViewModel::class.java]
        bookViewModel.getBooks().observe(this) { books ->
            bookAdapter.submitList(books)
        }

        findViewById<Button>(R.id.addBookButton).setOnClickListener {
            startActivity(Intent(this, CreateBookActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        bookViewModel.getBooks().observe(this) { books ->
            bookAdapter.submitList(books)
        }
    }

}
