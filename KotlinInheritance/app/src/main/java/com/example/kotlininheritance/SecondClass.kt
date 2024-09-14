package com.example.kotlininheritance

class SecondClass : BaseClass(), Kingdom {

    override fun attack() {
        println("second class attack()")
    }

    override fun declare() {
        println("second class declare()")
    }
}