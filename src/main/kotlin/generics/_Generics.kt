package com.example.generics

class Bag<T> {
    fun saveAll(to: MutableList<in T>, from: Collection<out T>) {
        to.addAll(from)
    }
}

fun main() {
    val bag = Bag<String>()

    // in 은 java에서의 ? super T 와 동일
    // out 은 java에서의 ? extends T 와 동일
    bag.saveAll(to = mutableListOf<CharSequence>("1", "2"), from = mutableListOf("3", "4"))

    val list1: MutableList<String> = mutableListOf<String>("A", "B")

    // star projection in kotlin
    // Java 의 <?> 와 동일
    val list2: MutableList<*> = mutableListOf<Int>(1, 2, 3)
    val list3: MutableList<*> = mutableListOf("1", "2", "3") // 생략가능

    //val result = addNumber(mutableListOf("1")) // 버그를 일으킬 수 있음 파라미터타입이 in Number 여서 String 도 들어감
    val result = addNumber(mutableListOf(1, 2, 3))
    println(result)
}
// PECS 원칙 in effective java producer extends consumer super
// producer extends - 값을 꺼내서 연산에 적용
// example
fun sumNumber(numbers: List<out Number>) {
    numbers.sumOf { number -> number.toInt() }
}

// consumer super - 값을 추가만 하는 용도
// example
fun addNumber(numbers: MutableList<in Number>): MutableList<in Number> {
    numbers.add(1)
    numbers.add(2)
    return numbers
}


