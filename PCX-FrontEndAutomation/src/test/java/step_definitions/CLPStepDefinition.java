package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

public class CLPStepDefinition {
    TestContextSetup tcs;
    public CLPStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I am on a CLP")
    public void iAmOnACLP() {
       tcs.pom.getCLP().navigateOnCarouselClp();
    }

    @When("Page loading")
    public void pageLoading() {
        Assert.assertFalse(tcs.pom.getCLP().validateClpPage());
    }
    @Then("I will see carousels for different categories stacked on the page")
    public void iWillSeeCarouselsForDifferentCategoriesStackedOnThePage() {
        Assert.assertTrue(tcs.pom.getCLP().validateCarousels());
    }

    @And("each carousel will include a Shop all button")
    public void eachCarouselWillIncludeAShopAllButton() {
        Assert.assertTrue(tcs.pom.getCLP().validateEachCarouselIncludeShopAll());
    }

    @And("each carousel can scroll horizontally")
    public void eachCarouselCanScrollHorizontally() {
        Assert.assertTrue(tcs.pom.getCLP().validateEachCarouselScrollHorizontally());
    }

    @And("each item in the grid will include a + button to add to cart")
    public void eachItemInTheGridWillIncludeAButtonToAddToCart() {
        Assert.assertTrue(tcs.pom.getCLP().validateVisibilityOfAddOnEachProduct());
    }

    @And("all cards will show all applicable information \\(to be covered in separate use case)")
    public void allCardsWillShowAllApplicableInformationToBeCoveredInSeparateUseCase() {
        Assert.assertTrue(tcs.pom.getCLP().validateVisibilityOfEachProductDetail());
    }

    @And("the page will display a page names")
    public void thePageWillDisplayAPageNames() {
        Assert.assertTrue(tcs.pom.getCLP().validateVisibilityOfPageName());
    }

    @And("the page will include a breadcrumb of where I am on the browse experience")
    public void thePageWillIncludeABreadcrumbOfWhereIAmOnTheBrowseExperience() {
//        No such breadcrumb included on the page, There is sub-categorise and the breadcrumb found when we go for any specific categories.
//        Assert.assertTrue(tcs.pom.getCLP().validateVisibilityOfBreadcrumb());
    }

    @And("sub-categories will display on left of page")
    public void subCategoriesWillDisplayOnLeftOfPage() {
        Assert.assertTrue(tcs.pom.getCLP().validateVisibilityOfSubCategories());
    }

    @And("media ad units will be displayed at top of page and on left of page")
    public void mediaAdUnitsWillBeDisplayedAtTopOfPageAndOnLeftOfPage() {
        /**
         TODO:
         **/
    }

    @And("sponsored carousel will be displayed at the top of the page \\(if applicable)")
    public void sponsoredCarouselWillBeDisplayedAtTheTopOfThePageIfApplicable() {
        //Not applicable
    }
    
    @When("I click on Shop all for a category")
    public void iClickOnShopAllForACategory() {
        tcs.pom.getCLP().clickOnShopAll();
    }

    @Then("I will see taken to the corresponding PLP")
    public void iWillSeeTakenToTheCorrespondingPLP() {
        Assert.assertTrue(tcs.pom.getCLP().validatePLP());
    }

    @When("I click on one of the sub-categories on left of page")
    public void iClickOnOneOfTheSubCategoriesOnLeftOfPage() {
        tcs.pom.getCLP().clickOnFirstSubCategories();
    }
}
