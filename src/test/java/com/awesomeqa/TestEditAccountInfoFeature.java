package com.awesomeqa;

import com.awesomeqa.pages.EditAccountInfoPage;
import com.awesomeqa.pages.LoginPage;
import com.awesomeqa.pages.MyAccountPage;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestEditAccountInfoFeature extends TestBase {

    @BeforeSuite()
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.login(getTestData("email"), getTestData("password"));
        loginPage.assertSuccessfulLogin();
        new MyAccountPage().clickEditAccountInfo();
        new MyAccountPage().assertDirectedToEditAccountInformationPage();

    }

    @Test
    public void TestEditAccountInformation() {
        EditAccountInfoPage editAccountinfoPage = new EditAccountInfoPage();
        editAccountinfoPage.navigateToEditAccountInfoPage();
        editAccountinfoPage.editAccountInformation(getTestData("firstname"), getTestData("lastname"), getTestData("email"), getTestData("telephone"));
        editAccountinfoPage.assertsuccessfulEditForAcountInfo();

    }

    @Test
    public void TestUnsuccessfullEditAccountInformationToAlreadyRegiteredEmail() {
        EditAccountInfoPage editAccountinfoPage = new EditAccountInfoPage();
        editAccountinfoPage.navigateToEditAccountInfoPage();
        editAccountinfoPage.editAccountInformation(getTestData("firstname"), getTestData("lastname"), getTestData("AlreadyRegisteredEmail"), getTestData("telephone"));
        editAccountinfoPage.assertUnsuccessfulEditAcountInfoWithALreadyRegisteredEmail();

    }
}
