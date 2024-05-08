package step_definitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Cart;
import resources.DataDriven;
import resources.ProjectConfig;
import util.TestContextSetup;

import java.io.IOException;
import java.util.List;

public class CartStepDefinition {
    TestContextSetup tcs;

    public CartStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I'm a logged in user with a PCX pass subscription")
    public void iAmLoggedInUserWithAPCXPassSubscription() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("PCXPassAccount");
        iAmOnABusinessSite();
        tcs.pom.getNavigation().validatesUserHavePCXPass();
        tcs.pom.getCart().spendUpto(ProjectConfig.LOBLAW_MINIMUM_CART_VALUE_FOR_PCX_PASS);
    }

    @When("I navigate to cart page")
    public void iNavigateToCartPage() {
        iGoToCartPage();
        tcs.pom.getCart().validateSelectedFulfilmentIsDelivery(ProjectConfig.TEST_DELIVERY_CODE);
    }

    @Then("I should see relevant fees\\(specific for PCX pass customers) displayed on order summary component for cart and checkout pages")
    public void iShouldSeeRelevantFeesSpecificForPCXPassCustomersDisplayedOnOrderSummaryComponentForCartAndCheckoutPages() {
        tcs.pom.getCheckout().checkout();
        tcs.pom.getCheckout().selectDeliveryAddress();
        tcs.pom.getCheckout().selectTimeSlot();
        tcs.commonUtility.waitForTextNotToBePresentInElement(tcs.pom.getCart().serviceFeeOnCheckoutPage, "-");
        Assert.assertEquals(tcs.pom.getCart().getServiceFee(), 0);
    }

    @Given("I'm a logged in user who has cancelled the PCX Pass subscriptions")
    public void iMALoggedInUserWhoHasCancelledThePCXPassSubscriptions() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("CanceledPCXPassAccount");
        iAmOnABusinessSite();
        tcs.pom.getCart().selectAndAddItemFromFreshFruits();
    }

    @And("I dont have any outstanding benefits left")
    public void iDontHaveAnyOutstandingBenefitsLeft() {
        //validated in next step
    }

    @Then("I should see relevant fees \\(non Pass Fees) displayed on order summary component for cart and checkout pages")
    public void iShouldSeeRelevantFeesNonPassFeesDisplayedOnOrderSummaryComponentForCartAndCheckoutPages() {
        tcs.pom.getCheckout().checkout();
        tcs.pom.getCheckout().selectDeliveryAddress();
        tcs.pom.getCheckout().selectTimeSlot();
        tcs.commonUtility.waitForTextNotToBePresentInElement(tcs.pom.getCart().serviceFeeOnCheckoutPage, "-");
        Assert.assertTrue(tcs.pom.getCart().getServiceFee() > 0);
    }

    @Given("I don't have any items in my cart")
    public void iDontHaveAnyItemsInMyCart() {
        Assert.assertTrue(tcs.pom.getCart().validateEmptyCartFromMiniCart());
    }

    @When("I add my first item to the cart")
    public void iAddMyFirstItemToTheCart() {
        tcs.pom.getPLP().selectFreshFruits();
        tcs.pom.getPLP().addAnItemViaCLP();
    }

    @Then("I can access my cart and view that item")
    public void iCanAccessMyCartAndViewThatItem() {
        iGoToCartPage();
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().cartItemName));
    }

    @Given("I am viewing a product or my cart")
    public void iAmViewingAProductOrMyCart() {
        iHaveItemAInMyCartWithQuantityTwo();
    }

    @When("I add x more of that product to my cart")
    public void iAddXMoreOfThatProductToMyCart() {
        //getting random number from 1 to 11
        int randomQuantity = tcs.pom.getCart().getRandomNumberUpto(10)  + 1;
        tcs.pom.getCart().updateProductQuantityviaPLP(randomQuantity);
        tcs.commonUtility.waitForTextToBePresentInElement(tcs.pom.getCart().itemCountCartPage, String.valueOf(randomQuantity));
    }

    @Then("my cart should immediately update with that product and show the correct quantity")
    public void myCartShouldImmediatelyUpdateWithThatProductAndShowTheCorrectQuantity() {
        Assert.assertTrue(tcs.pom.getCart().getTotalItemsCountFromCartPage() > 0);
    }

    @Given("I am viewing sliced ham")
    public void iAmViewingSlicedHam() throws IOException {
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("PDP", "Ham").get(1));
        tcs.pom.getCart().addItemToCart();
    }

    @When("I add x grams of sliced ham")
    public void iAddXGramsOfSlicedHam() {
        tcs.pom.getCart().addItemToCart();
    }

    @Then("my cart should show x grams of sliced ham")
    public void myCartShouldShowXGramsOfSlicedHam() {
        tcs.pom.getCart().openMiniCartFlyer();
        Assert.assertTrue(tcs.pom.getCart().validateWeightForItemQuantity());
    }

    @Given("I am adding a product to my cart")
    public void iAmAddingAProductToMyCart() throws IOException {
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("PDP", "Product_ID").get(1));
        tcs.pom.getCart().addItemToCart();
    }

    @When("I add more than the max quantity of {int} units of the product")
    public void iAddMoreThanTheMaxQuantityOfUnitsOfTheProduct(int args) {
        tcs.pom.getCart().updateProductQuantityviaPLP(args);
    }

    @Then("I should not be able to add more")
    public void iShouldNotBeAbleToAddMore() {
        Assert.assertFalse(tcs.pom.getCart().quantityIncreaseButton.isEnabled());
    }

    @When("I remove a quantity of x of a product from my cart")
    public void iRemoveAQuantityOfXOfAProductFromMyCart() {
        //removed the quantity in the next step
    }

    /**
     * Gets the Product Count and Product Price before decreasing the quantity
     * validates that the Product Count and Product Price has decreased
     */
    @Then("my cart should immediately update with the correct quantity for that product and show the correct pricing")
    public void myCartShouldImmediatelyUpdateWithTheCorrectQuantityForThatProductAndShowTheCorrectPricing() {
        int initialProductCount = tcs.pom.getCart().getPLPProductQuantity();
        String initialSubtotal = tcs.pom.getCart().estSubTotal.getText();
        tcs.pom.getCart().decreaseQuantity();
        Assert.assertFalse(tcs.pom.getCart().estSubTotal.getText().matches(initialSubtotal ));
        Assert.assertTrue(tcs.pom.getCart().getPLPProductQuantity() != initialProductCount);
    }

    @Given("I have x quantity of a product in my cart")
    public void iHaveXQuantityOfAProductInMyCart() {
        iHaveItemAInMyCartWithQuantityTwo();
    }

    @When("I change that quantity from x to {int}")
    public void iChangeThatQuantityFromXTo(int quantity) {
        tcs.pom.getCart().updateProductQuantityviaPLP(quantity);
    }

    @Then("that product should be removed from the cart")
    public void thatProductShouldBeRemovedFromTheCart() {
        Assert.assertTrue(tcs.pom.getCart().validateEmptyCartFromMiniCart());
    }

    @Given("I have {int} product in my cart")
    public void iHaveProductInMyCart(int arg0) {
        tcs.pom.getCart().selectAndAddItemFromFreshFruits();
        iGoToCartPage();
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().cartItemName));
    }

    @When("I remove that product")
    public void iRemoveThatProduct() {
        tcs.pom.getCart().removeProductFromCart();
    }

    @Then("my cart should be empty")
    public void myCartShouldBeEmpty() {
        Assert.assertTrue(tcs.pom.getCart().validateEmptyCartFromMiniCart());
    }

    @And("I should see the {string} page when I go to my cart")
    public void iShouldSeeThePageWhenIGoToMyCart(String emptyCartMessage) {
        Assert.assertTrue(tcs.commonUtility.validateElementContainsText(tcs.pom.getCart().emptyCartStatus, emptyCartMessage));
    }

    @Given("I have item A in my cart with quantity two")
    public void iHaveItemAInMyCartWithQuantityTwo() {
        tcs.pom.getCart().selectAndAddItemFromFreshFruits();
        tcs.pom.getCart().openMiniCartFlyer();
        tcs.pom.getCart().increaseQuantity();
        tcs.pom.getCart().visitCart();
        Assert.assertEquals(tcs.pom.getCart().getTotalItemsCountFromCartPage(), 2);
    }

    @When("I see the same item while browsing")
    public void iSeeTheTheSameItemWhileBrowsing() {
        Assert.assertTrue(tcs.pom.getCart().validateAddedProductVisibilityInCLP());
    }

    @Then("I should see the quantity as two")
    public void iShouldSeeTheQuantityAsTwo() {
        int currentQuantity = Integer.parseInt(tcs.pom.getCart().getCLPProductQuantity());
        Assert.assertEquals(currentQuantity, 2);
    }

    @Then("I should see the quantity as two and be able to increase or decrease the quantity")
    public void iShouldSeeTheQuantityAsTwoAndBeAbleToIncreaseOrDecreaseTheQuantity() {
        iShouldSeeTheQuantityAsTwo();
        tcs.pom.getCart().increaseAndDecreaseQuantityOfCLPproduct();
        iShouldSeeTheQuantityAsTwo();
    }

    /**
     * Clicks on account-sign-in link
     * Enters credentials
     * Submits the form
     */
    @Given("I am Logged in")
    public void iAmLoggedIn() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("CartAccount");
    }

    /**
     * Verifies that the current page is home page
     * Selects the fresh vegetables category
     * Adds a random item from the selected category to cart
     */
    @And("I am on business site and I have products in my cart")
    public void iAmOnBusinessSiteAndIHaveProductsInMyCart() {
        tcs.pom.getHomePage().validateHomePage();
        tcs.pom.getCart().selectAndAddItemFromFreshFruits();
        tcs.pom.getCart().validateSelectedFulfilmentIsDelivery(ProjectConfig.TEST_DELIVERY_CODE);
    }

    /**
     * Opens up the cart page by first clicking mini-cart button and then view cart button
     */
    @When("I go to cart page")
    public void iGoToCartPage() {
        tcs.pom.getCart().openMiniCartFlyer();
        tcs.pom.getCart().visitCart();
    }

    /**
     * Validates that the cart items are visible on the cart page
     */
    @Then("I see that the order summary includes:")
    public void validateThatTheOrderSummaryIncludes() {
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().cartItemName));
    }

    /**
     * Validates that the count of items in the cart is greater thn or equal to 1
     */
    @And("number of items")
    public void numberOfItems() {
        Assert.assertTrue(tcs.pom.getCart().getTotalItemsCountFromCartPage() >= 1);
    }

    /**
     * Validates that the sub-total is visible on the cart page and is in valid format
     */
    @And("subtotal")
    public void subtotal() {
        Assert.assertTrue(tcs.pom.getCart().validateSubTotal());
    }

    /**
     * Validates that the pick-up is visible on the cart page and is in valid format
     */
    @And("service fee or delivery,pick up as -")
    public void serviceFeeOrDeliveryPickUpAs() {
        Assert.assertTrue(tcs.commonUtility.validateElementContainsText(tcs.pom.getCart().pickupFee, "-"));
    }

    /**
     * Validates that the estimated-tax is visible on the cart page and is in valid format
     */
    @And("est. taxes as zero")
    public void estTaxesAs() {
        Assert.assertTrue(tcs.pom.getCart().validateEstimatedTax());
    }

    @And("driver tip of five \\(if fulfillment is delivery)")
    public void driverTipOfFiveIfFulfillmentIsDelivery() {
        tcs.commonUtility.waitForTextToBePresentInElement(tcs.pom.getCart().driverTip, "5");
        Assert.assertTrue(tcs.commonUtility.validateElementContainsText(tcs.pom.getCart().driverTip, "5"));
    }

    @And("est. total")
    public void estTotal() {
        Assert.assertTrue(tcs.pom.getCart().validateEstTotal());
    }

    @Then("I will see a minimum cart value message and will not be able to move to Checkout")
    public void iWillSeeAMinimumCartValueMessageAndWillNotBeAbleToMoveToCheckout() {
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().minimumCartValueWarning));
    }

    @Given("I have PCX Pass and added less than ${int} worth of items to my cart for Pickup")
    public void iHavePCXPassAndAddedLessThan$WorthOfItemsToMyCartForPickup(int arg0) throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("PCXPassAccount");
        iAmOnABusinessSite();
        tcs.pom.getNavigation().validatesUserHavePCXPass();
        tcs.pom.getCart().clearCart();
        tcs.pom.getCart().selectAndAddItemFromFreshFruits();
    }

    @When("I go to the cart page")
    public void iGoToTheCartPage() {
        iGoToCartPage();
    }

    @Given("I have an item in my cart")
    public void iHaveAnItemInMyCart() {
        tcs.pom.getCart().selectAndAddItemFromFreshFruits();
    }

    /**
     * Adding special instructions, requires a logged-in user
     * Sign in and add the special instruction and
     * then validates that the instruction message is displayed
     */
    @Then("I can add a special instruction to that item")
    public void iCanAddASpecialInstructionToThatItem() throws IOException {
        tcs.pom.getCart().clickSpecialInstructions();
        tcs.pom.getNavigation().logInToAccount("CartAccount");
        tcs.pom.getCart().clickSpecialInstructions();
        tcs.pom.getCart().addSpecialInstructions("Test@123");
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().existingInstructionText));
    }

    /**
     * Selects the fresh vegetables category
     * Adds a random item from the selected category to cart
     * then visit cart
     * and add special instruction
     */
    @Given("I wrote an instructions for an item in my cart")
    public void iWroteAnInstructionsForAnItemInMyCart() throws IOException {
        iAmLoggedIn();
        tcs.pom.getCart().clearCart();
        tcs.pom.getCart().selectAndAddItemFromFreshFruits();
        iGoToCartPage();
        tcs.pom.getCart().clickSpecialInstructions();
        tcs.pom.getCart().addSpecialInstructions("Test@123");
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().existingInstructionText));
    }

    /**
     * Removes the items with instructions
     * Adds them back to the cart
     * Visit cart
     */
    @When("I remove the item from my cart and readd")
    public void iRemoveTheItemFromMyCartAndReadd() {
        String productName = tcs.pom.getCart().cartItemName.getText();
        tcs.pom.getCart().removeProductFromCart();
        Assert.assertTrue(tcs.pom.getCart().validateEmptyCartFromMiniCart());
        tcs.pom.getCart().searchProduct(productName);
        tcs.pom.getCart().findProductByName(productName);
        tcs.pom.getCart().addItemToCart();
    }

    /**
     * Validates that the special instruction message is visible on the cart page
     */
    @Then("I should still see the same instructions I wrote")
    public void iShouldStillSeeTheSameInstructionsIWrote() {
        iGoToCartPage();
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().existingInstructionText));
    }

    /**
     * Logs in to the account
     * Selects the fresh vegetables category
     * Adds a random item from the selected category to cart
     * then visit cart
     * and ensures that the pick-up fulfillment mode is selected
     */
    @Given("I have a cart full of items with the fulfillment method pick up")
    public void iHaveACartFullOfItemsWithTheFulfillmentMethodPickUp() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("PickUpAccount");
        iAmOnABusinessSite();
        iGoToCartPage();
        tcs.pom.getCart().validatePickUpFromHeader();
    }

    /**
     * Switches to the delivery fulfillment mode
     * and ensures that the selected fulfillment mode is delivery
     */
    @When("I go to checkout page and change the fulfilment method to delivery")
    public void iGoToCheckoutPageAndChangeTheFulfilmentMethodToDelivery() {
        tcs.pom.getCheckout().checkout();
        tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().switchFulfilmentOnCheckoutPage);
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().checkoutShippingAddressList);
        if(!tcs.pom.getCheckout().checkoutShippingAddressList.isEmpty()){
            tcs.commonUtility.clickOnElement(tcs.commonUtility.selectAnyElementRandomly(tcs.pom.getCheckout().checkoutShippingAddressList,tcs.pom.getCheckout().checkoutShippingAddressList.size()));
            tcs.commonUtility.clickOnElement(tcs.pom.getCheckout().saveAndContinueButton);
        }
        tcs.commonUtility.waitForElementVisibility(tcs.pom.getCheckout().driverTip);
    }

    /**
     * Increase the quantity of item(at a particular index) to its maximum limit, so that minimum cart value would be greater than $35
     * If the limit exceeds and minimum cart value is still lesser than $35, add another item and increase its quantity
     * Thus, it validates that the cart's subtotal is equal to or more than 35 dollars.
     * and the user is able to check out or move back
     */
    @Then("I should be notified of the changes in my cart if I proceed and be able to make decisions to proceed or go back")
    public void iShouldBeNotifiedOfTheChangesInMyCartIfIProceedAndBeAbleToMakeDecisionsToProceedOrGoBack() {
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().backToCartLink);
        Assert.assertTrue(tcs.pom.getCart().validateDeliveryOnCartPage());
        Assert.assertTrue(tcs.pom.getCart().moveForthAndBack());
    }

    /**
     * Logs in to the account
     * Selects the fresh vegetables category
     * Adds a random item from the selected category to cart
     */
    @Given("I have items in my cart")
    public void iHaveItemsInMyCart() throws IOException {
        iAmLoggedIn();
        iAmOnABusinessSite();
        tcs.pom.getCart().clearCart();
        tcs.pom.getCart().selectAndAddItemFromFreshFruits();
    }

    /**
     * Toggles the substitute check box for all items in the cart
     */
    @Then("I can choose to opt-in or opt out for subs for each item in my cart")
    public void iCanChooseToOptInOrOptOutForSubsForEachItemInMyCart() {
        tcs.pom.getCart().chooseSubsForItemsInMyCart();
        Assert.assertTrue(tcs.pom.getCart().validateSubsForItemsInCart());
    }

    /**
     * Logs in to the account
     * Go to the home page and clears the cart, if any product is there in the cart
     * adds a random item to the cart
     * visit the cart and toggles the substitute check box
     */
    @Given("I have item A in my cart and I selected to opt-out of the substitution checkbox")
    public void iHaveItemAInMyCartAndISelectedToOptOutOfTheSubstitutionCheckbox() throws IOException {
        iAmLoggedIn();
        iAmOnABusinessSite();
        tcs.pom.getCart().clearCart();
        tcs.pom.getCart().selectAndAddItemFromFreshFruits();
        iGoToCartPage();
        tcs.pom.getCart().chooseSubsForItemsInMyCart();
    }

    @When("I remove the item entirely from my cart and re-add")
    public void iRemoveTheItemEntirelyFromMyCartAndReAdd() {
        iRemoveTheItemFromMyCartAndReadd();
    }

    @Then("I can see that the sub checkbox for the item is opted-out")
    public void iCanSeeThatTheSubCheckboxForTheItemIsOptedOut() {
        iGoToCartPage();
        Assert.assertTrue(tcs.pom.getCart().validateSubsForItemsInCart());
    }

    @Given("I'm an anonymous user and I have added product A to my cart from tab A and I am on tab B on the same site and I have added product B to my cart from tab B sheetname and rownumber")
    public void iMAnAnonymousUserAndIHaveAddedProductAToMyCartFromTabAAndIAmOnTabBOnTheSameSiteAndIHaveAddedProductBToMyCartFromTabBSheetnameAndRownumber() throws IOException {
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("TestData", "Products").get(1));
        tcs.pom.getCart().addItemToCart();
        tcs.commonUtility.waitForTextToBePresentInElement(tcs.pom.getCart().itemCountMiniCart, "1");
        tcs.pom.getCart().openSiteInNewTabAndSwitch();
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("TestData", "Products").get(2));
        tcs.pom.getCart().addItemToCart();
        tcs.commonUtility.waitForTextToBePresentInElement(tcs.pom.getCart().itemCountMiniCart, "2");
    }

    @When("when I go back to tab A")
    public void whenIGoBackToTabA() {
        tcs.commonUtility.switchToTab(0);
    }

    @Then("my cart should show products A and B")
    public void myCartShouldShowProductsAAndB() {
        iGoToCartPage();
        Assert.assertEquals(tcs.pom.getCart().getTotalItemsCountFromCartPage(), 2);
    }

    @Given("I am on a business site")
    public void iAmOnABusinessSite() {
        tcs.pom.getHomePage().validateHomePage();
    }

    @And("I have an item in my cart that has low stock")
    public void iHaveAnItemInMyCartThatHasLowStock() {
        tcs.pom.getPLP().selectFreshFruits();
        tcs.pom.getCart().findALowStockItem();
        tcs.pom.getCart().addItemToCart();
    }

    @Then("I should see a Low stock warning next to the item as well as a warning banner on the page")
    public void iShouldSeeALowStockWarningNextToTheItemAsWellAsAWarningBannerOnThePage() {
        Assert.assertTrue(tcs.pom.getCart().validateLowStockWarningMessage());
    }

    @And("the low stock product should have a low stock callout and a link to select a substitute")
    public void theLowStockProductShouldHaveALowStockCalloutAndALinkToSelectASubstitute() {
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().lowStockCallOut));
    }

    @Given("I have one apple, two breads and three butters in my cart")
    public void iHaveOneAppleTwoBreadsAndThreeButtersInMyCart() {
        tcs.pom.getCart().searchProduct("apple");
        tcs.pom.getCart().addRandomItemToCart();
        tcs.pom.getCart().searchProduct("bread");
        tcs.pom.getCart().addRandomItemToCart();
        tcs.pom.getCart().updateProductQuantityviaPLP(2);
        tcs.pom.getCart().searchProduct("butter");
        tcs.pom.getCart().addRandomItemToCart();
        tcs.pom.getCart().updateProductQuantityviaPLP(3);
    }

    @When("I view my cart")
    public void iViewMyCart() {
        iGoToCartPage();
    }

    @Then("I should see a total item count of Six")
    public void iShouldSeeATotalItemCountOfSix() {
        Assert.assertTrue(tcs.pom.getCart().getTotalItemsCountFromCartPage() >= 6);
    }

    @Given("I am browsing and shopping through the business page")
    public void iAmBrowsingAndShoppingThroughTheBusinessPage() {
        iAmOnABusinessSite();
        tcs.pom.getCart().selectAndAddItemFromFreshFruits();
    }

    @When("I scroll over the cart icon on the navigation top right")
    public void iScrollOverTheCartIconOnTheNavigationTopRight() {
        tcs.pom.getCart().openMiniCartFlyer();
    }

    @Then("I should see the the contents of my cart including item names, quantities, and cart total.")
    public void iShouldSeeTheTheContentsOfMyCartIncludingItemNamesQuantitiesAndCartTotal() {
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().itemNameMiniCart));
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().itemQuantityMiniCart));
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().subTotalMiniCart));
    }

    @And("I should be able to click the delete icon to remove the product form cart")
    public void iShouldBeAbleToClickTheDeleteIconToRemoveTheProductFormCart() {
        tcs.pom.getCart().removeProductFromCart();
        tcs.pom.getCart();
        Assert.assertTrue(tcs.commonUtility.validateIfElementIsNotPresent(Cart.byRemoveItemButton));
    }

    @And("I should be able to click on the View Cart and checkout CTA to navigate to the appropriate page")
    public void iShouldBeAbleToClickOnTheViewCartAndCheckoutCTAToNavigateToTheAppropriatePage() {
        tcs.pom.getCart().selectAndAddItemFromFreshFruits();
        iGoToCartPage();
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().cartPageHeader));
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().homePageLogo);
        tcs.pom.getCart().openMiniCartFlyer();
        Assert.assertTrue(tcs.pom.getCart().checkoutFromMiniCart());
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().homePageLogo);
    }

    @And("I should be able to change the quantity of the articles in the cart")
    public void iShouldBeAbleToChangeTheQuantityOfTheArticlesInTheCart() {
        //validated in next step
    }

    @And("any changes to my cart should reflect the appropriate change on the price of the Subtotal")
    public void anyChangesToMyCartShouldReflectTheAppropriateChangeOnThePriceOfTheSubtotal() {
        tcs.pom.getCart().openMiniCartFlyer();
        String initialSubtotal = tcs.pom.getCart().subTotalMiniCart.getText();
        tcs.pom.getCart().increaseQuantity();
        String currentSubtotal = tcs.pom.getCart().subTotalMiniCart.getText();
        Assert.assertFalse(currentSubtotal.matches(initialSubtotal));
    }

    @And("I should be able to scroll to view the products in the mini cart view")
    public void iShouldBeAbleToScrollToViewTheProductsInTheMiniCartView() {
        Assert.assertTrue(tcs.pom.getCart().addThreeItemsAndViewTheLastItemInMiniCart());
    }

    @Given("I am on any grocery banner and I click \"menu\" on web")
    public void iAmOnAnyGroceryBannerAndIClickMenuOnWeb() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("PCOptimumAccount");
        iAmOnABusinessSite();
    }

    @When("I click the chat icon in bottom right")
    public void iClickTheChatIconInBottomRight() {
        tcs.pom.getCart().openChatBot();
    }

    @Then("The Adachatbot should open")
    public void theAdachatbotShouldOpen() {
        Assert.assertTrue(tcs.pom.getCart().validateChatBot());
    }

    @Given("I have added NO alcohol products to my cart")
    public void iHaveAddedNOAlcoholProductsToMyCart() {
        tcs.pom.getCart().selectAndAddItemFromFreshFruits();
    }

    @When("I click proceed to cart")
    public void iClickProceedToCart() {
        iGoToCartPage();
    }

    @Then("I should NOT see this messaging at cart: Beer and wine: Prices shown at checkout will be itemized separately to show you the product price before applicable taxes and bottle deposit fees are added. You must be of legal drinking age to purchase alcohol products.")
    public void iShouldNOTSeeThisMessagingAtCartBeerAndWinePricesShownAtCheckoutWillBeItemizedSeparatelyToShowYouTheProductPriceBeforeApplicableTaxesAndBottleDepositFeesAreAddedYouMustBeOfLegalDrinkingAgeToPurchaseAlcoholProducts() {
        tcs.pom.getCart();
        Assert.assertTrue(tcs.commonUtility.validateIfElementIsNotPresent(Cart.errorMessage));
    }
    
    //WSC SPECIFIC STEP DEFINITIONS

    @Given("I am on WSC banner and I have added less than ${int} worth of items to my cart for Pickup")
    public void iAmOnWSCBannerAndIHaveAddedLessThan$WorthOfItemsToMyCartForPickup(int arg0) throws IOException {
        iAmLoggedIn();
        tcs.pom.getHomePage().validateHomePage();
        tcs.pom.getCart().clearCart();
        tcs.pom.getCart().validatePickUpFromHeader();
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("PDP", "Wsc_Product").get(1));
        tcs.pom.getCart().addItemToCart();
    }

    //Time slot is to be selected before checking out on wsc
    @When("I go to the wholesale-cart page")
    public void iGoToTheWholesaleCartPage() {
        iGoToCartPage();
        if(!tcs.commonUtility.validateIfElementIsNotPresent(tcs.pom.getCart().bySelectTimeSlotButtonCartPage)){
            tcs.commonUtility.clickOnElement(tcs.pom.getCart().selectTimeSlotButtonCartPage);
            tcs.pom.getCart().selectPickUpDate();
            tcs.pom.getCart().chooseTimeSlot();
        }
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @When("I add my first item to the wholesale-cart")
    public void iAddMyFirstItemToTheWholesaleCart() {
        tcs.pom.getCart().searchProduct("apple");
        tcs.pom.getCart().addItemToCart();
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    public void iHaveItemAInMyWholesaleCartWithQuantityTwo() {
        iAddMyFirstItemToTheWholesaleCart();
        tcs.pom.getCart().openMiniCartFlyer();
        tcs.pom.getCart().increaseQuantity();
        tcs.pom.getCart().visitCart();
        Assert.assertEquals(tcs.pom.getCart().getTotalItemsCountFromCartPage(), 2);
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @Given("I am viewing a product or my wholesale-cart")
    public void iAmViewingAProductOrMyWholesaleCart() {
        iHaveItemAInMyWholesaleCartWithQuantityTwo();
    }

    //Repeated step-definition as product ids are different for wsc and loblaw
    @Given("I am viewing wholesale-sliced ham")
    public void iAmViewingWholesaleSlicedHam() throws IOException {
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("PDP", "WSCHam").get(1));
        tcs.pom.getCart().addItemToCart();
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @Given("I am adding a product to my wholesale-cart")
    public void iAmAddingAProductToMyWholesaleCart() throws IOException {
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("PDP", "WSCInStockProduct").get(1));
        tcs.pom.getCart().addItemToCart();
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @Given("I have x quantity of a product in my wholesale-cart")
    public void iHaveXQuantityOfAProductInMyWholesaleCart() {
        iHaveItemAInMyWholesaleCartWithQuantityTwo();
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @Given("I have {int} product in my wholesale-cart")
    public void iHaveProductInMyWholesaleCart(int arg0) {
        iAddMyFirstItemToTheWholesaleCart();
        iGoToCartPage();
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().cartItemName));
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @And("I am on business site and I have products in my wholesale-cart")
    public void iAmOnBusinessSiteAndIHaveProductsInMyWholesaleCart() {
        iAmOnABusinessSite();
        iAddMyFirstItemToTheWholesaleCart();
        tcs.pom.getCart().validateSelectedFulfilmentIsDelivery(ProjectConfig.WHOLESALE_DELIVERY_CODE);
    }

    //In WSC, Delivery or pickUp fee has a select button, and in loblaw, it have -
    @And("delivery or pick up fee has a select button")
    public void deliveryOrPickUpFeeHasASelectButton() {
        tcs.pom.getCart();
        List<WebElement> listOfSelectButtons = tcs.pom.getCart().pickupFee.findElements(Cart.selectTimeSlotButtonOrderSummary);
        Assert.assertFalse(listOfSelectButtons.isEmpty());
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @Given("I have an item in my wholesale-cart")
    public void iHaveAnItemInMyWholesaleCart() {
        iAddMyFirstItemToTheWholesaleCart();
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @Given("I wrote an instructions for an item in my wholesale-cart")
    public void iWroteAnInstructionsForAnItemInMyWholesaleCart() throws IOException {
        iAmLoggedIn();
        tcs.pom.getCart().clearCart();
        iAddMyFirstItemToTheWholesaleCart();
        iGoToCartPage();
        tcs.pom.getCart().clickSpecialInstructions();
        tcs.pom.getCart().addSpecialInstructions("Test@123");
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().existingInstructionText));
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @Given("I have items in my wholsale-cart")
    public void iHaveItemsInMyWholsaleCart() throws IOException {
        iAmLoggedIn();
        iAmOnABusinessSite();
        tcs.pom.getCart().clearCart();
        iAddMyFirstItemToTheWholesaleCart();
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @Given("I have item A in my wholesale-cart and I selected to opt-out of the substitution checkbox")
    public void iHaveItemAInMyWholesaleCartAndISelectedToOptOutOfTheSubstitutionCheckbox() throws IOException {
        iAmLoggedIn();
        iAmOnABusinessSite();
        tcs.pom.getCart().clearCart();
        iAddMyFirstItemToTheWholesaleCart();
        iGoToCartPage();
        tcs.pom.getCart().chooseSubsForItemsInMyCart();
    }

    //Repeated step-definition as product ids are different for wsc and loblaw
    @Given("I'm an anonymous user and I have added product A to my wholsale-cart from tab A and I am on tab B on the same site and I have added product B to my wholsale-cart from tab B sheetname and rownumber")
    public void iMAnAnonymousUserAndIHaveAddedProductAToMyWholsaleCartFromTabAAndIAmOnTabBOnTheSameSiteAndIHaveAddedProductBToMyWholsaleCartFromTabBSheetnameAndRownumber() throws IOException {
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("PDP", "WSCInStockProduct").get(1));
        tcs.pom.getCart().addItemToCart();
        tcs.commonUtility.waitForTextToBePresentInElement(tcs.pom.getCart().itemCountMiniCart, "1");
        tcs.pom.getCart().openSiteInNewTabAndSwitch();
        tcs.pom.getCart().searchProduct(DataDriven.getTestData("PDP", "WSCInStockProduct").get(2));
        tcs.pom.getCart().addItemToCart();
        tcs.commonUtility.waitForTextToBePresentInElement(tcs.pom.getCart().itemCountMiniCart, "2");
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @Given("I am browsing and shopping through the wholsale-business page")
    public void iAmBrowsingAndShoppingThroughTheWholsaleBusinessPage() {
        iAmOnABusinessSite();
        iAddMyFirstItemToTheWholesaleCart();
    }

    //Repeated step-definition as minimum cart value is different for wsc and loblaw
    @And("I should be able to click on the View wholsale-Cart and checkout CTA to navigate to the appropriate page")
    public void iShouldBeAbleToClickOnTheViewWholsaleCartAndCheckoutCTAToNavigateToTheAppropriatePage() {
        tcs.pom.getCart().spendUptoWholesaleCart(ProjectConfig.WSC_MINIMUM_CART_VALUE);
        iGoToCartPage();
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().cartPageHeader));
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().homePageLogo);
        tcs.pom.getCart().openMiniCartFlyer();
        Assert.assertTrue(tcs.pom.getCart().checkoutFromMiniCart());
        tcs.commonUtility.clickOnElement(tcs.pom.getCart().homePageLogo);
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @Given("I have added NO alcohol products to my wholesale-cart")
    public void iHaveAddedNOAlcoholProductsToMyWholesaleCart() {
        iAddMyFirstItemToTheWholesaleCart();
    }

    //Temporary method as currently we are searching the product, instead of selecting it from category
    @And("I should be able to scroll to view the products in the mini wholesale-cart view")
    public void iShouldBeAbleToScrollToViewTheProductsInTheMiniWholesaleCartView() {
        Assert.assertTrue(tcs.pom.getCart().addThreeItemsAndViewTheLastItemInMiniWholesaleCart());
    }
}

