package com.example.myapplication.repository

import com.example.myapplication.data.Book

class BookRepository {
    private val books = mutableListOf<Book>()

    init {
        books.add(Book("1", "Example Book", "Author", "Genre", 4.5))
        books.add(Book("1", "Example Book", "Author", "Genre", 4.5))
    }

    fun addBook(book: Book) {
        books.add(book)
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
        return books
    }

}

