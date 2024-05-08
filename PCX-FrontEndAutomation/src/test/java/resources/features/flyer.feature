Feature: Flyers

  @Flyer @Wholesale
  Scenario: Flyer tab
    Given I am on the Flyers tab of the Flyers & Deals page
    When I view the page
    Then I will tabs for All Deals,Flyer Items,Flyer
    And I will see a registration link to sign up for emails about the flyer
    And a clickable flyer managed by Flipp
    And a drawer to the right of the flyer with information on how to use the page

  @Flyer @Wholesale
  Scenario: Email Flyer registration
    Given I am on the Flyers tab of the Flyers & Deals page
    When I click on the Sign up to receive our emails link
    Then I will be taken to a registration page where I can provide my name and email to receive emails
    And submitting my information on this page will register me for the mailing list

  #WebDriver browser disabled the Flipp content. Hence, removed the tag.
  Scenario: Flyer Drawer
    Given I am on the Flyers tab of the Flyers & Deals page
    When I click on an item in the flyer
    Then The drawer will update with the same information included in browse product tiles
    And an Add to Cart button
    And clicking the button will add the item to my cart
    And the button will be replace by the quantity configuration buttons once the item is in my cart

  @Flyer @Wholesale
  Scenario: All Deals tab
    Given I am in Flyers & Deals
    When I click on the All Deals tab
    Then I will be taken to All Deals, the page will be a L0 PLP and all items with a deal will be shown on the page

  @Flyer @Wholesale
  Scenario: Flyer items tab
    Given I am in Flyers & Deals
    When I click on the Flyer Items tab
    Then I will be taken to Flyer items and the page will be a L0 PLP and the items on the page will match the items listed in the flyer












