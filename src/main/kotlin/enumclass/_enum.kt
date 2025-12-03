package com.example.enumclass

enum class PaymentStatus(val label: String): Payable {
    UNPAID("미지급") {
        override fun isPayable(): Boolean = true
    },
    PAID("지급완료") {
        override fun isPayable(): Boolean = false
    },
    FAILED("지급실패") {
        override fun isPayable(): Boolean = false
    },
    REFUNDED("환불") {
        override fun isPayable(): Boolean = false
    };
}

interface Payable {
    fun isPayable(): Boolean
}

fun main() {
    print(PaymentStatus.UNPAID.label) // 상수의 property 접근
    if (PaymentStatus.UNPAID.isPayable()) println("결제 가능 상태")

    val paymentStatus = PaymentStatus.valueOf("PAID")
    println(paymentStatus.label)

    val result: Any = try {
        PaymentStatus.valueOf("wefewf")
    }catch (e: IllegalArgumentException) {
        println("존재하지 않는 PaymentStatus 입니다.")
    }
    println(result)

    for (status in PaymentStatus.entries) {
        println("$status : " + status.label)
    }
}