Feature: Rapid feature

  @Rapid
  Scenario: Rapid Serviceability - Guest, Serviceable (TC-39)
    Given I come to as a first time user
    When I input a serviceable address and the store is open
    Then I should be able to click the Continue button and enter the homepage

  @RapidServiceable
  Scenario: Rapid Serviceability - Guest, non Serviceable (TC-40)
    Given I come to as a first time user
    When I input a non serviceable address and stores are open
    Then I should be shown a message that either informs me I am not serviceable

# There is no such alert for closed store and no click okay option.
  @Rapid
  Scenario: Rapid Serviceability - store closed (TC-41)
    Given I come to as a first time user
    When I input a serviceable address and the store is closed
    Then I should be shown a message that the store is closed, and be able to click Okay

  @Rapid
  Scenario: Rapid Serviceability - return user (TC-42)
    Given I come to as a return user
    Then I should not see the serviceability modal appear (address should be stored)
#
  @Rapid
  Scenario: Rapid Serviceability - Switching Address (TC-43)
    Given I am a return user and I want to change my address on Rapid
    When I click the address listed in the top right
    Then I should see a serviceability modal open, with ability to adjust my address (inputting address should then follow same flows identified above)

  @Rapid
  Scenario: Rapid - CLP Homepage (TC-47)
     Given I am on the homepage
     When I click Shop All under any of the product carousels
     Then I should be taken to the Category Listing Page for that section
#
  @Rapid
  Scenario: Rapid - CLP Nav (TC-48)
    Given I am anywhere on the website
    When I click a category in the navigation
    Then I should able to the Category Listing Page for that section
#
  @Rapid
  Scenario: Rapid - PDP (TC-49)
    Given I am on the homepage
    When I click a category in the navigation
    When I click a product tile
    Then I should be taken to the PDP for that product

  @Rapid
  Scenario: Rapid - PDP (TC-50)
    Given I am on a Rapid PDP
    Then I should see product name, weight, price, image, and product description
#
  @Rapid
  Scenario: Rapid - PDP (TC-51)
    Given I am on a Rapid PDP
    When I click Add
    Then Product should be added to my cart, shown by a green checkmark on product image, appearance of floating checkout, addition of item to cart icon in nav, and ability to adjust quantity on page

   @Rapid
   Scenario: Rapid - Product Tile - In Stock (TC-52)
    Given I am on a product tile page
    When The product has ample stock
    Then I should not see any badging on product tile or PDP
#
  @Rapid
  Scenario: Rapid - Product Tile - Low Stock (TC-53)
    Given I am on a product tile page
    When The product has low stock
    Then I should see a Low Stock badge on product tile and PDP

  @Rapid
  Scenario: Rapid - Search (TC-55)
    Given I am on the homepage
    When I click into the search bar and enter a keyword
    Then I should see suggested results underneath the search bar

  @Rapid
  Scenario: Rapid - Search (TC-56)
    Given I am on the homepage
    When I click into the search bar, type a product name and press enter
    Then if there are results, I should see the SRP with related results. note SRP will load results user is required to click load more, to load more if available
#
  @Rapid
  Scenario: Rapid - Search (TC-57)
    Given I am on the homepage
    When I click into the search bar, enter a keyword and press enter
    Then if there are no results: I should see the message We were unable to find results for keyword Try checking your spelling or searching something less specific with the ability to try search again, in page.















