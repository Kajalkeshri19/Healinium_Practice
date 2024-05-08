package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

import java.io.IOException;
import java.time.Duration;

public class HomePageStepDefinition {
    TestContextSetup tcs;

    public HomePageStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I am on the home page of any banner")
    public void iAmOnTheHomePageOfAnyBanner() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfSignInButton());
    }

    @When("I scroll down the page")
    public void iScrollDownThePage() {
        tcs.pom.getHomePage().scrollDownPage();
    }

    @Then("I will see the following components:")
    public void iWillSeeTheFollowingComponents() {
        //done in following step
    }

    @And("The navigation")
    public void theNavigation() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfNavigation());
    }

    @And("a Headline banner")
    public void aHeadlineBanner() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfHeadlineBanner());
    }

    @And("a PCX Pass registration banner")
    public void aPCXPassRegistrationBanner() {
        /**
         TODO:
         **/
    }

    @And("a Sign in information card")
    public void aSignInInformationCard() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfSignInInformationCard());
    }

    @And("a Flyers and deals information card")
    public void aFlyersAndDealsInformationCard() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfFlyersAndDealsInformationCard());
    }

    @And("a location details for the order information card")
    public void aLocationDetailsForTheOrderInformationCard() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfLocationDetailsForTheOrderInformationCard());
    }

    @And("a two-up promo carousel")
    public void aTwoUpPromoCarousel() {
        /**
         TODO:
         **/
    }

    @And("a menu tiles carousel to shop categories")
    public void aMenuTilesCarouselToShopCategories() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfMenuTilesCarouselToShopCategories());
    }


    @And("a Start Shopping mini product tile carousel")
    public void aStartShoppingMiniProductTileCarousel() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfStartShoppingMiniProductTileCarousel());
    }

    @And("any product tile carousels as configured by merch team")
    public void anyProductTileCarouselsAsConfiguredByMerchTeam() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfProductTileCarousels());
    }


    @And("any promotional fifty-fifty wrappers as configured by merch team")
    public void anyPromotionalFiftyFiftyWrappersAsConfiguredByMerchTeam() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfFiftyFiftyWrappers());
    }

    @And("Four-across promotional tiles as configured by merch team")
    public void fourAcrossPromotionalTilesAsConfiguredByMerchTeam() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfFourAcrossPromotionalTiles());
    }

    @And("any brand spotlights as configured by merch-media teams")
    public void anyBrandSpotlightsAsConfiguredByMerchMediaTeams() {
        /**
         TODO:
         **/
    }

    @And("PCX informational banner of how PCX works")
    public void pcxInformationalBannerOfHowPCXWorks() {
        /**
         TODO:
         **/
    }

    @And("expandable Terms and Conditions accordion that is collapsed by default")
    public void expandableTermsAndConditionsAccordionThatIsCollapsedByDefault() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfExpandableTermsAndConditions());
    }

    @And("I am logged in AND I have not associated a PCO account with my PCID")
    public void iAmLoggedInANDIHaveNotAssociatedAPCOAccountWithMyPCID() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("CartAccount");
    }

    @And("I am logged in AND I have associated a PCO account with my PCID")
    public void iAmLoggedInANDIHaveAssociatedAPCOAccountWithMyPCID() throws IOException {
        tcs.pom.getNavigation().openLogInPage();
        tcs.pom.getNavigation().logInToAccount("CartAccount");
    }

    @When("I click on the CTA headline promo")
    public void iClickOnTheCTAHeadlinePromo() {
        tcs.pom.getHomePage().iClickOnCTAHeadlinePromo();

    }

    @Then("I will be taken to the associated promotional page")
    public void iWillBeTakenToTheAssociatedPromotionalPage() {
        Assert.assertTrue(tcs.pom.getHomePage().validatePromotionalPage());
    }

    @When("I click on the chevrons on the right or the left of the screen")
    public void iClickOnTheChevronsOnTheRightOrTheLeftOfTheScreen() {
        tcs.pom.getHomePage().iClickOnLeftChevrons();
        tcs.pom.getHomePage().iClickOnRightChevrons();
    }

    @Then("I will be taken to the next or previous page promotion")
    public void iWillBeTakenToTheNextOrPreviousPagePromotion() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfHeadlineBanner());
    }

    @When("I click on any of the dots in the kebab at the bottom of the the headline banner")
    public void iClickOnAnyOfTheDotsInTheKebabAtTheBottomOfTheTheHeadlineBanner() {
        tcs.pom.getHomePage().iClickOnSecondKebabButton();
    }

    @Then("I will be taken to the associated headline promotion that I clicked on")
    public void iWillBeTakenToTheAssociatedHeadlinePromotionThatIClickedOn() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfHeadlineBanner());
    }

    @When("I go to the My Shop information card")
    public void iGoToTheMyShopInformationCard() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfMyShopInformationCard());
    }

    @Then("I will see a preview of images of items in My Shop")
    public void iWillSeeAPreviewOfImagesOfItemsInMyShop() {
        /**
         TODO:
         **/
    }

    @And("I will see a CTA with the number of items in My Shop")
    public void iWillSeeACTAWithTheNumberOfItemsInMyShop() {
        /**
         TODO:
         **/
    }

    @And("clicking the CTA  will take me to Most Purchased tab in My Shop section of site")
    public void clickingTheCTAWillTakeMeToMostPurchasedTabInMyShopSectionOfSite() {
        /**
         TODO:
         **/
    }

    @When("I go to the Flyers and Deals information card")
    public void iGoToTheFlyersAndDealsInformationCard() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfFlyersAndDealsInformationCard());
    }

    @Then("I will see a preview of images of items in the flyer")
    public void iWillSeeAPreviewOfImagesOfItemsInTheFlyer() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfImagesOnFlyersCard());
    }

    @And("I will see a CTA")
    public void iWillSeeACTA() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfFlyersCardCTA());
    }

    @And("clicking the CTA will take me to the Flyer tab in Flyers and Deals section of site")
    public void clickingTheCTAWillTakeMeToTheFlyerTabInFlyersAndDealsSectionOfSite() {
        Assert.assertTrue(tcs.pom.getHomePage().validateFlyersCardCTA());
    }

    @When("I go to the Sign In information card")
    public void iGoToTheSignInInformationCard() {
        tcs.pom.getHomePage().iGoToSignInInformationCard();
    }

    @Then("I will see information on why to sign in")
    public void iWillSeeInformationOnWhyToSignIn() {
        Assert.assertTrue(tcs.pom.getHomePage().iSeeInformationWhyToSignIn());
    }

    @And("a button to sign in to my account")
    public void aButtonToSignInToMyAccount() {
        Assert.assertTrue(tcs.pom.getHomePage().aButtonToSignIn());
    }

    @And("clicking the sign in button will direct me to the sign in page")
    public void clickingTheSignInButtonWillDirectMeToTheSignInPage() {
        String expectedUrl = "https://accounts.pcid.ca/login";
        String actualUrl = tcs.pom.getHomePage().iClickSignIn();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @And("a create account link")
    public void aCreateAccountLink() {
        Assert.assertTrue(tcs.pom.getHomePage().iSeeCreateAccountLink());
    }

    @And("clicking the create account link will direct me to the account creation page")
    public void clickingTheCreateAccountLinkWillDirectMeToTheAccountCreationPage() {
        String expectedUrl = "https://accounts.pcid.ca/create-account";
        String actualUrl = tcs.pom.getHomePage().iClickCreateAccount();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        Assert.assertTrue(tcs.pom.getHomePage().validateHomePage());
    }

    @And("have selected a fulfillment option")
    public void haveSelectedAFulfillmentOption() {
        tcs.pom.getHomePage().iHaveSelectedFulfillmentOption();
    }

    @When("I view the location details information card")
    public void iViewTheLocationDetailsInformationCard() {
        aLocationDetailsForTheOrderInformationCard();
    }

    @Then("I will see the fulfillment option I have selected")
    public void iWillSeeTheFulfillmentOptionIHaveSelected() {
         Assert.assertTrue(tcs.pom.getHomePage().iWillSeeTheFulfillmentSelected());
    }

    @And("the location I am shopping at")
    public void theLocationIAmShoppingAt() {
          iWillSeeTheFulfillmentOptionIHaveSelected();
    }

    @And("the address and store hours for that location")
    public void theAddressAndStoreHoursForThatLocation() {
        Assert.assertTrue(tcs.pom.getHomePage().iSeeFulfillmentTimings());
    }

    @And("have not selected a fulfillment option")
    public void haveNotSelectedAFulfillmentOption() {
        haveSelectedAFulfillmentOption();
        Assert.assertTrue(tcs.pom.getHomePage().iHaveNotSelectedFulfillmentOption());
    }

    @Then("I will see all the fulfillment options available to me \\(Pickup,Delivery, In-Store)")
    public void iWillSeeAllTheFulfillmentOptionsAvailableToMePickupDeliveryInStore() {
        tcs.pom.getHomePage().iSeeAllFulfillmentOptionsAvailableToMe();
    }

    @And("clicking any button will redirect me to an informational page on PCX")
    public void clickingAnyButtonWillRedirectMeToAnInformationalPageOnPCX() {
        tcs.pom.getHomePage().iClickAnyButtonToRedirect();
    }

    @And("I will be asked to confirm my location")
    public void iWillBeAskedToConfirmMyLocation() {
        Assert.assertTrue(tcs.pom.getHeader().iAmToChangeLocationPage());
    }

    @And("have not registered for PCX pass")
    public void haveNotRegisteredForPCXPass() {
        tcs.base.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("I view the PCX pass banner")
    public void iViewThePCXPassBanner() {
        tcs.pom.getHomePage().iAmOnPcxPassBanner();
    }

    @Then("I will see a description of PCX pass")
    public void iWillSeeADescriptionOfPCXPass() {
        Assert.assertTrue(tcs.pom.getHomePage().iSeePcxPassDescription());
    }

    @And("a sign up button")
    public void aSignUpButton() {
        Assert.assertTrue(tcs.pom.getHomePage().iSeeSignUpButton());
    }

    @And("clicking sign up will direct me to the PCX pass registration page")
    public void clickingSignUpWillDirectMeToThePCXPassRegistrationPage() {
        String expectedUrl = "https://accounts.pcid.ca/login";
        String actualUrl = tcs.pom.getHomePage().iClickSignUpButton();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @And("the banner will no longer be on home if I complete by registration for PCX Pass")
    public void theBannerWillNoLongerBeOnHomeIfICompleteByRegistrationForPCXPass() throws IOException {
        tcs.pom.getNavigation().logInToAccount("CartAccount");
    }

    @When("I scroll to the bottom of the page")
    public void iScrollToTheBottomOfThePage() {
        iScrollDownThePage();
    }

    @Then("I will see an informational fifty-fifty wrapper with information on PCX and a welcome offer")
    public void iWillSeeAnInformationalFiftyFiftyWrapperWithInformationOnPCXAndAWelcomeOffer() {
         Assert.assertTrue(tcs.pom.getHomePage().iSeeFiftyAndFiftyPcxBanner());
    }

    @And("the left of the fifty-fifty banner will contain a title, description and Learn more button")
    public void theLeftOfTheFiftyFiftyBannerWillContainATitleDescriptionAndButton() {
         Assert.assertTrue(tcs.pom.getHomePage().theLeftOfBanner());
    }

    @And("the learn more button will direct users to the appropriate page as configured in contentful")
    public void theLearnMoreButtonWillDirectUsersToTheAppropriatePageAsConfiguredInContentful() {
        String expectedUrl = "https://www.loblaws.ca/online-grocery-shopping?icta=click:all-about-pcx:pcx-online-grocery";
        String actualUrl = tcs.pom.getHomePage().iClickOnLearnMore();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @And("the right of the wrapper will contain a promotional image")
    public void theRightOfTheWrapperWillContainAPromotionalImage() {
        Assert.assertTrue(tcs.pom.getHomePage().theRightOfBanner());
    }

    @When("I view the four-across promotional tiles")
    public void iViewTheFourAcrossPromotionalTiles() {
        Assert.assertTrue(tcs.pom.getHomePage().iViewTheFourPromotionalTiles());
    }

    @Then("I will see four side by side containers")
    public void iWillSeeFourSideBySideContainers() {
        Assert.assertTrue(tcs.pom.getHomePage().iSeeFourSideBySideContainers());
    }

    @And("each container will have an image, tile, description and Shop now button")
    public void eachContainerWillHaveAnImageTileDescriptionAndShopNowButton() {
        Assert.assertTrue(tcs.pom.getHomePage().iSeeImageTileDescriptionAndShopNowButton());
    }

    @And("clicking shop now will direct me to the appropriate page for that promotion")
    public void clickingShopNowWillDirectMeToTheAppropriatePageForThatPromotion() {
        String expectedUrl = "https://www.loblaws.ca/collection/summer-insiders-elevating-outdoor-entertaining-snacks?icid=gr_sir-snacks_verticaltile_1_hp";
        String actualUrl = tcs.pom.getHomePage().clickingShopNowWillDirectMeToAppropriatePage();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @When("I view the menu tiles carousel")
    public void iViewTheMenuTilesCarousel() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfMenuTilesCarouselToShopCategories());
    }

    @Then("I will see a list of categories on the site that correspond to LO categories")
    public void iWillSeeAListOfCategoriesOnTheSiteThatCorrespondToLOCategories() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfListOfCategories());
    }

    @And("each category will contain an associated icon")
    public void eachCategoryWillContainAnAssociatedIcon() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfIconForEachCategory());
    }

    @And("clicking on an icon will direct the user to the associated LO")
    public void clickingOnAnIconWillDirectTheUserToTheAssociatedLO() {
        Assert.assertTrue(tcs.pom.getHomePage().validateClickingOnAnIconWillDirect());
    }

    @When("I view the Start Shopping mini product tile carousel")
    public void iViewTheStartShoppingMiniProductTileCarousel() {
        tcs.pom.getHomePage().scrollDownPage();
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfStartShoppingMiniProductTileCarousel());
    }

    @Then("I will see a list of items")
    public void iWillSeeAListOfItems() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfListOfItem());
    }

    @And("the tiles will contain mini product images")
    public void theTilesWillContainMiniProductImages() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfImageForEachItem());
    }

    @And("the product name")
    public void theProductName() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfProductNameForEachItem());
    }

    @And("the products price")
    public void theProductsPrice() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfProductPriceForEachItem());
    }

    @And("any sales information")
    public void anySalesInformation() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfSalesInformation());
    }

    @And("an add to cart button for items not in cart")
    public void anAddToCartButtonForItemsNotInCart() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfAddButton());
    }

    @And("change quantity buttons for items that are in cart")
    public void changeQuantityButtonsForItemsThatAreInCart() {
        tcs.pom.getHomePage().addToCartFirstItemFromStartShoping();
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfchangeQuantityButtons());
    }

    @And("the list of items will be horizontally scrollable")
    public void theListOfItemsWillBeHorizontallyScrollable() {
        Assert.assertTrue(tcs.pom.getHomePage().validateTheListOfItemsWillBeHorizontallyScrollable());
    }

    @When("I view any merchandised product carousels")
    public void iViewAnyMerchandisedProductCarousels() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfProductTileCarousels());
    }

    @Then("I will see a title of a merchandised category")
    public void iWillSeeATitleOfAMerchandisedCategory() {
        /**
         TODO:
         **/
    }


    @When("I view the fifty-fifty wrapper")
    public void iViewTheFiftyFiftyWrapper() {
        tcs.pom.getHomePage().scrollDownPage();
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfFiftyFiftyWrappers());
    }

    @Then("I will see two of the following side-by-side as configured by the merch team")
    public void iWillSeeTwoOfTheFollowingSideBySideAsConfiguredByTheMerchTeam() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfSideBySideAsConfigure());
    }

    @And("A banner with an image, title and description")
    public void aBannerWithAnImageTitleAndDescription() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfBannerWithAnImageTitleAndDescription());
    }

    @And("a product grid with clickable tiles")
    public void aProductGridWithClickableTiles() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfProductGrid());
    }

    @And("a Shop All link that will take me to a hub for that promotion")
    public void aShopAllLinkThatWillTakeMeToAHubForThatPromotion() {
        Assert.assertTrue(tcs.pom.getHomePage().validateVisibilityOfShopAll());
        Assert.assertTrue(tcs.pom.getHomePage().validateShopAllLinkThatWillTakeMeToAHubForThatPromotion());
    }
}
