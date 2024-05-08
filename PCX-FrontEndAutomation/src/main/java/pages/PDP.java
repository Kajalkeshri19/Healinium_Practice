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

public class PDP {
    private static final String COLLAPSE_PROPERTY = "--inactive";
    private static final String ATTRIBUTE_CLASS = "class";
    private static final String PRICE_REGEX = "\\$\\d+\\.\\d{2}";
    WebDriver driver;
    WebDriverWait wait;
    @FindAll(@FindBy(css = "a.breadcrumb"))
    List<WebElement> breadcrumbs;
    @FindBy(css = "div.product-details-page-details__content__prices span.selling-price-list__item__price--now-price span.selling-price-list__item__price--now-price__value")
    WebElement sellingPrice;
    @FindBy(css = "span.selling-price-list__item__price--was-price__value")
    WebElement pdpRegularPrice;
    @FindBy(css = "h1.product-name__item")
    public WebElement pdpProductTitle;
    @FindBy(css = "span.product-name__item--brand")
    WebElement pdpBrandTitle;
    @FindBy(css = ".product-name__item--package-size")
    WebElement pdpWeight;
    @FindBy(css = "div.product-details-page-details__content__sticky-placeholder span.selling-price-list__item__price--now-price__value")
    WebElement pdpProductPrice;
    //PDP add-to-cart-button
    @FindBy(css = ".product-details-page-details__visibility-sensor button.common-button")
    WebElement addToCartButton;
    @FindAll(@FindBy(css = "li.breadcrumbs__list__item"))
    List<WebElement> breadCrumbItems;
    @FindBy(css = ".product-details-page-details img.responsive-image--product-details-page")
    WebElement pdpProductImage;
    @FindBy(css = "svg.product-image-zoom-button--oval__icon")
    WebElement magnifierIcon;
    @FindBy(css = "button.product-details-page-description__title")
    WebElement productDescriptionButton;
    @FindBy(css = "button.product-details-page-nutrition-info__title")
    WebElement productNutritionInfoButton;
    @FindBy(css = "button.product-details-page-legal-disclaimer__title")
    WebElement legalDisclaimerButton;
    @FindAll(@FindBy(css = "div.product-details-page-related-products div.product-tile"))
    List<WebElement> relatedItemsProductTiles;
    //CLP product-tile product-name-link
    @FindBy(css = "a.product-tile__details__info__name__link")
    WebElement relatedProductTile;
    @FindBy(css = "div.product-promo__badge")
    WebElement pdpBadge;
    @FindBy(css = "p.product-promo__badge__content")
    WebElement pdpAmountSavings;
    @FindBy(css = "p.product-promo__message__expiry-date")
    WebElement pdpExpiryDate;
    @FindBy(css = "p.product-low-inventory__text")
    WebElement lowStockBadge;
    @FindBy(css = "div.product-low-inventory__description--details")
    WebElement lowStockDescription;
    @FindBy(css = "div.product-in-cart-flag svg.product-in-cart-flag__icon")
    WebElement addToCartValidation;
    @FindBy(css = "p.product-promo__badge__content")
    WebElement badgeMinContent;

    @FindBy(css = "p.out-of-stock__text") WebElement outOfStockText;
    @FindBy(css = "div.product-details-page-details__visibility-sensor [data-testid='quantity-selector-button-increment-index-1']") WebElement qtyIncreaseButton;
    By relatedBrandNames = By.cssSelector("span.product-name__item--brand");
    By relatedProductNames=By.cssSelector("span.product-name__item--name");
    By relatedAddToCartItems=By.cssSelector("button[data-track='productAddToCartButton']");
    By relatedItemsImages=By.cssSelector("div.product-tile__thumbnail__image");
    @FindBy(css = "input.quantity-selector__quantity__input") WebElement qtyInputBox;
    @FindBy(css = "div.product-details-page-details__visibility-sensor button[data-testid='quantity-selector-button-decrement-index-1']") WebElement qtyDecreaseButton;

    public PDP(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean validateProductNameVisible() {
        wait.until(ExpectedConditions.visibilityOf(pdpProductTitle));
        Log.info("Product Name:" + pdpProductTitle.getText());
        return pdpProductTitle.isDisplayed();
    }

    public boolean validateBrandNameVisible() {
        wait.until(ExpectedConditions.visibilityOf(pdpBrandTitle));
        Log.info("Brand Name:" + pdpBrandTitle.getText());
        return pdpBrandTitle.isDisplayed();
    }

    public boolean validateSellingPriceVisible() {
        wait.until(ExpectedConditions.visibilityOf(sellingPrice));
        return sellingPrice.isDisplayed();
    }

    public boolean validateWeight() {
        wait.until(ExpectedConditions.visibilityOf(pdpWeight));
        Log.info(pdpWeight.getText());
        return pdpWeight.isDisplayed();
    }

    public boolean validateProductPriceVisible() {
        wait.until(ExpectedConditions.visibilityOf(pdpProductPrice));
        Log.info("Product Price:" + pdpProductPrice.isDisplayed());
        Log.info("Product Price" + pdpProductPrice.getText());
        Log.info("Product Price Regex:" + pdpProductPrice.getText().matches(PRICE_REGEX));
        return pdpProductPrice.isDisplayed() && pdpProductPrice.getText().matches(PRICE_REGEX);
    }

    public boolean validateAddToProductVisible() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        return addToCartButton.isDisplayed();
    }

    public boolean validateBreadCrumbItemsVisible() {
        wait.until(ExpectedConditions.visibilityOfAllElements(breadCrumbItems));
        Log.info("Breadcrumbs Item Size:" + breadCrumbItems.size());
        return breadCrumbItems.size() >= 3;
    }

