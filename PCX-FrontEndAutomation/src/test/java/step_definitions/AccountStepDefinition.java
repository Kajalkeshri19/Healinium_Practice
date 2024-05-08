package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

import java.util.Random;

public class AccountStepDefinition {

    TestContextSetup tcs;

    public AccountStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    public static String getRandomNumberString(int bound) {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(bound);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
    String num=getRandomNumberString(999999);

    @Given("I have created a PCID AND have not used PCX in the past")
    public void iHaveCreatedAPCIDANDHaveNotUsedPCXInThePast() {
        Assert.assertTrue(tcs.pom.getAccount().validateVisibilityOfSignInButton());
        tcs.pom.getAccount().createNewPCID("pcxprod1409@yopmail.com", "Loblaw@Testing");
        tcs.pom.getAccount().signOutAfterCreateAccount();
    }

    @When("I login to PCX for the first time")
    public void iLoginToPCXForTheFirstTime() {
        tcs.pom.getAccount().loginWithCreatedId("pcxprod1409@yopmail.com", "Loblaw@Testing");
    }

    @Then("my PCX profile should be created by CDS and associated with my PCID account")
    public void myPCXProfileShouldBeCreatedByCDSAndAssociatedWithMyPCIDAccount() {
        tcs.pom.getAccount().viewProfile();
        Assert.assertTrue(tcs.pom.getAccount().validateMyAccountAssociatedWithPCID());
        tcs.pom.getAccount().deleteAccount("pcxprod1409@yopmail.com", "Loblaw@Testing");
        Assert.assertTrue(tcs.pom.getAccount().deleteAccountConfirmationMessage());
    }

    @Given("I have deleted my account on LOB X and the process is NOT completed")
    public void iHaveDeletedMyAccountOnLOBXAndTheProcessIsNOTCompleted() {
        tcs.pom.getAccount().createNewPCID("pcxprod1409@yopmail.com", "Loblaw@Testing");
        tcs.pom.getAccount().viewProfile();
        tcs.pom.getAccount().deleteAccount("pcxprod1409@yopmail.com", "Loblaw@Testing");
        Assert.assertTrue(tcs.pom.getAccount().deleteAccountConfirmationMessage());
    }

    @When("i try to login on LOB X with same PCID email address")
    public void iTryToLoginOnLOBXWithSamePCIDEmailAddress() {
        tcs.pom.getAccount().loginWithCreatedId("pcxprod1409@yopmail.com", "Loblaw@Testing");
    }

    @Then("the account is marked for deletion")
    public void theAccountIsMarkedForDeletion() {
//      Your Marketplace account is in the process of being deleted and may take up to 45 days.
    }

    @And("an email is sent to customer And an email is sent to Privacy")
    public void anEmailIsSentToCustomerAndAnEmailIsSentToPrivacy() {
     /*
       ToDo
     */
    }

    @And("i cannot login to that LOB using the same PCID credentials")
    public void iCannotLoginToThatLOBUsingTheSamePCIDCredentials() {
     /*
       ToDo
     */
    }

    @And("i am logged out of all devices where i am logged in Detailed process")
    public void iAmLoggedOutOfAllDevicesWhereIAmLoggedInDetailedProcess() {
      /*
       ToDo
     */
    }

    @Given("i have deleted my account on PCX \\(irrespective of whether the process is completed or NOT)")
    public void iHaveDeletedMyAccountOnPCXIrrespectiveOfWhetherTheProcessIsCompletedOrNOT() {
        tcs.pom.getAccount().createNewPCID("pcxprod1409@yopmail.com", "Loblaw@Testing");
        tcs.pom.getAccount().viewProfile();
        tcs.pom.getAccount().deleteAccount("pcxprod1409@yopmail.com", "Loblaw@Testing");
        Assert.assertTrue(tcs.pom.getAccount().deleteAccountConfirmationMessage());
    }

    @When("i login to another LOB Y")
    public void iLoginToAnotherLOBY() {
        tcs.pom.getAccount().loginWithCreatedId("pcxprod1409@yopmail.com", "Loblaw@Testing");
    }

    @Then("i am able to login as usual into LOB Y")
    public void iAmAbleToLoginAsUsualIntoLOBY() {
        Assert.assertTrue(tcs.pom.getAccount().validateVisibilityOfProfilePage());
    }

    @Given("i have added information on a LOB which is stored in Hybris AND customer is successfully migrated to the new platform")
    public void iHaveAddedInformationOnALOBWhichIsStoredInHybrisANDCustomerIsSuccessfullyMigratedToTheNewPlatform() {
        tcs.pom.getAccount().createNewPCID("pcxprod1409@yopmail.com", "Loblaw@Testing");
        tcs.pom.getAccount().addAllInformation();
        tcs.pom.getAccount().signOutAfterCreateAccount();
    }

    @When("i log in to the LOB")
    public void iLogInToTheLOB() {
        tcs.pom.getAccount().loginWithCreatedId("pcxprod1409@yopmail.com", "Loblaw@Testing");
    }

    @Then("I can see my previously stored info : All the details mentioned in the above View cases")
    public void iCanSeeMyPreviouslyStoredInfoAllTheDetailsMentionedInTheAboveViewCases() {
        Assert.assertTrue(tcs.pom.getAccount().validateAllDetail("pcxprod1409@yopmail.com"));
        tcs.pom.getAccount().deleteAccount("pcxprod1409@yopmail.com", "Loblaw@Testing");
        Assert.assertTrue(tcs.pom.getAccount().deleteAccountConfirmationMessage());
    }

    @Given("my information is moved to the new platform AND LD does a rollback")
    public void myInformationIsMovedToTheNewPlatformANDLDDoesARollback() {
        tcs.pom.getAccount().createNewPCID("pcxprod1409@yopmail.com", "Loblaw@Testing");
        tcs.pom.getAccount().addAllInformation();
        tcs.pom.getAccount().signOutAfterCreateAccount();
    }

    @Then("i can see my latest stored info : All the details mentioned in the above View cases")
    public void iCanSeeMyLatestStoredInfoAllTheDetailsMentionedInTheAboveViewCases() {
        Assert.assertTrue(tcs.pom.getAccount().validateAllDetail("pcxprod1409@yopmail.com"));
        tcs.pom.getAccount().deleteAccount("pcxprod1409@yopmail.com", "Loblaw@Testing");
        Assert.assertTrue(tcs.pom.getAccount().deleteAccountConfirmationMessage());
    }

    @Given("I'm a logged in PCX user")
    public void iMALoggedInPCXUser() {
        //tcs.pom.getCheckout().signIn("pcxprodemptycart@yopmail.com", "Loblaw@Testing");
    }

    @When("I navigate to My Account > Payment")
    public void iNavigateToMyAccountPayment() {
        tcs.pom.getAccount().navigateToPayment();
    }


    @Then("I should see my saved card details \\(visa mastercard, last {int} digits, and primary tag). My Primary card should appear on top.")
    public void iShouldSeeMySavedCardDetailsVisaMastercardLastDigitsAndPrimaryTagMyPrimaryCardShouldAppearOnTop(int arg0) {
        Assert.assertTrue(tcs.pom.getAccount().validateSavedCardDetails());
    }

    @Then("I should be able to add a card")
    public void iShouldBeAbleToAddACard() {
        Assert.assertTrue(tcs.pom.getAccount().addACard());
    }

    @And("enter billing address details")
    public void enterBillingAddressDetails() {
        Assert.assertTrue(tcs.pom.getCheckout().addNewBillingAddress());

    }

    @And("add credit card details")
    public void addCreditCardDetails() {
        tcs.pom.getCheckout().addNewCard("4263970000005262", "08/29", "400", "Test Account");
    }

    @And("designate the card as my primary card")
    public void designateTheCardAsMyPrimaryCard() {
        Assert.assertTrue(tcs.pom.getAccount().cardAsPrimaryCard());
    }

    @And("save the new card to my account")
    public void saveTheNewCardToMyAccount() {
        Assert.assertTrue(tcs.pom.getAccount().saveTheCard());
    }

    @When("I navigate to My Account > Payment and add a new primary card")
    public void iNavigateToMyAccountPaymentAndAddANewPrimaryCard() {
        tcs.pom.getAccount().navigateToPayment();
    }

    @And("add a new primary card")
    public void addANewPrimaryCard() {
        Assert.assertTrue(tcs.pom.getAccount().addACard());
        Assert.assertTrue(tcs.pom.getCheckout().addNewBillingAddress());
        tcs.pom.getCheckout().addNewCard("4263970000005262", "08/29", "400", "Test Account");
        Assert.assertTrue(tcs.pom.getAccount().cardAsPrimaryCard());
        Assert.assertTrue(tcs.pom.getAccount().saveTheCard());
    }

    @Then("My new card should become primary and should appear on top. I should see this card as primary on checkout page as well.")
    public void myNewCardShouldBecomePrimaryAndShouldAppearOnTopIShouldSeeThisCardAsPrimaryOnCheckoutPageAsWell() {
        Assert.assertTrue(tcs.pom.getAccount().validatePrimaryCardDetails());

    }

    @Given("I'm a logged in PCX user and I have already added a card to my account")
    public void iMALoggedInPCXUserAndIHaveAlreadyAddedACardToMyAccount() {
        //tcs.pom.getCheckout().signIn("pcxprodemptycart@yopmail.com", "Loblaw@Testing");
        Assert.assertTrue(tcs.pom.getAccount().addACard());
        Assert.assertTrue(tcs.pom.getCheckout().addNewBillingAddress());
        tcs.pom.getCheckout().addNewCard("4263970000005262", "08/29", "400", "Test Account");
        Assert.assertTrue(tcs.pom.getAccount().cardAsPrimaryCard());
        Assert.assertTrue(tcs.pom.getAccount().saveTheCard());
    }

    @Then("I should see all previously added cards with the card type, and last {int} digits on the card")
    public void iShouldSeeAllPreviouslyAddedCardsWithTheCardTypeAndLastDigitsOnTheCard(int arg0) {
        Assert.assertTrue(tcs.pom.getAccount().validateSavedCardDetails());
    }

    @And("be able to remove the card by clicking Remove. On clicking Remove, I should be asked for a confirmation.")
    public void beAbleToRemoveTheCardByClickingRemoveOnClickingRemoveIShouldBeAskedForAConfirmation() {
        Assert.assertTrue(tcs.pom.getAccount().removeSavedCard());
    }

    @Then("I should see all previously added cards except for the deleted card and none of the cards should be marked as primary")
    public void iShouldSeeAllPreviouslyAddedCardsExceptForTheDeletedCardAndNoneOfTheCardsShouldBeMarkedAsPrimary() {
        Assert.assertTrue(tcs.pom.getAccount().removePrimaryCard());
    }

    @Given("I’m a logged in using PC ID and I don’t have an existing PC Optimum account")
    public void iMALoggedInUsingPCIDAndIDonTHaveAnExistingPCOptimumAccount() {
        //tcs.pom.getCheckout().signIn("pcxprodemptycart@yopmail.com", "Loblaw@Testing");
    }

    @When("I go to PC Optimum section on web")
    public void iGoToPCOptimumSectionOnWeb() {
        tcs.pom.getAccount().goToPCOptimum();
    }

    @Then("I’m presented with an option to enroll for PC Optimum")
    public void iMPresentedWithAnOptionToEnrollForPCOptimum() {
        Assert.assertTrue(tcs.pom.getAccount().validateTheJoinLinkOnPCO());
    }

    @Given("I'm a logged in user who has a PCO, PCOI account")
    public void iMALoggedInUserWhoHasAPCOPCOIAccount() {
       // tcs.pom.getCheckout().signIn("pcxprodemptycart@yopmail.com", "Loblaw@Testing");
    }

    @When("I log into my account->PC Optimum")
    public void iLogIntoMyAccountPCOptimum() {
       // tcs.pom.getCheckout().signIn("pcxprodemptycart@yopmail.com", "Loblaw@Testing");
    }

    @Then("I can see my PCO or PCOI points balance and account information \\(first name, last name and email address)")
    public void iCanSeeMyPCOOrPCOIPointsBalanceAndAccountInformationFirstNameLastNameAndEmailAddress() {
        Assert.assertTrue(tcs.pom.getAccount().validateTheInformationOnPCOPage());
    }

    @And("go to pcoptimum.ca")
    public void goToPcoptimumCa() {
        Assert.assertTrue(tcs.pom.getAccount().goToPcOptimumCa());
    }

    @Given("I'm a logged in PCX user AND I do not have a PCO account linked to my PCID")
    public void iMALoggedInPCXUserANDIDoNotHaveAPCOAccountLinkedToMyPCID() {
       // tcs.pom.getCheckout().signIn("pcxprodemptycart@yopmail.com", "Loblaw@Testing");
    }

    @When("I navigate to My Account > PC Optimum")
    public void iNavigateToMyAccountPCOptimum() {
        tcs.pom.getAccount().goToPCOptimum();

    }

    @Then("I will be able to register for a new account by consenting to receiving electronic messages, agreeing to the Terms & Conditions and clicking Continue")
    public void iWillBeAbleToRegisterForANewAccountByConsentingToReceivingElectronicMessagesAgreeingToTheTermsConditionsAndClickingContinue() {
        Assert.assertTrue(tcs.pom.getAccount().goToPcOptimumCa());
        Assert.assertTrue(tcs.pom.getAccount().registerNewAccount());
    }

    @Given("As a logged in PCX user")
    public void asALoggedInPCXUser() {

        //tcs.pom.getCheckout().signIn("pcxprodemptycart@yopmail.com", "Loblaw@Testing");
    }

    @When("i go to my order summary")
    public void iGoToMyOrderSummary() {
        tcs.pom.getPLP().selectFreshFruits();
        tcs.pom.getPLP().addAnItemViaCLP();
        tcs.pom.getCart().openMiniCartFlyer();
        tcs.pom.getCart().visitCart();
        Assert.assertTrue(tcs.commonUtility.validateElementVisibility(tcs.pom.getCart().cartItemName));
    }

    @Then("i want to view  billing information I have provided on my order , so that I can confirm that payment is made to the correct card")
    public void iWantToViewBillingInformationIHaveProvidedOnMyOrderSoThatICanConfirmThatPaymentIsMadeToTheCorrectCard() {
        Assert.assertTrue(tcs.pom.getAccount().validateBillingInfo());
    }

    @Given("I am on the Sign in Page")
    public void goToSignInPage(){
        tcs.pom.getAccount().onSignInPage();
    }
    @When("I click on the Create a PCid button and create PCID account")
    public void clickOnPCIDButton(){
//        tcs.pom.getAccount().createNewPCID("testloblaws777@yopmail.com","Testing@1234");
        tcs.pom.getAccount().createPCIDAccount("testloblaws"+num+"@yopmail.com","Testing@1234");
        tcs.pom.getAccount().competeProfile("testloblaws"+num+"@yopmail.com","Testing@1234");
    }

    @Then("I can login to PCX using my credentials once created")
    public void signInUsingCreatedCredentials(){
        //tcs.pom.getCheckout().signIn("testloblaws"+num+"@yopmail.com", "Testing@1234");
    }
}
