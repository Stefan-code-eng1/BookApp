package com.example.myapplication.data

import android.os.Parcelable

data class Book(
    val id: String,
    val title: String,
    val author: String,
    val genre: String,
    val reviews: Double
)


