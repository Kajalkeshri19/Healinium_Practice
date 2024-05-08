Feature: Cart

  #not applicable to wsc as there is no pcx pass subscription feature in wsc
  @Row52 @M2Purchase @Cart @ProfileInCart
  Scenario: PCX pass-View relevant fees
    Given I'm a logged in user with a PCX pass subscription
    When I navigate to cart page
    Then I should see relevant fees(specific for PCX pass customers) displayed on order summary component for cart and checkout pages

  #not applicable to wsc as there is no pcx pass subscription feature in wsc
  @Row53 @M2Purchase @Cart @ProfileInCart
  Scenario: Cancelled PCX pass-View relevant fees
    Given I'm a logged in user who has cancelled the PCX Pass subscriptions
    When I navigate to cart page
    And I dont have any outstanding benefits left
    Then I should see relevant fees (non Pass Fees) displayed on order summary component for cart and checkout pages

  @Row54 @M2Purchase @Cart @AddToCart @UAT
  Scenario: Create New Cart - With selected fulfillment
    Given I don't have any items in my cart
    When I add my first item to the cart
    Then I can access my cart and view that item

  @Row54 @M2Purchase @Cart @AddToCart @WholesaleCart
  Scenario: Create New Cart - With selected fulfillment
    Given I don't have any items in my cart
    When I add my first item to the wholesale-cart
    Then I can access my cart and view that item

  @Row57 @M2Purchase @Cart @AddToCart @UAT
  Scenario: Cart management & modifications / Change Quantity
    Given I am viewing a product or my cart
    When I add x more of that product to my cart
    Then my cart should immediately update with that product and show the correct quantity

  @Row57 @M2Purchase @Cart @AddToCart @WholesaleCart
  Scenario: Cart management & modifications / Change Quantity
    Given I am viewing a product or my wholesale-cart
    When I add x more of that product to my cart
    Then my cart should immediately update with that product and show the correct quantity

  @Row60 @M2Purchase @Cart @AddToCart @UAT
  Scenario: Cart management & modifications / Change weight
    Given I am viewing sliced ham
    When I add x grams of sliced ham
    Then my cart should show x grams of sliced ham

  @Row60 @M2Purchase @Cart @AddToCart @WholesaleCart
  Scenario: Cart management & modifications / Change weight
    Given I am viewing wholesale-sliced ham
    When I add x grams of sliced ham
    Then my cart should show x grams of sliced ham

  #not applicable to wsc : able to add more than 25 units of the product
  @Row61 @M2Purchase @Cart @AddToCart @UAT
  Scenario: Cart management & modifications / Max Item Quantity
    Given I am adding a product to my cart
    When I add more than the max quantity of 25 units of the product
    Then I should not be able to add more

  @Row64 @M2Purchase @Cart @RemoveFromCart @UAT
  Scenario: Cart management & modifications / Chanage Quantity
    Given I am viewing a product or my cart
    When I remove a quantity of x of a product from my cart
    Then my cart should immediately update with the correct quantity for that product and show the correct pricing

  @Row64 @M2Purchase @Cart @RemoveFromCart @WholesaleCart
  Scenario: Cart management & modifications / Chanage Quantity
    Given I am viewing a product or my wholesale-cart
    When I remove a quantity of x of a product from my cart
    Then my cart should immediately update with the correct quantity for that product and show the correct pricing

  @Row65 @M2Purchase @Cart @RemoveFromCart @UAT
  Scenario: Cart management & modifications / Chanage Quantity
    Given I have x quantity of a product in my cart
    When I change that quantity from x to 0
    Then that product should be removed from the cart

  @Row65 @M2Purchase @Cart @RemoveFromCart @WholesaleCart
  Scenario: Cart management & modifications / Chanage Quantity
    Given I have x quantity of a product in my wholesale-cart
    When I change that quantity from x to 0
    Then that product should be removed from the cart

  @Row66 @M2Purchase @Cart @RemoveFromCart @UAT
  Scenario: Cart management & modifications / Remove last item
    Given I have 1 product in my cart
    When I remove that product
    Then my cart should be empty
    And I should see the "Your Cart is empty!" page when I go to my cart

  @Row66 @M2Purchase @Cart @RemoveFromCart @WholesaleCart
  Scenario: Cart management & modifications / Remove last item
    Given I have 1 product in my wholesale-cart
    When I remove that product
    Then my cart should be empty
    And I should see the "Your Cart is empty!" page when I go to my cart

  #not automated in wsc because of CLP issue : select fresh fruits is failing
  @Row69 @M2Purchase @Cart @PLP/CLPForCart @UAT
  Scenario: Cart quantities on browse pages-LDP-28351
    Given I have item A in my cart with quantity two
    When I see the same item while browsing
    Then I should see the quantity as two

  #not automated in wsc because of CLP issue : select fresh fruits is failing
  @Row70 @M2Purchase @Cart @PLP/CLPForCart @UAT
  Scenario: Cart quantity on browse pages-LDP-28351
    Given I have item A in my cart with quantity two
    When I see the same item while browsing
    Then I should see the quantity as two and be able to increase or decrease the quantity

  @Row71 @M2Purchase @Cart @OrderSummary @UAT
  Scenario: Cart Order Summary-LDP-27137
    Given I am Logged in
    And I am on business site and I have products in my cart
    When I go to cart page
    Then I see that the order summary includes:
    And number of items
    And subtotal
    And service fee or delivery,pick up as -
    And est. taxes as zero
    And driver tip of five (if fulfillment is delivery)
    And est. total

  #modified then statement for wholesale-cart feature
  @Row71 @M2Purchase @Cart @OrderSummary @WholesaleCart
  Scenario: Cart Order Summary-LDP-27137
    Given I am Logged in
    And I am on business site and I have products in my wholesale-cart
    When I go to cart page
    Then I see that the order summary includes:
    And number of items
    And subtotal
    And delivery or pick up fee has a select button
    And est. taxes as zero
    And driver tip of five (if fulfillment is delivery)
    And est. total

  @Row72 @M2Purchase @Cart @OrderSummary @Outofscope
  Scenario: Cart Order Summary-LDP-27137
    Given I am a guest user
    And I am on business site and I have products in my cart
    When I go to cart page
    Then I see that the order summary includes:
    And number of items
    And subtotal
    And service fee or delivery,pick up as -
    And est. taxes as zero
    And driver tip of five (if fulfillment is delivery)
    And est. total

  #modified then statement for wholesale-cart feature
  @Row72 @M2Purchase @Cart @OrderSummary @Outofscope @WholesaleCart
  Scenario: Cart Order Summary-LDP-27137
    Given I am a guest user
    And I am on business site and I have products in my wholesale-cart
    When I go to cart page
    Then I see that the order summary includes:
    And number of items
    And subtotal
    And delivery or pick up fee has a select button
    And est. taxes as zero
    And driver tip of five (if fulfillment is delivery)
    And est. total

  #not applicable to loblaw
  @Row73 @M2Purchase @Cart @MinimumSpend(WSC,NoFrills,PCXPass) @WholesaleCart
  Scenario: Min spend on WSC Pickup
    Given I am on WSC banner and I have added less than $75 worth of items to my cart for Pickup
    When I go to the wholesale-cart page
    Then I will see a minimum cart value message and will not be able to move to Checkout

  #not applicable to wsc as there is no pcx pass subscription feature in wsc
  @Row75 @M2Purchase @Cart @MinimumSpend(WSC,NoFrills,PCXPass)
  Scenario: Min spend for PCX Pass subscribers on Pickup
    Given I have PCX Pass and added less than $35 worth of items to my cart for Pickup
    When I go to the cart page
    Then I will see a minimum cart value message and will not be able to move to Checkout

    #Need to correct the Then statement as we cannot modify the items at checkout page, we can modify the items only at the cart page.
