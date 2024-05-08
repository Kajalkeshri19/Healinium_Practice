package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

public class ProductTileStepDefinition {

    TestContextSetup tcs;

    public ProductTileStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I am viewing product tile for a bulk item \\(i.e. produce)")
    public void iAmViewingAProductTileForABulkItemIEProduce() {
        tcs.pom.getProductTile().iAmOnAProductTile();
    }

    @When("the tile of the item is loaded")
    public void theTileOfTheItemIsLoaded() {
        //Do nothing
    }


    @Then("The page will display the tile with a product image")
    public void thePageWillDisplayTheTileWithAProductImage() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeProductImage());
    }

    @And("the approximate product price")
    public void theApproximateProductPrice() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeProductPrice());
    }

    @And("the product title")
    public void theProductTitle() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeProductTitle());
    }

    @And("the product weight")
    public void theProductWeight() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeProductWeight());
    }

    @And("the cost per 100g")
    public void theCostPerG() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeCostPerWeight());
    }

    @And("an add to cart button")
    public void anAddToCartButton() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeCartButton());
    }

    @Given("I am on any page that display product tiles")
    public void iAmOnAnyPageThatDisplayProductTiles() {
        tcs.pom.getProductTile().iAmOnAPLPWithDiscount();
    }

    @And("there is a sale on an item")
    public void thereIsASaleOnAnItem() {
        tcs.pom.getProductTile().iSeeSaleOnItem();
    }

    @Then("The price of the item will have crossed out and the discounted price will be displayed in red")
    public void thePriceOfTheItemWillHaveCrossedOutAndTheDiscountedPriceWillBeDisplayedInRed() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeDiscountedPrice());
    }

    @And("an item is low in stock")
    public void anItemIsLowInStock() {
        tcs.pom.getProductTile().iAmOnLowStockItem();
    }

    @Then("The product tile will display")
    public void theProductTileWillDisplay() {
        theProductTitle();
    }

    @Given("I am on any page that displays a product tiles")
    public void iAmOnAnyPageThatDisplaysAProductTiles() {
        tcs.pom.getProductTile().iAmOnAPlp();
    }

    @And("a low stock inventory badge will display on top of the product image")
    public void aInventoryBadgeWillDisplayOnTopOfTheProductImage() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeLowInventoryMessage());
    }

    @Given("I am viewing product tile for a packaged item")
    public void iAmViewingAProductTileForAPackagedItem() {
        tcs.pom.getProductTile().iAmOnPackagedItem();
    }

    @And("the brand title")
    public void theBrandTitle() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeProductBrand());
    }

    @And("the product price")
    public void theProductPrice() {
        theApproximateProductPrice();
    }


    @And("an item is out of stock")
    public void anItemIsOutOfStock() {
        tcs.pom.getProductTile().iAmOnOutOfStockItem();
    }

    @And("a out of stock inventory badge will display on top of product image")
    public void aInventoryBadgeWillDisplayOnTopOfProductImage() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeOutOfStockMessage());
    }

    @Given("I am viewing a product tile")
    public void iAmViewingAProductTile() {
        iAmOnAnyPageThatDisplaysAProductTiles();
    }

    @When("I click on the + button for that item")
    public void i_click_on_the_button_for_that_item() {
        tcs.pom.getProductTile().clickOnAddButton();
    }


    @Then("The item will be added to my cart")
    public void theItemWillBeAddedToMyCart() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeProductHasBeenAdded());
    }

    @And("the tile will display the quantity I have added")
    public void theTileWillDisplayTheQuantityIHaveAdded() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeMiniCartTile());
    }

    @And("I will be able to add or remove the quantity of the item in my cart")
    public void iWillBeAbleToAddOrRemoveTheQuantityOfTheItemInMyCart() {
        tcs.pom.getProductTile().iCanAddOrReduceQuantity();
    }

    @And("I have added an item to cart")
    public void iHaveAddedAnItemToCart() {
        tcs.pom.getProductTile().addAnItemToCart();
    }

    @When("I click the + or - buttons next to the item amount")
    public void iClickTheOrButtonsNextToTheItemAmount() {
        tcs.pom.getProductTile().iClickOnAddOrMinusButtonNextToIt();
    }

    @Then("The quantity of the item in my cart will update")
    public void theQuantityOfTheItemInMyCartWillUpdate() {
        theItemWillBeAddedToMyCart();
    }

    @And("the new quantity of the item will display in the tile")
    public void theNewQuantityOfTheItemWillDisplayInTheTile() {
        tcs.pom.getProductTile().iGetNewUpdatedQuantity();
    }

    @When("I click anywhere on the tile other than the + button")
    public void iClickAnywhereOnTheTileOtherThanTheButton() {
        tcs.pom.getProductTile().iClickOnAnywhereOnTheProduct();
    }

    @Then("I will be taken to the PDP of that item")
    public void iWillBeTakenToThePDPOfThatItem() {
       Assert.assertTrue(tcs.pom.getProductTile().iWillBeTakenToThatPdp());
    }

    @And("there is a Sale on the item")
    public void thereIsASaleOnTheItem() {
        tcs.pom.getProductTile().iSeeSaleOnItem();
    }

    @Then("tile will display all details covered in bulk item")
    public void tileWillDisplayAllDetailsCoveredInBulkItem() {
        thePageWillDisplayTheTileWithAProductImage();
        theApproximateProductPrice();
        theProductPrice();
        theProductWeight();
        anAddToCartButton();
    }

    @And("will display deal information at bottom of tile")
    public void willDisplayDealInformationAtBottomOfTile() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeSaleDetails());
    }

    @Given("I am viewing the product tile")
    public void iAmViewingTheProductTile() {
        tcs.pom.getProductTile().iAmOnPcoTile();
    }

    @And("there is a Multi-buy Promo on the item")
    public void thereIsAMultiBuyPromoOnTheItem() {
        tcs.pom.getProductTile().iSeeMultiBuy();
    }

    @Then("The tile will display all details covered in Bulk item,Packaged item test cases")
    public void theTileWillDisplayAllDetailsCoveredInBulkItemPackagedItemTestCases() {
        thePageWillDisplayTheTileWithAProductImage();
        theApproximateProductPrice();
        theProductPrice();
        theProductWeight();
        anAddToCartButton();
    }

    @And("will display Multi-Buy information at the bottom of the tile")
    public void willDisplayMultiBuyInformationAtTheBottomOfTheTile() {
        willDisplayDealInformationAtBottomOfTile();
    }

    @Given("I am viewing product tile")
    public void iAmViewingProductTile() {
        tcs.pom.getProductTile().iAmOnPcoTile();
    }

    @And("there is a PCO Optimum offer on the item")
    public void thereIsAPCOOptimumOfferOnTheItem() {
         tcs.pom.getProductTile().iSeePcOptimumOffer();
    }

    @And("will display PC Optimum offer at the bottom of the tile")
    public void willDisplayPCOptimumOfferAtTheBottomOfTheTile() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeePcOptimumTag());
    }

    @And("the quantity is one")
    public void theQuantityIsOne() {
        Assert.assertTrue(tcs.pom.getProductTile().iSeeDefaultQuantity());
    }

    @When("I click the - button for that item the item will be removed from my cart")
    public void iClickTheButtonForThatItemTheItemWillBeRemovedFromMyCart() {
        Assert.assertTrue(tcs.pom.getProductTile().clickMinusOnMiniCart());
    }

    @And("the amount section will disappear")
    public void theAmountSectionWillDisappear() {
        Assert.assertTrue(tcs.pom.getProductTile().validateAmountSection());
    }

    @And("the add to cart button will re-appear")
    public void theAddToCartButtonWillReAppear() {
        Assert.assertTrue(tcs.pom.getProductTile().validateVisibilityOfAddToCartButton());
    }

    @Given("I am viewing the Sponsored product tile")
    public void iAmViewingTheSponsoredProductTile() {
    tcs.pom.getProductTile().iAmOnAPlp();
    }

    @And("the item is sponsored")
    public void theItemIsSponsored() {
     tcs.pom.getProductTile().iSeeSponsoredItem();
    }

    @And("will display sponsored on the tile")
    public void willDisplayOnTheTile() {
        //Do nothing
    }
}
