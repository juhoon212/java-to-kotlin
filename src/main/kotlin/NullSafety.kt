package com.example

fun getNullStr(str: String?): String? = null // 와 이게 가능하네

fun getLengthIfNotNull(str: String?): Int? = str?.length ?: 0 // 엘비스 연산자 null 이면 0 반환

fun main() {
    val result = getLengthIfNotNull(str = null)
    println(result)
}