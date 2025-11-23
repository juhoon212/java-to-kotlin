package com.example

fun failTest(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun main() {
    val a: String? = null
    val b = a ?: failTest("I'm not sure what to do")

    println(b.length)
}