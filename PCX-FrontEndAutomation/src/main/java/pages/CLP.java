package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;
import java.time.Duration;
import java.util.List;

public class CLP {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public CLP(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }
    @FindBy(xpath = "//span[contains(text(), 'Grocery')]") WebElement grocery;
    @FindBy(xpath = "//span[normalize-space()='Home, Beauty & Baby']") WebElement categoryHomeBeautyBaby;
    @FindBy(xpath = "//span[@class='primary-nav__list__item__link__text'][normalize-space()='Pantry']") WebElement categoryPantry;
    @FindBy(xpath = "//span[normalize-space()='Home & Kitchen']") WebElement categoryHome;
    @FindAll(@FindBy(css = "a[data-testid='header-link']")) List <WebElement> shopAll;
    @FindBy(css = "h1[data-testid='heading']") WebElement pageName;
    //CLP Home&Kitchen-category breadcrumb-of-page
    @FindBy(css = "div.breadcrumb-container") WebElement breadcrumb;
    //CLP Home&Kitchen-category sub-categories
    @FindBy(css = "div.chakra-accordion") WebElement subCategories;
    @FindBy(css = "label[id='sort-by']") WebElement sortBy;
    @FindBy(css = "h1[data-testid='heading']") WebElement pageHeading;
    @FindBy(xpath = "//p[normalize-space()='Bath']") WebElement firstCategories;
    @FindBy(xpath = "//a[normalize-space()='Toilet Accessories']") WebElement firstSubCategories;
    //CLP Home&Kitchen-category carousels-on-page
   By carousels = By.cssSelector("div[class='css-1en0kvl'] [data-testid='section']");
   By scrollContainer = By.cssSelector("div[class='indiana-scroll-container']");
    //CLP Home&Kitchen-category product-grid
   By productsGrid = By.cssSelector("div.chakra-linkbox");

   @FindAll(@FindBy(css = "button[data-testid='atc-button']")) List<WebElement> addButtonOnProducts;
   //By addButtonOnProducts = By.cssSelector("button[class='chakra-button css-lmu48k']");

    public void navigateOnCLP() {
        wait.until(ExpectedConditions.visibilityOf(grocery));
        // Commented as this code is required later.
        /*grocery.click();
        wait.until(ExpectedConditions.visibilityOf(categoryPantry));
        actions.moveToElement(categoryPantry).click().perform();*/
        driver.navigate().to("https://www.preprod.loblaws.ca/food/fruits-vegetables/fresh-fruits/mango-pineapple-kiwi/c/29592");

    }
    public void navigateOnCarouselClp() {
        wait.until(ExpectedConditions.visibilityOf(categoryHomeBeautyBaby));
        categoryHomeBeautyBaby.click();
        wait.until(ExpectedConditions.visibilityOf(categoryHome));
        actions.moveToElement(categoryHome).click().perform();
    }
    public boolean validateClpPage(){
        try{
            wait.until(ExpectedConditions.visibilityOfAllElements(shopAll));
            return shopAll.isEmpty();
        }catch(TimeoutException e){
            return false;
        }
    }
    public boolean validateCarousels(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long totalPageHeight = (Long) js.executeScript("return document.body.scrollHeight");
        int browserWindowHeight = driver.manage().window().getSize().getHeight();
        long currentPosition = (Long) js.executeScript("return window.pageYOffset");

        while (totalPageHeight - currentPosition > browserWindowHeight) {
            js.executeScript("window.scrollTo(" + currentPosition + ", " + (browserWindowHeight + currentPosition) + ");");
            currentPosition = (Long) js.executeScript("return window.pageYOffset");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(carousels));
        List<WebElement> allCarousel = driver.findElements(carousels);
        Log.info("All carousel : "+allCarousel.size());
        return !allCarousel.isEmpty();
    }
    public boolean validateEachCarouselIncludeShopAll(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(carousels));
        List<WebElement> allCarousel = driver.findElements(carousels);
        for(WebElement carousel : allCarousel){
            if(!carousel.getText().contains("Shop all"))
                return false;
        }
        return true;
    }
    public boolean validateEachCarouselScrollHorizontally(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(scrollContainer));
        List<WebElement> allScroller = driver.findElements(scrollContainer);
        for(WebElement scroller : allScroller) {
            actions.moveToElement(scroller).clickAndHold().moveByOffset(200, 0).release().perform();
        }
        return true;

    }
    public boolean validateVisibilityOfAddOnEachProduct(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productsGrid));
        wait.until(ExpectedConditions.visibilityOfAllElements(addButtonOnProducts));
        return driver.findElements(productsGrid).size() == addButtonOnProducts.size();
    }
    public boolean validateVisibilityOfEachProductDetail() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productsGrid));
        List<WebElement> products = driver.findElements(productsGrid);
        for (WebElement product : products) {
            if (!product.isDisplayed())
                return false;
        }
        return true;
    }
    public boolean validateVisibilityOfPageName(){
        try {
            wait.until(ExpectedConditions.visibilityOf(pageName));
            Log.info("Page Name: "+pageName.getText());
            return pageName.isDisplayed();
        }catch (TimeoutException e){
            Log.info("pageName is not visible on page");
            return false;
        }
    }
    public boolean validateVisibilityOfBreadcrumb(){
        try {
            wait.until(ExpectedConditions.visibilityOf(breadcrumb));
            return breadcrumb.isDisplayed();
        }catch (TimeoutException e){
            Log.info("Breadcrumb is not visible on page");
            return false;
        }
    }
    public boolean validateVisibilityOfSubCategories(){
        try {
            wait.until(ExpectedConditions.visibilityOf(subCategories));
            return subCategories.isDisplayed();
        }catch (TimeoutException e){
            Log.info("Sub Categories is not visible on page");
            return false;
        }
    }
    public void clickOnShopAll(){
       wait.until(ExpectedConditions.visibilityOfAllElements(shopAll));
       shopAll.get(0).click();
    }
    public boolean validatePLP() {
            wait.until(ExpectedConditions.visibilityOf(sortBy));
            wait.until(ExpectedConditions.visibilityOf(pageHeading));
            Log.info(pageHeading.getText());
            return sortBy.isDisplayed() && pageHeading.isDisplayed();
    }
    public void clickOnFirstSubCategories(){
       wait.until(ExpectedConditions.visibilityOf(firstCategories));
       firstCategories.click();
       wait.until(ExpectedConditions.visibilityOf(firstSubCategories));
       firstSubCategories.click();
    }
}
