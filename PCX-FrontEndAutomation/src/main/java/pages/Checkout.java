package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.CommonUtility;
import resources.DataDriven;
import resources.ProjectConfig;
import util.Log;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Checkout {
    public final String clickScript = "arguments[0]);";
    WebDriver driver;
    WebDriverWait wait;

    // Declaration of an object of CommonUtility class where methods with common operations are defined
    CommonUtility commonUtility;
    //HomePage Header-position-right sign-in-button
    @FindBy(css = "a.sign-in")
    WebElement signInButtonHomePage;

    @FindBy(css = "button.almost-done-page__fulfillment-toggle--button")
    public WebElement switchFulfilmentOnCheckoutPage;
    @FindBy(css = "input[aria-label='Email']")
    WebElement userEmail;
    @FindBy(css = "input[aria-label='Password']")
    WebElement userPass;
    @FindBy(xpath = "//button[text()='Sign In']")
    WebElement signInButton;
    @FindBy(css = "div[class='pickup-details__location pickup-details__location--faas-checkout']")
    WebElement pickupLocation;
    @FindBy(css = "button[class='clear-cart-btn']")
    WebElement clearItemButton;
    @FindBy(css = "button[class='confirm']")
    WebElement confirmButton;
    @FindBy(css = "a[class='empty-cart__action__link empty-cart__action__link--home-page']")
    WebElement naveBackToHomePage;
    @FindBy(xpath = "//button[text()='Proceed to Checkout']")
    public WebElement proceedToCheckout;
    @FindBy(css = "div[class='contact-details']")
    WebElement contactDetails;
    @FindBy(css = "button[aria-label='Edit Contact details']")
    WebElement editContactDetails;
    @FindBy(xpath = "//div[@class='pickup-content-contact__smsupdate__edit']/a[text()='Edit']")
    WebElement editSMSUpdate;
    @FindBy(xpath = "//div[@class='pickup-content-contact__number']/a[text()='Edit']")
    WebElement editContactNumber;
    @FindBy(css = "a[data-cruller='back-to-cart-link']")
    WebElement backToCart;
    @FindBy(css = "div[class='account-preferences-page']")
    WebElement preferencesPage;
    @FindBy(css = "input[data-track='textNotificationLinkName']")
    WebElement textNotificationButton;
    @FindBy(css = "button[class='account__toggle__button']")
    WebElement myAccount;
    @FindBy(css = "a[data-cruller='my-account-order-history-link']")
    WebElement myOrderHistory;
    @FindBy(css = "button[aria-label='Edit Payment']")
    WebElement editPayment;
    @FindBy(xpath = "//button[text()='Continue']")
    public WebElement continueButton;
    @FindBy(css = "div[class='payment-options__checkbox']")
    WebElement paymentOptionCheckBox;
    @FindBy(css = "input[id='primaryCard']")
    WebElement primaryCardCheckBox;
    @FindBy(css = "div[class ='card card--active card--payment-options']")
    WebElement activeCardOnTop;
    @FindBy(css = "button[class='payment-options__add-card-button']")
    WebElement addNewCardButton;
   //Checkout-Page payment-card-list
    @FindAll(@FindBy(css = "div.card--payment-options")) public List<WebElement> paymentCards;
    @FindAll(@FindBy(css = "button.card__content__item__add-to-cart")) public List<WebElement> selectCardButton;
    //Checkout-Page payment-card-list remove-card-button-on-each-card
    @FindAll(@FindBy(css = "button[data-cruller='remove-card-button']")) public List<WebElement> removeCardButton;
    @FindBy(css = "button[data-cruller='confirm-remove-card-button']")
    WebElement confirmCardRemoveButton;
    @FindBy(css = "input[id='streetAddress']")
    WebElement streetAddress;
    @FindBy(css = "input[id='unit']")
    WebElement aptOrUnitOptional;
    @FindBy(css = "input[id='city']")
    WebElement city;
    @FindBy(css = "input[id='postalCode']")
    WebElement postalCode;
    @FindBy(css = "select[id='region']")
    WebElement province;
    @FindBy(xpath = "//option[text()='Quebec']")
    WebElement quebecOption;
    @FindBy(css = "button[class*='billing-address-form__form__submit-btn--button']")
    WebElement saveAddressButton;
    @FindBy(css = "select[id='country']")
    WebElement country;
    @FindBy(css = "label[id='streetAddress__error']")
    WebElement streetAddressError;
    @FindBy(css = "label[id='postalCode__error']")
    WebElement postalCodeError;
    @FindBy(css = "div[class='billing-address-tile__content']")
    WebElement enterBillingAddress;
    @FindBy(css = "input[placeholder=\"Card Number\"]")
    WebElement cardNumber;
    @FindBy(css = "iframe[id=\"global-payment-frame\"]")
    WebElement paymentFormIframe;
    @FindBy(css = "input[id='pas_expiry']")
    WebElement cardExpireDate;
    @FindBy(css = "input[id='pas_cccvc']")
    WebElement securityCode;
    @FindBy(css = "input[id='pas_ccname']")
    WebElement cardholderName;
    @FindBy(css = "button[id='rxp-primary-btn']")
    WebElement processing;
    @FindBy(css = "label[id='pas_ccnum-error']")
    WebElement invalidCardError;
    //Cart Checkout-button checkout-button-main-cart-content
    @FindBy(css = "div.cart-page__section__content__main__sticky-container button[data-testid='proceed-to-checkout-button']") WebElement checkoutButtonOnCart;

    //Cart Proceed_To_Checkout_Button button-below-order-summary-on-cart-page
    @FindBy(css="div.cart-checkout-sidebar__group__summary button[data-testid='proceed-to-checkout-button']") WebElement proceedToCheckoutButton;
    @FindBy(css = ".cart-products-header__title.cart-products-header__title--delivery")
    WebElement delivery;
    @FindBy(xpath = "//h3[normalize-space()='Add Delivery Address']")
    WebElement addAddress;
    @FindBy(id = "firstName")
    WebElement addressFirstName;
    @FindBy(id = "lastName")
    WebElement addressLastName;
    @FindBy(xpath = "//input[@id='city']")
    WebElement addressCity;
    @FindBy(xpath = "//button[normalize-space()='Save delivery address']")
    WebElement saveAddress;
    @FindBy(xpath = "//div[@class='delivery-address-tile-list']//div[1]//div[1]//button[1]")
    WebElement savedAddressArea;
    @FindBy(xpath = "//h3[normalize-space()='Choose your address']")
    WebElement chooseAddress;

    @FindBy(css = "button.fulfillment-card")
    WebElement deliveryTime;
    @FindBy(xpath = "//span[@class='almost-done-page__header__link__message']")
    WebElement checkOutPage;
    @FindBy(xpath = "//button[@class='fulfillment-card']")
    WebElement timeSlotArea;
    @FindBy(xpath = "//button[@aria-label='Select 9:00am to 9:30am Tuesday, September 19th, Fee: $5']")
    WebElement firstSlot;
    @FindBy(css = "button.delivery-address-tile__content__choose-button")
    WebElement clickOnAddress;
    @FindBy(xpath = "//textarea[@id='pickupInstructions']")
    WebElement additionalArea;
    @FindBy(xpath = "//h2[normalize-space()='Bagging Preferences']")
    WebElement baggingPreference;
    @FindBy(xpath = "//strong[normalize-space()='Bring your own bags']")
    WebElement ownBag;
    @FindBy(xpath = "//input[@id='byob']")
    WebElement ownBagCheckbox;
    @FindBy(xpath = "//strong[normalize-space()='Already have reusable boxes?']")
    WebElement haveReusableBags;
    @FindBy(xpath = "//p[contains(text(),'Great! Tell us how many you have here and then bri')]")
    WebElement reusableBagText;
    @FindBy(xpath = "//input[@value='0']")
    WebElement reusableBagQuantity;
    @FindBy(xpath = "//a[normalize-space()='Edit']")
    WebElement editButton;
    @FindBy(xpath = "")
    WebElement myAccountPage;
    @FindBy(xpath = "//strong[normalize-space()='Want to purchase reusable boxes?']")
    WebElement purchaseReusableBoxes;
    @FindBy(xpath = "")
    WebElement addToCartForBoxes;
    @FindBy(xpath = "//p[contains(text(),'No problem! Buy them here and they will be used to')]")
    WebElement purchaseBoxText;
    @FindBy(xpath = "//div[@class='goGreen-exchange-form-row__label-qty-wrapper__form__quantity-selector-wrapper goGreen-exchange-form-row__label-qty-wrapper__form__quantity-selector-wrapper--purchase-bins']//button[@class='quantity-selector__adjust__button quantity-selector__adjust__button--increment']//*[name()='svg']//*[name()='path' and contains(@d,'M19 13h-6v')]")
    WebElement boxQuantityAdd;
    @FindBy(xpath = "//div[@class='order-summary-total-item order-summary-total-item--order-summary-estimated-total-mkt']")
    WebElement greenBoxTotal;
    @FindBy(xpath = "//a[normalize-space()='Profile']")
    WebElement myProfile;
    @FindBy(xpath = "//h3[normalize-space()='Add Credit Card Details']")
    WebElement addCreditCardDetails;

    @FindBy(xpath = "//span[normalize-space()='Fastest']")
    WebElement fastestDelivery;
    @FindBy(xpath = "//span[normalize-space()='Low Fee']")
    WebElement lowFeeDelivery;
    @FindBy(xpath = "//p[normalize-space()='Select a time']")
    WebElement selectATime;
    @FindBy(xpath = "//button[normalize-space()='See timeslot']")
    WebElement displayTimeSlot;
    @FindBy(xpath = "//div[@class='timeslot-selector-day-slot']")
    WebElement timeSlotSelector;
    @FindBy(xpath = "button[data-cruller=\"deliver-address-choose-button\"]")
    WebElement selectAddress;
    By bySelectAddress = By.cssSelector("button[data-cruller=\"deliver-address-choose-button\"]");
    @FindBy(xpath = "//button[normalize-space()='Save & Continue']")
    public WebElement saveAndContinue;
    @FindBy(xpath = "//h2[normalize-space()='Delivery details']")
    WebElement deliveryDetails;
    @FindBy(xpath = "//h2[normalize-space()='Pickup details']")
    WebElement PickUpDetails;
    @FindBy(xpath = "//span[normalize-space()='Same day']")
    WebElement sameDayDelivery;
    @FindBy(xpath = "//span[normalize-space()='Next day']")
    WebElement nextDayDelivery;
    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement placeOrder;
    @FindBy(css = "div.thank-you-page__header")
    WebElement confirmationMessage;
    @FindBy(css = "a.thank-you-page-pickup-details__order__link" )
    public WebElement viewOrder;
    @FindBy(xpath = "//li[@aria-label='The driver receives 100% of the tip.']")
    WebElement tipAmountPassedToDriver;
    @FindBy(xpath = "//div[@class='cart-products-header__title cart-products-header__title--pickup']")
    WebElement pickUp;
    @FindBy(xpath = "//h1[normalize-space()='Your PC Express Cart']")
    WebElement cart;
    @FindBy(xpath = "//h2[normalize-space()='Order Summary']")
    public WebElement orderSummary;
    @FindBy(xpath = "//h1[normalize-space()='Driver Tip']")
    public WebElement driverTip;
    @FindBy(xpath = "//span[@class='selected']")
    WebElement tipAmount;
    //Checkout page top-of-checkout-info-section fulfillment-swatch-delivery
    @FindBy(xpath = "//span[text()='Delivery']//parent::button") WebElement checkoutDeliverySwatch;
    //Checkout delivery-address-form
    @FindBy(css = "form.form-layout--delivery-address-form__form") WebElement deliveryAddressForm;
    //Checkout edit-delivery-address-button
    @FindBy(css = "button[aria-label='Edit Address']") WebElement editAddressButton;
    //Checkout delivery-form shipping-address-List
    @FindAll(@FindBy(css = "div.delivery-address-tile--delivery-address-tile-list"))
    public List<WebElement> checkoutShippingAddressList;
    //Checkout-delivery payment-Card-List
    @FindAll(@FindBy(css = "div.card--payment-options"))
    public List<WebElement> paymentCardList;
    //Checkout shipping-address-form first-name-input-box
    @FindBy(id = "firstName") WebElement firstNameInputBox;
    //Checkout shipping-address-form last-name-input-box
    @FindBy(id = "lastName") WebElement lastNameInputBox;
    //Checkout shipping-address-form street-input-box
    @FindBy(id = "streetAddress") WebElement streetAddressInputBox;
    //Checkout shipping-address-form street-input-box
    @FindBy(id = "city") WebElement cityInputBox;
    //CartPage checkoutButton
    @FindBy(xpath = "//button[text()='Proceed to Checkout']")
    WebElement checkoutButton;
    //AlmostDone-page deliveryButtonOnAlmostDonePage
    @FindBy(xpath = "//*[text()='Delivery']/..")
    WebElement deliveryButton;
    //AlmostDone-page firstFulfilmentPlanButton
    @FindBy(xpath = "(//*[@class='fulfillment-plans__form']//button)[1]")
    WebElement firstFulfilmentPlanButton;

    //AlmostDone-page deliveryButton (if there is any product that can not be delivered) listOfNonDeliverables
    @FindBy(xpath="//div[@class='modal-dialog__content__module']//tr/td[contains(@class,'--item')]")
    List<WebElement> listOfNonDeliverables;
    //AlmostDone-page deliveryButton acceptAndContinueButton
    @FindBy(xpath="//button[@data-track='productDropoutContinue']")
    WebElement acceptAndContinueButton;

    //Checkout delivery-form shipping-address-tiles
    @FindAll(@FindBy(css = "div[data-cruller='delivery-address-tile']"))
    List<WebElement> checkoutShippingAddressTiles;
    //Checkout delivery-form add-new-shipping-address
    @FindBy(css = "button.delivery-addresses__add-address-button") WebElement addNewDeliveryAddressButton;
    //Checkout delivery-form postalcode input-box;
    @FindBy(id = "postalCode") WebElement postalCodeInputBox;
    //Checkout delivery-form phonenumber input-box;
    @FindBy(id = "phoneNumber") WebElement phoneNumberInputBox;
    //Checkout delivery-form delivery-instructions-textbox
    @FindBy(id = "deliveryInstructions") WebElement deliveryInstructionsTextArea;
    //Checkout delivery-form save-shipping-address-button
    @FindBy(css = "button.delivery-address-form__form__action__submit-btn") public WebElement saveShippingAddressButton;
    @FindBy(css = "div[data-cruller='delivery-address-tile-content']") public WebElement shippingAddressInfo;
    @FindBy(id = "region") WebElement provinceDropdown;
    @FindBy(css = "h3.delivery-address-tile__content__detail") public WebElement customerNameInShippingAddressContent;
    @FindAll(@FindBy(css = "address.delivery-address-tile__content__detail")) List<WebElement> customerAddressInShippingAddressContent;
    @FindBy(css = "address.delivery-address-tile__content__detail__instruction") WebElement shippingAddressInstructionContent;
    @FindBy(css = "div.delivery-address button[data-cruller='edit-button']") public WebElement editShippingAddressButton;
    @FindAll(@FindBy(css = "button[data-cruller='deliver-address-choose-button']")) List<WebElement> buttonRadioSavedShippingAddress;
    By chooseDeliveryAddressButton = By.cssSelector("delivery-address-tile__content__choose-button");
    @FindAll(@FindBy(css = "button.fulfillment-card")) public List<WebElement> fulfilllmentTimeslotsButton;
    By byFulfilllmentTimeslotButton = By.cssSelector("button.fulfillment-card");
    @FindAll(@FindBy(css = "p.fulfillment-card__charge")) List<WebElement> fulfillmentSlotCharges;
    @FindAll(@FindBy(css = "span.fulfillment-card__plantype")) List<WebElement> fulfillmentPlanTypeLabels;
    @FindBy(css = "div.modal-dialog__content--newtimeslot-selector")
    public WebElement timeslotSelector;
    @FindAll(@FindBy(css = "button[data-cruller='timeslot-daylist-button--']")) List<WebElement> timeSlotDayListButton;
    @FindAll(@FindBy(css = "button.timeslot-selector-day-slot__slotrow__view-availability__button")) public List<WebElement> viewAvailabilityTimeSlotButton;
    @FindAll(@FindBy(css = "div.timeslot-selector-day-slot__slotrow__info__status__fee")) public List<WebElement> statusFeeOnTimeSlot;
    @FindAll(@FindBy(css = "button.timeslot-selector-day-slot__slotrow__choose__button")) public List<WebElement> timeslotSelectorButtons;
    @FindAll(@FindBy(css = "div.order-summary-total-item--fulfillment-fee")) public List<WebElement> fulfillmentFee;
    @FindBy(css = "div.timeslot-confirmation-v2-details__location") WebElement timeslotConfirmationLocation;
    @FindBy(css = "p.timeslot-confirmation-v2-details__timeslot") WebElement timeslotConfirmationTimeAndDate;
    @FindBy(css = "div.timeslot-confirmation-info") public WebElement timeslotConfirmationDetail;
    @FindBy(css = "button[data-track='confirmTimeslotButton']")public WebElement timeslotReserveButton;
    @FindBy(css = "button[data-track='cancelTimeslotButton']")public WebElement timeslotCancelButton;
    @FindBy(css = "div.fulfillment-plans--completed") public WebElement selectedTimeSlot;

    @FindBy(css = "button[data-testid='save-continue-button']" ) public WebElement saveAndContinueButton;
    @FindBy(id = "pickupInstructions") public WebElement instructionTextbox;
    @FindBy(id = "byob") public WebElement bringYourOwnBagCheckbox;
    @FindBy(css = "span.bagging-preference-summary-row__text-container span.text--small5") public WebElement selectedBaggingPreference;
    @FindBy(css = "input[aria-label='Quantity of boxes to swap']") public WebElement swapReusableBagQuantity;
    @FindBy(css = "input[aria-label='Quantity of boxes to buy']") public WebElement buyReusableBagQuantity;
    @FindBy(css = "button[data-track='productAddToCartButton']") public WebElement addReusableBagToCartButton;
    @FindBy(css = "span.order-summary-sub-total__values") public WebElement subTotalAmount;
    @FindBy(css = "span.pickup-content-contact__number__phone") public WebElement phoneNumberLabel;
    @FindBy(css = "button[aria-label='Edit Contact details']") public WebElement editContactDetailsButton;
    @FindBy(css = "a.pickup-content-contact__edit") public WebElement linkToEditPhoneNumber;
    @FindBy(css = "a.pickup-content-contact__smsupdate__edit__link ") public WebElement linkToEditSmsPreferences;
    @FindBy(css = "button[aria-label='Edit Delivery details']")
    public WebElement editDeliveryTimeSlotButton;
    @FindBy(css = "button[aria-label='Edit Pickup details']") WebElement editPickupTimeSlotButton;
    @FindBy(css = ".notification-item__content__message__text")
    WebElement errorMessage;
    @FindBy(css = "button.button.button--inline.button--theme-none.pickup-details__time__btn.pickup-details__time__btn--button")
    WebElement postalCodeCartPage;
    @FindBy(css = "button.quantity-selector__adjust__button--increment")
    WebElement quantityIncreaseButton;
    @FindBy(css = "span[class='almost-done-page__fulfillment-toggle__label']")
    WebElement deliveryTab;
    @FindBy(css = "button[data-track='productAddToCartButton']")
    WebElement addToCart;

    //Checkout Order-Summary SubTotal
    @FindBy(css = "div.order-summary-sub-total") WebElement orderSummarySubTotal;
    //Checkout Order-Summary Additional-Fee
    @FindBy(css = "div.order-summary-total-item--additional-fee") WebElement orderSummaryAdditionalFee;
    //Checkout Order-Summary Estimated-Tax
    @FindBy(css = "div.order-summary-total-item--order-summary-additional-fee") WebElement orderSummaryEstTaxes;
    //Checkout Order-Summary Driver-Tip
    @FindBy(css = "div.order-summary-total-item--order-summary-driver-tip") WebElement orderSummaryDriverTip;
    //Checkout Order-Summary Estimated-Total
    @FindBy(css = "div.order-summary-totals__total") WebElement orderSummaryEstTotal;
    //Checkout Order-Summary Fee-Amount
    By feeAmountSelector = By.cssSelector("span.order-summary-total-item__values");
    //Placed-Order View-Order Driver-Tip-in-Order-Summary
    @FindBy(css = "div.order-summary-total-item--trimmed__driver-tip") WebElement driverTipInOrderSummary;
    //Placed-Order View-Order Driver-Tip-in-Payment-Summary
    @FindBy(css = "div.order-summary-total-item--trimmed__live-cart-driver-tip") WebElement driverTipInPaymentSummary;
    @FindBy(css = "button[data-track='cartReviewSelectGroceryTimeSlotButton']")
    WebElement availableTimeslotsButtons;

    public Checkout(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, ProjectConfig.DEFAULT_TIMEOUT);
        commonUtility=new CommonUtility(driver);
    }

    //This method will click on sign In link for the users to Sign in with their PCId
    public void clickSignInOnHomePage() {
        commonUtility.clickOnElement(signInButtonHomePage);
    }

    public void signIn(String testCase) throws IOException {
        commonUtility.waitForElementVisibility((userEmail));
        userEmail.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Log.info("Data Driven : "+DataDriven.getTestData("TestData",testCase));
        userEmail.sendKeys(DataDriven.getTestData("TestData",testCase).get(1));
        userPass.sendKeys(DataDriven.getTestData("TestData",testCase).get(1));
        commonUtility.clickOnElement(signInButton);
    }

    //This method redirect the user from Cart to the Checkout page
    public void navigateFromCartToCheckoutPage(){
        commonUtility.waitForElementVisibility(checkoutButtonOnCart);
        commonUtility.clickOnElement(checkoutButtonOnCart);
    }

    //This method will switch the fulfillment method as delivery if current fulfillment method is Pickup
    public void switchToDeliveryOnCheckoutPage(){
        commonUtility.waitForElementVisibility(checkoutButtonOnCart);
        //If delivery swatch is not selected, then click the delivery button
        if(checkoutDeliverySwatch.isEnabled()){
            commonUtility.clickOnElement(addNewDeliveryAddressButton);
        }
    }

    //This method validates if there is any shipping address saved on user's profile
    public boolean validateIfThereIsShippingAddressSaved(){
        commonUtility.waitForElementVisibility(checkoutShippingAddressTiles);
        //If there is no address saved in profile, this statement will return true.
        return checkoutShippingAddressTiles.isEmpty();
    }

    // This method click ad-d an address button to add a new shipping address
    public void clickAddANewShippingAddressButton(){
        commonUtility.waitForElementVisibility(addNewDeliveryAddressButton);
        commonUtility.clickOnElement(addNewDeliveryAddressButton);
    }

    //This method will enter randomly generated first name in shipping address form
    public void fillFirstNameInShippingAddressForm(){
        openAddressForm();
        firstNameInputBox.sendKeys(commonUtility.generateRandomFirstName());
        Log.info("First Name: "+firstNameInputBox.getAttribute("value"));
    }
    public void openAddressForm(){
        try {
            wait.until(ExpectedConditions.visibilityOf(deliveryAddressForm));
        }catch (TimeoutException exception){
            Log.info("Address already added, let's add new address");
            addNewAddressIfRequired();
        }
    }
    public void addNewAddressIfRequired() {
        if(checkoutShippingAddressList.isEmpty()) {
            commonUtility.clickOnElement(editAddressButton);
        }
        commonUtility.clickOnElement(addNewDeliveryAddressButton);
        wait.until(ExpectedConditions.visibilityOf(deliveryAddressForm));
    }
    public String producHavingLargeInventoryCount() throws IOException {
        int randomProductIndex=commonUtility.generateRandomNumber(DataDriven.getTestData("TestData","Products").size());
        return DataDriven.getTestData("TestData","Products").get(randomProductIndex);
    }
    public boolean validateNameVisibleInShippingAddress(){
        commonUtility.waitForElementVisibility(customerNameInShippingAddressContent);
        Log.info("Customer Name: "+customerNameInShippingAddressContent.getText());
        return customerNameInShippingAddressContent.getText().isEmpty()||customerNameInShippingAddressContent.getText().equalsIgnoreCase("null");
    }

    public boolean validateAddressVisibleInShippingAddress(){
        commonUtility.waitForElementVisibility(customerAddressInShippingAddressContent);
        for (WebElement addressLine:customerAddressInShippingAddressContent){
            Log.info("Address: "+addressLine.getText());
            if(addressLine.getText().isEmpty()||addressLine.getText().equalsIgnoreCase("null")){
                return false;
            }
        }
        return true;
    }

    public boolean validateDeliveryInstructionAdded(){
        commonUtility.waitForElementVisibility(shippingAddressInstructionContent);
        Log.info("Shipping Instructions: "+shippingAddressInstructionContent.getText());
        return shippingAddressInstructionContent.getText().isEmpty()||shippingAddressInstructionContent.getText().equalsIgnoreCase("null");
    }


    //This method will enter randomly generated last name in shipping address form
    public void fillLastNameInShippingAddressForm(){
        commonUtility.waitForElementVisibility(deliveryAddressForm);
        lastNameInputBox.sendKeys(commonUtility.generateRandomLastName());
        Log.info("Last Name: "+lastNameInputBox.getAttribute("value"));
    }

    //This method will enter randomly generated street address in street address field
    public void fillStreetAddressInShippingAddressForm(){
        commonUtility.waitForElementVisibility(deliveryAddressForm);
        streetAddress.sendKeys(commonUtility.generateRandomStreetAddress());
    }

    //This method will enter the phone number in the phone number input box
    public void enterPhoneNumberInShippingAddressForm(){
        commonUtility.waitForElementVisibility(phoneNumberInputBox);
//        String phoneNumber=commonUtility.generateRandomPhoneNumber();
        //Does not work on UAT as it demands valid mobile number and not a random number
        String phoneNumber = "7787240160";
        Log.info("Generated Phone number: "+phoneNumber);
        phoneNumberInputBox.sendKeys(phoneNumber);
        Log.info(phoneNumberInputBox.getAttribute("value"));
    }

    //This will enter randomly generated text in special instructions
    public void enterTextDescriptionInDeliveryForm(){
        commonUtility.waitForElementVisibility(deliveryInstructionsTextArea);
        deliveryInstructionsTextArea.sendKeys(commonUtility.generateRandomDescription());
        Log.info(deliveryInstructionsTextArea.getAttribute("value"));
    }

    //This method will return true if shipping address is added on Checkout Page
    public boolean validateShippingAddressAdded(){
        commonUtility.waitForElementVisibility(shippingAddressInfo);
        Log.info("Shipping Address: "+shippingAddressInfo.getText());
        return commonUtility.validateIfElementIsVisible(shippingAddressInfo);
    }

    public boolean validatePickupLocation() {
        commonUtility.waitForElementVisibility(pickupLocation);
        Log.info("Pickup Location : " + pickupLocation.getText());
        return commonUtility.validateIfElementIsVisible(pickupLocation);
    }

    public void clearAllPickupItems() {
        commonUtility.clickOnElement(clearItemButton);
        commonUtility.clickOnElement(confirmButton);
        commonUtility.clickOnElement(naveBackToHomePage);
    }

    public void proceedToCheckout() {
        commonUtility.clickOnElement(proceedToCheckout);
    }

    public boolean validateVisibilityOfContactDetail() {
        commonUtility.waitForElementVisibility(contactDetails);
        Log.info("Contact Detail on Checkout : " + contactDetails.getText());
        return commonUtility.validateIfElementIsVisible(contactDetails);
    }

    public boolean mayIClickOnEditContact() {
        wait.until(ExpectedConditions.elementToBeClickable(editContactDetails));
        return editContactDetails.isEnabled();
    }

    public void backToCart() {
        commonUtility.clickOnElement(backToCart);
    }

    public void clickOnEditContactDetail() {
        commonUtility.clickOnElement(editContactDetails);
    }

    public boolean mayIClickOnEditNumberAndSMS() {
        wait.until(ExpectedConditions.elementToBeClickable(editContactNumber));
        wait.until(ExpectedConditions.elementToBeClickable(editSMSUpdate));
        return editContactNumber.isEnabled() && editSMSUpdate.isEnabled();
    }

    public void clickOnEditSMSUpdate() {
        commonUtility.clickOnElement(editSMSUpdate);
    }

    public String switchOnNewTab() {
        String originalTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return originalTab;
    }

    public boolean validateIfAddressSelectionCanBeSelected(){
        commonUtility.waitForElementVisibility(buttonRadioSavedShippingAddress);
        for(WebElement radioButton:buttonRadioSavedShippingAddress){
            if (!radioButton.isEnabled()){
                return false;
            }
        }
        return true;
    }

    public boolean validateNavigateOnPreferencesToSMSUpdate() {
        commonUtility.waitForElementVisibility(preferencesPage);
        Log.info("Preferences Details : " + preferencesPage.getText());
        return commonUtility.validateIfElementIsVisible(preferencesPage) && preferencesPage.getText().contains("Preferences");
    }

    public void switchOnTab(String switchTab) {
        driver.close();
        driver.switchTo().window(switchTab);
    }

    public void viewMyAccount(WebElement element) {
        commonUtility.clickOnElement(myAccount);
        commonUtility.clickOnElement(element);
    }

    public void viewMyOrderHistory() {
        viewMyAccount(myOrderHistory);
    }

    public void clickOnEditPayment() {
        commonUtility.waitForElementVisibility(paymentCardList);
        if(paymentCardList.isEmpty()){
            commonUtility.clickOnElement(editPayment);
        }

    }

    public boolean validateListOfSaveOrderDetail() {
        commonUtility.waitForElementVisibility(paymentCards);
        Log.info("Count of listed cards : " + paymentCards.size());
        Log.info("Card details : " + paymentCards.get(0).getText());
        return paymentCards.isEmpty();
    }

    public boolean canISelectOneOfThemListedCards() {
        commonUtility.waitForElementVisibility(paymentCards);
        commonUtility.waitForElementVisibility(selectCardButton);
        boolean selectorForEachCard = (paymentCards.size() == selectCardButton.size());
        commonUtility.clickOnElement(commonUtility.selectAnyElementRandomly(selectCardButton));
        commonUtility.clickOnElement(continueButton);
        return selectorForEachCard;
    }

    public boolean validatePrimaryCardIsOnTop() {
        clickOnEditPayment();
        commonUtility.waitForElementVisibility(paymentOptionCheckBox);
        commonUtility.waitForElementVisibility(activeCardOnTop);
        Log.info(paymentOptionCheckBox.getText());
        return commonUtility.validateIfElementIsVisible(activeCardOnTop);
    }

    public void clickOnAddNewCard() {
        commonUtility.clickOnElement(addNewCardButton);
    }

    public boolean validateStreetAddressField() {
        wait.until(ExpectedConditions.elementToBeClickable(streetAddress));
        return commonUtility.validateIfElementIsVisible(streetAddress);
    }

    public boolean validateVisibilityOfAPTField() {
        wait.until(ExpectedConditions.elementToBeClickable(aptOrUnitOptional));
        return commonUtility.validateIfElementIsVisible(aptOrUnitOptional);
    }

    public boolean validateVisibilityOfCityField() {
        wait.until(ExpectedConditions.elementToBeClickable(city));
        return commonUtility.validateIfElementIsVisible(city);
    }

    public boolean validateVisibilityOfProvinceField() {
        wait.until(ExpectedConditions.elementToBeClickable(province));
        return commonUtility.validateIfElementIsVisible(province);
    }

    public boolean validateVisibilityOfZipCodeField() {
        wait.until(ExpectedConditions.elementToBeClickable(postalCode));
        return commonUtility.validateIfElementIsVisible(postalCode);
    }

    public boolean validateStreetCountryField() {
        wait.until(ExpectedConditions.elementToBeClickable(country));
        return commonUtility.validateIfElementIsVisible(country);
    }

    public boolean validateErrorMessageForInputField() {
        commonUtility.clickOnElement(saveAddressButton);
        commonUtility.waitForElementVisibility(streetAddressError);
        commonUtility.waitForElementVisibility(postalCodeError);
        Log.info(streetAddressError.getText());
        return commonUtility.validateIfElementIsVisible(streetAddressError) && commonUtility.validateIfElementIsVisible(postalCodeError);
    }

    public boolean addNewBillingAddress() {
        clickOnEditPayment();
        clickOnAddNewCard();
        wait.until(ExpectedConditions.elementToBeClickable(streetAddress));
        streetAddress.sendKeys("6 Leslie St");
        city.sendKeys("Toronto");
        postalCode.sendKeys("M4M 3H7");
        commonUtility.clickOnElement(province);
        commonUtility.clickOnElement(quebecOption);
        commonUtility.clickOnElement(saveAddressButton);
        commonUtility.waitForElementVisibility(addCreditCardDetails);
        return commonUtility.validateIfElementIsVisible(addCreditCardDetails);
    }

    public boolean validateVisibilityOfEnteredBillingAddress() {
        commonUtility.waitForElementVisibility(enterBillingAddress);
        Log.info(enterBillingAddress.getText());
        return commonUtility.validateIfElementIsVisible(enterBillingAddress) && enterBillingAddress.getText().contains("6 Leslie St");
    }

    public void addNewCard(String cardNo, String exp, String code, String cardHolder) {
        commonUtility.waitForElementVisibility(paymentFormIframe);
        driver.switchTo().frame(paymentFormIframe);
        commonUtility.waitForElementVisibility(cardNumber);
        cardNumber.sendKeys(cardNo);
        cardExpireDate.sendKeys(exp);
        securityCode.sendKeys(code);
        cardholderName.sendKeys(cardHolder);
        commonUtility.clickOnElement(processing);
        // After interacting with elements inside the iframe, switch back to the default content
        driver.switchTo().defaultContent();
    }

    public boolean validateErrorMessageForAddCard() {
        commonUtility.waitForElementVisibility(paymentFormIframe);
        driver.switchTo().frame(paymentFormIframe);
        commonUtility.waitForElementVisibility(invalidCardError);
        boolean result = commonUtility.validateIfElementIsVisible(invalidCardError);
        Log.info("invalidCardError");
        // After interacting with elements inside the iframe, switch back to the default content
        driver.switchTo().defaultContent();
        return result;
    }

    public int attemptToDeleteNewAddedCard() {
        commonUtility.waitForElementVisibility(paymentCards);
        int totalCardsBeforeRemove = paymentCards.size();
        Log.info("Count of listed cards Before Remove : " + totalCardsBeforeRemove);
        commonUtility.clickOnElement(commonUtility.selectAnyElementRandomly(removeCardButton));
        commonUtility.clickOnElement(confirmCardRemoveButton);
        return totalCardsBeforeRemove;
    }

    public boolean validateRemoveCard(int totalCardBeforeRemove) {
        clickOnEditPayment();
        commonUtility.waitForElementVisibility(paymentCards);
        Log.info("Count of listed cards After Remove : " + paymentCards.size());
        return paymentCards.size() < totalCardBeforeRemove;
    }

    /*Our testing is limited to Postal Codes : L4B4R2 or M4M3H9. We have opted for addresses:
    17 Leslie St, Toronto and 301 High Tech Road, Richmond Hill
    We are fetching this address via Excel sheet and using it here
    * */
    public void enterStreetAddrees(String addressVariable) throws IOException {
        commonUtility.waitForElementVisibility(streetAddressInputBox);
        //Method to return the Row as array and accessed the second column which has the address
        Log.info(DataDriven.getTestData("TestData",addressVariable).get(1));
        streetAddressInputBox.sendKeys(DataDriven.getTestData("TestData",addressVariable).get(1));
        Log.info(streetAddressInputBox.getAttribute("value"));
    }

    public void enterPostalCode(String postalCode){
        commonUtility.waitForElementVisibility(postalCodeInputBox);
        if(postalCodeInputBox.getAttribute("value").contentEquals("")) {
            postalCodeInputBox.sendKeys(postalCode);
        }
        Log.info(postalCodeInputBox.getAttribute("value"));
    }
    public void enterAddressCity(String testCity) throws IOException {
        commonUtility.waitForElementVisibility(cityInputBox);
        Log.info("City: "+testCity);
        Log.info("Test Data: "+DataDriven.getTestData("TestData",testCity));
        cityInputBox.sendKeys(DataDriven.getTestData("TestData",testCity).get(1));
        Log.info(cityInputBox.getAttribute("value"));
    }

    public boolean enterValidAddress() throws IOException {
        commonUtility.waitForElementVisibility(firstNameInputBox);
        lastNameInputBox.sendKeys(commonUtility.generateRandomLastName());
        streetAddress.sendKeys(DataDriven.getTestData("Test Data","DefaultAddress1").get(1));
        addressCity.sendKeys(DataDriven.getTestData("Test Data","City").get(1));
        commonUtility.clickOnElement(saveAddress);
        return commonUtility.validateIfElementIsVisible(addAddress);
    }

    public boolean validateSavedAddress() {
        commonUtility.waitForElementVisibility(checkoutButtonOnCart);
        return commonUtility.validateIfElementIsVisible(savedAddressArea) && savedAddressArea.getText().contains("himani - 5350 East Boulevard, Vancouver, British Columbia, V6M 3V2");
    }

    public boolean selectAddress() {
        commonUtility.waitForElementVisibility(chooseAddress);
        commonUtility.clickOnElement(clickOnAddress);
        return commonUtility.validateIfElementIsVisible(chooseAddress);

    }

    public void goToCheckout() {
        commonUtility.clickOnElement(proceedToCheckout);
    }



    public boolean validatePhoneNoDisplayed() {
        commonUtility.waitForElementVisibility(phoneNumberLabel);
        Log.info("Phone Number: "+phoneNumberLabel.getText());
        return commonUtility.validateIfElementIsVisible(phoneNumberLabel);

    }

    public boolean validateOptionToEditPhoneNumberAndPreferences(){
        commonUtility.waitForElementVisibility(linkToEditPhoneNumber);
        return commonUtility.validateIfElementIsVisible(linkToEditPhoneNumber) && commonUtility.validateIfElementIsVisible(linkToEditSmsPreferences);
    }

    public boolean validateIfEditingPhoneNumberIsRedirectingToAccountsPage(){
        commonUtility.clickOnElement(linkToEditPhoneNumber);
        String originalWindowHandle= driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindowHandle.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return driver.getCurrentUrl().contains("account/profile");
    }

    public boolean validateIfEditingSMSPreferencesIsRedirectingToPreferences(){
        commonUtility.clickOnElement(linkToEditSmsPreferences);
        String originalWindowHandle= driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindowHandle.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return driver.getCurrentUrl().contains("/account/preference");
    }


    public void addNewAddress() {
        commonUtility.clickOnElement(myAccount);
        commonUtility.clickOnElement(myProfile);

    }

    public void fillAllCheckoutSteps() {
        commonUtility.waitForElementVisibility(chooseAddress);
        commonUtility.validateIfElementIsVisible(chooseAddress);
        commonUtility.clickOnElement(selectAddress);
        commonUtility.clickOnElement(saveAndContinue);
        commonUtility.waitForElementVisibility(deliveryDetails);
        commonUtility.validateIfElementIsVisible(deliveryDetails);
        commonUtility.clickOnElement(fastestDelivery);
        commonUtility.clickOnElement(saveAndContinue);

    }

    public boolean placeAnOrder() {
        commonUtility.clickOnElement(placeOrder);
        commonUtility.waitForElementVisibility(confirmationMessage);
        Log.info("Order placed message: "+confirmationMessage.getText());
        return commonUtility.validateIfElementIsVisible(confirmationMessage);
    }

    public void fillAllPickUpCheckoutSteps() {
        commonUtility.waitForElementVisibility(chooseAddress);
        commonUtility.validateIfElementIsVisible(chooseAddress);
        commonUtility.clickOnElement(selectAddress);
        commonUtility.clickOnElement(saveAndContinue);
        commonUtility.waitForElementVisibility(PickUpDetails);
        commonUtility.validateIfElementIsVisible(PickUpDetails);
        commonUtility.clickOnElement(fastestDelivery);
        commonUtility.clickOnElement(saveAndContinue);
    }

    public void fillNecessaryDeliveryCheckoutSteps() {
        commonUtility.waitForElementVisibility(placeOrder);
        commonUtility.waitForElementVisibility(fulfilllmentTimeslotsButton);
        if(!fulfilllmentTimeslotsButton.isEmpty()) {
            commonUtility.clickOnElement(commonUtility.selectAnyElementRandomly(fulfilllmentTimeslotsButton, fulfilllmentTimeslotsButton.size() - 1));
            commonUtility.clickOnElement(saveAndContinueButton);
        }
        commonUtility.clickOnElement(saveAndContinueButton);
    }

    public boolean validateFulfillmentOptions() {
        commonUtility.waitForElementVisibility(PickUpDetails);
        commonUtility.validateIfElementIsVisible(PickUpDetails);
        return commonUtility.validateIfElementIsVisible(fastestDelivery) && commonUtility.validateIfElementIsVisible(lowFeeDelivery) && commonUtility.validateIfElementIsVisible(nextDayDelivery);


    }

    public boolean validateFulfillmentDeliveryOptions() {
        wait.until(ExpectedConditions.visibilityOf(deliveryTab));
        deliveryTab.click();
        saveAndContinue.click();
        commonUtility.waitForElementVisibility(deliveryDetails);
        commonUtility.validateIfElementIsVisible(deliveryDetails);
        return commonUtility.validateIfElementIsVisible(fastestDelivery) && commonUtility.validateIfElementIsVisible(lowFeeDelivery) && commonUtility.validateIfElementIsVisible(sameDayDelivery);


    }

    public boolean selectATimeSlot() {
        commonUtility.clickOnElement(selectATime);
        commonUtility.waitForElementVisibility(displayTimeSlot);
        commonUtility.validateIfElementIsVisible(displayTimeSlot);
        commonUtility.clickOnElement(displayTimeSlot);
        return commonUtility.validateIfElementIsVisible(timeSlotSelector);
    }

    public boolean orderConfirmationPage() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmationMessage));
        return commonUtility.validateIfElementIsVisible(confirmationMessage);
    }

    public void selectATip() {
        commonUtility.waitForElementVisibility(driverTip);
        commonUtility.validateIfElementIsVisible(driverTip);
        commonUtility.clickOnElement(tipAmount);

    }
    //This method validate driver-tip value in order-summary, on view order page
    public boolean validateTipAmountInOrderSummary(){
        commonUtility.waitForElementVisibility(driverTipInOrderSummary);
        Double driverTip = getPrice(driverTipInOrderSummary);
        Log.info("Driver-Tip in OrderSummary: "+driverTip);
        return driverTip<25.00;
    }
    //This method validate driver-tip value in payment-summary, on view order page
    public boolean validateTipAmountInPaymentSummary(){
        commonUtility.waitForElementVisibility(driverTipInPaymentSummary);
        Double driverTip = getPrice(driverTipInPaymentSummary);
        Log.info("Driver-Tip in PaymentSummary: "+driverTip);
        return driverTip<25.00;
    }
    public boolean validateTipAmountPassedToDriver() {
        commonUtility.waitForElementVisibility(tipAmountPassedToDriver);
        return commonUtility.validateIfElementIsVisible(tipAmountPassedToDriver);
    }

    public void backToCartPage() {
        commonUtility.clickOnElement(backToCart);
    }

    public boolean validateCartPageInfo() {
        commonUtility.waitForElementVisibility(pickUp);
        commonUtility.validateIfElementIsVisible(pickUp);
        return commonUtility.validateIfElementIsVisible(pickupLocation) && commonUtility.validateIfElementIsVisible(cart) && commonUtility.validateIfElementIsVisible(orderSummary);

    }

    //This method selects the province by the value passed as parameter
    public void selectTheProvince(String provinceValue){
        commonUtility.waitForElementVisibility(provinceDropdown);
        Select provinceDropdownShippingAddress=new Select(provinceDropdown);
        provinceDropdownShippingAddress.selectByValue(provinceValue);
    }

    //This will return true if there is a suggested time slots available
    public boolean validateSlotsVisible(){
        commonUtility.waitForElementVisibility(fulfilllmentTimeslotsButton);
        Log.info("Total suggested slots: "+fulfilllmentTimeslotsButton.size());
        return fulfilllmentTimeslotsButton.size()>1;
    }
    //This will click on edit time slot for Pickup or Delivery if there is already selected timeSlot.
    public void clickOnEditTimeSlotForPickupOrDelivery(){
        try {
            commonUtility.clickOnElement(editDeliveryTimeSlotButton);
        }catch (TimeoutException exception){
            commonUtility.clickOnElement(editPickupTimeSlotButton);
        }
    }
    //This method validate if price is visible on the slots and also, it should be greater than or equal to 0.00
    public boolean validateIfPriceIsVisibleOnSlots(){
        for(WebElement timeSlotPrice:fulfillmentSlotCharges){
            if(Double.parseDouble(timeSlotPrice.getText().replace("$",""))<=0.00){
                return false;
            }
        }
        return true;
    }

    //This method will validate if suggested fulfillment slots have Fastest, Low Fee and Same day label
    public boolean validateIfFulfillmentSlotsHavePlanType(){
        commonUtility.waitForElementVisibility(fulfillmentPlanTypeLabels);
        for (WebElement fulfillmentPlan:fulfillmentPlanTypeLabels){
            Log.info("Fulfillment Type: "+fulfillmentPlan.getText());
            Log.info("Fulfillment result: "+fulfillmentPlan.getText().matches("\\b(Fastest|Low Fee|Same day)\\b"));
            if (!fulfillmentPlan.getText().matches("\\b(Fastest|Low Fee|Same day)\\b")){
                return false;
            }
        }
        return true;
    }

    public void selectTheTimeSlot(){
        commonUtility.waitForElementVisibility(fulfilllmentTimeslotsButton);
        fulfilllmentTimeslotsButton.get(fulfilllmentTimeslotsButton.size()-1);
    }


    public void checkOutAndCheckForPopUp() throws InterruptedException {
        commonUtility.clickOnElement(checkoutButton);
        int attempts = 0;
        while(attempts < 2) {
            try {
                commonUtility.clickOnElement(deliveryButton);
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        try{
            //Handling exception as some have fulfilment selected already
            commonUtility.clickOnElement(firstFulfilmentPlanButton);
        }
        catch(NoSuchElementException e){

        }
        commonUtility.clickOnElement(saveAndContinueButton);
    }

    public Boolean checkForNonDeliveryPopup(){
        try{
            if (listOfNonDeliverables.size()>=2){
                return true;
            }
            commonUtility.clickOnElement(acceptAndContinueButton);
        } catch(NoAlertPresentException e){
            return false;
        }
        return null;
    }

    public void saveAndContinue() {
        commonUtility.waitForElementVisibility(saveAndContinue);
        commonUtility.clickOnElement(saveAndContinue);
    }

    public void resetToZeroReusableBag(){
        try{
            wait.until(ExpectedConditions.visibilityOf(addReusableBagToCartButton));
        }catch (TimeoutException exception){
            Log.info("Bag is already Selected, let's reset it 0");
            String amountBeforeAddingReusableBag=subTotalAmount.getText().replace("$","");
            resetReusableBagQuantity("0");
            wait.until(ExpectedConditions.visibilityOf(addReusableBagToCartButton));
            waitForElementTextToChange(subTotalAmount, amountBeforeAddingReusableBag);
        }
    }
    public void resetReusableBagQuantity(String quantity){
        commonUtility.waitForElementVisibility(buyReusableBagQuantity);
        buyReusableBagQuantity.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        buyReusableBagQuantity.sendKeys(quantity);
        buyReusableBagQuantity.sendKeys(Keys.ENTER);
    }

    public void selectTimeSlot() {
        commonUtility.waitForElementVisibility(fulfilllmentTimeslotsButton);
        if(!fulfilllmentTimeslotsButton.isEmpty()) {
            commonUtility.clickOnElement(commonUtility.selectAnyElementRandomly(fulfilllmentTimeslotsButton, fulfilllmentTimeslotsButton.size() - 1));
            commonUtility.clickOnElement(saveAndContinueButton);
        }
    }

    public void checkout() {
        commonUtility.clickOnElement(proceedToCheckout);
        commonUtility.waitForElementVisibility(placeOrder);
    }
    public boolean validateCartPageInfoForDelivery() {
        wait.until(ExpectedConditions.visibilityOf(delivery));
        delivery.isDisplayed();
        return postalCodeCartPage.isDisplayed() && cart.isDisplayed() && orderSummary.isDisplayed();
    }

    public boolean validateErrorMsgForNondelivery() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        Log.info("Error Message on Undeliverable: "+errorMessage.getText());
        return errorMessage.getText().contentEquals("This order cannot be delivered");
    }

    public boolean validateErrorMsgForDeliveryLimit() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        Log.info("Error Message on deliver limit: "+errorMessage.getText());
        return errorMessage.getText().contentEquals("Sorry, with this addition you have exceeded the maximum number of items allotted for this location.");
    }

    public void addUnitsInCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.click();
        wait.until(ExpectedConditions.visibilityOf(quantityIncreaseButton));
        for (int i = 1; i <= 25; i++) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(quantityIncreaseButton));
            quantityIncreaseButton.click();;
        }
    }

    public void selectDeliveryAddress() {
        commonUtility.waitForElementVisibility(chooseAddress);
        if(!commonUtility.validateIfElementIsNotPresent(bySelectAddress)) {
            commonUtility.clickOnElement(clickOnAddress);
            commonUtility.clickOnElement(saveAndContinueButton);
            commonUtility.waitForElementInvisibility(chooseAddress);
        }
    }
    public boolean validateVisibilityOfAvailableTimeSlot() {
        commonUtility.waitForElementVisibility(viewAvailabilityTimeSlotButton);
        return viewAvailabilityTimeSlotButton.isEmpty();
    }
    public void clickOnRandomTimeSlot() {
        commonUtility.waitForElementVisibility(timeSlotDayListButton);
        int maxLimit = timeSlotDayListButton.size();
        // Ensure there are at least 3 time slots available
        if (maxLimit >= 3) {
            // Skip the first two time slots
//          commonUtility.clickOnElement(commonUtility.selectAnyElementRandomly(timeSlotDayListButton.subList(2, maxLimit), maxLimit - 3));
           commonUtility.clickOnElement(timeSlotDayListButton.get(3));
       } else {
           throw new RuntimeException("Not enough time slots available to generate a random index.");
       }
   }
   public boolean validateVisibilityOfDeliveryFees(){
       commonUtility.waitForElementVisibility(statusFeeOnTimeSlot);
       return statusFeeOnTimeSlot.isEmpty();
   }
   public boolean validateTimeSlotSelectionBoard(){
        commonUtility.waitForElementVisibility(timeslotConfirmationLocation);
        Log.info("Delivery Location : " + timeslotConfirmationLocation.getText());
        Log.info("Delivery Time and Date : " + timeslotConfirmationTimeAndDate.getText());
        return timeslotConfirmationLocation.isDisplayed() && timeslotConfirmationTimeAndDate.isDisplayed();
    }
    public boolean isTimeSlotSelected(){
        try {
            wait.until(ExpectedConditions.visibilityOf(selectedTimeSlot));
            return true;
        }catch (TimeoutException | NoSuchElementException exception){
            Log.error("Element not found until defined timeout");
            return false;
        }
    }
    public boolean validateElement(WebElement element){
        commonUtility.waitForElementVisibility(element);
        Log.info(element.getText());
        return commonUtility.validateIfElementIsVisible(element);
    }
    public boolean validateDeliveryFeeOnSummary(){
        commonUtility.waitForElementVisibility(fulfillmentFee);
        Double deliveryFee = getPrice(fulfillmentFee.get(0));
        Log.info("Delivery Fee: "+deliveryFee);
        return deliveryFee<25.00;
    }
    public boolean validateSubtotal() {
        return validateElement(orderSummarySubTotal);
    }
    public boolean validateServiceFeeOnSummary(){
        commonUtility.waitForElementVisibility(fulfillmentFee);
        Double serviceFee = getPrice(fulfillmentFee.get(fulfillmentFee.size()-1));
        Log.info("Service Fee: "+serviceFee);
        return serviceFee<25.00;
    }
    public boolean validateAdditionalFeeOnSummary(){
        commonUtility.waitForElementVisibility(orderSummaryAdditionalFee);
        Double additionalFee = getPrice(orderSummaryAdditionalFee);
        Log.info("Additional Fee: "+additionalFee);
        return additionalFee<25.00;
    }
    public Double getPrice(WebElement element){
        commonUtility.waitForElementVisibility(element);
        return commonUtility.convertStringToDouble(element.findElement(feeAmountSelector).getText().replace("$",""));
    }
    public boolean validateEstTaxesOnSummary(){
        return validateElement(orderSummaryEstTaxes);
    }
    public boolean validateDriverTipOnSummary(){
        commonUtility.waitForElementVisibility(orderSummaryDriverTip);
        Double driverTip = getPrice(orderSummaryDriverTip);
        Log.info("Driver Tip: "+driverTip);
        return driverTip<25.00;
    }
    public boolean validateEstTotalOnSummary(){
        return validateElement(orderSummaryEstTotal);
    }
    public void waitForElementTextToChange(WebElement element, String oldText) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, oldText)));
    }
    public boolean validateVisibilityOfPickupFees(){
        commonUtility.waitForElementVisibility(statusFeeOnTimeSlot);
        return statusFeeOnTimeSlot.isEmpty();
    }
    public void selectTimeslotButton() {
            commonUtility.waitForElementVisibility(availableTimeslotsButtons);
            commonUtility.clickOnElement(availableTimeslotsButtons);
            commonUtility.clickOnElement(displayTimeSlot);
    }
}
