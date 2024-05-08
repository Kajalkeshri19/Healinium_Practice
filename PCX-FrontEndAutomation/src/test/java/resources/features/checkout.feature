Feature: Checkout

  @Row163 @M2Purchase @Checkout @SetDeliveryDetails @Delivery @UAT
  Scenario: Order checkout-View delivery address TC-163
    Given I am a user logged into PCX who has not added a delivery address
    When I navigate to checkout page and try to view my delivery address information
    Then I cannot see my delivery address  as there is no address info on my profile

  @Row164 @M2Purchase @Checkout @SetDeliveryDetails @Delivery @UAT
  Scenario: Order checkout-Add delivery address TC-164
    Given A logged in PCX user who does not have a delivery address on my profile
    When I add items to my cart and proceed to checkout
    Then I can add one or more delivery addresses to my profile by providing the following information for each address: First name & Last name & Street address

  @Row167 @M2Purchase @Checkout @SetDeliveryDetails @Delivery @UAT
  Scenario: Order checkout-View delivery address TC-167
    Given I’m a user logged into PCX who has at least one delivery address saved to my profile
    When I add items to my cart and proceed to checkout
    Then I can see my saved delivery address with the following fields : First name , Last name , Street address , Apt or Suite or Unit , City , Provinc , Postal code
    And I can select the address on which I want to receive my shipment

  @Row168 @M2Purchase @Checkout @SetDeliveryDetails @Delivery @UAT
  Scenario: Order checkout - Select Delivery Details TC-168
    Given I’m a user logged into PCX who has at least one delivery address saved to my profile
    When I want to select a delivery time
    Then I should see the delivery responses from FAAS with:3 time options lowest fee, same day, select a time opens modal to select future times,first 2 options should show: time range, date- tomorrow today, fee same day, under these 2 options will be the delivery fee itself

  @Row169 @M2Purchase @Checkout @SetDeliveryDetails @Delivery @UAT
  Scenario: Order checkout - Select Delivery Details TC-169
    Given I’m a user logged into PCX who has at least one delivery address saved to my profile
    When I want to select a delivery time in the future two+ days out
    Then I click on `select a time` to open the modal.
    And I can: select a future date
    And see available timeslots on all days and ones not available (since they are full) shown accordingly
    And see the delivery fee for each timeslot
    And select any available timeslots
    And Upon timeslot selection, I should see a confirmation modal with: my postal code, timeslot selected [time range], [date]
    And What you need to know` section
    And `Reserve` CTA, or `cancel, go back` CTA

  @Row170 @M2Purchase @Checkout @SetPickupDetails @Delivery @UAT
  Scenario: Order checkout - Select Delivery Details TC-170
    Given I’m a logged in PCX user Delivery
    When I add items to my cart and proceed to checkout to select a delivery time
    Then Upon reserving my timeslot, the selection is saved in Delivery details and applicable fees have been added to my order summary.

  @Row176 @M2Purchase @Checkout @AddItemDetailsInstructions @Delivery @UAT
  Scenario: Order checkout - Add Item Details TC-176
    Given I’m a user logged into PCX who has at least one delivery address saved to my profile
    When  I'm at checkout
    Then I can enter in Additional instructions for your personal shopper

    #Removed from the PCX-Helios sheet. Hence, OOS
#  @Row177 @M2Purchase @Checkout @SetDeliveryDetails @Delivery
  Scenario: Order confirmation-Review delivery address information TC-177
    Given I’m a logged in PCX user
    When I review my order
    Then I can see my delivery address (selected during order checkout) on order review page

  @Row178 @M2Purchase @Checkout @SetBaggingPreferences @Pickup @UAT
  Scenario: Order checkout - Add baggage preferences TC-178
    Given I’m a logged in PCX user
    When I'm viewing my bagging preferences
    Then I can choose to bring my own bags by selecting the checkbox

  @Row179 @M2Purchase @Checkout @SetBaggingPreferences @Pickup @UAT
  Scenario: Order checkout - Add baggage preferences TC-179
    Given I’m a logged in PCX user
    When I'm viewing my bagging preferences
    Then I can choose to use my own reusable boxes and select the number of boxes I'll be bringing

  @Row180 @M2Purchase @Checkout @SetBaggingPreferences @Pickup @UAT
  Scenario: Order checkout - Add baggage preferences TC-180
    Given I’m a logged in PCX user
    When I'm viewing my bagging preferences
    Then I can choose to buy reusable boxes and click on the `add` CTA to add it to my order

  @Row181 @M2Purchase @Checkout @SetBaggingPreferences @Pickup @UAT
  Scenario: Order checkout - Add baggage preferences TC-181
    Given I’m a logged in PCX user
    When I'm viewing my bagging preferences
    Then I can choose to buy reusable boxes and have added three to my order
    And My order total should update once I click `save & continue`

  @Row182 @M2Purchase @Checkout @SetContactInformation @Pickup @UAT
  Scenario: Order checkout - contact information TC-182
    Given I’m a logged in PCX user
    When I'm viewing my contact details for the first time (first order to be placed)
    Then I should see the phone number I entered during profile creation populate here

  @Row183 @M2Purchase @Checkout @SetContactInformation @Pickup @UAT
  Scenario: Order checkout - contact information TC-183
    Given I’m a logged in PCX user
    When I'm viewing my contact details as an existing customer
    Then I should see my phone number pre-filled

  @Row186 @M2Purchase @Checkout @SetContactInformation @Pickup @UAT
  Scenario: Order checkout - contact information TC-186
    Given I’m a logged in PCX user
    When I'm viewing my contact details
    Then I can click `edit` to edit my number number and SMS preferences. Clicking on `edit` phone number will bring me to my accounts page to update phone number.


#Commented these 3 test cases as QA testing is restricted to test stores only.
#  @Row171 @M2Purchase @Checkout @SetDeliveryDetails
#  Scenario:Order checkout - Select Pick Up Details TC-171
#    Given A logged in PCX user who have not placed a PCX order yetI don't have any items in my cart
#    When I add items to my cart and proceed to checkout
#    Then I am autolocated to the closest pick up location
#

#  @Row172 @M2Purchase @Checkout @SetDeliveryDetails
#  Scenario:Order checkout - Select Pick Up Details TC-172
#    Given A logged in PCX user who have placed an order before
#    When I add items to my cart and proceed to checkout
#    Then I am autolocated to the closest pick up location with the next closest pick up location displayed.
#    And Selecting the other location will not offer any other timeslots at that location.
#    And  The other location will show: Name of pick up location
#    And address of this location along with how far it is from the pre-determined location closest to you
#    And timeslot selection shows: pick up, [time range], [date], fee
#

#  @Row173 @M2Purchase @Checkout @SetPickupDetails @Pickup
#  Scenario:Order checkout - Select Pick Up Details TC-173
#    Given A logged in PCX user who have placed an order before
#    When I add items to my cart and proceed to checkout
#    Then I am autolocated to the closest pick up location and can select a pick up time (pre-populated) at this location.
#    And I should see the Pickup responses from FAAS with:
#    And Three time options fastest, next day, select a time (opens modal to select future times)
#    And first two options should show: Pickup, time range, date- tomorrow or today, fastest or same day
#    And under these two options will be the delivery fee itself

  @Row174 @M2Purchase @Checkout @SetPickupDetails @Pickup
  Scenario:Order checkout - Select Pick Up Details TC-174
    Given I’m a logged in PCX user
    When I add items to my cart and proceed to checkout to select a pick up time
    Then I click on `select a time` to open the modal.
    And I can: select a future date
    And see available timeslots on all days and non-available ones indicated accordingly
    And see the pickup fee for each timeslot
    And select any available timeslots
    And Upon timeslot selection, I should see a confirmation modal with: my postal code, timeslot selected [time range], [date]
    And What you need to know` section
    And `Reserve` CTA, or `cancel, go back` CTA

  @Row175 @M2Purchase @Checkout @SetDeliveryDetails @Pickup @UAT
  Scenario:Order checkout - Select Pick Up Details TC-175
    Given I’m a logged in PCX user
    When I add items to my cart and proceed to checkout to select a pick up time
    Then Upon reserving my timeslot, the selection is saved in Pickup details and applicable fees have been added to my order summary. Booking is created in DCM.

  @Row185 @M2Purchase @Checkout @SetContactInformation @Pickup @UAT
  Scenario:Order checkout - contact information TC-185
    Given I’m a logged in PCX user
    When I'm viewing my contact details
    Then I can click `edit` to edit my number number at checkout directly


  @Row186 @M2Purchase @Checkout @SetContactInformation @Pickup @UAT
  Scenario:Order checkout - contact information TC-186
    Given I’m a logged in PCX user
    When I'm viewing my contact details
    Then I can click edit to edit my number number and SMS preferences.
    And Clicking on `edit` SMS Order Updates will bring me to my preferences page to update SMS settings.


    #Unable to replicate on the QA environment
  Scenario:Order checkout - contact information TC-221
    Given I’m a logged in PCX user
    When I'm viewing my contact details
    Then I can edit my SMS preferences by checking or unchecking the checkbox at checkout.

    #Removed from the PCX-Helios sheet. Hence, OOS
