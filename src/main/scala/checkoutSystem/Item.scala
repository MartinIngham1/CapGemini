package checkoutSystem

sealed class Item(val cost: BigDecimal)
class Apple extends Item(0.60)
class Orange extends Item(0.25)