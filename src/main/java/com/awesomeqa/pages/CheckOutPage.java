package com.awesomeqa.pages;

import com.awesomeqa.utils.BrowserActions;
import com.awesomeqa.utils.ElementActions;
import com.awesomeqa.utils.Waits;
import com.awesomeqa.utils.data_Reader.PropertiesUtils;
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
    private By continueButtonPaymentMethode = By.id("button-payment-method");
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

    @Step("click agree to Terms & Conditions")
    public void clickAgreeToTerms_Conditions() {
        ElementActions.clickElement(terms_conditions);
    }

    @Step("click Continue Button for payment method ")
    public void clickContinueButtonPaymentMethod() {
        ElementActions.clickElement(continueButtonPaymentMethode);
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

    @Step("Add Payment Method")
    public void addPaymentMethod() {
        clickAgreeToTerms_Conditions();
        clickContinueButtonPaymentMethod();
    }


}