#    Done with Happy path , for now I am not able to place order due to unavailability of appropriate location
#  @Checkout
#  Scenario:Order History-Review shipment information TC-222
#    Given I have placed an order (Irrespective of current status - Not shipped, Partially shipped, Delivered, Cancelled)
#    When i view my order history
#    Then I can see the delivery address for each order

  @Row189 @M2Purchase @Checkout @Wholesale @SetPaymentMethod @Delivery
  Scenario:Order checkout-View billing address TC-189
    Given i am checking out
    When i try to select my payment method
    Then i can see the list of saved card details (visa or mastercard label and last four digits)
    And i can select one among them.
    And My primary card should appear on top

  @Row190 @M2Purchase @Checkout  @Wholesale @SetPaymentMethod @Delivery
  Scenario:Order checkout - Add new payment method TC-190
    Given i have finished providing all the delivery information and delivery method
    When i decide to add a new payment method
    Then I am shown fields to enter my billing address Street address (Mandatory)
    And Apt or Suit or unit (optional)
    And City (Mandatory)
    And Province or State (Mandatory)
    And Postal code or Zip code (Mandatory)
    And Country (Mandatory)
    And invalid or empty inputs fields are handled gracefully, show appropriate error messaging and are recoverable upon valid retry

#  NOTE
#    * User can select a flag to choose billing address to be same as delivery address
#    * Billing address is supported for both US and Canada (refer screenshot)
#    * The billing address entered by user on checkout page is also reflected on “My Account” page under payment"

      #Removed from the PCX-Helios sheet. Hence, OOS
  Scenario:Order checkout-View billing address TC-225
    Given I have provided billing address during checkout while adding a new card
    When i move to enter card details
    Then i can view the entered Billing Address

