package org.asmolinski.kotlinadavanced

data class ProductPackagingRawTypes(
    val weightGrams: Int,
    val volumeCubicCm: Int
)

data class WeightDTO(val grams: Int)

data class VolumeDTO(val cubicCm: Int)

data class ProductPackagingDTO(
    val weight: WeightDTO,
    val volume: VolumeDTO
)

// CHEAT SHEET
// empty object size: 16 bytes (!)
// int size 4 bytes
// ref size 4 bytes

@JvmInline
value class Weight(val grams: Int) {

    val kilograms: Double get() = grams.toDouble() / 1000

    fun greet() = println("hello")

    companion object {
        fun ofKilograms(kilograms: Double) = Weight((kilograms * 1000).toInt())
    }
}

@JvmInline
value class Volume(val cubicCm: Int)

data class ProductPackaging(
    val weight: Weight,
    val volume: Volume
)

typealias Grams = Int
typealias CubicCm = Int

data class ProductPackagingTypealias(
    val weight: Grams,
    val volume: CubicCm
)

fun main() {
    val productPackagingRawTypes = ProductPackagingRawTypes(weightGrams = 10, volumeCubicCm = 1000)
    val productPackagingDTO = ProductPackagingDTO(WeightDTO(grams = 10), VolumeDTO(cubicCm = 1000))
    val productPackagingValueClass = ProductPackaging(Weight(grams = 10), Volume(cubicCm = 1000))
    val productPackagingTypealias = ProductPackagingTypealias(weight = 10, volume = 1000)
    println("Packaging with primitive types $productPackagingRawTypes")
    println("Packaging with data class types $productPackagingDTO")
    println("Packaging with value types $productPackagingValueClass")
    println("Packaging with type aliases $productPackagingTypealias")

    val weight = Weight.ofKilograms(2.234)
    println("${weight.kilograms}kg is ${weight.grams}g")
}