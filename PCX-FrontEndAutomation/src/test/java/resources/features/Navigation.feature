Feature: Navigation

  @Navigation
  Scenario: Persistent nav (unauthenticated)
    Given I am on any page of PCX
    And I am not logged in
    When The Page loads
    Then The nav will display at the top of the page
    And the store logo
    And the search bar
    And the selected store location
    And recommended pickup
    #And delivery times
    #And a tooltip for the fulfillment options
    And links for Grocery,Home,Beauty & Baby,Discover,My Shop,Flyers & Deals,Services,PC Express pass
    And a sign in button
    And a shopping cart with number of items and cart price
    #And a checkout button

  @Navigation
  Scenario: Persistent nav (authenticated)
    Given I am on any page of PCX
    #And I am logged in
    When The Page loads
    Then The nav will display at the top of the page
    And the store logo
    And the search bar
    And the selected store location
    And recommended pickup
    #And delivery times
    #And a tooltip for the fulfillment options
    And links for Grocery,Home,Beauty & Baby,Discover,My Shop,Flyers & Deals,Services,PC Express pass
    #And My Account
    And a shopping cart with number of items and cart price
    #And a checkout button

  @Navigation
  Scenario: Grocery
    Given I am on any page of PCX
    When I hover over Grocery in the Nav
    Then the list of categories in grocery will display
    And  the sub-categories for whatever category is selected
    #And  an ad unit relating to that category

  @Navigation
  Scenario: Home, Beauty & Baby
    Given I am on any page of PCX
    When I hover over Home,Beauty & Baby in the nav
    Then the list of categories in home, beauty & baby will display
    And sub-categories for whatever category is selected
    #And an ad unit relating to that category

  @Navigation
  Scenario: Discover / My Shop / Flyers & Deals / Services
    Given I am on any page of PCX
    When I hover over any of Discover, My Shop, Flyers & Deals, Services in the nav
    Then the list of categories in the selected menu will display

  @Navigation @Wholesale
  Scenario: Links
    Given I am on any page of PCX
    When I click on a link in the navigation
    Then I am directed the appropriate page as set up in contentful
    And  the link is not dead

  @Navigation @Wholesale
  Scenario: Sign in
    Given I am on any page of PCX
    When  I click on sign in in the navigation
    Then  I will be directed to sign PCID login page
    And   the button will change to My Account upon successful sign in

  @Navigation @Wholesale
  Scenario: Cart
    Given I am on any page of PCX
    When I click on my cart in the navigation
    Then My cart will expand
    And I will be able to see all the items in my cart
    And the subtotal of my cart
    And I will see a checkout button in the menu

  @Navigation @Wholesale
  Scenario: Checkout
    Given I am on any page of PCX
    When I click the checkout button in the cart menu or navigation
    Then I will be taken to the first step of checkout flow

  @Navigation @Wholesale
  Scenario: Breadcrumb - L0
    Given I am on L-zero of a CLP,PLP
    When I scroll to the top of page
    Then I will see L-zero page name at the top of the page

  @Navigation @Wholesale
  Scenario: Breadcrumb - L1
    Given I am on L-one of a CLP,PLP
    When  I scroll to the top of page
    Then  I will see L-zero page name at the top of the page
    And L-zero will be a clickable link back to L-zero
    And I see L-one in the breadcrumb at the top of the page

  @Navigation @Wholesale
  Scenario: Breadcrumb - L2
    Given I am on L-two of a CLP,PLP
    When I scroll to the top of page
    Then I will see L-zero page name at the top of the page
    And L-zero will be a clickable link back to L-zero
    And I see L-one in the breadcrumb at the top of the page
    And L-one will be a clickable link back to L-one
    And I see L-two in the breadcrumb at the top of the page

   @Wholesale
  Scenario: Breadcrumb - L3
    Given I am on L-three of a CLP,PLP
    When I scroll to the top of page
    Then I will see L-zero page name at the top of the page
    And L-zero will be a clickable link back to L-zero
    And I see L-one in the breadcrumb at the top of the page
    And L-one will be a clickable link back to L-one
    And I see L-two in the breadcrumb at the top of the page
    And L-two will be a clickable link back to L-two
    And I see L-three in the breadcrumb at the top of the page

  @Navigation @Wholesale
  Scenario: Breadcrumb - PDP
    Given I click on a product tile anywhere on PCX
    When I am taken to the PDP
    Then I will see L-zero page name at the top of the pdp
    And L-zero pdp will be a clickable link back to L-zero
    And I see L-one in the breadcrumb at the top of the pdp
    And L-one pdp will be a clickable link back to L-one
    And I see L-two in the breadcrumb at the top of the pdp
    And L-two pdp will be a clickable link back to L-two
    And I see L-three in the breadcrumb at the top of the pdp
    And L-three pdp will be a clickable link back to L-three
    And I see the product name in the breadcrumb at the top of the page




