package com.example.kotlinbasics

// class can accept paramaters
// using val properties : String this will serve as properties of this class
// using only parameter : String this will serve as class parameter
class Dog(val properties : String, parameter : String, var defaultValue : Int = 0) {

    init {
        // initializer
        // in kotlin, class have initializer and constructor
        bark(parameter)
    }

    fun bark(parameter: String) {
        println("paramater: $parameter")
        println("properties: $properties")
        println("default value: $defaultValue")
    }
}