package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

public class SRPStepDefination {
    TestContextSetup tcs;

    public SRPStepDefination(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I want to conduct a search on Rapid")
    public void iWantToConductASearchOnRapid() {
        Assert.assertTrue(tcs.pom.getSRP().validateVisibilityOfSignInButton());
    }

    @When("I click into the search bar and begin typing")
    public void iClickIntoTheSearchBarAndBeginTyping() {
        tcs.pom.getSRP().clickOnSearchField();
        tcs.pom.getSRP().checkForRecommendedSearchType("M");
    }

    @Then("I shoud see suggested results underneath the search bar")
    public void iShoudSeeSuggestedResultsUnderneathTheSearchBar() {
        Assert.assertTrue(tcs.pom.getSRP().validateRecommendedSearch());
    }

    @When("I click into the search bar, type a keyword and press enter")
    public void iClickIntoTheSearchBarTypeAKeywordAndPressEnter() {
        tcs.pom.getSRP().searchAProduct("Cheese");

    }

    @Then("if there are results: I should see the SRP with related results")
    public void ifThereAreResultsIShouldSeeTheSRPWithRelatedResults() {
        Assert.assertTrue(tcs.pom.getSRP().validateSearchTermAndResult());
    }

    @Given("I am on a Rapid pdp")
    public void iAmOnARapidPDP() {
        Assert.assertTrue(tcs.pom.getSRP().validateVisibilityOfSignInButton());
    }

    @When("I click into the search bar, type a keyword\\(no result) and press enter")
    public void iClickIntoTheSearchBarTypeAKeywordNoResultAndPressEnter() {
        tcs.pom.getSRP().searchAProduct("klajflksdajfdskfjsdklfjdslkjfksdjfkds");

    }

    @Then("if there are no results: I should see the message We were unable to find results for xx")
    public void ifThereAreNoResultsIShouldSeeTheMessageWeWereUnableToFindResultsForXx() {
        Assert.assertTrue(tcs.pom.getSRP().validateForNoResult());
    }


    @Given("I am on any page with search AND have never completed search")
    public void iAmOnAnyPageWithSearchANDHaveNeverCompletedSearch() {
        Assert.assertTrue(tcs.pom.getSRP().validateVisibilityOfSignInButton());
    }

    @When("I clicked on search bar")
    public void iClickedOnSearchBar() {
        tcs.pom.getSRP().clickOnSearchField();
    }

    @Then("Top Searches are recommended me")
    public void topSearchesAreRecommendedMe() {
        Assert.assertTrue(tcs.pom.getSRP().validateRecommendedSearch());
    }

    @Given("I am on any page with search AND have previously attempted search")
    public void iAmOnAnyPageWithSearchANDHavePreviouslyAttemptedSearch() {
        Assert.assertTrue(tcs.pom.getSRP().validateVisibilityOfSignInButton());
        tcs.pom.getSRP().searchAProduct("Cheese");
        tcs.pom.getSRP().searchAProduct("Milk");
        tcs.pom.getSRP().searchAProduct("Eggs");
        tcs.pom.getSRP().searchAProduct("Bread");
        tcs.pom.getSRP().searchAProduct("Yogurt");
    }

    @When("I click into search bar")
    public void iClickIntoSearchBar() {
        tcs.pom.getSRP().clickOrClearSearchField();
    }


    @Then("Last Five searches are recommended above Top Searches")
    public void lastFiveSearchesAreRecommendedAboveTopSearches() {
        Assert.assertTrue(tcs.pom.getSRP().validateRecommendedSearch());
    }

    @Given("I am on any page with search bar")
    public void iAmOnAnyPageWithSearchBar() {
        Assert.assertTrue(tcs.pom.getSRP().validateVisibilityOfSearchBar());
    }

    @When("I click on search bar and type in a character")
    public void iClickOnSearchBarAndTypeInACharacter() {
        tcs.pom.getSRP().checkForRecommendedSearchType("M");
    }

    @Then("Recommended searches will be display \\(if applicable)")
    public void recommendedSearchesWillBeDisplayIfApplicable() {
        Assert.assertTrue(tcs.pom.getSRP().validateRecommendedSearch());
    }
    @And("filters will be available on left of Page")
    public void filtersWillBeAvailableOnLeftOfPage() {
        Assert.assertTrue(tcs.pom.getSRP().iSeeQuickFilters());
    }

    @And("quick filters for Deals | Our Brands | Dietary will display above results\\(if applicable)")
    public void quickFiltersForDealsOurBrandsDietaryWillDisplayAboveResultsIfApplicable() {
        Assert.assertTrue(tcs.pom.getSRP().iSeeQuickFilters());
    }

    @Given("I have completed a search And I have results")
    public void iHaveCompletedASearchAndIHaveResults() {
        Assert.assertTrue(tcs.pom.getSRP().validateVisibilityOfSignInButton());
        tcs.pom.getSRP().searchAProduct("Cheese");
        Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());

    }

    @When("I click on Filter on the left of the Page")
    public void iClickOnFilterOnTheLeftOfThePage() {
        Assert.assertTrue(tcs.pom.getSRP().iSeeQuickFilters());
        tcs.pom.getSRP().clickOnFirstFilterOption();
    }

    @Then("I will see the number of items from my search that fit into that filter")
    public void iWillSeeTheNumberOfItemsFromMySearchThatFitIntoThatFilter() {
        Assert.assertTrue(tcs.pom.getSRP().validateNumberOfProducts());
        Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
    }

    @And("selected filters will display below quick filter")
    public void selectedFiltersWillDisplayBelowQuickFilter() {
        Assert.assertTrue(tcs.pom.getSRP().validateVisibilitySubFilter());
    }

    @And("all other behaviour from Search Results apply")
    public void allOtherBehaviourFromSearchResultsApply() {
        tcs.pom.getSRP().allOtherBehaviourOnSrp();
    }

    @When("I click on aisle on the left of the page")
    public void iClickOnAisleOnTheLeftOfThePage() {
        tcs.pom.getSRP().clickOnAisle();
    }

    @Then("I will see the number of items from my search that fit into that aisle")
    public void iWillSeeTheNumberOfItemsFromMySearchThatFitIntoThatAisle() {
        Assert.assertTrue(tcs.pom.getSRP().validateVisibilityOfAisleItem());
    }

    @When("I click on quick filter on top of the page")
    public void iClickOnQuickFilterOnTopOfThePage() {
        tcs.pom.getSRP().selectFirstQuickFilter();
    }

    @Then("I will see the number of items from my search that fit into that quick filter")
    public void iWillSeeTheNumberOfItemsFromMySearchThatFitIntoThatQuickFilter() {
        Assert.assertTrue(tcs.pom.getSRP().validateProductGrid());
    }

    @And("I will see the selected")
    public void iWillSeeTheSelected() {
        Assert.assertTrue(tcs.pom.getSRP().validateVisibilitySelectedFilter());
    }

}
