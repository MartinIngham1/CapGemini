package checkoutSystem

sealed class Item(val cost: BigDecimal)
object Apple extends Item(0.60)
object Orange extends Item(0.25)