#               Payment can't automated for now
#  @Checkout
#  Scenario:Order checkout - Change primary payment method TC-226
#    Given i have finished providing all the delivery information and delivery method
#    When I select a card other than my primary card and select Make this my primary card
#    Then After I pay with the card, it should become my primary card and should appear as Primary on My Account -> Payment and Checkout pages.

  @Row193 @M2Purchase @Checkout @SetPaymentMethod @Wholesale @Delivery
  Scenario:Order checkout - Supported card networks TC-193
    Given i have finished providing all the delivery information and delivery method
    When I add a new card other than Visa or Mastercard ( Amex, Discover, Diners Club etc)
    Then I should be presented with an appropriate error and should not be allowed to add the card

#               Block , I have no way to update billing address on this page , as ask in test case
#  @Checkout
#  Scenario:Order checkout-Update Billing address TC-228
#    Given I’m logged in PCX user who is on order checkout page
#    When I want to update my billing address
#    Then I can do so by updating any of the following fields Street address (Mandatory)
#    And Apt / Suite / Unit (optional)
#    And City (Mandatory)
#    And Province/State (Mandatory)
#    And Postal code/Zip code (Mandatory)
#    And Country (Mandatory)

#  Note
#  1. User can update multiple billing addresses on their profile corresponding to mutiple cards one at a time
#  2. When user updates their billing address, this does not impact the billing address on previous orders"
     #Removed from the PCX-Helios sheet. Hence, OOS
  Scenario:Order checkout-Delete payment method TC-195
    Given I have saved card & billing address on my account
    When I try to delete my payment method
    Then i am able to do so from checkout page by deleting one card at a time

