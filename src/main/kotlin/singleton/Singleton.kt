package com.example.singleton

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// 싱글톤 객체 보통 유틸리티 클래스를 만들 때 사용
object DateTimeUtil {
    const val DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"

    fun getCurrentDateTime(): String {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
    }
}

// class 기반 싱글톤
class MySingleton private constructor() {
    companion object {
        private var instance: MySingleton? = null

        fun getInstance(): MySingleton {
            if (instance == null) {
                instance = MySingleton()
            }
            return instance!!
        }
    }
}

fun main() {
    val now: String = DateTimeUtil.getCurrentDateTime()
    println("Current DateTime is : $now")

    val instance1 = MySingleton.getInstance()
    val instance2 = MySingleton.getInstance()

    println(instance1 === instance2) // 싱글톤이기 때문에 true
}

