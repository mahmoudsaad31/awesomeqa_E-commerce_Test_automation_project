package com.awesomeqa;

import com.awesomeqa.pages.HomePage;
import com.awesomeqa.utils.BrowserActions;
import com.awesomeqa.utils.Waits;
import org.testng.annotations.Test;

public class TestHomePage extends TestBase {


    @Test
    public void TestAddingProductToWishList() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.AddSpecificProductToWishList(getProductData("product1.name"));
        Waits.sleepForCertainTime(2000);
        //homePage.assertProductAddedToWishList(getProductData("product1.name"));
        homePage.AddSpecificProductToWishList(getProductData("product3.name"));
        //homePage.assertProductAddedToWishList(getProductData("product2.name"));
    }


    @Test
    public void TestAddingProductToComparison() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.AddSpecificProductToComparison(getProductData("product1.name"));
        Waits.sleepForCertainTime(2000);
        homePage.assertProductAddedToComparison(getProductData("product1.name"));
        homePage.AddSpecificProductToComparison(getProductData("product2.name"));
        homePage.assertProductAddedToComparison(getProductData("product2.name"));
        homePage.clickOnProductComparison();
        homePage.assertDirectedToProductComparisonPage();
    }

    @Test
    public void TestSearchForProduct() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.searchFeature(getProductData("searchedData.firstSearchItem"));
        homePage.assertsuccessfullSearchForSpecificWord(getProductData("searchedData.firstSearchItem"));
    }

    @Test
    public void TestClickingOnSpecificProductOnthePage() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.clickOnSpecificProductTOseeDetails(getProductData("product1.name"));
        BrowserActions.navigateBack();
        homePage.clickOnSpecificProductTOseeDetails(getProductData("product2.name"));
        BrowserActions.navigateBack();
        homePage.clickOnSpecificProductTOseeDetails(getProductData("product3.name"));
        BrowserActions.navigateBack();
        homePage.clickOnSpecificProductTOseeDetails(getProductData("product4.name"));
        BrowserActions.navigateBack();
    }


    @Test
    public void goToLoginPageFromHome() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.clickOnMyAccount();
        homePage.clickOnLogin();
        homePage.assertDirectedToLoginPage();


    }

    @Test
    public void goToRegisterPageFromHome() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.clickOnMyAccount();
        homePage.clickOnRegister();
        homePage.assertDirectedToRegisterPage();

    }


}
