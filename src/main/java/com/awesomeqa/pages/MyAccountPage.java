package com.awesomeqa.pages;

import com.awesomeqa.utils.ElementActions;
import com.awesomeqa.utils.Validations;
import com.awesomeqa.utils.data_Reader.PropertiesUtils;
import org.openqa.selenium.By;

public class MyAccountPage {
    //locators
    private By editAccountInfo = By.linkText("Edit your account information");
    private By changePassword = By.linkText("Change your password");
    private By MyAccountIcon = By.cssSelector("[title='My Account']");
    private By Logout = By.linkText("Logout");

    // constructor

    public MyAccountPage() {
    }

    // actions
    public void clickChangePassword() {
        ElementActions.clickElement(changePassword);
    }

    public void clickEditAccountInfo() {
        ElementActions.clickElement(editAccountInfo);
    }

    public void clickMyAccountIcon() {
        ElementActions.clickElement(MyAccountIcon);
    }

    public void clickMyLogoutIcon() {
        ElementActions.clickElement(Logout);
    }


    //validations

    public void assertDirectedToMyAccountURL() {
        Validations.validatePageUrl(PropertiesUtils.getPropertyValue("MyAccount"));
    }

    public void assertDirectedToChangePasswordPage() {
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("changePasswordPageTitle"));
    }

    public void assertDirectedToEditAccountInformationPage() {
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("EditAccountInfoPageTitle"));

    }
}
