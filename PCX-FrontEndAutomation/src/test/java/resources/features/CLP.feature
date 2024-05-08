Feature: CLP

  @CLP @Wholesale
  Scenario: Browse > CLP TC-192
   Given I am on a CLP
   When Page loading
   Then I will see carousels for different categories stacked on the page
   And each carousel will include a Shop all button
   And each carousel can scroll horizontally
   And each item in the grid will include a + button to add to cart
   And all cards will show all applicable information (to be covered in separate use case)
   And the page will display a page names
   And the page will include a breadcrumb of where I am on the browse experience
   And sub-categories will display on left of page
   And media ad units will be displayed at top of page and on left of page
   And sponsored carousel will be displayed at the top of the page (if applicable)

   @CLP @Wholesale
   Scenario: CLP > PLP TC-193
    Given I am on a CLP
    When I click on Shop all for a category
    Then I will see taken to the corresponding PLP

   @CLP @Wholesale
   Scenario: CLP > Sub-category TC-194
    Given I am on a CLP
    When I click on one of the sub-categories on left of page
    Then I will see taken to the corresponding PLP

