package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    SearchPage searchPage;
    RapidPage rapidPage;
    LoginPage loginPage;
    FooterPage footerPage;
    Navigation navigation;
    PLP plp;
    CLP clp;
    SRP srp;
    ProductTile productTile;
    PDP pdp;
    Header header;
    ServicesPage servicesPage;
    HomePage homePage;

    Flyers flyers;

    MyShop myShop;
    ExpressPass expressPass;

    FindALocation findALocation;
    Account account;
    Cart cart;
    Checkout checkout;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public SearchPage getSearchPage() {
        searchPage = new SearchPage(driver);
        return searchPage;
    }

    public FooterPage getFooterPage() {
        footerPage = new FooterPage(driver);
        return footerPage;
    }

    public Navigation getNavigation() {
        navigation = new Navigation(driver);
        return navigation;
    }

    public PLP getPLP() {
        plp = new PLP(driver);
        return plp;
    }

    public CLP getCLP(){
        clp = new CLP(driver);
        return clp;
    }

    public ProductTile getProductTile() {
        productTile = new ProductTile(driver);
        return productTile;
    }
    public SRP getSRP() {
        srp = new SRP(driver);
        return srp;
    }


    public HomePage getHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }


    public RapidPage getRapidPage() {
        rapidPage = new RapidPage(driver);
        return rapidPage;
    }

    public Header getHeader() {
        header = new Header(driver);
        return header;
    }
    public ServicesPage getServicesPage(){
        servicesPage = new ServicesPage(driver);
        return servicesPage;
    }

    public PDP getPdpPage(){
        pdp=new PDP(driver);
        return pdp;
    }
    public MyShop getMyShop() {
        myShop = new MyShop(driver);
        return myShop;
    }

    public ExpressPass getExpressPass() {
        expressPass = new ExpressPass(driver);
        return expressPass;
    }

    public Flyers getFlyers(){
        flyers=new Flyers(driver);
        return flyers;
    }

    public FindALocation getFindALocation() {
        findALocation = new FindALocation(driver);
        return findALocation;
    }
    public Account getAccount(){
        account = new Account(driver);
        return account;
    }

    public Cart getCart(){
        cart=new Cart(driver);
        return cart;
    }
    public Checkout getCheckout()  {
        checkout = new Checkout(driver);
        return checkout;
    }
}
