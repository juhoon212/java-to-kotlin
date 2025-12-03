package com.example.exception

fun main() {
    //Thread.sleep(1) // checked exception 처리 강제하지 않음.

    /*try {
        Thread.sleep(1)
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        println("Finally")
    }*/

    val a = try { // kotlin 에서는 try-catch 가 expression 임 (값을 반환함)
        "1234".toInt()
    } catch (e: Exception) {
        println("예외 발생!")
    }
    println(a)

    // throw Exception("예외 발생!")
    val b: String? = null
    val c: String = b ?: failFast("a is null")

    println(c.length)
}

fun failFast(message: String): Nothing { // Nothing은 모든 타입의 하위타입임
    throw IllegalArgumentException(message)
}

