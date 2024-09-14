package com.example.kotlinbasics

fun main() {
    // loop
    val queue = listOf<String>("budi", "heru", "yono")
    for (person in queue) {
        println("Person: $person")
    }
    println("===================")
    for (index in 0 until  queue.size) {
        println("Person: ${queue[index]}")
    }
}

fun list() {
    // immutable list cannot add or remove element
    val queue = listOf<String>("budi", "heru", "yono")

    // mutable list allow to add or remove element
    val shoppingCarts = mutableListOf<String>("pants", "hats", "t-shirt")
    shoppingCarts.add("shoes")
    shoppingCarts.remove("hats")
    shoppingCarts[0] = "jeans"

    // list.contains
    println("buy t-shirt? ${shoppingCarts.contains("t-shirt")}")

    println("queue: $queue")
    println("shoppping carts: $shoppingCarts")
}

fun exercise() {
    val fruitsList = mutableListOf<String>("apple", "pineapple", "watermelon", "banana", "peach")
    fruitsList.add("tomato")
    fruitsList.remove("peach")
    println("is contains peach? ${fruitsList.contains("peach")}")
}