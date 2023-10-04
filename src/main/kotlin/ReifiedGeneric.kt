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

inline fun <reified E : Enum<E>> String.asEnum(): E {
    println("Converting $this to ${E::class.simpleName}")
    return E::class.java.enumConstants.find { it.name == this } as E
}

enum class Enum1 { ON_OFFER, ON_ORDER }

enum class Enum2 { GOOD, BAD, UGLY }

data class MyDto(val decimal: BigDecimal, val double: Double, val enum1: Enum1, val enum2: Enum2)

fun main() {
    val double: Double = parse("1.23")
    val decimal: BigDecimal = parse("1.23")
    println("Parsed double: $double")
    println("Parsed decimal: $decimal")

    val enum1: Enum1 = "ON_OFFER".asEnum()
    val enum2: Enum2 = "BAD".asEnum()

    println(
        MyDto(
            parse("21.37"),
            parse("12.34"),
            "ON_ORDER".asEnum(),
            "GOOD".asEnum()
        )
    )
}