#  @Row76 @M2Purchase @Cart @MinimumSpend(WSC,NoFrills,PCXPass)
#  Scenario: Min spend for PCX Pass subscribers on Pickup
#    Given I have PCX Pass and I have added >$35 worth of items to my cart for Pickup
#    When I go to the checkout page and try to reduce the cart value below the minimum
#    Then I will get an error message and will not be able to remove items that reduce the value of my cart below the minimum

  #Need to correct the Then statement as we cannot modify the items at checkout page, we can modify the items only at the cart page.
#  @Row77 @M2Purchase @Cart @MinimumSpend(WSC,NoFrills,PCXPass)
#  Scenario: Min spend on WSC Pickup
#    Given I am on WSC banner and I have added less than $75 worth of items to my cart for Pickup
#    When I go to the checkout page and try to reduce the cart value below the minimum
#    Then I will get an error message and will not be able to remove items that reduce the value of my cart below the minimum

  @Row81 @M2Purchase @Cart @AddOrderDetailsInstructions @UAT
  Scenario: Instructions
    Given I have an item in my cart
    When I go to cart page
    Then I can add a special instruction to that item

  @Row81 @M2Purchase @Cart @AddOrderDetailsInstructions @WholesaleCart
  Scenario: Instructions
    Given I have an item in my wholesale-cart
    When I go to cart page
    Then I can add a special instruction to that item

  @Row82 @M2Purchase @Cart @AddOrderDetailsInstructions @UAT
  Scenario: Remembering the instructions for the item-LDP-28358
    Given I wrote an instructions for an item in my cart
    When  I remove the item from my cart and readd
    Then I should still see the same instructions I wrote

  @Row82 @M2Purchase @Cart @AddOrderDetailsInstructions @WholesaleCart
  Scenario: Remembering the instructions for the item-LDP-28358
    Given I wrote an instructions for an item in my wholesale-cart
    When  I remove the item from my cart and readd
    Then I should still see the same instructions I wrote

  #not applicable to wsc as we can not change the fulfillment method from cart or checkout page
  # fulfillment method can only be changed from the header
  @Row85 @M2Purchase @Cart @ChangePickup/Delivery @UAT
  Scenario: Changing fulfilment method
    Given I have a cart full of items with the fulfillment method pick up
    When  I go to checkout page and change the fulfilment method to delivery
    Then I should be notified of the changes in my cart if I proceed and be able to make decisions to proceed or go back

  @Row90 @M2Purchase @Cart @SubstituteAProductInCart @UAT
  Scenario: Substitutions Checkbox
    Given  I have items in my cart
    When I go to cart page
    Then I can choose to opt-in or opt out for subs for each item in my cart

  @Row90 @M2Purchase @Cart @SubstituteAProductInCart @WholesaleCart
  Scenario: Substitutions Checkbox
    Given  I have items in my wholsale-cart
    When I go to cart page
    Then I can choose to opt-in or opt out for subs for each item in my cart

  @Row91 @M2Purchase @Cart @SubstituteAProductInCart @UAT
  Scenario: Substitutions Checkbox-LDP-28358
    Given I have item A in my cart and I selected to opt-out of the substitution checkbox
    When I remove the item entirely from my cart and re-add
    Then I can see that the sub checkbox for the item is opted-out

  @Row91 @M2Purchase @Cart @SubstituteAProductInCart @WholesaleCart
  Scenario: Substitutions Checkbox-LDP-28358
    Given I have item A in my wholesale-cart and I selected to opt-out of the substitution checkbox
    When I remove the item entirely from my cart and re-add
    Then I can see that the sub checkbox for the item is opted-out

  @Row98 @M2Purchase @Cart @ViewCart @UAT
  Scenario: Cart management & modifications / Shopping across devices & user states
    Given I'm an anonymous user and I have added product A to my cart from tab A and I am on tab B on the same site and I have added product B to my cart from tab B sheetname and rownumber
    When when I go back to tab A
    Then my cart should show products A and B

  @Row98 @M2Purchase @Cart @ViewCart @WholesaleCart
  Scenario: Cart management & modifications / Shopping across devices & user states
    Given I'm an anonymous user and I have added product A to my wholsale-cart from tab A and I am on tab B on the same site and I have added product B to my wholsale-cart from tab B sheetname and rownumber
    When when I go back to tab A
    Then my cart should show products A and B

  #not automated in wsc because of CLP issue : select fresh fruits is failing
  @Row105 @M2Purchase @Cart @ViewCart @UAT
  Scenario: Low stock item in cart
    Given I am on a business site
    And I have an item in my cart that has low stock
    When I go to cart page
    Then I should see a Low stock warning next to the item as well as a warning banner on the page
    And the low stock product should have a low stock callout and a link to select a substitute

