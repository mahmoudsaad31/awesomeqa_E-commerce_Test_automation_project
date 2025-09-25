package com.awesomeqa;

import com.awesomeqa.pages.*;
import com.awesomeqa.utils.report.LogsUtils;
import org.testng.annotations.Test;

public class E2ETests extends TestBase {


    @Test
    public void TestNavigatingToRegisterPageFromHome() {
        LogsUtils.info("start of method TestGoingToRegisterPageFromHome");
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.clickOnMyAccount();
        homePage.clickOnRegister();
        homePage.assertDirectedToRegisterPage();
    }

    @Test(dependsOnMethods = "TestNavigatingToRegisterPageFromHome")
    public void TestSuccessfullRegister() {
        LogsUtils.info("start of method TestSuccessfullRegister");
        RegisterPage registerPage = new RegisterPage();
        registerPage.registerNewAcount(
                getTestData("firstname"), getTestData("lastname"),
                getRANDTestData("email"), getTestData("telephone"),
                getTestData("password"), getTestData("password"));
        registerPage.assertSuccessfullnewAccountRegistered();
        registerPage.clickContinueBtn();
        new MyAccountPage().assertDirectedToMyAccountURL();
    }

    @Test(dependsOnMethods = "TestSuccessfullRegister")
    public void TestSearchForProduct() {
        HomePage homePage = new HomePage();
        homePage.searchFeature(getProductData("searchedData.firstSearchItem"));
        homePage.assertsuccessfullSearchForSpecificWord(getProductData("searchedData.firstSearchItem"));
    }

    @Test(dependsOnMethods = "TestSearchForProduct")
    public void TestAddingMultipleProductsToCart() {
        HomePage homePage = new HomePage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        homePage.AddSpecificProductToCart(getProductData("product1.name"));
        homePage.assertProductAddedToCart(getProductData("product1.name"));
        homePage.AddSpecificProductToCart(getProductData("product2.name"));
        homePage.assertProductAddedToCart(getProductData("product2.name"));
        homePage.AddSpecificProductToCart(getProductData("product3.name"));
        homePage.assertProductAddedToCart(getProductData("product3.name"));
        homePage.AddSpecificProductToCart(getProductData("product4.name"));
        homePage.assertProductAddedToCart(getProductData("product4.name"));
        homePage.clickOnCartIcon();
        homePage.clickOnViewCartIcon();
        homePage.assertDirectedToViewCartPage();
//        shoppingCartPage.assertProductDetails(getProductData("product1.name"), getProductData("product1.price"));
//        shoppingCartPage.assertProductDetails(getProductData("product2.name"), getProductData("product2.price"));
//        shoppingCartPage.assertProductDetails(getProductData("product3.name"), getProductData("product3.price"));
//        shoppingCartPage.assertProductDetails(getProductData("product4.name"), getProductData("product4.price"));
    }

    @Test(dependsOnMethods = "TestAddingMultipleProductsToCart")
    public void TestRemovingProductsFromCart() {
        HomePage homePage = new HomePage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.removeSpecificProductFromCart(getProductData("product4.name"));
        shoppingCartPage.assertProductRemovedfromCart(getProductData("product4.name"));
        homePage.clickOnCartIcon();
        homePage.RemoveSpecificProductFromCart(getProductData("product3.name"));
        homePage.clickOnCartIcon();
        homePage.assertProductRemovedFromCarticon(getProductData("product3.name"));
    }

    @Test(dependsOnMethods = "TestRemovingProductsFromCart")
    public void TestContinueShoppingToAddAnotherProductsToCart() {
        HomePage homePage = new HomePage();
        new ShoppingCartPage().clickContinueShoppingButton();
        homePage.assertDirectedToHomePage();
        homePage.searchFeature(getProductData("searchedData.secondSearchItem"));
        homePage.assertsuccessfullSearchForSpecificWord(getProductData("searchedData.secondSearchItem"));
        homePage.AddSpecificProductToCart(getProductData("product5.name"));
        homePage.assertProductAddedToCart(getProductData("product5.name"));
        homePage.AddSpecificProductToCart(getProductData("product6.name"));
        homePage.assertProductAddedToCart(getProductData("product6.name"));
        homePage.clickOnCartIcon();
        homePage.clickOnViewCartIcon();
        homePage.assertDirectedToViewCartPage();
    }

    @Test(dependsOnMethods = "TestContinueShoppingToAddAnotherProductsToCart")
    public void TestUpdateProductQuantityInCart() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.addQuantityToSpecificProduct(getProductData("product1.name"), getProductData("product1.quantity"));
        shoppingCartPage.clickUpdateButtonToSpecificProduct(getProductData("product1.name"));
        shoppingCartPage.assertQuantityUpdatedSuccessfully();
        shoppingCartPage.addQuantityToSpecificProduct(getProductData("product2.name"), getProductData("product2.quantity"));
        shoppingCartPage.clickUpdateButtonToSpecificProduct(getProductData("product2.name"));
        shoppingCartPage.assertQuantityUpdatedSuccessfully();
        shoppingCartPage.addQuantityToSpecificProduct(getProductData("product5.name"), getProductData("product5.quantity"));
        shoppingCartPage.clickUpdateButtonToSpecificProduct(getProductData("product5.name"));
        shoppingCartPage.assertQuantityUpdatedSuccessfully();
        shoppingCartPage.addQuantityToSpecificProduct(getProductData("product6.name"), getProductData("product6.quantity"));
        shoppingCartPage.clickUpdateButtonToSpecificProduct(getProductData("product6.name"));
        shoppingCartPage.assertQuantityUpdatedSuccessfully();

    }

    @Test(dependsOnMethods = "TestUpdateProductQuantityInCart")
    public void TestcheckoutDetailsAndBillingDetails() {
        new ShoppingCartPage().clickCheckoutButton();
        CheckOutPage checkOutPage = new CheckOutPage();
        checkOutPage.assertDirectedToCheckOutPage();
        checkOutPage.billingDetails(getTestData("firstname"), getTestData("lastname"), getTestData("Address"), getTestData("City"), getTestData("PostCode"), getTestData("Country"), getTestData("State"));
        checkOutPage.clickContinueButtonPaymentAddress();
        checkOutPage.clickContinueButtonShippingAddress();
        checkOutPage.clickContinueButtonShippingMethod();
        checkOutPage.clickAgreeToTerms_Conditions();
        checkOutPage.clickContinueButtonPaymentMethod();

    }

    @Test(dependsOnMethods = "TestcheckoutDetailsAndBillingDetails")
    public void TestproductsDetailsBeforePlacingOrder() {
        CheckOutPage checkOutPage = new CheckOutPage();
        checkOutPage.assertProductDetails(getProductData("product1.name"), getProductData("product1.price"), getProductData("product1.quantity"));
        checkOutPage.assertProductDetails(getProductData("product2.name"), getProductData("product2.price"), getProductData("product2.quantity"));
        checkOutPage.assertProductDetails(getProductData("product5.name"), getProductData("product5.price"), getProductData("product5.quantity"));
        checkOutPage.assertProductDetails(getProductData("product6.name"), getProductData("product6.price"), getProductData("product6.quantity"));
        checkOutPage.clickConfirmOrderButton();
        checkOutPage.assertOrderHasBeenPlaced();
    }
}



