package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

public class ExpressPassStepDefinition {

    TestContextSetup tcs;

    public ExpressPassStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("Customer is on the landing page the PCid")
    public void customerIsOnTheLandingPageThePCid() {
        Assert.assertTrue(tcs.pom.getExpressPass().customerIsOnPcExpressPage());
    }

    @And("Sign in check should happen")
    public void signInCheckShouldHappen() {
        Assert.assertTrue(tcs.pom.getExpressPass().iSeeSignUpCheck());
    }

    @When("the customer click on the sign up")
    public void theCustomerClickOnTheSignUp() {
        tcs.pom.getExpressPass().iClickPcExpressSignUp();
    }

    @Then("the user is being asked to sign in to their PCid")
    public void theUserIsBeingAskedToSignInToTheirPCid() {
       Assert.assertTrue(tcs.pom.getExpressPass().iAmOnPcExpressSignIn());
    }

    @Given("the PCid sign up is completed")
    public void thePCidSignUpIsCompleted() {
        tcs.pom.getExpressPass().iClickOnSignIn("pcxpasstestdata85365@yopmail.com","passwordisnew");
    }

    @When("the customer has a PCOI subscription")
    public void theCustomerHasAPCOISubscription() {
        Assert.assertTrue(tcs.pom.getExpressPass().iHavePcoiSubscription());
    }

    @Then("the user can see the plan selection page and the user can view the last four digits of their credit card")
    public void theUserCanSeeThePlanSelectionPageAndTheUserCanViewTheLastDigitsOfTheirCreditCard() {
        tcs.pom.getExpressPass().iClickOnMyProfile();
    }

    @And("they should see the Plan Selection page with the credit card information pre-populated")
    public void theyShouldSeeThePlanSelectionPageWithTheCreditCardInformationPrePopulated() {
        Assert.assertTrue(tcs.pom.getExpressPass().iSeePlanSelectionPage());
    }

    @Given("the user sign in with PCid")
    public void theUserSignInWithPCid() {
        tcs.pom.getExpressPass().iClickOnSignIn("test2301one@yopmail.com","Loblaw@Testing");
    }

    @When("the user on the pass purchase journey is viewing the one month free trial CallOut for the Monthly Plan")
    public void theUserOnThePassPurchaseJourneyIsViewingTheOneMonthFreeTrialCallOutForTheMonthlyPlan() {
        tcs.pom.getExpressPass().customerIsOnPcExpressPage();
        theCustomerClickOnTheSignUp();
        Assert.assertTrue(tcs.pom.getExpressPass().iSeePcExpressCallOut());
        tcs.pom.getExpressPass().iSelectMonthlyPlan();
    }

    @When("the user on the pass purchase journey is viewing the one month free trial CallOut for the Annual Plan")
    public void theUserOnThePassPurchaseJourneyIsViewingTheOneMonthFreeTrialCallOutForTheAnnualPlan() {
        tcs.pom.getExpressPass().customerIsOnPcExpressPage();
        theCustomerClickOnTheSignUp();
        Assert.assertTrue(tcs.pom.getExpressPass().iSeePcExpressCallOut());
    }

    @Then("the user is able to view all the relevant screens Plan Selection, Billing, Shipping, CC entry, Plan Confirmation, Success Page")
    public void theUserIsAbleToViewAllTheRelevantScreensPlanSelectionBillingShippingCCEntryPlanConfirmationSuccessPage() {
        tcs.pom.getExpressPass().iSeeAllRelevantScreens("Test Automation Studio","Toronto","M1M 2H9");
    }

    @Given("the user login with PCid")
    public void theUserLoginWithPCid() {
        tcs.pom.getExpressPass().iClickOnSignIn("pcxpasstestdata85363@yopmail.com","passwordisnew");
    }

    @When("the user is on PC Express Section in Profile")
    public void theUserIsOnPCExpressSectionInProfile() {
       theUserCanSeeThePlanSelectionPageAndTheUserCanViewTheLastDigitsOfTheirCreditCard();
    }

    @Then("Customer should be presented with all pages except PCOI screens on the subscription purchase flow")
    public void customerShouldBePresentedWithAllPagesExceptPCOIScreensOnTheSubscriptionPurchaseFlow() {
        Assert.assertTrue(tcs.pom.getExpressPass().iSeeMonthlyPlanInProfile());
    }
}
