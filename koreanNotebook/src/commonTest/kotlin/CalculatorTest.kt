package org.koreanNotebook

import kotlin.test.Test
import kotlin.test.assertEquals

open class CalculatorTest {

    @Test
    fun testSum() {
        assertEquals(3, 1+2)
    }

    @Test
    fun testFactory() {
        val product = Factory.create(mapOf("user" to "jetbrains"))
        assertEquals(product.user, "jetbrains")
    }
}

