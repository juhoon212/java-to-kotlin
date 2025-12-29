package com.example.advanced_exception

fun getStr(): Nothing = throw IllegalArgumentException("예외 발생!")

fun main() {
    val result = runCatching { getStr() }.getOrDefault("기본값") // getOrDefault: 예외 발생 시 기본값 반환
    println(result)

    val result2 = runCatching { getStr() }
        .getOrNull() // getOrNull: 예외 발생 시 null 반환
    println(result2)

    val result3 = runCatching { getStr() }.getOrElse { "else" } // getOrElse: 예외 발생 시 람다식 결과 반환
    println(result3)

    val result4 = runCatching { println("안녕") } // getOrThrow: 예외 발생 시 예외를 다시 던짐
    //val result5 = runCatching { getStr() }.getOrThrow() // 예외 발생

    val result6 = runCatching { println("hi") }.exceptionOrNull() // exceptionOrNull: 예외가 발생하지 않으면 null 반환
    println(result6)

}