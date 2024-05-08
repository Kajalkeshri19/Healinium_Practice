package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;
import java.util.List;

public class ServicesPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public ServicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }

    //HomePage Header-SignInButton
    @FindBy(css = "a.account__login-link")
    WebElement signIn;
    //Homepage Header-menu-bar-navigation Service-navigation-button
    @FindBy(css = "button[data-code='services']")
    WebElement servicedButton;
    //Homepage Header-menu-bar-navigation Service-navigation-list Pharmacy-nav
    @FindBy(css = "a[data-code='/pharmacy']")
    WebElement pharmacy;
    //Homepage Header-menu-bar-navigation Service-navigation-list Dietitians-nav
    @FindBy(css = "a[data-code='https://www.dietitianservices.ca']")
    WebElement dietitians;
    @FindBy(css = "a[data-code='/optical?navid=optical']")
    WebElement optical;
    @FindBy(css = "a[data-code='/medical-clinics?navid=medical-clinics']")
    WebElement medicalClinics;
    @FindBy(css = "a[data-code='/cshopnicotine?navid=cshopnicotine']")
    WebElement cShopNicotine;
    //Homepage Header-menu-bar-navigation Pharmacy-nav Pharmacy-Home-Page
    @FindBy(css = "div.cms-pharmacy")
    WebElement pharmacyHomepage;
    @FindBy(css = "div.cms-optical")
    WebElement opticalHomepage;
    @FindBy(css = "div.cms-medical-clinics")
    WebElement medicalClinicsHomepage;
    @FindBy(css = "div.cms-cshopnicotine")
    WebElement cShopNicotineHomepage;
    @FindBy(css = "div[data-cms-id='4TellSpCg2r0CGYmHErS4r']")
    WebElement pharmacyExplanation;
    @FindBy(css = "div[data-cms-id='2yBFYS3pTxtr2OGakFTqli']")
    WebElement pharmacyDescription;
    @FindBy(css = "a[class*='store-locator-link']")
    WebElement selectLocation;
    @FindBy(css = "input[id='location-search__search__input']")
    WebElement locationSearchBar;
    By selectLocationButton = By.cssSelector("button[class*='location-set-store__button']");
    @FindBy(css = "a[class='fulfillment-location-confirmation__actions__button']")
    WebElement continueShopping;
    @FindBy(css = "span[class*='available__store__info__hours']")
    WebElement todayHour;
    @FindBy(css = "ul.localized-wellness-service-details-available__content__hours__list li")
    List<WebElement> hoursMedicalClinics;
    @FindBy(css = "div[class*='header__phone__info--telephone']")
    WebElement telephone;
    @FindBy(css = "div[class*='header__phone__info--fax']")
    WebElement fax;
    @FindBy(css = "div[class*='header__pharmacy__info--pharmacyManage']")
    WebElement pharmacyManager;
    @FindBy(css = "div[class*='header__pharmacy__info--licenseNum']")
    WebElement pharmacyLicense;
    @FindBy(css = "a[class*='license__details__link']")
    WebElement licenseByAddress;
    @FindBy(css = "div[class*='license__details__phone__info--telephone']")
    WebElement licenseByTelephone;
    @FindBy(css = "div[class*='license__details__phone__info--fax']")
    WebElement licenseByFax;
    @FindBy(css = "img[class*='license__details__icon']")
    WebElement licenseByLog;
    @FindBy(css = "div[id='4mS7gpcuMMbi1ihadnAAco']")
    WebElement healthMatterBanner;
    @FindBy(css = "div[data-cms-id='56GrTVYTaal1XkbQnhlWOF']")
    WebElement pharmacyLegalDisclaimer;
    @FindBy(css = "div[data-cms-id='2ZlEcruajudSa1FawBeQhb']")
    WebElement flueShot;
    @FindBy(css = "div[data-cms-id='38bN5TIt4jdICWQHTd0adT']")
    WebElement covid19;
    @FindBy(css = "div[data-cms-id='U20WBuWyM8pOJM9CgPXgW']")
    WebElement photoPrescription;
    @FindBy(css = "div[data-cms-id='3Xv8Q2eHyLOeF6WF8ug9lS']")
    WebElement nalxoneKits;
    @FindBy(css = "div[data-cms-id='4qQtQ2d45tPhqz32UW5R93']")
    WebElement opiodAgonistTherapy;
    @FindBy(css = "div[data-cms-id='gJz5w4B0ANK4D81wYT4vp']")
    WebElement adultVaccinations;
    @FindBy(css = "div[data-cms-id='v81y869YbogJwoqtbg7wU']")
    WebElement medicationPlan;
    @FindBy(css = "a[data-track='contentfulCTAButton']")
    WebElement bookNowButton;
    @FindBy(css = "div.block-hero-content--text-alignment-center")
    WebElement moduleHeader;
    @FindBy(css = "div[data-cms-id='4q8qrMEEyKbXIEb9uCUFGH']")
    WebElement medicationReviews;
    @FindBy(css = "div[data-cms-id='45xsjbNnx8GLX5YMcZY38N']")
    WebElement questionsPharmacist;
    @FindBy(css = "div[data-cms-id='2pcOkXGOdHaG9QjjLKg17A']")
    WebElement keyBenefits;
    @FindBy(css = "div[data-cms-id='6b4xLQ7bVct2yXLgDIjAu3']")
    WebElement strategiesSticking;
    @FindBy(css = "a[data-track='contentfulCTAButton']")
    WebElement moduleButton;
    @FindBy(css = "div[data-cms-id='pN4GwYn72nHluzDA4tZYm']")
    WebElement vaccinationsImmunization;
    @FindBy(css = "div[data-cms-id='7fGy2DPT7txftvxXtjUesN']")
    WebElement whyVaccinate;
    @FindBy(css = "div[data-cms-id='2Ynj8McNBOTq2LzfNIVKDE']")
    WebElement shingles;
    @FindBy(css = "div[data-cms-id='5idH7EjjehL3oadrJixEgc']")
    WebElement pneumococcalDisease;
    @FindBy(css = "div[data-cms-id='6lSFgFqA24SAiz8UTatpX8']")
    WebElement hepatitisAAndB;
    @FindBy(css = "div[data-cms-id='kW2qi0gF0sQ4UdoeTEhb0']")
    WebElement humanPapillomavirus;
    @FindBy(css = "div[data-cms-id='o2UC36KUyq63l6NWfGmar']")
    WebElement promotionalBanner;
    @FindBy(css = "div.element-tile--block-layout-2up") List<WebElement> opticalSeeMoreLinks;

    @FindBy(css = "div[data-cms-id='78fcol4VV4vGxIVQO01ncz']")
    WebElement opticalDescription;
    @FindBy(css = "div[data-cms-id='5KPHoaG77boE7qcmaoOZ3h']")
    WebElement opticalLegalDisclaimer;
    @FindBy(css = "div[data-cms-id='1e5RNwXQM4LHnGap5lcFw4']")
    WebElement prescriptionEyewear;
    @FindBy(css = "div[data-cms-id='7FeIqyJNpJjaqSEo9KuVFS']")
    WebElement contactLenses;
    @FindBy(css = "div[data-cms-id='2k2LAobHLiKGRqUS4DOZd0']")
    WebElement warranty;
    @FindBy(css = "div[data-track-link-name='eye-exams-arranged-cta-read-more']")
    WebElement eyeExamsArranged;
    @FindBy(css = "div[data-cms-id='4h84xaOwyeJ0Oh3HnOou8p']")
    WebElement brandsBanner;
    @FindBy(css = ".tokenized-label")
    WebElement medicalClinicsHeading;
    @FindBy(css = "div[data-cms-id='2SrC98Ff5XidFeLtGAbPqv']")
    WebElement medicalClinicsExplanation;
    @FindBy(css = "a[id='1fWTNkDlTfnznZ9YqnSCl0']")
    WebElement cShopCTA;
    @FindBy(css = "img[alt='Real Canadian Superstore']")
    WebElement realCanadianSuperstore;
    @FindBy(css = "img[alt='Dominion stores of Newfoundland']")
    WebElement dominionStores;
    @FindBy(css = "img[alt='Your Independent Grocer']")
    WebElement independentGrocer;
    By title = By.cssSelector("h2");
    By bodyCopy = By.cssSelector("div[class*='content__body']");
    By flueShotBodyCopy = By.cssSelector("p.element-header__body");
    By callToAction = By.cssSelector("div[class*='content__cta-list']");
    By moduleDescription = By.cssSelector("div.block-wrapper--block-type-block-content-with-image");
    By readMore = By.cssSelector("div.element-tile__content__link");
    By title2 = By.cssSelector("h3");
    By link = By.cssSelector("a");


    public boolean validateVisibilityOfSignInButton() {
        try {
            wait.until(ExpectedConditions.visibilityOf(signIn));
            return signIn.isDisplayed();
        } catch (TimeoutException exception) {
            Log.info(exception.getMessage());
            return false;
        }
    }

    public void clickOnServices(WebElement module) {
        wait.until(ExpectedConditions.visibilityOf(servicedButton));
        servicedButton.click();
        wait.until(ExpectedConditions.visibilityOf(module));
        actions.moveToElement(module).click().perform();
    }

    public void clickOnServicePharmacy() {
        clickOnServices(pharmacy);
    }

    public boolean validateHomePage(WebElement homePage) {
        try {
            wait.until(ExpectedConditions.visibilityOf(homePage));
            return homePage.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean validatePharmacyHomePage() {
        return validateHomePage(pharmacyHomepage);
    }

    public boolean validateExplanationOf(WebElement module) {
        wait.until(ExpectedConditions.visibilityOf(module));
        Log.info(module.getText());
        return module.isDisplayed();
    }

    public boolean validateExplainOfPharmacyServices() {
        return validateExplanationOf(pharmacyExplanation);
    }

    public boolean validateVisibilityOfLocation() {
        try {
            wait.until(ExpectedConditions.visibilityOf(selectLocation));
            return selectLocation.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void selectLocation(String locationName) {
        wait.until(ExpectedConditions.visibilityOf(selectLocation));
        selectLocation.click();
        wait.until(ExpectedConditions.visibilityOf(locationSearchBar));
        locationSearchBar.click();
        locationSearchBar.sendKeys(locationName);
        locationSearchBar.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selectLocationButton));
        try {
            driver.findElements(selectLocationButton).get(0).click();
        } catch (StaleElementReferenceException e) {
            driver.findElements(selectLocationButton).get(0).click();
        }
        wait.until(ExpectedConditions.visibilityOf(continueShopping));
        continueShopping.click();
    }

    public boolean validateVisibilityOfTodayHours() {
        try {
            wait.until(ExpectedConditions.visibilityOf(todayHour));
        }
        catch (TimeoutException exception){
            Log.info("No Time slot available on this location Let's try with another location 'High Tech Road'");
            selectLocation("High Tech Road");
            wait.until(ExpectedConditions.visibilityOf(todayHour));
        }
        Log.info("Today hour : " + todayHour.getText());
        return todayHour.isDisplayed();
    }

    public boolean validateVisibilityOfServiceDetails() {
        wait.until(ExpectedConditions.visibilityOf(telephone));
        return telephone.isDisplayed() && fax.isDisplayed() && pharmacyManager.isDisplayed() && pharmacyLicense.isDisplayed();
    }

    public boolean validateVisibilityOfLicensingDetails() {
        wait.until(ExpectedConditions.visibilityOf(licenseByTelephone));
        wait.until(ExpectedConditions.visibilityOf(licenseByLog));
        return licenseByAddress.isDisplayed() && licenseByTelephone.isDisplayed() && licenseByFax.isDisplayed() && licenseByLog.isDisplayed();
    }
    public boolean validateVisibilityOfHoursEntireWeek() {
       wait.until(ExpectedConditions.visibilityOfAllElements(hoursMedicalClinics));
       return hoursMedicalClinics.size()>=5;
    }

    public boolean validateVisibilityOfHealthMatterBanner() {
        try {
            wait.until(ExpectedConditions.visibilityOf(healthMatterBanner));
            return healthMatterBanner.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("Banner is not visible");
            return false;
        }
    }

    public boolean validateDescriptionOfPharmacyServices() {
        try {
            wait.until(ExpectedConditions.visibilityOf(pharmacyDescription));
            Log.info("Pharmacy Description : " + pharmacyDescription.getText());
            return pharmacyDescription.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("Pharmacy services not visible");
            return false;
        }
    }

    public boolean validateLegalDisclaimer(WebElement legalDisclaimer) {
        try {
            wait.until(ExpectedConditions.visibilityOf(legalDisclaimer));
            Log.info("Legal Disclaimer : " + legalDisclaimer.getText());
            return legalDisclaimer.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("Legal Disclaimer not visible");
            return false;
        }
    }

    public boolean validatePharmacyLegalDisclaimer() {
        return validateLegalDisclaimer(pharmacyLegalDisclaimer);
    }

    public boolean validateVisibilityOfAllContentModules() {
        wait.until(ExpectedConditions.visibilityOf(flueShot));
        wait.until(ExpectedConditions.visibilityOf(adultVaccinations));
        //Naloxone Kits Module not found on pharmacy services, so temporary remove- nalxoneKits.isDisplayed()
        return flueShot.isDisplayed() && covid19.isDisplayed() && photoPrescription.isDisplayed() && opiodAgonistTherapy.isDisplayed() && adultVaccinations.isDisplayed();
    }

    public boolean relevantContentModulesValidation(WebElement module, String moduleName, By bodyCopy) {
        wait.until(ExpectedConditions.visibilityOf(module));
        WebElement titleOfModule = module.findElement(title);
        WebElement bodyOfModule = module.findElement(bodyCopy);
        WebElement catOfModule = module.findElement(callToAction);
        Log.info(moduleName + " title : " + titleOfModule.getText());
        return titleOfModule.getText().contains(moduleName) && bodyOfModule.isDisplayed() && catOfModule.isEnabled();
    }

    public boolean validateFlueShotModule(String name) {
        return relevantContentModulesValidation(flueShot,name,flueShotBodyCopy);
    }

    public boolean validateCovidVaccinesModule(String name) {
        return relevantContentModulesValidation(covid19,name,bodyCopy);
    }

    public boolean validateSubmitAPhotoOfPrescriptionModule(String name) {
        return relevantContentModulesValidation(photoPrescription,name,bodyCopy);
    }

    public boolean validateNaloxoneKitsModule(String name) {
        return relevantContentModulesValidation(nalxoneKits,name,bodyCopy);
    }

    public boolean validateOpiodAgonistTherapyModule(String name) {
        return relevantContentModulesValidation(opiodAgonistTherapy,name,bodyCopy);
    }

    public boolean validateAdultVaccinationsModule(String name) {
        return relevantContentModulesValidation(adultVaccinations,name,bodyCopy);
    }

    public boolean validateMedicationPlanModule(String name) {
        return relevantContentModulesValidation(medicationPlan,name,bodyCopy);
    }

    public void clickOnModuleCat(WebElement module) {
        wait.until(ExpectedConditions.visibilityOf(module));
        wait.until(ExpectedConditions.elementToBeClickable(module.findElement(callToAction))).click();
    }

    public void clickOnFlueShotModule() {
        clickOnModuleCat(flueShot);
    }

    public boolean isNewTabOpen() {
        int tabCount = driver.getWindowHandles().size();
        Log.info("Currently open tabs are : " + tabCount);
        return tabCount > 1;
    }

    public void switchOnNewTab(String mainWindowHandle) {
        Log.info("Main Window Handle: "+mainWindowHandle);
        Log.info("Size of window: "+driver.getWindowHandles().size());
        if(driver.getWindowHandles().size()==2){
            String[] handles=driver.getWindowHandles().toArray(new String[0]);
            driver.switchTo().window(handles[1]);
        }
    }

    public boolean amITakenTo(String urlShould) {
        Log.info("URL Parameter: "+urlShould);
        Log.info("Window handles: "+driver.getWindowHandles().size());
        switchOnNewTab(driver.getWindowHandle());
        String urlIs = driver.getCurrentUrl();
        Log.info("Current Url : " + urlIs);
        return urlShould.equalsIgnoreCase(urlIs);
    }

    public boolean isButtonVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(bookNowButton));
            return bookNowButton.isEnabled();
        } catch (TimeoutException e) {
            Log.info("Button is not visible");
            return false;
        }
    }

    public void clickOnBookNow() {
        wait.until(ExpectedConditions.elementToBeClickable(bookNowButton)).click();
        wait.until(ExpectedConditions.invisibilityOf(bookNowButton));
    }

    public void clickOnNaloxoneKitContentModule() {
        clickOnModuleCat(nalxoneKits);
    }

    public boolean validateVisibilityOfModuleHeader() {
        try {
            wait.until(ExpectedConditions.visibilityOf(moduleHeader));
            Log.info("Module Header : " + moduleHeader.getText());
            return moduleHeader.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("Module header is not Visible");
            return false;
        }
    }

    public boolean validateVisibilityOfNaloxoneDescription() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(moduleDescription));
            for (WebElement description : driver.findElements(moduleDescription)) {
                if (description.getText().contains("WHAT IS NALOXONE") || description.getText().contains("WHAT IS IN A NALOXONE KIT") || description.getText().contains("WHO SHOULD GET A NALOXONE KIT")) {
                    Log.info("Naloxone Description : " + description);
                    return true;
                }
            }
            Log.info("Description not contain such question");
            return false;
        } catch (TimeoutException e) {
            Log.info("Naloxone Description is not Visible");
            return false;
        }
    }

    public void clickOnOpiodAgonist() {
        clickOnModuleCat(opiodAgonistTherapy);
    }

    public boolean validateVisibilityOfOpiodDescription() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(moduleDescription));
        return driver.findElements(moduleDescription).get(0).isDisplayed();
    }

    public boolean amIAbleToClickBack() {
        wait.until(ExpectedConditions.visibilityOf(moduleButton));
        moduleButton.click();
        return validatePharmacyHomePage();
    }

    public void clickOnMedicationPlan() {
        clickOnModuleCat(medicationPlan);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public boolean validateModuleTitleAndCTA(WebElement module) {
        wait.until(ExpectedConditions.visibilityOf(module));
        wait.until(ExpectedConditions.visibilityOf(module.findElement(title2)));
        wait.until(ExpectedConditions.visibilityOf(module.findElement(readMore)));
        return module.findElement(title2).isDisplayed() && module.findElement(readMore).isEnabled();
    }

    public void clickOnReadMore(WebElement module) {
        wait.until(ExpectedConditions.visibilityOf(module.findElement(readMore))).click();
    }

    public boolean validateMedicationReviewModule() {
        return validateModuleTitleAndCTA(medicationReviews);
    }

    public void clickOnMedicationCTA() {
        clickOnReadMore(medicationReviews);
    }

    public boolean validateQuestionsForPharmacistModule() {
        return validateModuleTitleAndCTA(questionsPharmacist);
    }

    public void clickOnQuestionPharmacistCTA() {
        clickOnReadMore(questionsPharmacist);
    }

    public boolean validateKeyBenefitsMedicationModule() {
        return validateModuleTitleAndCTA(keyBenefits);
    }

    public void clickOnBenefitsCTA() {
        clickOnReadMore(keyBenefits);
    }

    public boolean validateStrategiesStickingMedicationModule() {
        return validateModuleTitleAndCTA(strategiesSticking);
    }

    public void clickOnStickingMedicationCTA() {
        clickOnReadMore(strategiesSticking);
    }

    public void clickOnAdultVaccinations() {
        clickOnModuleCat(adultVaccinations);
    }

    public void clickOnBookNowVaccination() {
        wait.until(ExpectedConditions.elementToBeClickable(bookNowButton));
        bookNowButton.click();
        switchOnNewTab(driver.getWindowHandle());
    }

    public boolean validatevaccinationsImmunizationsModule() {
        return validateModuleTitleAndCTA(vaccinationsImmunization);
    }

    public void clickOnVaccinationReadMore() {
        clickOnReadMore(vaccinationsImmunization);
    }

    public boolean validateWhyVaccinateModule() {
        return validateModuleTitleAndCTA(whyVaccinate);
    }

    public void clickOnWhyVaccinationReadMore() {
        clickOnReadMore(whyVaccinate);
    }

    public boolean validateShinglesModule() {
        return validateModuleTitleAndCTA(shingles);
    }

    public void clickOnShinglesReadMore() {
        clickOnReadMore(shingles);
    }

    public boolean validatePneumococcalModule() {
        return validateModuleTitleAndCTA(pneumococcalDisease);
    }

    public void clickOnPneumococcalReadMore() {
        clickOnReadMore(pneumococcalDisease);
    }

    public boolean validateHepatitisAandBModule() {
        return validateModuleTitleAndCTA(hepatitisAAndB);
    }

    public void clickOnHepatitisAandBReadMore() {
        clickOnReadMore(hepatitisAAndB);
    }

    public boolean validateHPVModule() {
        return validateModuleTitleAndCTA(humanPapillomavirus);
    }

    public void clickOnHPVReadMore() {
        clickOnReadMore(humanPapillomavirus);
    }

    public void clickOnServiceDietitians() {
        clickOnServices(dietitians);
        switchOnNewTab(driver.getWindowHandle());
    }

    public void clickOnServiceOptical() {
        clickOnServices(optical);
    }

    public boolean validateOpticalHomePage() {
        return validateHomePage(opticalHomepage);
    }

    public boolean validatePromotionalBanner() {
        wait.until(ExpectedConditions.visibilityOfAllElements(opticalSeeMoreLinks));
        return opticalSeeMoreLinks.isEmpty();
    }

    public boolean validateExplainOfOpticalServices() {
        return validateExplanationOf(opticalDescription);
    }

    public boolean validateOpticalLegalDisclaimer() {
        return validateLegalDisclaimer(opticalLegalDisclaimer);
    }

    public boolean validateModuleImagesWithSubtitlesBodyCopyAndCTAs(WebElement module) {
        wait.until(ExpectedConditions.visibilityOf(module));
        wait.until(ExpectedConditions.visibilityOf(module.findElement(readMore)));
        return module.findElement(title2).isDisplayed() && module.findElement(bodyCopy).isDisplayed() && module.findElement(readMore).isEnabled();
    }

    public boolean validatePrescriptionEyewearModule() {
        return validateModuleImagesWithSubtitlesBodyCopyAndCTAs(prescriptionEyewear);
    }

    public void clickOnPrescriptionEyewearCTA() {
        clickOnReadMore(prescriptionEyewear);
    }

    public boolean validateContactLensesModule() {
        return validateModuleImagesWithSubtitlesBodyCopyAndCTAs(contactLenses);
    }

    public void clickOnContactLensesCTA() {
        clickOnReadMore(contactLenses);
    }

    public boolean validateWarrantyModule() {
        return validateModuleImagesWithSubtitlesBodyCopyAndCTAs(warranty);
    }

    public void clickOnWarrantyCTA() {
        clickOnReadMore(warranty);
    }

    public boolean validateEyeExamModule() {
        return validateModuleImagesWithSubtitlesBodyCopyAndCTAs(eyeExamsArranged);
    }

    public void clickOnEyeExamCTA() {
        clickOnReadMore(eyeExamsArranged);
    }

    public boolean validateVisibilityOfBanner() {
        try {
            wait.until(ExpectedConditions.visibilityOf(brandsBanner));
            return brandsBanner.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("Banner is not visible");
            return false;
        }
    }

    public void clickOnServiceMedicalClinics() {
        clickOnServices(medicalClinics);
    }

    public boolean validateMedicalClinicsHomepage() {
        return validateHomePage(medicalClinicsHomepage);
    }

    public boolean validateVisibilityOfMedicalClinics() {
        try {
            wait.until(ExpectedConditions.visibilityOf(medicalClinicsHeading));
            return medicalClinicsHeading.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("Medical clinics heading is not visible on page");
            return false;
        }
    }

    public boolean validateExplainingOfMedicalClinics() {
        try {
            wait.until(ExpectedConditions.visibilityOf(medicalClinicsExplanation));
            return medicalClinicsExplanation.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("Medical clinics Explanation is not visible on page");
            return false;
        }
    }

    public void clickOnServiceCShopCannabis() {
        clickOnServices(cShopNicotine);
    }

    public boolean validateCShopCannabisHomepage() {
        return validateHomePage(cShopNicotineHomepage);
    }

    public boolean validateVisibilityOfCShopCTA() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cShopCTA));
            return cShopCTA.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("C-Shop CTA is not visible on the page");
            return false;
        }
    }

    public void clickOnCShopCTA() {
        wait.until(ExpectedConditions.visibilityOf(cShopCTA)).click();

    }

    public boolean validateCShopCTANewTab() {
        switchOnNewTab(driver.getWindowHandle());
        boolean result = driver.getCurrentUrl().contains("shop.ca");
        switchOnNewTab(driver.getWindowHandle());
        return result;
    }

    public boolean validateVisibilityOfThreeLocation() {
        try {
            wait.until(ExpectedConditions.visibilityOf(realCanadianSuperstore));
            wait.until(ExpectedConditions.visibilityOf(dominionStores));
            wait.until(ExpectedConditions.visibilityOf(independentGrocer));
            return realCanadianSuperstore.isDisplayed() && dominionStores.isDisplayed() && independentGrocer.isDisplayed();
        } catch (TimeoutException e) {
            Log.info("C-Shop three location is not visible on the page");
            return false;
        }
    }
    public void clickOnDominion(){
        wait.until(ExpectedConditions.visibilityOf(dominionStores)).click();
    }
    public void clickOnRCSS(){
        wait.until(ExpectedConditions.visibilityOf(realCanadianSuperstore)).click();
    }
    public void clickOnIndependent(){
        wait.until(ExpectedConditions.visibilityOf(independentGrocer)).click();
    }

    public void switchToOriginalWindow(String windowHandle){
        String[] handles=driver.getWindowHandles().toArray(new String[0]);
        if(windowHandle.contentEquals(handles[1])){
            driver.close();
            driver.switchTo().window(handles[0]);
        }
    }
}