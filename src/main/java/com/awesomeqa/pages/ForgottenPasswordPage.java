package com.awesomeqa.pages;

import com.awesomeqa.utils.BrowserActions;
import com.awesomeqa.utils.ElementActions;
import com.awesomeqa.utils.Validations;
import com.awesomeqa.utils.data_Reader.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ForgottenPasswordPage {

    // locators

    By EmailField = By.id("input-email");
    By ContinueButton = By.cssSelector("[value='Continue']");
    By WarningMSG = By.className("alert");


    // constructor
    public ForgottenPasswordPage() {
    }

    // actions

    @Step("navigte to Forgotten Password Page ")
    public void navigateToForgottenPasswordPage() {
        BrowserActions.navigateToURL(PropertiesUtils.getPropertyValue("ForgottenPassword"));
    }

    @Step("Enter Your Email: {Email}")
    public void EnterYourEmail(String Email) {
        ElementActions.sendData(EmailField, Email);
        ElementActions.clickElement(ContinueButton);
    }

    @Step("get message")
    public String getWarningMSG() {
        return ElementActions.getData(WarningMSG);
    }

    @Step("Assert Message Shown for EMail not Found In records")
    public void assertMessageShownforEMailnotFoundInrecords() {
        Validations.validateEquals(getWarningMSG(), PropertiesUtils.getPropertyValue("forgotten_password_failed_msg"));
    }

    @Step("Assert Message Shown for Confirmation Link Sent To Email")
    public void assertMessageShownForConfirmationLinkSentToEmail() {
        Validations.validateEquals(getWarningMSG(), PropertiesUtils.getPropertyValue("forgotten_password_success_msg"));
    }
}
