package com.awesomeqa.pages;

import com.awesomeqa.utils.BrowserActions;
import com.awesomeqa.utils.ElementActions;
import com.awesomeqa.utils.Validations;
import com.awesomeqa.utils.Waits;
import com.awesomeqa.utils.data_Reader.PropertiesUtils;
import com.awesomeqa.utils.report.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class CheckOutPage {

    // Locators
    private By register = By.cssSelector("[value='register']");
    private By guest = By.cssSelector("[value='guest']");
    private By continueButton = By.id("button-account");
    private By firstnameField = By.id("input-payment-firstname");
    private By lastnameField = By.id("input-payment-lastname");
    private By emailField = By.id("input-payment-email");
    private By telephoneField = By.id("input-payment-telephone");
    private By passwordField = By.id("input-payment-password");
    private By confirmPasswordField = By.id("input-payment-confirm");
    private By address1Field = By.id("input-payment-address-1");
    private By cityField = By.id("input-payment-city");
    private By postCodeField = By.id("input-payment-postcode");
    private By countryField = By.id("input-payment-country");
    private By zoneField = By.id("input-payment-zone");
    private By privacyPolicy = By.cssSelector("[name=agree]");
    private By continueButtonRegister = By.id("button-register");
    private By continueButtonPaymentAddress = By.id("button-payment-address");
    private By continueButtonShippingAddress = By.id("button-shipping-address");
    private By continueButtonShippingMethod = By.id("button-shipping-method");
    private By continueButtonPaymentMethode = By.id("button-payment-method");
    private By confirmOrderButton = By.id("button-confirm");
    private By terms_conditions = RelativeLocator.with(By.cssSelector("[name=agree]")).toRightOf(By.linkText("Terms & Conditions"));

    // constructor
    public CheckOutPage() {
    }

    @Step("Navigate to the CheckOut page")
    public void navigateToCheckOutPage() {
        BrowserActions.navigateToURL(PropertiesUtils.getPropertyValue("CheckoutURL"));
    }

    @Step("click Register radio Button")
    public void clickRegisterRadioButton() {
        ElementActions.clickElement(register);
    }

    @Step("click Guest Radio Button")
    public void clickGuestRadioButton() {
        ElementActions.clickElement(guest);
    }

    @Step("click Continue Button")
    public void clickContinueButton() {
        ElementActions.clickElement(continueButton);
    }

    @Step("Enter FirstName: {FirstName}")
    public void enterFirstName(String FirstName) {
        ElementActions.sendData(firstnameField, FirstName);
    }

    @Step("Enter LastName: {0}")
    public void enterLastName(String LastName) {
        ElementActions.sendData(lastnameField, LastName);
    }

    @Step("Enter Email: {Email}")
    public void enterEmail(String Email) {
        ElementActions.sendData(emailField, Email);
    }

    @Step("Enter Telephone: {Telephone}")
    public void enterTelephone(String Telephone) {
        ElementActions.sendData(telephoneField, Telephone);
    }

    @Step("Enter Password: {0}")
    public void enterPassword(String Password) {
        ElementActions.sendData(passwordField, Password);
    }

    @Step("Enter ConfirmPassword: {0}")
    public void enterConfirmPassword(String Password) {
        ElementActions.sendData(confirmPasswordField, Password);
    }

    @Step("Enter Address: {address}")
    public void enterAddress(String address) {
        ElementActions.sendData(address1Field, address);
    }

    @Step("Enter city: {address}")
    public void enterCity(String City) {
        ElementActions.sendData(cityField, City);
    }

    @Step("Enter Post Code: {PostCode}")
    public void enterPostCode(String PostCode) {
        ElementActions.sendData(postCodeField, PostCode);
    }

    @Step("Enter country: {country}")
    public void enterCountry(String country) {
        ElementActions.selectFromDropDownList(countryField, country);
    }

    @Step("Enter State: {State}")
    public void enterState(String State) {
        Waits.sleepForCertainTime(1000);
        ElementActions.selectFromDropDownList(zoneField, State);
    }


    @Step("click agree privacy policy")
    public void clickAgreePrivacyPolicy() {
        ElementActions.clickElement(privacyPolicy);
    }

    @Step("click Continue Button for register")
    public void clickContinueButtonRegister() {
        ElementActions.clickElement(continueButtonRegister);
    }

    @Step("click Continue Button for PaymentAddress")
    public void clickContinueButtonPaymentAddress() {
        ElementActions.clickElement(continueButtonPaymentAddress);
    }

    @Step("click Continue Button for ShippingAddress")
    public void clickContinueButtonShippingAddress() {
        ElementActions.clickElement(continueButtonShippingAddress);
    }

    @Step("click Continue Button for ShippingMethod")
    public void clickContinueButtonShippingMethod() {
        ElementActions.clickElement(continueButtonShippingMethod);
    }


    @Step("click agree to Terms & Conditions")
    public void clickAgreeToTerms_Conditions() {
        ElementActions.clickElement(terms_conditions);
    }

    @Step("click Continue Button for payment method ")
    public void clickContinueButtonPaymentMethod() {
        ElementActions.clickElement(continueButtonPaymentMethode);
    }

    @Step("click confirm order button ")
    public void clickConfirmOrderButton() {
        ElementActions.clickElement(confirmOrderButton);
    }


    @Step("checkout options")
    public void checkoutOptions() {
        clickRegisterRadioButton();
        clickContinueButton();
    }


    @Step("Register New Acount")
    public void addAccountAndBillingDetails(String firstname, String lastname, String email, String telephone, String password, String confirmPassword,
                                            String address, String city, String postcode, String country, String state) {
        enterFirstName(firstname);
        enterLastName(lastname);
        enterEmail(email);
        enterTelephone(telephone);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);

        enterAddress(address);
        enterCity(city);
        enterPostCode(postcode);
        enterCountry(country);
        enterState(state);

        clickAgreePrivacyPolicy();
        clickContinueButtonRegister();
    }

    @Step("Billing Details")
    public void billingDetails(String firstname, String lastname, String address, String city, String postcode, String country, String state) {
        enterFirstName(firstname);
        enterLastName(lastname);
        enterAddress(address);
        enterCity(city);
        enterPostCode(postcode);
        enterCountry(country);
        enterState(state);

    }

    @Step("Add Payment Method")
    public void addPaymentMethod() {
        clickAgreeToTerms_Conditions();
        clickContinueButtonPaymentMethod();
    }

    @Step("get product name {productname}")
    public String getProductName(String productname) {
        By productNameField = By.linkText(productname);
        LogsUtils.info("product name is " + ElementActions.getData(productNameField));
        return ElementActions.getData(productNameField);
    }


    @Step("get product price of {productname}")
    public String getProductPrice(String productname) {
        By productPriceField = RelativeLocator.with(By.xpath("//*[@class='table-responsive']//tbody//td[4]")).straightRightOf(By.linkText(productname));
        LogsUtils.info("product price is " + ElementActions.getData(productPriceField));
        return ElementActions.getData(productPriceField);
    }

    @Step("get product quantity of {productname}")
    public String getProductQuantity(String productname) {
        By productQuantityField = RelativeLocator.with(By.xpath("//*[@class='table-responsive']//tbody//td[3]")).straightRightOf(By.linkText(productname));
        LogsUtils.info("product quantity is " + ElementActions.getData(productQuantityField));
        return ElementActions.getData(productQuantityField);
    }

    // validation

    @Step("assert product details")
    public void assertProductDetails(String productname, String productPrice, String productQuantity) {
        String actualProductname = getProductName(productname);
        String actualProductPrice = getProductPrice(productname);
        String actualProductQuantity = getProductQuantity(productname);

        Validations.validateEquals(actualProductname, productname);
        Validations.validateEquals(actualProductPrice, productPrice);
        Validations.validateEquals(actualProductQuantity, productQuantity);
        LogsUtils.info("assertProductDetails is successfully passed");
    }

    public void assertOrderHasBeenPlaced() {
        Waits.sleepForCertainTime(2000);
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("checkoutSuccessTitle"));
    }

    public void assertDirectedToCheckOutPage() {
        Waits.sleepForCertainTime(1000);
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("ckeckoutPageTile"));
    }

}
