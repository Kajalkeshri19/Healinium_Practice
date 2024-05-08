package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressPass {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    @FindBy (xpath = "//span[normalize-space()='PC Express Pass']")
    WebElement pcExpressNav;

    @FindBy(css = "div[class*='block-hero-content block-hero-content--text-alignment-l']")
    WebElement pcExpressCarousel;

    @FindBy(css = "button[data-cruller='cta-pcx-pass-grocery-cta']")
    WebElement pcExpressSignUp;

    @FindBy(css = "legend[class='form__legend']")
    WebElement pcExpressSignIn;

    @FindBy(css = "a[data-auid='account-login-button']")
    WebElement signInOnNav;

    @FindBy(xpath = "//input[@name='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@name='password']")
    WebElement inputPassword;
    //HomePage (sign in from header) signInButton
    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    WebElement signInButton;

   //HomePage (signIn with PC user) pco-banner-heading-title
    @FindBy(css = "div.tile-heading--pc-optimum")
    WebElement pcoAccountBalance;

    @FindBy(css = "button[class='account__toggle__button']")
    WebElement profileButton;

    @FindBy(css = "a[data-cruller='my-account-pc-express-pass-link']")
    WebElement pcExpressCategory;

    @FindBy(css = "div[class='pc-optimum-layout__main__content']")
    WebElement pcExpressPassInformation;

    @FindBy(css = "div[class='pc-express-pass-payment']")
    WebElement pcExpressPassPayment;

    @FindBy(css = "div[class='pcx-pass-subscription-modal']")
    WebElement pcExpressCallOut;

    @FindBy(css = "button[class='pcx-pass-subscription-item__button']")
    WebElement pcExpressMonthlySelection;

    @FindBy(css = "input[name='streetAddress']")
    WebElement pcExpressInputAddress;

    @FindBy(css = "input[name='city']")
    WebElement pcExpressInputCity;

    @FindBy(css = "select[name='region']")
    WebElement pcExpressInputProvince;

    @FindBy(css = "option[value='CA-QC']")
    WebElement pcExpressProvinceOption;

    @FindBy(css = "input[name='postalCode']")
    WebElement pcExpressInputPostalCode;

    @FindBy(css = "button[class*='common-button common-button--theme-base common-button--theme-p']")
    WebElement pcExpressConfirmButton;

    @FindBy(css = "div[class='pcx-pass-modal-skeleton']")
    WebElement pcExpressConfirmationMessage;

    @FindBy(css = "section[class='pc-express-pass-section pc-express-pass-section--separator']")
    WebElement pcExpressMonthlyInformation;

    public ExpressPass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        action = new Actions(driver);
    }

    public boolean customerIsOnPcExpressPage() {
        wait.until(ExpectedConditions.visibilityOf(pcExpressNav));
        pcExpressNav.click();
        wait.until(ExpectedConditions.visibilityOf(pcExpressCarousel));
        Log.info(pcExpressCarousel.getText());
        return pcExpressCarousel.isDisplayed() && pcExpressCarousel.getText().contains("UNLOCK PC EXPRESS PASS.");
    }

    public boolean iSeeSignUpCheck() {
        wait.until(ExpectedConditions.visibilityOf(pcExpressSignUp));
        Log.info(pcExpressSignUp.getText());
        return pcExpressSignUp.isDisplayed() && pcExpressSignUp.getText().contains("SIGN UP");
    }

    public void iClickPcExpressSignUp() {
        wait.until(ExpectedConditions.visibilityOf(pcExpressSignUp));
        pcExpressSignUp.click();
    }

    public boolean iAmOnPcExpressSignIn() {
        wait.until(ExpectedConditions.visibilityOf(pcExpressSignIn));
        Log.info(pcExpressSignIn.getText());
        return pcExpressSignIn.isDisplayed() && pcExpressSignIn.getText().contains("Sign in with PC™id");
    }

    public void iClickOnSignIn(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(signInOnNav));
        signInOnNav.click();
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInButton);
    }

    public boolean iHavePcoiSubscription() {
        wait.until(ExpectedConditions.visibilityOf(pcoAccountBalance));
        Log.info(pcoAccountBalance.getText());
        return pcoAccountBalance.isDisplayed() && pcoAccountBalance.getText().contains("Your points balance");
    }

    public void iClickOnMyProfile() {
        wait.until(ExpectedConditions.visibilityOf(profileButton));
        profileButton.click();
        action.moveToElement(pcExpressCategory).click().build().perform();
    }

    public boolean iSeePlanSelectionPage() {
        wait.until(ExpectedConditions.visibilityOf(pcExpressPassInformation));
        wait.until(ExpectedConditions.visibilityOf(pcExpressPassPayment));
        Log.info(pcExpressPassInformation.getText());
        String text = pcExpressPassPayment.getText();
        Pattern pattern = Pattern.compile("Ending in \\d{4}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return pcExpressPassInformation.isDisplayed();
        } else {
            return false;
        }
    }

    public boolean iSeePcExpressCallOut() {
        wait.until(ExpectedConditions.visibilityOf(pcExpressCallOut));
        Log.info(pcExpressCallOut.getText());
        return pcExpressCallOut.isDisplayed();
    }

    public void iSelectMonthlyPlan() {
        wait.until(ExpectedConditions.visibilityOf(pcExpressMonthlySelection));
        pcExpressMonthlySelection.click();
    }

    public void iSeeAllRelevantScreens(String address, String city, String postalCode) {
        wait.until(ExpectedConditions.visibilityOf(pcExpressConfirmButton));
        pcExpressConfirmButton.click();
        wait.until(ExpectedConditions.visibilityOf(pcExpressInputAddress));
        pcExpressInputAddress.sendKeys(address);
        wait.until(ExpectedConditions.visibilityOf(pcExpressInputCity));
        pcExpressInputCity.sendKeys(city);
        wait.until(ExpectedConditions.visibilityOf(pcExpressInputProvince));
        pcExpressInputProvince.click();
        wait.until(ExpectedConditions.visibilityOf(pcExpressProvinceOption));
        pcExpressProvinceOption.click();
        wait.until(ExpectedConditions.visibilityOf(pcExpressInputPostalCode));
        pcExpressInputPostalCode.sendKeys(postalCode);
        wait.until(ExpectedConditions.visibilityOf(pcExpressConfirmButton));
        pcExpressConfirmButton.click();
        wait.until(ExpectedConditions.visibilityOf(pcExpressConfirmationMessage));
    }

    public boolean iSeeMonthlyPlanInProfile() {
        wait.until(ExpectedConditions.invisibilityOf(pcExpressNav));
        wait.until(ExpectedConditions.visibilityOf(pcExpressPassInformation));
        Log.info(pcExpressMonthlyInformation.getText());
        return pcExpressMonthlyInformation.isDisplayed() && pcExpressMonthlyInformation.getText().contains("Next billing date:");
    }

}
