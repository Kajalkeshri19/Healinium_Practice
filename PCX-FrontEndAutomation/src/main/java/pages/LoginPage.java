package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class LoginPage {

    WebDriver driver;
    Random random;
    WebDriverWait expWait;
    By email = By.id("identifierId");
    By password = By.xpath("//*[contains(@type,\"password\")]");
    @FindBy(xpath = "//span[normalize-space()='Next']")
    private WebElement nextButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = ThreadLocalRandom.current();
        expWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void loginAsFirstUser() {
        expWait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys("gargi.sanadhya@loblaw.ca");
        nextButton.click();
        expWait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("knoldustestauto@0210");
        nextButton.click();
    }


}
