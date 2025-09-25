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
    By cartList = By.xpath("//*[@id='content']/form/div/table");

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


    public String getTextFromMSG() {
        return ElementActions.getData(pageMsg);
    }

    public void assertProductRemovedfromCart(String productname) {
        Waits.sleepForCertainTime(1000);
        Validations.validateFalse(ElementActions.getHtmlSourceTextFromElement(cartList).contains(productname));
        LogsUtils.info("assert" + productname + "RemovedFromCart");

    }

    public void assertQuantityUpdatedSuccessfully() {
        Validations.validateContains(getTextFromMSG(), PropertiesUtils.getPropertyValue("shoppingCartPage_msg"));

    }

}
