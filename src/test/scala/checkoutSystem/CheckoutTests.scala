package checkoutSystem

import org.scalatest.FlatSpec

class CheckoutTests extends FlatSpec {
  "Checkout takes a list of items scanned at the till" should "output the total cost" in {
    val scannedItems = Seq(new Apple, new Apple, new Orange, new Apple)
    val expected = 2.05
    val result = new Checkout().totalCost(scannedItems)
    assert(result == expected)
  }
}
