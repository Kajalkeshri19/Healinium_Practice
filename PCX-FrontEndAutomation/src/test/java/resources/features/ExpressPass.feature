Feature: ExpressPass

@ExpressPass
 Scenario: New Customer Flow
 Given Customer is on the landing page the PCid
 And Sign in check should happen
 When the customer click on the sign up
 Then the user is being asked to sign in to their PCid

@ExpressPass
 Scenario: PCOI Check
 Given the PCid sign up is completed
 When the customer has a PCOI subscription
 Then the user can see the plan selection page and the user can view the last four digits of their credit card
 And they should see the Plan Selection page with the credit card information pre-populated

@ExpressPass
 Scenario: Monthly Plan Selection
 Given the user sign in with PCid
 When the user on the pass purchase journey is viewing the one month free trial CallOut for the Monthly Plan
 Then the user is able to view all the relevant screens Plan Selection, Billing, Shipping, CC entry, Plan Confirmation, Success Page

@ExpressPass
 Scenario: Annual Plan Selection
 Given the user sign in with PCid
 When the user on the pass purchase journey is viewing the one month free trial CallOut for the Annual Plan
 Then the user is able to view all the relevant screens Plan Selection, Billing, Shipping, CC entry, Plan Confirmation, Success Page

@ExpressPass
 Scenario: Existing Customer
 Given the user login with PCid
 When the user is on PC Express Section in Profile
 Then Customer should be presented with all pages except PCOI screens on the subscription purchase flow

