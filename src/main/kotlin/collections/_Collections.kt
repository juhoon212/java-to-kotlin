package com.example.collections

fun main() {
    // immutable list
    val currencyList = listOf("USD", "EUR", "JPY", "GBP", "AUD")

    // mutable list
    val mutableCurrencyList = mutableListOf("USD", "EUR", "JPY").apply {
        add("GBP")
        add("AUD")
    }
    println(mutableCurrencyList)

    // immutable set
    val numberSet = setOf(1, 2, 3, 4)

    // mutable set
    val mutableNumberSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }
    println(mutableNumberSet)

    // immutable map
    val numberMap = mapOf("one" to 1, "two" to 2, "three" to 3) // "to" 키워드로 쌍 생성

    // mutable map
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1 // kotlin 스타일
    mutableNumberMap.put("two", 2) // java 스타일

    println(mutableNumberMap)
}