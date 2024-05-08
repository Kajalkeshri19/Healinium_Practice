package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

public class PLPStepDefinition {
    
    TestContextSetup tcs;

    public PLPStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }
    
    @Given("I am on a PLP")
    public void iAmOnAPLP() {
      Assert.assertTrue(tcs.pom.getPLP().iAmOnAPLP());
    }

    @When("Page loads")
    public void pageLoads() {
        // Do nothing
    }

    @Then("I will see a grid of all the products")
    public void iWillSeeAGridOfAllTheProducts() {
      Assert.assertTrue(tcs.pom.getPLP().iSeeGridOfAllProducts());
    }

    @And("the page will display a page name")
    public void thePageWillDisplayAPageName() {
        String expectedName = "Fruits & Vegetables";
        String actualName = tcs.pom.getPLP().getPageName();
        Assert.assertEquals(actualName, expectedName);
    }

    @And("filters will be available on left of page")
    public void filtersWillBeAvailableOnLeftOfPage() {
       Assert.assertTrue(tcs.pom.getPLP().iSeeFilterList());
    }

    @And("quick filters for Deals | Our Brands | Dietary will display above results \\(if applicable)")
    public void quickFiltersForDealsOurBrandsDietaryWillDisplayAboveResultsIfApplicable() {
       Assert.assertFalse(tcs.pom.getPLP().iSeeQuickFilters());
    }

    @And("sort filter will be on page, default by Relevance")
    public void sortFilterWillBeOnPageDefaultByRelevance() {
        Assert.assertTrue(tcs.pom.getPLP().iSeeSortByAndDefaultByRelevance());
    }

    @And("media ad units will be displayed at top of page and below filters")
    public void mediaAdUnitsWillBeDisplayedAtTopOfPageAndBelowFilters() {
        Assert.assertTrue(tcs.pom.getPLP().iSeeMediaUnits());
    }

    @And("PCX Pass subscription banner will display above my result")
    public void pcxPassSubscriptionBannerWillDisplayAboveMyResult() {
       Assert.assertTrue(tcs.pom.getPLP().iSeePCXPass());
    }

    @And("sponsored items will be displayed at the top of the page \\(if applicable)")
    public void sponsoredItemsWillBeDisplayedAtTheTopOfThePageIfApplicable() {
        //Not applicable
    }

    @And("You May Also Like column will be displayed on right of screen \\(if applicable)")
    public void youMayAlsoLikeColumnWillBeDisplayedOnRightOfScreenIfApplicable() {
         //Not applicable
    }

    @And("page has loaded")
    public void pageHasLoaded() {
        // DO nothing
    }

    @When("I click on filter on the left of the page")
    public void iClickOnFilterOnTheLeftOfThePage() {
        tcs.pom.getPLP().iClickOnFilterOnLeftPage();
    }

    @And("selected filters will display below quick filters")
    public void selectedFiltersWillDisplayBelowQuickFilters() {
        Assert.assertTrue(tcs.pom.getPLP().iSeeSelectedfilters());
    }

    @And("all other behaviour from PLP apply")
    public void allOtherBehaviourFromPLPApply() {
       tcs.pom.getPLP().allOtherBehaviourOnPLP();
    }

    @And("have selected a filter")
    public void haveSelectedAFilter() {
       tcs.pom.getPLP().iClickOnFilterOnLeftPage();
    }

    @When("I click on any of the x buttons next to the filter at the top of page")
    public void iClickOnAnyOfTheButtonsNextToTheFilterAtTopOfPage() {
        tcs.pom.getPLP().selectOneMoreFilter();
    }

    @Then("Filter will be removed")
    public void filterWillBeRemoved() {
        Assert.assertTrue(tcs.pom.getPLP().removeFilterAndValidateCount());
    }

    @And("I will remain on PLP")
    public void iWillRemainOnPLP() {
        Assert.assertTrue(tcs.pom.getPLP().validatePageName("Fruits & Vegetables"));
    }

    @And("all other filters I've selected will still be applied")
    public void allOtherFiltersIVeSelectedWillStillBeApplied() {
        Assert.assertTrue(tcs.pom.getPLP().iCanSeeOtherFiltersApplied());
    }
}
