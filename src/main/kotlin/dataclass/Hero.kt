package com.example.dataclass

import dataclass.Person

data class Hero(
    val name: String,
    val age: Int,
    val address: String
)

fun main() {
    val hero = Hero(name="Tony", age=45, address="Seoul")
    println(hero)

    val person = Person()
    person.name
}