package org.asmolinski.kotlinadavanced

fun regularSum(a: Int, b: Int) = a + b

inline fun inlineSum(a: Int, b: Int) = a + b

// inlining this is a tradeoff
fun przyklad1() {
    println("test")
    println("test")
    println("test")
    println("test")
    println("test")
    println("test")
    println("test")
    println("test")
}

fun przyklad2() {
    // this is equivalent to just println("test") !
    run { run { run { run { println("test") } } } }
}

fun executeLambda(lambda: () -> Unit) {
    println("Odpalamy lambde")
    lambda()
}

inline fun inlineLambda(lambda: () -> Unit) {
    println("Odpalamy lambde inline")
    lambda()
}

fun main() {
    println(regularSum(2, 3))
    println(inlineSum(2, 3))

    executeLambda { println("test1") }
    inlineLambda { println("test2") }

    // inlining in Kotlin stdlib
    "hello world".let { inlineLambda { println(it) } }
    listOf(1, 2, 3).map { it + 1 }
    przyklad2()
}