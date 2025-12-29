package com.example.advanced_exception

import java.io.FileWriter

fun main() {

    // use는 내부에서 Closable 객체를 자동으로 close 해줌
    FileWriter("output.txt")
        .use { writer -> writer.write("abcdefg") }
}