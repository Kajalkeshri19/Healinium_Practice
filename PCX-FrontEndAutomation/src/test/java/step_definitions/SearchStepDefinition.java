package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;


public class SearchStepDefinition {

    TestContextSetup tcs;

    public SearchStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I am on any page with search AND have never completed a search")
    public void iAmOnAnyPageWithSearchANDHaveNeverCompletedASearch() {
        tcs.pom.getSearchPage().clickOnSearchField();
    }

    @When("I click on search bar")
    public void iClickOnSearchBar() {
        // Do nothing
    }

    @Then("Top Searches are recommended")
    public void topSearchesAreRecommended() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateReleatedSearch());
    }

    @Given("I have entered a search term in the search box")
    public void iHaveEnteredASearchTermInTheSearchBox() {
        tcs.pom.getSearchPage().searchTheProduct("Milk");
    }

    @When("I hit enter for search")
    public void iHitEnterForSearch() {
        // Do nothing
    }

    @Then("I should see a search grid with three items across")
    public void iShouldSeeASearchGridWithThreeItemsAcross() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateTheSearchGrid());
    }

    @Then("I should see my search term on the top left")
    public void iShouldSeeMySearchTermOnTheTopLeft() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateSearchTermOnTopLeft());
    }

    @Given("I am on any page with search")
    public void iAmOnAnyPageWithSearch() {
        tcs.pom.getSearchPage().checkForRecommendedSearch("Yog");
    }

    @When("I click on search bar AND type in a character")
    public void iClickOnSearchBarANDTypeInACharacter() {
        // Do nothing
    }

    @Then("Recommended searches will be displayed \\(if applicable)")
    public void recommendedSearchesWillBeDisplayedIfApplicable() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateReleatedSearch());
    }

    @Given("I have typed in a search query")
    public void iHaveTypedInASearchQuery() {
        tcs.pom.getSearchPage().searchTheProduct("Milk");
    }

    @When("I click enter AND results exist")
    public void iClickEnterANDResultsExist() {
        // Do nothing
    }

    @Then("I will be taken to a product grid with my search results")
    public void iWillBeTakenToAProductGridWithMySearchResults() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateProductGrid());
    }

    @And("the page will display my search term and total no of results")
    public void thePageWillDisplayMySearchTermAndTotalNoOfResults() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateSearchTermAndResult());
    }

    @And("aisles and filters will be available on left of page")
    public void aislesAndFiltersWillBeAvailableOnLeftOfPage() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateAislesAndFilter());
    }

    @And("sort filter will be on page, defaulted by Relevance")
    public void sortFilterWillBeOnPageDefaultedByRelevance() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateSortedResultContain("Relevance"));
    }

    @And("PCX Pass subscription banner will display above my results")
    public void pcxPassSubscriptionBannerWillDisplayAboveMyResults() {
        Assert.assertTrue(tcs.pom.getSearchPage().validatePcxBanner());
    }

    @Given("I have typed in a search query having no Result")
    public void iHaveTypedInASearchQueryHavingNoResult() {
        tcs.pom.getSearchPage().searchTheProduct("dbehde");
    }

    @When("I click enter AND results do not exist")
    public void iClickEnterANDResultsDoNotExist() {
          // Do nothing
    }


    @Then("I will be taken to a No Results page and error message will be displayed")
    public void iWillBeTakenToANoResultsPageAndErrorMessageWillBeDisplayed() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateNoResult());

    }

    @And("categories will be displayed below error message")
    public void categoriesWillBeDisplayedBelowErrorMessage() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateCategoriesDisplayed());
    }

    @Given("I am on any page with search AND have previously attempted a search")
    public void iAmOnAnyPageWithSearchANDHavePreviouslyAttemptedASearch() {
        tcs.pom.getSearchPage().searchTheProduct("Milk");
        tcs.pom.getSearchPage().clickOnSearchField();
    }

    @Then("Last five searches are recommended above Top Searches")
    public void lastFiveSearchesAreRecommendedAboveTopSearches() {
        Assert.assertTrue(tcs.pom.getSearchPage().validatePreviousSearch());
    }

    @Given("I have completed a search AND I have results AND I have selected a filter")
    public void iHaveCompletedASearchANDIHaveResultsANDIHaveSelectedAFilter() {
        tcs.pom.getSearchPage().searchTheProduct("Milk");
        Assert.assertTrue(tcs.pom.getSearchPage().validateTheSearchGrid());
        tcs.pom.getSearchPage().selectFilter();
    }

    @When("I click on any of the x buttons next to the filter at top of page")
    public void iClickOnAnyOfTheXButtonsNextToTheFilterAtTopOfPage() {
        tcs.pom.getSearchPage().closeFirstFilterOption();
    }

    @Then("Filter will be removed AND I will remain on Search Results that match my query and any other filters I have selected")
    public void filterWillBeRemovedANDIWillRemainOnSearchResultsThatMatchMyQueryAndAnyOtherFiltersIHaveSelected() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateTheSearchGrid());
        Assert.assertTrue(tcs.pom.getSearchPage().validateRemainFilterOption());
    }

    @When("II click on clear all at top of page")
    public void iiClickOnClearAllAtTopOfPage() {
        tcs.pom.getSearchPage().clickOnClearAllFilter();
    }

    @Then("All Filters will be removed")
    public void allFiltersWillBeRemoved() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateAllFiltersRemove());
    }

    @And("I will remain on Search Results that match my query and any aisles I've selected")
    public void iWillRemainOnSearchResultsThatMatchMyQueryAndAnyAislesIVeSelected() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateTheSearchGrid());
    }

    @Given("I have completed a search AND I have results")
    public void iHaveCompletedASearchANDIHaveResults() {
        tcs.pom.getSearchPage().searchTheProduct("Milk");
        Assert.assertTrue(tcs.pom.getSearchPage().validateTheSearchGrid());
    }

    @When("I click on Sort By dropdown AND select a new value")
    public void iClickOnSortByDropdownANDSelectANewValue() {
        tcs.pom.getSearchPage().clickOnSortByAndSelectFirstOption();
    }

    @Then("I will remain on my search results")
    public void iWillRemainOnMySearchResults() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateTheSearchGrid());
    }

    @And("my results will now be sorted by the new sort selection")
    public void myResultsWillNowBeSortedByTheNewSortSelection() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateSortedResultContain("Price (Low to High)"));
    }

    @When("I click enter AND a CLP is mapped to my results")
    public void iClickEnterANDACLPIsMappedToMyResults() {
        //Do nothing
    }

    @Then("I will be taken the appropriate CLP")
    public void iWillBeTakenTheAppropriateCLP() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateProductGrid());
    }

    @And("the page will display my search term")
    public void thePageWillDisplayMySearchTerm() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateSearchTermAndResult());
    }

    @And("the page will display total number of results")
    public void thePageWillDisplayTotalNumberOfResults() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateTotalNumberOfResult());
    }

    @And("aisles will be available on left of page")
    public void aislesWillBeAvailableOnLeftOfPage() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateAislesAndFilter());
    }

    @And("filters will be available on left of page1")
    public void filtersWillBeAvailableOnLeftOfPage1() {
        //validate in just above
    }

    @And("quick filters for Deals | Our Brands | Dietary will display above results \\(if applicable)1")
    public void quickFiltersForDealsOurBrandsDietaryWillDisplayAboveResultsIfApplicable1() {
        Assert.assertTrue(tcs.pom.getSearchPage().validateQuickFilter());
    }

    @And("media ad units will be displayed at top of page and below filters1")
    public void mediaAdUnitsWillBeDisplayedAtTopOfPageAndBelowFilters1() {
        /**
         TODO:
         **/
    }
}