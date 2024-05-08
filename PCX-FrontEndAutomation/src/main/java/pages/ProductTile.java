package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductTile {

    WebDriver driver;
    WebDriverWait wait;
    Random random;

    private static final String CLICK_SCRIPT = "arguments[0].click();";
    private static final String OUT_OF_STOCK = "Out of Stock";
    private static final String LOW_STOCK = "Low Stock";

    public ProductTile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        random=new Random();
    }

    @FindBy(xpath = "//span[normalize-space()='Grocery']")
    WebElement plpCategory;

    @FindBy(xpath = "//span[normalize-space()='Home, Beauty & Baby']")
    WebElement beautyCategory;

    @FindBy(xpath = "//span[normalize-space()='Pet Food & Supplies']")
    WebElement petFoodCategory;

    @FindBy(xpath = "//span[normalize-space()='Fruits & Vegetables']")
    WebElement fruitsAndVegetables;

    @FindBy(css = "img[class='responsive-image responsive-image--product-details-page']")
    WebElement productImage;

    @FindBy(className = "selling-price-list__item")
    WebElement productPrice;

    @FindBy(css = "div[class='product-name product-name--product-details-page']")
    WebElement productTitle;

    @FindBy(css = "li[class*='comparison-price-list__item']")
    WebElement productWeight;

    @FindBy(css = "span[class='price comparison-price-list__item__price']")
    WebElement costPerWeight;

    @FindBy(css = "button[data-testid='quantity-selector-add-to-cart-index-0']")
    WebElement addToCartButton;

    @FindBy(css = ".selling-price-list--sale .selling-price-list__item__price--now-price")
    WebElement discountedPrice;

    @FindBy(css = ".selling-price-list--multi-item-quickview__item__price--was-price,.selling-price-list__item__price--was-price")
    WebElement normalPrice;

    @FindBy(xpath = "//p[@class='product-low-inventory__text']")
    WebElement lowInventoryMessage;

    @FindBy(xpath = "//p[@class='out-of-stock__text']")
    WebElement outOfStockMessage;

    @FindBy(xpath = "//span[normalize-space()='Dairy & Eggs']")
    WebElement dairyAndEggs;

    @FindBy(css = "span[class='product-name__item product-name__item--brand']")
    WebElement productBrand;

    @FindBy(xpath = "//button[@aria-label='Next Page']")
    WebElement nextPageButton;

    @FindBy(xpath = "//span[@class='cart-item-count__text']")
    WebElement miniCart;

    @FindBy(xpath = "//div[@class='product-promo__badge-wrapper']")
    WebElement productPromo;

    @FindBy(css = ".quantity-selector__label")
    WebElement miniCartQuantity;

    @FindBy(css = "div[class*='horizontal'] button[data-testid*='button-increment']")
    WebElement quantityIncrease;

    @FindBy(css = "div[class*='horizontal'] button[data-testid*='button-decrement']")
    WebElement quantityDecrease;

    @FindBy(css = "button[data-testid='quantity-selector-button-increment-index-1']")
    WebElement miniCartQuantityIncrease;

    @FindBy(css = "button[data-testid='quantity-selector-button-decrement-index-1']")
    WebElement miniCartQuantityDecrease;

    @FindBy(css = "input[value='2']")
    WebElement increaseQuantityCount;

    @FindBy(css = "input[aria-label='Quantity']")
    WebElement defaultQuantityCount;

    @FindBy(css ="p[class*='text--center text--default-color cart-removed-all-items']")
    WebElement removeItem;

    @FindBy(css = "span[class='price__value']")
    WebElement amountOnMiniCart;

    @FindBy(css = "div[class='product-name product-name--product-details-page']")
    WebElement productDetails;

    @FindBy(css = "button[aria-label=\"Next Page\"]")
    WebElement nextPage;

    @FindBy(xpath = "//span[normalize-space()='Multi-Buy']")
    WebElement multiBuyFilter;

    @FindBy(css = "div[class='product-promo']")
    WebElement pcoProductTag;

    @FindBy(css = "button.tooltip__description__close")
    WebElement timeSlotPopup;

    By dealsFilters = By.cssSelector("p[data-testid='accordion-title']");

    //CLP Quick-Filter labels
    By plpDeals = By.cssSelector("div[aria-label='Quick filters'] label");
    //CLP product-grids individual-products
    By plpList = By.cssSelector("div.chakra-linkbox");
    By addButton = By.cssSelector("button[data-testid='atc-button']");

    public void iAmOnAProductTile() {
            Actions action = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(plpCategory));
            action.moveToElement(plpCategory).build().perform();
            wait.until(ExpectedConditions.visibilityOf(fruitsAndVegetables));
            action.moveToElement(fruitsAndVegetables).click().build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
            List<WebElement> tiles = driver.findElements(plpList);
            for (WebElement tile : tiles) {
                if (!(tile.getText().contains(OUT_OF_STOCK) || tile.getText().contains(LOW_STOCK))) {
                    tile.click();
                    break;
                }
            }
    }

    public boolean iSeeProductImage() {
            wait.until(ExpectedConditions.visibilityOf(productImage));
            return productImage.isDisplayed();
    }

    public boolean iSeeProductPrice() {
            wait.until(ExpectedConditions.visibilityOf(productPrice));
            Log.info(productPrice.getText());
            return productPrice.isDisplayed();
    }

    public boolean iSeeProductTitle() {
            wait.until(ExpectedConditions.visibilityOf(productTitle));
            Log.info(productTitle.getText());
            return productTitle.isDisplayed();
    }

    public boolean iSeeProductWeight() {
            wait.until(ExpectedConditions.visibilityOf(productWeight));
            Log.info(productWeight.getText());
            return productWeight.isDisplayed();
    }

    public boolean iSeeCostPerWeight() {
            wait.until(ExpectedConditions.visibilityOf(costPerWeight));
            return costPerWeight.isDisplayed();
    }

    public boolean iSeeCartButton() {
            wait.until(ExpectedConditions.visibilityOf(addToCartButton));
            return addToCartButton.isDisplayed();
    }

    public void iAmOnAPLPWithDiscount() {
            Actions action = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(plpCategory));
            action.moveToElement(plpCategory).build().perform();
            wait.until(ExpectedConditions.visibilityOf(fruitsAndVegetables));
            action.moveToElement(fruitsAndVegetables).click().build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(plpDeals));
            List<WebElement> filters = driver.findElements(plpDeals);
            for (WebElement filter : filters) {
                if (filter.getText().contains("Deals"))
                {
                    filter.click();
                    break;
                }
            }
    }


    public boolean iSeeDiscountedPrice() {
        wait.until(ExpectedConditions.visibilityOf(discountedPrice));
        Log.info(discountedPrice.getText());
        Log.info(normalPrice.getText());
        return normalPrice.getCssValue("text-decoration").contains("line-through");
    }


    public void iAmOnAPlp() {
            Actions action = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(plpCategory));
            action.moveToElement(plpCategory).build().perform();
            wait.until(ExpectedConditions.visibilityOf(fruitsAndVegetables));
            action.moveToElement(fruitsAndVegetables).click().build().perform();
    }

    public void iAmOnLowStockItem() {
        boolean found = false;

        while (!found) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
            List<WebElement> tiles = driver.findElements(plpList);

            for (WebElement tile : tiles) {
                if (tile.getText().contains(LOW_STOCK)) {
                    tile.click();
                    found = true;
                    break;
                }
            }

            if (!found) {
                // Navigate to the next page
                wait.until(ExpectedConditions.visibilityOf(nextPageButton));
                if (nextPageButton.isEnabled()) {
                    ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, nextPageButton);
                } else {
                    break;
                }
            }
        }
    }


    public boolean iSeeLowInventoryMessage() {
            wait.until(ExpectedConditions.visibilityOf(lowInventoryMessage));
            return lowInventoryMessage.isDisplayed();
    }

    public void iAmOnPackagedItem() {
            Actions action = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(plpCategory));
            action.moveToElement(plpCategory).build().perform();
            wait.until(ExpectedConditions.visibilityOf(dairyAndEggs));
            action.moveToElement(dairyAndEggs).click().build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
            List<WebElement> tiles = driver.findElements(plpList);
            tiles.get(random.nextInt(tiles.size())).click();
    }

    public boolean iSeeProductBrand() {
            wait.until(ExpectedConditions.visibilityOf(productBrand));
            return productBrand.isDisplayed();
    }

    public void iAmOnOutOfStockItem() {
        boolean found = false;

            while (!found) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
                List<WebElement> tiles = driver.findElements(plpList);


                for (WebElement tile : tiles) {
                    if (tile.getText().contains(OUT_OF_STOCK)) {
                        tile.click();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    // Navigate to the next page
                    wait.until(ExpectedConditions.visibilityOf(nextPageButton));
                    if (nextPageButton.isEnabled()) {
                        ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, nextPageButton);
                    } else {
                        break;
                    }
                }
            }
    }

    public boolean iSeeOutOfStockMessage() {
            wait.until(ExpectedConditions.visibilityOf(outOfStockMessage));
            return outOfStockMessage.isDisplayed();
    }

    public void clickOnAddButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        List<WebElement> options = driver.findElements(addButton);
        int validProductIndex = getRandomIndexForValidProduct();
        if (validProductIndex != -1) {
            options.get(validProductIndex).click();
        } else {
            Log.info("No valid product found to click on the 'Add' button.");
        }
    }
    public int getRandomIndexForValidProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
        List<WebElement> tiles = driver.findElements(plpList);
        // Shuffle the order of tiles to randomly select a valid product
        List<WebElement> shuffledTiles = new ArrayList<>(tiles);
        Collections.shuffle(shuffledTiles);
        for (WebElement tile : shuffledTiles) {
            if (!(tile.getText().contains(OUT_OF_STOCK) || tile.getText().contains(LOW_STOCK))) {
                return tiles.indexOf(tile); // Return the index of the valid product
            }
        }
        return -1; // Return -1 if no valid product is found
    }


