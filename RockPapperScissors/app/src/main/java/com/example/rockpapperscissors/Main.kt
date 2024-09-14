package com.example.rockpapperscissors

fun main() {
    var computerChoice = ""
    var userChoice = ""

    println("rock paper scissor!")
    userChoice = readln().lowercase()

    while (userChoice != "paper" && userChoice != "rock" && userChoice != "scissor") {
        println("invalid input!")
        userChoice = readln()
    }

    val randomNumber = (1..3).random()

    if (randomNumber == 1) {
        computerChoice = "rock"
    } else if (randomNumber == 2) {
        computerChoice = "paper"
    } else if (randomNumber === 3) {
        computerChoice = "scissor"
    }
    println("computer choice: $computerChoice")
    println("player choice: $userChoice")

    val winner = when {
        userChoice == computerChoice -> "tie"
        userChoice == "rock" && computerChoice == "scissor" -> "player"
        userChoice == "paper" && computerChoice == "rock" -> "player"
        userChoice == "scissor" && computerChoice == "paper" -> "player"
        else -> "computer"
    }

    when (winner) {
        "player" -> println("Player won!")
        "computer" -> println("Computer won!")
        else -> println("tie")
    }

}