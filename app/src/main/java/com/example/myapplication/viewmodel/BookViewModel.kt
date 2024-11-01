package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Book
import com.example.myapplication.repository.BookRepository

class BookViewModel : ViewModel() {
    private val repository = BookRepository()
    private val _books = MutableLiveData(repository.getBooks())

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

    fun getBooks(): MutableLiveData<List<Book>> {
        return _books
    }
}
