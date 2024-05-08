package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Flyers {
    WebDriver driver;
    Random random;

    WebDriverWait wait;
    Actions actions;
    @FindBy(css = "button[data-code='flyers-deals']")
    WebElement flyerNavigationButton;
    @FindBy(css = "a[data-code='/print-flyer']")
    WebElement flyerMenuOption;
    @FindBy(xpath = "//span[@title='All Deals']//ancestor::a")
    WebElement allDealsOption;
    @FindBy(xpath = "//span[@title='Flyer Items']//ancestor::a")
    WebElement flyerItemsOption;
    @FindBy(xpath = "//span[@title='Flyer']//ancestor::a")
    WebElement flyerOption;
    @FindBy(css = "a.flipp-flyer-header__signup-link")
    WebElement signUpReceiveEmail;
    @FindBy(css = "p.flipp-flyer-header__welcome-message")
    WebElement welcomeMessage;
    @FindBy(name = "preferredName")
    WebElement firstNameSignUp;
    @FindBy(name = "email")
    WebElement emailSignUp;
    @FindBy(name = "province")
    WebElement provinceSignUp;
    @FindBy(name = "familyName")
    WebElement familyNameSignUp;
    @FindBy(css = "h1.digital-flyer-subscriptions-form-success-message__title")
    WebElement sucessMessage;
    @FindBy(css = "input#optInStatus")
    WebElement optInSignUp;
    @FindBy(css = "button.digital-flyer-subscriptions-form__form__submit--button")
    WebElement submitSignUpFormButton;
    @FindAll(@FindBy(css = "sfml-flyer-image div button "))
    List<WebElement> flyerButtonImages;
    @FindBy(css = "div.product-image-list img")
    WebElement imageFlyerDialogBox;
    @FindBy(css = "div.product-button-group button")
    WebElement addToCartDialogBox;
    @FindBy(css = "input.quantity-selector__quantity__input")
    WebElement quantitySelectorDialogBox;
    @FindBy(css = "span.cart-item-count__text")
    WebElement cartAmountTextBox;
    @FindBy(css = "iframe.mainframe")
    WebElement frameFlipp;
    @FindAll(@FindBy(css = "div.product-badge__icon__text"))
    List<WebElement> productBadgeFlyerAllDeals;
    By productBadgeLoyalty = By.cssSelector("div.product-badge--loyalty");
    @FindAll(@FindBy(css = "div.product-tracking"))
    List<WebElement> productTiles;
    @FindAll(@FindBy(css = "div[data-testid=\"product-grid\"] div.css-0 a")) List<WebElement> productLink;
    @FindAll(@FindBy(xpath = "//div[@class='product-tracking']"))
    List<WebElement> productTilesXpath;

    public Flyers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }

    public void visitFlyerPage() {
        wait.until(ExpectedConditions.visibilityOf(flyerNavigationButton));
        actions.moveToElement(flyerNavigationButton).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(flyerMenuOption));
        flyerMenuOption.click();
    }

    public boolean validateTabs() {
        wait.until(ExpectedConditions.visibilityOf(allDealsOption));
        return allDealsOption.isDisplayed() && flyerItemsOption.isDisplayed() && flyerOption.isDisplayed();
    }

    public boolean validateSignUpEmail() {
        wait.until(ExpectedConditions.visibilityOf(signUpReceiveEmail));
        return signUpReceiveEmail.isDisplayed();
    }

    public boolean validateWelcomeMessage() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        return welcomeMessage.isDisplayed();
    }

    public void selectTheProvinceRandomly() {
        wait.until(ExpectedConditions.visibilityOf(provinceSignUp));
        provinceSignUp.click();
        Select select = new Select(provinceSignUp);
        int indexOfStateToBeSelected = random.nextInt(select.getOptions().size());
        if (indexOfStateToBeSelected == 0) {
            indexOfStateToBeSelected = 1;
        }
        select.selectByIndex(indexOfStateToBeSelected);
    }

    public void clickSignUp() {
        wait.until(ExpectedConditions.visibilityOf(signUpReceiveEmail));
        signUpReceiveEmail.click();
    }

    public void fillFirstName() {
        wait.until(ExpectedConditions.visibilityOf(firstNameSignUp));
        firstNameSignUp.sendKeys("Test");
    }

    public void fillLastName() {
        wait.until(ExpectedConditions.visibilityOf(familyNameSignUp));
        familyNameSignUp.sendKeys("Account");
    }

    public void fillEmail() {
        wait.until(ExpectedConditions.visibilityOf(emailSignUp));
        emailSignUp.sendKeys("test" + random.nextInt(1000) + "@yopmail.com");
    }

    public void clickOptInCheckbox() {
        optInSignUp.click();
    }

    public void sumbitSignUpForm() {
        wait.until(ExpectedConditions.visibilityOf(submitSignUpFormButton));
        submitSignUpFormButton.click();
    }

    public boolean validateSucessMessage() {
        wait.until(ExpectedConditions.visibilityOf(sucessMessage));
        return sucessMessage.isDisplayed() && sucessMessage.getText().equals("Thank you for signing up!");
    }

    public void randomlyClickOnFlyerProduct() {
        driver.switchTo().frame(frameFlipp);
        wait.until(ExpectedConditions.visibilityOfAllElements(flyerButtonImages));
        flyerButtonImages.get(random.nextInt(flyerButtonImages.size())).click();
        driver.switchTo().defaultContent();
    }

    public boolean validateImageAndCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCartDialogBox));
        return addToCartDialogBox.isDisplayed() && imageFlyerDialogBox.isDisplayed();
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCartDialogBox));
        addToCartDialogBox.click();
    }

    public boolean validateCartQuantity() {
        wait.until(ExpectedConditions.visibilityOf(cartAmountTextBox));
        return Integer.parseInt(cartAmountTextBox.getText()) >= 1;
    }

    public boolean validateItemQuantityButtonAppear() {
        wait.until(ExpectedConditions.visibilityOf(quantitySelectorDialogBox));
        return Integer.parseInt(quantitySelectorDialogBox.getAttribute("value")) >= 1;
    }

    public void switchToFlyerAllDeals() {
       /* wait.until(ExpectedConditions.visibilityOf(allDealsOption));
        allDealsOption.click();*/
        driver.navigate().to("https://www.preprod.loblaws.ca/deals/all?navid=flyout-L2-All-Deals");
    }

    public boolean validateAllDealsBadge() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productBadgeFlyerAllDeals));
        WebElement allDealBadge = productBadgeFlyerAllDeals.get(random.nextInt(productBadgeFlyerAllDeals.size()));
        Log.info(allDealBadge.getText());
        return allDealBadge.isDisplayed();
    }

    public void clickFlyerItems() {
        /*wait.until(ExpectedConditions.visibilityOf(flyerItemsOption));
        flyerItemsOption.click();*/
        driver.navigate().to("https://www.preprod.loblaws.ca/deals/flyer");
    }

    public boolean validateFlyerItemsVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(productLink));
            return productLink.isEmpty();
        }
        catch (StaleElementReferenceException sere){
            wait.until(ExpectedConditions.visibilityOfAllElements(productTilesXpath));
            return productTilesXpath.isEmpty();
        }
    }
}
