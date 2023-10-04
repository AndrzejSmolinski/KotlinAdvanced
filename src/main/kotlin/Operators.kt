import java.lang.IllegalArgumentException
import java.math.BigDecimal

/**
 * WARNING - THERE WILL BE A LOT OF THINGS THAT ARE BAD
 * PLEASE DO NOT DO THIS IN YOUR PROJECTS
 * ESPECIALLY IF THIS IS ALSO MY PROJECT
 * */

data class Item(
    val itemId: String,
    val quantity: Int
)

operator fun Item.plus(other: Item): Item  {
    if (this.itemId != other.itemId) {
        throw IllegalArgumentException("cannot sum items with different ids!")
    }
    return Item(this.itemId, this.quantity + other.quantity)
}

infix fun Item.dodać(other: Item): Item {
    return this + other
}

infix fun Item.`💩`(other: Item): Item {
    println("\uD83D\uDCA9\uD83D\uDCA9\uD83D\uDCA9\uD83D\uDCA9\uD83D\uDCA9")
    return this
}

operator fun String.invoke(): BigDecimal {
    return BigDecimal("12.34")
}

operator fun String.invoke(liczba: Int): String {
    return "$this-$liczba"
}

operator fun Int.invoke(liczba: Int): Int {
    return this + liczba
}

fun main() {
    val item1 = Item("item-1", 1)
    val item2 = Item("item-1", 2)
    println(item1.plus(item2))
    println(item1 + item2)
    println(item1 dodać item2)
    println(item1 `💩` item2)
    println("WTF"())
    println("test"(123))
    println((1)(2)(3)(4))
}