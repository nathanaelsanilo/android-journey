package com.example.kotlinbasics

import java.util.Date

fun main2() {
    val constantNumber = 3.14 // constant value use val (immutable)
    var mutableString = "aaa" // mutable variable
    val age: Byte = 29
    println(constantNumber)
    println(mutableString)

    // float and double
    val pi = 3.14 // infer as double
    val floatNumber = 3.14f // infer as float or
    val floatNumber2: Float = 3.144f
    // float use precision
    val cash = 5.4839849239490f // value is 5.483985 (round up)
    println(cash)
    // to avoid that, use double (default)
    val saving = 5.4839849239490
    println(saving)

    // unsigned integer
    // start from 0 (always positive number)
    val positiveInt = 34u
    val positiveByte: UByte = 29u // give error -29u

    // boolean
    val isTrue = true
    val isFalse = false
    println(isTrue || isFalse)
    println(isTrue && isFalse)
    print(!isFalse)

    // character
    val a = 'a'
    val enter = '\n'
    val unicode = '\u00a9'
    print(enter)
    println(unicode)

    // read input
    println("Type here...")
    val input = readln()
    val year = input.toInt()
    if (year > 2024) {
        println("greater than 2024")
    } else if (year < 2024) {
        println("less than 2024")
    } else {
        println("equal to 2024")
    }

    // while statement
    var counter = 0
    while (counter < 3) {
        println("counter: $counter")
        counter += 1
    }
}

// looks like interface
data class Coffee(val sugar : Int, val name: String)

fun main() {
    println("Input Customer")
    val customer = readln()
    println("Input sugar")
    val sugar = readln().toInt()

    val coffee = Coffee(sugar, customer)
    makeCoffee(coffee)
}

fun main3() {
    val dog = Dog("properties", "parameter")
    println("dog properties: ${dog.properties}")
    println("dog defaultValue: ${dog.defaultValue}")
    println("=======================")
    println()

    val book = Book()
    println("author: ${book.author}")
    println("title: ${book.title}")
    println("published year: ${book.yearPublished}")
    println("=======================")
    println()

    val book2 = Book("kotlin for dummy", "Maxwell", Date(2024, 0, 1))
    println("author: ${book2.author}")
    println("title: ${book2.title}")
    println("published year: ${book2.yearPublished}")
}

fun makeCoffee(coffee: Coffee) {
    println("Customer: ${coffee.name}")

    if (coffee.sugar == 0) {
        println("Sugar: No sugar")
    } else if (coffee.sugar == 1) {
        println("Sugar: ${coffee.sugar} spoon")
    } else {
        println("Sugar: ${coffee.sugar} spoons")
    }

}