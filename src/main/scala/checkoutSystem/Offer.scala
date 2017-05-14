package checkoutSystem

class Offer(val item: Item, buyQuantity: Int, offerQuantity: Int) {
  def itemCount(items: Seq[Item]) : Int = items.count {
    case `item` => true
    case _ => false
  }
  def totalCost(itemCount: Int): BigDecimal = {
    val offerCount = itemCount / offerQuantity
    val remainderCount = itemCount % offerQuantity
    (offerCount * buyQuantity + remainderCount) * item.cost
  }
}

class Offers(offers: Seq[Offer]) {
  def contains(item: Item): Boolean = {
    offers.exists(x => x.item == item)
  }
  def offerCost(items: Seq[Item]): BigDecimal = offers.map(o => o totalCost o.itemCount(items)).sum
}