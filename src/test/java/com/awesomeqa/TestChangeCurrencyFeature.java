package com.awesomeqa;

import com.awesomeqa.pages.HomePage;
import org.testng.annotations.Test;

public class TestChangeCurrencyFeature extends TestBase {

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
        homePage.assertcurrencyChangedInproductPrice(getProductData("currency.poundSterling"));
        homePage.clickOnCurrency();
        homePage.clickOnUsDollar();
        homePage.assertCurrencyChangedToNewCurrency(getProductData("currency.usDollar"));
        homePage.assertcurrencyChangedInproductPrice(getProductData("currency.usDollar"));
    }
}
