package org.koreanNotebook

import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped

actual class Platform actual constructor() {
    actual val platform: String = "iOS"
}

actual class Product(actual val user: String) {
    val model: String = "lalala"

    fun iosSpecificOperation() {
        println("I am $model")
    }

    override fun toString() = "iOS product of $user for $model"
}

actual object Factory {
    actual fun create(config: Map<String, String>) =
        Product(config["user"]!!)

    actual val platform: String = "ios"
}
