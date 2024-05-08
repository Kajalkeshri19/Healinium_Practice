Feature: PDP

  @PDP
  Scenario: PDP default state
    Given I am on a PDP
    When the page loads
    Then page will display all the required infomation
      | Excel         | Location                                            | Sheet |
      | ddt_data.xlsx | src/main/java/resources/external_data/pcx_data.xlsx | PDP   |
    # As this will drive DDT manner, it is not feasible to keep multiple steps for one scenario.
      # Hence, combined the step to validate product image with magnifying class, brand,name,price,weight,cost per 100,atc button
    #expanded button, collapsed buttons & related items

  @PDP @Deals
  Scenario: Item discount
    Given I am on a PDP
    When the page loads
    Then price of the item will have crossed out and the discounted price will be displayed in red, sale badge and amount saved and expiration date of the discount
      | Excel         | Location                                            | Sheet |
      | ddt_data.xlsx | src/main/java/resources/external_data/pcx_data.xlsx | PDP   |

  @PDP
  Scenario: Low stock
    Given I am on a PDP
    When the page loads
    Then PDP will display a low stock inventory badge and provide additional context on what this means
      | Excel         | Location                                            | Sheet |
      | ddt_data.xlsx | src/main/java/resources/external_data/pcx_data.xlsx | PDP   |

  @PDP
  Scenario: Out Of Stock
    Given I am on a PDP
    When the page loads
    Then PDP will display a out of stock inventory badge and provide additional context on what this means and I will not be able to add this item to my cart
      | Excel         | Location                                            | Sheet |
      | ddt_data.xlsx | src/main/java/resources/external_data/pcx_data.xlsx | PDP   |

  @PDP
  Scenario: Add to cart
    Given I am on a PDP
    When the page loads
    Then click on Add To Cart and the item will be added to my cart
      | Excel         | Location                                            | Sheet |
      | ddt_data.xlsx | src/main/java/resources/external_data/pcx_data.xlsx | PDP   |

  @PDP  @Deals
  Scenario: Deal / Sale
    Given I am on a PDP
    When the page loads
    Then PDP will display deal information on the page along with Savings Strikethorugh pricing and the expiration date of the promo
      | Excel         | Location                                            | Sheet |
      | ddt_data.xlsx | src/main/java/resources/external_data/pcx_data.xlsx | PDP   |

  @PDP @Deals
  Scenario: Multibuy
    Given I am on a PDP
    When the page loads
    Then The PDP will display deal information on the page along with Min purchase price and the expiration date of the promo
      | Excel         | Location                                            | Sheet |
      | ddt_data.xlsx | src/main/java/resources/external_data/pcx_data.xlsx | PDP   |

#  Recommendation Microservice not migrated yet for PCX-QA, Bug-LDP-19104.
  @PDPLater
  Scenario: Related items
    Given I am on a PDP
    When the page loads
    Then Related items will display at the bottom of the page
      | Excel         | Location                                            | Sheet |
      | ddt_data.xlsx | src/main/java/resources/external_data/pcx_data.xlsx | PDP   |

  @PDP
  Scenario: Change quantity
    Given I am on a PDP
    When the page loads
    Then The quantity of the item in my cart will update and the new quantity of the item will display in the tile
      | Excel         | Location                                            | Sheet |
      | ddt_data.xlsx | src/main/java/resources/external_data/pcx_data.xlsx | PDP   |

  @PDP
  Scenario: Remove item
    Given I am on a PDP
    When the page loads
    Then The item will be removed from my cart and the amount section will disappear and the add to cart button will re-appear
      | Excel         | Location                                            | Sheet |
      | ddt_data.xlsx | src/main/java/resources/external_data/pcx_data.xlsx | PDP   |