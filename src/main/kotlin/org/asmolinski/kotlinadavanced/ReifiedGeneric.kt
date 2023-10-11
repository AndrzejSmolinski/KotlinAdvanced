package org.asmolinski.kotlinadavanced

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.math.BigDecimal

inline fun <reified T : Number> parse(string: String): T {
    return if (T::class == BigDecimal::class) {
        BigDecimal(string) as T
    } else if (T::class == Double::class) {
        string.toDouble() as T
    } else {
        throw IllegalArgumentException()
    }
}

private fun numberParseExample() {
    val double: Double = parse("1.23")
    val decimal: BigDecimal = parse("1.23")
    println("Parsed double: $double")
    println("Parsed decimal: $decimal")
}

inline fun <reified E : Enum<E>> String.asEnum(): E {
    println("Converting $this to ${E::class.simpleName}")
    return E::class.java.enumConstants.find { it.name == this } as E
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







