package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.Log;
import util.TestContextSetup;

import java.io.IOException;

public class ServicesStepDefinition {
    TestContextSetup tcs;

    public ServicesStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I am a user who is on banner.ca")
    public void iAmAUserWhoIsOnBannerCa() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfSignInButton());
    }

    @When("I click into Services > Pharmacy in the navigation")
    public void iClickIntoServicesPharmacyInTheNavigation() {
        tcs.pom.getServicesPage().clickOnServicePharmacy();
    }

    @Then("I want to be taken to the pharmacy homepage")
    public void iWantToBeTakenToThePharmacyHomepage() {
        Assert.assertTrue(tcs.pom.getServicesPage().validatePharmacyHomePage());
    }

    @And("I should see copy explaining what the Pharmacy service is")
    public void iShouldSeeCopyExplainingWhatThePharmacyServiceIs() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateExplainOfPharmacyServices());
    }

    @And("I should see the location I have in my header repeated on the page")
    public void iShouldSeeTheLocationIHaveInMyHeaderRepeatedOnThePage() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfLocation());
    }

    @And("I should see Pharmacy hours for today")
    public void iShouldSeePharmacyHoursForToday() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfTodayHours());
    }

    @And("I should see the telephone, fax, pharmacy manager & Pharmacy license # details")
    public void iShouldSeeTheTelephoneFaxPharmacyManagerPharmacyLicenseDetails() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfServiceDetails());

    }

    @And("I should see the licensing body information \\(incl. licensed by,addrss, tel, fax & logo)")
    public void iShouldSeeTheLicensingBodyInformationInclLicensedByAddrssTelFaxLogo() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfLicensingDetails());
    }

    @And("I should see Pharmacy hours for the entire week")
    public void iShouldSeePharmacyHoursForTheEntireWeek() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfHoursEntireWeek());
    }

    @And("I should be able to select another location where the service is available \\(clicking this will take me to a store locator page)")
    public void iShouldBeAbleToSelectAnotherLocationWhereTheServiceIsAvailableClickingThisWillTakeMeToAStoreLocatorPage() {
        tcs.pom.getServicesPage().selectLocation("LONSDALE CITY MARKET");//17 LESLIE ST, TORONTO, ONTARIO M4M 3H9
    }

    @And("I should see a banner with Health Matters Here information with a disclaimer drawer")
    public void iShouldSeeABannerWithHealthMattersHereInformationWithADisclaimerDrawer() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfHealthMatterBanner());
    }

    @And("I should see six relevant content modules \\(captured in next test case)")
    public void iShouldSeeSixRelevantContentModulesCapturedInNextTestCase() {
        /**
         TODO:
         **/
    }

    @And("I should see pharamcy services description")
    public void iShouldSeePharamcyServicesDescription() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateDescriptionOfPharmacyServices());
    }


    @And("I should see legal disclaimer")
    public void iShouldSeeLegalDisclaimer() {
        Assert.assertTrue(tcs.pom.getServicesPage().validatePharmacyLegalDisclaimer());
    }

    @When("I click into Services > Pharmacy in the navigation and go to the Pharmacy Services page,")
    public void iClickIntoServicesPharmacyInTheNavigationAndGoToThePharmacyServicesPage() {
        tcs.pom.getServicesPage().clickOnServicePharmacy();
        Assert.assertTrue(tcs.pom.getServicesPage().validatePharmacyHomePage());
    }

    @Then("I should see the following six relevant content modules, with a title, body copy and CTA for each:")
    public void iShouldSeeTheFollowingSixRelevantContentModulesWithATitleBodyCopyAndCTAForEach() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfAllContentModules());
    }

    @And("Flu Shots are Now Available")
    public void fluShotsAreNowAvailable() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateFlueShotModule("Flu Season"));
    }

    @And("COVID-19 Vaccines available")
    public void covidVaccinesAvailable() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateCovidVaccinesModule("COVID-19"));
    }

    @And("Submit a photo of prescription")
    public void submitAPhotoOfPrescription() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateSubmitAPhotoOfPrescriptionModule("photo of your new prescription"));
    }

    @And("Naloxone Kits")
    public void naloxoneKits() {
//Naloxone Kits Module not found on pharmacy services
//        Assert.assertTrue(tcs.pom.getServicesPage().validateNaloxoneKitsModule("NALOXONE KITS"));
    }

    @And("Opiod Agonist Therapy")
    public void opiodAgonistTherapy() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateOpiodAgonistTherapyModule("Opioid Agonist Therapy"));
    }

    @And("Adult Vaccinations")
    public void adultVaccinations() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateAdultVaccinationsModule("Adult Vaccinations"));
    }

    @And("Medication Plan")
    public void medicationPlan() {
//Medication Plan Module not found on pharmacy services
//      Assert.assertTrue(tcs.pom.getServicesPage().validateMedicationPlanModule("MEDICATIONS"));
    }

    @When("I click into Services > Pharmacy and click the Flu Shots content module")
    public void iClickIntoServicesPharmacyAndClickTheFluShotsContentModule() {
        tcs.pom.getServicesPage().clickOnServicePharmacy();
        tcs.pom.getServicesPage().clickOnFlueShotModule();
    }

    @Then("A new tab should open and I shoud be taken to {string}")
    public void aNewTabShouldOpenAndIShoudBeTakenToHttpsWwwLoblawsCaFluIcidDrxfluShotsctaWell(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().isNewTabOpen());
        Log.info("URL:"+tcs.base.loadProperties("url")+url);
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
    }
    @And("then I should see a button to go to {string}")
    public void thenIShouldSeeAButtonToGoToHttpsWwwShoppersdrugmartCaEnHealthAndPharmacyPharmacyServicesFluShot(String url) {
        Assert.assertTrue(tcs.pom.getServicesPage().isButtonVisible());
        tcs.pom.getServicesPage().clickOnBookNow();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(url));
    }

    @When("I click into Services > Pharmacy and click the Naloxone Kit content module")
    public void iClickIntoServicesPharmacyAndClickTheNaloxoneKitContentModule() {
        tcs.pom.getServicesPage().clickOnServicePharmacy();
        tcs.pom.getServicesPage().clickOnNaloxoneKitContentModule();
    }

    @Then("I should be taken to {string}")
    public void iShouldBeTakenToHttpsWwwLoblawsCaNaloxone(String url) throws IOException {
        Log.info("URL: "+tcs.base.loadProperties("url")+url);
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
    }

    @And("I should see a header module with a title and copy")
    public void iShouldSeeAHeaderModuleWithATitleAndCopy() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfModuleHeader());
    }

    @And("I should see a description of what Nalaxone is, what is in a kit and who should get a kit")
    public void iShouldSeeADescriptionOfWhatNalaxoneIsWhatIsInAKitAndWhoShouldGetAKit() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfNaloxoneDescription());
    }

    @When("I click into Services > Pharmacy and click the Opiod Agonist content module")
    public void iClickIntoServicesPharmacyAndClickTheOpiodAgonistContentModule() {
        tcs.pom.getServicesPage().clickOnServicePharmacy();
        tcs.pom.getServicesPage().clickOnOpiodAgonist();
    }

    @And("I should see a description of what Opiod Agonist Therapy is")
    public void iShouldSeeADescriptionOfWhatOpiodAgonistTherapyIs() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfOpiodDescription());
    }

    @And("I should be able to click Back to Pharmacy to go back")
    public void iShouldBeAbleToClickBackToPharmacyToGoBack() {
        Assert.assertTrue(tcs.pom.getServicesPage().amIAbleToClickBack());
    }

    @When("I click into Services > Pharmacy and click the Medication Plan content module")
    public void iClickIntoServicesPharmacyAndClickTheMedicationPlanContentModule() {
        tcs.pom.getServicesPage().clickOnServicePharmacy();
        tcs.pom.getServicesPage().clickOnMedicationPlan();
    }


    @And("I should see four content modules with a title & CTA:")
    public void iShouldSeeFourContentModulesWithATitleCTA() {
        //Done in following steps
    }


    @And("Medication Review & FAQs: {string}")
    public void medicationReviewFAQsHttpsWwwLoblawsCaMedicationReviewsFrequentlyAskedQuestions(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().validateMedicationReviewModule());
        tcs.pom.getServicesPage().clickOnMedicationCTA();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.pom.getServicesPage().navigateBack();
    }

    @And("Questions for your pharmacist: {string}")
    public void questionsForYourPharmacistHttpsWwwLoblawsCaQuestionsForYourPharmacist(String url) throws IOException {
        tcs.base.getDriver().navigate().back();
        //tcs.base.getDriver().navigate().back();
        Assert.assertTrue(tcs.pom.getServicesPage().validateQuestionsForPharmacistModule());
        tcs.pom.getServicesPage().clickOnQuestionPharmacistCTA();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.pom.getServicesPage().navigateBack();
    }

    @And("Key Benefits of a Medication Review: {string}")
    public void keyBenefitsOfAMedicationReviewHttpsWwwLoblawsCaKeyBenefitsOfAMedicationReviewWithYourPharmacist(String url) throws IOException {
        tcs.base.getDriver().navigate().back();
        //tcs.base.getDriver().navigate().back();
        Assert.assertTrue(tcs.pom.getServicesPage().validateKeyBenefitsMedicationModule());
        tcs.pom.getServicesPage().clickOnBenefitsCTA();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.pom.getServicesPage().navigateBack();
    }

    @And("Strategies for Sticking with your Medication: {string}")
    public void strategiesForStickingWithYourMedicationHttpsWwwLoblawsCaStrategiesForStickingWithYourMedication(String url) throws IOException {
        tcs.base.getDriver().navigate().back();
        //tcs.base.getDriver().navigate().back();
        Assert.assertTrue(tcs.pom.getServicesPage().validateStrategiesStickingMedicationModule());
        tcs.pom.getServicesPage().clickOnStickingMedicationCTA();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.pom.getServicesPage().navigateBack();
    }

    @When("I click into Services > Pharmacy and click the Adult Vaccinations content module")
    public void iClickIntoServicesPharmacyAndClickTheAdultVaccinationsContentModule() {
        tcs.pom.getServicesPage().clickOnServicePharmacy();
        tcs.pom.getServicesPage().clickOnAdultVaccinations();
    }

    @And("an CTA to Book Now clicking will take me to {string}")
    public void anCTAToBookNowClickingWillTakeMeToHttpsLoblawpharmacyMedmeappComScheduleGroupsImmunizationInjection(String url) throws IOException {
        tcs.pom.getServicesPage().clickOnBookNowVaccination();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(url));
        tcs.pom.getServicesPage().switchToOriginalWindow(tcs.base.getDriver().getWindowHandle());
    }

    @And("I should see six content modules with a title & CTA:")
    public void iShouldSeeSixContentModulesWithATitleCTA() {
        //Done in following steps
    }

    @And("Vaccinations & Immunizations: {string}")
    public void vaccinationsImmunizationsHttpsWwwLoblawsCaVaccinationsImmunization(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().validatevaccinationsImmunizationsModule());
        tcs.pom.getServicesPage().clickOnVaccinationReadMore();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.base.getDriver().navigate().back();
        tcs.base.getDriver().navigate().back();
    }

    @And("Why vaccinate?: {string}")
    public void whyVaccinateHttpsWwwLoblawsCaWhyVaccinate(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().validateWhyVaccinateModule());
        tcs.pom.getServicesPage().clickOnWhyVaccinationReadMore();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.base.getDriver().navigate().back();
        tcs.base.getDriver().navigate().back();
    }

    @And("Shingles {string}")
    public void shinglesHttpsWwwLoblawsCaShingles(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().validateShinglesModule());
        tcs.pom.getServicesPage().clickOnShinglesReadMore();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.base.getDriver().navigate().back();
        tcs.base.getDriver().navigate().back();
    }

    @And("Pnemococcal Disease: {string}")
    public void pnemococcalDiseaseHttpsWwwLoblawsCaPneumococcalDisease(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().validatePneumococcalModule());
        tcs.pom.getServicesPage().clickOnPneumococcalReadMore();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.base.getDriver().navigate().back();
        tcs.base.getDriver().navigate().back();
    }

    @And("Hep A & B : {string}")
    public void hepABHttpsWwwLoblawsCaHepatitisAB(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().validateHepatitisAandBModule());
        tcs.pom.getServicesPage().clickOnHepatitisAandBReadMore();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.base.getDriver().navigate().back();
        tcs.base.getDriver().navigate().back();
    }


    @And("HPV {string}")
    public void hpvHttpsWwwLoblawsCaHpv(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().validateHPVModule());
        tcs.pom.getServicesPage().clickOnHPVReadMore();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.base.getDriver().navigate().back();
        tcs.base.getDriver().navigate().back();
    }

    @When("I click into Services > Dietitians in the navigation")
    public void iClickIntoServicesDietitiansInTheNavigation() {
        tcs.pom.getServicesPage().clickOnServiceDietitians();
    }

    @Then("A new tab should open and take me to {string}")
    public void aNewTabShouldOpenAndTakeMeToHttpsWwwDietitianservicesCaNavidFlyoutLDietitians(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().isNewTabOpen());
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(url));
        tcs.pom.getServicesPage().navigateBack();
    }

    @Given("I am a user who is on banner.ca where there IS an Optical service")
    public void iAmAUserWhoIsOnBannerCaWhereThereISAnOpticalService() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfSignInButton());
    }
    @Given("I am a user who is on banner.ca where there IS NOT an Optical service")
    public void iAmAUserWhoIsOnBannerCaWhereThereISNOTAnOpticalService() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfSignInButton());
    }
    @When("I click into Services > Optical in the navigation")
    public void iClickIntoServicesOpticalInTheNavigation() {
        tcs.pom.getServicesPage().clickOnServiceOptical();
    }

    @Then("I want to be taken to the Optical homepage")
    public void iWantToBeTakenToTheOpticalHomepage() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateOpticalHomePage());
    }

    @And("I should see a promotional banner with a CTA to see details")
    public void iShouldSeeAPromotionalBannerWithACTAToSeeDetails() {
       Assert.assertFalse(tcs.pom.getServicesPage().validatePromotionalBanner());
    }

    @And("I should see copy explaining what the Optical service is")
    public void iShouldSeeCopyExplainingWhatTheOpticalServiceIs() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateExplainOfOpticalServices());
    }

    @And("I should see optical legal disclaimer")
    public void iShouldSeeOpticalLegalDisclaimer() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateOpticalLegalDisclaimer());
    }

    @And("I should see Optical hours for today")
    public void iShouldSeeOpticalHoursForToday() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfTodayHours());
    }

    @And("I should see Optical hours for the entire week")
    public void iShouldSeeOpticalHoursForTheEntireWeek() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfHoursEntireWeek());
    }

    @And("I should see four different images with subtitles, body copy and CTAs \\(detailed below):")
    public void iShouldSeeFourDifferentImagesWithSubtitlesBodyCopyAndCTAsDetailedBelow() {
        //Done in following steps
    }

    @And("Prescription Eyewear link: {string}")
    public void prescriptionEyewearLinkHttpsWwwLoblawsCaOpticalInformationPrescription(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().validatePrescriptionEyewearModule());
        tcs.pom.getServicesPage().clickOnPrescriptionEyewearCTA();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.pom.getServicesPage().navigateBack();
    }

    @And("Contact Lenses link: {string}")
    public void contactLensesLinkHttpsWwwLoblawsCaOpticalInformationContact(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().validateContactLensesModule());
        tcs.pom.getServicesPage().clickOnContactLensesCTA();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.pom.getServicesPage().navigateBack();
    }

    @And("Warranty link: {string}")
    public void warrantyLinkHttpsWwwLoblawsCaOpticalInformationWarranty(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().validateWarrantyModule());
        tcs.pom.getServicesPage().clickOnWarrantyCTA();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.pom.getServicesPage().navigateBack();
    }

    @And("Eye exam link: {string}")
    public void eyeExamLinkHttpsWwwLoblawsCaOpticalInformationEye(String url) throws IOException {
        Assert.assertTrue(tcs.pom.getServicesPage().validateEyeExamModule());
        tcs.pom.getServicesPage().clickOnEyeExamCTA();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
        tcs.pom.getServicesPage().navigateBack();
    }

    @And("I should see a banner with brands we carry")
    public void iShouldSeeABannerWithBrandsWeCarry() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfBanner());
    }

    @When("I click into Services > Medical Clinics in the navigation")
    public void iClickIntoServicesMedicalClinicsInTheNavigation() {
        tcs.pom.getServicesPage().clickOnServiceMedicalClinics();
    }

    @Then("I want to be taken to the medical clinics homepage")
    public void iWantToBeTakenToTheMedicalClinicsHomepage() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateMedicalClinicsHomepage());
    }

    @Given("I am a user who is on banner.ca where there IS a Medical Clinics service")
    public void iAmAUserWhoIsOnBannerCaWhereThereISAMedicalClinicsService() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfSignInButton());
    }

    @Given("I am a user who is on banner.ca where there IS NOT a Medical Clinics service")
    public void iAmAUserWhoIsOnBannerCaWhereThereISNOTAMedicalClinicsService() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfSignInButton());
    }
    @When("I click into Services > Medical Clinics")
    public void iClickIntoServicesMedicalClinics() {
        tcs.pom.getServicesPage().clickOnServiceMedicalClinics();
    }

    @Then("I should see Medical Clinics")
    public void iShouldSeeMedicalClinics() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfMedicalClinics());

    }

    @And("I should see copy explaining what the Medical Clinics services is")
    public void iShouldSeeCopyExplainingWhatTheMedicalClinicsServicesIs() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateExplainingOfMedicalClinics());
    }

    @And("I should see Medical Clinic hour for today")
    public void iShouldSeeMedicalClinicHourForToday() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfTodayHours());
    }

    @And("I should see Medical Clinic hours for the entire week")
    public void iShouldSeeMedicalClinicHoursForTheEntireWeek() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfHoursEntireWeek());
    }

    @Given("I am a user who is on the banners mentioned")
    public void iAmAUserWhoIsOnTheBannersMentioned() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfSignInButton());
    }

    @When("I click into Services >C Shop Cannabis in the navigation")
    public void iClickIntoServicesCShopCannabisInTheNavigation() {
        tcs.pom.getServicesPage().clickOnServiceCShopCannabis();
    }

    @Then("I want to be taken to the C Shop Cannabis homepage")
    public void iWantToBeTakenToTheCShopCannabisHomepage() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateCShopCannabisHomepage());
    }

    @And("I should see a header with a CTA to take me to c-shop.ca \\(new tab)")
    public void iShouldSeeAHeaderWithACTAToTakeMeToCShopCaNewTab() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfCShopCTA());
        tcs.pom.getServicesPage().clickOnCShopCTA();
        Assert.assertTrue(tcs.pom.getServicesPage().validateCShopCTANewTab());
    }

    @And("I should see the three locations C shop is available at \\(Dominion, RCSS, Independent)")
    public void iShouldSeeTheThreeLocationsCShopIsAvailableAtDominionRCSSIndependent() {
        Assert.assertTrue(tcs.pom.getServicesPage().validateVisibilityOfThreeLocation());
    }

    @And("I should be able to click Shop Now under each location and be taken to the related menu page for each:")
    public void iShouldBeAbleToClickShopNowUnderEachLocationAndBeTakenToTheRelatedMenuPageForEach() {
        //Done in following steps
    }

    @And("Dominion: {string}")
    public void dominionHttpsWwwCshopcannabisCaNewfoundlandlabradorIcidCscshopStoresnewfoundlandctaHub(String url) throws IOException {
        tcs.pom.getServicesPage().clickOnDominion();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
    }

    @And("RCSS: {string}")
    public void rcssHttpsWwwCshopcannabisCaManitobaIcidCscshopstoresrcssmanitobactaHub(String url) throws IOException {
        tcs.pom.getServicesPage().clickOnRCSS();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
    }

    @And("Independent:  {string}")
    public void independentHttpsWwwCshopcannabisCaOntarioIcidCscshopstoresyigontarioctaHub(String url) throws IOException {
        tcs.pom.getServicesPage().clickOnIndependent();
        Assert.assertTrue(tcs.pom.getServicesPage().amITakenTo(tcs.base.loadProperties("url")+url));
    }
}