package com.example.functional_programming

fun main() {

    // 함수는 데이터 구조이고 때문에 자료구조에 넣을 수 있다.
    val functionalList = mutableListOf(printHello)
    val result = functionalList[0]
    result()

    call(printHello) //

    val list = listOf("a", "b", "c")
    val printAction: (String) -> Unit = { println(it) }
    forEachStr(list, printAction)

    outerFunction() // 실행은 되지만 반환된 함수는 사용되지 않음
    val func = outerFunction()
    func()

    val func2 = outerFunctionLambda()
    func2()

    val func3 = outerFunctionLambda2()
    func3()

    // 함수중에 마지막에 람다식이 오면 소괄호 밖으로 뺄 수 있다.
    forEachStr(list) {
        println(it)
    }

    val callReference = ::printHello
    callReference()()

    val numberList = listOf("1", "2", "3")
    numberList.map { it.toInt() }.forEach { println(it) }

    // 참조로 표현
    numberList.map(String::toInt).forEach(::println)

    val argFunc = arg1 { println(it)}
    val arg2Func =  { a: String, b: String -> println(a + b) }

    val ex1 = arg2Func.let {
        it("a", "b")
        "123"
    }
    println(ex1)
}

fun arg1(block: (String) -> Unit) {}
fun arg2(block: (String, String) -> Unit) {}

// 람다 표현식 전체
val sum: (Int, Int) -> Int = { x:Int, y:Int -> x + y }

// 위 람다식을 최대로 줄인 형태
val sum2 = { x: Int, y:Int -> x + y }

val printHello: () -> Unit = { println("Hello") }

/**
 * 람다 표현식
 */
val printMessage: (String) -> Unit = { message: String -> println(message) }
val printMessage2: (String) -> Unit = { message -> println(message) }
val printMessage3: (String) -> Unit = { println(it) }

/**
 * 고차 함수: 함수를 매개변수로 받는 함수
 */
fun call(block: () -> Unit) {
    block()
}

fun outerFunction(): () -> Unit {
    return fun () {
        println("This is an outer function returning a function")
    }
}

fun outerFunctionLambda(): () -> Unit {
    return { println("This is an outer function lambda") }
}

fun outerFunctionLambda2() : () -> Unit = { println("This is an outer function lambda2") }

fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item)
    }
}