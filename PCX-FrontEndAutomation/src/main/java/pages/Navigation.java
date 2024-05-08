package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DataDriven;
import util.Log;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Navigation {

    WebDriver driver;
    WebDriverWait wait;

    Actions action;

    Random random;

    private static final String CLICK_SCRIPT = "arguments[0].click();";

    public Navigation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(css = "div[class='desktop-site-header__logo']")
    WebElement storeLogo;

    @FindBy(xpath = "//nav[@aria-label='Main navigation']")
    WebElement mainNavigation;

    @FindBy(xpath = "//input[@placeholder='Search for product']")
    WebElement searchBar;

    @FindBy(css = "div.home-page-hero-single-tile__headline-wrapper--pc-optimum")
    WebElement pcOptimumTile;

    @FindBy(css = "div[class='fulfillment-mode-button__content']")
    WebElement storePickup;

    @FindBy(css = "div[class='fulfillment-mode-button__content__location']")
    WebElement storeLocation;

    @FindBy(css = "div[class*='fulfillment-next-available-times fulfillment-next-available-times--booking-selector_']")
    WebElement deliveryTime;

    @FindBy(css = "span[class='tooltip__circle']")
    WebElement toolTip;
    //Home-page-header signIn-button
    @FindBy(css = "a.account__login-link")
    WebElement signInLink;

    @FindBy(xpath = "//span[normalize-space()='Discover']")
    WebElement mainDiscover;

    @FindAll(@FindBy(css = "button[class='primary-nav__list__item__link']"))
    List<WebElement> navigationCategoriesLinks;

    @FindBy(xpath = "//span[normalize-space()='New Arrivals']")
    WebElement discoverCategory;

    @FindBy(xpath = "//span[normalize-space()='Seasonal Shop']")
    WebElement groceryCategory;

    @FindBy(css = "ul[class='primary-nav__list primary-nav__list--level-2']")
    WebElement subCategory;

    @FindBy(css = "ul[data-code='Baby']")
    WebElement subCategoryInBeauty;

    @FindBy(css = "ul[data-code='fruits-vegetables']")
    WebElement subCategoryInGrocery;

    @FindBy(xpath = "//a[@class='checkout-button checkout-button--cart-summary']")
    WebElement checkoutButton;

    @FindBy(css = "button[data-auid='mini-cart-button']")
    WebElement miniCartButton;

    @FindBy(css = "button[data-code='xp-455-food-departments']")
    WebElement groceryNav;

    @FindBy(xpath = "//span[normalize-space()='Home, Beauty & Baby']")
    WebElement beautyNav;

    @FindBy(xpath = "//span[normalize-space()='Fruits & Vegetables']")
    WebElement fruitsAndVegetablesCategory;

    @FindBy(css = "h1[class='page-title__title']")
    WebElement pageHeading;

    @FindBy(xpath = "//span[normalize-space()='Baby']")
    WebElement babyCategory;

    @FindBy(css = "ul[data-code='xp-455-food-departments']")
    WebElement categoriesInGrocery;

    @FindBy(css = "ul[data-code='xp-455-nonfood-departments']")
    WebElement categoriesInBeauty;

    @FindBy(css = "img[class='dam-asset__image']")
    WebElement adInCategory;

    @FindBy(xpath = "//h2[normalize-space()='Sign in, get rewarded']")
    WebElement pcxHomepageSignInCard;

    @FindBy(xpath = "//div[@role='main']")
    WebElement signInPage;

    @FindBy(css = "div[data-auid='mini-cart-flyout']")
    WebElement miniCartExpand;
    //HomePage Header MyAccountButton
    @FindBy(css = "button.account__toggle__button")
    WebElement myAccountButton;
    //HomePage Header MyAccountButton PcExpressOption (in the drop down list)
    @FindBy(css = "a[data-cruller=\"my-account-pc-express-pass-link\"]")
    WebElement pcExpressPassLink;

    @FindBy(xpath = "//div[@class='mini-cart__flyout__content']")
    WebElement itemsInCart;

    @FindBy(css = "div[class='cart-summary__content__subtotal']")
     WebElement cartSummary;

    @FindBy(css = "div[class='cart-summary__view-cart']")
    WebElement viewCartButton;

    @FindBy(xpath = "//a[@href='/cartReview?icta=cart-flyout-checkout-button']")
    WebElement checkoutInCart;

    @FindBy(xpath = "//input[@name='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@name='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    WebElement signInButton;

    @FindBy(css = "div[class='cart-checkout-sidebar__group__summary__cart-order-summary']")
    WebElement orderSummary;

    @FindAll(@FindBy(css = "ol.chakra-breadcrumb__list a")) List<WebElement> breadCrumbList;
    @FindBy(css = "a[class='chakra-link css-18lvaev']")
    WebElement levelZeroBreadCrumb;

    @FindBy(css = "a[href='/food/pantry/c/28006']")
    WebElement levelOneBreadCrumb;

    @FindBy(css = "a[href*='/food/pantry/cereal-granola-bars/c']")
    WebElement levelTwoBreadCrumb;

    @FindBy(css = "li[data-item-id='breadcrumb-item-current']")
    WebElement currentLevelBreadCrumb;

    @FindBy(css = "h1[data-testid='heading']")
    WebElement pageTitle;

    @FindBy(xpath = "//a[normalize-space()='Shop all']")
    WebElement shopAll;

    @FindBy(css = "a[href*='/food/pantry/cereal-granola-bars/h']")
    WebElement levelThreeBreadCrumbCategory;

    @FindBy(css = "li[class*='breadcrumbs__list__item--isLast']")
    WebElement productNameOnBreadcrumb;

    @FindBy(css = "a[title='home']")
    WebElement levelZeroBreadCrumbOnPdp;

    @FindBy(css = "div.breadcrumbs a[href*='/food/c']")
    WebElement levelOneBreadCrumbOnPdp;

    @FindBy(css = "a[href='/food/pantry/c/28006']")
    WebElement levelTwoBreadCrumbOnPdp;

    @FindBy(css = "a[href*='/cereal']")
    WebElement levelThreeBreadCrumbOnPdp;
    @FindAll(@FindBy(css = "a.breadcrumb")) List<WebElement> pdpBreadcrumbs;

    By mainNavItems = By.cssSelector("button[class*='primary-nav__list__item__link']");

    By productTile = By.cssSelector("div.chakra-linkbox");
    public static final String SHEET_NAME="TestData";


    public boolean iAmOnPcxHomePage() {
            wait.until(ExpectedConditions.visibilityOf(pcxHomepageSignInCard));
            Log.info(pcxHomepageSignInCard.getText());
            return pcxHomepageSignInCard.getText().contains("Sign in, get rewarded");
    }


   public boolean navWillDisplayAtTopOfPage() {
           wait.until(ExpectedConditions.visibilityOf(mainNavigation));
           return mainNavigation.isDisplayed();
   }

   public boolean iSeeStoreLogo() {
           wait.until(ExpectedConditions.visibilityOf(storeLogo));
           return storeLogo.isDisplayed();
   }

   public boolean iSeeSearchBar() {
           wait.until(ExpectedConditions.visibilityOf(searchBar));
           return searchBar.isDisplayed();
   }

   public boolean iSeeRecommendedPickup() {
           wait.until(ExpectedConditions.visibilityOf(storePickup));
           wait.until(ExpectedConditions.visibilityOf(storeLocation));
           Log.info(storeLocation.getText());
           return storePickup.isDisplayed();
   }

    public boolean iSeeDeliveryTime() {
            wait.until(ExpectedConditions.visibilityOf(deliveryTime));
            return deliveryTime.isDisplayed();
    }

    public boolean iSeeToolTip() {
            wait.until(ExpectedConditions.visibilityOf(toolTip));
            return toolTip.isDisplayed();
    }

    public boolean iSeeLinksOnMainNav() {
        List<WebElement> navItems = driver.findElements(mainNavItems);
        for (WebElement item : navItems) {
                String linkText = item.getText();
                if (    linkText.contains("GROCERY") ||
                        linkText.contains("HOME, BEAUTY & BABY") ||
                        linkText.contains("DISCOVER") ||
                        linkText.contains("MY SHOP") ||
                        linkText.contains("FLYERS & DEALS") ||
                        linkText.contains("SERVICES")) {
                    return true;
                }
            }
        return false;
    }

    public boolean iSeeSignIn() {
            wait.until(ExpectedConditions.visibilityOf(signInButton));
            return signInButton.isDisplayed();
    }

    public boolean iSeeMiniCart() {
            wait.until(ExpectedConditions.visibilityOf(miniCartButton));
            return miniCartButton.isDisplayed();
    }

    public boolean iSeeCheckout() {
            wait.until(ExpectedConditions.visibilityOf(checkoutButton));
            return checkoutButton.isDisplayed();
    }

    public boolean iHoverOverGroceryInNav() {
            wait.until(ExpectedConditions.visibilityOf(groceryNav));
            action.moveToElement(groceryNav).build().perform();
            wait.until(ExpectedConditions.visibilityOf(fruitsAndVegetablesCategory));
            return fruitsAndVegetablesCategory.isDisplayed();
    }

    public boolean iCanSeeAllCategoriesInGrocery() {
            wait.until(ExpectedConditions.visibilityOf(categoriesInGrocery));
            return categoriesInGrocery.getText().contains("Fruits & Vegetables");
    }

    public boolean iCanSeeAllCategoriesInBeauty() {
            wait.until(ExpectedConditions.visibilityOf(categoriesInBeauty));
            return categoriesInBeauty.getText().contains("Baby");
    }



    public boolean iCanSeeSubCategoryInGrocery() {
            wait.until(ExpectedConditions.visibilityOf(categoriesInGrocery));
            wait.until(ExpectedConditions.visibilityOf(fruitsAndVegetablesCategory));
            action.moveToElement(fruitsAndVegetablesCategory).build().perform();
            wait.until(ExpectedConditions.visibilityOf(subCategory));
            action.moveToElement(subCategory).build().perform();
            wait.until(ExpectedConditions.visibilityOf(subCategoryInGrocery));
            Log.info(subCategoryInGrocery.getText());
            return subCategoryInGrocery.getText().contains("Fresh Vegetables") || subCategoryInGrocery.getText().contains("Fresh Fruits");
    }

    public boolean iCanSeeSubCategoryInBeauty() {
            wait.until(ExpectedConditions.visibilityOf(beautyNav));
            action.moveToElement(beautyNav).build().perform();
            wait.until(ExpectedConditions.visibilityOf(babyCategory));
            action.moveToElement(babyCategory).build().perform();
            wait.until(ExpectedConditions.visibilityOf(subCategoryInBeauty));
            action.moveToElement(subCategoryInBeauty).build().perform();
            Log.info(subCategoryInBeauty.getText());
            return subCategoryInBeauty.getText().contains("Baby Food") || subCategoryInBeauty.getText().contains("Baby Formula");
    }



    public boolean iCanSeeAdInCategory() {
            action.moveToElement(fruitsAndVegetablesCategory).build().perform();
            wait.until(ExpectedConditions.visibilityOf(adInCategory));
            return adInCategory.isDisplayed();
    }

    public boolean iHoverOverHomeBeautyAndBaby() {
            wait.until(ExpectedConditions.visibilityOf(beautyNav));
            action.moveToElement(beautyNav).build().perform();
            wait.until(ExpectedConditions.visibilityOf(babyCategory));
            return babyCategory.isDisplayed();
    }

    public boolean iHoverOverAnyOfDiscoverMyShopFlyersDealsServices() {
            wait.until(ExpectedConditions.visibilityOfAllElements(navigationCategoriesLinks));
            WebElement navigationCategory = navigationCategoriesLinks.get(random.nextInt(navigationCategoriesLinks.size()));
            action.moveToElement(navigationCategory).build().perform();
            Log.info(navigationCategory.getText());
            return navigationCategory.isDisplayed();
    }

    public boolean iSeeCategoryInDiscover() {
            action.moveToElement(mainDiscover).build().perform();
            wait.until(ExpectedConditions.visibilityOf(discoverCategory));
            return discoverCategory.isDisplayed();
    }

    public void iClickOnALinkInNav() {
        wait.until(ExpectedConditions.visibilityOf(groceryNav));
        action.moveToElement(groceryNav).build().perform();
        wait.until(ExpectedConditions.visibilityOf(groceryCategory));
        ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, groceryCategory);
    }

    public boolean iAmOnAppropriatePage() {
            wait.until(ExpectedConditions.visibilityOf(pageHeading));
            Log.info(pageHeading.getText());
            return pageHeading.getText().contains("SEASONAL FRUITS & VEGETABLES");
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickElement(WebElement element) {
            wait.until(ExpectedConditions.visibilityOf(element));
            ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, element);
    }

    /**
     * Clicks on the "Sign In" link to navigate to the log-in page.
     */
    public void openLogInPage() {
            clickElement(signInLink);
    }

    public boolean iAmOnSignInPage() {
            wait.until(ExpectedConditions.visibilityOf(signInPage));
            return signInPage.isDisplayed();
    }

    public void enterCredentials(String testCase) throws IOException {
            wait.until(ExpectedConditions.visibilityOf(inputEmail));
            Log.info("Credentials: "+DataDriven.getTestData(SHEET_NAME,testCase));
            inputEmail.sendKeys(DataDriven.getTestData(SHEET_NAME,testCase).get(1));
            Log.info("Input Email: "+inputEmail.getAttribute("value"));
            wait.until(ExpectedConditions.visibilityOf(inputPassword));
            inputPassword.sendKeys(DataDriven.getTestData(SHEET_NAME,testCase).get(1));
    }

    /**
     * Enters valid credentials (email and password) and submits the sign-in form.
     * This method performs the following steps:
     * 1. Calls the helper method enterCredentials() to input the provided email and password.
     * 2. Clicks the "Sign In" element to submit the login form.\
     */
    public void logInToAccount(String testCase) throws IOException {
            enterCredentials(testCase);
            clickElement(signInButton);
    }

    public void iClickOnCart() {
        wait.until(ExpectedConditions.visibilityOf(miniCartButton));
        ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, miniCartButton);
    }

    public boolean iSeeMyCartExpand() {
            wait.until(ExpectedConditions.visibilityOf(miniCartExpand));
            return miniCartExpand.isDisplayed();
    }

    public boolean iSeeAllItemsInCart() {
            wait.until(ExpectedConditions.visibilityOf(itemsInCart));
            Log.info(itemsInCart.getText());
            return itemsInCart.isDisplayed();
    }

    public boolean iSeeSummaryOfCart() {
            wait.until(ExpectedConditions.visibilityOf(cartSummary));
            Log.info(cartSummary.getText());
            wait.until(ExpectedConditions.visibilityOf(viewCartButton));
            return cartSummary.isDisplayed();
    }

    public boolean iSeeCheckoutButtonInCartMenu() {
            wait.until(ExpectedConditions.visibilityOf(checkoutInCart));
            return checkoutInCart.isDisplayed();
    }

    public void iClickOnCheckout() {
            wait.until(ExpectedConditions.visibilityOf(checkoutButton));
            ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, checkoutButton);
    }

    public boolean iAmOnFirstFlowOfCheckout() {
            wait.until(ExpectedConditions.visibilityOf(orderSummary));
            return orderSummary.isDisplayed();
    }

    public void iScrollToTopOfPage() {
            wait.until(ExpectedConditions.visibilityOf(pageTitle));
            Log.info(pageTitle.getText());
            action.sendKeys(Keys.END).build().perform();
            action.sendKeys(Keys.HOME).build().perform();
    }

    public boolean iSeeLzeroAtTopOfPage() {
            wait.until(ExpectedConditions.visibilityOfAllElements(breadCrumbList));
            Log.info("BreadCrumb 1: "+breadCrumbList.get(0));
            return breadCrumbList.get(0).isDisplayed() && !breadCrumbList.isEmpty();
    }

    public boolean lZeroLinkWillBeClickable() {
            wait.until(ExpectedConditions.visibilityOfAllElements(breadCrumbList));
            ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, breadCrumbList.get(0));
            wait.until(ExpectedConditions.visibilityOf(pageTitle));
            return pageTitle.isDisplayed();
    }

    public boolean iSeeBreadCrumbLevelAtTopOfPage() {
            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOf(currentLevelBreadCrumb));
            return currentLevelBreadCrumb.isDisplayed();
    }

    public void iAmOnLTwoBreadCrumb() {
            wait.until(ExpectedConditions.visibilityOfAllElements(breadCrumbList));
    }

    public boolean lOneLinkWillBeClickable() {
            wait.until(ExpectedConditions.visibilityOfAllElements(breadCrumbList));
            String breadCrumbText=breadCrumbList.get(1).getText();
            ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, breadCrumbList.get(1));
            wait.until(ExpectedConditions.visibilityOf(pageTitle));
            return pageTitle.getText().equals(breadCrumbText);
    }

    public void iAmOnLevelThreeBreadCrumb() {
            wait.until(ExpectedConditions.visibilityOfAllElements(breadCrumbList));
            ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, breadCrumbList.get(2));
    }

    public boolean lTwoLinkWillBeClickable() {
            wait.until(ExpectedConditions.visibilityOfAllElements(breadCrumbList));
            String breadCrumbText=breadCrumbList.get(2).getText();
            ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, breadCrumbList.get(2));
            wait.until(ExpectedConditions.visibilityOf(pageTitle));
            return pageTitle.getText().equals(breadCrumbText);
    }

    public void iClickOnProductOnPcx() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTile));
        List<WebElement> tiles = driver.findElements(productTile);
        for (WebElement tile : tiles) {
            if (!(tile.getText().contains("Out of Stock") || tile.getText().contains("Low Stock"))) {
                tile.click();
                break; // Exit the loop after clicking the first in-stock product
            }
        }
    }



    public boolean iSeeProductNameOnBreadCrumb() {
            wait.until(ExpectedConditions.visibilityOfAllElements(pdpBreadcrumbs));
            Log.info(productNameOnBreadcrumb.getText());
            return productNameOnBreadcrumb.isDisplayed();
    }



    public boolean iClickBreadCrumbLevelsAtTopOfPdp(WebElement element) {
            wait.until(ExpectedConditions.visibilityOf(element));
            ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, element);
            driver.navigate().back();
            return true;
    }

    public boolean iClickLzeroBreadCrumbAtPdp() {
        return iClickBreadCrumbLevelsAtTopOfPdp(levelZeroBreadCrumbOnPdp);
    }

    public boolean iClickLoneBreadCrumbAtPdp() {
        return iClickBreadCrumbLevelsAtTopOfPdp(levelOneBreadCrumbOnPdp);
    }

    public boolean iClickLtwoBreadCrumbAtPdp() {
        return iClickBreadCrumbLevelsAtTopOfPdp(pdpBreadcrumbs.get(2));
    }

    public boolean iClickLthreeBreadCrumbAtPdp() {
        return iClickBreadCrumbLevelsAtTopOfPdp(pdpBreadcrumbs.get(3));
    }


    public boolean iSeeBreadCrumbLevelsAtTopOfPdp(WebElement element) {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
    }

    public boolean iSeeLzeroBreadCrumbAtPdp() {
        Log.info(levelZeroBreadCrumbOnPdp.getText());
        return iSeeBreadCrumbLevelsAtTopOfPdp(levelZeroBreadCrumbOnPdp);
    }

    public boolean iSeeLoneBreadCrumbAtPdp() {
        Log.info(levelOneBreadCrumbOnPdp.getText());
        return iSeeBreadCrumbLevelsAtTopOfPdp(levelOneBreadCrumbOnPdp);
    }

    public boolean iSeeLtwoBreadCrumbAtPdp() {
        wait.until(ExpectedConditions.visibilityOfAllElements(pdpBreadcrumbs));
        Log.info("Breadcrumb 2:"+pdpBreadcrumbs.get(2));
        return iSeeBreadCrumbLevelsAtTopOfPdp(pdpBreadcrumbs.get(2));
    }

    public boolean iSeeLthreeBreadCrumbAtPdp() {
        Log.info(pdpBreadcrumbs.get(3).getText());
        return iSeeBreadCrumbLevelsAtTopOfPdp(pdpBreadcrumbs.get(3));
    }

    public boolean validatesUserHavePCXPass() {
        clickElement(myAccountButton);
        return pcExpressPassLink.isDisplayed();
    }
}
