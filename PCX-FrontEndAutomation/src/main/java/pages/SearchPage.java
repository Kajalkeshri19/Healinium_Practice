package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SearchPage {

    WebDriver driver;
    Random random;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = ThreadLocalRandom.current();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

       //pcx locators
    @FindBy(css = "input.search-input__input") public WebElement searchArea;
    @FindBy(css = "h1.page-title__title") public WebElement searchResultHeading;
    @FindBy(css = "ul.product-tile-group__list") public WebElement productGrid;
    @FindBy(css = "ul.typeahead-suggestion-list") public WebElement recommendedSearchList;
    @FindBy(css = "div.filter-group-list") public WebElement filterGroupList;
    @FindBy(css = "button.styled-dropdown__selected-item-link") public WebElement sortBy;
    @FindBy(css = "div.block-cta-bar--block-theme-dark") WebElement pcxBanner;
    @FindBy(css = "h1.search-no-results__section-title") WebElement noSearchResult;
    @FindBy(css = "div.search-no-results__search-form") WebElement noSearchResultArea;
    @FindBy(css = "div.block-tile-list-overflow-wrapping") WebElement startBrowsingCategory;
    @FindBy(css = "li.typeahead-suggestion-list-item--your-search") WebElement searchedHistory;
    @FindBy(css = "button[aria-label='Clear all filters']") WebElement clearAllFilter;
    @FindBy(css = ".quick-filters__label") WebElement quickFilter;
    By filterOptions = By.cssSelector("button.quick-filters__chips--quick-filter");
    By filterClose = By.cssSelector("span[aria-label='Remove filter']");
    By sortByList = By.cssSelector(".styled-dropdown__list-item-link");



    public void clickOnSearchField() {
        wait.until(ExpectedConditions.elementToBeClickable(searchArea));
        searchArea.click();
    }
    public void searchTheProduct(String product) {
        wait.until(ExpectedConditions.elementToBeClickable(searchArea)).click();
        Log.info("Search term :"+searchArea.getAttribute("value"));
        searchArea.sendKeys(product);
        searchArea.sendKeys(Keys.ENTER);
    }

    public boolean validateTheSearchGrid() {
        wait.until(ExpectedConditions.visibilityOf(searchResultHeading));
        wait.until(ExpectedConditions.visibilityOf(productGrid));
        return searchResultHeading.isDisplayed() && productGrid.isDisplayed();
    }

    public boolean validateSearchTermOnTopLeft() {
        wait.until(ExpectedConditions.visibilityOf(searchResultHeading));
        Log.info(searchResultHeading.getText());
        return searchResultHeading.getText().contains("MILK");
    }

    public void checkForRecommendedSearch(String product) {
        wait.until(ExpectedConditions.elementToBeClickable(searchArea)).click();
        searchArea.sendKeys(product);
    }

    public boolean validateReleatedSearch() {
        wait.until(ExpectedConditions.visibilityOf(recommendedSearchList));
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

    public boolean validateAislesAndFilter() {
        /**
         *  TODO: We can assert the via pattern there. Like we did in JF.
         */
        wait.until(ExpectedConditions.visibilityOf(searchResultHeading));
        return filterGroupList.isDisplayed();
    }

    public boolean validatePcxBanner() {
        wait.until(ExpectedConditions.visibilityOf(sortBy));
        return pcxBanner.isDisplayed();
    }

    public boolean validateNoResult() {
        wait.until(ExpectedConditions.visibilityOf(noSearchResult));
        return noSearchResultArea.isDisplayed() && noSearchResult.isDisplayed() &&
                noSearchResult.getText().matches("We were unable to find results for \"+\\w+\"");
    }

    public boolean validateCategoriesDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(startBrowsingCategory));
        return startBrowsingCategory.isDisplayed();
    }

    public boolean validatePreviousSearch() {
        wait.until(ExpectedConditions.visibilityOf(searchedHistory));
        return searchedHistory.isDisplayed();
    }

    public void selectFilter(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(filterOptions));
        List<WebElement> filters = driver.findElements(filterOptions);
        filters.get(0).click();
    }
    public void closeFirstFilterOption(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(filterClose));
        List<WebElement> closeList = driver.findElements(filterClose);
        closeList.get(0).click();
    }
    public boolean validateRemainFilterOption(){
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(filterClose));
            List<WebElement> closeList = driver.findElements(filterClose);
            return !closeList.isEmpty();
    }
    public void clickOnClearAllFilter(){
        wait.until(ExpectedConditions.visibilityOf(clearAllFilter));
        clearAllFilter.click();
    }
    public boolean validateAllFiltersRemove(){
            wait.until(ExpectedConditions.invisibilityOf(clearAllFilter));
            return true;
    }

    public void clickOnSortByAndSelectFirstOption(){
        wait.until(ExpectedConditions.visibilityOf(sortBy));
        sortBy.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sortByList));
        List<WebElement> list = driver.findElements(sortByList);
        list.get(1).click();
    }
    public boolean validateSortedResultContain(String text){
        wait.until(ExpectedConditions.visibilityOf(sortBy));
        Log.info(sortBy.getText());
        return sortBy.getText().equals(text);
    }
    public boolean validateTotalNumberOfResult(){
        wait.until(ExpectedConditions.visibilityOf(searchResultHeading));
        try {
            Log.info("Total result : "+Integer.parseInt(searchResultHeading.getText().split(" ")[1]));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
   public boolean validateQuickFilter(){
       wait.until(ExpectedConditions.visibilityOf(searchResultHeading));
       return quickFilter.isDisplayed();
   }
}
