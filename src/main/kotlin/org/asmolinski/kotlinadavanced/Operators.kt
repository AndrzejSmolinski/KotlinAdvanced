package org.asmolinski.kotlinadavanced

import kotlin.IllegalArgumentException
import java.math.BigDecimal

/**
 * WARNING - THERE WILL BE A LOT OF THINGS THAT ARE BAD
 * PLEASE DO NOT DO THIS IN YOUR PROJECTS
 * ESPECIALLY IF THIS IS ALSO MY PROJECT
 * */

data class Item(
    val productId: String,
    val quantity: Int
)

operator fun Item.plus(other: Item): Item {
    if (this.productId != other.productId) {
        throw IllegalArgumentException("cannot sum items with different product ids!")
    }
    return Item(this.productId, this.quantity + other.quantity)
}

fun plusExample() {
    val item1 = Item("item-1", 1)
    val item2 = Item("item-1", 2)
    println(item1.plus(item2))
    println(item1 + item2)
}


infix fun Item.dodać(other: Item): Item {
    return this + other
}

infix fun Item.`💩`(other: Item) {
    println("💩💩💩")
}

fun infixExample() {
    val item1 = Item("item-1", 1)
    val item2 = Item("item-1", 2)
    println(item1 dodać item2)
    item1 `💩` item2
}

// question to audience - where does it actually make sense?

operator fun String.invoke(): BigDecimal {
    return BigDecimal("12.34")
}

operator fun String.invoke(liczba: Int): String {
    return "$this-$liczba"
}

operator fun Int.invoke(liczba: Int): Int {
    return this + liczba
}

fun invokeWeirdExamples() {
    println("WTF"())
    println("test"(123))
    println((1)(2)(3)(4))
}

data class MyInt(val raw: Int) {
    constructor(str: String) : this(str.toInt())
}

data class MyOtherInt(val raw: Int) {
    companion object {
        operator fun invoke(str: String) {
            MyOtherInt(str.toInt())
        }

        operator fun invoke(double: Double): Double {
            return double
        }
    }
}

fun invokeInCompanion() {
    val myInt = MyInt("123")
    val myOtherInt = MyOtherInt("123")
    val notAnInt = MyOtherInt(1.23)
}

// will not work, because member wins with extension
operator fun Int.plus(liczba: Int): Int {
    return this * liczba
}

fun main() {
    plusExample()
    infixExample()
    invokeWeirdExamples()
    invokeInCompanion()
    println(3 + 3)
}