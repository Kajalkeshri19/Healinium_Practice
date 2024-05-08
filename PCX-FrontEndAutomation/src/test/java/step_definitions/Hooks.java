package step_definitions;

import ddt_config.DataReader;
import ddt_config.ExcelDataReader;
import ddt_config.ReaderConfig;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import resources.ProjectConfig;
import org.openqa.selenium.*;
import util.Log;
import util.TestContextSetup;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Hooks {
    TestContextSetup tcs;

    public Hooks(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Before("not @Header and not @Rapid and not @RapidServiceable")
    public void beforeScenario() throws  IOException {
        try {
            tcs.pom.getFooterPage().closeFooterNotificationWithRetry();
        }catch (TimeoutException | ElementClickInterceptedException exception){
            Log.info("Page not loaded properly, trying to reload the website by closing the previous tab.");
            tcs.base.reloadTheWebsite();
            tcs.pom.getFooterPage().closeFooterNotificationWithRetry();
        }
        if(tcs.base.getDriver().getCurrentUrl().contentEquals(tcs.base.loadProperties("productionUrl"))) {
            tcs.base.setSiteCookie();
            tcs.base.getDriver().navigate().refresh();
        }
        tcs.pom.getHeader().updateTheStore(ProjectConfig.TEST_PROMOTION_DELIVERY_CODE);
        tcs.pom.getHeader().selectTheStore(ProjectConfig.TEST_PROMOTION_STORE_NAME);
    }

    @Before("@Rapid")
    public void beforeScenarios() {
        tcs.pom.getHeader().selectTheStoreOnRapid("2255 McGillivray Blvd, Winnipeg, MB, R3Y 0A1");
    }

    @Before("@WholesaleCart")
    public void beforeScenarioss() throws IOException {
        tcs.pom.getCart().goToWscBanner();
        try {
            tcs.pom.getFooterPage().closeFooterNotificationWithRetry();
        }catch (TimeoutException | ElementClickInterceptedException exception){
            Log.info("Page not loaded properly, trying to reload the website by closing the previous tab.");
            tcs.base.reloadTheWebsite();
            tcs.pom.getFooterPage().closeFooterNotificationWithRetry();
        }
        tcs.pom.getHeader().updateTheStore(ProjectConfig.WHOLESALE_DELIVERY_CODE);
        tcs.pom.getHeader().selectTheStore(ProjectConfig.WHOLESALE_STORE_NAME);
    }

    @Before("@RapidServiceable")
    public void startScenario()  {
        tcs.pom.getHeader().selectTheStoreOnRapid("6 Leslie St, Toronto, ON, M4M 3H7");
    }

    @Before("@Header")

    public void beforeHeaderScenarios() throws IOException {
        try {
            tcs.pom.getFooterPage().closeFooterNotificationWithRetry();
        }catch (TimeoutException | ElementClickInterceptedException exception){
            Log.info("Page not loaded properly, trying to reload the website by closing the previous tab.");
            tcs.base.reloadTheWebsite();
            tcs.pom.getFooterPage().closeFooterNotificationWithRetry();
        }
    }

    @DataTableType
    public DataReader excelToDataTable(Map<String, String> entry) {
        ReaderConfig config = new ReaderConfig.ReaderConfigBuilder().setFileName(entry.get("Excel")).setFileLocation(entry.get("Location")).setSheetName(entry.get("Sheet")).setColumnName(Integer.parseInt(entry.getOrDefault("ColumnHeader", "0"))).setIndex(Integer.valueOf(entry.getOrDefault("Index", "0"))).build();
        return new ExcelDataReader(config);
    }


    @After
    public void afterScenario() throws IOException {
        tcs.base.initializeDriver().quit();
    }


    @AfterStep
    public void takeScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = tcs.base.getDriver();
        if (scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }
    }


}
