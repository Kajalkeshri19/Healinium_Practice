package step_definitions;

import ddt_config.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.Log;
import util.TestContextSetup;

import java.util.List;
import java.util.Map;

public class PdpStepDefinition {
    TestContextSetup tcs;

    public PdpStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I am on a PDP")
    public void iAmOnAPDP() {
        //Given Step is intentionally kept empty to implement DDT approach
    }

    @When("the page loads")
    public void thePageLoads() {
        //When step is intentionally kept empty to implement DDT approach
    }

    @Then("page will display all the required infomation")
    public void pageWillDisplayAllTheRequiredInfomation(DataReader dataReader) {
        List<Map<String, String>> pdpCodes = dataReader.getAllRows();
        Log.info("PDP" + pdpCodes);
        for (Map<String, String> pdpCode : pdpCodes) {
            if(!pdpCode.get("Product_ID").isEmpty()) {
                tcs.pom.getSearchPage().searchTheProduct(pdpCode.get("Product_ID"));
                tcs.pom.getPdpPage().clickPdp();
                Assert.assertTrue(tcs.pom.getPdpPage().validateWeight());
                Assert.assertTrue(tcs.pom.getPdpPage().validateBreadCrumbItemsVisible());
                Assert.assertTrue(tcs.pom.getPdpPage().validateProductNameVisible());
                Assert.assertTrue(tcs.pom.getPdpPage().validateBreadCrumbItemsVisible());
                Assert.assertTrue(tcs.pom.getPdpPage().validatePdpImageAndMagnifier());
                Assert.assertTrue(tcs.pom.getPdpPage().validateWeight());
                Assert.assertTrue(tcs.pom.getPdpPage().validateBrandNameVisible());
                Assert.assertTrue(tcs.pom.getPdpPage().validateProductPriceVisible());
                Assert.assertTrue(tcs.pom.getPdpPage().validateExpandedDescriptionAndOtherFacetsCollapsed());
//          Recommendation Microservice not migrated yet for PCX-QA, Bug-LDP-19104.
//          Assert.assertFalse(tcs.pom.getPdpPage().validateRelatedItemsSection());
                Assert.assertTrue(tcs.pom.getPdpPage().validateAddToProductVisible());
            }
        }

    }

    @Then("price of the item will have crossed out and the discounted price will be displayed in red, sale badge and amount saved and expiration date of the discount")
    public void priceOfTheItemWillHaveCrossedOutAndTheDiscountedPriceWillBeDisplayedInRedSaleBadgeAndAmountSavedAndExpirationDateOfTheDiscount(DataReader dataReader) {
        List<Map<String, String>> pdpCodes = dataReader.getAllRows();
        Log.info("PDP" + pdpCodes);
        for (Map<String, String> pdpCode : pdpCodes) {
            if(!pdpCode.get("Sale_ID").isEmpty()) {
                tcs.pom.getSearchPage().searchTheProduct(pdpCode.get("Sale_ID"));
                tcs.pom.getPdpPage().clickPdp();
                Assert.assertTrue(tcs.pom.getPdpPage().validateSellingPrice());
                Assert.assertTrue(tcs.pom.getPdpPage().validatePdpRegularPrice());
                Assert.assertTrue(tcs.pom.getPdpPage().validatePdpAmountSavings());
                Assert.assertTrue(tcs.pom.getPdpPage().validateSaleBadge());
                Assert.assertTrue(tcs.pom.getPdpPage().validateOfferExpiry());
            }
        }
    }

    @Then("PDP will display a low stock inventory badge and provide additional context on what this means")
    public void pdpWillDisplayAInventoryBadgeAndProvideAdditionalContextOnWhatThisMeans(DataReader dataReader) {
        List<Map<String, String>> pdpCodes = dataReader.getAllRows();
        Log.info("PDP" + pdpCodes);
        for (Map<String, String> pdpCode : pdpCodes) {
            if(!pdpCode.get("Low_Stock").isEmpty()) {
                tcs.pom.getSearchPage().searchTheProduct(pdpCode.get("Low_Stock"));
                tcs.pom.getPdpPage().clickPdp();
                Assert.assertTrue(tcs.pom.getPdpPage().validateLowStockBadge());
                Assert.assertTrue(tcs.pom.getPdpPage().validateLowStockDescription());
            }
        }
    }

    @Then("PDP will display a out of stock inventory badge and provide additional context on what this means and I will not be able to add this item to my cart")
    public void pdpWillDisplayAOutOfStockInventoryBadgeAndProvideAdditionalContextOnWhatThisMeansAndIWillNotBeAbleToAddThisItemToMyCart(DataReader dataReader) {
        List<Map<String, String>> pdpCodes = dataReader.getAllRows();
        Log.info("PDP" + pdpCodes);
        for (Map<String, String> pdpCode : pdpCodes) {
            if(!pdpCode.get("Out_Of_Stock").isEmpty()) {
                tcs.pom.getSearchPage().searchTheProduct(pdpCode.get("Out_Of_Stock"));
                tcs.pom.getPdpPage().clickPdp();
                Assert.assertTrue(tcs.pom.getPdpPage().validateOutOfStockText());
            }
        }
    }