#  @Checkout # Duplicate As TC-225
#  Scenario:Order checkout-View billing address TC-230
#    Given I have provided billing address during checkout while adding a new card
#    When i move to enter card details
#    Then i can view the entered Billing Address

  #    No such card credential| done with happy path

   #Removed from the PCX-Helios sheet. Hence, OOS
  Scenario:Order checkout-Suspected fraud TC-231
    Given i move to enter new card details
    When the card violates fraud rules set in Cybersource Decision Manager (velocity, known fraudster etc)
    Then I should see an error and not be able to add or use the card

    #Removed from the PCX-Helios sheet. Hence, OOS
  Scenario: Order checkout-Update delivery address
    Given A logged in PCX user who wants to add a new address different from what I have on my profile
    When I add items to my cart and proceed to checkout
    Then I can add one or more delivery addresses to my profile by providing the following information for each address:First name , Last name , Street address , Apt , City , Province , Postal code , Phone number , Delivery instuctions , Make this my primary address.

    #Removed from the PCX-Helios sheet. Hence, OOS
  Scenario: Order checkout - Change primary payment method
    Given i have finished providing all the delivery information and delivery method
    When I select a card other than my primary card and select "Make this my primary card"
    Then After I pay with the card, it should become my primary card and should appear as Primary on My Account -> Payment and Checkout pages.


  @Row263 @M2Purchase @Checkout @FaaSSanityFlows  @OrderPlace
  Scenario: Pickup Happy Path TC-263
    Given that I am a PCX customer who has selected pickup
    When I go to checkout and select a pickup time and fill in all checkout steps (contact details, bagging preferences, item details)
    Then I should be able to successfully place a pickup order

 @Row264 @M2Purchase @Checkout @FaaSSanityFlows @OrderPlace
  Scenario: Delivery Happy Path TC-264
    Given that I am a returning PCX customer who has previously selected delivery
    When I go to checkout and select a delivery time and fill in all checkout steps (contact details, bagging preferences, item details)
    Then I should be able to successfully place a delivery order

#
#  @Checkout
#  Scenario: Changing fulfilment method
#    Given I have a cart full of items and I have previously used the fulfillment method pick up
#    When I go to the checkout page
#    Then then I should see my fulfillment options in the Pickup tab in the following order - Fastest (Alternative store) , Cheaptest (Only until checkout) , Same day (Only until checkout) , Select a custom time from timeslot selector (Only until checkout)
#
#  @Checkout
#  Scenario: Changing fulfilment method
#    Given I have a cart full of items and I have previously used the fulfillment method delivery
#    When I go to the checkout page
#    Then then I should see my fulfillment options in the delivery tab in the following order - Fastest (Alternative store) , Cheaptest (Only until checkout) , Same day (Only until checkout) , Select a custom time from timeslot selector (Only until checkout)
#

    #Removed from the PCX-Helios sheet. Hence, OOS
  Scenario: Changing fulfilment method
    Given I have a cart full of items and I have previously used the fulfillment method pick up
    When I go to the checkout page
    Then then I should see my fulfillment options in the Pickup tab in the following order - Fastest (Alternative store) , Cheaptest (Only until checkout) , Same day (Only until checkout) , Select a custom time from timeslot selector (Only until checkout)

    #Removed from the PCX-Helios sheet. Hence, OOS
  Scenario: Changing fulfilment method
    Given I have a cart full of items and I have previously used the fulfillment method delivery
    When I go to the checkout page
    Then then I should see my fulfillment options in the delivery tab in the following order - Fastest (Alternative store) , Cheaptest (Only until checkout) , Same day (Only until checkout) , Select a custom time from timeslot selector (Only until checkout)

  @Row220 @M2Purchase @Checkout @PlaceOrder @OrderPlace
  Scenario:Order - Place Order TC-220
    Given i'm logged in PCX user who is on order checkout page
    When I select Place Order
    Then I should see an order confirmation page

 #Test Data Unavailable
