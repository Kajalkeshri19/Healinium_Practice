Feature: SRP
  
#  @SRP @Rapid
#  Scenario: Rapid - Search TC-55
#    Given I want to conduct a search on Rapid
#    When I click into the search bar and begin typing
#    Then I shoud see suggested results underneath the search bar
#
#  @SRP @Rapid
#  Scenario: Rapid - Search TC-56
#    Given I want to conduct a search on Rapid
#    When I click into the search bar, type a keyword and press enter
#    Then if there are results: I should see the SRP with related results
#    #(note, SRP will load 32 results; user is required to click load more, to load more if available)
#
#  @SRP @Rapid
#  Scenario: Rapid - Search TC-57
#    Given I am on a Rapid pdp
#    When I click into the search bar, type a keyword(no result) and press enter
#    Then if there are no results: I should see the message We were unable to find results for xx
#   #Try checking your spelling or searching something less specific."" with the ability to try search again, in page.

  @SRP @Wholesale
  Scenario: Search Recommendations TC-58
    Given I am on any page with search AND have never completed search
    When I clicked on search bar
    Then Top Searches are recommended me

  @SRP @Wholesale
  Scenario: Search History TC-59
    Given I am on any page with search AND have previously attempted search
    When I click into search bar
    Then Last Five searches are recommended above Top Searches

  @SRP @Wholesale
  Scenario: Search Auto-complete TC-60
    Given I am on any page with search bar
    When I click on search bar and type in a character
    Then Recommended searches will be display (if applicable)

  @SRP  # cover in Search
  Scenario: Search Results TC-61
    Given I have typed in a search query
    When I click enter AND results exist
    Then I will be taken to a product grid with my search results
    And the page will display my search term
    And the page will display total number of results
    And aisles will be available on left of page
    And filters will be available on left of Page
    And quick filters for Deals | Our Brands | Dietary will display above results(if applicable)
    And sort filter will be on page, defaulted by Relevance
    And media ad units will be displayed at top of page and below filters
    And PCX Pass subscription banner will display above my results

  @SRP # cover in Search
  Scenario: No Results TC-62
    Given I have typed in a search query having no Result
    When I click enter AND results do not exist
    Then I will be taken to a No Results page and error message will be displayed
    And categories will be displayed below error message

   @Wholesale
  Scenario: Search Filters TC-63
    Given I have completed a search And I have results
    When I click on Filter on the left of the Page
    Then I will see the number of items from my search that fit into that filter
    And selected filters will display below quick filter
    And all other behaviour from Search Results apply

  @Wholesale
  Scenario: Search Aisles TC-64
    Given I have completed a search And I have results
    When I click on aisle on the left of the page
    Then I will see the number of items from my search that fit into that aisle
    And all other behaviour from Search Results apply

  @SRP @Wholesale
  Scenario: Search Quick Filters TC-65
    Given I have completed a search And I have results
    When I click on quick filter on top of the page
    Then I will see the number of items from my search that fit into that quick filter
    And I will see the selected
    And all other behaviour from Search Results apply

  @SRP # cover in Search
  Scenario: Search remove Filters TC-66
    Given I have completed a search AND I have results AND I have selected a filter
    When I click on any of the x buttons next to the filter at top of page
    Then Filter will be removed AND I will remain on Search Results that match my query and any other filters I have selected

  @SRP # cover in Search
  Scenario: Search clear all Filters TC-67
    Given I have completed a search AND I have results AND I have selected a filter
    When II click on clear all at top of page
    Then All Filters will be removed
    And  I will remain on Search Results that match my query and any aisles I've selected

  @SRP # cover in Search
  Scenario: Search Sort TC-68
    Given I have completed a search AND I have results
    When I click on Sort By dropdown AND select a new value
    Then I will remain on my search results
    And  my results will now be sorted by the new sort selection

  @SRP # cover in Search
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