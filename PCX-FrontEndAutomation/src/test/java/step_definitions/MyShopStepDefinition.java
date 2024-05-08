package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

import java.io.IOException;

public class MyShopStepDefinition {

    TestContextSetup tcs;
    public MyShopStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }

    /**
     * Validates that the user has not logged in
     */
    @Given("I am a guest user")
    public void iAmAGuestUser() {
        Assert.assertTrue(tcs.pom.getMyShop().userIsGuest());
    }

    @When("I click on the My Shop links")
    public void iClickOnTheMyShopLinks() {
        tcs.pom.getMyShop().iClickOnMyShopLink();
    }

    @Then("I should be prompted to sign")
    public void iShouldBePromptedToSign() {
         Assert.assertTrue(tcs.pom.getMyShop().iAmPromptedToSignIn());
    }

    @And("when I click on the sign CTA I should be able to enter my PCid")
    public void whenIClickOnTheSignCTAIShouldBeAbleToEnterMyPCid() {
        Assert.assertTrue(tcs.pom.getMyShop().iClickOnSignInCta());
        tcs.pom.getMyShop().iAmAbleToEnterMyPcId("test2301one@yopmail.com","Loblaw@Testing");
    }

    @And("I should be able to create an Account")
    public void iShouldBeAbleToCreateAnAccount() {
        tcs.base.getDriver().navigate().back();
        Assert.assertTrue(tcs.pom.getMyShop().iShouldBeAbleToCreateAccount());
    }

    @And("I should be able to see the right validation on the PCid sign in,sign up page")
    public void iShouldBeAbleToSeeTheRightValidationOnThePCidSignInSignUpPage() {
        tcs.base.getDriver().navigate().back();
        tcs.pom.getMyShop().iClickOnSignInCta();
        Assert.assertTrue(tcs.pom.getMyShop().iSeeRightValidation());
        Assert.assertTrue(tcs.pom.getMyShop().iSeeLoginFailedValidation("abcde"));
    }

    @Given("I am a logged in customer")
    public void iAmALoggedInCustomer() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("CartAccount");
    }


    @When("I click on Most Purchased link from the Most Shop Nav")
    public void iClickOnMostPurchasedLinkFromTheMostShopNav() {
        iClickOnTheMyShopLinks();
    }

    @Then("I should be able to see the most purchased products on the Most Purchase page")
    public void iShouldBeAbleToSeeTheMostPurchasedProductsOnTheMostPurchasePage() {
        Assert.assertTrue(tcs.pom.getMyShop().iSeeMyMostPurchasedOrder());
    }

    @And("see the merch carousels on the page")
    public void seeTheMerchCarouselsOnThePage() {
        Assert.assertFalse(tcs.pom.getMyShop().iSeeMerchOnMostPurchased());
    }

    @When("I click on Post Order link from the Most Shop Nav")
    public void iClickOnPostOrderLinkFromTheMostShopNav() {
        tcs.pom.getMyShop().iClickOnPostOrderLink();
    }

    @Then("I should be able to see all past orders with the banner")
    public void iShouldBeAbleToSeeAllPastOrdersWithTheBanner() {
         iShouldBeAbleToSeeTheMostPurchasedProductsOnTheMostPurchasePage();
    }

    @When("I click on Aisles link from the Most Shop Nav")
    public void iClickOnAislesLinkFromTheMostShopNav() {
        tcs.pom.getMyShop().iClickOnAisleLink();

    }

    @Then("I should be able to see all most purchased products sorted by aisles")
    public void iShouldBeAbleToSeeAllMostPurchasedProductsSortedByAisles() {
        iShouldBeAbleToSeeAllPastOrdersWithTheBanner();
    }

    @Given("I am a customer who has favourite products on the mobile app")
    public void iAmACustomerWhoHasFavouriteProductsOnTheMobileApp() throws IOException {
        iAmALoggedInCustomer();
    }

    @When("When I click on the Web shopping lists")
    public void whenIClickOnTheWebShoppingLists() {
        tcs.pom.getMyShop().iClickOnShoppingListLink();
    }

    @Then("I should be able to see the save items")
    public void iShouldBeAbleToSeeTheSaveItems() {
         Assert.assertTrue(tcs.pom.getMyShop().iSeeSaveItems());
    }

    @And("add the items to cart")
    public void addTheItemsToCart() {
        Assert.assertTrue(tcs.pom.getMyShop().iSeeAddToCartButton());
    }
}
