package com.example.scope_function

class Car {
    var name: String?= null
    var price: Int?= null
    var madeBy: String?= null

    fun validate() {
        println("Validating car information...")
        madeBy?.run {
            if (length < 2) throw IllegalArgumentException("Manufacturer name is too short")
        }
        Thread.sleep(1000)
        println("Car information is valid!")
    }

    override fun toString(): String {
        return "Car(name=$name, price=$price, madeBy=$madeBy)"
    }
}

fun main() {
    // apply: block 내부에서 this 로 객체 참조, 객체 자신이 반환값
    val car: Car = Car().apply {
        name = "Model S"
        price = 79999
        madeBy = "TSLA"
        validate()
    }

    println("My car is $car")
}