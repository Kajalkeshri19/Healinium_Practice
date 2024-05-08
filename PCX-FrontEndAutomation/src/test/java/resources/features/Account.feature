Feature: Account

  @Account
  Scenario: Complete Profile-First Time user TC-1
    Given I have created a PCID AND have not used PCX in the past
    When I login to PCX for the first time
    Then my PCX profile should be created by CDS and associated with my PCID account

    # TC-2 Block due to email verification | 2-way verification | done with Happy Path only
  @Account
  Scenario: Delete Account-PCX TC-2
    Given I have deleted my account on LOB X and the process is NOT completed
    When i try to login on LOB X with same PCID email address
    Then  the account is marked for deletion
    And an email is sent to customer And an email is sent to Privacy
    And i cannot login to that LOB using the same PCID credentials
    And i am logged out of all devices where i am logged in Detailed process
#    : https://confluence.lblw.cloud/pages/viewpage.action?pageId=617116323#DeleteaccountInPlatformworld-SDMprocess

  @Account
  Scenario: Delete Account-PCX TC-3
    Given i have deleted my account on PCX (irrespective of whether the process is completed or NOT)
    When i login to another LOB Y
    Then i am able to login as usual into LOB Y

  @Account
  Scenario: Migrate customers from Hybris to new Platform TC-4
    Given i have added information on a LOB which is stored in Hybris AND customer is successfully migrated to the new platform
    When i log in to the LOB
    Then I can see my previously stored info : All the details mentioned in the above View cases
#  Ex: Name, Shipping info,Billing address, Preferences

  @Account
  Scenario: Rollback to Hybris in case of issues TC-5
    Given my information is moved to the new platform AND LD does a rollback
    When i log in to the LOB
    Then i can see my latest stored info : All the details mentioned in the above View cases
#  Ex: Name, Shipping info,Billing address, Preferences

  @Account
  Scenario: View Payment
    Given I'm a logged in PCX user
    When I navigate to My Account > Payment
    Then I should see my saved card details (visa mastercard, last 4 digits, and primary tag). My Primary card should appear on top.

  @Account
  Scenario: Add Payment
    Given I'm a logged in PCX user
    When I navigate to My Account > Payment
    Then I should be able to add a card
    And enter billing address details
    And add credit card details
    And designate the card as my primary card
    And save the new card to my account

  @Account
  Scenario: Add Primary Payment
    Given I'm a logged in PCX user
    When I navigate to My Account > Payment
    And add a new primary card
    Then My new card should become primary and should appear on top. I should see this card as primary on checkout page as well.

  @Account
  Scenario: Remove Payment
    Given I'm a logged in PCX user and I have already added a card to my account
    When I navigate to My Account > Payment
    Then I should see all previously added cards with the card type, and last 4 digits on the card
    And be able to remove the card by clicking Remove. On clicking Remove, I should be asked for a confirmation.

  @Account
  Scenario: Remove Primary Payment
    Given I'm a logged in PCX user and I have already added a card to my account
    When I navigate to My Account > Payment
    And add a new primary card
    Then I should see all previously added cards except for the deleted card and none of the cards should be marked as primary

  @Account
  Scenario: PC Optimum details
    Given I’m a logged in using PC ID and I don’t have an existing PC Optimum account
    When I go to PC Optimum section on web
    Then I’m presented with an option to enroll for PC Optimum

  @Account
  Scenario: PC Optimum details
    Given I'm a logged in user who has a PCO, PCOI account
    When I log into my account->PC Optimum
    Then I can see my PCO or PCOI points balance and account information (first name, last name and email address)
    And go to pcoptimum.ca
#   And delete my PC optimum account

  @Account
  Scenario: Create PCO Account
    Given I'm a logged in PCX user AND I do not have a PCO account linked to my PCID
    When I navigate to My Account > PC Optimum
    Then I will be able to register for a new account by consenting to receiving electronic messages, agreeing to the Terms & Conditions and clicking Continue

  @Account
  Scenario: Order summary-View billing address
    Given As a logged in PCX user
    When i go to my order summary
    Then i want to view  billing information I have provided on my order , so that I can confirm that payment is made to the correct card


    @TestingNewAccount
    Scenario: Create a PC Id
      Given I am on the Sign in Page
      When I click on the Create a PCid button and create PCID account
      Then I can login to PCX using my credentials once created

