package org.asmolinski.kotlinadavanced

import java.math.BigDecimal

@JvmInline
value class SellerId(val raw: String)

@JvmInline
value class FulfilmentProductId(val raw: String)

@JvmInline
value class Weight(val grams: Int)

@JvmInline
value class Volume(val cubicCm: Int)

data class WeightDTO(val grams: Int)

data class VolumeDTO(val cubicCm: Int)

@JvmInline
value class AverageDailyStock(val raw: BigDecimal) {
    companion object {
        fun of(raw: String) = AverageDailyStock(BigDecimal(raw))
    }
}

data class ProductItem(
    val sellerId: SellerId,
    val fulfilmentProductId: FulfilmentProductId,
    val avgStock: AverageDailyStock
)

data class ProductPackaging(
    val weight: Weight,
    val volume: Volume
)

data class ProductPackagingRawTypes(
    val weightGrams: Int,
    val volumeCubicCm: Int
)

data class ProductPackagingDTO(
    val weight: WeightDTO,
    val volume: VolumeDTO
)

fun main() {
    println(
        ProductItem(
            SellerId("ANDRZEJ-SELLER"),
            FulfilmentProductId("ANDRZEJ-PRODUCT"),
            AverageDailyStock.of("12.34")
        )
    )

    println("sellerId ${SellerId("ANDRZEJ")}")

    val productPackagingRawTypes = ProductPackagingRawTypes(weightGrams = 10, volumeCubicCm = 1000)
    val productPackagingDTO = ProductPackagingDTO(WeightDTO(grams = 10), VolumeDTO(cubicCm = 1000))
    val productPackagingValueClass = ProductPackaging(Weight(grams = 10), Volume(cubicCm = 1000))
    println("Packaging with primitive types $productPackagingRawTypes")
    println("Packaging with data class types $productPackagingDTO")
    println("Packaging with value types $productPackagingValueClass")
}