#  @Checkout
#  Scenario: Changing fulfilment method on checkout
#    Given I have a cart full of items with the fulfillment method pick up with non-deliverable item
#    When I go to checkout page and place order by selecting delivery
#    Then The undeliverable product should be dropped from the customers cart
#    And The order summary should reflect the change


 #Unavailable Test data

#  @Checkout
#  Scenario: Changing fulfilment method on checkout  - Error Cases
#    Given I have a cart full of items with the fulfillment method pick up
#    When I go to checkout page and change the fulfilment method to delivery
#    Then If there are products that cannot be delivered (Eg: HMR Chicken) I should see an error state and should be provided with option to either proceed for go back,
#    And if the customer chooses to proceed then the undeliverable product should be dropped from the customers cart and the order summary should reflect the change

  @Row292 @M2Purchase @Checkout @DeliveryTipping @OrderPlace
  Scenario: Tip amount selection TC-292
    Given I select a tip amount in the checkout page
    When I click Place Order
    Then I should see tip amount as part of the order summary and captured as part of the payment capture

    #Removed from the PCX-Helios sheet. Hence, OOS
#  @Row293 @M2Purchase @Checkout @DeliveryTipping @Delivery @OrderPlace
  Scenario:  Tip amount selection TC-293
    Given I select a tip amount in the checkout page
    When I click Place Order
    Then I should see the delivery tip passed on to the delivery provider

  @Row217 @M2Purchase @Checkout @ReturnToCart @Pickup @UAT
  Scenario: Order - Return to cart on WEB (pickup) TC-217
    Given i'm logged in PCX user who is on order checkout page and I have selected pickup
    When I select Back to Cart
    Then I should see Pickup , I should see my Pickup location, I should see my cart, I should my order Summary reflecting my checkout choices: Subtotal, Applicable Fee message, Service Fee, Est. Taxes, Est. Total

     #Removed from the PCX-Helios sheet. Hence, OOS
  Scenario: Changing fulfilment method on checkout Pickup
    Given I have a cart full of items with the fulfillment method pick up
    When I go to the checkout page
    Then I should see my fulfillment options in the Pickup tab
    And validate the order

  @Row87 @M2Purchase @Checkout @ReturnToCart @Pickup
  Scenario:Available fulfilment method on checkout - @Row87
    Given I have a cart full of items with either delivery or pickup method selected
    When I go to checkout page I should see both Pickup and Delivery Tabs
    Then I should see : For both pickup and delivery , From $X: X should be the fee from the cheapest plan ,Ready by X PM: X should be the start time of the fastest plan
##
  @Row160 @M2Purchase @Checkout @ChangingMethod @Pickup
  Scenario: Changing fulfilment method - @Row160
    Given I have a cart full of items with the fulfillment method pick up
    When I go to checkout page and change the fulfilment method to delivery
    Then I should be notified of the changes in my cart if I proceed and be able to make decisions to proceed or go back
##
  @Row265 @M2Purchase @Checkout @RSwitchingMethod @Pickup
  Scenario: Switching Fulfillment Method -@Row265
    Given I am a customer who has browsed and added to cart in pickup
    When I switch to delivery in checkout
    Then I should see an error  that This item is not deliverable message for products that are not available for delivery
#
  @Row266 @M2Purchase @Checkout @DeliveryLimit @Pickup
  Scenario: Delivery Limit - @Row266
    Given I am a customer who has browsed and added a high volume of one product to cart in pickup mode
    When I switch to delivery in checkout
    Then I should see an error message for product volumes that are too large
