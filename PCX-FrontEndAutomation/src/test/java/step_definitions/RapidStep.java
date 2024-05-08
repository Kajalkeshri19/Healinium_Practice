package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

public class RapidStep {
    TestContextSetup tcs;

    public RapidStep(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I come to as a first time user")
    public void i_come_to_as_a_first_time_user() {
        tcs.pom.getRapidPage().isBannerBoxDisplay();

    }

    @When("I input a serviceable address and the store is open")
    public void i_input_a_serviceable_address_and_the_store_is_open() {
       //Already Done In former steps
    }

    @Then("I should be able to click the Continue button and enter the homepage")
    public void i_should_be_able_to_click_the_continue_button_and_enter_the_homepage() {
        Assert.assertTrue(tcs.pom.getRapidPage().clickOnContinueButton());

    }

    @When("I input a non serviceable address and stores are open")
    public void iInputANonServiceableAddressAndStoresAreOpen() {
        tcs.pom.getRapidPage().clickOnContinueButton();

    }

    @Then("I should be shown a message that either informs me I am not serviceable")
    public void iShouldBeShownAMessageThatEitherInformsMeIAmNotServiceableAndOrDirectsMeToPCX() {
        Assert.assertTrue(tcs.pom.getRapidPage().shownAMessage());

    }

    @Given("I come to as a return user")
    public void iComeToAsAReturnUser() {
        tcs.pom.getRapidPage().isBannerBoxDisplay();
        tcs.pom.getRapidPage().clickOnContinueButton();
        tcs.pom.getRapidPage().returnUser();

    }

    @When("I input a serviceable address and the store is closed")
    public void iInputAServiceableAddressAndTheStoreIsClosed() {
        tcs.pom.getRapidPage().clickOnContinueButton();

    }

    @Then("I should be shown a message that the store is closed, and be able to click Okay")
    public void iShouldBeShownAMessageThatTheStoreIsClosedAndBeAbleToClickOkay() {
//        Need Test Data.
//        Assert.assertTrue(tcs.pom.getRapidPage().messageForClosedStore());
    }

    @Then("I should not see the serviceability modal appear \\(address should be stored)")
    public void iShouldNotSeeTheServiceabilityModalAppearAddressShouldBeStored() {
//        Assert.assertTrue(tcs.pom.getRapidPage().messageForClosedStore());
        Assert.assertTrue(tcs.pom.getRapidPage().storeAddress());
    }

    @Given("I am a return user and I want to change my address on Rapid")
    public void iAmAReturnUserAndIWantToChangeMyAddressOnRapid() {
        tcs.pom.getRapidPage().isBannerBoxDisplay();
        tcs.pom.getRapidPage().clickOnContinueButton();
        tcs.pom.getRapidPage().returnUser();
    }


    @When("I click the address listed in the top right")
    public void iClickTheAddressListedInTheTopRight() {
//        tcs.pom.getRapidPage().messageForClosedStore();
        tcs.pom.getRapidPage().storeAddress();
        tcs.pom.getRapidPage().clickOnStoreAddress();

    }

    @Then("I should see a serviceability modal open, with ability to adjust my address \\(inputting address should then follow same flows identified above)")
    public void iShouldSeeAServiceabilityModalOpenWithAbilityToAdjustMyAddressInputtingAddressShouldThenFollowSameFlowsIdentifiedAbove() {
        Assert.assertTrue(tcs.pom.getRapidPage().seeServiceabilityModal());
        Assert.assertTrue(tcs.pom.getRapidPage().changeAddress());
        Assert.assertTrue(tcs.pom.getRapidPage().clickOnContinueButton());
    }


    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        tcs.pom.getRapidPage().isBannerBoxDisplay();
        tcs.pom.getRapidPage().clickOnContinueButton();
        tcs.pom.getRapidPage().returnUser();

    }

    @When("I click Shop All under any of the product carousels")
    public void iClickShopAllUnderAnyOfTheProductCarousels() {
//        tcs.pom.getRapidPage().messageForClosedStore();
        tcs.pom.getRapidPage().clickOnShopAll();


    }

    @Then("I should be taken to the Category Listing Page for that section")
    public void iShouldBeTakenToTheCategoryListingPageForThatSection() {
        Assert.assertTrue(tcs.pom.getRapidPage().navigateToCategoryListingPage());
    }

    @Given("I am anywhere on the website")
    public void iAmAnywhereOnTheWebsite() {
        tcs.pom.getRapidPage().isBannerBoxDisplay();
        tcs.pom.getRapidPage().clickOnContinueButton();
        tcs.pom.getRapidPage().returnUser();
    }

    @When("I click a category in the navigation")
    public void iClickACategoryInTheNavigation() {
//        tcs.pom.getRapidPage().messageForClosedStore();
        tcs.pom.getRapidPage().clickCategory();

    }

    @Then("I should able to the Category Listing Page for that section")
    public void iShouldAbleToTheCategoryListingPageForThatSection() {
        Assert.assertTrue(tcs.pom.getRapidPage().navigateCategoryListingPage());
    }