    @Then("click on Add To Cart and the item will be added to my cart")
    public void clickOnAddToCartAndTheItemWillBeAddedToMyCart(DataReader dataReader) {
        List<Map<String, String>> pdpCodes = dataReader.getAllRows();
        Log.info("PDP" + pdpCodes);
        for (Map<String, String> pdpCode : pdpCodes) {
            if(!pdpCode.get("Product_ID").isEmpty()) {
                tcs.pom.getSearchPage().searchTheProduct(pdpCode.get("Product_ID"));
                tcs.pom.getPdpPage().clickPdp();
                Assert.assertTrue(tcs.pom.getPdpPage().validateAddToProductVisible());
                tcs.pom.getPdpPage().clickAddToCartButton();
                Assert.assertTrue(tcs.pom.getPdpPage().validateAddToCart());
            }
        }
    }

    @Then("PDP will display deal information on the page along with Savings Strikethorugh pricing and the expiration date of the promo")
    public void pdpWillDisplayDealInformationOnThePageAlongWithSavingsStrikethorughPricingAndTheExpirationDateOfThePromo(DataReader dataReader) {
        List<Map<String, String>> pdpCodes = dataReader.getAllRows();
        Log.info("PDP" + pdpCodes);
        for (Map<String, String> pdpCode : pdpCodes) {
            if(!pdpCode.get("Sale_ID").isEmpty()) {
                tcs.pom.getSearchPage().searchTheProduct(pdpCode.get("Sale_ID"));
                tcs.pom.getPdpPage().clickPdp();
                Assert.assertTrue(tcs.pom.getPdpPage().validateSellingPrice());
                Assert.assertTrue(tcs.pom.getPdpPage().validatePdpRegularPrice());
                Assert.assertTrue(tcs.pom.getPdpPage().validatePdpAmountSavings());
                Assert.assertTrue(tcs.pom.getPdpPage().validateSaleBadge());
                Assert.assertTrue(tcs.pom.getPdpPage().validateOfferExpiry());
            }
        }
    }

    @Then("The PDP will display deal information on the page along with Min purchase price and the expiration date of the promo")
    public void thePDPWillDisplayDealInformationOnThePageAlongWithMinPurchasePriceAndTheExpirationDateOfThePromo(DataReader dataReader) {
        List<Map<String, String>> pdpCodes = dataReader.getAllRows();
        Log.info("PDP" + pdpCodes);
        for (Map<String, String> pdpCode : pdpCodes) {
            if(!pdpCode.get("Multibuy").isEmpty()) {
                tcs.pom.getSearchPage().searchTheProduct(pdpCode.get("Multibuy"));
                tcs.pom.getPdpPage().clickPdp();
                Assert.assertTrue(tcs.pom.getPdpPage().validateMultiBadge());
                Assert.assertTrue(tcs.pom.getPdpPage().validateMultiMessage());
            }
        }
    }

    @Then("Related items will display at the bottom of the page")
    public void relatedItemsWillDisplayAtTheBottomOfThePage(DataReader dataReader) {
        List<Map<String, String>> pdpCodes = dataReader.getAllRows();
        Log.info("PDP" + pdpCodes);
        for (Map<String, String> pdpCode : pdpCodes) {
            if(!pdpCode.get("Product_ID").isEmpty()) {
                tcs.pom.getSearchPage().searchTheProduct(pdpCode.get("Product_ID"));
                tcs.pom.getPdpPage().clickPdp();
                Log.info("Product Name: " + tcs.pom.getPdpPage().pdpProductTitle.getText());
                Assert.assertFalse(tcs.pom.getPdpPage().validateRelatedItemsSection());
                Assert.assertTrue(tcs.pom.getPdpPage().validateRelatedItems());
            }
        }
    }

    @Then("The quantity of the item in my cart will update and the new quantity of the item will display in the tile")
    public void theQuantityOfTheItemInMyCartWillUpdateAndTheNewQuantityOfTheItemWillDisplayInTheTile(DataReader dataReader) {
        List<Map<String, String>> pdpCodes = dataReader.getAllRows();
        Log.info("PDP" + pdpCodes);
        for (Map<String, String> pdpCode : pdpCodes) {
            if(!pdpCode.get("Product_ID").isEmpty()) {
                tcs.pom.getSearchPage().searchTheProduct(pdpCode.get("Product_ID"));
                tcs.pom.getPdpPage().clickPdp();
                tcs.pom.getPdpPage().clickAddToCartButton();
                tcs.pom.getPdpPage().addTheItemPlusOne();
                Assert.assertTrue(tcs.pom.getPdpPage().validateCartProductQuantity());
            }
        }
    }

    @Then("The item will be removed from my cart and the amount section will disappear and the add to cart button will re-appear")
    public void theItemWillBeRemovedFromMyCartAndTheAmountSectionWillDisappearAndTheAddToCartButtonWillReAppear(DataReader dataReader) {
        List<Map<String, String>> pdpCodes = dataReader.getAllRows();
        Log.info("PDP" + pdpCodes);
        for (Map<String, String> pdpCode : pdpCodes) {
            if(!pdpCode.get("Product_ID").isEmpty()) {
                tcs.pom.getSearchPage().searchTheProduct(pdpCode.get("Product_ID"));
                tcs.pom.getPdpPage().clickPdp();
                tcs.pom.getPdpPage().clickAddToCartButton();
                tcs.pom.getPdpPage().decreaseTheItemQuantity();
                Assert.assertTrue(tcs.pom.getPdpPage().validateAddToCart());
            }
        }
    }
}
