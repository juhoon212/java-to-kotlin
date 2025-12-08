package com.example.collections

import java.util.LinkedList

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

    // 컬렉션 빌더 - 내부에선 mutable 반환되는 것은 immutable
    val numberList: List<Int> = buildList { // mutable
        add(1)
        add(2)
        add(3)
    }

    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
    }

    val iterator = currencyList.iterator()

    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("=====================")

    for (currency in currencyList) {
        println(currency)
    }

    println("=====================")

    currencyList.forEach { println(it) }

    // for loop -> map
    val lowerList = listOf("a", "b", "c")
    val upperList = mutableListOf<String>()

    for (lowerCase in lowerList) {
        upperList.add(lowerCase.uppercase())
    }
    println("=====================")
    println(upperList)

    upperList.clear()
    val newUpperList = lowerList.map { it.uppercase() }
    println(newUpperList)

    println("=====================")

    val filteredList = mutableListOf<String>()
    for (upperCase in newUpperList) {
        if (upperCase == "A" || upperCase == "C") {
            filteredList.add(upperCase)
        }
    }
    println(filteredList)
    println(newUpperList.filter { it == "A" || it == "C" })
    println("=====================")

    val filteredList2 = newUpperList // sequence 사용 예시 + sequence API는 중간에 filter 등 여러번 호출해도 최종 연산 시점에 한꺼번에 처리되기 때문에 성능상 이점이 있음
        .asSequence()
        .filter { it == "A" || it == "C" }
        .toList()

    val filteredList3 = upperList // 불필요한 중간 리스트 생성 예시 - 매번 filter 호출 시마다 새로운 리스트가 생성됨
        .filter { it == "A" || it == "C" }
        .filter { it == "A" || it == "C" }
        .filter { it == "A" || it == "C" }
        .filter { it == "A" || it == "C" }
        .filter { it == "A" || it == "C" }

    println(filteredList2)
}