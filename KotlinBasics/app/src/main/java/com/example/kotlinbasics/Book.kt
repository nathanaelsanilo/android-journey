package com.example.kotlinbasics

import java.util.Date

class Book(val title: String = "Unknown", val author: String = "Anonymous", val yearPublished: Date = Date()) {
    init {

    }
}