package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.CommonUtility;
import util.Log;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cart {
    private static final String DELIVERY_LABEL = "Delivery to";
    private static final String PICK_UP_LABEL = "Pickup at";
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    CommonUtility commonUtility;
    Random random;
    PLP plp;
    //HomePage
    @FindBy(css = "a.logo")
    public WebElement homePageLogo;
    //HomePage(PC Optimum account) adaButtonFrame
    @FindBy(css = "iframe.ada-button-frame")
    WebElement adaButtonFrame;
    //HomePage(PC Optimum account) adaChatFrame
    @FindBy(css = "iframe.ada-chat-frame")
    WebElement adaChatFrame;
    //HomePage(PC Optimum account) adaChatButton
    @FindBy(css = "button[id='ada-chat-button']")
    WebElement adaChatButton;
    //HomePage(PC Optimum account) adaChatButton adaChatBotMessageList
    @FindBy(css = "div[data-testid='MessageList']")
    public WebElement adaChatBotMessageList;
    //HomePage header miniCartButton miniCartFlyer subTotalMiniCart
    @FindBy(css = "span[data-cruller='cart-subtotal-text']")
    WebElement subTotalHeader;
    //HomePage header miniCartButton (click on it to open up the mini cart flyout)
    @FindBy(css = "button.desktop-mini-cart-button")
    WebElement miniCartButton;
    //HomePage header miniCartButton checkoutButtonMiniCart
    @FindBy(css = "a.checkout-button")
    public WebElement checkoutButtonMiniCart;
    //HomePage header itemCountMiniCart (displays the count of items in the cart, on the mini cart button)
    @FindBy(css = "span.cart-item-count__text")
    public WebElement itemCountMiniCart;
    //HomePage header miniCartButton viewCartButton (open the cart page)
    By byViewCartButton = By.cssSelector("a.cart-summary__view-cart__link");
    //HomePage header miniCartButton viewCartButton (opens the cart page)
    @FindBy(css = "a.cart-summary__view-cart__link")
    WebElement viewCartButton;
    //HomePage header miniCartButton miniCartFlyer (displays all the cart info)
    @FindBy(css = "div[data-auid='mini-cart-flyout']")
    WebElement miniCartFlyer;
    //HomePage header miniCartButton miniCartFlyer addedMessageMiniCart
    @FindBy(css = "p.cart-entry__content--product-added")
    WebElement addedMessage;
    //HomePage header miniCartButton miniCartFlyer subTotalMiniCart
    @FindBy(css = "span.cart-summary__content__subtotal__value")
    public WebElement subTotalMiniCart;
    //HomePage header itemNameMiniCart
    @FindBy(css = "a.cart-entry__content--product-name")
    public WebElement itemNameMiniCart;
    //HomePage header miniCartButton particular-items-count
    @FindBy(css = "span.quantity-selector__label")
    public WebElement itemQuantityMiniCart;
    //HomePage header miniCartButton quantity-increment-button
    @FindBy(css = "button.quantity-selector__adjust__button--increment")
    public WebElement quantityIncreaseButton;
    //HomePage Header miniCartButton quantity-decrement-button
    @FindBy(css = "button.quantity-selector__adjust__button--decrement")
    public WebElement quantityDecreaseButton;
    //HomePage Header miniCartButton quantity-decrement-button
    @FindBy(css = "button.quantity-selector__adjust__button--decrement")
    public List<WebElement> quantityDecreaseButtonList;
    //HomePage search-bar search-term Any-product productNameHeading
    @FindBy(css = "h1.product-name__item--name")
    WebElement productNameHeading;
    //HomePage search-box
    @FindBy(css = "input.search-input__input")
    WebElement searchBox;
    //HomePage search-box (enter an item name)  list of productNames
    @FindBy(css = "span.product-name__item--name")
    List<WebElement> productNames;
    //HomePage search-box (enter an item name) productTiles
    @FindBy(css = "div.product-tile")
    List<WebElement> productTiles;
    //HomePage search-box (enter an item name) product addToCartButton
    @FindBy(css = "button[data-track='productAddToCartButton']")
    WebElement addToCartButton;
    //HomePage product-tile (if the item is in low stock) lowStockCallOut
    @FindBy(xpath = "//p[normalize-space()='This item is running low.']")
    public WebElement lowStockCallOut;
    //CartPage clearCartButton (click on it to clear the cart)
    @FindBy(css = "button.clear-cart-btn")
    WebElement clearCartButton;
    //CartPage clearCartButton clearCartPopup confirmClearCartButton (click on it to confirm clearing the cart)
    @FindBy(css = "button.confirm")
    WebElement confirmClearCartButton;
    //CartPage estSubTotal (the total of all the products of the cart)
    @FindBy(css = "span.grocery-cart-products__content__bottom-bar__est-total__value")
    public WebElement estSubTotal;
    //CartPage cartPageHeader (displays text : YOUR PC EXPRESS CART , on top of the cart page)
    @FindBy(css = "h1.checkout-hero-banner__title")
    public WebElement cartPageHeader;
    //CartPage itemCountCartPage (displays the count of items in the cart, on the cart page)
    @FindBy(css = "div.cart-products-header__count")
    public WebElement itemCountCartPage;
    //CartPage listed-cart-items items-name
    @FindBy(css = "div.cart-entry__content--product-name")
    public WebElement cartItemName;
    //CartPage remove-item-button
    @FindBy(css = "button[data-track='productRemoveFromCartButton']")
    WebElement removeItemButton;
    //CartPage remove-item-button
    public static final By byRemoveItemButton = By.cssSelector("button[data-track='productRemoveFromCartButton']");
    //CartPage remove-item-button
    @FindBy(css = "p.cart-entry__content--product-removed")
    WebElement removedMessage;
    //CartPage order-summary subtotal-value
    @FindBy(css = "span.order-summary-sub-total__values")
    WebElement subTotalCartPage;
    //CartPage order-summary estTotal-value
    @FindBy(css = "div.order-summary-total-item--order-summary-estimated-total-mkt span.order-summary-total-item__values")
    WebElement estTotal;
    //CartPage order-summary pickupFee
    @FindBy(css = "div.order-summary-total-item--fulfillment-fee span.order-summary-total-item__values")
    public WebElement pickupFee;
    //CartPage order-summary estimatedTax
    @FindBy(css = "div.order-summary-total-item--order-summary-additional-fee span.order-summary-total-item__values")
    WebElement estimatedTax;
    //CartPage order-summary driver-Tip (If selected fulfilment type is delivery)
    @FindBy(css = "div.order-summary-total-item--order-summary-driver-tip")
    public WebElement driverTip;
    //CartPage listed-cart-items addInstructionButton
    @FindBy(css = "button.cart-entry-note__add-button")
    WebElement addInstructionButton;
    //CartPage listed-cart-items existingInstructionText
    @FindBy(css = "span.cart-entry-note__add-button__text")
    public WebElement existingInstructionText;
    //CartPage listed-cart-items addInstructionButton instructionInputBox
    @FindBy(css = "textarea.cart-entry-note__form__textbox")
    WebElement instructionInputBox;
    //CartPage listed-cart-items addInstructionIcon saveInstructionButton
    @FindBy(css = "button[data-track='cartEntrySaveNoteButton']")
    WebElement saveInstructionButton;
    //CartPage delivery-section addressInCart
    @FindBy(css = "button.pickup-details__time__btn")
    WebElement addressInCart;
    //CartPage checkoutButton
    @FindBy(xpath = "//button[text()='Proceed to Checkout']")
    WebElement checkoutButton;
    //CartPage (if product sub-total is lesser than 35 dollars) minimumCartValueWarning
    @FindBy(css = "div.below-threshold-warning")
    public WebElement minimumCartValueWarning;
    //CartPage checkoutButton checkoutPageSubMenus
    @FindBy(css = "div.mobile-one-page-checkout-title")
    List<WebElement> checkoutPageSubMenus;
    //CartPage cart-item selectSubstitute
    @FindBy(xpath = "//label[normalize-space()='Substitute']")
    List<WebElement> selectSubstitute;
    //CartPage (if a low stock item is selected) Delivery-section lowStockWarningBanner
    @FindBy(css = "div.product-low-inventory--cart-review-title")
    WebElement lowStockWarningBanner;
    //CartPage Delivery-section lowStockItemWarning (next to a low stock item)
    @FindBy(css = "div.product-low-inventory--cart-entry")
    WebElement lowStockItemWarning;
    //CartPage (add alcoholic product) errorMessage
    public static final By errorMessage = By.xpath("//div[@class='message__content__wrapper__details']");
    //CartPage Empty-cart-prompt backToHomeButton
    @FindBy(xpath = "//button[@class='confirm']")
    WebElement backToHomeButton;
    //Desktop-Header fulfillmentModeLabel
    @FindBy(css = "div.desktop-site-header")
    WebElement desktopHeader;
    //Desktop-Header fulfillmentModeLabel
    @FindBy(css = "div.fulfillment-mode-button__content__label")
    WebElement fulfillmentModeLabel;
    //Desktop-Header fulfillmentModeButton
    @FindBy(css = "button[data-cruller='fulfillment-mode-button']")
    WebElement fulfillmentModeButton;
    //Desktop-Header fulfillmentModeButton switchFulfillmentButton
    @FindBy(css = "button[data-cruller='switch-fulfillment-mode']")
    WebElement switchFulfillmentButton;
    //Desktop-Header fulfillmentModeButton switchFulfillmentButton inputPostalBox
    @FindBy(css = "input[name='postalCode']")
    WebElement inputPostalBox;
    //Desktop-Header fulfillmentModeButton switchFulfillmentButton savePostalInputButton
    @FindBy(css = "button.delivery-widget-postal-code-form__form__button")
    WebElement savePostalInputButton;
    //Desktop-Header postalCodeLabel (If selected fulfilment type is delivery)
    @FindBy(css = "span[data-cruller='fulfillment-postal-code']")
    WebElement postalCodeLabel;
    //AlmostDone-page
    @FindBy(xpath = "//div[@class='modal-dialog__content modal-dialog__content--show-checkout-error']//div[contains(text(),'no items')]")
    WebElement errorPopup;
    //AlmostDone-page pickupButton
    @FindBy(xpath = "//*[text()='Pickup']/..")
    public WebElement pickupButton;
    @FindBy(xpath = "//button[@Class='fulfillment-card']//span[contains(@class,'plantype')]")
    List<WebElement> planType;
    //Header righht-menu-checkout-button
    @FindBy(css = "a.checkout-button--menu-bar")
    public WebElement headerCheckoutButton;
    //View-empty-Cart cart-head-title
    @FindBy(css = "h2.empty-cart__sub-title")
    public WebElement emptyCartStatus;
    //PLP add-to-cart-button
    By byAddToCartButton = By.cssSelector("button[data-track='productAddToCartButton']");
    //PLP (add a product to cart) quantityInputBox
    By byPlpQuantityInputBox = By.cssSelector("input[aria-label='Quantity']");
    //PLP (add a product to cart) quantityInputBox
    @FindBy(css = "input[aria-label='Quantity']")
    WebElement plpQuantityInputBox;
    //CLP product-grid (if there is a product added to cart) clpProductTile
    @FindAll(@FindBy(css = "div.chakra-linkbox"))
    List<WebElement> clpProductTiles;
    //CLP (add a product to cart) quantityInputBox
    By byClpQuantityInputBox = By.cssSelector("input[data-testid='quantity-input']");
    //CLP product-grid (if there is a product added to cart) clpQuantityButton
    @FindBy(css = "p[data-testid='btn-text']")
    WebElement clpQuantityButton;
    //CLP product-grid (if there is a product added to cart)
    By byInventoryBadge = By.cssSelector("p[data-testid='inventory-badge-text']");
    //CLP product-grid (if there is a product added to cart) clpQuantityIncreaseButton
    @FindBy(css = "button.css-xz6dbq > svg")
    WebElement clpQuantityIncreaseButton;
    //CLP product-grid (if there is a product added to cart) clpQuantityIncreaseButton
    @FindBy(css = "button.css-lj67pw > svg")
    WebElement clpQuantityDecreaseButton;
    //CheckoutPage order-summary estTotal-value
    @FindBy(css = "div.order-summary-total-item--fulfillment-fee span.order-summary-total-item__values")
    public WebElement serviceFeeOnCheckoutPage;
    //CheckoutPage backToCartLink
    @FindBy(css = "a[data-cruller='back-to-cart-link']")
    public WebElement backToCartLink;
    //WSC CartPage selectTimeSlotButton
    @FindBy(css="button[data-track-link-name='select-pickup-timeslot']")
    public WebElement selectTimeSlotButtonCartPage;
    //WSC CartPage selectTimeSlotButton
    public By bySelectTimeSlotButtonCartPage = By.cssSelector("button[data-track-link-name='select-pickup-timeslot']");
    //WSC CartPage selectTimeSlotButton chooseAvailableTimeSlotButton
    By byChooseAvailableTimeSlotButton = By.cssSelector("button.timeslot-selector-day-slot__slotrow__choose__button");
    //WSC CartPage selectTimeSlotButton chooseAvailableTimeSlotButton
    @FindBy(css="timeslot-selector-day-slot__slotrow__choose__button")
    WebElement chooseAvailableTimeSlotButton;
    //WSC CartPage selectTimeSlotButton pickUpDateButton
    @FindAll(@FindBy(css="button.timeslot-selector-v2-daylist__day__button"))
    List<WebElement> pickUpDateButtonList;
    //WSC CartPage selectTimeSlotButton chooseAvailableTimeSlotButton confirmTimeslotButton
    @FindBy(css="button[data-cruller='timeslot-selector-v2-daylist__button--next']")
    WebElement nextButton;
    //WSC CartPage selectTimeSlotButton chooseAvailableTimeSlotButton confirmTimeslotButton
    @FindBy(css="button[data-track='confirmTimeslotButton']")
    WebElement confirmTimeslotButton;
    //WSC CartPage Order-summary selectTimeSlotButton
    public static final By selectTimeSlotButtonOrderSummary = By.cssSelector("button.order-summary-totals__select-timeslot");


    /**
     * Constructor method for the cart page object
     */
    public Cart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        commonUtility = new CommonUtility(driver);
        plp = new PLP(driver);
        action = new Actions(driver);
        random = new Random();
    }

    //Navigates to the WSC Banner
    public void goToWscBanner() {
        driver.get("https://www.preprod.wholesaleclub.ca/");
    }

    //@return the random number from 0 to maximum value
    public int getRandomNumberUpto(int maximum) {
        Log.info("Finding random number from 0 to " + maximum);
        return random.nextInt(maximum);
    }

    //This method returns number of items in the cart
    public int numberOfItemsInCart() {
        commonUtility.waitForElementVisibility(itemCountMiniCart);
        return commonUtility.convertStringToInteger(itemCountMiniCart.getText());
    }

    //Switches the fulfillment mode from pick-up to delivery or vice-versa
    public void switchFulfillment() {
        commonUtility.clickOnElement(fulfillmentModeButton);
        commonUtility.clickOnElement(switchFulfillmentButton);
    }

    /**
     * Inputs the term in the search box and press enter to proceed search
     * @param searchBox  the web element to which the term is to be sent
     * @param searchTerm the term to be entered in the box
     */
    private void fillTheSearchBox(WebElement searchBox, String searchTerm) {
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.ENTER);
    }

    //Opens URL in new tab and switch to that new tab
    public void openSiteInNewTabAndSwitch() {
        openSiteInNewTab();
        commonUtility.switchToTab(1);
    }

    //Validate the error is poped up on the cart page and return to home page
    public void validateAndCloseErrorPopup() {
        commonUtility.waitForElementVisibility(errorPopup);
        commonUtility.clickOnElement(backToHomeButton);
    }

    //Clicks the mini-cart button from the header section and displays the mini-cart entry list
    public void openMiniCartFlyer() {
        commonUtility.clickOnElement(miniCartButton);
        commonUtility.waitForElementVisibility(miniCartFlyer);
    }

    //Clicks the view-cart button from the mini-cart entry list and opens up the cart page
    public void visitCart() {
        commonUtility.clickOnElement(viewCartButton);
        commonUtility.waitForElementVisibility(cartPageHeader);
    }

    /**
     * Checks if the cart is empty From mini cart
     * @return {@code true} if the item count on the mini-cart icon is 0, {@code false} otherwise.
     */
    public boolean validateEmptyCartFromMiniCart() {
        commonUtility.waitForElementVisibility(itemCountMiniCart);
        return commonUtility.convertStringToInteger(itemCountMiniCart.getText()) == 0;
    }

    //Increases the item quantity from the mini-cart-flyer of the header
    public void increaseQuantity() {
        commonUtility.clickOnElement(quantityIncreaseButton);
        commonUtility.waitForElementVisibility(addedMessage);
    }

    public void decreaseQuantity() {
        commonUtility.clickOnElement(quantityDecreaseButton);
        commonUtility.waitForElementVisibility(removedMessage);
    }

    /**
     * Validate that a product which is added to the cart, is visible among all the  clp products
     * @return @code true if product is found otherwise false
     */
    public boolean validateAddedProductVisibilityInCLP() {
        driver.navigate().back();
        return commonUtility.validateElementVisibility(clpQuantityButton);
    }

    /**
     * Validate that the substitute checkbox is selected for the first item in the cart
     * @return @code true if substitute checkbox is selected, otherwise false
     */
    public boolean validateSubsForItemsInCart() {
        commonUtility.waitForElementVisibility(selectSubstitute);
        return (!selectSubstitute.get(0).isSelected());
    }

    //Get the quantity of the clp product, which is added to the cart
    public String getCLPProductQuantity() {
        commonUtility.waitForElementVisibility(clpQuantityButton);
        return clpQuantityButton.getText();
    }

    /**
     * Gets the count of items in the cart
     * @return the text of the itemCount (a header element on the cart page)
     */
    public String getItemCountTextFromCartPage() {
        commonUtility.waitForElementVisibility(itemCountCartPage);
        return itemCountCartPage.getText();
    }

    /**
     * Gets the Quantity of the product
     * @return value from the quantityInputBox
     */
    public int getPLPProductQuantity() {
        commonUtility.waitForElementVisibility(plpQuantityInputBox);
        return commonUtility.convertStringToInteger(plpQuantityInputBox.getAttribute("value"));
    }

    /**
     * Extracts the item count from an element text on the cart page
     * This method performs the following steps:
     * 1. Calls the helper method getItemCount() to get text of a header element.
     * 2. Remove characters from the text and
     *
     * @return the total count of items
     */
    public Integer getTotalItemsCountFromCartPage() {
        String itemCountText = getItemCountTextFromCartPage();
        return commonUtility.removeCharacters(itemCountText);
    }

    /**
     * Validates that the sub-total of the items in the cart is in the currency values' pattern
     * @return true if the sub-total matches the specified pattern
     */
    public boolean validateSubTotal() {
        commonUtility.waitForElementVisibility(subTotalCartPage);
        return commonUtility.validateCurrencyPattern(subTotalCartPage);
    }

    /**
     * Validates that the est-total of the items in the cart is in the currency values' pattern
     * @return true if the est-total matches the specified pattern
     */
    public boolean validateEstTotal() {
        commonUtility.waitForElementVisibility(estTotal);
        return commonUtility.validateCurrencyPattern(estTotal);
    }

    /**
     * Validates that the estimated Tax on the order is in the currency values' pattern
     * @return true if the estimated Tax matches the specified pattern
     */
    public boolean validateEstimatedTax() {
        commonUtility.waitForElementVisibility(estimatedTax);
        return commonUtility.validateCurrencyPattern(estimatedTax);
    }

    /**
     * Checks if selected fulfilment type is pickup from the header
     * if it not, then switch to pickup.
     */
    public void validatePickUpFromHeader() {
        if (!commonUtility.validateElementContainsText(fulfillmentModeLabel, PICK_UP_LABEL)) {
            switchFulfillmentToPickUp();
        }
    }

    //Switches the fulfillment mode to pick-up from the header
    private void switchFulfillmentToPickUp() {
        switchFulfillment();
        commonUtility.waitForTextToBePresentInElement(fulfillmentModeLabel, PICK_UP_LABEL);
    }

    //Removes the top product from the cart and returns its name
    public void removeProductFromCart() {
        commonUtility.clickOnElement(removeItemButton);
        commonUtility.waitForElementInvisibility(removeItemButton);
    }

    /**
     * Validates that the Selected Fulfilment type is delivery form the header section
     * If the selected fulfillment type is not delivery, Calls the helper method switchToDelivery() to switch from pickup to delivery type.
     * @param postalCode the postal code for the delivery
     */
    public void validateSelectedFulfilmentIsDelivery(String postalCode) {
        if (!commonUtility.validateElementContainsText(fulfillmentModeLabel, DELIVERY_LABEL)) {
            switchFulfillmentToDelivery(postalCode);
        }
    }

    //Returns the service fee on the checkout page
    public int getServiceFee() {
        commonUtility.waitForElementVisibility(serviceFeeOnCheckoutPage);
        return commonUtility.removeDollarSignAndDecimalDigits(serviceFeeOnCheckoutPage.getText());
    }

    //Checks out by clicking the checkout button in the mini cart flyer
    public boolean checkoutFromMiniCart() {
        commonUtility.clickOnElement(checkoutButtonMiniCart);
        return commonUtility.validateElementVisibility(cartPageHeader);
    }

    //Selects the Fresh Fruits category and adds a random item from the category
    public void selectAndAddItemFromFreshFruits() {
        plp.selectFreshFruits();
        plp.addAnItemViaCLP();
    }

    //Validates that the Chat Bot is opened
    public boolean validateChatBot() {
        commonUtility.waitForElementVisibility(adaChatFrame);
        driver.switchTo().frame(adaChatFrame);
        return commonUtility.validateElementVisibility(adaChatBotMessageList);
    }

    //Add three more items to cart and validate the visibility of last item in mini cart
    public boolean addThreeItemsAndViewTheLastItemInMiniCart() {
        for (int i = 0; i < 4; i++) selectAndAddItemFromFreshFruits();
        openMiniCartFlyer();
        return commonUtility.validateElementVisibility(quantityDecreaseButtonList.get(quantityDecreaseButtonList.size() - 1 ));
    }

    /**
     * Validates that a warning is visible on the cart page, if there is a low stock product in the cart
     * @return true if warning banner is displayed
     */
    public boolean validateLowStockWarningMessage() {
        commonUtility.waitForElementVisibility(cartItemName);
        commonUtility.waitForElementVisibility(lowStockItemWarning);
        return commonUtility.validateElementVisibility(lowStockWarningBanner);
    }

    /**
     * Validates that the mini-cart quantity is in terms of weight, that is gram units
     * @return @code true if weight is in grams, otherwise false
     */
    public boolean validateWeightForItemQuantity() {
        commonUtility.waitForElementVisibility(itemQuantityMiniCart);
        String regexPattern = "\\b\\d+g\\b";
        return commonUtility.validateElementMatchesPattern(itemQuantityMiniCart, regexPattern);
    }

    //Opt-In Or Opt-out the substitute check box for all items in the cart
    public void chooseSubsForItemsInMyCart() {
        commonUtility.waitForElementVisibility(cartItemName);
        for (WebElement substitute : selectSubstitute) {
            commonUtility.clickOnElement(substitute);
        }
    }

    /**
     * Clicks the random button from all the add to cart buttons visible on the page
     * and then increase the quantity upto n times
     */
    public void addRandomItemToCart() {
        List<WebElement> addToCartButtonList = driver.findElements(byAddToCartButton);
        int randomNumber = random.nextInt(addToCartButtonList.size());
        commonUtility.clickOnElement(addToCartButtonList.get(randomNumber));
    }

    /**
     * Validates that the Delivery fulfillment type is selected in the cart and the postal code is a valid Canadian postal code
     * @return true if the postal code is valid, otherwise return false.
     */
    public boolean validateDeliveryOnCartPage() {
        commonUtility.waitForElementVisibility(addressInCart);
        String regexPattern = "[A-Z]\\d[A-Z] \\d[A-Z]\\d";
        return commonUtility.validateElementMatchesPattern(addressInCart, regexPattern);
    }

    /**
     * Clicks the checkout button and then moves back
     * @return @code true if the cart page is visible, otherwise false.
     */
    public boolean moveForthAndBack() {
        commonUtility.clickOnElement(checkoutButton);
        commonUtility.waitForElementVisibility(checkoutPageSubMenus);
        driver.navigate().back();
        return commonUtility.validateElementVisibility(cartPageHeader);
    }

    //Opens Site in new tab by getting the current url
    private void openSiteInNewTab() {
        String site = driver.getCurrentUrl();
        driver.get(site);
        commonUtility.openSite(site);
    }

    //Validate that the selected fulfilment type is pickup on the cart page
    public List<String> validatePickupOnCartPage() {
        List<String> planTypeText = new ArrayList<>();
        for (WebElement element : planType) planTypeText.add(element.getText());
        return planTypeText;
    }

    /**
     * Searches an item with the provided product name
     * This method performs the following steps:
     * 1. Clear the search box
     * 2. Enters the search term in search box
     */
    public void searchProduct(String productName) {
        commonUtility.clearTheInputBoxElement(searchBox);
        fillTheSearchBox(searchBox, productName);
        commonUtility.waitForElementVisibility(productTiles);
    }

    /**
     * Switches to delivery fulfillment type, from the header
     * This method performs the following steps:
     * 1. Calls the helper method switchFulfillment() to switch the fulfillment type.
     * 2. Inputs the postal code.
     * 3. Checks if the driver tip is five.
     * @param postalCode the postal code for the delivery
     */
    public void switchFulfillmentToDelivery(String postalCode) {
        Log.info("Switching the fulfilment type.");
        switchFulfillment();
        inputPostalCode(postalCode);
        commonUtility.waitForTextToBePresentInElement(fulfillmentModeLabel, DELIVERY_LABEL);
    }

    /**
     * Enters the special instruction message in the instruction input box
     * @param message the instruction message to add
     */
    public void addSpecialInstructions(String message) {
        commonUtility.waitForElementVisibility(instructionInputBox);
        instructionInputBox.sendKeys(message);
        Log.info("Instruction message" + message + "is added.");
        commonUtility.clickOnElement(saveInstructionButton);
    }

    //Increase and decrease quantity of clp product, which is added to the cart
    public void increaseAndDecreaseQuantityOfCLPproduct() {
        commonUtility.clickOnElement((clpQuantityButton));
        commonUtility.clickOnElement(clpQuantityIncreaseButton);
        commonUtility.clickOnElement(clpQuantityDecreaseButton);
        commonUtility.clickOnElement(desktopHeader);
    }

    /**
     * Inputs the postal code from the header
     * @param postalCode the postal code to be entered in the input box
     */
    private void inputPostalCode(String postalCode) {
        commonUtility.waitForElementVisibility(inputPostalBox);
        inputPostalBox.sendKeys(postalCode);
        commonUtility.clickOnElement(savePostalInputButton);
        commonUtility.waitForElementVisibility(postalCodeLabel);
    }

    //Adds an item to the cart, which is opened
    public void addItemToCart() {
        if (!commonUtility.validateIfElementIsNotPresent(byAddToCartButton)) {
            commonUtility.clickOnElement(addToCartButton);
            commonUtility.waitForElementVisibility(plpQuantityInputBox);
            commonUtility.waitForElementVisibility(subTotalHeader);
        }
    }

    //Opens up the chat bot, by first switching to adaButtonFrame and then clicking on adaChatButton
    public void openChatBot() {
        commonUtility.waitForElementVisibility(adaButtonFrame);
        driver.switchTo().frame(adaButtonFrame);
        commonUtility.waitForElementVisibility(adaChatButton);
        commonUtility.clickOnElement(adaChatButton);
        driver.switchTo().defaultContent();
    }

    //Buy items and update their quantity to 25 repeatedly, until the spend is upto the given amount
    public void spendUpto(int amount) {
        while (commonUtility.removeDollarSignAndDecimalDigits(subTotalHeader.getText()) < amount) {
            Log.info("Added another product as the first product limit is exceeded.");
            selectAndAddItemFromFreshFruits();
            updateProductQuantityIfOneViaCLP(25);
            commonUtility.waitForElementVisibility(subTotalHeader);
        }
    }

    /**
     * Updates the quantity of an item with the provided quantity from the cart page
     * @param quantity the provided quantity to change with
     */
    public void updateProductQuantityviaPLP(int quantity) {
        Log.info("Quantity is updated to " + quantity);
        commonUtility.waitForElementVisibility(plpQuantityInputBox);
        plpQuantityInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
        plpQuantityInputBox.sendKeys(String.valueOf(quantity));
        plpQuantityInputBox.sendKeys(Keys.ENTER);
    }

    /**
     * If there is no existing Instruction, Clicks on special Instruction Icon.
     * Else delete the existing Instruction from the instruction input Box
     */
    public void clickSpecialInstructions() {
        commonUtility.waitForElementVisibility(cartPageHeader);
        try {
            wait.until(ExpectedConditions.visibilityOf(addInstructionButton));
            addInstructionButton.click();
        } catch (NoSuchElementException e) {
            commonUtility.clickOnElement(existingInstructionText);
            commonUtility.clearTheInputBoxElement(instructionInputBox);
        }
    }

    //Visits the cart and clears it if any product is there in the cart
    public void clearCart() {
        openMiniCartFlyer();
        //viewCartButton will be visible only if there is any item in the cart
        if (!commonUtility.validateIfElementIsNotPresent(byViewCartButton)) {
            visitCart();
            Log.info("Clearing ");
            commonUtility.clickOnElement(clearCartButton);
            commonUtility.clickOnElement(confirmClearCartButton);
        } else {
            commonUtility.clickOnElement(miniCartButton);
        }
    }

    //Updates the quantity of a CLP Product, which is already added to the cart
    private void updateProductQuantityIfOneViaCLP(int quantity) {
        List<WebElement> clpQuantityInputBoxList = driver.findElements(byClpQuantityInputBox);
        for(WebElement clpQuantityInputBox : clpQuantityInputBoxList){
            if(clpQuantityInputBox.getAttribute("value").matches("1")){
                Log.info("Quantity is updated to " + quantity);
                commonUtility.waitForElementVisibility(clpQuantityInputBox);
                clpQuantityInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
                clpQuantityInputBox.sendKeys(String.valueOf(quantity));
                clpQuantityInputBox.sendKeys(Keys.ENTER);
            }
        }
    }

    /**
     * Matches the product name with the text of the provided web element and then opens that product
     * This method performs the following steps:
     * 1. If the text of the web element  matches with the product name
     * 2. If yes, view that product
     * @param productName provide the name of the product to add in the cart
     */
    public void findProductByName(String productName) {
        boolean found = false;
        while (!found) {
            commonUtility.waitForElementVisibility(productNames);
            for (WebElement product : productNames) {
                if (commonUtility.validateElementMatchesPattern(product, productName)) {
                    Log.info(productName + "is found");
                    commonUtility.clickOnElement(product);
                    commonUtility.waitForElementVisibility(productNameHeading);
                    found = true;
                    break;
                }
            }
        }
    }

    //Find an item which is in low stock, out of all the clp products
    public void findALowStockItem() {
        commonUtility.waitForElementVisibility(clpProductTiles);
        for (WebElement clpProductTile : clpProductTiles) {
            // find all product tiles that have the inventoryBadge as child element and store in the list
            List<WebElement> inventoryBadge = clpProductTile.findElements(byInventoryBadge);
            //checks if there are some product tiles that have inventoryBadge with text "Low Stock"
            if (!inventoryBadge.isEmpty() && (commonUtility.validateElementContainsText(inventoryBadge.get(0), "Low Stock"))) {
                commonUtility.clickOnElement(clpProductTile);
                commonUtility.waitForElementVisibility(productNameHeading);
                break;
            }
        }
    }

    //WSC SPECIFIC METHODS

    //Temporary method as currently we are searching the product, instead of selecting it from category
    //Add three more items to cart and validate the visibility of last item in mini cart
    public boolean addThreeItemsAndViewTheLastItemInMiniWholesaleCart() {
        for (int i = 0; i < 4; i++) {
            searchProduct("banana");
            addItemToCart();
        }
        openMiniCartFlyer();
        return commonUtility.validateElementVisibility(quantityDecreaseButtonList.get(quantityDecreaseButtonList.size() - 1 ));
    }

    /**
     * WSC : if there are some available time slots for today, select a random from it.
     * Else select a random date and select a random time slot for that date
     */
    public void chooseTimeSlot() {
        List<WebElement> chooseAvailableTimeSlotButtonList = driver.findElements(byChooseAvailableTimeSlotButton);
        int randomTimeSlot = getRandomNumberUpto(chooseAvailableTimeSlotButtonList.size());
        Log.info("Random time slot chosen at index  : " + randomTimeSlot);
        commonUtility.clickOnElement(chooseAvailableTimeSlotButtonList.get(randomTimeSlot));
        commonUtility.clickOnElement(confirmTimeslotButton);
        commonUtility.waitForElementVisibility(cartPageHeader);
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    //Buy items and update their quantity to 25 repeatedly, until the spend is upto the given amount
    public void spendUptoWholesaleCart(int amount) {
        commonUtility.waitForElementVisibility(subTotalHeader);
        while (commonUtility.removeDollarSignAndDecimalDigits(subTotalHeader.getText()) < amount) {
            Log.info("Added another product as the first product limit is exceeded.");
            searchProduct("apple");
            addItemToCart();
            updateProductQuantityIfOneViaPLP(25);
            commonUtility.waitForElementVisibility(subTotalHeader);
        }

    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    //Update the quantity of the product if its one via PLP page
    private void updateProductQuantityIfOneViaPLP(int quantity) {
        List<WebElement> plpQuantityInputBoxList = driver.findElements(byPlpQuantityInputBox);
        for(WebElement plpQuantityBox : plpQuantityInputBoxList){
            if(plpQuantityBox.getAttribute("value").matches("1")){
                Log.info("Quantity is updated to " + quantity);
                commonUtility.waitForElementVisibility(plpQuantityBox);
                plpQuantityBox.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
                plpQuantityBox.sendKeys(String.valueOf(quantity));
                plpQuantityBox.sendKeys(Keys.ENTER);
            }
        }
    }

    /**
     * Find a random pickup date and click on it when its visible
     */
    private void findARandomDate() {
        int randomDate = getRandomNumberUpto(pickUpDateButtonList.size());
        Log.info("Random time date chosen at index : " + randomDate);
        boolean dateIsVisible = false;
        //repeatedly click on next button until the date is visible
        while(!dateIsVisible){
            try{
                pickUpDateButtonList.get(randomDate).isDisplayed();
            } catch (Exception e) {
                commonUtility.clickOnElement(nextButton);
                dateIsVisible = true;
            }
        }
        commonUtility.clickOnElement(pickUpDateButtonList.get(randomDate));
    }


    /**
     * WSC : selects a pickup date for which time slots are available
     */
    public void selectPickUpDate() {
        commonUtility.waitForElementVisibility(pickUpDateButtonList);
        List<WebElement> chooseAvailableTimeSlotButtonList = null;
        boolean isTimeSlotAvailable = false;
        //Loops until a date is found for which time slots are available
        while(!isTimeSlotAvailable){
            commonUtility.waitForElementVisibility(chooseAvailableTimeSlotButton);
            chooseAvailableTimeSlotButtonList = driver.findElements(byChooseAvailableTimeSlotButton);
            //if there is no available time slot available for selected date, then find a new random date
            if(chooseAvailableTimeSlotButtonList.isEmpty()){
                findARandomDate();
            }
            else{
                isTimeSlotAvailable = true;
                Log.info("Size of chooseAvailableTimeSlotButtonList : " + chooseAvailableTimeSlotButtonList.size());
            }
        }
    }

}
