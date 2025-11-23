package com.example

class ClassProperty {
}

// kotlin constructor
class Coffee(var name: String, var price: Int, ) {
    val brand: String
        // get() = "Starbucks" // custom getter
        get() {
            return "Starbucks"
        }
    var quantity: Int = 0
        set(value) {
            field = if (value > 0) value else 0 // backing field, 직접 할당시에는 무한재귀에 빠짐
        }
}

class Coffee2(val name: String = "Americano", val price: Int = 0) {}

class EmptyClass // 이런 빈 클래스도 생성 가능

fun main() {
    val coffee = Coffee("Latte", 5000)
    coffee.name = "아이스 아메리카노"
    coffee.price = 2000

    coffee.quantity = 4
    println("${coffee.brand}: ${coffee.name} 가격은 ${coffee.price} ${coffee.quantity}")
}