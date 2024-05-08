package resources;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class CommonUtility {

    /**
     * Common Utility has methods that are being repeatedly used in code.
     * Instead of duplicating single operation in different files, we have created utility methods
     **/
    WebDriver driver;
    WebDriverWait wait;
    Base base;
    Faker faker;
    Random random;
    public CommonUtility(WebDriver driver) {
        this.driver= driver;
        base=new Base();
        wait=new WebDriverWait(driver, ProjectConfig.DEFAULT_TIMEOUT);
        faker=new Faker();
        random=new Random();
    }

    /**
     * This method determine if element is visible or not for defined timeout duration
     * **/

    public void waitForElementVisibility(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (TimeoutException timeoutException){
            Log.error("Element "+ element +"is not visible until defined timeout");
        }
    }

    /**
     * This method determine if all the defined elements are visible or not for defined timeout duration
     * **/
    public void waitForElementVisibility(List<WebElement> listOfElements){
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(listOfElements));
        }
        catch (TimeoutException timeoutException){
            Log.error("Element"+ listOfElements +"are not visible until defined timeout");
        }
    }

    /**
     * This element clicks an element on the wep page. In case where .click() method by Selenium fails,
     * it will click an element through JavaScript executor.
     * */
    public void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            //Selenium Click Method
            element.click();
        }
        catch (ElementClickInterceptedException elementClickInterceptedException){
            Log.error("Error encountered: "+elementClickInterceptedException.toString());
            /*JavaScript command to click an element if
            Selenium click throws ElementClickIntercepted Exception*/
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
        }
        catch (Exception exception){
            Log.error("Exception occurred while click action :"+exception.toString());
            Log.error("Click action cannot be performed on "+element);
        }
    }

    /**
     * This method convert the String type into integer.
     * */

    public int convertStringToInteger(String text){
        return Integer.parseInt(text);
    }

    public String generateRandomFirstName(){
        return faker.name().firstName();
    }

    public String generateRandomLastName(){
        return faker.name().lastName();
    }

    public String generateRandomPhoneNumber(){
        return "9"+faker.number().digits(9);
    }

    public String generateRandomStreetAddress(){
        return faker.address().streetAddress();
    }

  public boolean validateIfElementIsVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public String generateRandomDescription(){
        return faker.lorem().characters(3,150,true);
    }


    public WebElement selectAnyElementRandomly(List<WebElement> webElementList,int maxLimit){
        waitForElementVisibility(webElementList);
        Log.info("List Size: "+webElementList.size());
        Log.info("Max Limit: "+maxLimit);
        return webElementList.get(random.nextInt(maxLimit));
    }

    public int generateRandomNumber(int maxLimit){
        return random.nextInt(maxLimit);
    }

    public Double convertStringToDouble(String text){
        return Double.parseDouble(text);
    }

    public WebElement selectAnyElementRandomly(List<WebElement> webElementList){
        waitForElementVisibility(webElementList);
        return webElementList.get(random.nextInt(webElementList.size()));
    }

    public boolean validateIfElementIsNotPresent(By elementLocators) {
        return driver.findElements(elementLocators).isEmpty();
    }

    // Removes all non-numeric characters, leaving only the digits and convert it to an integer
    public Integer removeCharacters(String text) {
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public boolean validateElementVisibility(WebElement element){
        waitForElementVisibility(element);
        return element.isDisplayed();
    }

    public void openSite(String site){
        ((JavascriptExecutor) driver).executeScript("window.open('" + site + "', '_blank');");
    }

    /**
     * Switches to the first tab
     */
    public void switchToTab(int index) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    /**
     * Waits for invisibility of a WebElement on the web page.
     */
    public void waitForElementInvisibility(WebElement element){
        try{
            wait.until(ExpectedConditions.invisibilityOf(element));
        }catch (TimeoutException | NoSuchElementException exception){
            Log.error("Element"+ element +"is visible until defined timeout");
        }
    }

    /**
     * Waits for all WebElements in the given list to be visible on the web page.
     *
     * @param element The WebElement whose text is to be matched.
     * @param text    the text which is to be matched with element's text
     * @throws TimeoutException If the text is not present in the element is not achieved within the specified timeout period.
     */
    public void waitForTextToBePresentInElement(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (TimeoutException exception) {
            Log.info("TimeoutException while waiting for text : " + text + ", to be present in the element: " + element + "\n" + exception.getMessage());
        }
    }

    public void waitForTextNotToBePresentInElement(WebElement element, String text) {
        try {
            wait.until(not(ExpectedConditions.textToBePresentInElement(element, text)));
        } catch (TimeoutException exception) {
            Log.info("TimeoutException while waiting for text : " + text + ", to be present in the element: " + element + "\n" + exception.getMessage());
        }
    }

    public boolean validateElementContainsText(WebElement webElement, String text) {
        waitForElementVisibility(webElement);
        return webElement.getText().contains(text);
    }

    public boolean validateElementMatchesPattern(WebElement webElement, String text) {
        return webElement.getText().matches(text);
    }

    /**
     * Extracts the integer part from the sub-total value, by removing the dollar sign and the decimal part
     * @return integer part of the web element value
     */
    public int removeDollarSignAndDecimalDigits(String text) {
        Log.info(text);
        int indexOfDecimal = text.indexOf(".");
        if(indexOfDecimal > 0){
            return Integer.parseInt(text.substring(1, indexOfDecimal));
        }else{
            return indexOfDecimal;
        }
    }

    /**
     * Deletes all text from an input element
     * @param inputBoxElement an input web element
     */
    public void clearTheInputBoxElement(WebElement inputBoxElement) {
        waitForElementVisibility(inputBoxElement);
        inputBoxElement.sendKeys(Keys.CONTROL + "a");
        inputBoxElement.sendKeys(Keys.DELETE);
    }

    /**
     * Validates if the text content of a WebElement matches the expected currency pattern.
     * @param webElement The WebElement containing the text to be validated.
     * @return {@code true} if the text matches the expected currency pattern, {@code false} otherwise.
     */
    public boolean validateCurrencyPattern(WebElement webElement) {
        String regexPattern = "\\$\\d+\\.\\d{2}";
        return validateElementMatchesPattern(webElement, regexPattern);
    }
}
