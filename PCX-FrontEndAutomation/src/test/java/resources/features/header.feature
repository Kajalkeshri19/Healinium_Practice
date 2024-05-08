Feature: Header

  @Header @Wholesale
  Scenario: Banner tab TC#76
    Given I am a customer who is on banner.ca
    When I click the banner logo in the top left
    Then I want to be taken to banner homepage

  @Header @Wholesale
  Scenario: Banner tab - 1 TC#77
    Given I am a customer who is on banner.ca
    When I navigate to the site
    Then I should not see the Marketplace tab

  @Header @Wholesale
  Scenario: Pick-up/Delivery TC#78
    Given I am a first time customer on banner.ca
    When I navigate to the site
    Then I should see a default location (based on my IP) in the top right corner

  @Header @Wholesale
  Scenario: Header Pickup TC#79 (All logged in)
    Given I am a previous pickup customer on banner.ca
    When I navigate to the site
    Then I should see my last pickup location in the top right corner

  @Header @Wholesale
  Scenario: Header Pickup - 1 TC#80
    Given I am a first time customer or a previous pickup customer
    When I click the pickup location in the top right
    Then I should see a message displayed that tells me this is my nearest location
    And I should see Nearest Location title
    And I should see the location Name and location Address
    And I should see messaging about this being my nearest location
    And I should have the ability to click Yes, this is my preferred location
    And I should have the ability to click No, change location

  @Header @Wholesale
  Scenario: Header Pickup - 2 TC#81
    Given I am a first time customer or a previous pickup customer
    When I click the pickup location in the top right and click No, change location
    Then I should be taken to the store locator page to find a new location

  @Header @Wholesale
  Scenario: Header Delivery TC#82 (All logged in)
    Given I am a previous delivery customer on banner.ca
    When I navigate to the site
    Then I should see my delivery postal code in the top right corner

  @Header @Wholesale
  Scenario: Header Delivery - 1 TC#83 (All logged in)
    Given I am a previous delivery customer on banner.ca
    When I click into my delivery address in the top left
    Then I should be able to edit my postal code and click save
    And if successful, I should be able to continue shopping
    And if unsuccessful, I should see a message that this address isn't available for delivery