Feature: HomePage

  @HomePage @Wholesale
  Scenario: Home page layout - Guest RO-250
    Given I am on the home page of any banner
    And I am not logged in
    When I scroll down the page
    Then I will see the following components:
    And The navigation
    And a Headline banner
    And a PCX Pass registration banner
    And a Sign in information card
    And a Flyers and deals information card
    And a location details for the order information card
    And a two-up promo carousel
    And a menu tiles carousel to shop categories
    And a Start Shopping mini product tile carousel
    And any product tile carousels as configured by merch team
    And any promotional fifty-fifty wrappers as configured by merch team
    And Four-across promotional tiles as configured by merch team
    And any brand spotlights as configured by merch-media teams
    And PCX informational banner of how PCX works
    And expandable Terms and Conditions accordion that is collapsed by default

  @HomePage @Wholesale
  Scenario: Home page layout - Signed-in + non-PCO RO-251
    Given I am on the home page of any banner
    And I am logged in AND I have not associated a PCO account with my PCID
    When I scroll down the page
    Then I will see the following components:
    And The navigation
    And a Headline banner
    And a PCX Pass registration banner
    And a Sign in information card
    And a Flyers and deals information card
    And a location details for the order information card
    And a two-up promo carousel
    And a menu tiles carousel to shop categories
    And a Start Shopping mini product tile carousel
    And any product tile carousels as configured by merch team
    And any promotional fifty-fifty wrappers as configured by merch team
    And Four-across promotional tiles as configured by merch team
    And any brand spotlights as configured by merch-media teams
    And PCX informational banner of how PCX works
    And expandable Terms and Conditions accordion that is collapsed by default

  @HomePage @Wholesale
  Scenario: Home page layout - Signed-in + non-PCO RO-252
    Given I am on the home page of any banner
    And I am logged in AND I have associated a PCO account with my PCID
    When I scroll down the page
    Then I will see the following components:
    And The navigation
    And a Headline banner
    And a PCX Pass registration banner
    And a Sign in information card
    And a Flyers and deals information card
    And a location details for the order information card
    And a two-up promo carousel
    And a menu tiles carousel to shop categories
    And a Start Shopping mini product tile carousel
    And any product tile carousels as configured by merch team
    And any promotional fifty-fifty wrappers as configured by merch team
    And Four-across promotional tiles as configured by merch team
    And any brand spotlights as configured by merch-media teams
    And PCX informational banner of how PCX works
    And expandable Terms and Conditions accordion that is collapsed by default

  @HomePage @Wholesale
  Scenario: Home page layout - Guest RO-253
    Given I am on the home page of any banner
    When I click on the CTA headline promo
    Then I will be taken to the associated promotional page

  @HomePage @Wholesale
  Scenario: Headline Banner > Chevrons RO-254
    Given I am on the home page of any banner
    When I click on the chevrons on the right or the left of the screen
    Then I will be taken to the next or previous page promotion

  @HomePage @Wholesale
  Scenario: Headline Banner > Kebab RO-255
    Given I am on the home page of any banner
    When I click on any of the dots in the kebab at the bottom of the the headline banner
    Then I will be taken to the associated headline promotion that I clicked on

  @HomePage @Wholesale
  Scenario: My Shop information card RO-256
    Given I am on the home page of any banner
    When I go to the My Shop information card
    Then I will see a preview of images of items in My Shop
    And I will see a CTA with the number of items in My Shop
    And clicking the CTA  will take me to Most Purchased tab in My Shop section of site

  @HomePage @Wholesale
  Scenario: Flyers and Deals information card RO-257
    Given I am on the home page of any banner
    When I go to the Flyers and Deals information card
    Then I will see a preview of images of items in the flyer
    And I will see a CTA
    And clicking the CTA will take me to the Flyer tab in Flyers and Deals section of site

#  @HomePage
#  Scenario: PCO Rewards Information card RO-258
#    Given I am on the home page of any banner
#    When I go to the PCO Rewards information card
#    Then I will see a preview of images of items that have a loyalty offer
#    And I will see a CTA with the number of loyalty offers available to me
#    And clicking the CTA  will take me to the loyalty offers section of PCX