    @When("I click a product tile")
    public void iClickAProductTile() {
        tcs.pom.getRapidPage().clickAProductTile();

    }

    @Then("I should be taken to the PDP for that product")
    public void iShouldBeTakenToThePDPForThatProduct() {
        Assert.assertTrue(tcs.pom.getRapidPage().navigatePdpPage());
    }

    @Given("I am on a Rapid PDP")
    public void iAmOnARapidPDP() {
        tcs.pom.getRapidPage().isBannerBoxDisplay();
        tcs.pom.getRapidPage().clickOnContinueButton();
        tcs.pom.getRapidPage().returnUser();
//        tcs.pom.getRapidPage().messageForClosedStore();
        tcs.pom.getRapidPage().clickCategory();
        tcs.pom.getRapidPage().navigateCategoryListingPage();
        tcs.pom.getRapidPage().clickAProductTile();
        tcs.pom.getRapidPage().navigatePdpPage();
    }

    @Then("I should see product name, weight, price, image, and product description")
    public void iShouldSeeProductNameWeightPriceImageAndProductDescription() {
        Assert.assertTrue(tcs.pom.getRapidPage().validatePdpPageContent());
    }

    @When("I click Add")
    public void iClickAdd() {
        tcs.pom.getRapidPage().clickAdd();
    }

    @Then("Product should be added to my cart, shown by a green checkmark on product image, appearance of floating checkout, addition of item to cart icon in nav, and ability to adjust quantity on page")
    public void productShouldBeAddedToMyCartShownByAGreenCheckmarkOnProductImageAppearanceOfFloatingCheckoutAdditionOfItemToCartIconInNavAndAbilityToAdjustQuantityOnPage() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getRapidPage().validateAddToCartProcess());
        Assert.assertTrue(tcs.pom.getRapidPage().additionOfItem());
    }


    @Given("I am on a product tile page")
    public void iAmOnAProductTilePage() {
        tcs.pom.getRapidPage().isBannerBoxDisplay();
        tcs.pom.getRapidPage().clickOnContinueButton();
        tcs.pom.getRapidPage().returnUser();
//        tcs.pom.getRapidPage().messageForClosedStore();
        tcs.pom.getRapidPage().clickCategory();
        tcs.pom.getRapidPage().navigateCategoryListingPage();


    }

    @When("The product has ample stock")
    public void theProductHasAmpleStock() {
        tcs.pom.getRapidPage().searchProduct("DD_1000023507_EA");
        tcs.pom.getRapidPage().clickOnSearchIcon();

    }

    @Then("I should not see any badging on product tile or PDP")
    public void iShouldNotSeeAnyBadgingOnProductTileOrPDP() {
        Assert.assertTrue(tcs.pom.getRapidPage().ampleStock());
    }

    @When("The product has low stock")
    public void theProductHasLowStock() {
        tcs.pom.getRapidPage().searchProduct("DD_1000023507_EA");
        tcs.pom.getRapidPage().clickOnSearchIcon();
    }

    @Then("I should see a Low Stock badge on product tile and PDP")
    public void iShouldSeeALowStockBadgeOnProductTileAndPDP() {
        Assert.assertTrue(tcs.pom.getRapidPage().isProductLowStock());
    }


    @Then("I should see suggested results underneath the search bar")
    public void iShouldSeeSuggestedResultsUnderneathTheSearchBar() {
        Assert.assertTrue(tcs.pom.getRapidPage().seeSuggestedResults());
    }


    @Then("if there are results, I should see the SRP with related results. note SRP will load results user is required to click load more, to load more if available")
    public void ifThereAreResultsIShouldSeeTheSRPWithRelatedResultsNoteSRPWillLoadResultsUserIsRequiredToClickLoadMoreToLoadMoreIfAvailable() {
        Assert.assertFalse(tcs.pom.getRapidPage().seeRelatedResults());
    }

    @When("I click into the search bar, enter a keyword and press enter")
    public void iClickIntoTheSearchBarEnterAKeywordAndPressEnter() {
        tcs.pom.getRapidPage().searchProduct("wa");
        tcs.pom.getRapidPage().clickOnSearchIcon();
    }

    @Then("if there are no results: I should see the message We were unable to find results for keyword Try checking your spelling or searching something less specific with the ability to try search again, in page.")
    public void ifThereAreNoResultsIShouldSeeTheMessageWeWereUnableToFindResultsForKeywordTryCheckingYourSpellingOrSearchingSomethingLessSpecificWithTheAbilityToTrySearchAgainInPage() {
        Assert.assertTrue(tcs.pom.getRapidPage().errorMessage());

    }

    @When("I click into the search bar and enter a keyword")
    public void iClickIntoTheSearchBarAndEnterAKeyword() {
        tcs.pom.getRapidPage().searchProduct("Apple");
    }

    @When("I click into the search bar, type a product name and press enter")
    public void iClickIntoTheSearchBarTypeAProductNameAndPressEnter() {
//        tcs.pom.getRapidPage().messageForClosedStore();
        tcs.pom.getRapidPage().searchProduct("snacks");
        tcs.pom.getRapidPage().clickOnSearchIcon();
    }
}

