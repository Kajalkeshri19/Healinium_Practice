package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class FindALocation {

    WebDriver driver;
    Random random;
    WebDriverWait wait;
    Actions actions;

   @FindBy(css = "a[data-track-link-name='about-us:store-locator']")
   WebElement storeLocatorFooter;

   @FindBy(css = "h1[class='page-title__title']")
   WebElement findLocationHeading;

   @FindBy(css = "label[for='location-search__search__input']")
   WebElement locationInputBox;

   @FindAll(@FindBy (css = "div[class='location-list-item-details']"))
   List<WebElement> nearByStores;

   @FindBy(css = "div[class='location-map__map']")
   WebElement locationMap;

   @FindAll(@FindBy (css = "div[class='location-list-item-details__address']"))
   List <WebElement> storesDetails;

   @FindAll(@FindBy(css = "button[data-testid='quantity-selector-button-increment-index-1']"))
   List <WebElement> increaseQuantityInMiniCart;

   @FindAll(@FindBy(css = "a[data-auid='checkout-button']"))
   List <WebElement> checkoutButton;

   @FindAll(@FindBy(css = "button[data-testid='proceed-to-checkout-button']"))
   List <WebElement> proceedToCheckout;

   @FindBy(css = "button[data-track='productRemoveFromCartButton']")
   WebElement removeProduct;

   @FindBy(css = "p[role='status']")
   WebElement productRemovedMessage;

   @FindBy(css = "a[data-cruller='cart-summary-view-cart-link']")
   WebElement viewCartButton;

   @FindBy(css = "div[class='cart-page__header']")
   WebElement cartPageHeading;

   @FindBy(css = "div[class='order-summary-totals']")
   WebElement orderSummary;
    public FindALocation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        actions = new Actions(driver);
    }

    public boolean iAmOnFindLocationPage() {
        wait.until(ExpectedConditions.visibilityOf(storeLocatorFooter));
        storeLocatorFooter.click();
        wait.until(ExpectedConditions.visibilityOf(findLocationHeading));
        Log.info(findLocationHeading.getText());
        return findLocationHeading.isDisplayed() && findLocationHeading.getText().contains("FIND A LOCATION");
    }

    public boolean iAmLookingForStore() {
        wait.until(ExpectedConditions.visibilityOf(locationInputBox));
        Log.info(locationInputBox.getText());
        return locationInputBox.isDisplayed() && locationInputBox.getText().contains("Enter an address");
    }

    public void iEnterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOf(locationInputBox));
        locationInputBox.sendKeys(address);
        locationInputBox.sendKeys(Keys.ENTER);
    }

    public boolean iSeeNearByStores() {
        wait.until(ExpectedConditions.visibilityOfAllElements(nearByStores));
        WebElement store = nearByStores.get(random.nextInt(nearByStores.size()));
        Log.info(store.getText());
        return !nearByStores.isEmpty();
    }

    public void selectTheStore(String storeName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='"+storeName.toUpperCase()+"']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text()='"+storeName.toUpperCase()+"']//ancestor::li//button")));
        driver.findElement(By.xpath("//h2[text()='"+storeName.toUpperCase()+"']//ancestor::li//button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fulfillment-mode-button__content__location']//span[text()='"+storeName+"']")));
    }

    public boolean iSeeStoreDetails() {
        wait.until(ExpectedConditions.visibilityOfAllElements(storesDetails));
        WebElement storeDetail = storesDetails.get(random.nextInt(storesDetails.size()));
        Log.info(storeDetail.getText());
        return !storesDetails.isEmpty();
    }
    public boolean iViewLocationMap() {
        wait.until(ExpectedConditions.visibilityOf(locationMap));
        return locationMap.isDisplayed();
    }

    public void iCanIncreaseQuantity() {
        wait.until(ExpectedConditions.visibilityOfAllElements(increaseQuantityInMiniCart));
        increaseQuantityInMiniCart.get(0).click();
    }

    public boolean iCanRemoveProduct() {
        wait.until(ExpectedConditions.visibilityOf(removeProduct));
        removeProduct.click();
        wait.until(ExpectedConditions.visibilityOf(productRemovedMessage));
        return productRemovedMessage.isDisplayed() && productRemovedMessage.getText().contains("Removed");
    }

    public boolean iClickOnViewCart() {
        wait.until(ExpectedConditions.visibilityOf(viewCartButton));
        viewCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(cartPageHeading));
        return cartPageHeading.isDisplayed() && cartPageHeading.getText().contains("YOUR PC EXPRESS CART");
    }

    public void iClickOnCheckout() {
        wait.until(ExpectedConditions.visibilityOfAllElements(checkoutButton));
        checkoutButton.get(0).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(proceedToCheckout));
        proceedToCheckout.get(0).click();
    }

    public boolean iSeeOrderSummary() {
        wait.until(ExpectedConditions.visibilityOf(orderSummary));
        Log.info(orderSummary.getText());
        return orderSummary.isDisplayed() && orderSummary.getText().contains("Subtotal");
    }

}
