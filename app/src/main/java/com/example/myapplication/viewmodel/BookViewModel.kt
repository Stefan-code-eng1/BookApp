package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Book
import com.example.myapplication.repository.BookRepository

class BookViewModel(private val repository: BookRepository) : ViewModel() {
    private val _books = MutableLiveData(repository.getBooks())
    val books: LiveData<List<Book>> = _books

    fun addBook(book: Book) {
        repository.addBook(book)
        _books.value = repository.getBooks()
    }

    fun updateBook(updatedBook: Book) {
        repository.updateBook(updatedBook)
        _books.value = repository.getBooks()
    }

    fun removeBook(bookId: String) {
        repository.removeBook(bookId)
        _books.value = repository.getBooks()
    }
}
