package com.awesomeqa.pages;

import com.awesomeqa.utils.BrowserActions;
import com.awesomeqa.utils.ElementActions;
import com.awesomeqa.utils.Validations;
import com.awesomeqa.utils.data_Reader.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegisterPage {


    // locators
    private By FirstNameField = By.id("input-firstname");
    private By LastNameField = By.id("input-lastname");
    private By EmailField = By.id("input-email");
    private By TelephoneField = By.id("input-telephone");
    private By PasswordField = By.id("input-password");
    private By ConfirmPasswordField = By.id("input-confirm");
    private By PrivacyPolicy = By.cssSelector("[name='agree']");
    private By ContinueButton = By.cssSelector("[value='Continue']");
    private By registerWarnningMsg = By.cssSelector(".alert");
    private By FnameErrorMSG = By.xpath("(//*[@class='col-sm-10'])[2]/div");
    private By LnameErrorMSG = By.xpath("(//*[@class='col-sm-10'])[3]/div");
    private By EmailErrorMSG = By.xpath("(//*[@class='col-sm-10'])[4]/div");
    private By TelephoneErrorMSG = By.xpath("(//*[@class='col-sm-10'])[5]/div");
    private By PasswordErrorMSG = By.xpath("(//*[@class='col-sm-10'])[6]/div");


    // constructor
    public RegisterPage() {
    }

    // actions

    @Step("Navigate to the Register page")
    public void navigateToRegisterPage() {
        BrowserActions.navigateToURL(PropertiesUtils.getPropertyValue("RegisterURL"));
    }

    @Step("Enter FirstName: {FirstName}")
    public void enterFirstName(String FirstName) {
        ElementActions.sendData(FirstNameField, FirstName);
    }

    @Step("Enter LastName: {0}")
    public void enterLastName(String LastName) {
        ElementActions.sendData(LastNameField, LastName);
    }

    @Step("Enter Email: {Email}")
    public void enterEmail(String Email) {
        ElementActions.sendData(EmailField, Email);
    }

    @Step("Enter Telephone: {Telephone}")
    public void enterTelephone(String Telephone) {
        ElementActions.sendData(TelephoneField, Telephone);
    }

    @Step("Enter Password: {0}")
    public void enterPassword(String Password) {
        ElementActions.sendData(PasswordField, Password);
    }

    @Step("Enter ConfirmPassword: {0}")
    public void enterConfirmPassword(String Password) {
        ElementActions.sendData(ConfirmPasswordField, Password);
    }

    @Step("click agree privacy policy")
    public void clickAgreePrivacyPolicy() {
        ElementActions.clickElement(PrivacyPolicy);
    }

    @Step("click Continue Button")
    public void clickContinueButton() {
        ElementActions.clickElement(ContinueButton);
    }

    @Step("click Continue Btn")
    public void clickContinueBtn() {
        ElementActions.clickElement(By.linkText("Continue"));
    }


    @Step("Register New Acount")
    public void registerNewAcount(String firstname, String lastname, String email, String telephone, String password, String confirmPassword) {
        enterFirstName(firstname);
        enterLastName(lastname);
        enterEmail(email);
        enterTelephone(telephone);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        clickAgreePrivacyPolicy();
        clickContinueButton();
    }

    public String getWarningMSG(By locator) {
        return ElementActions.getData(locator);
    }

    @Step("Assert successful Register")
    public void assertSuccessfullnewAccountRegistered() {
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("RegisterSuccessPageTitle"));
    }

    @Step("Assert unsuccessful Register with already registered email")
    public void assertUNSuccessfullnewAccountRegistered() {
        Validations.validateContains(getWarningMSG(registerWarnningMsg), PropertiesUtils.getPropertyValue("already_registered_MSG"));
    }

    @Step("Assert unsuccessful Register with invalid first name")
    public void assertMessageShownWhenUserEnterInvalidFirstName() {
        Validations.validateContains(getWarningMSG(FnameErrorMSG), PropertiesUtils.getPropertyValue("invalid_firstname_MSG"));
    }

    @Step("Assert unsuccessful Register with invalid last name")
    public void assertMessageShownWhenUserEnterInvalidLastName() {
        Validations.validateContains(getWarningMSG(LnameErrorMSG), PropertiesUtils.getPropertyValue("invalid_lastname_MSG"));
    }

    @Step("Assert unsuccessful Register with invalid email name")
    public void assertMessageShownWhenUserEnterInvalidEmail() {
        Validations.validateContains(getWarningMSG(EmailErrorMSG), PropertiesUtils.getPropertyValue("invalid_email_MSG"));
    }

    @Step("Assert unsuccessful Register with invalid telephone")
    public void assertMessageShownWhenUserEnterInvalidTelephone() {
        Validations.validateContains(getWarningMSG(TelephoneErrorMSG), PropertiesUtils.getPropertyValue("invalid_telephone_MSG"));
    }

    @Step("Assert unsuccessful Register with invalid Password")
    public void assertMessageShownWhenUserEnterInvalidPassword() {
        Validations.validateContains(getWarningMSG(PasswordErrorMSG), PropertiesUtils.getPropertyValue("invalid_password_MSG"));
    }


}
