package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

import java.io.IOException;
import java.time.Duration;

public class HeaderStepDefinition {

    TestContextSetup tcs;
    public HeaderStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @Given("I am a customer who is on banner.ca")
    public void iAmACustomerWhoIsOnBannerCa() {
        tcs.base.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("I click the banner logo in the top left")
    public void iClickTheBannerLogoInTheTopLeft()  {
        Assert.assertTrue(tcs.pom.getHeader().clickAnyCategory());
        tcs.pom.getHeader().clickLogo();
    }

    @Then("I want to be taken to banner homepage")
    public void iWantToBeTakenToBannerHomepage() throws IOException {
       Assert.assertTrue(tcs.pom.getHeader().validateHeaderLink());
    }

    @When("I navigate to the site")
    public void iNavigateToTheSite() throws IOException {
          iWantToBeTakenToBannerHomepage();
    }

    @Then("I should not see the Marketplace tab")
    public void iShouldNotSeeTheMarketplaceTab() {
        Assert.assertTrue(tcs.pom.getHeader().iDontSeeMarketPlace());
    }

    @Given("I am a first time customer on banner.ca")
    public void iAmAFirstTimeCustomerOnBannerCa() {
        iAmACustomerWhoIsOnBannerCa();
    }

    @Then("I should see a default location \\(based on my IP) in the top right corner")
    public void iShouldSeeADefaultLocationBasedOnMyIPInTheTopRightCorner() {
        Assert.assertTrue(tcs.pom.getHeader().iSeeDefaultLocation());
    }

    @Given("I am a previous pickup customer on banner.ca")
    public void iAmAPreviousPickupCustomerOnBannerCa() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("PickUpAccount");
    }

    @Then("I should see my last pickup location in the top right corner")
    public void iShouldSeeMyLastPickupLocationInTheTopRightCorner() {
        Assert.assertTrue(tcs.pom.getHeader().iSeeDefaultLocation());
    }

    @Given("I am a first time customer or a previous pickup customer")
    public void iAmAFirstTimeCustomerOrAPreviousPickupCustomer() {
        iAmACustomerWhoIsOnBannerCa();
    }

    @When("I click the pickup location in the top right")
    public void iClickThePickupLocationInTheTopRight() {
        tcs.pom.getHeader().iClickLocationTitle();
    }

    @Then("I should see a message displayed that tells me this is my nearest location")
    public void iShouldSeeAMessageDisplayedThatTellsMeThisIsMyNearestLocation() {
        Assert.assertTrue(tcs.pom.getHeader().iSeeNearestLocationMessage());
    }

    @And("I should see Nearest Location title")
    public void iShouldSeeNearestLocationTitle() {
        Assert.assertTrue(tcs.pom.getHeader().iSeeNearestLocation());
    }

    @And("I should see the location Name and location Address")
    public void iShouldSeeTheLocationNameAndLocationAddress() {
        iShouldSeeNearestLocationTitle();
    }

    @And("I should see messaging about this being my nearest location")
    public void iShouldSeeMessagingAboutThisBeingMyNearestLocation() {
        iShouldSeeAMessageDisplayedThatTellsMeThisIsMyNearestLocation();
    }

    @And("I should have the ability to click Yes, this is my preferred location")
    public void iShouldHaveTheAbilityToClickYesThisIsMyPreferredLocation() {
       Assert.assertTrue(tcs.pom.getHeader().iHaveTheAbilityToClickYes());
    }

    @And("I should have the ability to click No, change location")
    public void iShouldHaveTheAbilityToClickNoChangeLocation() {
        Assert.assertTrue(tcs.pom.getHeader().iHaveTheAbilityToClickNo());
    }

    @When("I click the pickup location in the top right and click No, change location")
    public void iClickThePickupLocationInTheTopRightAndClickNoChangeLocation() {
        iClickThePickupLocationInTheTopRight();
        tcs.pom.getHeader().iClickChangeLocation();
    }

    @Then("I should be taken to the store locator page to find a new location")
    public void iShouldBeTakenToTheStoreLocatorPageToFindANewLocation() {
        Assert.assertTrue(tcs.pom.getHeader().iAmToChangeLocationPage());
    }

    @Given("I am a previous delivery customer on banner.ca")
    public void iAmAPreviousDeliveryCustomerOnBannerCa() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("DeliveryAccount");
    }

    @Then("I should see my delivery postal code in the top right corner")
    public void iShouldSeeMyDeliveryPostalCodeInTheTopRightCorner() {
            iShouldSeeMyLastPickupLocationInTheTopRightCorner();
    }

    @When("I click into my delivery address in the top left")
    public void iClickIntoMyDeliveryAddressInTheTopLeft() {
        iClickThePickupLocationInTheTopRight();
        tcs.pom.getHeader().switchToDelivery();
    }

    @Then("I should be able to edit my postal code and click save")
    public void iShouldBeAbleToEditMyPostalCodeAndClickSave() {
        Assert.assertTrue(tcs.pom.getHeader().iSeeMyDeliveryCode());
    }

    @And("if successful, I should be able to continue shopping")
    public void ifSuccessfulIShouldBeAbleToContinueShopping() {
        iAmACustomerWhoIsOnBannerCa();
    }

    @And("if unsuccessful, I should see a message that this address isn't available for delivery")
    public void ifUnsuccessfulIShouldSeeAMessageThatThisAddressIsnTAvailableForDelivery() {
        Assert.assertTrue(tcs.pom.getHeader().iSeeAppropriateMessage());
    }
}
