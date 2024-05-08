Feature: Product Tile

  @ProductTile @Wholesale
  Scenario: Product Tile - Bulk item
    Given I am viewing product tile for a bulk item (i.e. produce)
    When the tile of the item is loaded
    Then The page will display the tile with a product image
    And the approximate product price
    And the product title
    And the product weight
    And the cost per 100g
    And an add to cart button

  @ProductTile @Wholesale
  Scenario: Item discount
    Given I am on any page that display product tiles
    And there is a sale on an item
    When the tile of the item is loaded
    Then The price of the item will have crossed out and the discounted price will be displayed in red

  @ProductTile @Wholesale
  Scenario: Low stock
    Given I am on any page that displays a product tiles
    And an item is low in stock
    When the tile of the item is loaded
    Then The product tile will display
    And a low stock inventory badge will display on top of the product image

  @ProductTile @Wholesale
  Scenario: Packaged Item
    Given I am viewing product tile for a packaged item
    When the tile of the item is loaded
    Then The page will display the tile with a product image
    And the brand title
    And the product title
    And the product weight
    And the product price
    And the cost per 100g
    And an add to cart button

  @ProductTile @Wholesale
  Scenario: Out of Stock
    Given I am on any page that displays a product tiles
    And an item is out of stock
    When the tile of the item is loaded
    Then The product tile will display
    And a out of stock inventory badge will display on top of product image

  @ProductTile @Wholesale
  Scenario:  Add to cart
    Given I am viewing a product tile
    When I click on the + button for that item
    Then The item will be added to my cart
    And the tile will display the quantity I have added
    And I will be able to add or remove the quantity of the item in my cart

  @ProductTile @Wholesale
  Scenario: Change quantity
    Given I am viewing a product tile
    And I have added an item to cart
    When I click the + or - buttons next to the item amount
    Then The quantity of the item in my cart will update
    And the new quantity of the item will display in the tile

  @ProductTile @Wholesale
  Scenario: Remove Item
    Given I am viewing a product tile
    And I have added an item to cart
    And the quantity is one
    When I click the - button for that item the item will be removed from my cart
    And the amount section will disappear
    And the add to cart button will re-appear

  @ProductTile @Wholesale
  Scenario: Link to PDP
    Given I am viewing a product tile
    When I click anywhere on the tile other than the + button
    Then I will be taken to the PDP of that item

  @ProductTile @Wholesale
  Scenario: Deal/Sale
    Given I am viewing a product tile
    And there is a Sale on the item
    When the tile of the item is loaded
    Then tile will display all details covered in bulk item
    And will display deal information at bottom of tile

  @ProductTile @Wholesale
  Scenario: Multibuy
    Given I am viewing the product tile
    And there is a Multi-buy Promo on the item
    When the tile of the item is loaded
    Then The tile will display all details covered in Bulk item,Packaged item test cases
    And will display Multi-Buy information at the bottom of the tile

  Scenario: PC Optimum Offer (not OT1)
    Given I am viewing product tile
    And there is a PCO Optimum offer on the item
    When the tile of the item is loaded
    Then The tile will display all details covered in Bulk item,Packaged item test cases
    And will display PC Optimum offer at the bottom of the tile

# Sponsored items are not found on page.
#  @ProductTile @Wholesale
#  Scenario: Sponsored item
#    Given I am viewing the Sponsored product tile
#    And the item is sponsored
#    When the tile of the item is loaded
#    Then The tile will display all details covered in Bulk item,Packaged item test cases
#    And will display sponsored on the tile
