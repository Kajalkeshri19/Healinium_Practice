package pages;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;

public class Account {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "a[class='sign-in account__login-link']")
    WebElement signIn;
    @FindBy(xpath = "//a/span[text()='Create a ']")
    WebElement createPCIDButton;
    @FindBy(css = "input[aria-label='Email']")
    WebElement userEmail;
    @FindBy(css = "input[aria-label='Password']")
    WebElement userPass;
    @FindBy(css = "input[aria-label='Confirm password']")
    WebElement confirmPass;
    @FindBy(xpath = "//button[text()='Create a ']")
    WebElement createButton;
    @FindBy(css = "input[id='privacyPolicy']")
    WebElement privacyPolicy;
    @FindBy(css = "input[id='termsAndConditions']")
    WebElement termsAndConditions;
    @FindBy(xpath = "//h1[text()='Complete Your Profile']")
    WebElement completeProfilePage;
    @FindBy(css = "input[id='firstName']")
    WebElement firstName;
    @FindBy(css = "input[id='lastName']")
    WebElement lastName;
    @FindBy(css = "input[id='phoneNumber']")
    WebElement phoneNumber;
    @FindBy(css = "input[id='termsCheckbox']")
    WebElement profileTermCheckBox;
    @FindBy(css = "input[id='privacyCheckbox']")
    WebElement profilePrivacyCheckBox;
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;
    @FindBy(xpath = "//button[text()='Done']")
    WebElement doneButton;
    @FindBy(xpath = "//button[text()='Sign In']")
    WebElement signInButton;
    @FindBy(xpath = "//button[text()='Yes, delete account']")
    WebElement confirmDeleteButton;
    @FindBy(css = "button[class='account__toggle__button']")
    WebElement myAccount;
    @FindBy(css = "a[data-cruller='my-account-profile-link']")
    WebElement myProfile;
    @FindBy(css = "a[data-cruller='my-account-payment-link']")
    WebElement myPayment;
    @FindBy(css = "a[data-cruller='my-account-preference-link']")
    WebElement myPreference;
    @FindBy(css = "button[data-cruller='my-account-sign-out-link']")
    WebElement signOutButton;
    @FindBy(xpath = "//button[text()='Delete PC Express™ account']")
    WebElement deleteAccountButton;
    @FindBy(xpath = "//label[@class='input-checkbox__icon']//*[name()='svg']")
    WebElement deleteAccountAgreeCheckBox;
    @FindBy(css = "input[id='deleteAccount']")
    WebElement acceptDeleteAccountCheckBox;
    @FindBy(css = "div[class*='delete-account-confirmation']")
    WebElement deleteAccountConfirmationMessage;
    @FindBy(xpath = "//a/span[text()='Sign In']")
    WebElement signInWithExitingAccount;
    @FindBy(xpath = "//h2[text()='PC™id Account Details']")
    WebElement accountDetailHeading;
    @FindBy(xpath = "//a[text()='Manage your PC™id account']")
    WebElement managePCIDAccountButton;
    @FindBy(css = "input[id='streetAddress']")
    WebElement streetAddress;
    @FindBy(css = "input[id='city']")
    WebElement city;
    @FindBy(css = "input[id='postalCode']")
    WebElement postalCode;
    @FindBy(css = "select[id='region']")
    WebElement selectRegion;
    @FindBy(xpath = "//option[text()='Quebec']")
    WebElement quebecOption;
    @FindBy(xpath = "//button[text()='Save & Continue']")
    WebElement saveAddressButton;
    @FindBy(css = "input[id='pas_ccnum']")
    WebElement cardNumber;
    @FindBy(css = "input[id='pas_expiry']")
    WebElement cardExpireDate;
    @FindBy(css = "input[id='pas_cccvc']")
    WebElement securityCode;
    @FindBy(css = "input[id='pas_ccname']")
    WebElement cardholderName;
    @FindBy(css = "button[id='rxp-primary-btn']")
    WebElement processing;
    @FindBy(css = "div[class='account-profile-details__account__email']")
    WebElement myProfileId;
    @FindBy(css = "div[class='card card--account-payment-cards-list']")
    WebElement savedCard;
    @FindBy(css = "div[class='account-preferences-deals-and-news__main__content__container__info']")
    WebElement myPreferenceAccount;
    @FindBy(xpath = "//span[@class='card__content__item__wrapper__details__primary']")
    WebElement firstCard;
    @FindBy(xpath = "//div[3]//div[2]//div[1]//button[1]")
    WebElement removeCard;
    @FindBy(xpath = "//div[@class='site-layout__content']//div[3]//div[2]//div[1]//button[1]")
    WebElement removePrimaryCard;
    @FindBy(xpath = "//button[@id='confirm']")
    WebElement confirmationMessage;
    @FindBy(xpath = "//h2[normalize-space()='Saved credit cards']")
    WebElement savedCreditCards;
    @FindBy(xpath = "//button[normalize-space()='ADD A CARD']")
    WebElement addACard;
    @FindBy(xpath = "//h2[normalize-space()='Add Credit Card: Billing Address']")
    WebElement addBillingAddress;
    @FindBy(xpath = "//input[@id='primaryCard']")
    WebElement makeAsPrimaryCard;
    @FindBy(xpath = "//a[@class='my-account-form__link'][normalize-space()='PC Optimum']")
    WebElement pCOptimum;
    @FindBy(xpath = "//button[@aria-label='Manage your PC Optimum™ account']")
    WebElement joinPCOLink;
    @FindBy(xpath = "//p[@class=\"plp__subHeading__2vFZU\"]")
    WebElement getInformationOfPCO;
    @FindBy(xpath = "//p[@class='plp__userEmail__1UpQb']")
    WebElement emailOnPCO;
    @FindBy(xpath = "//p[@class=\"plp__accountValues__1UvCj plp__redText__3Rq2q\"]")
    WebElement pointsOnPCO;
    @FindBy(xpath = "//p[@class=\"plp__accountValues__1UvCj\"]")
    WebElement redeemableValueOnPCO;
    @FindBy(xpath = "//button[@aria-label=\"Manage your PC Optimum™ account\"]")
    WebElement manageYourPCIdInformationOnPCO;
    @FindBy(xpath = "//a[normalize-space()='PCOptimum.ca']")
    WebElement pcOptimumCa;
    @FindBy(xpath = "//div[@class='breadcrumb form__breadcrumb']")
    WebElement pcOptimumPage;
    @FindBy(xpath = "//body/div[@id='__next']/div[@class='layout-container']/div[@role='main']/div[@class='layout__secondary-cta']/a[@class='link link--theme-base link--inline']/span[1]")
    WebElement createNewId;
    @FindBy(xpath = "//h2[normalize-space()='Payment']")
    WebElement payment;

    public Account(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean validateVisibilityOfSignInButton() {
        try {
            wait.until(ExpectedConditions.visibilityOf(signIn));
            return signIn.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("Sign in button not found on page");
            return false;
        }
    }

    public void clickOnSign() {
        wait.until(ExpectedConditions.visibilityOf(signIn));
        signIn.click();
    }

    public void signIn(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(userEmail));
        userEmail.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        userEmail.sendKeys(email);
        userPass.sendKeys(password);
        signInButton.click();
    }

    public void createNewPCID(String email, String password) {
        clickOnSign();
        createPCIDAccount(email, password);
        competeProfile(email, password);
    }

    public void createPCIDAccount(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(createPCIDButton));
        createPCIDButton.click();
        wait.until(ExpectedConditions.visibilityOf(createButton));
        wait.until(ExpectedConditions.visibilityOf(userEmail));
        userEmail.sendKeys(email);
        userPass.sendKeys(password);
        confirmPass.sendKeys(password);
        privacyPolicy.click();
        termsAndConditions.click();
        scrollPage();
        createButton.click();
    }

    public void competeProfile(String email, String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(completeProfilePage));
        } catch (TimeoutException e) {
            wait.until(ExpectedConditions.visibilityOf(signInWithExitingAccount));
            signInWithExitingAccount.click();
            signIn(email, password);
            wait.until(ExpectedConditions.visibilityOf(completeProfilePage));
        }
        firstName.sendKeys("Prod");
        lastName.sendKeys("Testing");
        phoneNumber.sendKeys("1234567890");
        profileTermCheckBox.click();
        profilePrivacyCheckBox.click();
        continueButton.click();
    }

    public void signOutAfterCreateAccount() {
        wait.until(ExpectedConditions.visibilityOf(myAccount));
        myAccount.click();
        wait.until(ExpectedConditions.visibilityOf(signOutButton));
        signOutButton.click();
    }

    public void loginWithCreatedId(String email, String password) {
        clickOnSign();
        signIn(email, password);
    }

    public void viewProfile() {
        wait.until(ExpectedConditions.visibilityOf(myAccount));
        myAccount.click();
        wait.until(ExpectedConditions.visibilityOf(myProfile));
        myProfile.click();
    }

    public boolean validateMyAccountAssociatedWithPCID() {
        wait.until(ExpectedConditions.visibilityOf(accountDetailHeading));
        return accountDetailHeading.getText().contains("PC™id") && managePCIDAccountButton.isDisplayed();
    }

    public void deleteAccount(String email, String password) {
        viewProfile();
        wait.until(ExpectedConditions.visibilityOf(deleteAccountButton));
        deleteAccountButton.click();
        signIn(email, password);
        wait.until(ExpectedConditions.visibilityOf(deleteAccountAgreeCheckBox));
        acceptDeleteAccountCheckBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
        wait.until(ExpectedConditions.visibilityOf(confirmDeleteButton));
        confirmDeleteButton.click();
    }

    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long totalPageHeight = (Long) js.executeScript("return document.body.scrollHeight");
        int browserWindowHeight = driver.manage().window().getSize().getHeight();
        long currentPosition = (Long) js.executeScript("return window.pageYOffset");

        while (totalPageHeight - currentPosition > browserWindowHeight) {
            js.executeScript("window.scrollTo(" + currentPosition + ", " + (browserWindowHeight + currentPosition) + ");");
            currentPosition = (Long) js.executeScript("return window.pageYOffset");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    public boolean deleteAccountConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOf(deleteAccountConfirmationMessage));
        Log.info(deleteAccountConfirmationMessage.getText());
        boolean result = deleteAccountConfirmationMessage.isDisplayed();
        doneButton.click();
        return result;
    }

    public boolean validateVisibilityOfProfilePage() {
        wait.until(ExpectedConditions.visibilityOf(completeProfilePage));
        Log.info(completeProfilePage.getText());
        return completeProfilePage.isDisplayed();
    }

    public void viewMyAccount(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(myAccount));
        myAccount.click();
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void addBillingAddress() {
        wait.until(ExpectedConditions.visibilityOf(streetAddress));
        streetAddress.sendKeys("6 Leslie St, Toronto, ON, M4M 3H7");
        city.sendKeys("Toronto");
        postalCode.sendKeys("M4M 3H7");
        selectRegion.click();
        wait.until(ExpectedConditions.visibilityOf(quebecOption));
        quebecOption.click();
        saveAddressButton.click();
    }

    public void addCreditCardDetail() {
        wait.until(ExpectedConditions.visibilityOf(cardNumber));
        cardNumber.sendKeys("4263970000005262");
        cardExpireDate.sendKeys("08/29");
        securityCode.sendKeys("400");
        cardholderName.sendKeys("Test Account");
        processing.click();
    }

    public void addAllInformation() {
        viewMyAccount(myPayment);
        addBillingAddress();
    }

    public boolean validateMyProfile(String email) {
        viewMyAccount(myProfile);
        wait.until(ExpectedConditions.visibilityOf(myProfileId));
        return myProfileId.getText().contains(email);
    }

    public boolean validateMyPayment() {
        viewMyAccount(myPayment);
        wait.until(ExpectedConditions.visibilityOf(savedCard));
        return savedCard.isDisplayed();
    }

    public boolean validateMyPreferences(String email) {
        viewMyAccount(myPreference);
        wait.until(ExpectedConditions.visibilityOf(myPreferenceAccount));
        return myPreferenceAccount.getText().contains(email);
    }

    public boolean validateAllDetail(String email) {
        return validateMyProfile(email) && validateMyPreferences(email);
    }

    public void navigateToPayment() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccount));
        myAccount.click();
        wait.until(ExpectedConditions.elementToBeClickable(myPayment));
        myPayment.click();
    }

    public boolean validateSavedCardDetails() {
        wait.until(ExpectedConditions.visibilityOf(savedCreditCards));
        Log.info(savedCreditCards.getText());
        return savedCreditCards.isDisplayed() && savedCreditCards.getText().contains("Ending in 5262");
    }

    public boolean addACard() {
        wait.until(ExpectedConditions.elementToBeClickable(addACard));
        addACard.click();
        wait.until(ExpectedConditions.visibilityOf(addBillingAddress));
        return addBillingAddress.isDisplayed();
    }

    public boolean cardAsPrimaryCard() {
        wait.until(ExpectedConditions.elementToBeClickable(makeAsPrimaryCard));
        makeAsPrimaryCard.click();
        return makeAsPrimaryCard.isDisplayed();

    }

    public boolean saveTheCard() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
        wait.until(ExpectedConditions.visibilityOf(savedCreditCards));
        return savedCreditCards.isDisplayed();

    }

    public boolean validatePrimaryCardDetails() {
        wait.until(ExpectedConditions.visibilityOf(firstCard));
        Log.info(firstCard.getText());
        return savedCreditCards.isDisplayed() && firstCard.getText().contains("primary");
    }

    public boolean removeSavedCard() {
        wait.until(ExpectedConditions.elementToBeClickable(removeCard));
        removeCard.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmationMessage));
        confirmationMessage.click();
        wait.until(ExpectedConditions.visibilityOf(savedCreditCards));
        return savedCreditCards.isDisplayed();
    }

    public boolean removePrimaryCard() {
        wait.until(ExpectedConditions.elementToBeClickable(removePrimaryCard));
        removePrimaryCard.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmationMessage));
        confirmationMessage.click();
        wait.until(ExpectedConditions.visibilityOf(savedCreditCards));
        return savedCreditCards.isDisplayed();
    }

    public void goToPCOptimum() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccount));
        myAccount.click();
        wait.until(ExpectedConditions.visibilityOf(pCOptimum));

    }

    public boolean validateTheJoinLinkOnPCO() {
        wait.until(ExpectedConditions.visibilityOf(joinPCOLink));
        return joinPCOLink.isDisplayed();
    }

    public boolean validateTheInformationOnPCOPage() {
        wait.until(ExpectedConditions.visibilityOf(getInformationOfPCO));
        return emailOnPCO.isDisplayed() && pointsOnPCO.isDisplayed() && redeemableValueOnPCO.isDisplayed() && manageYourPCIdInformationOnPCO.isDisplayed();
    }

    public boolean goToPcOptimumCa() {
        wait.until(ExpectedConditions.elementToBeClickable(pcOptimumCa));
        pcOptimumCa.click();
        wait.until(ExpectedConditions.visibilityOf(pcOptimumPage));
        return pcOptimumCa.isDisplayed();

    }

    public boolean registerNewAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(createNewId));
        createNewId.click();
        return pcOptimumPage.isDisplayed();

    }

    public boolean validateBillingInfo() {
        wait.until(ExpectedConditions.visibilityOf(payment));
        return payment.isDisplayed();
    }
    public void onSignInPage(){
        clickOnSign();
        wait.until(ExpectedConditions.elementToBeClickable(createPCIDButton));
    }
}
