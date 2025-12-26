package com.example.scope_function

fun main() {
    val str: String?= "Hello, Kotlin!"

    val result = str.let {
        it?.uppercase()
    }
    println(result)

    val result2 = str.let {
        val def: String?= " [Default Value]"
        it + def
    }
    println(result2)

    if (str.isNullOrEmpty() || result2.isEmpty()) {
        println("str or result2 is null or empty")
    } else {
        println("str and result2 are not null or empty")
    }
}