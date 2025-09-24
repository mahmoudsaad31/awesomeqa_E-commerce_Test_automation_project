package com.awesomeqa;

import com.awesomeqa.pages.RegisterPage;
import com.awesomeqa.utils.report.LogsUtils;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class TestRegisterFeature extends TestBase {

    @Test
    @Step("start of method TestSuccessfullRegister")
    public void TestSuccessfullRegister() {
        LogsUtils.info("start of method TestSuccessfullRegister");
        RegisterPage registerPage = new RegisterPage();
        registerPage.navigateToRegisterPage();
        registerPage.registerNewAcount(
                getTestData("firstname"), getTestData("lastname"),
                getTestData("email"), getTestData("telephone"),
                getTestData("password"), getTestData("password"));
        registerPage.assertSuccessfullnewAccountRegistered();
    }

    @Test
    @Step("start of method testUnsuccessfullRegistrationWithAlreadyRegisteredEmail")
    public void testUnsuccessfullRegistrationWithAlreadyRegisteredEmail() {
        LogsUtils.info("start of method testUnsuccessfullRegistrationWithAlreadyRegisteredEmail");
        RegisterPage registerPage = new RegisterPage();
        registerPage.navigateToRegisterPage();
        registerPage.registerNewAcount(
                getTestData("firstname"), getTestData("lastname"),
                getTestData("email"), getTestData("telephone"),
                getTestData("password"), getTestData("password"));
        registerPage.assertUNSuccessfullnewAccountRegistered();
    }

    @Test
    @Step("start of method testUnsuccessfullRegistrationWithInvalidEmail")
    public void testUnsuccessfullRegistrationWithInvalidEmail() {
        LogsUtils.info("start of method testUnsuccessfullRegistrationWithInvalidEmail");
        RegisterPage registerPage = new RegisterPage();
        registerPage.navigateToRegisterPage();
        registerPage.registerNewAcount(
                getTestData("firstname"), getTestData("lastname"),
                getTestData("invalidEmail"), getTestData("telephone"),
                getTestData("password"), getTestData("password"));
        registerPage.assertMessageShownWhenUserEnterInvalidEmail();

    }

    @Test
    @Step("start of method testUnsuccessfullRegistrationWithAllfieldsEmpty")
    public void testUnsuccessfullRegistrationWithAllfieldsEmpty() {
        LogsUtils.info("start of method testUnsuccessfullRegistrationWithAllfieldsEmpty");
        RegisterPage registerPage = new RegisterPage();
        registerPage.navigateToRegisterPage();
        registerPage.registerNewAcount("", "", "", "", "", "");
        registerPage.assertMessageShownWhenUserEnterInvalidFirstName();
        registerPage.assertMessageShownWhenUserEnterInvalidLastName();
        registerPage.assertMessageShownWhenUserEnterInvalidEmail();
        registerPage.assertMessageShownWhenUserEnterInvalidTelephone();
        registerPage.assertMessageShownWhenUserEnterInvalidPassword();


    }

}
