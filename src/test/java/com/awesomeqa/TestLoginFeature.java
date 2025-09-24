package com.awesomeqa;

import com.awesomeqa.pages.LoginPage;
import com.awesomeqa.utils.report.LogsUtils;
import io.qameta.allure.Step;
import org.testng.annotations.Test;


public class TestLoginFeature extends TestBase {


    @Test(priority = 1)
    @Step(" start of method testUnSuccessfullLoginWithInvalidEmail ")
    public void testUnSuccessfullLoginWithInvalidEmail() {
        LogsUtils.info("start of method testUnSuccessfullLoginWithInvalidEmail");
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.login(getTestData("invalidEmail"), getTestData("password"));
        loginPage.assertUnSuccessfulLogin();

    }

    @Test(priority = 2)
    @Step(" start of method testUnSuccessfullLoginWithInvalidPassword ")
    public void testUnSuccessfullLoginWithInvalidpassword() {
        LogsUtils.info("start of method testUnSuccessfullLoginWithInvalidPassword");
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.login(getTestData("email"), getTestData("invalidPassword"));
        loginPage.assertUnSuccessfulLogin();
    }

    @Test(priority = 3)
    @Step(" start of method testUnSuccessfullLoginWithEmptyFields ")
    public void testUnSuccessfullLoginWithEmptyFields() {
        LogsUtils.info("start of method testUnSuccessfullLoginWithEmptyFields");
        LoginPage loginPage = new LoginPage();
        loginPage.login(" ", " ");
        loginPage.assertUnSuccessfulLogin();
    }

    @Test(priority = 4)
    @Step(" start of method testSuccessfullLogin ")
    public void testSuccessfullLoginWithValidCredentials() {
        LogsUtils.info("start of method testSuccessfullLogin");
        LoginPage loginPage = new LoginPage();
        loginPage.login(getTestData("email"), getTestData("password"));
        loginPage.assertSuccessfulLogin();
    }


}


