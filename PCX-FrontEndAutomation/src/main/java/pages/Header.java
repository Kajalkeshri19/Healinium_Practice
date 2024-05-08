package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Base;
import resources.CommonUtility;
import util.Log;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public class Header {
    public final String CLICK_SCRIPT = "arguments[0].click();";
    WebDriver driver;
    WebDriverWait wait;
    Random random;
    CommonUtility commonUtility;
    @FindBy(css = "a.logo")
    WebElement headerLogoLink;
    @FindBy(xpath = "//h2[text()='Sign in, get rewarded']")
    WebElement signInHeading;
    @FindBy(css = "div[class='block-linked-image']")
    WebElement marketPlace;
    @FindBy(css = "div[class='fulfillment-mode-button__content']")
    WebElement currentLocation;
    @FindBy(css = "div[class='fulfillment-mode-button__content__text']")
    WebElement deliveryLocationText;
    @FindBy(css = "p[class='confirm-auto-localization-detailed__prompt']")
    WebElement nearestLocationMessage;
    @FindBy(css = "button[data-cruller='confirm-nearby-location-button']")
    WebElement buttonYes;
    @FindBy(css = "a[data-cruller='store-locator-link']")
    WebElement changeLocationButton;
    @FindBy(css = "div[class='fulfillment-destination']")
    WebElement locationTile;
    @FindBy(css = "a.store-locator-link")
    WebElement changeCurrentLocation;
    @FindBy(css = "div[class='page-title']")
    WebElement pageHeading;
    @FindBy(css = "button[data-track-link-name='pick-up-details-switch-to-delivery']")
    WebElement switchToDelivery;
    @FindBy(name = "postalCode")
    WebElement deliveryPostalInputBox;
    @FindBy(css = "button[data-cruller='fulfillment-mode-button']") public WebElement fullfillmentButton;
    @FindBy(css = "button[data-track='fulfillmentModeSwitchButton']") WebElement switchFulfillmentButton;
    @FindBy(css = "button[class*='button button']")
    WebElement saveDeliveryInput;
    @FindBy(css = "div[data-cruller='delivery-widget-edit']")
    WebElement deliveryBox;
    @FindBy(css = "button[class*='button button']")
    WebElement change;
    @FindBy(css = "div[class='delivery-widget-unavailable']")
    WebElement noDeliveryMessage;
    @FindBy(css = "input[name='addressAutocomplete']")
    WebElement rapidLocationInputBox;
    @FindBy(css = "button[data-code='services']")
    WebElement servicesHeader;
    @FindBy(css = "a[data-code='/rapid-delivery']")
    WebElement rapidDeliveryService;
    @FindAll(@FindBy(css = "div[class='address-autocomplete__options-container']"))
    List<WebElement> rapidAutoCompleteList;
    @FindBy(css = "button.fulfillment-mode-button")
    WebElement storeButton;
    @FindBy(xpath = "//h1[text()='Find a location']")
    WebElement findALocationTitle;
    @FindBy(id = "location-search__search__input")
    WebElement searchLocationInputBox;
    @FindBy(id = "PlacesAutocomplete__root")
    WebElement placesDropdown;
    @FindAll(@FindBy(css = "div[id^='PlacesAutocomplete__autocomplete-item-']"))
    List<WebElement> dropdownItems;
    @FindBy(css = "a.fulfillment-location-confirmation__actions__button")
    WebElement confirmLocationButton;
    //Header fulfillment-dialog delivery-save-postal-code-button
    @FindBy(css = "button.delivery-widget-postal-code-form__form__button") public WebElement saveDeliveryPostalCodeButton;
    //Header fulfillment-dialog fullfillment-mode-label
    @FindBy(css = "div.fulfillment-mode-button__content__label") public WebElement fulfillmentModeContentLabel;
    //Header fulfillment-dialog change-pickup-location-link
    @FindBy(css = "a[data-cruller='store-locator-link']") public WebElement noChangeLocationLink;


    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        random = new Random();
        commonUtility=new CommonUtility(driver);
    }

    public void clickLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(headerLogoLink));
        headerLogoLink.click();
    }

    public boolean validateHeaderLink() throws IOException {
        Base base = new Base();
        wait.until(ExpectedConditions.visibilityOf(headerLogoLink));
        return driver.getCurrentUrl().equals(base.loadProperties("url"));
    }

    public boolean clickAnyCategory() {
        wait.until(ExpectedConditions.visibilityOf(signInHeading));
        Log.info(signInHeading.getText());
        return signInHeading.getText().contains("Sign in, get rewarded");
    }

    public boolean iDontSeeMarketPlace() {
        wait.until(ExpectedConditions.invisibilityOf(marketPlace));
        return true;
    }

    /**
     * Validates the location is visible on the cart page
     * @return true if current location is displayed
     */
    public boolean iSeeDefaultLocation() {
        wait.until(ExpectedConditions.visibilityOf(currentLocation));
        Log.info(currentLocation.getText());
        return currentLocation.isDisplayed();
    }

    public void iClickLocationTitle() {
        wait.until(ExpectedConditions.visibilityOf(currentLocation));
        Log.info(currentLocation.getText());
        currentLocation.click();
    }

    public boolean iSeeNearestLocationMessage() {
        wait.until(ExpectedConditions.visibilityOf(nearestLocationMessage));
        Log.info(nearestLocationMessage.getText());
        return nearestLocationMessage.isDisplayed();
    }

    public boolean iHaveTheAbilityToClickYes() {
        wait.until(ExpectedConditions.visibilityOf(buttonYes));
        return buttonYes.isDisplayed() && buttonYes.isEnabled();
    }

    public boolean iHaveTheAbilityToClickNo() {
        wait.until(ExpectedConditions.visibilityOf(changeLocationButton));
        return changeLocationButton.isDisplayed() && changeLocationButton.isEnabled();
    }

    public boolean iSeeNearestLocation() {
        wait.until(ExpectedConditions.visibilityOf(locationTile));
        return locationTile.isDisplayed();
    }

    public void iClickChangeLocation() {
        wait.until(ExpectedConditions.visibilityOf(changeLocationButton));
        changeLocationButton.click();
    }

    public boolean iAmToChangeLocationPage() {
        wait.until(ExpectedConditions.visibilityOf(pageHeading));
        return pageHeading.getText().contains("FIND A LOCATION");
    }

    public void switchToDelivery() {
        wait.until(ExpectedConditions.visibilityOf(currentLocation));
        currentLocation.click();
        try {
             // Click on change if the current location is already set for delivery; otherwise, proceed with switching to delivery.
                wait.until(ExpectedConditions.visibilityOf(change));
                change.click();
        } catch (NoSuchElementException |TimeoutException e) {
            Log.info("Pickup Option is present");
            wait.until(ExpectedConditions.visibilityOf(switchToDelivery));
            switchToDelivery.click();
        }
    }

    public boolean iSeeMyDeliveryCode() {
        wait.until(ExpectedConditions.visibilityOf(deliveryPostalInputBox));
        deliveryPostalInputBox.sendKeys("M4M3H9");
        wait.until(ExpectedConditions.visibilityOf(saveDeliveryInput));
        saveDeliveryInput.click();
        wait.until(ExpectedConditions.invisibilityOf(deliveryBox));
        return true;
    }

    public boolean iSeeAppropriateMessage() {
        wait.until(ExpectedConditions.visibilityOf(change));
        change.click();
        deliveryPostalInputBox.sendKeys("A1A1A1");
        wait.until(ExpectedConditions.visibilityOf(saveDeliveryInput));
        saveDeliveryInput.click();
        wait.until(ExpectedConditions.visibilityOf(noDeliveryMessage));
        Log.info(noDeliveryMessage.getText());
        return noDeliveryMessage.isDisplayed();
    }

    public void updateTheStore(String storeSearchQuery) {
        wait.until(ExpectedConditions.visibilityOf(storeButton));
        try {
            storeButton.click();
        } catch (ElementClickInterceptedException ecie) {
            ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, storeButton);
        }
        wait.until(ExpectedConditions.visibilityOf(changeCurrentLocation));
        try {
            changeCurrentLocation.click();
        } catch (ElementClickInterceptedException ecee) {
            ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, changeCurrentLocation);
        }
        wait.until(ExpectedConditions.visibilityOf(findALocationTitle));
        searchLocationInputBox.sendKeys(storeSearchQuery);
        wait.until(ExpectedConditions.visibilityOf(placesDropdown));
        wait.until(ExpectedConditions.visibilityOfAllElements(dropdownItems));
        try {
            dropdownItems.get(0).click();
        } catch (ElementClickInterceptedException ecie) {
            ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, dropdownItems.get(0));
        }
    }

    public void selectTheStore(String storeName) {
        //Ignore the code smell here as this is dynamic locator and cannot be predefined
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='" + storeName.toUpperCase() + "']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text()='" + storeName.toUpperCase() + "']//ancestor::li//button")));
        driver.findElement(By.xpath("//h2[text()='" + storeName.toUpperCase() + "']//ancestor::li//button")).click();
        wait.until(ExpectedConditions.visibilityOf(confirmLocationButton));
        changeCurrentLocation.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fulfillment-mode-button__content__location']//span[text()='" + storeName + "']")));
        wait.until(ExpectedConditions.visibilityOf(headerLogoLink));
        headerLogoLink.click();
    }

    public void selectTheStoreOnRapid(String storeLocation) {
        wait.until(ExpectedConditions.visibilityOf(rapidLocationInputBox));
        rapidLocationInputBox.sendKeys(storeLocation);
        wait.until(ExpectedConditions.visibilityOfAllElements(rapidAutoCompleteList));
        rapidAutoCompleteList.get(0).click();
    }


    public void switchTheFulfillment(){
        commonUtility.waitForElementVisibility(switchFulfillmentButton);
        commonUtility.clickOnElement(switchFulfillmentButton);
    }

    public void setPostalCodeInDeliveryBox(String postalCode){
        commonUtility.waitForElementVisibility(deliveryPostalInputBox);
        deliveryPostalInputBox.sendKeys(postalCode);
    }

    public boolean validateDeliveryFulfilmentIsSelected(){
       wait.until(ExpectedConditions.textToBePresentInElement(fulfillmentModeContentLabel,"Delivery"));
        return fulfillmentModeContentLabel.getText().contains("Delivery");
    }

    public boolean validatePickupFulfilmentIsSelected(){
        wait.until(ExpectedConditions.textToBePresentInElement(fulfillmentModeContentLabel,"Pickup"));
        return fulfillmentModeContentLabel.getText().contains("Pickup");
    }

    public String currentFulfillmentMethod(){
        commonUtility.waitForElementVisibility(fulfillmentModeContentLabel);
        return fulfillmentModeContentLabel.getText();
    }


}
