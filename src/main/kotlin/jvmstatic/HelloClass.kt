package com.example.jvmstatic

class HelloClass {

    companion object {
        @JvmStatic
        fun hello() = "hello!"
    }
}

object HiObject {
    @JvmStatic
    fun hi() = "hi!"
}

fun main() {
    val hello = HelloClass.hello() // companion object 의 메서드 호출
    val hi = HiObject.hi()
}