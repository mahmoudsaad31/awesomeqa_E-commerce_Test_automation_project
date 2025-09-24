package com.awesomeqa.pages;

import com.awesomeqa.utils.BrowserActions;
import com.awesomeqa.utils.ElementActions;
import com.awesomeqa.utils.Validations;
import com.awesomeqa.utils.data_Reader.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EditAccountInfoPage {
    // locators
    private By FirstNameField = By.id("input-firstname");
    private By LastNameField = By.id("input-lastname");
    private By EmailField = By.id("input-email");
    private By TelephoneField = By.id("input-telephone");
    private By ContinueButton = By.cssSelector("[value='Continue']");
    private By pageMSG = By.cssSelector(".alert");

    // constructors
    public EditAccountInfoPage() {

    }

    //actions

    public void navigateToEditAccountInfoPage() {
        BrowserActions.navigateToURL(PropertiesUtils.getPropertyValue("EditAccount"));
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

    @Step("click Continue Button")
    public void clickContinueButton() {
        ElementActions.clickElement(ContinueButton);
    }

    public String getpageMsg() {
        return ElementActions.getData(pageMSG);
    }


    public void editAccountInformation(String firstname, String lastname, String email, String telephone) {
        enterFirstName(firstname);
        enterLastName(lastname);
        enterEmail(email);
        enterTelephone(telephone);
        clickContinueButton();
    }

    // validations

    public void assertUnsuccessfulEditAcountInfoWithALreadyRegisteredEmail() {
        Validations.validateEquals(getpageMsg(), PropertiesUtils.getPropertyValue("already_registered_MSG2"));
    }

    public void assertsuccessfulEditForAcountInfo() {
        Validations.validateEquals(getpageMsg(), PropertiesUtils.getPropertyValue("edit_Account_info_MSG"));
    }


}