#  @HomePage
#  Scenario: 2-up promo carousel RO-259
#    Given I am on the home page of any banner
#    And a two-up promo has been configured
#    When I view the two-up promo card carousel
#    Then I will see two side by side cards
#    And each card will contain an image
#    And each card will include a headline and description
#    And each card will contain its own CTA
#    And clicking on each CTA will direct the user to the pages associated with the respective cards


  @HomePage @Wholesale
  Scenario: Menu tiles carousel RO-260
    Given I am on the home page of any banner
    When I view the menu tiles carousel
    Then I will see a list of categories on the site that correspond to LO categories
    And each category will contain an associated icon
    And clicking on an icon will direct the user to the associated LO

  @HomePage @Wholesale
  Scenario: Start Shopping mini product tile carousel RO-261
    Given I am on the home page of any banner
    When I view the Start Shopping mini product tile carousel
    Then I will see a list of items
    And the tiles will contain mini product images
    And the product name
    And the products price
    And any sales information
    And an add to cart button for items not in cart
    And change quantity buttons for items that are in cart
    And the list of items will be horizontally scrollable

#  @HomePage
#  Scenario: Product tile carousels RO-262
#    Given I am on the home page of any banner
#    When I view any merchandised product carousels
#    Then I will see a title of a merchandised category
#    And a carousel of items
#    And each item will have a product tile
#    And each product tile will have the same information and functionality as in the Browse pages
#    And I will be able to scroll the carousel horizontally
#    And there will be a Shop All link
#    And when I click the link, it will direct me to a hub page for that category

  @HomePage @Wholesale
  Scenario: Promotional 50/50 wrappers / Spotlight box - Merchandised RO-263
    Given I am on the home page of any banner
    When I view the fifty-fifty wrapper
    Then I will see two of the following side-by-side as configured by the merch team
    And A banner with an image, title and description
    And a product grid with clickable tiles
    And a Shop All link that will take me to a hub for that promotion

  @Homepage @Wholesale
  Scenario: Four-across promotional tiles RO-266
    Given I am on the home page
    When I view the four-across promotional tiles
    Then I will see four side by side containers
    And each container will have an image, tile, description and Shop now button
    And clicking shop now will direct me to the appropriate page for that promotion

  @Homepage @Wholesale
  Scenario: PCX informational banner RO-267
    Given I am on the home page
    When I scroll to the bottom of the page
    Then I will see an informational fifty-fifty wrapper with information on PCX and a welcome offer
    And the left of the fifty-fifty banner will contain a title, description and Learn more button
    And the right of the wrapper will contain a promotional image
    And the learn more button will direct users to the appropriate page as configured in contentful

  @Homepage @Wholesale
  Scenario: PCX Pass registration banner RO-268
    Given I am on the home page
    And have not registered for PCX pass
    When I view the PCX pass banner
    Then I will see a description of PCX pass
    And a sign up button
    And clicking sign up will direct me to the PCX pass registration page
    And the banner will no longer be on home if I complete by registration for PCX Pass


  @Homepage @Wholesale
  Scenario: Location details information card - No fulfillment option RO-269
    Given I am on the home page
    And have not selected a fulfillment option
    When I view the location details information card
    Then I will see all the fulfillment options available to me (Pickup,Delivery, In-Store)
    And clicking any button will redirect me to an informational page on PCX
    And I will be asked to confirm my location

  @Homepage @Wholesale
  Scenario: Location details information card - Fulfillment option RO-270
    Given I am on the home page
    And have selected a fulfillment option
    When I view the location details information card
    Then I will see the fulfillment option I have selected
    And the location I am shopping at
    And the address and store hours for that location

  @Homepage @Wholesale
  Scenario: Sign in information card RO-271
    Given I am on the home page of any banner
    When I go to the Sign In information card
    Then I will see information on why to sign in
    And a button to sign in to my account
    And clicking the sign in button will direct me to the sign in page
    And a create account link
    And clicking the create account link will direct me to the account creation page


