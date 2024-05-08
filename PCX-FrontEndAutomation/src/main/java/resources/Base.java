package resources;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Base {
    private WebDriver driver;
    private static final String ORIGIN_SESSION_COOKIE="Origin_Session_Cookie";
    private static final String BRONX_FEATURE_FLAG="bronxFeatureFlagEnableCartCheckoutAccountBFFMigration";
    private static final String BRONX_FEATURE_PCO="bronxFeatureFlagShowPCORedemption";
    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver initializeDriver() throws IOException {
        if(driver==null){
            String browser=loadProperties("webBrowser");
            Log.info("Executing Browser: "+browser);
            if(browser.equalsIgnoreCase("Chrome")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                Log.info("You have initialized a Chrome driver");
                navigate();
            }
            else if (browser.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
                Log.info("You have initialized a Firefox driver");
                navigate();
            } else if (browser.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
                Log.info("You have initialized a Edge driver");
                navigate();
            } else if (browser.equalsIgnoreCase("Safari")) {
                driver = new SafariDriver();
                Log.info("You have initialized a Safari driver");
                navigate();
            } else if (browser.equalsIgnoreCase("Chrome headless")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("start-maximized");
                options.addArguments("--window-size=1920x1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sendbox");
                options.addArguments("--remote-allow-origins=*");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
                Log.info("You have initialized Chrome in headless mode");
                navigate();
            } else if (browser.equalsIgnoreCase("Remote")) {
                /**
                 *  TODO: BrowserStack Integration
                 */
            } else {
                Log.error("There is some error in Browser name");
            }
        }
        return driver;
        }


    public String loadProperties(String property) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream dataFile = new FileInputStream("src/main/java/resources/data.properties")) {
            properties.load(dataFile);
            return properties.getProperty(property).trim();
        }
    }

    public void navigate() throws IOException {
        driver.manage().window().maximize();
        driver.get(loadProperties("url"));
    }

    public void setSiteCookie() throws IOException {
        if(loadProperties(BRONX_FEATURE_FLAG).equalsIgnoreCase("true")) {
            driver.manage().addCookie(new Cookie(BRONX_FEATURE_FLAG, loadProperties(BRONX_FEATURE_FLAG)));
        }
        driver.navigate().refresh();
        Log.info("Cookie Value:"+driver.manage().getCookieNamed(ORIGIN_SESSION_COOKIE));
        Log.info("Cookie Value:"+driver.manage().getCookieNamed(BRONX_FEATURE_FLAG));
    }
    public void reloadTheWebsite() throws IOException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        navigate();
    }
}
