package checkoutSystem

class Checkout {
  def totalCost(scannedItems: Seq[Item]): BigDecimal = scannedItems.map(_.cost).sum
}