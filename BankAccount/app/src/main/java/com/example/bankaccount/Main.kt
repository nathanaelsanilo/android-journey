package com.example.bankaccount

fun main() {
    val account = BankAccount("Nathan")

    account.deposit(5000.0)
    account.withdraw(250.0)
    account.withdraw(9000.0)
    account.getHistories()

    println("====================================")

    val sarahAccount = BankAccount("Sarah")
    println("Sarah account balance: ${sarahAccount.acctBalance()}")
    sarahAccount.deposit(100.0)
    sarahAccount.withdraw(10.0)
    sarahAccount.deposit(300.0)
    sarahAccount.getHistories()
}