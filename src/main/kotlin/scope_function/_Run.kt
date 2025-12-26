package com.example.scope_function

class DataBaseClient {
    var user: String?= null
    var password: String?= null
    var url: String?= null

    fun connect(): Boolean {
        println("DB 연결 중...")
        Thread.sleep(2000)
        println("DB 연결 성공!")
        return true
    }
}

fun main() {
    // run: block 내부에서 this 로 객체 참조, 마지막 식이 반환값
    val result = DataBaseClient().run {
        user = "admin"
        password = "dnflskfk"
        url = "localhost:3306"
        connect()
    }

    println("DB 연결 결과: $result")
}