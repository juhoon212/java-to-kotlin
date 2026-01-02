package com.example.functional_programming

fun main() {

    // 함수는 데이터 구조이고 때문에 자료구조에 넣을 수 있다.
    val functionalList = mutableListOf(printHello)
    val result = functionalList[0]
    result()

    call(printHello) //
}

val printHello: () -> Unit = { println("Hello") }

/**
 * 고차 함수: 함수를 매개변수로 받는 함수
 */
fun call(block: () -> Unit) {
    block()
}