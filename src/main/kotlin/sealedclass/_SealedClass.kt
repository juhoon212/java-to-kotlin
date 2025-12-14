package com.example.sealedclass

/*abstract class Developer {
    abstract var name: String
    abstract fun code(language: String)
}*/

sealed class Developer { // sealed class는 컴파일 시점에 하위 클래스가 모두 결정되어야 한다.
    abstract var name: String
    abstract fun code(language: String)
}

data class FrontendDeveloper(override var name: String) : Developer() {
    override fun code(language: String) {
        println("I'm $language frontend developer. My name is $name")
    }
}

data class BackendDeveloper(override var name: String): Developer() {
    override fun code(language: String) {
        println("I'm $language frontend developer. My name is $name")
    }
}

data class AndroidDeveloper(override var name: String): Developer() {
    override fun code(language: String) {
        println("I'm $language android developer. My name is $name")
    }
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun get(name: String): Developer {
        return pool[name] ?: throw IllegalArgumentException("No developer with name $name")
    }

    fun add(developer: Developer) = when(developer) { // 하위 타입을 정의하지 않으면 compile error 발생
        is FrontendDeveloper -> pool[developer.name] = developer
        is BackendDeveloper -> pool[developer.name] = developer
        is AndroidDeveloper -> pool[developer.name] = developer
        //else -> {} // 추상 클래스는 when 절에서 else 분기 필요
    }
}

fun main() {
    val frontendDeveloper = FrontendDeveloper(name="Alice")
    val backendDeveloper = BackendDeveloper(name="Bob")
    val androidDeveloper = AndroidDeveloper(name = "Chris")

    DeveloperPool.add(frontendDeveloper)
    DeveloperPool.add(backendDeveloper)
    DeveloperPool.add(androidDeveloper)

    val dev1 = DeveloperPool.get("Alice")
    dev1.code("Kotlin")

    val dev2 = DeveloperPool.get("Bob")
    dev2.code("Java")

    val dev3 = DeveloperPool.get("Chris")
    dev3.code("Swift")
}