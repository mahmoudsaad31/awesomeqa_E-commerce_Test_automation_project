package com.awesomeqa;

import com.awesomeqa.pages.ChangePasswordPage;
import com.awesomeqa.pages.LoginPage;
import com.awesomeqa.pages.MyAccountPage;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestChangePasswordFeature extends TestBase {

    @BeforeSuite()
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.login(getTestData("email"), getTestData("password"));
        loginPage.assertSuccessfulLogin();
        new MyAccountPage().clickChangePassword();
        new MyAccountPage().assertDirectedToChangePasswordPage();

    }

    @Test(priority = 1)
    public void testChangePasswordWithInvalidPassword() {
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.navigateToChangePasswordPage();
        changePasswordPage.changePassword(getTestData("invalidPassword"), getTestData("invalidPassword"));
        changePasswordPage.assertMSGforInvalidPassword();
    }

    @Test(priority = 2)
    public void testChangePasswordWithNotMatchedConfirmPassword() {
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.navigateToChangePasswordPage();
        changePasswordPage.changePassword(getTestData("password"), getTestData("invalidPassword"));
        changePasswordPage.assertMSGforPasswordConfirm();
    }

    @Test(priority = 3)
    public void testChangePassword() {
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.navigateToChangePasswordPage();
        changePasswordPage.changePassword(getTestData("password"), getTestData("password"));
        changePasswordPage.assertPasswordChangedSuccessfullyMSG();
    }


}