    public boolean validatePdpImageAndMagnifier() {
        wait.until(ExpectedConditions.visibilityOf(pdpProductImage));
        return pdpProductImage.isDisplayed() && !pdpProductImage.getAttribute(ATTRIBUTE_CLASS).contains("responsive-image--loading-failed") && magnifierIcon.isDisplayed();
    }

    public boolean validateExpandedDescriptionAndOtherFacetsCollapsed() {
        wait.until(ExpectedConditions.visibilityOf(pdpProductImage));
        return !productDescriptionButton.getAttribute(ATTRIBUTE_CLASS).contains(COLLAPSE_PROPERTY) && productNutritionInfoButton.getAttribute(ATTRIBUTE_CLASS).contains(COLLAPSE_PROPERTY) && legalDisclaimerButton.getAttribute(ATTRIBUTE_CLASS).contains(COLLAPSE_PROPERTY);
    }

    public void clickPdp() {
        wait.until(ExpectedConditions.visibilityOf(relatedProductTile));
        relatedProductTile.click();
        wait.until(ExpectedConditions.visibilityOf(pdpProductTitle));
    }

    public boolean validateRelatedItemsSection() {
        wait.until(ExpectedConditions.visibilityOfAllElements(relatedItemsProductTiles));
        return relatedItemsProductTiles.isEmpty();
    }

    public boolean validatePdpRegularPrice() {
        wait.until(ExpectedConditions.visibilityOf(pdpRegularPrice));
        Log.info("Regular Price:" + pdpRegularPrice.getText());
        return pdpRegularPrice.isDisplayed() && pdpRegularPrice.getText().matches(PRICE_REGEX);
    }

    public boolean validateSellingPrice() {
        wait.until(ExpectedConditions.visibilityOf(sellingPrice));
        Log.info("Selling price: " + sellingPrice.getText());
        return sellingPrice.isDisplayed() && sellingPrice.getText().matches(PRICE_REGEX);
    }

    public boolean validateSaleBadge() {
        wait.until(ExpectedConditions.visibilityOf(pdpBadge));
        Log.info("Badge: " + pdpBadge.getText());
        return pdpBadge.isDisplayed() && pdpBadge.getText().equalsIgnoreCase("Sale");
    }

    public boolean validatePdpAmountSavings() {
        wait.until(ExpectedConditions.visibilityOf(pdpAmountSavings));
        Log.info("PDP Saving Amount: " + pdpAmountSavings.getText());
        return pdpAmountSavings.isDisplayed() && pdpAmountSavings.getText().matches("SAVE \\$\\d+\\.\\d{2}");
    }

    public boolean validateOfferExpiry() {
        wait.until(ExpectedConditions.visibilityOf(pdpExpiryDate));
        Log.info("PDP Expiry Date: " + pdpExpiryDate.getText());
        return pdpExpiryDate.isDisplayed() && pdpExpiryDate.getText().matches("Offer expires \\d{4}-\\d{2}-\\d{2}\\.");
    }

    public boolean validateLowStockDescription() {
        wait.until(ExpectedConditions.visibilityOf(lowStockDescription));
        Log.info("Low Stock Description:" + lowStockDescription.getText());
        return lowStockDescription.isDisplayed();
    }

    public boolean validateLowStockBadge() {
        wait.until(ExpectedConditions.visibilityOf(lowStockBadge));
        Log.info("Low Stock: " + lowStockBadge.getText());
        return lowStockBadge.isDisplayed();
    }

    public boolean validateAddToCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCartValidation));
        return addToCartValidation.isDisplayed();
    }

    public boolean validateMultiBadge() {
        wait.until(ExpectedConditions.visibilityOf(pdpBadge));
        Log.info("Badge: " + pdpBadge.getText());
        return pdpBadge.isDisplayed() && pdpBadge.getText().equalsIgnoreCase("multi");
    }

    public boolean validateMultiMessage() {
        wait.until(ExpectedConditions.visibilityOf(badgeMinContent));
        Log.info("Badge Min Content: " + badgeMinContent.getText());
        return badgeMinContent.isDisplayed() && badgeMinContent.getText().matches("\\d+\\s+FOR\\s+\\$\\d+\\.\\d{2}");
    }

    public boolean validateRelatedItems(){
        wait.until(ExpectedConditions.visibilityOfAllElements(relatedItemsProductTiles));
        for(WebElement recoRelatedProductTile:relatedItemsProductTiles){
            if(recoRelatedProductTile.findElements(relatedProductNames).isEmpty()&& recoRelatedProductTile.findElements(relatedBrandNames).isEmpty()
                    && recoRelatedProductTile.findElements(relatedItemsImages).isEmpty()&& recoRelatedProductTile.findElements(relatedAddToCartItems).isEmpty()){
                return false;
            }
        }
        return true;
    }

    public void clickAddToCartButton(){
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
    }

    public void addTheItemPlusOne(){
        wait.until(ExpectedConditions.visibilityOf(qtyIncreaseButton));
        qtyIncreaseButton.click();
    }

    public boolean validateCartProductQuantity(){
        wait.until(ExpectedConditions.visibilityOf(qtyInputBox));
        return Integer.parseInt(qtyInputBox.getAttribute("value"))>=1;
    }

    public void decreaseTheItemQuantity(){
        wait.until(ExpectedConditions.visibilityOf(qtyDecreaseButton));
        qtyDecreaseButton.click();
    }

    public boolean validateOutOfStockText(){
       wait.until(ExpectedConditions.visibilityOf(outOfStockText));
       return outOfStockText.getText().equals("This item is currently out of stock at this location.");
    }
}
