package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

public class FlyerStepDefinition {

    TestContextSetup tcs;

    public FlyerStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I am on the Flyers tab of the Flyers & Deals page")
    public void iAmOnTheTabOfTheFlyersDealsPage() {
        tcs.pom.getFlyers().visitFlyerPage();

    }

    @When("I view the page")
    public void iViewThePage() {
        //It is about if the Flyer page is visible or not.
    }

    @Then("I will tabs for All Deals,Flyer Items,Flyer")
    public void iWillTabsForAllDealsFlyerItemsFlyer() {
       // Assert.assertTrue(tcs.pom.getFlyers().validateTabs());
    }

    @And("I will see a registration link to sign up for emails about the flyer")
    public void iWillSeeARegistrationLinkToSignUpForEmailsAboutTheFlyer() {
        Assert.assertTrue(tcs.pom.getFlyers().validateSignUpEmail());
    }

    @And("a clickable flyer managed by Flipp")
    public void aClickableFlyerManagedByFlipp() {
        //Covered under another step
    }

    @And("a drawer to the right of the flyer with information on how to use the page")
    public void aDrawerToTheRightOfTheFlyerWithInformationOnHowToUseThePage() {
        Assert.assertTrue(tcs.pom.getFlyers().validateWelcomeMessage());
    }

    @When("I click on the Sign up to receive our emails link")
    public void iClickOnTheSignUpToReceiveOurEmailsLink() {
        tcs.pom.getFlyers().clickSignUp();
    }

    @Then("I will be taken to a registration page where I can provide my name and email to receive emails")
    public void iWillBeTakenToARegistrationPageWhereICanProvideMyNameAndEmailToReceiveEmails() {
        tcs.pom.getFlyers().fillFirstName();
        tcs.pom.getFlyers().fillLastName();
        tcs.pom.getFlyers().selectTheProvinceRandomly();
        tcs.pom.getFlyers().fillEmail();
        tcs.pom.getFlyers().clickOptInCheckbox();
        tcs.pom.getFlyers().sumbitSignUpForm();
    }

    @And("submitting my information on this page will register me for the mailing list")
    public void submittingMyInformationOnThisPageWillRegisterMeForTheMailingList() {
        Assert.assertTrue(tcs.pom.getFlyers().validateSucessMessage());
    }

    @When("I click on an item in the flyer")
    public void iClickOnAnItemInTheFlyer() {
        tcs.pom.getFlyers().randomlyClickOnFlyerProduct();

    }

    @Then("The drawer will update with the same information included in browse product tiles")
    public void theDrawerWillUpdateWithTheSameInformationIncludedInBrowseProductTiles() {
        Assert.assertTrue(tcs.pom.getFlyers().validateImageAndCart());
    }

    @And("an Add to Cart button")
    public void anButton() {
        tcs.pom.getFlyers().clickAddToCart();
    }

    @And("clicking the button will add the item to my cart")
    public void clickingTheButtonWillAddTheItemToMyCart() {
        Assert.assertTrue(tcs.pom.getFlyers().validateCartQuantity());
    }

    @And("the button will be replace by the quantity configuration buttons once the item is in my cart")
    public void theButtonWillBeReplaceByTheQuantityConfigurationButtonsOnceTheItemIsInMyCart() {
        Assert.assertTrue(tcs.pom.getFlyers().validateItemQuantityButtonAppear());
    }

    @Given("I am in Flyers & Deals")
    public void iAmInFlyersDeals() {
        tcs.pom.getFlyers().visitFlyerPage();
    }

    @When("I click on the All Deals tab")
    public void iClickOnTheAllDealsTab() {
        tcs.pom.getFlyers().switchToFlyerAllDeals();
    }

    @Then("I will be taken to All Deals, the page will be a L0 PLP and all items with a deal will be shown on the page")
    public void iWillBeTakenToAllDeals() {
        Assert.assertTrue(tcs.pom.getFlyers().validateAllDealsBadge());
    }

    @When("I click on the Flyer Items tab")
    public void iClickOnTheFlyerItemsTab() {
        tcs.pom.getFlyers().clickFlyerItems();

    }

    @Then("I will be taken to Flyer items and the page will be a L0 PLP and the items on the page will match the items listed in the flyer")
    public void iWillBeTakenToFlyerItemsAndThePageWillBeALPLPAndTheItemsOnThePageWillMatchTheItemsListedInTheFlyer() {
        Assert.assertFalse(tcs.pom.getFlyers().validateFlyerItemsVisible());
    }
}
