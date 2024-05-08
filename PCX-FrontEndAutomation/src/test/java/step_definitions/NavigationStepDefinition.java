package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

import java.io.IOException;

public class NavigationStepDefinition {

    TestContextSetup tcs;

    public NavigationStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }
    
    @Given("I am on any page of PCX")
    public void iAmOnAnyPageOfPCX() {
        Assert.assertTrue(tcs.pom.getNavigation().iAmOnPcxHomePage());
    }

    @And("I am not logged in")
    public void iAmNotLoggedIn() {
        aSignInButton();
    }

    @When("The Page loads")
    public void thePageLoads() {
        // Do nothing
    }

    @Then("The nav will display at the top of the page")
    public void theNavWillDisplayAtTheTopOfThePage() {
        Assert.assertTrue(tcs.pom.getNavigation().navWillDisplayAtTopOfPage());
    }

    @And("the store logo")
    public void theStoreLogo() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeStoreLogo());
    }

    @And("the search bar")
    public void theSearchBar() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeSearchBar());
    }

    @And("the selected store location")
    public void theSelectedStoreLocation() {
       tcs.pom.getNavigation().iSeeRecommendedPickup();
    }

    @And("recommended pickup")
    public void recommendedPickup() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeRecommendedPickup());
    }

    @And("delivery times")
    public void deliveryTimes() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeDeliveryTime());
    }

    @And("a tooltip for the fulfillment options")
    public void aTooltipForTheFulfillmentOptions() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeToolTip());
    }

    @And("links for Grocery,Home,Beauty & Baby,Discover,My Shop,Flyers & Deals,Services,PC Express pass")
    public void linksForGroceryHomeBeautyBabyDiscoverMyShopFlyersDealsServicesPCExpressPass() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeLinksOnMainNav());
    }

    @And("a sign in button")
    public void aSignInButton() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeSignIn());
    }

    @And("a shopping cart with number of items and cart price")
    public void aShoppingCartWithNumberOfItemsAndCartPrice() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeMiniCart());
    }

    @And("a checkout button")
    public void aCheckoutButton() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeCheckout());
    }

    @When("I hover over Grocery in the Nav")
    public void iHoverOverGroceryInTheNav() {
        Assert.assertTrue(tcs.pom.getNavigation().iHoverOverGroceryInNav());
    }


    @Then("the list of categories in grocery will display")
    public void theListOfCategoriesInGroceryWillDisplay() {
        Assert.assertTrue(tcs.pom.getNavigation().iCanSeeAllCategoriesInGrocery());
    }

    @And("the sub-categories for whatever category is selected")
    public void theSubCategoriesForWhateverCategoryIsSelected() {
        Assert.assertTrue(tcs.pom.getNavigation().iCanSeeSubCategoryInGrocery());
    }

    @And("an ad unit relating to that category")
    public void anAdUnitRelatingToThatCategory() {
        Assert.assertTrue(tcs.pom.getNavigation().iCanSeeAdInCategory());
    }

    @When("I hover over Home,Beauty & Baby in the nav")
    public void iHoverOverHomeBeautyBabyInTheNav() {
        Assert.assertTrue(tcs.pom.getNavigation().iHoverOverHomeBeautyAndBaby());
    }

    @Then("the list of categories in home, beauty & baby will display")
    public void theListOfCategoriesInHomeBeautyBabyWillDisplay() {
        Assert.assertTrue(tcs.pom.getNavigation().iCanSeeAllCategoriesInBeauty());
    }

    @And("sub-categories for whatever category is selected")
    public void subCategoriesForWhateverCategoryIsSelected() {
        Assert.assertTrue(tcs.pom.getNavigation().iCanSeeSubCategoryInBeauty());
    }

    @When("I hover over any of Discover, My Shop, Flyers & Deals, Services in the nav")
    public void iHoverOverAnyOfDiscoverMyShopFlyersDealsServicesInTheNav() {
        Assert.assertTrue(tcs.pom.getNavigation().iHoverOverAnyOfDiscoverMyShopFlyersDealsServices());
    }

    @Then("the list of categories in the selected menu will display")
    public void theListOfCategoriesInTheSelectedMenuWillDisplay() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeCategoryInDiscover());
    }

    @When("I click on a link in the navigation")
    public void iClickOnALinkInTheNavigation() {
           tcs.pom.getNavigation().iClickOnALinkInNav();
    }

    @Then("I am directed the appropriate page as set up in contentful")
    public void iAmDirectedTheAppropriatePageAsSetUpInContentful() {
          Assert.assertTrue(tcs.pom.getNavigation().iAmOnAppropriatePage());
    }

    @And("the link is not dead")
    public void theLinkIsNotDead() {
        String expectedURL = "https://www.preprod.loblaws.ca/collections/shop-local-all?navid=flyout-L2-seasonal-shop";
        String actualURL = tcs.pom.getNavigation().getUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @When("I click on sign in in the navigation")
    public void iClickOnSignInInTheNavigation() {
         tcs.pom.getNavigation().openLogInPage();
    }

    @Then("I will be directed to sign PCID login page")
    public void iWillBeDirectedToSignPCIDLoginPage() {
        Assert.assertTrue(tcs.pom.getNavigation().iAmOnSignInPage());
    }

    @And("the button will change to My Account upon successful sign in")
    public void theButtonWillChangeToMyAccountUponSuccessfulSignIn() throws IOException {
        tcs.pom.getNavigation().logInToAccount("CartAccount");
    }

    @When("I click on my cart in the navigation")
    public void iClickOnMyCartInTheNavigation() {
        tcs.pom.getProductTile().iAmOnAPlp();
        tcs.pom.getProductTile().addAnItemToCart();
        tcs.pom.getNavigation().iClickOnCart();
    }

    @Then("My cart will expand")
    public void myCartWillExpand() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeMyCartExpand());
    }

    @And("I will be able to see all the items in my cart")
    public void iWillBeAbleToSeeAllTheItemsInMyCart() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeAllItemsInCart());
    }

    @And("the subtotal of my cart")
    public void theSubtotalOfMyCart() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeSummaryOfCart());
    }

    @And("I will see a checkout button in the menu")
    public void iWillSeeACheckoutButtonInTheMenu() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeCheckoutButtonInCartMenu());
    }

    @When("I click the checkout button in the cart menu or navigation")
    public void iClickTheCheckoutButtonInTheCartMenuOrNavigation() {
        tcs.pom.getProductTile().iAmOnAPlp();
        tcs.pom.getProductTile().addAnItemToCart();
        tcs.pom.getNavigation().iClickOnCart();
        tcs.pom.getNavigation().iClickOnCheckout();
    }

    @Then("I will be taken to the first step of checkout flow")
    public void iWillBeTakenToTheFirstStepOfCheckoutFlow() {
        Assert.assertTrue(tcs.pom.getNavigation().iAmOnFirstFlowOfCheckout());
    }

    @Given("I am on L-zero of a CLP,PLP")
    public void iAmOnLZeroOfACLPPLP() {
        tcs.pom.getCLP().navigateOnCLP();
    }


    @When("I scroll to the top of page")
    public void iScrollToTheTopOfPage() {
         tcs.pom.getNavigation().iScrollToTopOfPage();
    }

    @Then("I will see L-zero page name at the top of the page")
    public void iWillSeeLZeroPageNameAtTheTopOfThePage() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeLzeroAtTopOfPage());
    }

    @Given("I am on L-one of a CLP,PLP")
    public void iAmOnLOneOfACLPPLP() {
        tcs.pom.getCLP().navigateOnCLP();

    }

    @And("L-zero will be a clickable link back to L-zero")
    public void lZeroWillBeAClickableLinkBackToLZero() {
       Assert.assertTrue(tcs.pom.getNavigation().lZeroLinkWillBeClickable());
    }

    @And("I see L-one in the breadcrumb at the top of the page")
    public void iSeeLOneInTheBreadcrumbAtTheTopOfThePage() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeBreadCrumbLevelAtTopOfPage());
    }

    @Given("I am on L-two of a CLP,PLP")
    public void iAmOnLTwoOfACLPPLP() {
        tcs.pom.getCLP().navigateOnCLP();
        tcs.pom.getNavigation().iAmOnLTwoBreadCrumb();
    }

    @And("L-one will be a clickable link back to L-one")
    public void lOneWillBeAClickableLinkBackToLOne() {
        Assert.assertTrue(tcs.pom.getNavigation().lOneLinkWillBeClickable());
    }

    @And("I see L-two in the breadcrumb at the top of the page")
    public void iSeeLTwoInTheBreadcrumbAtTheTopOfThePage() {
        iSeeLOneInTheBreadcrumbAtTheTopOfThePage();
    }

    @Given("I am on L-three of a CLP,PLP")
    public void iAmOnLThreeOfACLPPLP() {
        tcs.pom.getCLP().navigateOnCLP();
        tcs.pom.getNavigation().iAmOnLTwoBreadCrumb();
        tcs.pom.getNavigation().iAmOnLevelThreeBreadCrumb();
    }

    @And("L-two will be a clickable link back to L-two")
    public void lTwoWillBeAClickableLinkBackToLTwo() {
         Assert.assertTrue(tcs.pom.getNavigation().lTwoLinkWillBeClickable());
    }

    @And("I see L-three in the breadcrumb at the top of the page")
    public void iSeeLThreeInTheBreadcrumbAtTheTopOfThePage() {
        iSeeLOneInTheBreadcrumbAtTheTopOfThePage();
    }

    @Given("I click on a product tile anywhere on PCX")
    public void iClickOnAProductTileAnywhereOnPCX() {
        iAmOnLThreeOfACLPPLP();
        tcs.pom.getNavigation().iClickOnProductOnPcx();
    }


    @When("I am taken to the PDP")
    public void iAmTakenToThePDP() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeProductPrice());
        Assert.assertTrue(tcs.pom.getProductTile().iSeeProductTitle());
        Assert.assertTrue(tcs.pom.getProductTile().iSeeProductWeight());
        Assert.assertTrue(tcs.pom.getProductTile().iSeeCostPerWeight());
        Assert.assertTrue(tcs.pom.getProductTile().iSeeCartButton());
    }

    @Then("I will see L-zero page name at the top of the pdp")
    public void iWillSeeLZeroPageNameAtTheTopOfThePdp() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeLzeroBreadCrumbAtPdp());
    }

    @And("L-zero pdp will be a clickable link back to L-zero")
    public void lZeroPdpWillBeAClickableLinkBackToLZero() {
        Assert.assertTrue(tcs.pom.getNavigation().iClickLzeroBreadCrumbAtPdp());
    }

    @And("I see L-one in the breadcrumb at the top of the pdp")
    public void iSeeLOneInTheBreadcrumbAtTheTopOfThePdp() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeLoneBreadCrumbAtPdp());
    }

    @And("L-one pdp will be a clickable link back to L-one")
    public void lOnePdpWillBeAClickableLinkBackToLOne() {
        Assert.assertTrue(tcs.pom.getNavigation().iClickLoneBreadCrumbAtPdp());
    }

    @And("I see L-two in the breadcrumb at the top of the pdp")
    public void iSeeLTwoInTheBreadcrumbAtTheTopOfThePdp() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeLtwoBreadCrumbAtPdp());
    }

    @And("L-two pdp will be a clickable link back to L-two")
    public void lTwoPdpWillBeAClickableLinkBackToLTwo() {
        Assert.assertTrue(tcs.pom.getNavigation().iClickLtwoBreadCrumbAtPdp());
    }

    @And("I see L-three in the breadcrumb at the top of the pdp")
    public void iSeeLThreeInTheBreadcrumbAtTheTopOfThePdp() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeLthreeBreadCrumbAtPdp());
    }

    @And("L-three pdp will be a clickable link back to L-three")
    public void lThreePdpWillBeAClickableLinkBackToLThree() {
        Assert.assertTrue(tcs.pom.getNavigation().iClickLthreeBreadCrumbAtPdp());
    }

    @And("I see the product name in the breadcrumb at the top of the page")
    public void iSeeTheProductNameInTheBreadcrumbAtTheTopOfThePage() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeProductNameOnBreadCrumb());
    }

}
