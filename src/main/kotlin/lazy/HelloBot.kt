package com.example.lazy

import com.example.lazy.ReportType.*

class HelloBot {
    val greeting by lazy {
        println("initializing greeting...")
        getHello()
    }
    fun sayHello() = println(greeting)
}

fun getHello(): String {
    return "Hello, Kotlin!"
}

enum class ReportType {
    PDF, EXCEL, HTML
}

fun main() {
    val helloBot = HelloBot()
    helloBot.sayHello()
}

class PdfGenerator {
    fun generate() {}
}
class ExcelGenerator {
    fun generate() {}
}

class ReportService {
    /*val pdfGenerator = PdfGenerator() // 무거운 객체 생성(가정) -> 초기화를 해버림
    val excelGenerator = ExcelGenerator() // 무거운 객체 생성(가정) -> 초기화를 해버림*/

    // 위의 작업들은 너무 무거울 수 있음 -> lazy initialization 적용
    val pdfGenerator by lazy { PdfGenerator() }
    val excelGenerator by lazy { ExcelGenerator() } // lazy 사용 시 호출될때 초기화가 일어남

    fun generate(type: ReportType) {
        when (type) {
            PDF -> pdfGenerator.generate()
            EXCEL -> excelGenerator.generate()
            HTML -> println("Generating HTML report...")
        }
    }
}