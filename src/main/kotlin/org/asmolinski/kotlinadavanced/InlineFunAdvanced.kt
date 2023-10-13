package org.asmolinski.kotlinadavanced

inline fun executeCrossinlineLambda(crossinline lambda: () -> Unit) {
    println("Odpalamy lambde crossinline")
    lambda()
    executeLambda { lambda() }
}

inline fun executeNonlineLambda(noinline lambda: () -> Unit, otherLambda: () -> Unit) {
    println("Przekazujemy lambde wprost do funkcji nie inline")
    executeLambda(lambda)
    println("druga lambda się zinlinuje")
    otherLambda()
}

fun nonLocalReturn(): Int {
    inlineLambda {
        return 1
    }
    return 0
    // does not compile
//    executeLambda {
//        return 2
//    }
//    // does not compile
//    executeCrossinlineLambda {
//        return 3
//    }
}

fun main() {
    println("non local return " + nonLocalReturn())
    executeCrossinlineLambda { println("bonżur") }
    executeNonlineLambda(
        { println("nie zinlinuję się :(") },
        { println("a ja się zinlinuję :)") })
}

// CHEAT SHEET - FUNCTION PARAMETERS IN INLINE FUNS
// inline (no modifier) = returns in lambdas allowed, no function object is created, cannot be invoked in lambda, cannot be passed to non-inline fun as parameter
// crossinline = returns in lambdas not allowed, no function object is created, can be invoked in lambda, cannot be passed to non-inline fun as parameter
// noinline = returns in lambdas not allowed, function object is created, can be invoked in lambda, can be passed to non-inline fun as parameter