#  Duplicate of TC-57, TC-59 for live cart, not automated
#  @Row__ @M2Purchase @Cart @AddToCart
#  Scenario: Cart management & modifications / Chanage Quantity
#    Given I am viewing a product or my cart
#    When I add x more of that product to my cart
#    Then my cart should immediately update with that product and show the correct quantity

  @Row106 @M2Purchase @Cart @ViewCart @UAT
  Scenario: Total numbers of items in Cart
    Given I have one apple, two breads and three butters in my cart
    When I view my cart
    Then I should see a total item count of Six

  @Row106 @M2Purchase @Cart @ViewCart @WholesaleCart
  Scenario: Total numbers of items in Cart
    Given I have one apple, two breads and three butters in my cart
    When I view my cart
    Then I should see a total item count of Six

  @Row157 @M2Purchase @Cart @ViewMiniCart @UAT
  Scenario: Mini Cart View
    Given I am browsing and shopping through the business page
    When I scroll over the cart icon on the navigation top right
    Then I should see the the contents of my cart including item names, quantities, and cart total.
    And I should be able to click the delete icon to remove the product form cart
    And I should be able to click on the View Cart and checkout CTA to navigate to the appropriate page
    And I should be able to change the quantity of the articles in the cart
    And any changes to my cart should reflect the appropriate change on the price of the Subtotal
    And I should be able to scroll to view the products in the mini cart view

  @Row157 @M2Purchase @Cart @ViewMiniCart @WholesaleCart
  Scenario: Mini Cart View
    Given I am browsing and shopping through the wholsale-business page
    When I scroll over the cart icon on the navigation top right
    Then I should see the the contents of my cart including item names, quantities, and cart total.
    And I should be able to click the delete icon to remove the product form cart
    And I should be able to click on the View wholsale-Cart and checkout CTA to navigate to the appropriate page
    And I should be able to change the quantity of the articles in the cart
    And any changes to my cart should reflect the appropriate change on the price of the Subtotal
    And I should be able to scroll to view the products in the mini wholesale-cart view

  @Row158 @M2Purchase @Cart @ViewMiniCart @UAT
  Scenario: Mini Cart View
    Given I am browsing and shopping through the business page
    When I scroll over the cart icon on the navigation top right
    Then I should see the the contents of my cart including item names, quantities, and cart total.

  @Row158 @M2Purchase @Cart @ViewMiniCart @WholesaleCart
  Scenario: Mini Cart View
    Given I am browsing and shopping through the wholsale-business page
    When I scroll over the cart icon on the navigation top right
    Then I should see the the contents of my cart including item names, quantities, and cart total.

  #not applicable to wsc as there is no Ada Chatbot feature in wsc
  @Row280 @M2Purchase @Cart @PCOptimumAccount
  Scenario: Ensure Ada Chatbot launches
    Given I am on any grocery banner and I click "menu" on web
    When I click the chat icon in bottom right
    Then The Adachatbot should open

  @Row291 @M2Purchase @Cart @ViewCart @UAT
  Scenario: Alcohol in Cart
    Given I have added NO alcohol products to my cart
    When I click proceed to cart
    Then I should NOT see this messaging at cart: Beer and wine: Prices shown at checkout will be itemized separately to show you the product price before applicable taxes and bottle deposit fees are added. You must be of legal drinking age to purchase alcohol products.

  @Row291 @M2Purchase @Cart @ViewCart @WholesaleCart
  Scenario: Alcohol in Cart
    Given I have added NO alcohol products to my wholesale-cart
    When I click proceed to cart
    Then I should NOT see this messaging at cart: Beer and wine: Prices shown at checkout will be itemized separately to show you the product price before applicable taxes and bottle deposit fees are added. You must be of legal drinking age to purchase alcohol products.


