package com.example.bankaccount

class BankAccount(var accountName: String, var balance: Double = 0.0) {

    private val histories = mutableListOf<String>()

    fun deposit(amount: Double) {
        balance += amount
        histories.add("Deposit: $amount")
    }

    fun withdraw(amount: Double) {
        if (amount > balance) {
            println("You don't have enough funds!")
        } else {
            balance -= amount
            histories.add("Withdrew: $amount")
        }

    }

    fun getHistories() {
        for (history in histories) {
            println("Transaction $history")
        }
        println("$accountName Balance: ${balance}")
    }

    fun acctBalance(): Double {
        return balance
    }
}