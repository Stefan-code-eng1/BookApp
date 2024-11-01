package com.example.myapplication

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.example.myapplication.repository.BookRepository
import com.example.myapplication.viewmodel.BookViewModel
import com.example.myapplication.viewmodel.BookViewModelFactory

class BookApp : Application() {

    private val repository by lazy { BookRepository() }


    val bookViewModel: BookViewModel by lazy {
        ViewModelProvider(
            ViewModelStore(),
            BookViewModelFactory(repository)
        )[BookViewModel::class.java]
    }

}
