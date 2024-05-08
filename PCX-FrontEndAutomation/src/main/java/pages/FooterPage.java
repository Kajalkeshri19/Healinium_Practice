package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.ProjectConfig;
import util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FooterPage {
    WebDriver driver;
    Random random;
    WebDriverWait wait;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = ThreadLocalRandom.current();
        wait = new WebDriverWait(driver, ProjectConfig.DEFAULT_TIMEOUT);
    }
    @FindBy(css = "button.lds__privacy-policy__btnClose")
    WebElement footerClose;
    @FindBy(xpath = "//a[@data-auid='click:all-about-pcx:faqs-link']") WebElement footerFaq;
    @FindBy(css = "div.block-faq__content") WebElement footerPageArea;
    @FindBy(xpath = "//a[@data-auid='click:all-about-pcx:pcx-online-grocery-link']") WebElement footerHowItWorks;
    @FindBy(css = "a[data-track-link-name='aog-how-it-works']") WebElement howItWorksPageArea;
    @FindBy(xpath = "//a[@data-auid='click:all-about-pcx:delivery -link']") WebElement footerDelivery;
    @FindBy(css = "button[data-track='contentfulCTAButton']") WebElement deliveryStartShoppingButton;
    @FindBy(xpath = "//a[@data-auid='click:all-about-pcx:pickup-link']") WebElement footerPickup;
    @FindBy(xpath = "//a[@id='66ppBiwQoQqRCJGAw9n7fP']") WebElement pickupShopRapidDelivery;
    @FindBy(xpath = "//a[@data-auid='click:all-about-pcx:go-green-link']") WebElement reusableBoxSwap;
    @FindBy(xpath = "//div[@data-cms-id='3a6dWk7hoKN71mjGNFofoo']") WebElement theReusableBoxSwap;
    @FindBy(xpath = "//div[@data-cms-id='19NUCchIhii0XEvizm1Z63']") WebElement bringYourOwnBags;
    @FindBy(xpath = "//div[@data-track-product-component='product-details']") WebElement productDetail;
    @FindBy(xpath = "//a[@data-auid='click:about-us:who-we-are-link']") WebElement footerWhoWeAre;
    @FindBy(xpath = "//a[@id='3hudqjQdp4WHUTS2c7DIX3']") WebElement startShoppingButtonOnWhoWeArePage;
    @FindBy(xpath = "//a[@id='4uZgNSiCvyln5sQY8YEETU']") WebElement chooseYourLocationOnWhoWeArePage;
    @FindBy(xpath = "//a[@data-auid='click:about-us:charity-community-link']") WebElement footerCharityCommunityLink;
    @FindBy(css = "nav.Header_nav__6OWqP") WebElement pcChildrenCharityHeader;
    @FindBy(xpath = "//a[@data-auid='click:about-us:corporate-social-responsibility-link']") WebElement footerSocialResponsibility;
    @FindBy(css = "div.navbar-submenu") WebElement socialResponsibilityPageHeader;
    @FindBy(xpath = "//a[@data-auid='click:about-us:partner-stores-link']") WebElement footerPartnerStores;
    By storeList = By.cssSelector("div.element-tile--block-style-browse-by");
    @FindBy(xpath = "//a[@data-auid='click:about-us:store-locator-link']") WebElement footerStoreLocator;
    @FindBy(css = "input.location-search__search__input") WebElement searchInStoreLocatorPage;
    @FindBy(css = "ul.location-list") WebElement locationsList;
    @FindBy(css = " input.location-search__search__input") WebElement locationSearchInput;
    @FindBy(xpath = "//a[@data-auid='click:about-us:contact-us-link']") WebElement contactUs;
    @FindBy(css = "h1.contact-us-page__header__title") WebElement contactUsHeading;
    @FindBy(css = "select.contact-us-form__form__dropdown-field__select") WebElement emailUsDropDown;
    @FindBy(css = "label.contact-us-form__form__dropdown-field__label") WebElement emailUsDropDownSubHeading;
    @FindBy(css = "button.contact-us-form__form__action__submit-btn--button") WebElement emailUsSubmitButton;
    @FindBy(css = "h2.contact-us-contact-info__header") WebElement callUsHeading;
    By callUsDetails = By.cssSelector("div.contact-us-contact-info__contact-us-contact-info__header");
    @FindBy(xpath = "//a[@data-auid='click:about-us:careers-link']") WebElement footerCareers;
    @FindBy(xpath = "//a[@data-auid='click:shop-popular-categories:weekly-flyer-link']") WebElement footerWeeklyFlyer;
    @FindBy(css = "a[href='/print-flyer']") WebElement flyersPageHeading;
    @FindBy(css = "div.location-pickup-confirmation__title") WebElement pickupConfirmationTitle;
    @FindBy(css = "div.flipp-flyer-header") WebElement notificationHeadline;
    @FindBy(xpath = "//a[@data-auid='click:shop-popular-categories:fruits-vegetables-link']") WebElement footerFruitsAndVegetables;
    @FindBy(css = "h1.chakra-heading") WebElement pageHeading;
    @FindBy(css = "p.css-tr0511") WebElement vegSubHeading;
    @FindBy(xpath = "//a[@data-auid='click:shop-popular-categories:dairy-eggs-link']") WebElement footerDairyAndEggs;
    @FindBy(css = "h2.chakra-heading") WebElement subHeading;
    @FindBy(xpath = "//a[@data-auid='click:shop-popular-categories:pantry-link']") WebElement footerPantry;
    @FindBy(xpath = "//a[@data-auid='click:shop-popular-categories:meat-link']") WebElement footerMeat;
    @FindBy(xpath = "//a[@data-auid='click:shop-popular-categories:bakery-link']") WebElement footerBakery;
    @FindBy(xpath = "//a[@data-auid='click:shop-popular-categories:joe-fresh-link']") WebElement footerJoeFresh;
    @FindBy(xpath = "//a[@data-auid='click:more-services:gift-cards-link']") WebElement footerGiftCards;
    @FindBy(xpath = "//a[@data-auid='click:more-services:pharmacy-link']") WebElement footerPharmacyPage;
    @FindBy(xpath = "//a[@data-auid='click:more-services:photo-lab-link']") WebElement footerPhotoLabPage;
    @FindBy(xpath = "//a[text()='PC Financial®']") WebElement footerPcFinancialPage;
    @FindBy(xpath = "//a[@data-auid='click:more-services:recipes-link']") WebElement footerRecipesPage;
    @FindBy(xpath = "//a[@data-auid='click:partner-with-us:advertise-with-loblaw-media-link']") WebElement footerAdvertisePage;
    @FindBy(xpath = "//a[@data-auid='click:more-services:pcoi-link']") WebElement footerPcOptimumInsiderPage;
    @FindBy(xpath = "//span[text()='How it works']") WebElement textHowItWorks;
    @FindBy(xpath = "//h2//span[text()='Flexible grocery delivery, ready when you are.']") WebElement textHowDeliveryWorks;
    @FindBy(xpath = "//div[text()= 'Shop Reusable Boxes    ']//parent::a") WebElement shopReusableBoxesButton;
    @FindBy(css="h1[data-testid='heading']") WebElement clpHeading;
    @FindAll(@FindBy(css = "div.chakra-linkbox")) List<WebElement> productTiles;
    @FindBy(css = "span[title='Flyer Items']") WebElement flyerTabTitle;

    private final static String CLICK_SCRIPT="arguments[0].click();";


    public void closeFooterNotification() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(footerClose));
        try {
            footerClose.click();
        } catch (ElementClickInterceptedException ecee) {
            ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, footerClose);

        }
    }
    public void closeFooterNotificationWithRetry(){
                wait.until(ExpectedConditions.visibilityOf(footerClose));
                ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, footerClose);
    }


    public void goToFaqPage() {
        wait.until(ExpectedConditions.elementToBeClickable(footerFaq));
        try {
            footerFaq.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerFaq);
        }
    }

    public boolean validateFaqPage() {
        wait.until(ExpectedConditions.visibilityOf(footerPageArea));
        String currentUrl=driver.getCurrentUrl();
        return footerPageArea.isDisplayed() && currentUrl.contains("/faq?icta=click:all-about-pcx:faqs");
    }

    public void goToHowItWorksPage() {
        wait.until(ExpectedConditions.elementToBeClickable(footerHowItWorks));
        try {
            footerHowItWorks.click();
        }
        catch (ElementClickInterceptedException ec){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerHowItWorks);
        }
    }

    public boolean validateHowItWorksPage() {
        wait.until(ExpectedConditions.urlContains("all-about-pcx"));
        return driver.getCurrentUrl().contains("all-about-pcx");
    }

    public void goToDeliveryPage() {
        wait.until(ExpectedConditions.elementToBeClickable(footerDelivery));
        try {
            footerDelivery.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerDelivery);
        }
    }

    public boolean validateDeliveryPage() {
        wait.until(ExpectedConditions.visibilityOf(deliveryStartShoppingButton));
        return deliveryStartShoppingButton.isDisplayed() && textHowDeliveryWorks.isDisplayed();
    }

    public void goToPickupPage() {
        wait.until(ExpectedConditions.elementToBeClickable(footerPickup));
        try {
            footerPickup.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerPickup);
        }
    }

    public boolean validatePickupPage() {
        wait.until(ExpectedConditions.urlContains(":pickup"));
        String currentUrl=driver.getCurrentUrl();
        return currentUrl.contains(":pickup");
    }

    public void goToReusableBoxSwapPage() {
        wait.until(ExpectedConditions.elementToBeClickable(reusableBoxSwap));
        try {
            reusableBoxSwap.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,reusableBoxSwap);
        }
    }

    public boolean validateReusableBoxPage() {
        wait.until(ExpectedConditions.visibilityOf(theReusableBoxSwap));
        String currentUrl=driver.getCurrentUrl();
        return theReusableBoxSwap.isDisplayed() &&
                currentUrl.contains("/gogreen?icta=click:all-about-pcx:go-green");
    }

    public boolean validateShopForReusableBags() {
        wait.until(ExpectedConditions.visibilityOf(bringYourOwnBags));
        return bringYourOwnBags.isDisplayed();
    }

    public boolean validateShopReusableBoxedRedirect() {
        wait.until(ExpectedConditions.visibilityOf(shopReusableBoxesButton));
        String currentUrl=driver.getCurrentUrl();
        return shopReusableBoxesButton.isDisplayed() &&
                currentUrl.contains("/box/p/21175631_EA");
    }

    public void goToWhoWeArePage() {
        wait.until(ExpectedConditions.elementToBeClickable(footerWhoWeAre));
        try {
            footerWhoWeAre.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerWhoWeAre);
        }
    }

    public boolean validateWhoWeArePage() {
        wait.until(ExpectedConditions.visibilityOf(startShoppingButtonOnWhoWeArePage));
        String currentUrl=driver.getCurrentUrl();
        return startShoppingButtonOnWhoWeArePage.isDisplayed() &&
                currentUrl.contains("/about?icta=click:about-us:who-we-are");
    }

    public boolean validateStartShoppingButtonWhoWeArePage() {
        wait.until(ExpectedConditions.visibilityOf(startShoppingButtonOnWhoWeArePage));
        String redirectLink = startShoppingButtonOnWhoWeArePage.getAttribute("href");
        String expectedRedirectionLink = "/store-locator?icta=aboutus_findyourstore";
        return redirectLink.contains(expectedRedirectionLink);
    }

    public boolean validateChooseYourLocationPage() {
        wait.until(ExpectedConditions.visibilityOf(chooseYourLocationOnWhoWeArePage));
        String redirectLink = chooseYourLocationOnWhoWeArePage.getAttribute("href");
        String expectedRedirectionLink = "/store-locator?icta=aboutus_findyourstore";
        return redirectLink.contains(expectedRedirectionLink);
    }

    public void goToViewingCharityAndCommunityPage() {
        wait.until(ExpectedConditions.elementToBeClickable(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerCharityCommunityLink));
        try {
            footerCharityCommunityLink.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerCharityCommunityLink);
        }
    }

    public boolean validatePcChildrenCharity() {
        List<String> tabsSecond = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsSecond.get(1));
        wait.until(ExpectedConditions.visibilityOf(pcChildrenCharityHeader));
        String currentUrl=driver.getCurrentUrl();
        return currentUrl.equals("https://www.pcchildrenscharity.ca/");
    }

    public void goToCorporateSocialResponsibilityPage() {
        wait.until(ExpectedConditions.elementToBeClickable(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerSocialResponsibility));
        try {
            footerSocialResponsibility.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerSocialResponsibility);
        }
    }

    public boolean validateResponsibilityPage() {
        List<String> tabsSecond = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsSecond.get(1));
        wait.until(ExpectedConditions.visibilityOf(socialResponsibilityPageHeader));
        String currentUrl=driver.getCurrentUrl();
        return currentUrl.equals("https://www.loblaw.ca/en/responsibility/");
    }

    public void goToPartnerStores() {

        wait.until(ExpectedConditions.elementToBeClickable(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerPartnerStores));
        try {
            footerPartnerStores.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerPartnerStores);
        }
    }

    public boolean validatePartnerStorePage() {
        List<String> tabsSecond = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsSecond.get(1));
        String currentUrl=driver.getCurrentUrl();
        return currentUrl.contains("/our-stores?icta=click:about-us:partner-stores");
    }

    public boolean validateListOfStores() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(storeList));
        return driver.findElements(storeList).isEmpty();
    }

    public void goToStoreLocatorPage() {
        wait.until(ExpectedConditions.elementToBeClickable(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerStoreLocator));
        try {
            footerStoreLocator.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerStoreLocator);
        }
    }

    public boolean validateStoreLocatorPage() {
        wait.until(ExpectedConditions.visibilityOf(searchInStoreLocatorPage));
        String currentUrl=driver.getCurrentUrl();
        return searchInStoreLocatorPage.isDisplayed() &&
                currentUrl.contains("/store-locator?icta=click:about-us:store-locator");
    }

    public boolean validateListOfStoresLocations() {
        wait.until(ExpectedConditions.visibilityOf(locationsList));
        return locationsList.isDisplayed();

    }

    public boolean validateSearchForLocation() {
        wait.until(ExpectedConditions.visibilityOf(locationSearchInput));
        return locationSearchInput.isDisplayed();
    }

    public void goToContactUsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(contactUs));
        try {
            contactUs.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,contactUs);
        }
    }

    public boolean validateContactUsPage() {
        wait.until(ExpectedConditions.visibilityOf(contactUsHeading));
        String currentUrl=driver.getCurrentUrl();
        return contactUsHeading.isDisplayed() &&
                currentUrl.contains("/contact-us?icta=click:about-us:contact-us");
    }

    public boolean validateEmailUsArea() {
        wait.until(ExpectedConditions.elementToBeClickable(emailUsDropDown));
        return emailUsDropDown.isDisplayed() && emailUsSubmitButton.isDisplayed() &&
                emailUsSubmitButton.getText().equals("Submit") &&
                emailUsDropDownSubHeading.getText().equals("What would you like to contact us for:");
    }

    public boolean validateCallUsArea() {
        wait.until(ExpectedConditions.elementToBeClickable(callUsHeading));
        wait.until(ExpectedConditions.visibilityOfElementLocated(callUsDetails));
        for (int iterator = 0; iterator < driver.findElements(callUsDetails).size(); iterator++) {
            if (driver.findElements(callUsDetails).get(iterator).getText().matches(".*(CUSTOMER RELATIONS CENTRE|PC EXPRESS|MARKETPLACE|WRITE TO US).*")) {
                return true;
            }
        }
        return false;
    }

    public void goToCareersPage() {
        wait.until(ExpectedConditions.elementToBeClickable(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerCareers));
        try {
            footerCareers.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerCareers);
        }
    }

    public boolean validateCareersPage() {
        List<String> tabsSecond = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsSecond.get(1));
        String currentUrl=driver.getCurrentUrl();
        return currentUrl.contains("/life-at-loblaw/");
    }

    public void goToWeeklyFlyerPage() {
        wait.until(ExpectedConditions.elementToBeClickable(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerWeeklyFlyer));
        try {
            footerWeeklyFlyer.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerWeeklyFlyer);
        }
    }

    public boolean validateWeeklyFlyerPage() {
        wait.until(ExpectedConditions.visibilityOf(clpHeading));
        return clpHeading.getText().equals("Flyer Items") && driver.getCurrentUrl().contains("/deals/flyer?icta=click:shop-popular-categories:weekly-flyer");
    }

    public boolean validateFlayerPageArea() {
        wait.until(ExpectedConditions.visibilityOf(flyersPageHeading));
        flyersPageHeading.click();
        wait.until(ExpectedConditions.visibilityOf(notificationHeadline));
        Log.info(notificationHeadline.getText());
        return notificationHeadline.getText().contains("Welcome! Please click on the product tile to add items to your cart and view details.");
    }


    public void goToFruitsAndVegetablesPage() {
        wait.until(ExpectedConditions.visibilityOf(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerFruitsAndVegetables));
        try {
            footerFruitsAndVegetables.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerFruitsAndVegetables);
        }

    }

    public boolean validateFruitsAndVegetablePage() {
        wait.until(ExpectedConditions.visibilityOf(clpHeading));
        return clpHeading.getText().equals("Fruits & Vegetables");
    }
    public boolean validateProductsVisible() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productTiles));
        return productTiles.isEmpty();
    }

    public void goToDairyEggsPage() {
        wait.until(ExpectedConditions.visibilityOf(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerDairyAndEggs));
        try {
            footerDairyAndEggs.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerDairyAndEggs);
        }

    }

    public boolean validateDairyAndEggsPage() {
        wait.until(ExpectedConditions.visibilityOf(clpHeading));
        return clpHeading.getText().equals("Dairy & Eggs");
    }

    public boolean validateFunctionality(String text) {
        wait.until(ExpectedConditions.visibilityOf(subHeading));
        Log.info(subHeading.getText());
        return subHeading.getText().equals(text);
    }

    public void goToPantryPage() {
        wait.until(ExpectedConditions.visibilityOf(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerPantry));
        try {
            footerPantry.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerPantry);
        }
    }

    public boolean validatePantryPage() {
        wait.until(ExpectedConditions.visibilityOf(clpHeading));
        return clpHeading.getText().equals("Pantry");
    }

    public void goToMeatPage() {
        wait.until(ExpectedConditions.visibilityOf(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerMeat));
        try {
            footerMeat.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerMeat);
        }
    }

    public boolean validateMeatPage() {
        wait.until(ExpectedConditions.visibilityOf(clpHeading));
        return pageHeading.getText().equals("Meat");
    }

    public void goToBakeryPage() {
        wait.until(ExpectedConditions.visibilityOf(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerBakery));
        try {
            footerBakery.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerBakery);
        }
    }

    public boolean validateBakeryPage() {
        wait.until(ExpectedConditions.visibilityOf(clpHeading));
        return clpHeading.getText().equals("Bakery");
    }

    public void goToJoeFreshPage() {
        wait.until(ExpectedConditions.visibilityOf(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerJoeFresh));
        try {
            footerJoeFresh.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerJoeFresh);
        }
    }

    public boolean validateJoeFreshPage() {
        wait.until(ExpectedConditions.visibilityOf(clpHeading));
        return clpHeading.getText().equals("Joe Fresh");
    }

    public void goToGiftCardPage() {
        wait.until(ExpectedConditions.visibilityOf(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerGiftCards));
        try {
            footerGiftCards.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerGiftCards);
        }
    }

    public boolean validateGiftCardsPage() {
        List<String> tabsSecond = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsSecond.get(1));
        String currentUrl=driver.getCurrentUrl();
        return currentUrl.contains("https://www.giftofchoice.ca/en/");
    }

    public void goToPharmacyPage() {
        wait.until(ExpectedConditions.visibilityOf(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerPharmacyPage));
        try {
            footerPharmacyPage.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerPharmacyPage);
        }
    }

    public boolean validatePharmacyPage() {
        String currentUrl=driver.getCurrentUrl();
        return currentUrl.contains("/pharmacy?icta=click:more-services:pharmacy");
    }

    public void goToPhotoLabPage() {
        wait.until(ExpectedConditions.visibilityOf(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerPhotoLabPage));
        try {
            footerPhotoLabPage.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerPhotoLabPage);
        }
    }

    public boolean validatePhotoLabPage() {
        List<String> tabsSecond = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsSecond.get(1));
        String currentUrl=driver.getCurrentUrl();
        return currentUrl.equals("https://www.photolab.ca/en-CA");
    }

    public void goToPcFinancialPage() {
        wait.until(ExpectedConditions.visibilityOf(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerPcFinancialPage));
        try {
            footerPcFinancialPage.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerPcFinancialPage);
        }
    }

    public boolean validatePcFinancialPage() {
        List<String> tabsSecond = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsSecond.get(1));
        String currentUrl=driver.getCurrentUrl();
        return currentUrl.equals("https://www.pcfinancial.ca/en/");
    }

    public void goToRecipesPage() {
        wait.until(ExpectedConditions.visibilityOf(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerRecipesPage));
        try {
            footerRecipesPage.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerRecipesPage);
        }
    }

    public boolean validateRecipesPage() {
        List<String> tabsSecond = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsSecond.get(1));
        String currentUrl=driver.getCurrentUrl();
        return currentUrl.equals("https://www.presidentschoice.ca/recipes");
    }

    public void goToAdvertisePage() {
        wait.until(ExpectedConditions.elementToBeClickable(footerAdvertisePage));
        try{
            footerAdvertisePage.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerAdvertisePage);
        }
    }

    public boolean validateAdvertisePage() {
        List<String> tabsSecond = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsSecond.get(1));
        String currentUrl=driver.getCurrentUrl();
        Log.info(currentUrl);
        return currentUrl.equals("https://www.loblawadvance.ca/");
    }

    public void goToPcOptimumInsiders() {
        wait.until(ExpectedConditions.visibilityOf(footerWhoWeAre));
        wait.until(ExpectedConditions.elementToBeClickable(footerPcOptimumInsiderPage));
        try {
            footerPcOptimumInsiderPage.click();
        }
        catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript(CLICK_SCRIPT,footerPcOptimumInsiderPage);
        }
    }

    public boolean validatePcOptimumInsiderPage() {
        String currentUrl=driver.getCurrentUrl();
        return currentUrl.contains("/loyalty?icta=click:more-services:pcoi");
    }
}