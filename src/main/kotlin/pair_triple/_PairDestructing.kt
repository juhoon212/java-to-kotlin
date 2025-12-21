package com.example.pair_triple

fun plusNumber(pair: Pair<Int, Int>): Int {
    val sum: Int = pair.first + pair.second
    return sum
}

fun plusTripleNumber(triple: Triple<Int, Int, Int>): Int {
    val sum: Int = triple.first + triple.second + triple.third
    return sum
}

fun main() {
    val sum = plusNumber(Pair(20, 30))
    println(sum)

    val sum2 = plusTripleNumber(Triple(10, 20, 30))
    println(sum2)

    val pair = Pair(10,20)
    //pair.first = 20 // val 이기 때문에 변경 불가능
    // -> 이럴때 copy 를 사용
    val newPair = pair.copy(first = 10)
    println(newPair)

    println(pair == newPair) // true pair는 data class 이기 때문에 equals() 가 재정의 되어 있다.

    val tuple = Triple(10, 20, 30)

    // 구조분해 할당
    val (a, b, c) = tuple
    println("a = $a b = $b c = $c")

    val tupleList = tuple.toList() // immutable list 로 변환
    println(tupleList.component1())
    println(tupleList.component2())
    println(tupleList.component3())
    //println(tupleList.component4()) // 없는 값이라 error 발생

    val map = mutableMapOf<String, String>("윤주훈" to "백엔드 개발자")

    for ((name, developerName) in map) {
        println("${name} 은 ${developerName} 입니다.")
    }

}