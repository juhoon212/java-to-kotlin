package com.example

open class Dog {
    open var age: Int = 0

    open fun bark() {
        println("멍멍")
    }
}

open class Bulldog(final override var age: Int = 0): Dog() { // final 키워드로 쓰는것들은 상속이 불가능하다.
    final override fun bark() {
        //println("컹컹")
        super.bark() // java 와 마찬가지로 부모의 메소드를 super 키워드를 통해서 호출할 수 있다.
    }
}

abstract class Developer {
    abstract var age: Int
    abstract fun code(language: String)
}

class BackendDeveloper(override var age: Int) : Developer() {
    override fun code(language: String) {
        println("I'm $language backend developer")
    }
}

fun main() {
    val dog = Bulldog(age=3)
    println(dog.age)
    dog.bark()

    val backendDeveloper = BackendDeveloper(age=30)
    backendDeveloper.code(language = "kotlin")
}

