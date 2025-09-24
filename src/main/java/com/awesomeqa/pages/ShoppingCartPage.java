package com.awesomeqa.pages;

import com.awesomeqa.utils.ElementActions;
import com.awesomeqa.utils.Validations;
import com.awesomeqa.utils.Waits;
import com.awesomeqa.utils.data_Reader.PropertiesUtils;
import com.awesomeqa.utils.report.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ShoppingCartPage {

    // locators
    By checkoutButton = By.linkText("Checkout");
    By continueShoppingButton = By.linkText("Continue Shopping");
    By pageMsg = By.cssSelector(".alert");


    // constructor
    public ShoppingCartPage() {
    }

    @Step("click on Checkout Button")
    public void clickCheckoutButton() {
        ElementActions.clickElement(checkoutButton);
    }

    @Step("click on Continue Shopping Button")
    public void clickContinueShoppingButton() {
        ElementActions.clickElement(continueShoppingButton);
    }

    @Step("add quantity to specific product")
    public void addQuantityToSpecificProduct(String productname, String Quantity) {
        By QuantityField = RelativeLocator.with(By.xpath("//*[@class='table-responsive']/table//td[4]//input")).straightRightOf(By.linkText(productname));
        LogsUtils.info("adding quantity to product : ", Quantity);
        ElementActions.sendData(QuantityField, Quantity);
    }

    @Step("click update button to specific product")
    public void clickUpdateButtonToSpecificProduct(String productname) {
        By updateButton = RelativeLocator.with(By.cssSelector("[data-original-title=Update]")).straightRightOf(By.linkText(productname));
        LogsUtils.info("Click update Button");
        ElementActions.clickElement(updateButton);
    }

    @Step("removeSpecificProductFromCart")
    public void removeSpecificProductFromCart(String productname) {
        By removeButton = RelativeLocator.with(By.cssSelector("[data-original-title=Remove]")).straightRightOf(By.linkText(productname));
        LogsUtils.info("remove" + productname + "from cart");
        ElementActions.clickElement(removeButton);
    }


    @Step("get product name {productname}")
    public String getProductName(String productname) {
        By productNameField = By.linkText(productname);
        LogsUtils.info("product name is " + ElementActions.getData(productNameField));
        return ElementActions.getData(productNameField);
    }


    @Step("get product price {productPrice}")
    public String getProductPrice(String productname) {
        By productPriceField = RelativeLocator.with(By.xpath("//*[@class='table-responsive']//tbody//td[5]")).straightBelow(By.xpath("//td[.='Unit Price']")).straightRightOf(By.linkText(productname));
        LogsUtils.info("product price is " + ElementActions.getData(productPriceField));
        return ElementActions.getData(productPriceField);
    }

    @Step("assert product {productPrice} added to cart")
    public void assertProductisAddedInCart(String productname) {
        Validations.validateEquals(getProductName(productname), productname);
        LogsUtils.info("assertProductisAddedInCart is successfully passed");
    }

    @Step("assert product details")
    public void assertProductDetails(String productname, String productPrice) {
        String actualProductname = getProductName(productname);
        String actualProductPrice = getProductPrice(productname);
        Validations.validateEquals(actualProductname, productname);
        Validations.validateEquals(actualProductPrice, productPrice);
        LogsUtils.info("assertProductDetails is successfully passed");
    }

    public String getTextFromMSG() {
        return ElementActions.getData(pageMsg);
    }

    public void assertQuantityUpdatedSuccessfully() {
        Validations.validateContains(getTextFromMSG(), PropertiesUtils.getPropertyValue("shoppingCartPage_msg"));

    }

    public void assertDirectedToCheckOutPage() {
        Waits.sleepForCertainTime(1000);
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("ckeckoutPageTile"));
    }

}
