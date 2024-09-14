package com.example.kotlininheritance

fun main() {
    val baseClass = BaseClass()
    baseClass.spawn();

    val secondClass = SecondClass()
    secondClass.declare()

    val tertiary = Tertiary()
    tertiary.attack()
}