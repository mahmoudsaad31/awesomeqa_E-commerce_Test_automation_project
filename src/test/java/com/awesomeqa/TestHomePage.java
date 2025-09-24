package com.awesomeqa;

import com.awesomeqa.pages.CheckOutPage;
import com.awesomeqa.pages.HomePage;
import com.awesomeqa.pages.ShoppingCartPage;
import com.awesomeqa.utils.BrowserActions;
import com.awesomeqa.utils.Waits;
import org.testng.annotations.Test;

public class TestHomePage extends TestBase {


    @Test
    public void addingProductToCart() {
        HomePage homePage = new HomePage();
        CheckOutPage checkOutPage = new CheckOutPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        homePage.navigateToHomePage();
        homePage.AddSpecificProductToCart(getProductData("product1.name"));
        homePage.assertProductAddedToCart(getProductData("product1.name"));
        homePage.AddSpecificProductToCart(getProductData("product2.name"));
        homePage.assertProductAddedToCart(getProductData("product2.name"));
        homePage.clickOnCartIcon();
        //homePage.RemoveSpecificProductFromCart(getProductData("product2.name"));
        //homePage.assertProductRemovedFromCart(getProductData("product2.name"));
        homePage.clickOnViewCartIcon();
        homePage.assertDirectedToViewCartPage();
        shoppingCartPage.assertProductisAddedInCart(getProductData("product2.name"));
        shoppingCartPage.assertProductDetails(getProductData("product2.name"), getProductData("product2.price"));
        shoppingCartPage.addQuantityToSpecificProduct(getProductData("product1.name"), getProductData("product1.quantity"));
        shoppingCartPage.clickUpdateButtonToSpecificProduct(getProductData("product1.name"));
        shoppingCartPage.assertQuantityUpdatedSuccessfully();
        shoppingCartPage.addQuantityToSpecificProduct(getProductData("product2.name"), getProductData("product2.quantity"));
        shoppingCartPage.clickUpdateButtonToSpecificProduct(getProductData("product2.name"));
        shoppingCartPage.assertQuantityUpdatedSuccessfully();
        shoppingCartPage.removeSpecificProductFromCart(getProductData("product2.name"));
        //shoppingCartPage.removeSpecificProductFromCart(getProductData("product1.name"));
        shoppingCartPage.clickContinueShoppingButton();
        Waits.sleepForCertainTime(2000);
        BrowserActions.navigateBack();
        shoppingCartPage.clickCheckoutButton();
        shoppingCartPage.assertDirectedToCheckOutPage();


//        BrowserActions.navigateBack();
//        homePage.clickOnCartIcon();
//        homePage.clickOnCheckOutIcon();
//        homePage.assertDirectedToCheckOutPage();
//        checkOutPage.checkoutOptions();
//        checkOutPage.addAccountAndBillingDetails("h", "h", "h@h.com", "1234", "12345", "12345", "hhh", "hhh", "12", "Egypt", "Al Qahirah");
//        checkOutPage.addPaymentMethod();
    }

    @Test
    public void addingProductToWishList() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.AddSpecificProductToWishList(getProductData("product1.name"));
        Waits.sleepForCertainTime(2000);
        //homePage.assertProductAddedToWishList(getProductData("product1.name"));
        homePage.AddSpecificProductToWishList(getProductData("product3.name"));
        //homePage.assertProductAddedToWishList(getProductData("product2.name"));
    }


    @Test
    public void addingProductToComparison() {
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
    public void testChangeCurrency() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.clickOnCurrency();
        homePage.clickOnEuro();
        homePage.assertCurrencyChangedToNewCurrency(getProductData("currency.euro"));
        homePage.assertcurrencyChangedInproductPrice(getProductData("currency.euro"));
        homePage.clickOnCurrency();
        homePage.clickOnPoundSterling();
        homePage.assertCurrencyChangedToNewCurrency(getProductData("currency.poundSterling"));
        homePage.clickOnCurrency();
        homePage.clickOnUsDollar();
        homePage.assertCurrencyChangedToNewCurrency(getProductData("currency.usDollar"));
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
