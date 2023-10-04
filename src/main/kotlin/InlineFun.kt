fun regularSum(a: Int, b: Int) = a + b

inline fun inlineSum(a: Int, b: Int) = a + b

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
}