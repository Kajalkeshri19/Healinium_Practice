package util;

import pages.PageObjectManager;
import resources.Base;
import resources.CommonUtility;

import java.io.IOException;

public class TestContextSetup {
    /**
     * Test Context Setup class enwraps initialization of Base, Common and PageObjectManager.
     * Instead of initialize these class separately in each step definition, we are using Test Context Setup
     * **/

    //PageObjectManager is a class that has methods to return instance of each page class.
    public final PageObjectManager pom;

    //Base class has methods to all driver related operations.
    public final Base base;

    //CommonUtility is a class which has methods associated with basic Selenium operations
    public final CommonUtility commonUtility;



    public TestContextSetup() throws IOException {
        base = new Base();
        pom = new PageObjectManager(base.initializeDriver());
        commonUtility=new CommonUtility(base.initializeDriver());
    }
}