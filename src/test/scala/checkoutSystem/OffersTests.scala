package checkoutSystem

import org.scalatest.FlatSpec

class OffersTests extends FlatSpec {

  behavior of "Offer"

  it should "charge buy quantity at item cost" in {
    val scannedItems = Seq(Orange, Orange)
    val expected = Orange.cost * 2
    val offers = new Offers(Seq(new Offer(Orange, 2, 3)))
    val result = offers.offerCost(scannedItems)
    assert(result == expected)
  }

  it should "charge quantity above offer at item cost" in {
    val scannedItems = Seq(Orange, Orange, Orange, Orange)
    val expected = Orange.cost * 3
    val offers = new Offers(Seq(new Offer(Orange, 2, 3)))
    val result = offers.offerCost(scannedItems)
    assert(result == expected)
  }
}
