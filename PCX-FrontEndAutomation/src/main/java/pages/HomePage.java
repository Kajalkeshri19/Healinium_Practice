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
import java.util.Random;


public class HomePage {
        WebDriver driver;
        WebDriverWait wait;
        Actions actions;
        Random random;

        public HomePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            actions = new Actions(driver);
            random=new Random();
        }

    @FindBy(css = "a.logo")
    WebElement homePageLogo;
    @FindBy(css = "a[class='sign-in account__login-link']")
    WebElement signIn;
    @FindBy(css = "div.menu-bar__navigation")
    WebElement navigation;
    @FindBy(css = "div[class='slick-slide slick-active slick-current']")
    WebElement headlineBanner;
    @FindBy(xpath = "//h2[contains(text(), 'Shop Categories')]")
    WebElement shopCategories;
    @FindBy(xpath = "//h2[contains(text(), 'Start shopping')]")
    WebElement startShopping;
    @FindBy(xpath = "//h2[contains(text(), 'New Arrivals')]")
    WebElement newArrivalsProductTile;
    @FindBy(css = "div[data-testid='mini-product-tile-carousel-scroller']")
    WebElement startShoppingMiniProductTile;
    @FindBy(css = "div[data-testid='accordion-item']")
    WebElement termsAndConditions;
    @FindBy(css = "div[data-testid='product-grid']")
    WebElement productGrid;
    @FindBy(css = "div.banner-container")
    WebElement bannerContainer;
    @FindBy(css = "button[data-testid='carousel-btn-prev']")
    WebElement carouselPrevButton;
    @FindBy(css = "button[data-testid='carousel-btn-next']")
    WebElement carouselNextButton;
    @FindBy(css = "ul.slick-dots")
    WebElement kebabDots;
    @FindBy(css = "div.flyers-header__header__info__title")
    WebElement flyerHeaderTitle;
    @FindBy(css = "div.css-1tcolzl")
    WebElement categoriesCarousel;
    @FindBy(css = "button[data-cruller='confirm-nearby-location-button']")
    WebElement confirmButton;
    @FindBy(css = "a[aria-label='Shop now Super Duper Sundaes']")
    WebElement shopAll;
    @FindBy(xpath = "//h2[contains(text(), 'Sign in, get rewarded')]")
    WebElement signInInformationCard;
    @FindBy(css = "div[class='tile-heading']")
    WebElement signInInformation;
    @FindBy(css = "button[data-cruller*='cta-homepage-v2-sign-in']")
    WebElement signInButton;
    @FindBy(css = "legend[class='form__legend']")
    WebElement signInPage;
    @FindBy(css = "button[data-track-link-name='cta-homepage-v2-sign-up']")
    WebElement createAccount;

    @FindBy(css = "div[data-cruller='current-location']")
    WebElement fulfillmentOption;

    @FindBy(css = "button[data-testid*='confirm-nearby']")
    WebElement confirmNearby;
    @FindBy(css = "div[class='hero-tile-pickup-shoppable']")
    WebElement fulfillmentLocation;
    @FindBy(css = "p[class='hero-tile-pickup-shoppable__store-hours']")
    WebElement fulfillmentTimings;

    @FindBy(css = "a[data-cruller='cta-homepage-v2-pick-up']")
    WebElement pickUpFulfillmentOption;
    @FindBy(css = "a[data-cruller='cta-homepage-v2-in-store']")
    WebElement inStoreFulfillmentOption;
    @FindBy(css = "a[data-cruller='cta-homepage-v2-delivery']")
    WebElement deliveryFulfillmentOption;
    @FindAll(@FindBy( css = "a[class*='element-cta element-cta--tile-cta-row']"))
    List<WebElement> ctaButtonOnLocationCard;
    @FindBy(css = "a[data-code='/pc-express-pass']")
    WebElement pcxPassNav;
    @FindBy(css = "div[class*='dark block-wrapper--block-column-layout-true ']")
    WebElement pcxPassBanner;
    @FindBy(css = "div[class*='--block-style-regular block-tile-list-overflow-wrapping--block-l']")
    WebElement pcxPassDescription;
    @FindBy(css = "button[data-track-link-name='cta-pcx-pass-grocery-cta']")
    WebElement signUpButton;
    @FindBy(css = "div[class='chakra-container banner-wrapper css-1dkj5z9']")
    WebElement fiftyAndFiftyPcxBanner;
    @FindBy(css = "div[class='banner-content css-zgwnzv']")
    WebElement leftOfPcxBanner;
    @FindBy(css = "h2[data-testid='banner-title']")
    WebElement leftOfPcxBannerTitle;
    @FindBy(css = "p[data-testid='banner-body']")
    WebElement leftOfPcxBannerDescription;
    @FindBy(css = "a[data-testid='banner-promo-button-one']")
    WebElement learnMoreButton;
    @FindBy(css = "img[data-testid='banner-image']")
    WebElement rightOfPcxBannerImage;
    @FindBy(css = "button[data-track-link-name='cta-aog-shop-now']")
    WebElement shopNowButton;
    @FindBy(css = "ul[class='css-99m36d']")
    WebElement fourByFourSlide;
    @FindBy(css = "div[class='css-1kgasmc']")
    WebElement fourContainerImages;
    @FindBy(css = "h3[data-testid='nav-tile-title']")
    WebElement fourContainerTiles;
    @FindBy(css = "p[data-testid='nav-tile-content']")
    WebElement fourContainerDescriptions;
    @FindBy(css = "a[data-testid='nav-tile-cta']")
    WebElement fourContainersShopNowButton;
    @FindBy(css = "h2[data-testid='heading']")
    WebElement pageHeading;
    By startShoppingProductList = By.cssSelector("div.chakra-linkbox");
    By productImage = By.cssSelector("div[data-testid='product-image']");
    By productName = By.className("h3[data-testid='product-title']");
    By salesInformation = By.cssSelector("[data-testid='product-deal-badge']");
    By productPrice = By.cssSelector("div[data-testid='product-price']");
    By changeQuantityButton = By.cssSelector("[data-testid='quantity-button']");
    By categories = By.cssSelector("div[data-testid='card']");
    By categoriesIcon = By.cssSelector("div[data-testid='card-media']");
    By scrollContainer = By.cssSelector("div[class='indiana-scroll-container']");
    By allProductGrid = By.cssSelector("div[data-testid='product-grid']");
    By cardMedia = By.cssSelector("div[data-testid='card-media']");
    By cardContent = By.cssSelector("div[data-testid='card-content']");
    By informationCard = By.cssSelector("div.home-page-hero-single-tile");
    By promotionalWrappers = By.cssSelector("div[data-testid='dividing-section']");
    By fourAcrossPromotionalTiles =  By.cssSelector("li.css-18f0hmm");
    By headerCTA = By.cssSelector("span[class='element-cta__text']");
    By button = By.cssSelector("button");
    By flyerImages = By.cssSelector("div.product-thumbnail-list");
    By flyerCTA = By.cssSelector("a span");
    By separateFourSlideContainers = By.cssSelector("li[class='css-18f0hmm']");

    public boolean validateVisibilityOfSignInButton(){
        try {
            wait.until(ExpectedConditions.visibilityOf(signIn));
            return signIn.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("Sign in button not found on page");
            return false;
        }
    }
     public void scrollDownPage(){
         ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4000)", "");
     }

     public void clickScript(WebElement element) {
         ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
     }

     public boolean validateVisibilityOf(WebElement element){
         try {
             wait.until(ExpectedConditions.visibilityOf(element));
             return element.isDisplayed();
         } catch (TimeoutException e) {
             return false;
         }
     }

    public boolean validateVisibilityOfNavigation(){
      return validateVisibilityOf(navigation);
    }
    public boolean validateVisibilityOfHeadlineBanner(){
        return validateVisibilityOf(headlineBanner);
    }
    public boolean validateVisibilityOfSignInInformationCard(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(informationCard));
        WebElement loggedInInformationCard = driver.findElements(informationCard).get(0);
        return validateVisibilityOf(loggedInInformationCard);
    }
    public boolean validateVisibilityOfFlyersAndDealsInformationCard(){
        try{
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(informationCard));
        WebElement flyerDeals= driver.findElements(informationCard).get(1);
        return validateVisibilityOf(flyerDeals);
    }catch (ArrayIndexOutOfBoundsException e){
        Log.info("Flyer and Deals Card is not found");
        return false;
    }
    }


    public boolean validateVisibilityOfStartShoppingMiniProductTileCarousel(){
        return validateVisibilityOf(startShopping) && validateVisibilityOf(startShoppingMiniProductTile);
    }
    public boolean validateVisibilityOfProductTileCarousels(){
        return validateVisibilityOf(newArrivalsProductTile);
    }
    public boolean validateVisibilityOfFiftyFiftyWrappers(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(promotionalWrappers));
        return !driver.findElements(promotionalWrappers).isEmpty();
    }
    public boolean validateVisibilityOfFourAcrossPromotionalTiles(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fourAcrossPromotionalTiles));
        return !driver.findElements(fourAcrossPromotionalTiles).isEmpty();
    }
    public boolean validateVisibilityOfExpandableTermsAndConditions(){
        return validateVisibilityOf(termsAndConditions);
    }
    public void iClickOnCTAHeadlinePromo(){
        wait.until(ExpectedConditions.visibilityOf(headlineBanner));
        wait.until(ExpectedConditions.visibilityOf(headlineBanner.findElement(headerCTA))).click();
    }
    public boolean validatePromotionalPage(){
        return validateVisibilityOf(bannerContainer) && validateVisibilityOf(productGrid);
    }
    public void iClickOnLeftChevrons(){
        wait.until(ExpectedConditions.visibilityOf(carouselPrevButton));
        carouselPrevButton.click();
    }
    public void iClickOnRightChevrons(){
        wait.until(ExpectedConditions.visibilityOf(carouselNextButton));
        carouselNextButton.click();
    }
    public void iClickOnSecondKebabButton(){
        wait.until(ExpectedConditions.visibilityOf(kebabDots));
        kebabDots.findElements(button).get(1).click();
    }
    public boolean validateVisibilityOfMyShopInformationCard(){
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(informationCard));
            WebElement loggedInInformationCard = driver.findElements(informationCard).get(3);
            return validateVisibilityOf(loggedInInformationCard);
        }catch (ArrayIndexOutOfBoundsException e){
            Log.info("MyShopInformation Card is not found");
            return false;
        }
    }
    public boolean validateVisibilityOfImagesOnFlyersCard(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(informationCard));
        WebElement flyerDeals= driver.findElements(informationCard).get(1);
        return !flyerDeals.findElements(flyerImages).isEmpty();
    }
    public boolean validateVisibilityOfFlyersCardCTA(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(informationCard));
        WebElement flyerDeals= driver.findElements(informationCard).get(1);
        return validateVisibilityOf(flyerDeals.findElement(flyerCTA));
    }
    public boolean validateFlyersCardCTA(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(informationCard));
        WebElement flyerDeals= driver.findElements(informationCard).get(1);
        flyerDeals.findElement(flyerCTA).click();
        wait.until(ExpectedConditions.visibilityOf(flyerHeaderTitle));
        return flyerHeaderTitle.isDisplayed();
    }


    public boolean validateVisibilityOfLocationDetailsForTheOrderInformationCard(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(informationCard));
        WebElement locationCard= driver.findElements(informationCard).get(2);
        return validateVisibilityOf(locationCard);
    }
    public boolean validateVisibilityOfMenuTilesCarouselToShopCategories() {
        return validateVisibilityOf(shopCategories);
    }

    public void iGoToSignInInformationCard() {
            Actions action = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(signInInformationCard));
            action.scrollToElement(signInInformationCard).build().perform();
    }

    public boolean iSeeInformationWhyToSignIn() {
            wait.until(ExpectedConditions.visibilityOf(signInInformation));
            return signInInformation.isDisplayed();
    }

    public boolean aButtonToSignIn() {
            wait.until(ExpectedConditions.visibilityOf(signInButton));
            return signInButton.isDisplayed();
    }

    public String iClickSignIn() {
            wait.until(ExpectedConditions.visibilityOf(signInButton));
            clickScript(signInButton);
            wait.until(ExpectedConditions.visibilityOf(signInPage));
            return driver.getCurrentUrl();
    }

    public boolean iSeeCreateAccountLink() {
            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOf(createAccount));
            return createAccount.isDisplayed();
    }

    public String iClickCreateAccount() {
            wait.until(ExpectedConditions.visibilityOf(createAccount));
            clickScript(createAccount);
            wait.until(ExpectedConditions.visibilityOf(signInPage));
            return driver.getCurrentUrl();
    }

    /**
     * Validates that the current page is home page.
     */
    public boolean validateHomePage() {
        return validateVisibilityOf(homePageLogo);
    }

    public void iHaveSelectedFulfillmentOption() {
        wait.until(ExpectedConditions.visibilityOf(fulfillmentOption));
        clickScript(fulfillmentOption);
        wait.until(ExpectedConditions.visibilityOf(confirmNearby));
        clickScript(confirmNearby);
    }

    public boolean iWillSeeTheFulfillmentSelected() {
        wait.until(ExpectedConditions.visibilityOf(fulfillmentLocation));
        return fulfillmentLocation.isDisplayed() && fulfillmentLocation.getText().contains("Leslie Street");
    }

    public boolean iSeeFulfillmentTimings() {
        wait.until(ExpectedConditions.visibilityOf(fulfillmentTimings));
        return fulfillmentTimings.isDisplayed();
    }

    public boolean iHaveNotSelectedFulfillmentOption() {
         wait.until(ExpectedConditions.visibilityOf(fulfillmentOption));
         return fulfillmentOption.isDisplayed() && fulfillmentOption.getText().contains("FIND A LOCATION");
    }

    public boolean iSeeAllFulfillmentOptionsAvailableToMe() {
        wait.until(ExpectedConditions.visibilityOf(pickUpFulfillmentOption));
        wait.until(ExpectedConditions.visibilityOf(inStoreFulfillmentOption));
        wait.until(ExpectedConditions.visibilityOf(deliveryFulfillmentOption));
        return pickUpFulfillmentOption.isDisplayed() && inStoreFulfillmentOption.isDisplayed() && deliveryFulfillmentOption.isDisplayed() && pickUpFulfillmentOption.getText().contains("Pickup") && inStoreFulfillmentOption.getText().contains("In-store") && deliveryFulfillmentOption.getText().contains("Delivery");
    }

    public void iClickAnyButtonToRedirect() {
        wait.until(ExpectedConditions.visibilityOfAllElements(ctaButtonOnLocationCard));
        ctaButtonOnLocationCard.get(random.nextInt(ctaButtonOnLocationCard.size())).click();
    }

    public boolean iAmOnPcxPassBanner() {
        wait.until(ExpectedConditions.visibilityOf(pcxPassNav));
        clickScript(pcxPassNav);
        wait.until(ExpectedConditions.visibilityOf(pcxPassBanner));
        return pcxPassBanner.isDisplayed();
    }

    public boolean iSeePcxPassDescription() {
        wait.until(ExpectedConditions.visibilityOf(pcxPassDescription));
        return pcxPassDescription.isDisplayed() && pcxPassDescription.getText().contains("Unlimited FREE pickup and delivery");
    }

    public boolean iSeeSignUpButton() {
        wait.until(ExpectedConditions.visibilityOf(signUpButton));
        return signUpButton.isDisplayed() && signUpButton.getText().contains("SIGN UP");
    }


    public String iClickSignUpButton() {
        wait.until(ExpectedConditions.visibilityOf(signUpButton));
        clickScript(signUpButton);
        wait.until(ExpectedConditions.visibilityOf(signInPage));
        return driver.getCurrentUrl();
    }

    public boolean iSeeFiftyAndFiftyPcxBanner() {
        wait.until(ExpectedConditions.visibilityOf(fiftyAndFiftyPcxBanner));
        return fiftyAndFiftyPcxBanner.isDisplayed() && fiftyAndFiftyPcxBanner.getText().contains("PC Express customers");
    }

    public boolean theLeftOfBanner() {
        wait.until(ExpectedConditions.visibilityOf(leftOfPcxBanner));
        return leftOfPcxBannerTitle.getText().contains("PC Express customers") && leftOfPcxBannerDescription.getText().contains("Get started with 20,000 PC Optimum™ points") && learnMoreButton.isDisplayed();
    }
    public boolean validateVisibilityOfListOfCategories(){
        wait.until(ExpectedConditions.visibilityOf(categoriesCarousel));
        return !categoriesCarousel.findElements(categories).isEmpty();
    }
    public boolean validateVisibilityOfIconForEachCategory(){
        wait.until(ExpectedConditions.visibilityOf(categoriesCarousel));
        for(WebElement category : categoriesCarousel.findElements(categories)) {
            if(!validateVisibilityOf(category.findElement(categoriesIcon)))
                return false;
        }
        return true;
    }
    public boolean validateClickingOnAnIconWillDirect(){
        wait.until(ExpectedConditions.visibilityOf(categoriesCarousel));
        categoriesCarousel.findElements(categories).get(0).findElement(categoriesIcon).click();
        return validateVisibilityOf(bannerContainer) && validateVisibilityOf(productGrid);
    }
    public boolean validateVisibilityOfListOfItem(){
        wait.until(ExpectedConditions.visibilityOf(startShoppingMiniProductTile));
        return !startShoppingMiniProductTile.findElements(startShoppingProductList).isEmpty();
    }
    public boolean validateVisibilityOfImageForEachItem(){
        wait.until(ExpectedConditions.visibilityOf(startShoppingMiniProductTile));
        for(WebElement product : startShoppingMiniProductTile.findElements(startShoppingProductList)){
            if(!validateVisibilityOf(product.findElement(productImage)))
                return false;
        }
        return true;
    }
    public boolean validateVisibilityOfProductNameForEachItem(){
        wait.until(ExpectedConditions.visibilityOf(startShoppingMiniProductTile));
        for(WebElement product : startShoppingMiniProductTile.findElements(productName)){
            if(!validateVisibilityOf(product))
                return false;
        }
        return true;
    }
    public boolean validateVisibilityOfProductPriceForEachItem(){
        wait.until(ExpectedConditions.visibilityOf(startShoppingMiniProductTile));
        for(WebElement product : startShoppingMiniProductTile.findElements(startShoppingProductList)){
            if(!validateVisibilityOf(product.findElement(productPrice)))
                return false;
        }
        return true;
    }
    public boolean validateVisibilityOfSalesInformation(){
        wait.until(ExpectedConditions.visibilityOf(startShoppingMiniProductTile));
        for(WebElement productSalesInformation : startShoppingMiniProductTile.findElements(salesInformation)){
            if(validateVisibilityOf(productSalesInformation))
                return true;
        }
        Log.info("No sales information for any product");
        return false;
    }
    public boolean validateVisibilityOfAddButton(){
        wait.until(ExpectedConditions.visibilityOf(startShoppingMiniProductTile));
        for(WebElement product : startShoppingMiniProductTile.findElements(startShoppingProductList)){
            if(!validateVisibilityOf(product.findElement(button)))
                return false;
        }
        return true;
    }
    public void addToCartFirstItemFromStartShoping(){
        wait.until(ExpectedConditions.visibilityOf(startShoppingMiniProductTile));
        WebElement firstProduct = startShoppingMiniProductTile.findElements(startShoppingProductList).get(0);
        firstProduct.findElement(button).click();
        wait.until(ExpectedConditions.visibilityOf(confirmButton)).click();
        wait.until(ExpectedConditions.visibilityOf(startShoppingMiniProductTile));
        firstProduct.findElement(button).click();
    }
    public boolean validateVisibilityOfchangeQuantityButtons(){
        wait.until(ExpectedConditions.visibilityOf(startShoppingMiniProductTile));
        for(WebElement product : startShoppingMiniProductTile.findElements(startShoppingProductList)){
            if(validateVisibilityOf(product.findElement(changeQuantityButton)))
                return true;
        }
        Log.info("Change of quality button is not visible for any product");
        return false;
    }
    public boolean validateTheListOfItemsWillBeHorizontallyScrollable(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(scrollContainer));
        List<WebElement> allScroller = driver.findElements(scrollContainer);
        for(WebElement scroller : allScroller) {
            actions.moveToElement(scroller).clickAndHold().moveByOffset(200, 0).release().perform();
        }
        return true;
    }

    public boolean validateVisibilityOfSideBySideAsConfigure(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(promotionalWrappers));
        WebElement firstWrapper = driver.findElements(promotionalWrappers).get(0);
        return firstWrapper.findElement(categories).isDisplayed() && firstWrapper.findElement(allProductGrid).isDisplayed();
    }
    public boolean validateVisibilityOfBannerWithAnImageTitleAndDescription(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(promotionalWrappers));
        WebElement firstWrapper = driver.findElements(promotionalWrappers).get(0);
        return firstWrapper.findElement(categories).findElement(cardMedia).isDisplayed() && firstWrapper.findElement(categories).findElement(cardContent).isDisplayed();
    }
    public boolean validateVisibilityOfProductGrid(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(promotionalWrappers));
        WebElement firstWrapper = driver.findElements(promotionalWrappers).get(0);
        return firstWrapper.findElement(allProductGrid).isDisplayed();
    }
    public boolean validateVisibilityOfShopAll(){
        return validateVisibilityOf(shopAll);
    }
    public boolean validateShopAllLinkThatWillTakeMeToAHubForThatPromotion() {
        wait.until(ExpectedConditions.visibilityOf(shopAll));
        shopAll.click();
        return validateVisibilityOf(productGrid);
    }
    public boolean theRightOfBanner() {
        wait.until(ExpectedConditions.visibilityOf(rightOfPcxBannerImage));
        return rightOfPcxBannerImage.isDisplayed();
    }

    public String iClickOnLearnMore() {
        wait.until(ExpectedConditions.visibilityOf(learnMoreButton));
        clickScript(learnMoreButton);
        wait.until(ExpectedConditions.visibilityOf(shopNowButton));
        return driver.getCurrentUrl();
    }

    public boolean iViewTheFourPromotionalTiles() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2900)", "");
        wait.until(ExpectedConditions.visibilityOf(fourByFourSlide));
        String slideCount = fourByFourSlide.getText();
        String[] slides = slideCount.split("Shop now");
        int count = slides.length;
        return count == 4;
    }

    public boolean iSeeFourSideBySideContainers() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(separateFourSlideContainers));
        List<WebElement> containers = driver.findElements(separateFourSlideContainers);

        if (containers.size() != 4) {
            return false;
        }

        boolean areSideBySide = true;

        for (int i = 0; i < containers.size() - 1; i++) {
            WebElement currentContainer = containers.get(i);
            WebElement nextContainer = containers.get(i + 1);

            int currentContainerX = currentContainer.getLocation().getX();
            int nextContainerX = nextContainer.getLocation().getX();

            if (nextContainerX <= currentContainerX) {
                areSideBySide = false;
                break;
            }
        }

        return areSideBySide;
    }


    public boolean iSeeImageTileDescriptionAndShopNowButton() {
        wait.until(ExpectedConditions.visibilityOf(fourContainerImages));
        return fourContainerImages.isDisplayed() && fourContainerTiles.isDisplayed() && fourContainerDescriptions.isDisplayed() && fourContainersShopNowButton.isDisplayed();
    }

    public String clickingShopNowWillDirectMeToAppropriatePage () {
        wait.until(ExpectedConditions.visibilityOf(fourContainersShopNowButton));
        clickScript(fourContainersShopNowButton);
        wait.until(ExpectedConditions.visibilityOf(pageHeading));
        return driver.getCurrentUrl();
    }

}
