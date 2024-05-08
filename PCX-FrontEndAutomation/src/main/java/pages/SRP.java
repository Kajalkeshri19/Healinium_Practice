package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SRP {
    WebDriver driver;
    WebDriverWait wait;

    public SRP(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(css = "input.search-input__input")
    public WebElement searchArea;
    @FindBy(css = "button.clear-button")
    WebElement clearSearch;
    @FindBy(css = "ul.typeahead-suggestion-list")
    public WebElement recommendedSearchList;
    @FindBy(css = "ul.product-tile-group__list")
    public WebElement productGrid;
    @FindBy(css = "h1.page-title__title")
    public WebElement searchResultHeading;
    @FindBy(css = "a[class='sign-in account__login-link']")
    WebElement signIn;
    @FindBy(css = "div.search-no-results__search-form")
    WebElement noSearchResult;
    @FindBy(css = "div[class='product-filters']")
    WebElement filter;
    @FindBy(css = "h1[class='page-title__title']")
    WebElement totalResultsHeading;
    @FindBy(xpath = "//button[@class='quick-filters__chips quick-filters__chips--selected-filter']")
    WebElement subFilter;
    @FindBy(xpath = "//button[contains(text(), 'Aisle')]")
    WebElement aisle;
    @FindBy(css = "fieldset[class='quick-filters quick-filters--selected']")
    WebElement selectedQuickFilter;
    @FindBy(xpath = "//button[@aria-label='Clear all filters']")
    WebElement clearAllButton;
    @FindBy(xpath = "//button[@class='styled-dropdown__selected-item-link styled-dropdown__selected-item-link--filter']")
    WebElement sortByButton;
    @FindBy(xpath = "//button[normalize-space()='Price (Low to High)']")
    WebElement lowToHighFilter;
    By dealFilter = By.xpath("//label[normalize-space()='Multi-Buy']");
    By quickFilterOptions = By.cssSelector("button.quick-filters__chips--quick-filter");
    @FindBy(css = "button[data-track='productAddToCartButton']") public WebElement addToCartSRPButton;

    public boolean validateVisibilityOfSignInButton() {
        try {
            wait.until(ExpectedConditions.visibilityOf(signIn));
            return signIn.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("Sign in button not found on page");
            return false;
        }
    }

    public boolean validateVisibilityOfSearchBar() {
        try {
            wait.until(ExpectedConditions.visibilityOf(searchArea));
            return searchArea.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("Search bar is not visible on page");
            return false;
        }
    }

    public void clickOnSearchField() {
        wait.until(ExpectedConditions.elementToBeClickable(searchArea)).click();
    }

    public void searchAProduct(String product) {
        wait.until(ExpectedConditions.elementToBeClickable(searchArea)).click();
        searchArea.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        searchArea.sendKeys(product);
        searchArea.sendKeys(Keys.ENTER);
    }

    public void checkForRecommendedSearchType(String product) {
        wait.until(ExpectedConditions.elementToBeClickable(searchArea)).click();
        searchArea.sendKeys(product);
    }

    public boolean validateRecommendedSearch() {
        wait.until(ExpectedConditions.visibilityOf(recommendedSearchList));
        Log.info(recommendedSearchList.getText());
        return recommendedSearchList.isDisplayed();
    }

    public boolean validateProductGrid() {
        wait.until(ExpectedConditions.visibilityOf(productGrid));
        return productGrid.isDisplayed();
    }

    public boolean validateSearchTermAndResult() {
        wait.until(ExpectedConditions.visibilityOf(searchResultHeading));
        Log.info(searchResultHeading.getText());
        return searchResultHeading.getText().matches("SHOWING +\\d+ RESULTS FOR \"+\\w+\"");
    }

    public boolean validateForNoResult() {
        wait.until(ExpectedConditions.visibilityOf(noSearchResult));
        Log.info(noSearchResult.getText());
        return noSearchResult.getText().contains("We were unable to find results for");
    }

    public void clickOrClearSearchField() {
        try {
            wait.until(ExpectedConditions.visibilityOf(clearSearch)).click();
            wait.until(ExpectedConditions.elementToBeClickable(searchArea)).click();
        } catch (TimeoutException e) {
            wait.until(ExpectedConditions.elementToBeClickable(searchArea)).click();
        }
    }

    public boolean iSeeQuickFilters() {
        try {
            wait.until(ExpectedConditions.visibilityOf(filter));
            return (filter.getText().contains("Aisle") || filter.getText().contains("Deals"));
        } catch (TimeoutException e) {
            Log.info("Filter not found");
            return false;
        }
    }

    public void clickOnFirstFilterOption() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dealFilter));
        driver.findElements(dealFilter).get(0).click();
    }

    public boolean validateNumberOfProducts() {
        wait.until(ExpectedConditions.visibilityOf(totalResultsHeading));
        String headingText = totalResultsHeading.getText();
        Log.info(headingText);
        Pattern pattern = Pattern.compile("SHOWING (\\d+) RESULTS FOR \"(.+?)\"");
        Matcher matcher = pattern.matcher(headingText);
        if (matcher.find()) {
            int actualCount = Integer.parseInt(matcher.group(1));
            String searchTerm = matcher.group(2);
            return totalResultsHeading.isDisplayed() && actualCount > 0 && !searchTerm.isEmpty();
        } else {
            return false;
        }
    }

    public void allOtherBehaviourOnSrp() {
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(clearAllButton));
        clearAllButton.click();
        wait.until(ExpectedConditions.visibilityOf(sortByButton));
        sortByButton.click();
        wait.until(ExpectedConditions.visibilityOf(lowToHighFilter));
        action.moveToElement(lowToHighFilter).click().build().perform();
    }

    public boolean validateVisibilitySubFilter() {
        try {
            wait.until(ExpectedConditions.visibilityOf(subFilter));
            return subFilter.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("Sub filter is not display");
            return false;
        }
    }

    public void clickOnAisle() {
        wait.until(ExpectedConditions.visibilityOf(aisle));
        aisle.click();
    }

    public boolean validateVisibilityOfAisleItem() {
        try {
            wait.until(ExpectedConditions.visibilityOf(subFilter));
        } catch (TimeoutException e) {
            clickOnAisle();
            wait.until(ExpectedConditions.visibilityOf(subFilter));
        }
        return subFilter.isDisplayed();
    }

    public void selectFirstQuickFilter() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(quickFilterOptions));
        driver.findElements(quickFilterOptions).get(0).click();
    }

    public boolean validateVisibilitySelectedFilter() {
        try {
            wait.until(ExpectedConditions.visibilityOf(selectedQuickFilter));
            return selectedQuickFilter.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("No filter selected");
            return false;
        }
    }
}
