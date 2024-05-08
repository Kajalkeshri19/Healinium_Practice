package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.DataDriven;
import resources.ProjectConfig;
import util.ClearCartViaAPI;
import util.TestContextSetup;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CheckoutStepDefinition {
    TestContextSetup tcs;

    public CheckoutStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I am a user logged into PCX who has not added a delivery address")
    public void I_am_a_user_logged_into_PCX_who_has_not_added_a_delivery_address() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("NoAddressAccount");
        tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
        if(tcs.pom.getHeader().currentFulfillmentMethod().contains("Pickup")) {
            tcs.pom.getHeader().switchTheFulfillment();
            tcs.pom.getHeader().setPostalCodeInDeliveryBox(ProjectConfig.TEST_DELIVERY_CODE);
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().saveDeliveryPostalCodeButton);
        }
        Assert.assertTrue(tcs.pom.getHeader().validateDeliveryFulfilmentIsSelected());
    }

    @When("I navigate to checkout page and try to view my delivery address information")
    public void iNavigateToCheckoutPageAndTryToViewMyDeliveryAddressInformation() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
    }

    @Then("I cannot see my delivery address  as there is no address info on my profile")
    public void iCannotSeeMyDeliveryAddressAsThereIsNoAddressInfoOnMyProfile() {
        Assert.assertTrue(tcs.pom.getCheckout().validateIfThereIsShippingAddressSaved());
    }


    @Given("A logged in PCX user who have not placed a PCX order yetI don't have any items in my cart")
    public void aLoggedInPCXUserWhoHaveNotPlacedAPCXOrderYetIDonTHaveAnyItemsInMyCart() throws IOException {
        tcs.pom.getCheckout().signIn("NoAddressAccount");
//        Assert.assertTrue(tcs.pom.getCart().validateCartIsEmpty());
    }

    @When("I add items to my cart and proceed to checkout")
    public void iAddItemsToMyCartAndProceedToCheckout() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
    }

    @Then("I am autolocated to the closest pick up location")
    public void iAmAutolocatedToTheClosestPickUpLocation() {
        Assert.assertTrue(tcs.pom.getCheckout().validatePickupLocation());
        tcs.pom.getCheckout().clearAllPickupItems();
    }

    @Given("A logged in PCX user who have placed an order before")
    public void aLoggedInPCXUserWhoHavePlacedAnOrderBefore() {
        //tcs.pom.getCheckout().signIn("pcxprodemptycart@yopmail.com", "Loblaw@Testing");
//        Assert.assertTrue(tcs.pom.getCart().validateCartIsEmpty());
    }

    @Then("I am autolocated to the closest pick up location with the next closest pick up location displayed.")
    public void iAmAutolocatedToTheClosestPickUpLocationWithTheNextClosestPickUpLocationDisplayed() {
        Assert.assertTrue(tcs.pom.getCheckout().validatePickupLocation());
    }

    @And("Selecting the other location will not offer any other timeslots at that location.")
    public void selectingTheOtherLocationWillNotOfferAnyOtherTimeslotsAtThatLocation() {
        /*
         ToDo
        */
    }

    @And("The other location will show: Name of pick up location")
    public void theOtherLocationWillShowNameOfPickUpLocation() {
        /*
         ToDo
        */
    }

    @And("address of this location along with how far it is from the pre-determined location closest to you")
    public void addressOfThisLocationAlongWithHowFarItIsFromThePreDeterminedLocationClosestToYou() {
        /*
         ToDo
        */
    }

    @And("timeslot selection shows: pick up, [time range], [date], fee")
    public void timeslotSelectionShowsPickUpTimeRangeDateFee() {
        /*
         ToDo
        */
    }

    @Then("I am autolocated to the closest pick up location and can select a pick up time \\(pre-populated) at this location.")
    public void iAmAutolocatedToTheClosestPickUpLocationAndCanSelectAPickUpTimePrePopulatedAtThisLocation() {
        /*
         ToDo
        */
    }

    @And("I should see the Pickup responses from FAAS with:")
    public void iShouldSeeThePickupResponsesFromFAASWith() {
        /*
         ToDo
        */
    }

    @And("Three time options fastest, next day, select a time \\(opens modal to select future times)")
    public void threeTimeOptionsFastestNextDaySelectATimeOpensModalToSelectFutureTimes() {

    }

    @And("first two options should show: Pickup, time range, date- tomorrow or today, fastest or same day")
    public void firstTwoOptionsShouldShowPickupTimeRangeDateTomorrowOrTodayFastestOrSameDay() {
    }

    @And("under these two options will be the delivery fee itself")
    public void underTheseTwoOptionsWillBeTheDeliveryFeeItself() {
    }

    @Given("I’m a logged in PCX user")
    public void iMALoggedInPCXUser() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("PickupAccount");
        tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
        if(tcs.pom.getHeader().currentFulfillmentMethod().contains("Delivery")) {
            tcs.pom.getHeader().switchTheFulfillment();
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().noChangeLocationLink);
            tcs.pom.getHeader().updateTheStore(ProjectConfig.TEST_DELIVERY_CODE);
            tcs.pom.getHeader().selectTheStore(ProjectConfig.TEST_STORE_NAME);
        }
        Assert.assertTrue(tcs.pom.getHeader().validatePickupFulfilmentIsSelected());
    }

    @When("I add items to my cart and proceed to checkout to select a pick up time")
    public void iAddItemsToMyCartAndProceedToCheckoutToSelectAPickUpTime() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
    }

    @Then("I click on `select a time` to open the modal.")
    public void iClickOnSelectATimeToOpenTheModal() {
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().fulfilllmentTimeslotsButton);
        if(tcs.pom.getCheckout().fulfilllmentTimeslotsButton.isEmpty()){
           tcs.pom.getCheckout().clickOnEditTimeSlotForPickupOrDelivery();
        }
        Assert.assertTrue(tcs.pom.getCheckout().validateSlotsVisible());
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().fulfilllmentTimeslotsButton.get(tcs.pom.getCheckout().fulfilllmentTimeslotsButton.size() - 1));
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().timeslotSelector);
    }

    @And("I can: select a future date")
    public void iCanSelectAFutureDate() {
        tcs.pom.getCheckout().clickOnRandomTimeSlot();
    }

    @And("see available timeslots on all days and non-available ones indicated accordingly")
    public void seeAvailableTimeslotsOnAllDaysAndNonAvailableOnesIndicatedAccordingly() {
        Assert.assertFalse(tcs.pom.getCheckout().validateVisibilityOfAvailableTimeSlot());
        tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().viewAvailabilityTimeSlotButton,tcs.pom.getCheckout().viewAvailabilityTimeSlotButton.size()-1));
    }

    @And("see the pickup fee for each timeslot")
    public void seeThePickupFeeForEachTimeslot() {
        Assert.assertFalse(tcs.pom.getCheckout().validateVisibilityOfPickupFees());
    }

    @And("select any available timeslots")
    public void selectAnyAvailableTimeslots() {
        tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().timeslotSelectorButtons,tcs.pom.getCheckout().timeslotSelectorButtons.size()-1));
    }

    @And("Upon timeslot selection, I should see a confirmation modal with: my postal code, timeslot selected [time range], [date]")
    public void uponTimeslotSelectionIShouldSeeAConfirmationModalWithMyPostalCodeTimeslotSelectedTimeRangeDate() {
        Assert.assertTrue(tcs.pom.getCheckout().validateTimeSlotSelectionBoard());
    }

    @Then("Upon reserving my timeslot, the selection is saved in Pickup details and applicable fees have been added to my order summary. Booking is created in DCM.")
    public void uponReservingMyTimeslotTheSelectionIsSavedInPickupDetailsAndApplicableFeesHaveBeenAddedToMyOrderSummaryBookingIsCreatedInDCM() {
        Assert.assertTrue(tcs.pom.getCheckout().validatePickupLocation());
    }

    @When("I'm viewing my contact details")
    public void iMViewingMyContactDetails() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        Assert.assertTrue(tcs.pom.getCheckout().validateVisibilityOfContactDetail());
    }

    @Then("I can click `edit` to edit my number number at checkout directly")
    public void iCanClickEditToEditMyNumberNumberAtCheckoutDirectly() {
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().editContactDetailsButton);
        Assert.assertTrue(tcs.pom.getCheckout().validateOptionToEditPhoneNumberAndPreferences());
    }

    @Then("I can click edit to edit my number number and SMS preferences.")
    public void iCanClickEditToEditMyNumberNumberAndSMSPreferences() {
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().editContactDetailsButton);
        Assert.assertTrue(tcs.pom.getCheckout().validateOptionToEditPhoneNumberAndPreferences());
    }

    @And("Clicking on `edit` SMS Order Updates will bring me to my preferences page to update SMS settings.")
    public void clickingOnEditSMSOrderUpdatesWillBringMeToMyPreferencesPageToUpdateSMSSettings() {
        Assert.assertTrue(tcs.pom.getCheckout().validateIfEditingSMSPreferencesIsRedirectingToPreferences());
    }

    @Then("I can edit my SMS preferences by checking or unchecking the checkbox at checkout.")
    public void iCanEditMySMSPreferencesByCheckingOrUncheckingTheCheckboxAtCheckout() {
        tcs.pom.getCheckout().clickOnEditContactDetail();
        tcs.pom.getCheckout().clickOnEditSMSUpdate();
        String originalTab = tcs.pom.getCheckout().switchOnNewTab();
        Assert.assertTrue(tcs.pom.getCheckout().validateNavigateOnPreferencesToSMSUpdate());
        tcs.pom.getCheckout().switchOnTab(originalTab);
        tcs.pom.getCheckout().backToCart();
        tcs.pom.getCheckout().clearAllPickupItems();
    }

    @Given("I have placed an order \\(Irrespective of current status - Not shipped, Partially shipped, Delivered, Cancelled)")
    public void iHavePlacedAnOrderIrrespectiveOfCurrentStatusNotShippedPartiallyShippedDeliveredCancelled() {
        //   tcs.pom.getCheckout().signIn("pcxprodplaceorder@yopmail.com", "Loblaw@Testing");
    }

    @When("i view my order history")
    public void iViewMyOrderHistory() {
        tcs.pom.getCheckout().viewMyOrderHistory();
    }

    @Then("I can see the delivery address for each order")
    public void iCanSeeTheDeliveryAddressForEachOrder() {
        /*
         ToDo
         */
    }

    @Given("i am checking out")
    public void iAmCheckingOut() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("DeliveryAccount");
        tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
        if(tcs.pom.getHeader().currentFulfillmentMethod().contains("Pickup")) {
            tcs.pom.getHeader().switchTheFulfillment();
            tcs.pom.getHeader().setPostalCodeInDeliveryBox(ProjectConfig.TEST_DELIVERY_CODE);
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().saveDeliveryPostalCodeButton);
        }
        Assert.assertTrue(tcs.pom.getHeader().validateDeliveryFulfilmentIsSelected());
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().checkoutShippingAddressList);
        if(!tcs.pom.getCheckout().checkoutShippingAddressList.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().checkoutShippingAddressList,tcs.pom.getCheckout().checkoutShippingAddressList.size()-1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().fulfilllmentTimeslotsButton);
        if(!tcs.pom.getCheckout().fulfilllmentTimeslotsButton.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().fulfilllmentTimeslotsButton,tcs.pom.getCheckout().fulfilllmentTimeslotsButton.size()-1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
    }

    @When("i try to select my payment method")
    public void iTryToSelectMyPaymentMethod() {
        tcs.pom.getCheckout().clickOnEditContactDetail();
        tcs.pom.getCheckout().clickOnEditPayment();
    }

    @Then("i can see the list of saved card details \\(visa or mastercard label and last four digits)")
    public void iCanSeeTheListOfSavedCardDetailsVisaOrMastercardLabelAndLastFourDigits() {
        Assert.assertFalse(tcs.pom.getCheckout().validateListOfSaveOrderDetail());
    }

    @And("i can select one among them.")
    public void iCanSelectOneAmongThem() {
        Assert.assertTrue(tcs.pom.getCheckout().canISelectOneOfThemListedCards());
    }

    @And("My primary card should appear on top")
    public void myPrimaryCardShouldAppearOnTop() {
        Assert.assertTrue(tcs.pom.getCheckout().validatePrimaryCardIsOnTop());
        tcs.pom.getCheckout().backToCart();
        tcs.pom.getCheckout().clearAllPickupItems();
    }


    @Given("i have finished providing all the delivery information and delivery method")
    public void iHaveFinishedProvidingAllTheDeliveryInformationAndDeliveryMethod() throws IOException {
        iAmCheckingOut();
    }

    @When("i decide to add a new payment method")
    public void iDecideToAddANewPaymentMethod() {
        tcs.pom.getCheckout().clickOnEditContactDetail();
        tcs.pom.getCheckout().clickOnEditPayment();
        tcs.pom.getCheckout().clickOnAddNewCard();
    }

    @Then("I am shown fields to enter my billing address Street address \\(Mandatory)")
    public void iAmShownFieldsToEnterMyBillingAddressStreetAddressMandatory() {
        Assert.assertTrue(tcs.pom.getCheckout().validateStreetAddressField());
    }

    @And("Apt or Suit or unit \\(optional)")
    public void aptOrSuitOrUnitOptional() {
        Assert.assertTrue(tcs.pom.getCheckout().validateVisibilityOfAPTField());
    }

    @And("City \\(Mandatory)")
    public void cityMandatory() {
        Assert.assertTrue(tcs.pom.getCheckout().validateVisibilityOfCityField());
    }

    @And("Province or State \\(Mandatory)")
    public void provinceOrStateMandatory() {
        Assert.assertTrue(tcs.pom.getCheckout().validateVisibilityOfProvinceField());
    }

    @And("Postal code or Zip code \\(Mandatory)")
    public void postalCodeOrZipCodeMandatory() {
        Assert.assertTrue(tcs.pom.getCheckout().validateVisibilityOfZipCodeField());
    }

    @And("Country \\(Mandatory)")
    public void countryMandatory() {
        Assert.assertTrue(tcs.pom.getCheckout().validateStreetCountryField());
    }

    @And("invalid or empty inputs fields are handled gracefully, show appropriate error messaging and are recoverable upon valid retry")
    public void invalidOrEmptyInputsFieldsAreHandledGracefullyShowAppropriateErrorMessagingAndAreRecoverableUponValidRetry() {
        Assert.assertTrue(tcs.pom.getCheckout().validateErrorMessageForInputField());
        tcs.pom.getCheckout().backToCart();
        tcs.pom.getCheckout().clearAllPickupItems();
    }

    @Given("I have provided billing address during checkout while adding a new card")
    public void iHaveProvidedBillingAddressDuringCheckoutWhileAddingANewCard() throws IOException {
       //  tcs.pom.getCheckout().signIn("pcxprodemptycart@yopmail.com", "Loblaw@Testing");
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
    }

    @When("i move to enter card details")
    public void iMoveToEnterCardDetails() {
        Assert.assertTrue(tcs.pom.getCheckout().addNewBillingAddress());
    }

    @Then("i can view the entered Billing Address")
    public void iCanViewTheEnteredBillingAddress() {
        Assert.assertTrue(tcs.pom.getCheckout().validateVisibilityOfEnteredBillingAddress());
    }

    @When("I add a new card other than Visa or Mastercard \\( Amex, Discover, Diners Club etc)")
    public void iAddANewCardOtherThanVisaOrMastercardAmexDiscoverDinersClubEtc() {
        tcs.pom.getCheckout().addNewBillingAddress();
        tcs.pom.getCheckout().addNewCard("123456789123", "08/29", "400", "Test Account");
    }

    @Then("I should be presented with an appropriate error and should not be allowed to add the card")
    public void iShouldBePresentedWithAnAppropriateErrorAndShouldNotBeAllowedToAddTheCard() {
        Assert.assertTrue(tcs.pom.getCheckout().validateErrorMessageForAddCard());
    }

    @Given("I have saved card & billing address on my account")
    public void iHaveSavedCardBillingAddressOnMyAccount() throws IOException {
        iAmCheckingOut();
        tcs.pom.getCheckout().addNewBillingAddress();
        tcs.pom.getCheckout().addNewCard("4263970000005262", "08/29", "622", "Test Temp");
    }

    @When("I try to delete my payment method")
    public void iTryToDeleteMyPaymentMethod() {
        tcs.pom.getCheckout().clickOnEditPayment();
    }

    @Then("i am able to do so from checkout page by deleting one card at a time")
    public void iAmAbleToDoSoFromCheckoutPageByDeletingOneCardAtATime() {
        int totalCardBeforeRemove = tcs.pom.getCheckout().attemptToDeleteNewAddedCard();
        Assert.assertTrue(tcs.pom.getCheckout().validateRemoveCard(totalCardBeforeRemove));
        tcs.pom.getCheckout().backToCart();
        tcs.pom.getCheckout().clearAllPickupItems();
    }

    @Given("i move to enter new card details")
    public void iMoveToEnterNewCardDetails() throws IOException {
      //   tcs.pom.getCheckout().signIn("pcxprodemptycart@yopmail.com", "Loblaw@Testing");
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        tcs.pom.getCheckout().addNewBillingAddress();

    }

    @When("the card violates fraud rules set in Cybersource Decision Manager \\(velocity, known fraudster etc)")
    public void theCardViolatesFraudRulesSetInCybersourceDecisionManagerVelocityKnownFraudsterEtc() {
        tcs.pom.getCheckout().addNewCard("velocityCard", "08/29", "622", "Test Temp");
    }

    @Then("I should see an error and not be able to add or use the card")
    public void iShouldSeeAnErrorAndNotBeAbleToAddOrUseTheCard() {
        Assert.assertTrue(tcs.pom.getCheckout().validateErrorMessageForAddCard());
    }

    @Given("A logged in PCX user who does not have a delivery address on my profile")
    public void aLoggedInPCXUserWhoDoesNotHaveADeliveryAddressOnMyProfile() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("DeliveryAccount");
        tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
        if(tcs.pom.getHeader().currentFulfillmentMethod().contains("Pickup")) {
            tcs.pom.getHeader().switchTheFulfillment();
            tcs.pom.getHeader().setPostalCodeInDeliveryBox(ProjectConfig.TEST_DELIVERY_CODE);
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().saveDeliveryPostalCodeButton);
        }
        Assert.assertTrue(tcs.pom.getHeader().validateDeliveryFulfilmentIsSelected());

    }

    @Then("I can add one or more delivery addresses to my profile by providing the following information for each address: First name & Last name & Street address")
    public void iCanAddOneOrMoreDeliveryAddressesToMyProfileByProvidingTheFollowingInformationForEachAddressFirstNameLastNameStreetAddress() throws IOException {
        tcs.pom.getCheckout().fillFirstNameInShippingAddressForm();
        tcs.pom.getCheckout().fillLastNameInShippingAddressForm();
        tcs.pom.getCheckout().enterStreetAddrees("DefaultAddress1");
        tcs.pom.getCheckout().enterAddressCity("City");
        tcs.pom.getCheckout().enterPostalCode(ProjectConfig.TEST_DELIVERY_CODE);
        tcs.pom.getCheckout().selectTheProvince(ProjectConfig.POSTAL_CODE_VALUE);
        tcs.pom.getCheckout().enterPhoneNumberInShippingAddressForm();
        tcs.pom.getCheckout().enterTextDescriptionInDeliveryForm();
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveShippingAddressButton);
        Assert.assertTrue(tcs.commonUtility.validateIfElementIsVisible(tcs.pom.getCheckout().shippingAddressInfo));
    }

    @Given("I’m a user logged into PCX who has at least one delivery address saved to my profile")
    public void iMAUserLoggedIntoPCXWhoHasAtLeastOneDeliveryAddressSavedToMyProfile() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("DeliveryAccount");
        tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
        if(tcs.pom.getHeader().currentFulfillmentMethod().contains("Pickup")) {
            tcs.pom.getHeader().switchTheFulfillment();
            tcs.pom.getHeader().setPostalCodeInDeliveryBox(ProjectConfig.TEST_DELIVERY_CODE);
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().saveDeliveryPostalCodeButton);
        }
        Assert.assertTrue(tcs.pom.getHeader().validateDeliveryFulfilmentIsSelected());
    }

    @Then("I can see my saved delivery address with the following fields : First name , Last name , Street address , Apt or Suite or Unit , City , Provinc , Postal code")
    public void iCanSeeMySavedDeliveryAddressWithTheFollowingFieldsFirstNameLastNameStreetAddressAptOrSuiteOrUnitCityProvincPostalCode() {
        Assert.assertTrue(tcs.commonUtility.validateIfElementIsVisible(tcs.pom.getCheckout().shippingAddressInfo));
        Assert.assertFalse(tcs.pom.getCheckout().validateNameVisibleInShippingAddress());
        Assert.assertTrue(tcs.pom.getCheckout().validateAddressVisibleInShippingAddress());
        Assert.assertFalse(tcs.pom.getCheckout().validateDeliveryInstructionAdded());
    }

    @And("I can select the address on which I want to receive my shipment")
    public void iCanSelectTheAddressOnWhichIWantToReceiveMyShipment() {
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().editShippingAddressButton);
        Assert.assertFalse(tcs.pom.getCheckout().validateIfThereIsShippingAddressSaved());
        Assert.assertTrue(tcs.pom.getCheckout().validateIfAddressSelectionCanBeSelected());

    }

    @When("I want to select a delivery time")
    public void iWantToSelectADeliveryTime() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
    }

    @When("I'm at checkout")
    public void iMAtCheckout() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().checkoutShippingAddressList);
        if(!tcs.pom.getCheckout().checkoutShippingAddressList.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().checkoutShippingAddressList,tcs.pom.getCheckout().checkoutShippingAddressList.size()-1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().fulfilllmentTimeslotsButton);
        if(!tcs.pom.getCheckout().fulfilllmentTimeslotsButton.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().fulfilllmentTimeslotsButton,tcs.pom.getCheckout().fulfilllmentTimeslotsButton.size()-1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
    }

    @Then("I can enter in Additional instructions for your personal shopper")
    public void iCanEnterInAdditionalInstructionsForYourPersonalShopper() {
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().instructionTextbox);
        tcs.pom.getCheckout().instructionTextbox.sendKeys(tcs.commonUtility.generateRandomDescription());
        Assert.assertFalse(tcs.pom.getCheckout().instructionTextbox.getText().isEmpty());
    }

    @When("I review my order")
    public void iReviewMyOrder() {
         /*
         ToDo
         */
    }

    @Then("I can see my delivery address \\(selected during order checkout) on order review page")
    public void iCanSeeMyDeliveryAddressSelectedDuringOrderCheckoutOnOrderReviewPage() {
         /*
         ToDo
         */
    }

    @When("I'm viewing my bagging preferences")
    public void iMViewingMyBaggingPreferences() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().fulfilllmentTimeslotsButton);
        if(!tcs.pom.getCheckout().fulfilllmentTimeslotsButton.isEmpty()) {
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().fulfilllmentTimeslotsButton, tcs.pom.getCheckout().fulfilllmentTimeslotsButton.size() - 1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().instructionTextbox);
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);

    }

    @Then("I can choose to bring my own bags by selecting the checkbox")
    public void iCanChooseToBringMyOwnBagsBySelectingTheCheckbox() {
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().bringYourOwnBagCheckbox);
        if(!tcs.pom.getCheckout().bringYourOwnBagCheckbox.isSelected()){
            tcs.pom.getCheckout().bringYourOwnBagCheckbox.click();
        }
        Assert.assertTrue(tcs.pom.getCheckout().bringYourOwnBagCheckbox.isSelected());

    }

    @Then("I can choose to use my own reusable boxes and select the number of boxes I'll be bringing")
    public void iCanChooseToUseMyOwnReusableBoxesAndSelectTheNumberOfBoxesILlBeBringing() {
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().bringYourOwnBagCheckbox);
        if(!tcs.pom.getCheckout().bringYourOwnBagCheckbox.isSelected()){
            tcs.pom.getCheckout().bringYourOwnBagCheckbox.click();
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().swapReusableBagQuantity);
        tcs.pom.getCheckout().swapReusableBagQuantity.sendKeys(Integer.toString(tcs.commonUtility.generateRandomNumber(7)));
        Assert.assertTrue(tcs.commonUtility.convertStringToInteger(tcs.pom.getCheckout().swapReusableBagQuantity.getAttribute("value"))>0);
    }

    @Then("I can choose to buy reusable boxes and click on the `add` CTA to add it to my order")
    public void iCanChooseToBuyReusableBoxesAndClickOnTheAddCTAToAddItToMyOrder() {
        tcs.pom.getCheckout().resetToZeroReusableBag();
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().addReusableBagToCartButton);
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().buyReusableBagQuantity);
        Assert.assertEquals(Integer.parseInt(tcs.pom.getCheckout().buyReusableBagQuantity.getAttribute("value")),1);
        tcs.pom.getCheckout().resetToZeroReusableBag();
    }

    @Then("I can choose to buy reusable boxes and have added three to my order")
    public void iCanChooseToBuyReusableBoxesAndHaveAddedThreeToMyOrder() {
        //Covered in the next step
    }

    @And("My order total should update once I click `save & continue`")
    public void myOrderTotalShouldUpdateOnceIClickSaveContinue() {
        tcs.pom.getCheckout().resetToZeroReusableBag();
        String amountBeforeAddingReusableBag=tcs.pom.getCheckout().subTotalAmount.getText().replace("$","");
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().addReusableBagToCartButton);
        tcs.pom.getCheckout().resetReusableBagQuantity("3");
        tcs.pom.getCheckout().waitForElementTextToChange(tcs.pom.getCheckout().subTotalAmount, amountBeforeAddingReusableBag);
        String amountAfterAddingReusableBag=tcs.pom.getCheckout().subTotalAmount.getText().replace("$","");
        Assert.assertEquals(tcs.commonUtility.convertStringToDouble(amountAfterAddingReusableBag),tcs.commonUtility.convertStringToDouble(amountBeforeAddingReusableBag)+21.00);
    }

    @When("I'm viewing my contact details for the first time \\(first order to be placed)")
    public void iMViewingMyContactDetailsForTheFirstTimeFirstOrderToBePlaced() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
    }

    @Then("I should see the phone number I entered during profile creation populate here")
    public void iShouldSeeThePhoneNumberIEnteredDuringProfileCreationPopulateHere() {
        Assert.assertTrue(tcs.pom.getCheckout().validatePhoneNoDisplayed());

    }

    @When("I'm viewing my contact details as an existing customer")
    public void iMViewingMyContactDetailsAsAnExistingCustomer() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
    }

    @Then("I should see my phone number pre-filled")
    public void iShouldSeeMyPhoneNumberPreFilled() {
        Assert.assertTrue(tcs.pom.getCheckout().validatePhoneNoDisplayed());
    }

    @Then("I can click `edit` to edit my number number and SMS preferences. Clicking on `edit` phone number will bring me to my accounts page to update phone number.")
    public void iCanClickEditToEditMyNumberNumberAndSMSPreferencesClickingOnEditPhoneNumberWillBringMeToMyAccountsPageToUpdatePhoneNumber() {
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().editContactDetailsButton);
        Assert.assertTrue(tcs.pom.getCheckout().validateOptionToEditPhoneNumberAndPreferences());
        Assert.assertTrue(tcs.pom.getCheckout().validateIfEditingPhoneNumberIsRedirectingToAccountsPage());
    }

    @Given("A logged in PCX user who wants to add a new address different from what I have on my profile")
    public void aLoggedInPCXUserWhoWantsToAddANewAddressDifferentFromWhatIHaveOnMyProfile() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getNavigation().logInToAccount("CartAccount");
        tcs.pom.getCheckout().addNewAddress();

    }

    @Then("I can add one or more delivery addresses to my profile by providing the following information for each address:First name , Last name , Street address , Apt , City , Province , Postal code , Phone number , Delivery instuctions , Make this my primary address.")
    public void iCanAddOneOrMoreDeliveryAddressesToMyProfileByProvidingTheFollowingInformationForEachAddressFirstNameLastNameStreetAddressAptCityProvincePostalCodePhoneNumberDeliveryInstuctionsMakeThisMyPrimaryAddress() throws IOException {
        Assert.assertTrue(tcs.pom.getCheckout().enterValidAddress());
    }

    @When("I select a card other than my primary card and select {string}")
    public void iSelectACardOtherThanMyPrimaryCardAndSelect(String arg0) {
        Assert.assertTrue(tcs.pom.getAccount().validatePrimaryCardDetails());
    }

    @Then("After I pay with the card, it should become my primary card and should appear as Primary on My Account -> Payment and Checkout pages.")
    public void afterIPayWithTheCardItShouldBecomeMyPrimaryCardAndShouldAppearAsPrimaryOnMyAccountPaymentAndCheckoutPages() {
        Assert.assertTrue(tcs.pom.getAccount().validatePrimaryCardDetails());
    }

    @Given("that I am a PCX customer who has selected pickup")
    public void thatIAmAPCXCustomerWhoHasSelectedPickup() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("PickupPlaceOrderAccount");
        tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
        if(tcs.pom.getHeader().currentFulfillmentMethod().contains("Delivery")) {
            tcs.pom.getHeader().switchTheFulfillment();
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().noChangeLocationLink);
            tcs.pom.getHeader().updateTheStore(ProjectConfig.TEST_DELIVERY_CODE);
            tcs.pom.getHeader().selectTheStore(ProjectConfig.TEST_STORE_NAME);
        }
        Assert.assertTrue(tcs.pom.getHeader().validatePickupFulfilmentIsSelected());
    }

    @When("I go to checkout and select a pickup time and fill in all checkout steps \\(contact details, bagging preferences, item details)")
    public void iGoToCheckoutAndSelectAPickupTimeAndFillInAllCheckoutStepsContactDetailsBaggingPreferencesItemDetails() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().fulfilllmentTimeslotsButton);
        if(!tcs.pom.getCheckout().fulfilllmentTimeslotsButton.isEmpty()) {
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().fulfilllmentTimeslotsButton, tcs.pom.getCheckout().fulfilllmentTimeslotsButton.size() - 1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().instructionTextbox);
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);

        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().bringYourOwnBagCheckbox);
        if(!tcs.pom.getCheckout().bringYourOwnBagCheckbox.isSelected()){
            tcs.pom.getCheckout().bringYourOwnBagCheckbox.click();
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
    }

    @Then("I should be able to successfully place a pickup order")
    public void iShouldBeAbleToSuccessfullyPlaceAPickupOrder() {
        Assert.assertTrue(tcs.pom.getCheckout().placeAnOrder());
    }

    @Given("that I am a returning PCX customer who has previously selected delivery")
    public void thatIAmAReturningPCXCustomerWhoHasPreviouslySelectedDelivery() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("DeliveryPlaceOrderAccount");
        tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
        if(tcs.pom.getHeader().currentFulfillmentMethod().contains("Pickup")) {
            tcs.pom.getHeader().switchTheFulfillment();
            tcs.pom.getHeader().setPostalCodeInDeliveryBox(ProjectConfig.TEST_DELIVERY_CODE);
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().saveDeliveryPostalCodeButton);
        }
        Assert.assertTrue(tcs.pom.getHeader().validateDeliveryFulfilmentIsSelected());
    }

    @Then("I should be able to successfully place a delivery order")
    public void iShouldBeAbleToSuccessfullyPlaceADeliveryOrder() {
        Assert.assertTrue(tcs.pom.getCheckout().placeAnOrder());
    }

    @When("I go to checkout and select a delivery time and fill in all checkout steps \\(contact details, bagging preferences, item details)")
    public void iGoToCheckoutAndSelectADeliveryTimeAndFillInAllCheckoutStepsContactDetailsBaggingPreferencesItemDetails() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().checkoutShippingAddressList);
        if(!tcs.pom.getCheckout().checkoutShippingAddressList.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().checkoutShippingAddressList,tcs.pom.getCheckout().checkoutShippingAddressList.size()-1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().fulfilllmentTimeslotsButton);
        if(!tcs.pom.getCheckout().fulfilllmentTimeslotsButton.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().fulfilllmentTimeslotsButton,tcs.pom.getCheckout().fulfilllmentTimeslotsButton.size()-1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().instructionTextbox);
        tcs.pom.getCheckout().instructionTextbox.sendKeys(tcs.commonUtility.generateRandomDescription());
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        tcs.pom.getCheckout().selectATip();
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
    }

    @Given("I have a cart full of items and I have previously used the fulfillment method pick up")
    public void iHaveACartFullOfItemsAndIHavePreviouslyUsedTheFulfillmentMethodPickUp() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
      //  tcs.pom.getNavigation().logInToAccount("test2301one@yopmail.com", "Loblaw@Testing");

        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        Assert.assertTrue(tcs.pom.getHeader().iSeeDefaultLocation());
    }

    @When("I go to the checkout page")
    public void iGoToCheckoutPage() {
        tcs.pom.getCheckout().goToCheckout();
    }

    @Then("then I should see my fulfillment options in the Pickup tab in the following order - Fastest \\(Alternative store) , Cheaptest \\(Only until checkout) , Same day \\(Only until checkout) , Select a custom time from timeslot selector \\(Only until checkout)")
    public void thenIShouldSeeMyFulfillmentOptionsInThePickupTabInTheFollowingOrderFastestAlternativeStoreCheaptestOnlyUntilCheckoutSameDayOnlyUntilCheckoutSelectACustomTimeFromTimeslotSelectorOnlyUntilCheckout() {
        Assert.assertTrue(tcs.pom.getCheckout().validateFulfillmentOptions());
        Assert.assertTrue(tcs.pom.getCheckout().selectATimeSlot());
    }

    @Given("I have a cart full of items and I have previously used the fulfillment method delivery")
    public void iHaveACartFullOfItemsAndIHavePreviouslyUsedTheFulfillmentMethodDelivery() {
        tcs.pom.getCart().validateSelectedFulfilmentIsDelivery("M4M 2H9");
        Assert.assertTrue(tcs.pom.getCart().validateDeliveryOnCartPage());
    }

    @Then("then I should see my fulfillment options in the delivery tab in the following order - Fastest \\(Alternative store) , Cheaptest \\(Only until checkout) , Same day \\(Only until checkout) , Select a custom time from timeslot selector \\(Only until checkout)")
    public void thenIShouldSeeMyFulfillmentOptionsInTheDeliveryTabInTheFollowingOrderFastestAlternativeStoreCheaptestOnlyUntilCheckoutSameDayOnlyUntilCheckoutSelectACustomTimeFromTimeslotSelectorOnlyUntilCheckout() {
        Assert.assertTrue(tcs.pom.getCheckout().validateFulfillmentDeliveryOptions());
    }

    @Given("i'm logged in PCX user who is on order checkout page")
    public void iMLoggedInPCXUserWhoIsOnOrderCheckoutPage() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("DeliveryPlaceOrderAccount");
        tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
        if(tcs.pom.getHeader().currentFulfillmentMethod().contains("Pickup")) {
            tcs.pom.getHeader().switchTheFulfillment();
            tcs.pom.getHeader().setPostalCodeInDeliveryBox(ProjectConfig.TEST_DELIVERY_CODE);
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().saveDeliveryPostalCodeButton);
        }
        Assert.assertTrue(tcs.pom.getHeader().validateDeliveryFulfilmentIsSelected());
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().checkoutShippingAddressList);
        if(!tcs.pom.getCheckout().checkoutShippingAddressList.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().checkoutShippingAddressList,tcs.pom.getCheckout().checkoutShippingAddressList.size()-1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().fulfilllmentTimeslotsButton);
        if(!tcs.pom.getCheckout().fulfilllmentTimeslotsButton.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().fulfilllmentTimeslotsButton,tcs.pom.getCheckout().fulfilllmentTimeslotsButton.size()-1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().instructionTextbox);
        tcs.pom.getCheckout().instructionTextbox.sendKeys(tcs.commonUtility.generateRandomDescription());
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        tcs.pom.getCheckout().selectATip();
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
    }

    @When("I select Place Order")
    public void iSelectPlaceOrder() {
         Assert.assertTrue(tcs.pom.getCheckout().placeAnOrder());
    }

    @Then("I should see an order confirmation page")
    public void iShouldSeeAnOrderConfirmationPage() {
        Assert.assertTrue(tcs.pom.getCheckout().orderConfirmationPage());
    }

    @Given("I have a cart full of items with the fulfillment method pick up with non-deliverable item")
    public void iHaveACartFullOfItemsWithTheFulfillmentMethodPickUpWithNonDeliverableItem() {
        tcs.pom.getNavigation().openLogInPage();
        //tcs.pom.getNavigation().logInToAccount("pcxuser1feb9@yopmail.com", "pcxuser1feb9@yopmail.com");
        tcs.pom.getCart().clearCart();
        tcs.pom.getCart().validatePickUpFromHeader();
        tcs.pom.getCart().searchProduct("Montreal Smoked Meat");
        tcs.pom.getCart().findProductByName("Montreal Smoked Meat");
        tcs.pom.getCart().addItemToCart();
        tcs.pom.getCart().openMiniCartFlyer();
        tcs.pom.getCart().visitCart();
        tcs.pom.getCart().validatePickupOnCartPage();
    }

    @When("I go to checkout page and place order by selecting delivery")
    public void proceedToCheckoutAndChangeToDelivery() throws InterruptedException {
        tcs.pom.getCheckout().checkOutAndCheckForPopUp();
    }

    @Then("The undeliverable product should be dropped from the customers cart")
    public void popupCheck(){
        Assert.assertTrue(tcs.pom.getCheckout().checkForNonDeliveryPopup());
    }

    @And("The order summary should reflect the change")
    public void validateOrderSummary(){
        tcs.pom.getCart().validateAndCloseErrorPopup();
    }

    @Then("I should see my fulfillment options in the Pickup tab")
    public void Checkfullfilment() {
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().pickupButton);
    }

    @And("validate the order")
    public void validateTheOrder() {
        List<String> expectedValues = Arrays.asList(new String[]{"Next day","Low Fee","Fastest"});
        List<String> planTypeText = tcs.pom.getCart().validatePickupOnCartPage();
        for(int i=0; i < planTypeText.size(); i++){
            Assert.assertTrue(expectedValues.contains(planTypeText));
        }
    }

    @Given("I select a tip amount in the checkout page")
    public void iSelectATipAmountInTheCheckoutPage() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("DeliveryPlaceOrderAccount");
        tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
        if(tcs.pom.getHeader().currentFulfillmentMethod().contains("Pickup")) {
            tcs.pom.getHeader().switchTheFulfillment();
            tcs.pom.getHeader().setPostalCodeInDeliveryBox(ProjectConfig.TEST_DELIVERY_CODE);
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().saveDeliveryPostalCodeButton);
        }
        Assert.assertTrue(tcs.pom.getHeader().validateDeliveryFulfilmentIsSelected());
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().checkoutShippingAddressList);
        if(!tcs.pom.getCheckout().checkoutShippingAddressList.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().checkoutShippingAddressList,tcs.pom.getCheckout().checkoutShippingAddressList.size()-1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().fulfilllmentTimeslotsButton);
        if(!tcs.pom.getCheckout().fulfilllmentTimeslotsButton.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().fulfilllmentTimeslotsButton,tcs.pom.getCheckout().fulfilllmentTimeslotsButton.size()-1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().instructionTextbox);
        tcs.pom.getCheckout().instructionTextbox.sendKeys(tcs.commonUtility.generateRandomDescription());
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        tcs.pom.getCheckout().selectATip();
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().paymentCardList);
        if(!tcs.pom.getCheckout().paymentCardList.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().paymentCardList,tcs.pom.getCheckout().paymentCardList.size()));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().continueButton);
        }
    }

    @When("I click Place Order")
    public void iClickPlaceOrder() {
        Assert.assertTrue(tcs.pom.getCheckout().placeAnOrder());
    }

    @Then("I should see tip amount as part of the order summary and captured as part of the payment capture")
    public void iShouldSeeTipAmountAsPartOfTheOrderSummaryAndCapturedAsPartOfThePaymentCapture() {
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().viewOrder);
        Assert.assertTrue(tcs.pom.getCheckout().validateTipAmountInOrderSummary());
        Assert.assertTrue(tcs.pom.getCheckout().validateTipAmountInPaymentSummary());
    }

    @Then("I should see the delivery tip passed on to the delivery provider")
    public void iShouldSeeTheDeliveryTipPassedOnToTheDeliveryProvider() {
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().viewOrder);
        Assert.assertTrue(tcs.pom.getCheckout().validateTipAmountPassedToDriver());
    }

    @Given("i'm logged in PCX user who is on order checkout page and I have selected pickup")
    public void iMLoggedInPCXUserWhoIsOnOrderCheckoutPageAndIHaveSelectedPickup() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("PickupAccount");
        tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
        if(tcs.pom.getHeader().currentFulfillmentMethod().contains("Delivery")) {
            tcs.pom.getHeader().switchTheFulfillment();
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().noChangeLocationLink);
            tcs.pom.getHeader().updateTheStore(ProjectConfig.TEST_DELIVERY_CODE);
            tcs.pom.getHeader().selectTheStore(ProjectConfig.TEST_STORE_NAME);
        }
        Assert.assertTrue(tcs.pom.getHeader().validatePickupFulfilmentIsSelected());
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
    }

    @When("I select Back to Cart")
    public void iSelectBackToCart() {
        tcs.pom.getCheckout().backToCartPage();
    }

    @Then("I should see Pickup , I should see my Pickup location, I should see my cart, I should my order Summary reflecting my checkout choices: Subtotal, Applicable Fee message, Service Fee, Est. Taxes, Est. Total")
    public void iShouldSeePickupIShouldSeeMyPickupLocationIShouldSeeMyCartIShouldMyOrderSummaryReflectingMyCheckoutChoicesSubtotalApplicableFeeMessageServiceFeeEstTaxesEstTotal() {
        Assert.assertTrue(tcs.pom.getCheckout().validateCartPageInfo());

    }

    @Then("I should see the delivery responses from FAAS with:3 time options lowest fee, same day, select a time opens modal to select future times,first 2 options should show: time range, date- tomorrow today, fee same day, under these 2 options will be the delivery fee itself")
    public void iShouldSeeTheDeliveryResponsesFromFAASWithTimeOptionsLowestFeeSameDaySelectATimeOpensModalToSelectFutureTimesFirstOptionsShouldShowTimeRangeDateTomorrowTodayFeeSameDayUnderTheseOptionsWillBeTheDeliveryFeeItself() {
        Assert.assertTrue(tcs.pom.getCheckout().validateSlotsVisible());
        Assert.assertTrue(tcs.pom.getCheckout().validateIfPriceIsVisibleOnSlots());
        Assert.assertTrue(tcs.pom.getCheckout().validateIfFulfillmentSlotsHavePlanType());
    }
    @Given("I have a cart full of items with either delivery or pickup method selected")
    public void iHaveACartFullOfItemsWithEitherDeliveryOrPickupMethodSelected() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("CartAccount");
        tcs.pom.getHomePage().validateHomePage();
        tcs.pom.getCart().clearCart();
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("PDP", "Product_ID").get(1));
        tcs.pom.getCart().addItemToCart();
        tcs.pom.getCart().openMiniCartFlyer();
        tcs.pom.getCart().visitCart();
        tcs.pom.getCart().validatePickUpFromHeader();
    }

    @When("I go to checkout page I should see both Pickup and Delivery Tabs")
    public void iGoToCheckoutPageIShouldSeeBothPickupAndDeliveryTabs() {
        tcs.pom.getCheckout().goToCheckout();
    }

    @Then("I should see : For both pickup and delivery , From $X: X should be the fee from the cheapest plan ,Ready by X PM: X should be the start time of the fastest plan")
    public void iShouldSeeForBothPickupAndDeliveryFrom$XXShouldBeTheFeeFromTheCheapestPlanReadyByXPMXShouldBeTheStartTimeOfTheFastestPlan() {
        tcs.pom.getCheckout().validateFulfillmentOptions();
        tcs.pom.getCheckout().validateFulfillmentDeliveryOptions();
    }

    @Given("i'm logged in PCX user who is on order checkout page and I have selected delivery")
    public void iMLoggedInPCXUserWhoIsOnOrderCheckoutPageAndIHaveSelectedDelivery() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("CartAccount");
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("PDP", "Product_ID").get(1));
        tcs.pom.getCart().addItemToCart();
        tcs.pom.getCart().openMiniCartFlyer();
        tcs.pom.getCart().visitCart();
        Assert.assertTrue(tcs.pom.getHeader().iSeeDefaultLocation());
        tcs.pom.getCheckout().goToCheckout();
    }

    @Then("I should see Delivery , I should see my Delivery postal code I should see my cart, I should my order Summary reflecting my checkout choices: Subtotal,Delivery Fee,Applicable Fee message,Est. Taxes,Driver Tip,Est. Total")
    public void iShouldSeeDeliveryIShouldSeeMyDeliveryPostalCodeIShouldSeeMyCartIShouldMyOrderSummaryReflectingMyCheckoutChoicesSubtotalDeliveryFeeApplicableFeeMessageEstTaxesDriverTipEstTotal() {
        Assert.assertTrue(tcs.pom.getCheckout().validateCartPageInfoForDelivery());
    }

    @Given("I am a customer who has browsed and added to cart in pickup")
    public void iAmACustomerWhoHasBrowsedAndAddedToCartInPickup() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("CartAccount");
        tcs.pom.getHomePage().validateHomePage();
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("PDP", "Undeliverable").get(1));
        tcs.pom.getCart().addItemToCart();
        tcs.pom.getCart().openMiniCartFlyer();
        tcs.pom.getCart().visitCart();
    }

    @When("I switch to delivery in checkout")
    public void iSwitchToDeliveryInCheckout() {
        tcs.pom.getCart().switchFulfillmentToDelivery(ProjectConfig.TEST_DELIVERY_CODE);
    }

    @Given("I am a customer who has browsed and added a high volume of one product to cart in pickup mode")
    public void iAmACustomerWhoHasBrowsedAndAddedAHighVolumeOfOneProductToCartInPickupMode() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("PickUpAccount");
        tcs.pom.getHomePage().validateHomePage();
        tcs.pom.getCart().clearCart();
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("PDP", "High_volume").get(1));
        tcs.pom.getCheckout().addUnitsInCart();
    }

    @Then("I should see an error  that This item is not deliverable message for products that are not available for delivery")
    public void iShouldSeeAnErrorThatThisItemIsNotDeliverableMessageForProductsThatAreNotAvailableForDelivery() {
        Assert.assertTrue(tcs.pom.getCheckout().validateErrorMsgForNondelivery());
    }


    @Then("I should see an error message for product volumes that are too large")
    public void iShouldSeeAnErrorMessageForProductVolumesThatAreTooLarge() {
        Assert.assertTrue(tcs.pom.getCheckout().validateErrorMsgForDeliveryLimit());

    }

    @When("I want to select a delivery time in the future two+ days out")
    public void iWantToSelectADeliveryTimeInTheFutureTwoDaysOut() throws IOException {
        iWantToSelectADeliveryTime();
    }

    @And("see available timeslots on all days and ones not available \\(since they are full) shown accordingly")
    public void seeAvailableTimeslotsOnAllDaysAndOnesNotAvailableSinceTheyAreFullShownAccordingly() {
        Assert.assertFalse(tcs.pom.getCheckout().validateVisibilityOfAvailableTimeSlot());
        tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().viewAvailabilityTimeSlotButton,tcs.pom.getCheckout().viewAvailabilityTimeSlotButton.size()-1));
    }

    @And("see the delivery fee for each timeslot")
    public void seeTheDeliveryFeeForEachTimeslot() {
        Assert.assertFalse(tcs.pom.getCheckout().validateVisibilityOfDeliveryFees());
    }

    @And("What you need to know` section")
    public void whatYouNeedToKnowSection() {
        Assert.assertTrue(tcs.commonUtility.validateIfElementIsVisible(tcs.pom.getCheckout().timeslotConfirmationDetail));
    }

    @And("`Reserve` CTA, or `cancel, go back` CTA")
    public void reserveCTAOrCancelGoBackCTA() {
        Assert.assertTrue(tcs.commonUtility.validateIfElementIsVisible(tcs.pom.getCheckout().timeslotReserveButton));
        Assert.assertTrue(tcs.commonUtility.validateIfElementIsVisible(tcs.pom.getCheckout().timeslotCancelButton));
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().timeslotReserveButton);
    }

    @When("I add items to my cart and proceed to checkout to select a delivery time")
    public void iAddItemsToMyCartAndProceedToCheckoutToSelectADeliveryTime() throws IOException {
        iWantToSelectADeliveryTime();
    }

    @Then("Upon reserving my timeslot, the selection is saved in Delivery details and applicable fees have been added to my order summary.")
    public void uponReservingMyTimeslotTheSelectionIsSavedInDeliveryDetailsAndApplicableFeesHaveBeenAddedToMyOrderSummary() {
        if(!tcs.pom.getCheckout().isTimeSlotSelected()) {
            Assert.assertTrue(tcs.pom.getCheckout().validateSlotsVisible());
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().fulfilllmentTimeslotsButton.get(tcs.pom.getCheckout().fulfilllmentTimeslotsButton.size() - 1));
            tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().timeslotSelector);
            tcs.pom.getCheckout().clickOnRandomTimeSlot();
            Assert.assertFalse(tcs.pom.getCheckout().validateVisibilityOfAvailableTimeSlot());
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().viewAvailabilityTimeSlotButton, tcs.pom.getCheckout().viewAvailabilityTimeSlotButton.size() - 1));
            tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().timeslotSelectorButtons);
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().timeslotSelectorButtons, tcs.pom.getCheckout().timeslotSelectorButtons.size() - 1));
            Assert.assertTrue(tcs.commonUtility.validateIfElementIsVisible(tcs.pom.getCheckout().timeslotReserveButton));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().timeslotReserveButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().selectedTimeSlot);
        Assert.assertTrue(tcs.pom.getCheckout().validateDeliveryFeeOnSummary());
    }

    @Given("I’m a logged in PCX user Delivery")
    public void iMALoggedInPCXUserDelivery() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("DeliveryAccount");
        tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
        if(tcs.pom.getHeader().currentFulfillmentMethod().contains("Pickup")) {
            tcs.pom.getHeader().switchTheFulfillment();
            tcs.pom.getHeader().setPostalCodeInDeliveryBox(ProjectConfig.TEST_DELIVERY_CODE);
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().saveDeliveryPostalCodeButton);
        }
        Assert.assertTrue(tcs.pom.getHeader().validateDeliveryFulfilmentIsSelected());
    }

    @Given("I am logged in PCX user who is on order checkout page and I have selected delivery")
    public void IAMLoggedInPCXUserWhoIsOnOrderCheckoutPageAndIHaveSelectedDelivery() throws IOException {
        iMALoggedInPCXUserDelivery();
    }

    @When("I review my order summary")
    public void iReviewMyOrderSummary() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().fulfilllmentTimeslotsButton);
        if(!tcs.pom.getCheckout().fulfilllmentTimeslotsButton.isEmpty()) {
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().fulfilllmentTimeslotsButton, tcs.pom.getCheckout().fulfilllmentTimeslotsButton.size() - 1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().instructionTextbox);
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        tcs.pom.getCheckout().selectATip();
        tcs.pom.getCheckout().saveAndContinue();
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCheckout().orderSummary));
    }

    @Then("I should see Item subtotal \\(cost of items in my cart)")
    public void iShouldSeeItemSubtotalCostOfItemsInMyCart() {
        Assert.assertTrue(tcs.pom.getCheckout().validateSubtotal());
    }

    @And("Delivery Fee")
    public void deliveryFee() {
        Assert.assertTrue(tcs.pom.getCheckout().validateDeliveryFeeOnSummary());
    }

    @And("Service Fee")
    public void serviceFee() {
        Assert.assertTrue(tcs.pom.getCheckout().validateServiceFeeOnSummary());
    }

    @And("Applicable Fee message")
    public void applicableFeeMessage() {
        //No such fee message on order summary.
    }

    @And("Additional Fees")
    public void additionalFees() {
        Assert.assertTrue(tcs.pom.getCheckout().validateAdditionalFeeOnSummary());
    }

    @And("Est. Taxes")
    public void estTaxes() {
        Assert.assertTrue(tcs.pom.getCheckout().validateEstTaxesOnSummary());
    }

    @And("Driver Tip \\(as selected)")
    public void driverTipAsSelected() {
        Assert.assertTrue(tcs.pom.getCheckout().validateDriverTipOnSummary());
    }

    @And("Estimated Total")
    public void estimatedTotal() {
        Assert.assertTrue(tcs.pom.getCheckout().validateEstTotalOnSummary());
    }

    @Given("I am logged in PCX user who is on order checkout page and I have selected pickup")
    public void iAmLoggedInPCXUserWhoIsOnOrderCheckoutPageAndIHaveSelectedPickup() throws IOException {
        tcs.pom.getCheckout().clickSignInOnHomePage();
        tcs.pom.getCheckout().signIn("PickupAccount");
        tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
        if(tcs.pom.getHeader().currentFulfillmentMethod().contains("Delivery")) {
            tcs.pom.getHeader().switchTheFulfillment();
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().fullfillmentButton);
            tcs.commonUtility.clickOnElement(tcs.pom.getHeader().noChangeLocationLink);
            tcs.pom.getHeader().updateTheStore(ProjectConfig.TEST_DELIVERY_CODE);
            tcs.pom.getHeader().selectTheStore(ProjectConfig.TEST_STORE_NAME);
        }
        Assert.assertTrue(tcs.pom.getHeader().validatePickupFulfilmentIsSelected());
    }

    @When("I review my pickup order summary")
    public void iReviewMyPickupOrderSummary() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().fulfilllmentTimeslotsButton);
        if(!tcs.pom.getCheckout().fulfilllmentTimeslotsButton.isEmpty()) {
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().fulfilllmentTimeslotsButton, tcs.pom.getCheckout().fulfilllmentTimeslotsButton.size() - 1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
    }
    @After("@OrderPlace")
    public void clearTheCart() throws IOException {
        ClearCartViaAPI deleteCartViaAPI=new ClearCartViaAPI();
        for(int iterator=1;iterator<DataDriven.getTestData("TestData","PcID").size();iterator++) {
            deleteCartViaAPI.clearTheCart("loblaw", DataDriven.getTestData("TestData","PcID").get(iterator));
        }
    }

    @When("I'm at checkout on Wholesale")
    public void iMAtCheckoutOnWholesale() throws IOException {
        if(tcs.pom.getCart().numberOfItemsInCart()==0) {
            tcs.pom.getSearchPage().searchTheProduct(tcs.pom.getCheckout().producHavingLargeInventoryCount());
            Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
            tcs.commonUtility.clickOnElement(tcs.pom.getSRP().addToCartSRPButton);
        }
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        tcs.pom.getCheckout().selectTimeslotButton();
        tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().timeslotSelectorButtons,tcs.pom.getCheckout().timeslotSelectorButtons.size()-1));
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().timeslotReserveButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
    }

    @When("I'm viewing my bagging preferences on wholesale")
    public void iMViewingMyBaggingPreferencesOnWholesale() throws IOException {
        tcs.pom.getHomePage().validateHomePage();
        tcs.pom.getCart().spendUptoWholesaleCart(ProjectConfig.WSC_MINIMUM_CART_VALUE);
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        if (!tcs.pom.getCheckout().fulfilllmentTimeslotsButton.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().timeslotSelectorButtons, tcs.pom.getCheckout().timeslotSelectorButtons.size() - 1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().timeslotReserveButton);
            tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.pom.getCheckout().selectTimeslotButton();
        tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().timeslotSelectorButtons, tcs.pom.getCheckout().timeslotSelectorButtons.size() - 1));
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().timeslotReserveButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().instructionTextbox);
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);

    }

    @When("I'm viewing my contact details for the first time on wholesale \\(first order to be placed)")
    public void iMViewingMyContactDetailsForTheFirstTimeOnWholesaleFirstOrderToBePlaced() {
        tcs.pom.getHomePage().validateHomePage();
        tcs.pom.getCart().spendUptoWholesaleCart(ProjectConfig.WSC_MINIMUM_CART_VALUE);
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().headerCheckoutButton);
        if (!tcs.pom.getCheckout().fulfilllmentTimeslotsButton.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().timeslotSelectorButtons, tcs.pom.getCheckout().timeslotSelectorButtons.size() - 1));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().timeslotReserveButton);
            tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.pom.getCheckout().selectTimeslotButton();
        tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().timeslotSelectorButtons, tcs.pom.getCheckout().timeslotSelectorButtons.size() - 1));
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().timeslotReserveButton);
        tcs.pom.getCheckout().navigateFromCartToCheckoutPage();
    }

    @When("I'm viewing my contact details as an existing customer on wholesale")
    public void iMViewingMyContactDetailsAsAnExistingCustomerOnWholesale() {
        iMViewingMyContactDetailsAsAnExistingCustomerOnWholesale();
    }

    @When("I'm viewing my contact details on wholesale")
    public void iMViewingMyContactDetailsOnWholesale() {
        iMViewingMyContactDetailsAsAnExistingCustomerOnWholesale();
    }

    @Then("I can click `edit` to edit my number number and SMS preferences. Clicking on `edit` phone number will bring me to my accounts page to update phone number on wholesale")
    public void iCanClickEditToEditMyNumberNumberAndSMSPreferencesClickingOnEditPhoneNumberWillBringMeToMyAccountsPageToUpdatePhoneNumberOnWholesale() {
        Assert.assertTrue(tcs.pom.getCheckout().validateOptionToEditPhoneNumberAndPreferences());
        Assert.assertTrue(tcs.pom.getCheckout().validateIfEditingSMSPreferencesIsRedirectingToPreferences());

    }

    @When("I add items to my cart and proceed to checkout to select a pick up time on wholesale")
    public void iAddItemsToMyCartAndProceedToCheckoutToSelectAPickUpTimeOnWholesale() throws IOException {
        iMAtCheckoutOnWholesale();
    }
}