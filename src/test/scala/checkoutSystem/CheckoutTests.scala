package checkoutSystem

import org.scalatest.FlatSpec

class CheckoutTests extends FlatSpec {

  behavior of "Checkout"

  it should "output the total cost" in {
    val scannedItems = Seq(Apple, Apple, Orange, Apple)
    val expected = Apple.cost * 3 + Orange.cost
    val offers = new Offers(Nil)
    val result = new Checkout(offers).totalCost(scannedItems)
    assert(result == expected)
  }

  it should "apply Apples offer of buy one, get one free on Apples" in {
    val scannedItems = Seq(Apple, Apple)
    val expected = Apple.cost
    val offers = new Offers(Seq(new Offer(Apple, 1, 2)))
    val result = new Checkout(offers).totalCost(scannedItems)
    assert(result == expected)
  }

  it should "not apply Oranges offer on Apples" in {
    val scannedItems = Seq(Apple, Apple)
    val expected = Apple.cost * 2
    val offers = new Offers(Seq(new Offer(Orange, 1, 2)))
    val result = new Checkout(offers).totalCost(scannedItems)
    assert(result == expected)
  }

  it should "apply offer of 3 for the price of 2 on Oranges" in {
    val scannedItems = Seq(Orange, Orange, Orange)
    val expected = Orange.cost * 2
    val offers = new Offers(Seq(new Offer(Orange, 2, 3)))
    val result = new Checkout(offers).totalCost(scannedItems)
    assert(result == expected)
  }
}