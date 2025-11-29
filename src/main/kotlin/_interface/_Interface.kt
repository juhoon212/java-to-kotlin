package com.example._interface

class Product(val name: String, val price: Int)

interface Wheel { // Cart의 상위 인터페이스
    fun roll()
}

interface Cart: Wheel {
    var coin: Int // 인터페이스에서는 프로퍼티에 초기값을 줄 수 없음 하지만 변수 선언 가능
    val weight: String
        get() = "1kg" // 커스텀 게터는 가능
        /*get() {
            field
        }*/ // 인터페이스에서는 backing field 를 사용할 수 없음

    fun add(product: Product)
    fun rent() { // 몸통부가 있으면 interface 내부에서 구현하는 것이기 때문에 선택적 구현이 가능
        if (coin > 0) println("카트를 대여합니다.")
    }

    fun printId(id: String): Unit = println("Cart id = $id") // 동일한 함수를 정의하면 구현하는 곳에서 충돌이 발생함 따라서 super<Class>.add() 형태로 호출해야 함
}

interface Order {
    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다.")
    }

    fun printId(id: String): Unit = println("Order id = $id")
}

class MyCart(override var coin: Int): Cart, Order { // 복수개의 interface 구현 가능
    override fun add(product: Product) {
        if (coin <= 0) println("코인을 넣어주세요")
        else println("${product.name} (이)가 카트에 추가되었습니다.")

        // 주문하기
        super<Order>.add(product)
    }

    override fun printId(id: String) {
        super<Cart>.printId(id)
        super<Order>.printId(id)
    }

    override fun roll() {
        println("카트가 굴러갑니다")
    }
}

fun main() {
    val cart = MyCart(3)
    cart.rent()
    cart.add(Product(name = "빼뺴로", price = 3))
    cart.roll()
    cart.add(Product(name = "장난감", price = 3))
    cart.printId("1234")
}
