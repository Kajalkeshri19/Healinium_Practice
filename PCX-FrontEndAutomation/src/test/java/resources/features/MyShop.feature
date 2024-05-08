Feature: My Shop

  @MyShop @Wholesale
  Scenario: Sign In
    Given I am a guest user
    When I click on the My Shop links
    Then I should be prompted to sign
    And when I click on the sign CTA I should be able to enter my PCid
    And I should be able to create an Account
    And  I should be able to see the right validation on the PCid sign in,sign up page

  @MyShop
  Scenario: Most Purchased
    Given I am a logged in customer
    When I click on Most Purchased link from the Most Shop Nav
    Then I should be able to see the most purchased products on the Most Purchase page
    And see the merch carousels on the page

  @MyShop
  Scenario: Past Orders
    Given I am a logged in customer
    When I click on Post Order link from the Most Shop Nav
    Then I should be able to see all past orders with the banner

  @MyShop
  Scenario: Aisles
    Given I am a logged in customer
    When I click on Aisles link from the Most Shop Nav
    Then I should be able to see all most purchased products sorted by aisles

  @MyShop
  Scenario: Shopping Lists
    Given I am a customer who has favourite products on the mobile app
    When When I click on the Web shopping lists
    Then I should be able to see the save items
    And add the items to cart
