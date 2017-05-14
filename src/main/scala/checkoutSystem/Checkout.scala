package checkoutSystem

class Checkout(offers: Offers) {
  def totalCost(scannedItems: Seq[Item]): BigDecimal = {
    val offerCost = offers.offerCost(scannedItems)
    val standardCost = scannedItems.filter(item => !offers.contains(item)).map(_.cost).sum
    offerCost + standardCost
  }
}