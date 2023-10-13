package org.asmolinski.kotlinadavanced

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import kotlin.reflect.KClass
import java.math.BigDecimal

fun <T : Number> javaStyleParse(string: String, targetType: KClass<T>): T {
    return when (targetType) {
        BigDecimal::class -> BigDecimal(string) as T
        Double::class -> string.toDouble() as T
        else -> throw IllegalArgumentException()
    }
}

inline fun <reified T : Number> parse(string: String): T {
    return when(T::class) {
        BigDecimal::class -> BigDecimal(string) as T
        Double::class -> string.toDouble() as T
        else -> throw IllegalArgumentException()
    }
}

private fun numberParseExample() {
    val doubleNoReified: Double = javaStyleParse("1.23", Double::class)
    val decimalNoReified: BigDecimal = javaStyleParse("1.23", BigDecimal::class)
    println("Parsed double no reified: $doubleNoReified")
    println("Parsed decimal no reified: $decimalNoReified")


    val double: Double = parse("1.23")
    val decimal: BigDecimal = parse("1.23")
    println("Parsed double: $double")
    println("Parsed decimal: $decimal")
}

inline fun <reified E : Enum<E>> String.asEnum(): E {
    println("Converting $this to ${E::class.simpleName}")
    return java.lang.Enum.valueOf(E::class.java, this)
}

enum class Enum1 { ON_OFFER, ON_ORDER }

enum class Enum2 { GOOD, BAD, UGLY }

private fun enumParseExample() {
    val enum1: Enum1 = "ON_OFFER".asEnum()
    val enum2: Enum2 = "BAD".asEnum()
}

data class MyDto(val decimal: BigDecimal, val double: Double, val enum1: Enum1, val enum2: Enum2)

inline fun <reified T> parseJson(json: String): T {
    val objectMapper = ObjectMapper().registerModule(KotlinModule())
    return objectMapper.readValue(json, T::class.java)
}

private fun dtoParseExample() {
    var myDto = MyDto(
        parse("21.37"),
        parse("12.34"),
        "ON_ORDER".asEnum(),
        "GOOD".asEnum()
    )
    println(myDto)

    myDto = parseJson(
        """
        {
           "decimal": "1.23",
           "double": 1.23,
           "enum1": "ON_OFFER",
           "enum2": "BAD"
        }
    """.trimIndent()
    )
    println(myDto)
}

fun main() {
    numberParseExample()
    enumParseExample()
    dtoParseExample()
}







