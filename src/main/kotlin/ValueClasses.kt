import java.math.BigDecimal

@JvmInline
value class SellerId(val raw: String)

@JvmInline
value class FulfilmentProductId(val raw: String)

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

fun main() {
    println(
        ProductItem(
            SellerId("ANDRZEJ-SELLER"),
            FulfilmentProductId("ANDRZEJ-PRODUCT"),
            AverageDailyStock.of("12.34")
        )
    )

    println("sellerId ${SellerId("ANDRZEJ")}")
}