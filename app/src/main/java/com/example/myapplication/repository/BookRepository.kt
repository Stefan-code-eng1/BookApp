package com.example.myapplication.repository

import android.util.Log
import com.example.myapplication.data.Book

class BookRepository {
    private val books = mutableListOf<Book>()

    init {
        books.add(Book("1", "Example Book1", "Author1", "Genre1", 4.5))
        books.add(Book("2", "Example Book2", "Author2", "Genre2", 3.5))
    }

    fun addBook(book: Book) {
        books.add(book)
        Log.d("BookRepository", "Book added: $book")
    }

    fun updateBook(updatedBook: Book) {
        val index = books.indexOfFirst { it.id == updatedBook.id }
        if (index != -1) {
            books[index] = updatedBook
        }
    }

    fun removeBook(bookId: String) {
        books.removeAll { it.id == bookId }
    }

    fun getBooks(): List<Book> {
        return books.toList()
    }

}

