package pages;

import org.openqa.selenium.JavascriptExecutor;
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

public class MyShop {

    WebDriver driver;
    WebDriverWait wait;
    Random random;
    Actions action;
    private static final String CLICK_SCRIPT = "arguments[0].click();";

    //Home-page-header signIn-button
    @FindBy(xpath = "//a[@data-track='headerSignInLink']")
    WebElement signInLink;

    @FindBy(xpath = "//span[normalize-space()='My Shop']")
    WebElement myShopCategory;

    @FindBy(xpath = "//span[normalize-space()='Most Purchased']")
    WebElement mostPurchasedSubCategory;

    @FindBy(xpath = "//span[normalize-space()='Past Orders']")
    WebElement pastOrderSubCategory;

    @FindBy(xpath = "//span[normalize-space()='Aisles']")
    WebElement aislesSubCategory;

    @FindBy(xpath = "//span[normalize-space()='Shopping List']")
    WebElement shoppingListSubCategory;

    @FindBy(css = "div[class='shopping-lists-page-lists-details__info']")
    WebElement saveItemsList;

    @FindBy(css = "button[data-track='myshopViewListButton']")
    WebElement viewListButton;

    @FindBy(className = "product-tile")
    WebElement savedProducts;

    @FindBy(css = "button[data-cruller='quantity-selector-add-to-cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@href='/'][normalize-space()='Sign In']")
    WebElement myShopSignInButton;

    @FindBy(xpath = "//a[normalize-space()='Create an account']")
    WebElement myShopCreateAccountButton;

    @FindBy(css = "div[class='myshop-title myshop-title--anonymous']")
    WebElement signInPromptMessage;

    @FindBy(css = "legend[class='form__legend']")
    WebElement signInPage;

    @FindBy(xpath = "//input[@name='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@name='password']")
    WebElement inputPassword;

    @FindBy(id = "password__error")
    WebElement enterPasswordWarning;

    @FindBy(className = "form-message__content")
    WebElement loginFailedMessage;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    WebElement signIn;

    @FindBy(css = "div[class='my-shop-browse-content__content']")
    WebElement mostPurchasedItems;

    @FindAll(@FindBy(css = "a[data-track='homepageAisleLink']"))
    List<WebElement> merchOnMostPurchased;

    public MyShop(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        random=new Random();
        action = new Actions(driver);
    }

    /**
     * Validates that the user has not logged in to the account
     * and account-sign-in link contains the text "SIGN IN" instead of  "MY ACCOUNT"
     * @return true if the account-sign-in link is visible and contains text "SIGN IN"
     */
    public boolean userIsGuest() {
        wait.until(ExpectedConditions.visibilityOf(signInLink));
        return signInLink.isDisplayed() &&signInLink.getText().contains("SIGN IN");
    }

    public void iClickOnMyShopLink() {
        wait.until(ExpectedConditions.visibilityOf(myShopCategory));
        myShopCategory.click();
        wait.until(ExpectedConditions.visibilityOf(mostPurchasedSubCategory));
        action.moveToElement(mostPurchasedSubCategory).click().build().perform();
    }

    public boolean iAmPromptedToSignIn() {
        wait.until(ExpectedConditions.visibilityOf(myShopSignInButton));
        wait.until(ExpectedConditions.visibilityOf(signInPromptMessage));
        Log.info(signInPromptMessage.getText());
        return myShopSignInButton.isDisplayed() && signInPromptMessage.isDisplayed();
    }

    public boolean iClickOnSignInCta() {
        wait.until(ExpectedConditions.visibilityOf(myShopSignInButton));
        myShopSignInButton.click();
        wait.until(ExpectedConditions.visibilityOf(signInPage));
        Log.info(signInPage.getText());
        return signInPage.isDisplayed();
    }

    public void iAmAbleToEnterMyPcId(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.sendKeys(password);
    }

    public boolean iShouldBeAbleToCreateAccount() {
        wait.until(ExpectedConditions.visibilityOf(myShopCreateAccountButton));
        myShopCreateAccountButton.click();
        wait.until(ExpectedConditions.visibilityOf(signInPage));
        Log.info(signInPage.getText());
        return signInPage.isDisplayed();
    }

    public boolean iSeeRightValidation() {
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.clear();
        inputEmail.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(enterPasswordWarning));
        Log.info(enterPasswordWarning.getText());
        return enterPasswordWarning.isDisplayed() && enterPasswordWarning.getText().contains("Please enter a password.");
    }

    public boolean iSeeLoginFailedValidation(String password) {
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(signIn));
        ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, signIn);
        wait.until(ExpectedConditions.visibilityOf(loginFailedMessage));
        return loginFailedMessage.isDisplayed() && loginFailedMessage.getText().contains("Your email or password was incorrect.");
    }

    public boolean iSeeMyMostPurchasedOrder() {
        wait.until(ExpectedConditions.visibilityOf(mostPurchasedItems));
        return mostPurchasedItems.isDisplayed();
    }

    public boolean iSeeMerchOnMostPurchased() {
        wait.until(ExpectedConditions.visibilityOfAllElements(merchOnMostPurchased));
        for (WebElement merchandise : merchOnMostPurchased) {
            Log.info(merchandise.getText());
        }
        return merchOnMostPurchased.isEmpty();
    }

    public void iClickOnPostOrderLink() {
        wait.until(ExpectedConditions.visibilityOf(myShopCategory));
        myShopCategory.click();
        wait.until(ExpectedConditions.visibilityOf(pastOrderSubCategory));
        action.moveToElement(pastOrderSubCategory).click().build().perform();
    }

    public void iClickOnAisleLink() {
        wait.until(ExpectedConditions.visibilityOf(myShopCategory));
        myShopCategory.click();
        wait.until(ExpectedConditions.visibilityOf(aislesSubCategory));
        action.moveToElement(aislesSubCategory).click().build().perform();
    }

    public void iClickOnShoppingListLink() {
        wait.until(ExpectedConditions.visibilityOf(myShopCategory));
        myShopCategory.click();
        wait.until(ExpectedConditions.visibilityOf(shoppingListSubCategory));
        action.moveToElement(shoppingListSubCategory).click().build().perform();
    }

    public boolean iSeeSaveItems() {
        wait.until(ExpectedConditions.visibilityOf(saveItemsList));
        wait.until(ExpectedConditions.visibilityOf(viewListButton));
        viewListButton.click();
        wait.until(ExpectedConditions.visibilityOf(savedProducts));
        Log.info(savedProducts.getText());
        return savedProducts.isDisplayed();
    }

    public boolean iSeeAddToCartButton() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        return addToCartButton.isDisplayed();
    }
}