#
#
  @Row218 @M2Purchase @Checkout @ReturnToCart @Delivery
  Scenario: Order - Return to cart on WEB (delivery) TC-218
    Given i'm logged in PCX user who is on order checkout page and I have selected delivery
    When I select Back to Cart
    Then I should see Delivery , I should see my Delivery postal code I should see my cart, I should my order Summary reflecting my checkout choices: Subtotal,Delivery Fee,Applicable Fee message,Est. Taxes,Driver Tip,Est. Total


  @Row211 @M2Purchase @Checkout @ViewOrderSummary @Delivery @UAT
  Scenario: Order - view order summary (delivery) TC-211
    Given I am logged in PCX user who is on order checkout page and I have selected delivery
    When I review my order summary
    Then I should see Item subtotal (cost of items in my cart)
    And Delivery Fee
    And Service Fee
    And Applicable Fee message
    And Additional Fees
    And Est. Taxes
    And Driver Tip (as selected)
    And Estimated Total

  @Row212 @M2Purchase @Checkout @ViewOrderSummary @Pickup @UAT
  Scenario: Order - view order summary (pickup) TC-212
    Given I am logged in PCX user who is on order checkout page and I have selected pickup
    When I review my pickup order summary
    Then I should see Item subtotal (cost of items in my cart)
    And Service Fee
    And Applicable Fee message
    And Additional Fees
    And Est. Taxes
    And Estimated Total

  @Row176 @M2Purchase @Wholesale @AddItemDetailsInstructions @Delivery
  Scenario: Order checkout - Add Item Details
    Given I’m a user logged into PCX who has at least one delivery address saved to my profile
    When  I'm at checkout on Wholesale
    Then I can enter in Additional instructions for your personal shopper

  @Row178 @M2Purchase @Wholesale @SetBaggingPreferences @Pickup
  Scenario: Order checkout - Add baggage preferences
    Given I’m a logged in PCX user
    When I'm viewing my bagging preferences on wholesale
    Then I can choose to bring my own bags by selecting the checkbox

  @Row179 @M2Purchase @Wholesale @SetBaggingPreferences @Pickup
  Scenario: Order checkout - Add baggage preferences
    Given I’m a logged in PCX user
    When I'm viewing my bagging preferences on wholesale
    Then I can choose to use my own reusable boxes and select the number of boxes I'll be bringing

  @Row180 @M2Purchase @Wholesale @SetBaggingPreferences @Pickup
  Scenario: Order checkout - Add baggage preferences
    Given I’m a logged in PCX user
    When I'm viewing my bagging preferences on wholesale
    Then I can choose to buy reusable boxes and click on the `add` CTA to add it to my order

  @Row181 @M2Purchase @Wholesale @SetBaggingPreferences @Pickup
  Scenario: Order checkout - Add baggage preferences
    Given I’m a logged in PCX user
    When I'm viewing my bagging preferences on wholesale
    Then I can choose to buy reusable boxes and have added three to my order
    And My order total should update once I click `save & continue`

  @Row182 @M2Purchase @Checkout @Wholesale @SetContactInformation @Pickup
  Scenario: Order checkout - contact information
    Given I’m a logged in PCX user
    When I'm viewing my contact details for the first time on wholesale (first order to be placed)
    Then I should see the phone number I entered during profile creation populate here

  @Row183 @M2Purchase @Checkout @Wholesale @SetContactInformation @Pickup
  Scenario: Order checkout - contact information
    Given I’m a logged in PCX user
    When I'm viewing my contact details as an existing customer on wholesale
    Then I should see my phone number pre-filled

  @Row186 @M2Purchase @Checkout @Wholesale @SetContactInformation @Pickup
  Scenario: Order checkout - contact information
    Given I’m a logged in PCX user
    When I'm viewing my contact details on wholesale
    Then I can click `edit` to edit my number number and SMS preferences. Clicking on `edit` phone number will bring me to my accounts page to update phone number on wholesale

  @Row175 @M2Purchase @Checkout @Wholesale @SetDeliveryDetails @Pickup @UAT
  Scenario:Order checkout - Select Pick Up Details TC-175
    Given I’m a logged in PCX user
    When I add items to my cart and proceed to checkout to select a pick up time on wholesale
    Then Upon reserving my timeslot, the selection is saved in Pickup details and applicable fees have been added to my order summary. Booking is created in DCM.