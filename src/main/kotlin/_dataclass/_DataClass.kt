package com.example._dataclass

class Person(var name: String, val age: Int)
data class PersonDataClass(var name: String, val age: Int)

fun main() {
    val person1 = Person("Alice", 23)
    val person2 = Person("Alice", 23)

    val hashSet1: HashSet<Person> = HashSet()
    hashSet1.add(person1)

    println(hashSet1.contains(person2)) // equals() 와 hashCode() 가 재정의 되어 있지 않기 때문에 false

    val person3 = PersonDataClass("Bob", 30)
    val person4 = PersonDataClass("Bob", 30)

    val hashset2 = hashSetOf(person3)

    println(hashset2.contains(person4)) // data class 는 equals() 와 hashCode() 가 재정의 되어 있기 때문에 true

    val person5 = PersonDataClass("Chris", 28)
    val person6 = person5.copy() // shallow copy
    println(person5 == person6) // copy() 로 복사한 객체는 shallow copy 이기 때문에 true

    println("=============================")

    println(person5 === person6)
    val person7 = person5.copy(name="David") // name 만 변경한 복사본 생성
    println(person6 == person7) // name 이 다르기 때문에 false
}