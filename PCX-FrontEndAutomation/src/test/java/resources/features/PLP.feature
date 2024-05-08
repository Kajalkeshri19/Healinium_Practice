Feature: PLP

  @PLP @Wholesale
  Scenario: Browse > PLP TC#125
    Given I am on a PLP
    When Page loads
    Then I will see a grid of all the products
    And  the page will display a page name
    And  filters will be available on left of page
    And  quick filters for Deals | Our Brands | Dietary will display above results (if applicable)
    And sort filter will be on page, default by Relevance
    And media ad units will be displayed at top of page and below filters
    And PCX Pass subscription banner will display above my result
    And sponsored items will be displayed at the top of the page (if applicable)
    And You May Also Like column will be displayed on right of screen (if applicable)

  @PLP @Wholesale
  Scenario: PLP Filters TC#126
    Given I am on a PLP
    And page has loaded
    When  I click on filter on the left of the page
    Then  I will see a grid of all the products
    And  selected filters will display below quick filters
    And  all other behaviour from PLP apply

  @PLP @Wholesale
  Scenario: PLP Quick Filters TC#127
    Given I am on a PLP
    And  page has loaded
    When I click on filter on the left of the page
    Then I will see a grid of all the products
    And selected filters will display below quick filters
    And all other behaviour from PLP apply

  @PLP @Wholesale
  Scenario: PLP remove Filters TC#128
    Given I am on a PLP
    And  page has loaded
    And have selected a filter
    When I click on any of the x buttons next to the filter at the top of page
    Then Filter will be removed
    And  I will remain on PLP
    And all other filters I've selected will still be applied

