package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class RapidPage {
    @FindBy(xpath = "//span[@class='price__value selling-price-list__item__price selling-price-list__item__price--now-price__value']")
    public WebElement price;
    @FindBy(xpath = "//img[@alt='Bananas (3lbs)']")
    public WebElement image;
    @FindBy(xpath = "//div[@class='product-details-page-description']")
    public WebElement productDescription;
    WebDriver driver;
    Random random;
    WebDriverWait expWait;
    By continueButton = By.xpath("//button[normalize-space()='Continue']");
    By searchBox = By.xpath("//input[@id='addressAutocomplete']");
    By bannerBox = By.xpath("//*[text()=\", it's bananas!\"]");
    By message = By.xpath("//*[text()=\"We’re sorry but it looks like we’re not available in your area yet.\"]");
   //Rapid-Home-Page
    By homePage = By.cssSelector("div.cms-homepage");
    By sorryMessage = By.xpath("//*[text()=\"Sorry, we're closed!\"]");
    By clickOnAddress = By.xpath("//div[@class='address-list-item__info']");
    By clickOnCategory = By.xpath("//span[normalize-space()='Fruits & Veg']");
   //Rapid-Category-Page-title
    By categoryListingPageTitle = By.cssSelector("h1.page-title__title");
    By categoryPage = By.xpath("//h1[normalize-space()='Fruits & Vegetables']");
    By clickOnProductTile = By.xpath("//img[@alt='Bananas (3lbs)']");
    By pdpPage = By.xpath("//div[@class='product-details-page-description__title__label']");
    By clickOnOkay = By.xpath("//button[normalize-space()='Okay']");
    By storeAddress = By.xpath("//span[@class='fulfillment-mode-button__delivery-label']");
   //Rapid-Home-Page shopAll-button-for-each-category
    By shopAllButton = By.cssSelector("span[title='Shop all']");
    By enterAddress = By.xpath("//h2[normalize-space()='Enter your address']");
    By productName = By.xpath("//h1[normalize-space()='Bananas (3lbs)']");

    By returnPage = By.xpath("//h1[contains(text(),'Showing')]");

    @FindAll(@FindBy(css = "div.product-tile"))
    List<WebElement> productTiles;

    By clickOnAdd = By.xpath("//button[normalize-space()='Add']");
    By floatingCheckout = By.xpath("//div[@class='floating-checkout__button__content']");

    By clickOnAdjustQuantity = By.xpath("//div[@class='quantity-selector quantity-selector--update quantity-selector--horizontal quantity-selector--product-details-page quantity-selector--add-to-list-button']//button[@class='quantity-selector__adjust__button quantity-selector__adjust__button--increment']//*[name()='svg']");
    By greenCheckmark = By.xpath("//div[@class='product-in-cart-flag product-in-cart-flag--in-cart product-in-cart-flag--product-images product-images--product-details-page product-images--size-1']//*[name()='svg']");
    By cartButton = By.className("cart-item-count__text");
    By productTile = By.className("product-tile__thumbnail__image");
    By lowStockBadge = By.cssSelector(".product-badge__lowInventory--text");
    By searchForProduct = By.xpath("//input[@id='autocomplete-listbox-desktop-site-header-']");
    By suggestedResults = By.xpath("//ul[@id='autocomplete-listbox']");
    By searchIcon = By.xpath("//button[@title='Submit Search']");
    By loadMore = By.xpath("//button[contains(text(),'Load')]");
    By errorMessage = By.xpath("//div[@class='search-no-results__search-form']");
    By searchAgain = By.xpath("//input[@id='autocomplete-listbox-search-no-results-wa']");
    By clickOnSearch = By.xpath("//button[normalize-space()='Search']");
    By emptyBadge = By.cssSelector(".product-tile__details__info__text-badge");
    By homePageForClosedStore = By.xpath("//strong[normalize-space()='Delivery is currently unavailable']");
    By suggestedList = By.xpath("//ul[@id='autocomplete-listbox']");


    public RapidPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random=new Random();
        expWait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void isBannerBoxDisplay() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(bannerBox)).isDisplayed();
    }


    public boolean clickOnContinueButton() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        driver.findElement(continueButton).click();
        expWait.until(ExpectedConditions.invisibilityOfElementLocated(bannerBox));
        expWait.until(ExpectedConditions.visibilityOfElementLocated(homePage));
        return driver.findElement(homePage).isDisplayed();
    }

    public boolean shownAMessage() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(message));
        return driver.findElement(message).isDisplayed();
    }

    public void returnUser() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(homePage)).isDisplayed();
    }

    public boolean seeServiceabilityModal() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(enterAddress));
        return driver.findElement(enterAddress).isDisplayed();
    }

    public boolean changeAddress() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).isDisplayed();
        expWait.until(ExpectedConditions.elementToBeClickable(searchBox));
        driver.findElement(searchBox).click();
        return driver.findElement(continueButton).isDisplayed();
    }

    public void clickOnShopAll() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(shopAllButton));
        List<WebElement> allCategoryShopAll = driver.findElements(shopAllButton);
        allCategoryShopAll.get(random.nextInt(allCategoryShopAll.size())).click();
    }


    public boolean navigateCategoryListingPage() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(categoryPage));
        return driver.findElement(categoryPage).isDisplayed();
    }


    public boolean navigatePdpPage() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(pdpPage));
        return driver.findElement(pdpPage).isDisplayed();
    }

    public void clickCategory() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(clickOnCategory)).click();
    }

    public void clickAProductTile() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(clickOnProductTile)).click();
    }

    public void clickOnStoreAddress() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(storeAddress)).click();
    }

    public boolean navigateToCategoryListingPage() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(categoryListingPageTitle));
        Log.info("Selected categorise pate : "+driver.findElement(categoryListingPageTitle).getText());
        return driver.findElement(categoryListingPageTitle).isDisplayed();
    }

    public boolean storeAddress() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(storeAddress));
        return driver.findElement(storeAddress).isDisplayed();
    }

    public boolean validatePdpPageContent() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(productName)).isDisplayed();
        return price.isDisplayed() && image.isDisplayed() && productDescription.isDisplayed();
    }

    public void clickAdd() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(clickOnAdd)).click();
    }

    public boolean validateAddToCartProcess() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(greenCheckmark));
        driver.findElement(greenCheckmark).isDisplayed();
        expWait.until(ExpectedConditions.visibilityOfElementLocated(floatingCheckout));
        driver.findElement(floatingCheckout).isDisplayed();
        expWait.until(ExpectedConditions.elementToBeClickable(clickOnAdjustQuantity));
        driver.findElement(clickOnAdjustQuantity);
        return driver.findElement(pdpPage).isDisplayed();
    }

    public boolean additionOfItem() throws InterruptedException {
        Thread.sleep(5000);
        expWait.until(ExpectedConditions.visibilityOfElementLocated(cartButton));
        String getCartCount = driver.findElement(cartButton).getText();
        Log.info("Cart Count :" + getCartCount);
        int cartCount = Integer.parseInt(getCartCount);
        return cartCount >= 1;
    }

    public boolean ampleStock() {
        WebElement emptyProductBadge = expWait.until(ExpectedConditions.visibilityOfElementLocated(emptyBadge));
        Log.info("Badge Detail: AMPLE STOCK " + emptyProductBadge.getText());
        return emptyProductBadge.getText().isEmpty();

    }


    public boolean messageForClosedStore() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(sorryMessage));
        driver.findElement(sorryMessage).isDisplayed();
        expWait.until(ExpectedConditions.elementToBeClickable(clickOnOkay));
        driver.findElement(clickOnOkay).click();
        return driver.findElement(homePageForClosedStore).isDisplayed();

    }

    public boolean isProductLowStock() {
        WebElement lowProductBadge = expWait.until(ExpectedConditions.visibilityOfElementLocated(lowStockBadge));
        Log.info("Badge Detail: " + lowProductBadge.getText());
        return lowProductBadge.getText().equals("LOW STOCK");
    }

    public void searchProduct(String product) {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(searchForProduct)).sendKeys(product);

    }

    public boolean seeSuggestedResults() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(suggestedList));
        return driver.findElement(suggestedList).isDisplayed();

    }

    public void clickOnSearchIcon() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(searchIcon)).submit();

    }

    public boolean seeRelatedResults() {
        expWait.until(ExpectedConditions.visibilityOfAllElements(productTiles));
        expWait.until(ExpectedConditions.elementToBeClickable(loadMore));
        driver.findElement(loadMore).click();
        return productTiles.isEmpty();

    }

    public boolean errorMessage() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
        expWait.until(ExpectedConditions.visibilityOfElementLocated(searchAgain)).sendKeys("ter");
        expWait.until(ExpectedConditions.visibilityOfElementLocated(clickOnSearch)).submit();
        expWait.until(ExpectedConditions.visibilityOfElementLocated(returnPage));
        return driver.findElement(returnPage).isDisplayed();
    }


}
