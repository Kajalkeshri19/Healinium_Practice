package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

import java.io.IOException;

public class FindALocationStepDefinition {

    TestContextSetup tcs;
    public FindALocationStepDefinition(TestContextSetup tcs) {
      this.tcs = tcs;
    }

    @Given("I am on the Find a Location page")
    public void i_am_on_the_find_a_location_page() {
       Assert.assertTrue(tcs.pom.getFindALocation().iAmOnFindLocationPage());
    }

    @And("I want to look up a store location")
    public void i_want_to_look_up_a_store_location() {
       Assert.assertTrue(tcs.pom.getFindALocation().iAmLookingForStore());
    }

    @When("I enter an address in the address search bar")
    public void i_enter_an_address_in_the_address_search_bar() {
        tcs.pom.getFindALocation().iEnterAddress("720 Broadview Ave, Toronto, Ontario M4K 2P1");
    }

    @Then("I will be shown the nearest store locations to that address")
    public void i_will_be_shown_the_nearest_store_locations_to_that_address() {
        Assert.assertTrue(tcs.pom.getFindALocation().iSeeNearByStores());
    }

    @And("I will be able to select a location")
    public void i_will_be_able_to_select_a_location() {
        tcs.pom.getFindALocation().selectTheStore("Broadview Avenue");
    }

    @And("I will be able to view location details")
    public void i_will_be_able_to_view_location_details() {
        Assert.assertTrue(tcs.pom.getFindALocation().iSeeStoreDetails());
    }

    @And("I will be able to see the locations on the Map")
    public void i_will_be_able_to_see_the_locations_on_the_map() {
        Assert.assertTrue(tcs.pom.getFindALocation().iViewLocationMap());
    }

    @Given("I am on a banner website for online grocery")
    public void iAmOnABannerWebsiteForOnlineGrocery() {
        Assert.assertTrue(tcs.pom.getNavigation().iAmOnPcxHomePage());
        Assert.assertTrue(tcs.pom.getNavigation().iSeeStoreLogo());
    }

    @When("I click the cart logo in the header")
    public void iClickTheCartLogoInTheHeader() {
        tcs.pom.getProductTile().iAmOnAPlp();
        tcs.pom.getProductTile().addAnItemToCart();
        tcs.pom.getNavigation().iClickOnCart();
    }

    @Then("I will be shown a mini cart with a breakdown of items and subtotal")
    public void iWillBeShownAMiniCartWithABreakdownOfItemsAndSubtotal() {
        Assert.assertTrue(tcs.pom.getNavigation().iSeeMyCartExpand());
        Assert.assertTrue(tcs.pom.getNavigation().iSeeAllItemsInCart());
    }

    @And("be able to increase the quantity of items")
    public void beAbleToIncreaseTheQuantityOfItems() {
        tcs.pom.getFindALocation().iCanIncreaseQuantity();
    }

    @And("be able to remove items")
    public void beAbleToRemoveItems() {
        Assert.assertTrue(tcs.pom.getFindALocation().iCanRemoveProduct());
    }

    @And("be able to go to cart page by clicking view cart")
    public void beAbleToGoToCartPageByClickingViewCart() {
        tcs.base.getDriver().navigate().back();
        tcs.pom.getProductTile().addAnItemToCart();
        tcs.pom.getNavigation().iClickOnCart();
        Assert.assertTrue(tcs.pom.getFindALocation().iClickOnViewCart());
    }

    @And("go to checkout page by clicking Checkout")
    public void goToCheckoutPageByClickingCheckout() throws IOException {
        tcs.base.getDriver().navigate().back();
        tcs.pom.getNavigation().iClickOnCart();
        tcs.pom.getFindALocation().iClickOnCheckout();
        tcs.pom.getNavigation().logInToAccount("CartAccount");
    }

    @And("be able to see the subtotal")
    public void beAbleToSeeTheSubtotal() {
       Assert.assertTrue(tcs.pom.getFindALocation().iSeeOrderSummary());
    }
}
