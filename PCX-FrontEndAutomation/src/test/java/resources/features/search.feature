Feature: Search

  @Search @Wholesale
  Scenario: Search Recommendations TC-20
    Given I am on any page with search AND have never completed a search
    When I click on search bar
    Then Top Searches are recommended

  @Search @Wholesale
  Scenario: Search History TC-21
    Given I am on any page with search AND have previously attempted a search
    When I click on search bar
    Then Last five searches are recommended above Top Searches

  @Search @Wholesale
  Scenario: Search Auto-complete TC-22
    Given I am on any page with search
    When I click on search bar AND type in a character
    Then Recommended searches will be displayed (if applicable)

  @Search @Wholesale
  Scenario: Search Results TC-23
    Given I have typed in a search query
    When I click enter AND results exist
    Then I will be taken to a product grid with my search results
    And the page will display my search term and total no of results
    And aisles and filters will be available on left of page
    And sort filter will be on page, defaulted by Relevance
    And PCX Pass subscription banner will display above my results

  @Search @Wholesale
  Scenario: No Results TC-24
    Given I have typed in a search query having no Result
    When I click enter AND results do not exist
    Then I will be taken to a No Results page and error message will be displayed
    And categories will be displayed below error message

  @Search @Wholesale
    Scenario: Search remove Filters TC-66
      Given I have completed a search AND I have results AND I have selected a filter
      When I click on any of the x buttons next to the filter at top of page
      Then Filter will be removed AND I will remain on Search Results that match my query and any other filters I have selected

  @Search @Wholesale
  Scenario: Search clear all Filters TC-67
    Given I have completed a search AND I have results AND I have selected a filter
    When II click on clear all at top of page
    Then All Filters will be removed
    And  I will remain on Search Results that match my query and any aisles I've selected

  @Search @Wholesale
  Scenario: Search Sort TC-68
    Given I have completed a search AND I have results
    When I click on Sort By dropdown AND select a new value
    Then I will remain on my search results
    And  my results will now be sorted by the new sort selection

  @Search @Wholesale
  Scenario: Search > Category Listing Page TC-69
    Given I have typed in a search query
    When I click enter AND a CLP is mapped to my results
    Then I will be taken the appropriate CLP
    And the page will display my search term
    And the page will display total number of results
    And aisles will be available on left of page
    And filters will be available on left of page1
    And quick filters for Deals | Our Brands | Dietary will display above results (if applicable)1
    And sort filter will be on page, defaulted by Relevance
    And media ad units will be displayed at top of page and below filters1
    And PCX Pass subscription banner will display above my results