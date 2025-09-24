package com.awesomeqa.pages;

import com.awesomeqa.utils.BrowserActions;
import com.awesomeqa.utils.ElementActions;
import com.awesomeqa.utils.Validations;
import com.awesomeqa.utils.Waits;
import com.awesomeqa.utils.data_Reader.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ChangePasswordPage {
    // locators
    private final By passwordField = By.id("input-password");
    private final By passwordConfirmField = By.id("input-confirm");
    private final By ContinueButton = By.cssSelector("[value='Continue']");
    private final By SuccessMSG = By.cssSelector(".alert");
    private final By invalidPasswordMSG = RelativeLocator.with(By.tagName("div")).straightBelow(By.id("input-password"));
    private final By confirmPasswordMSG = RelativeLocator.with(By.tagName("div")).straightBelow(By.id("input-confirm"));

    //constructor

    public ChangePasswordPage() {
    }

    //actions
    public void navigateToChangePasswordPage() {
        BrowserActions.navigateToURL(PropertiesUtils.getPropertyValue("ChangePassword"));
    }

    public void enterNewPassword(String password) {
        ElementActions.sendData(passwordField, password);
    }

    public void enterPasswordConfirm(String password) {
        ElementActions.sendData(passwordConfirmField, password);
    }

    public void clickContoniueButton() {
        ElementActions.clickElement(ContinueButton);
    }

    public String getTextMSG(By locator) {
        return ElementActions.getData(locator);
    }

    public void changePassword(String password, String passwordConfirm) {
        enterNewPassword(password);
        enterPasswordConfirm(passwordConfirm);
        clickContoniueButton();
    }

    //Validations

    public void assertPasswordChangedSuccessfullyMSG() {
        Validations.validateEquals(getTextMSG(SuccessMSG), PropertiesUtils.getPropertyValue("password_changed_MSG"));
    }

    public void assertMSGforInvalidPassword() {
        Waits.waitForTextToBe(invalidPasswordMSG, PropertiesUtils.getPropertyValue("invalid_password_MSG"));
        Validations.validateEquals(getTextMSG(invalidPasswordMSG), PropertiesUtils.getPropertyValue("invalid_password_MSG"));
    }

    public void assertMSGforPasswordConfirm() {
        Waits.waitForTextToBe(confirmPasswordMSG, PropertiesUtils.getPropertyValue("password_confirm_MSG"));
        Validations.validateEquals(getTextMSG(confirmPasswordMSG), PropertiesUtils.getPropertyValue("password_confirm_MSG"));
    }

}
