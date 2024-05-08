package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

public class FooterStepDefinition {
    TestContextSetup tcs;

    public FooterStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }
    @Given("I am on the Homepage footer")
    public void iAmOnTheHomepageFooter() {

    }

    @When("I click on the FAQs under the About PC Express section")
    public void iClickOnTheFAQsUnderTheAboutPCExpressSection() {
        tcs.pom.getFooterPage().goToFaqPage();
    }

    @Then("I should be directed to the FAQs page")
    public void iShouldBeDirectedToTheFAQsPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateFaqPage());
    }

    @When("I click on the PCX How It Works Page under the About PC Express section")
    public void iClickOnThePCXHowItWorksPageUnderTheAboutPCExpressSection() {
        tcs.pom.getFooterPage().goToHowItWorksPage();
    }

    @Then("I should be taken to the PCX How It Works page")
    public void iShouldBeTakenToThePCXHowItWorksPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateHowItWorksPage());
    }

    @When("I click on Delivery Page under the PC Express section")
    public void iClickOnDeliveryPageUnderThePCExpressSection() {
        tcs.pom.getFooterPage().goToDeliveryPage();
    }

    @Then("I should be directed to the PCX Delivery Page about and I should see a Start Shopping button")
    public void iShouldBeDirectedToThePCXDeliveryPageAboutAndIShouldSeeAStartShoppingButton() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateDeliveryPage());
    }

    @When("I click on Pickup Page under the PC Express section")
    public void iClickOnPickupPageUnderThePCExpressSection() {
        tcs.pom.getFooterPage().goToPickupPage();
    }

    @Then("I should be directed to the PCX Pickup Page about and I should see a Start Shopping and Shop Rapid Delivery button")
    public void iShouldBeDirectedToThePCXPickupPageAboutAndIShouldSeeAStartShoppingAndShopRapidDeliveryButton() {
        Assert.assertTrue(tcs.pom.getFooterPage().validatePickupPage());
    }

    @When("I click on Reusable Box Swap under the PC Express section")
    public void iClickOnReusableBoxSwapUnderThePCExpressSection() {
        tcs.pom.getFooterPage().goToReusableBoxSwapPage();
    }

    @Then("I should be directed to the Reusable Box page and I see a description of how the reusable box works")
    public void iShouldBeDirectedToTheReusableBoxPageAndISeeADescriptionOfHowTheReusableBoxWorks() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateReusableBoxPage());
    }

    @And("I should see an option to shop for resuable bags")
    public void iShouldSeeAnOptionToShopForResuableBags() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateShopForReusableBags());
    }

    @And("I should see an option to shop for reusable boxes that directs me to the reusable box item")
    public void iShouldSeeAnOptionToShopForReusableBoxesThatDirectsMeToTheReusableBoxItem() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateShopReusableBoxedRedirect());
    }

    @When("I click on Who We Are under the About Us section")
    public void iClickOnWhoWeAreUnderTheAboutUsSection() {
        tcs.pom.getFooterPage().goToWhoWeArePage();
    }

    @Then("I should be directed to the About Loblaws page")
    public void iShouldBeDirectedToTheAboutLoblawsPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateWhoWeArePage());
    }

    @And("I should see a Start Shopping button on the page that directs me to the store locator page")
    public void iShouldSeeAStartShoppingButtonOnThePageThatDirectsMeToTheStoreLocatorPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateStartShoppingButtonWhoWeArePage());
    }

    @And("I should see a Choose your Location button on the page that directs me to the store locator page")
    public void iShouldSeeAChooseYourLocationButtonOnThePageThatDirectsMeToTheStoreLocatorPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateChooseYourLocationPage());
    }

    @When("they click on a footer link Viewing Charity and Community Page")
    public void theyClickOnAFooterLinkViewingCharityAndCommunityPage() {
        tcs.pom.getFooterPage().goToViewingCharityAndCommunityPage();
    }

    @Then("they should be redirected to the pcChildrenCharity")
    public void theyShouldBeRedirectedToThePcChildrenCharity() {
        Assert.assertTrue(tcs.pom.getFooterPage().validatePcChildrenCharity());
    }

    @When("they click on a footer link Viewing Corporate Social Responsibility Page")
    public void theyClickOnAFooterLinkViewingCorporateSocialResponsibilityPage() {
        tcs.pom.getFooterPage().goToCorporateSocialResponsibilityPage();
    }

    @Then("they should be redirected to the Responsibility page based on the banner selected")
    public void theyShouldBeRedirectedToTheResponsibilityPageBasedOnTheBannerSelected() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateResponsibilityPage());
    }

    @When("they click on a footer link Viewing Partner stores Page")
    public void theyClickOnAFooterLinkViewingPartnerStoresPage() {
        tcs.pom.getFooterPage().goToPartnerStores();
    }

    @Then("they should be redirected to the Partner Store Page")
    public void theyShouldBeRedirectedToThePartnerStorePage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validatePartnerStorePage());
    }

    @And("they should be able to see a list of stores per areas")
    public void theyShouldBeAbleToSeeAListOfStoresPerAreas() {
        Assert.assertFalse(tcs.pom.getFooterPage().validateListOfStores());
    }

    @When("they click on a footer link Viewing Partner Store Locator Page")
    public void theyClickOnAFooterLinkViewingPartnerStoreLocatorPage() {
        tcs.pom.getFooterPage().goToStoreLocatorPage();
    }

    @Then("they should be redirected to the Store Locator page based")
    public void theyShouldBeRedirectedToTheStoreLocatorPageBased() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateStoreLocatorPage());
    }

    @And("they should see a list of stores where they can select a location")
    public void theyShouldSeeAListOfStoresWhereTheyCanSelectALocation() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateListOfStoresLocations());
    }

    @And("they should be able to search for an address")
    public void theyShouldBeAbleToSearchForAnAddress() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateSearchForLocation());
    }

    @When("they click on a footer link Viewing Contact Us Page")
    public void theyClickOnAFooterLinkViewingContactUsPage() throws InterruptedException {
        tcs.pom.getFooterPage().goToContactUsPage();
    }

    @Then("they should be redirected to the contact us based on the banner selected")
    public void theyShouldBeRedirectedToTheContactUsBasedOnTheBannerSelected() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateContactUsPage());
    }

    @And("they should be able to select a reason under Email and add in the details of the customer reaching out")
    public void theyShouldBeAbleToSelectAReasonUnderEmailAndAddInTheDetailsOfTheCustomerReachingOut() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateEmailUsArea());
    }

    @And("the customer should see the CSR, PCX Express and Write to US details")
    public void theCustomerShouldSeeTheCSRPCXExpressAndWriteToUSDetails() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateCallUsArea());
    }

    @When("they click on a footer link Viewing Careers Page")
    public void theyClickOnAFooterLinkViewingCareersPage() {
        tcs.pom.getFooterPage().goToCareersPage();
    }

    @Then("they should be redirected to the Careers page")
    public void theyShouldBeRedirectedToTheCareersPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateCareersPage());
    }

    @When("they click on a footer link Viewing Weekly Flyer Page")
    public void theyClickOnAFooterLinkViewingWeeklyFlyerPage() {
        tcs.pom.getFooterPage().goToWeeklyFlyerPage();
    }

    @Then("they should be redirected to the weekly-flyer page based on the banner selected")
    public void theyShouldBeRedirectedToTheWeeklyFlyerPageBasedOnTheBannerSelected() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateWeeklyFlyerPage());
    }

    @And("they should see the store information and a CTA to select the Store or a change store link")
    public void theyShouldSeeTheStoreInformationAndACTAToSelectTheStoreOrAChangeStoreLink() {
        Assert.assertTrue(tcs.pom.getHeader().iSeeDefaultLocation());
    }

    @And("they should see-use the functionality on the Flyer page")
    public void theyShouldSeeUseTheFunctionalityOnTheFlyerPage() {
      //  Assert.assertTrue(tcs.pom.getFooterPage().validateFlayerPageArea());
    }

    @When("they click on a footer link Viewing Fruits & Vegetables Page")
    public void theyClickOnAFooterLinkViewingFruitsVegetablesPage() {
        tcs.pom.getFooterPage().goToFruitsAndVegetablesPage();
    }

    @Then("they should be redirected to the Viewing Fruits & Vegetables Page CLP page")
    public void theyShouldBeRedirectedToTheViewingFruitsVegetablesPageCLPPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateFruitsAndVegetablePage());
    }

    @And("should be able to see-use the functionality on the Fruits & Vegetables CLP Page")
    public void shouldBeAbleToSeeUseTheFunctionalityOnTheFruitsVegetablesCLPPage() {
        Assert.assertFalse(tcs.pom.getFooterPage().validateProductsVisible());
    }

    @When("they click on a footer link Viewing Dairy & Eggs Page")
    public void theyClickOnAFooterLinkViewingDairyEggsPage() {
        tcs.pom.getFooterPage().goToDairyEggsPage();
    }

    @Then("they should be redirected to the Viewing Dairy & Eggs Page CLP page")
    public void theyShouldBeRedirectedToTheViewingDairyEggsPageCLPPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateDairyAndEggsPage());
    }

    @And("should be able to see-use the functionality on the Dairy & Eggs CLP Page")
    public void shouldBeAbleToSeeUseTheFunctionalityOnTheDairyEggsCLPPage() {
        Assert.assertFalse(tcs.pom.getFooterPage().validateProductsVisible());
    }

    @When("they click on a footer link Viewing Pantry Page")
    public void theyClickOnAFooterLinkViewingPantryPage() {
        tcs.pom.getFooterPage().goToPantryPage();
    }

    @Then("they should be redirected to the Viewing Pantry CLP page")
    public void theyShouldBeRedirectedToTheViewingPantryCLPPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validatePantryPage());
    }

    @And("should be able to see-use the functionality on the Pantry CLP Page")
    public void shouldBeAbleToSeeUseTheFunctionalityOnThePantryCLPPage() {
        Assert.assertFalse(tcs.pom.getFooterPage().validateProductsVisible());
    }

    @When("they click on a footer link Viewing Meat Page")
    public void theyClickOnAFooterLinkViewingMeatPage() {
        tcs.pom.getFooterPage().goToMeatPage();
    }

    @Then("they should be redirected to the Viewing Meat CLP page")
    public void theyShouldBeRedirectedToTheViewingMeatCLPPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateMeatPage());
    }

    @And("should be able to see-use the functionality on the Meat CLP Page")
    public void shouldBeAbleToSeeUseTheFunctionalityOnTheMeatCLPPage() {
        Assert.assertFalse(tcs.pom.getFooterPage().validateProductsVisible());
    }

    @When("they click on a footer link Viewing Bakery Page")
    public void theyClickOnAFooterLinkViewingBakeryPage() {
        tcs.pom.getFooterPage().goToBakeryPage();
    }

    @Then("they should be redirected to the Viewing Bakery CLP page")
    public void theyShouldBeRedirectedToTheViewingBakeryCLPPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateBakeryPage());
    }

    @And("should be able to see-use the functionality on the Bakery CLP Page")
    public void shouldBeAbleToSeeUseTheFunctionalityOnTheBakeryCLPPage() {
        Assert.assertFalse(tcs.pom.getFooterPage().validateProductsVisible());
           }

    @When("they click on a footer link Viewing Joe Fresh Page")
    public void theyClickOnAFooterLinkViewingJoeFreshPage() {
        tcs.pom.getFooterPage().goToJoeFreshPage();
    }

    @Then("they should be redirected to the Viewing Joe Fresh CLP page")
    public void theyShouldBeRedirectedToTheViewingJoeFreshCLPPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateJoeFreshPage());
    }

    @When("the customer clicks on the Gift Cards page")
    public void theCustomerClicksOnTheGiftCardsPage() {
        tcs.pom.getFooterPage().goToGiftCardPage();
    }

    @Then("they should be redirected to the Gift Cards Page")
    public void theyShouldBeRedirectedToTheGiftCardsPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateGiftCardsPage());
    }

    @When("the customer clicks on the Pharmacy Page")
    public void theCustomerClicksOnThePharmacyPage() {
        tcs.pom.getFooterPage().goToPharmacyPage();
    }

    @Then("they should be redirected to the Pharmacy Page")
    public void theyShouldBeRedirectedToThePharmacyPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validatePharmacyPage());
    }

    @When("the customer clicks on the Photo Lab in footer")
    public void theCustomerClicksOnThePhotoLabInFooter() {
        tcs.pom.getFooterPage().goToPhotoLabPage();
    }

    @Then("they should be redirected to Photo Lab Page")
    public void theyShouldBeRedirectedToPhotoLabPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validatePhotoLabPage());
    }

    @When("the customer clicks on the PC Financial in footer")
    public void theCustomerClicksOnThePCFinancialInFooter() {
        tcs.pom.getFooterPage().goToPcFinancialPage();
    }

    @Then("they should be redirected to PC Financial Page")
    public void theyShouldBeRedirectedToPCFinancialPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validatePcFinancialPage());
    }

    @When("the customer clicks on the Recipes in footer")
    public void theCustomerClicksOnTheRecipesInFooter() {
        tcs.pom.getFooterPage().goToRecipesPage();
    }

    @Then("they should be redirected to Recipes Page")
    public void theyShouldBeRedirectedToRecipesPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateRecipesPage());
    }

    @When("the customer clicks on the Advertise with Loblaw Media in footer")
    public void theCustomerClicksOnTheAdvertiseWithLoblawMediaInFooter() {
        tcs.pom.getFooterPage().goToAdvertisePage();
    }

    @Then("they should be redirected to Advertise with Loblaw Media Page")
    public void theyShouldBeRedirectedToAdvertiseWithLoblawMediaPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validateAdvertisePage());
    }

    @When("the customer clicks on the PC Optimum Insiders in footer")
    public void theCustomerClicksOnThePCOptimumInsidersInFooter() {
        tcs.pom.getFooterPage().goToPcOptimumInsiders();
    }

    @Then("they should be redirected to the PC Optimum Insiders Page")
    public void theyShouldBeRedirectedToThePCOptimumInsidersPage() {
        Assert.assertTrue(tcs.pom.getFooterPage().validatePcOptimumInsiderPage());
    }
}
