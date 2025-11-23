package com.example

import JavaThrow
import java.io.IOException
import kotlin.jvm.Throws

class KotlinThrow {

    //@Throws(IOException::class) // 이 어노테이션은 Java에서 호출할 때 checked exception 처리를 위해 필요함
    fun throwIoException() {
        throw IOException("Checked Exception in Kotlin")
    }

    fun main() {
        val javaThrow = JavaThrow()
        javaThrow.throwIoException() // Java의 checked exception을 강제로 throw 하거나 try-catch 해야하지 않음

        val kotlinThrow = KotlinThrow()
        kotlinThrow.throwIoException() // 위와 동일하게 처리하지 않아도 됨.
    }
}