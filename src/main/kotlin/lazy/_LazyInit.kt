package com.example.lazy

/**
 * 주로 테스트 코드에서 사용되는 lateinit @Autowired 와 같은 의존성 주입에서 주로 사용
 */
class LazyInit {
    lateinit var text: String

    fun printText() {
        if (this::text.isInitialized) println("text has been initialized: $text")
        else println("text is not initialized yet.")
    }
}

fun main() {
    val lz = LazyInit()
    lz.text= "Hello, Kotlin!"

    println(lz.text)
    // lz.text.isInitialized -> class level 에서만 isInitialized 사용 가능
    lz.printText()
}