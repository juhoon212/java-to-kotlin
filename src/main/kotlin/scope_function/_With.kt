package com.example.scope_function

class Person {
    var name: String?= null
    var age: Int?= null
}
fun main() {
    val result = with(Person()) {
        name = "Alice"
        age = 25
    }

    println(result)
}