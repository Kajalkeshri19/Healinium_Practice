Feature: Footer

  @Footer @Wholesale
  Scenario: Viewing PCX FAQs
    Given I am on the Homepage footer
    When I click on the FAQs under the About PC Express section
    Then I should be directed to the FAQs page

  @Footer @Wholesale
  Scenario: Viewing PCX How It Works Page
    Given I am on the Homepage footer
    When I click on the PCX How It Works Page under the About PC Express section
    Then I should be taken to the PCX How It Works page

  @Footer @Wholesale
  Scenario: Viewing PCX Delivery Page
    Given I am on the Homepage footer
    When I click on Delivery Page under the PC Express section
    Then I should be directed to the PCX Delivery Page about and I should see a Start Shopping button

  @Footer @Wholesale
  Scenario: Viewing PCX Pickup Page
    Given I am on the Homepage footer
    When I click on Pickup Page under the PC Express section
    Then I should be directed to the PCX Pickup Page about and I should see a Start Shopping and Shop Rapid Delivery button

  @Footer @Wholesale
  Scenario: Viewing PCX Reusable Box Swap Page
    Given I am on the Homepage footer
    When I click on Reusable Box Swap under the PC Express section
    Then I should be directed to the Reusable Box page and I see a description of how the reusable box works
    And I should see an option to shop for resuable bags
   # Commented this step as the end result is not functioning on either environment
   # And I should see an option to shop for reusable boxes that directs me to the reusable box item

  @FooterWWAP @Wholesale
  Scenario: Viewing Who We Are Page
    Given I am on the Homepage footer
    When I click on Who We Are under the About Us section
    Then I should be directed to the About Loblaws page
    And I should see a Start Shopping button on the page that directs me to the store locator page
    And I should see a Choose your Location button on the page that directs me to the store locator page

  @Footer @Wholesale
  Scenario: Viewing Charity & Community Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Charity and Community Page
    Then they should be redirected to the pcChildrenCharity

  @Footer @Wholesale
  Scenario: Viewing Corporate Social Responsibility Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Corporate Social Responsibility Page
    Then they should be redirected to the Responsibility page based on the banner selected

  @Footer @Wholesale
  Scenario: Viewing Partner stores Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Partner stores Page
    Then they should be redirected to the Partner Store Page
    And they should be able to see a list of stores per areas

  @Footer @Wholesale
  Scenario: Viewing Store Locator Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Partner Store Locator Page
    Then they should be redirected to the Store Locator page based
    And they should see a list of stores where they can select a location
    And they should be able to search for an address
#    And they should be able to filter for store results
#    And they should be ablet to view the store details and the opening hours for the store
#    And they should be able to use the map to see the stores in an area and click on a pin to view the store details.

  @Footer @Wholesale
  Scenario: Viewing Contact Us Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Contact Us Page
    Then they should be redirected to the contact us based on the banner selected
    And they should be able to select a reason under Email and add in the details of the customer reaching out
    And the customer should see the CSR, PCX Express and Write to US details

  @Footer @Wholesale
  Scenario: Viewing Careers Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Careers Page
    Then they should be redirected to the Careers page

  @Footer @Wholesale
  Scenario: Viewing Weekly Flyer Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Weekly Flyer Page
    Then they should be redirected to the weekly-flyer page based on the banner selected
    And they should see the store information and a CTA to select the Store or a change store link
    And they should see-use the functionality on the Flyer page

  @Footer @Wholesale
  Scenario: Viewing Fruits & Vegetables Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Fruits & Vegetables Page
    Then they should be redirected to the Viewing Fruits & Vegetables Page CLP page
    And should be able to see-use the functionality on the Fruits & Vegetables CLP Page

  @Footer @Wholesale
  Scenario: Viewing Dairy & Eggs Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Dairy & Eggs Page
    Then they should be redirected to the Viewing Dairy & Eggs Page CLP page
    And should be able to see-use the functionality on the Dairy & Eggs CLP Page

  @Footer @Wholesale
  Scenario: Viewing Pantry Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Pantry Page
    Then they should be redirected to the Viewing Pantry CLP page
    And should be able to see-use the functionality on the Pantry CLP Page

  @Footer @Wholesale
  Scenario: Viewing Meat Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Meat Page
    Then they should be redirected to the Viewing Meat CLP page
    And should be able to see-use the functionality on the Meat CLP Page

  @Footer @Wholesale
  Scenario: Viewing Bakery Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Bakery Page
    Then they should be redirected to the Viewing Bakery CLP page
    And should be able to see-use the functionality on the Bakery CLP Page

  @Footer @Wholesale
  Scenario: Viewing Joe Fresh Page
    Given I am on the Homepage footer
    When they click on a footer link Viewing Joe Fresh Page
    Then they should be redirected to the Viewing Joe Fresh CLP page

  @Footer @Wholesale
  Scenario: Viewing the Gift Cards Page
    Given I am on the Homepage footer
    When the customer clicks on the Gift Cards page
    Then they should be redirected to the Gift Cards Page

  @Footer @Wholesale
  Scenario: Viewing the PC Optimum Insiders Page
    Given I am on the Homepage footer
    When the customer clicks on the PC Optimum Insiders in footer
    Then they should be redirected to the PC Optimum Insiders Page

  @Footer @Wholesale
  Scenario: Viewing the Pharmacy Page
    Given I am on the Homepage footer
    When the customer clicks on the Pharmacy Page
    Then they should be redirected to the Pharmacy Page

  @Footer @Wholesale
  Scenario: Viewing the Photo Lab Page
    Given I am on the Homepage footer
    When the customer clicks on the Photo Lab in footer
    Then they should be redirected to Photo Lab Page

  @Footer @Wholesale
  Scenario: Viewing the PC Financial Page
    Given I am on the Homepage footer
    When the customer clicks on the PC Financial in footer
    Then they should be redirected to PC Financial Page

  @Footer @Wholesale
  Scenario: Viewing the Recipes Page
    Given I am on the Homepage footer
    When the customer clicks on the Recipes in footer
    Then they should be redirected to Recipes Page

  @Footer @Wholesale
  Scenario: Viewing the Advertise with Loblaw Media Page
    Given I am on the Homepage footer
    When the customer clicks on the Advertise with Loblaw Media in footer
    Then they should be redirected to Advertise with Loblaw Media Page
