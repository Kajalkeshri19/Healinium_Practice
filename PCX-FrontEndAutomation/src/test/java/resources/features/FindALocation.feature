Feature: Find A Location

@FindALocation
 Scenario: Look up location
  Given I am on the Find a Location page
  And I want to look up a store location
  When I enter an address in the address search bar
  Then I will be shown the nearest store locations to that address
  And I will be able to select a location
  And I will be able to view location details
  And I will be able to see the locations on the Map

@FindALocation
 Scenario: View Mini Cart
  Given I am on a banner website for online grocery
  When I click the cart logo in the header
  Then I will be shown a mini cart with a breakdown of items and subtotal
  And be able to increase the quantity of items
  And be able to remove items
  And be able to go to cart page by clicking view cart
  And go to checkout page by clicking Checkout
  And be able to see the subtotal