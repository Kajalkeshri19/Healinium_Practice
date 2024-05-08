package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.ProjectConfig;
import util.Log;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PLP {
    WebDriver driver;
    WebDriverWait wait;
    Random random;
    Actions actions;

    public PLP(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, ProjectConfig.DEFAULT_TIMEOUT);
        random=new Random();
        actions=new Actions(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Grocery']")
    WebElement plpCategory;

    @FindBy(xpath = "//span[normalize-space()='Fruits & Vegetables']")
    WebElement fruitsAndVegetables;

    @FindBy(xpath = "//a[@aria-label='Shop all Fresh Vegetables']")
    WebElement shopAll;

    @FindBy(xpath = "//h1[normalize-space()='Fruits & Vegetables']")
    WebElement pageName;

    @FindBy(xpath = "//p[normalize-space()='Brand']")
    WebElement brand;

    @FindBy(css = "label[id='sort-by']")
    WebElement sortBy;

    @FindBy(xpath = "//button[@data-testid='menu-button']")
    WebElement sortByMenu;

    @FindBy(xpath = "//div[@class='social-links']")
    WebElement mediaUnits;

    @FindBy(xpath = "//a[@data-code='/pc-express-pass']")
    WebElement pcxPass;

    @FindBy(xpath = "//span[normalize-space()='PC Organics']")
    WebElement pcOrganics;
    @FindBy(xpath = "//span[normalize-space()='Eat Smart']")
    WebElement eatSmartFilter;

    @FindBy(css = "div[data-testid='filter-chip']")
    WebElement activeFilter;

    @FindBy(xpath = "//div[@data-testid='filter-chip']")
    WebElement customFilter;

    @FindBy(xpath = "//button[normalize-space()='Clear All']")
    WebElement clearAllButton;

    @FindBy(xpath = "//div[@aria-label='Quick filters']")
    WebElement quickFilters;
    @FindAll(@FindBy(css = "div[aria-label='Quick filters'] input")) List<WebElement> quickDeals;
    //CLP product-grid products-title
    @FindBy(css = "ul.product-tile-group__list") public WebElement productGrid;
    //HomePage HeaderButtons
    @FindAll(@FindBy(css = "button.primary-nav__list__item__link")) List<WebElement> headerButtons;
    @FindAll(@FindBy(css = "h3[data-testid='product-title']")) List<WebElement> products;
    //CLP product-grid add-to-cart-button-on-each-product
    @FindAll(@FindBy(css = "button[data-testid='atc-button']")) List<WebElement> allAddToCartButtons;


    //Header header-primary-menu-items main-product-categories
    @FindAll(@FindBy(css = "button.primary-nav__list__item__link--banner")) List<WebElement> primaryMenuItems;
    @FindBy(xpath = "//button[@data-cruller='fulfillment-mode-button']")
    WebElement fulfillmentmodebutton;

    @FindBy(xpath = "//div[@class='switch-fulfillment-mode-button']/button[contains(@data-track-link-name,'switch-to-pickup')]")
    WebElement switchtopickup;

    @FindBy(xpath = "//button[contains(@class,'close-button')][contains(@class,'fulfillment-mode-flyout')]")
    WebElement  closebtn;
   @FindBy (xpath = "//input[@placeholder='Search for product']")
   WebElement searchProduct;
   @FindBy (xpath= "//button[@type='submit']")
   WebElement submit;

   @FindBy (xpath = "(//button[contains(@aria-label,'Add to cart')][contains(@aria-label,'Montreal Smoked')])[1]")
   WebElement addToCartButton;

    By clearFilter= By.cssSelector("button[data-testid='close-filter-chip']");

    By plpList = By.cssSelector("div.chakra-linkbox");

    By filterList = By.cssSelector("button.chakra-accordion__button");

    By filter = By.cssSelector("div[aria-label='Quick filters']");
    By addButton = By.cssSelector("button[data-testid='atc-button']");

    private static final String CLICK_SCRIPT = "arguments[0].click();";

    public boolean iAmOnAPLP() {
            Actions action = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(plpCategory));
            action.moveToElement(plpCategory).build().perform();
            wait.until(ExpectedConditions.visibilityOf(fruitsAndVegetables));
            action.moveToElement(fruitsAndVegetables).click().build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
            List<WebElement> list = driver.findElements(plpList);
            return !list.isEmpty();
    }

    public boolean iSeeGridOfAllProducts() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(plpList));
            List<WebElement> list = driver.findElements(plpList);
            return !list.isEmpty();
    }

    public String getPageName() {
        wait.until(ExpectedConditions.visibilityOf(pageName));
        return pageName.getText();
    }

    public boolean iSeeFilterList() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(filterList));
            List<WebElement> filters = driver.findElements(filterList);
            return !filters.isEmpty();
    }

    public boolean iSeeQuickFilters() {
        wait.until(ExpectedConditions.visibilityOfAllElements(quickDeals));
        return quickDeals.isEmpty();
    }

    public boolean iSeeSortByAndDefaultByRelevance() {
            wait.until(ExpectedConditions.visibilityOf(sortBy));
            wait.until(ExpectedConditions.visibilityOf(sortByMenu));
            return sortBy.isDisplayed() && sortByMenu.isDisplayed() && sortByMenu.getText().contains("Relevance");
    }

    public boolean iSeeMediaUnits() {
            wait.until(ExpectedConditions.visibilityOf(mediaUnits));
            return mediaUnits.isDisplayed();
    }

    public boolean iSeePCXPass() {
            wait.until(ExpectedConditions.visibilityOf(pcxPass));
            return pcxPass.isDisplayed();
    }

    public void iClickOnFilterOnLeftPage() {
        wait.until(ExpectedConditions.visibilityOf(brand));
        ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, brand);
        wait.until(ExpectedConditions.visibilityOf(pcOrganics));
        ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, pcOrganics);
    }
    public void selectOneMoreFilter(){
        wait.until(ExpectedConditions.visibilityOf(eatSmartFilter));
        ((JavascriptExecutor) driver).executeScript(CLICK_SCRIPT, eatSmartFilter);
    }

    public boolean iSeeSelectedfilters() {
        wait.until(ExpectedConditions.visibilityOf(activeFilter));
        Log.info(activeFilter.getText());
        return activeFilter.isDisplayed();
    }

    public void allOtherBehaviourOnPLP() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        List<WebElement> options = driver.findElements(addButton);
        if (!options.isEmpty()) {
            WebElement firstOption = options.get(0);
            firstOption.click();
        }
        wait.until(ExpectedConditions.visibilityOf(quickFilters));
        quickFilters.click();
        wait.until(ExpectedConditions.visibilityOf(clearAllButton));
        clearAllButton.click();
    }

    public boolean removeFilterAndValidateCount() {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class);

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(clearFilter));
        List<WebElement> clearFiltersBefore = driver.findElements(clearFilter);
        int previousFilterCount = clearFiltersBefore.size();
        WebElement randomClearButton = getRandomClearButton(clearFiltersBefore);
        clickClearButton(randomClearButton);
        // Wait until the specific filter button is removed from the DOM
        fluentWait.until(ExpectedConditions.stalenessOf(randomClearButton));
        List<WebElement> clearFiltersAfter = driver.findElements(clearFilter);
        int currentFilterCount = clearFiltersAfter.size();
        // Validate if the filter count is reduced after removal
        return previousFilterCount > currentFilterCount;
    }
    private WebElement getRandomClearButton(List<WebElement> clearFilters) {
        // Generate a random index to select a random clear button
        int randomIndex = new Random().nextInt(clearFilters.size());
        return clearFilters.get(randomIndex);
    }
    private void clickClearButton(WebElement clearButton) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class);
        fluentWait.until(ExpectedConditions.elementToBeClickable(clearButton));
        clearButton.click();
    }

    public boolean iCanSeeOtherFiltersApplied() {
        wait.until(ExpectedConditions.visibilityOf(quickFilters));
        quickFilters.click();
        wait.until(ExpectedConditions.visibilityOf(activeFilter));
        Log.info(activeFilter.getText());
        return activeFilter.isDisplayed();
    }
    public boolean validatePageName(String text){
        wait.until(ExpectedConditions.visibilityOf(pageName));
        Log.info(pageName.getText());
        return pageName.getText().contains(text);
    }

    public void selectPlpRandomly(){
        wait.until(ExpectedConditions.visibilityOfAllElements(headerButtons));
        int headerButtonToBeSelected=random.nextInt(headerButtons.size());
        String dataCodeAttribute=headerButtons.get(headerButtonToBeSelected).getAttribute("data-code");
        headerButtons.get(headerButtonToBeSelected).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[data-code='"+dataCodeAttribute+"']")));
        List<WebElement> availableMenu1=driver.findElements(By.cssSelector("ul[data-code='"+dataCodeAttribute+"']>li>a"));
        int menuLevelToBeSelected=random.nextInt(availableMenu1.size());
        actions.moveToElement(availableMenu1.get(menuLevelToBeSelected)).build().perform();

    }
    //The use of this method is temporary. Please ignore hardcoded locators
     public void selectFreshFruits(){
        wait.until(ExpectedConditions.visibilityOfAllElements(headerButtons));
         driver.findElement(By.cssSelector("button[data-code='xp-455-food-departments']")).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[data-code='xp-455-food-departments']")));
         actions.moveToElement(driver.findElement(By.cssSelector("a[data-code='28000']"))).build().perform();
         wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[data-code='28194']"))));
         actions.moveToElement((driver.findElement(By.cssSelector("a[data-code='28195']")))).click().build().perform();
         wait.until(ExpectedConditions.visibilityOfAllElements(products));
    }
    public String addAnItemViaCLP() {
     // Wait for all add to cart buttons to be visible on the page
    wait.until(ExpectedConditions.visibilityOfAllElements(allAddToCartButtons));
    int itemToBeSelected;
    String plpProductName;
    do {
        //get random item index
        itemToBeSelected = getRandomItem();

        //get the product name for selected item
        plpProductName = getProductName(itemToBeSelected);
        //get the addToCart button for selected item
        WebElement selectedButton = getSelectedButton(itemToBeSelected);
        //validate, the button is for stock or for out of stock item.
        if (selectedButton.isEnabled()) {
            //click add to cart and return
            clickOnButton(selectedButton);
            return plpProductName;
          }
        //repeat the step until got a valid product
        } while (true);
    }

    private int getRandomItem() {
        return random.nextInt(allAddToCartButtons.size());
    }
    private String getProductName(int index) {
        return products.get(index).getText();
    }
    private WebElement getSelectedButton(int index) {
        return allAddToCartButtons.get(index);
    }
    private boolean isValidButton(WebElement button) {
        return button != null && !"true".equals(button.getAttribute("disabled"));
    }
    private void clickOnButton(WebElement button) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }
    public void selectNonDeliverableItem() {
        wait.until(ExpectedConditions.visibilityOfAllElements(headerButtons));
        wait.until(ExpectedConditions.visibilityOf(fulfillmentmodebutton));
        fulfillmentmodebutton.click();
        try {
            switchtopickup.click();
        }
        catch(NoSuchElementException e){

        }
        closebtn.click();
        searchProduct.sendKeys("Montreal Smoked Meat");
        submit.click();
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0]. scrollIntoView(true);", addToCartButton);
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", addToCartButton);
    }


}
