package com.example.kotlininheritance

open class BaseClass {

    fun spawn() {
        println("baseClass.spawn()")
    }

    open fun attack() {
        println("baseClass.attack()")
    }
}