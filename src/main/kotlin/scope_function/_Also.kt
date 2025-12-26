package com.example.scope_function

class User(var name: String, var age: Int) {
    fun validate(): Boolean {
        return name.length > 5
    }

    override fun toString(): String {
        return "User(name='$name', age=$age)"
    }
}
fun main() {
    val validatedUser = User(name = "Jonathan", age = 30).also {
        it.validate()
    }
    println(validatedUser)
}