public boolean iSeeProductHasBeenAdded(){
    try {
        wait.until(ExpectedConditions.invisibilityOf(miniCart));
        Log.info("Cart is not Display");
        return false;
    }catch (TimeoutException e) {
        String cartItemCount = miniCart.getText();
        Log.info(cartItemCount);
        int count = Integer.parseInt(cartItemCount);
        return count >= 1;
    }
}

    public boolean iSeeMiniCartTile() {
        closeTimeslotPopup();
        wait.until(ExpectedConditions.visibilityOf(miniCart));
        miniCart.click();
        wait.until(ExpectedConditions.visibilityOf(miniCartQuantity));
        return miniCartQuantity.isDisplayed();
    }

    public void iCanAddOrReduceQuantity() {
        wait.until(ExpectedConditions.visibilityOf(miniCartQuantityIncrease));
        miniCartQuantityIncrease.click();
        wait.until(ExpectedConditions.visibilityOf(miniCartQuantityDecrease));
        miniCartQuantityDecrease.click();
    }

    public void addAnItemToCart() {
           wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
           List<WebElement> tiles = driver.findElements(plpList);
           for (WebElement tile : tiles) {
               if (!(tile.getText().contains(OUT_OF_STOCK) || tile.getText().contains(LOW_STOCK))) {
                   tile.click();
                   break;
               }
           }
           wait.until(ExpectedConditions.visibilityOf(addToCartButton));
           addToCartButton.click();
    }

    public void addALowStockItemToCart() {
        boolean foundLowStockProduct = false;
        while(!foundLowStockProduct){
            wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
            List<WebElement> tiles = driver.findElements(plpList);
            for (WebElement tile : tiles) {
                if (tile.getText().contains(LOW_STOCK)) {
                    tile.click();
                    foundLowStockProduct = true;
                    break;
                }
            }
            if(!foundLowStockProduct) nextPageButton.click();
        }
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
    }

    public void closeTimeslotPopup(){
        try {
            wait.until(ExpectedConditions.visibilityOf(timeSlotPopup));
            timeSlotPopup.click();
        }catch (TimeoutException e){
            Log.info("No time slot popup rise");
        }
    }
    public void iClickOnAddOrMinusButtonNextToIt() {
        closeTimeslotPopup();
        wait.until(ExpectedConditions.visibilityOf(quantityIncrease));
        ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, quantityIncrease);
        wait.until(ExpectedConditions.visibilityOf(increaseQuantityCount));
        wait.until(ExpectedConditions.visibilityOf(quantityDecrease));
        ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, quantityDecrease);
    }

    public void iGetNewUpdatedQuantity() {
        wait.until(ExpectedConditions.visibilityOf(miniCart));
        String cartItemCount = miniCart.getText();
        int count = Integer.parseInt(cartItemCount);
        if (count >= 1 ) {
            miniCart.getText();
        } else {
            Log.info("Quantity is zero in cart");
        }
    }

    public void iClickOnAnywhereOnTheProduct() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
             List<WebElement> tiles = driver.findElements(plpList);
        for (WebElement tile : tiles) {
            if (!(tile.getText().contains(OUT_OF_STOCK) || tile.getText().contains(LOW_STOCK))) {
                tile.click();
                break;
            }
        }
    } catch (NoSuchElementException e) {
        e.printStackTrace();
    }
}

   public boolean iWillBeTakenToThatPdp() {
           wait.until(ExpectedConditions.visibilityOf(productDetails));
           return productDetails.isDisplayed();
   }

   public void iSeeSaleOnItem() {
       boolean found = false;

           while (!found) {
               wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
               List<WebElement> tiles = driver.findElements(plpList);
               Pattern pattern = Pattern.compile("SAVE \\$\\d+\\.\\d+");

               for (WebElement tile : tiles) {
                   String tileText = tile.getText();
                   Matcher matcher = pattern.matcher(tileText);
                   if (matcher.find() && !(tile.getText().contains(OUT_OF_STOCK) || tile.getText().contains(LOW_STOCK))) {
                       tile.click();
                       found = true;
                       break;
                   }
               }
               if (!found) {
                   // Navigate to the next page
                   wait.until(ExpectedConditions.visibilityOf(nextPageButton));
                   if (nextPageButton.isEnabled()) {
                       ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, nextPageButton);
                   } else {
                       break;
                   }
               }
           }
   }

    public boolean iSeeSaleDetails() {
           wait.until(ExpectedConditions.visibilityOf(productPromo));
           return productPromo.isDisplayed();
   }

   public void iSeeMultiBuy() {
       wait.until(ExpectedConditions.visibilityOfElementLocated(dealsFilters));
       List<WebElement> deals = driver.findElements(dealsFilters);
       for(WebElement deal : deals) {
           if(deal.getText().contains("Deals")) {
               deal.click();
               break;
           }
       }
       wait.until(ExpectedConditions.visibilityOf(multiBuyFilter));
       ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, multiBuyFilter);
               wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
               List<WebElement> tiles = driver.findElements(plpList);
               for (WebElement tile : tiles) {
                   if (!(tile.getText().contains(OUT_OF_STOCK) || tile.getText().contains(LOW_STOCK))) {
                       tile.click();
                       break;
                   }
               }
       }

       public void iAmOnPcoTile() {
           Actions action = new Actions(driver);
           wait.until(ExpectedConditions.visibilityOf(beautyCategory));
           action.moveToElement(beautyCategory).build().perform();
           wait.until(ExpectedConditions.visibilityOf(petFoodCategory));
           action.moveToElement(petFoodCategory).click().build().perform();
       }


       public void iSeePcOptimumOffer() {
           boolean found = false;

           while (!found) {
               wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
               List<WebElement> tiles = driver.findElements(plpList);

               for (WebElement tile : tiles) {
                   if (tile.getText().contains("PC Optimum Offer")) {
                       tile.click();
                       found = true;
                       break;
                   }
               }
               if (!found) {
                   // Navigate to the next page
                   wait.until(ExpectedConditions.visibilityOf(nextPageButton));
                   if (nextPageButton.isEnabled()) {
                       ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, nextPageButton);
                   } else {
                       break;
                   }
               }
           }
       }

       public boolean iSeePcOptimumTag() {
               wait.until(ExpectedConditions.visibilityOf(pcoProductTag));
               return pcoProductTag.isDisplayed();
       }

    public boolean iSeeDefaultQuantity() {
            wait.until(ExpectedConditions.visibilityOf(defaultQuantityCount));
            Log.info(defaultQuantityCount.getText());
            return defaultQuantityCount.isDisplayed();
    }

    public boolean clickMinusOnMiniCart() {
        wait.until(ExpectedConditions.visibilityOf(miniCart));
        ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, miniCart);
        wait.until(ExpectedConditions.visibilityOf(miniCartQuantityDecrease));
        ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, miniCartQuantityDecrease);
        wait.until(ExpectedConditions.visibilityOf(removeItem));
        return removeItem.getText().equalsIgnoreCase("Removed");
    }

    public boolean validateAmountSection(){
        try {
            wait.until(ExpectedConditions.invisibilityOf(amountOnMiniCart));
            return true;
        }catch (TimeoutException e){
            Log.info("Amount section is visible till now");
            return false;
        }

    }

    public boolean validateVisibilityOfAddToCartButton(){
        try {
            wait.until(ExpectedConditions.visibilityOf(addToCartButton));
            return addToCartButton.isDisplayed();
        }catch (TimeoutException e){
            Log.info("Add to cart button is not display");
            return false;
        }
    }

    public void iSeeSponsoredItem() {
        boolean found = false;

        while (!found) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
            List<WebElement> tiles = driver.findElements(plpList);

            for (WebElement tile : tiles) {
                if (tile.getText().contains("Sponsored")) {
                    tile.click();
                    found = true;
                    break;
                }
            }
            if (!found) {
                // Navigate to the next page
                wait.until(ExpectedConditions.visibilityOf(nextPageButton));
                if (nextPageButton.isEnabled()) {
                    ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, nextPageButton);
                } else {
                    break;
                }
            }
        }
    }

    public void iAmOnFruitsAndVegetablesPlp() {
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(plpCategory));
        plpCategory.click();
        wait.until(ExpectedConditions.visibilityOf(fruitsAndVegetables));
        action.moveToElement(fruitsAndVegetables).click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
    }

}
