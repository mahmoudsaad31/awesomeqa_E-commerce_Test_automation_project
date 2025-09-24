package com.awesomeqa;

import com.awesomeqa.pages.ForgottenPasswordPage;
import com.awesomeqa.utils.report.LogsUtils;
import org.testng.annotations.Test;

public class TestForgottenPasswordFeature extends TestBase {

    @Test
    public void testForgottenPasswordWithValidEmail() {
        LogsUtils.info("start of testForgottenPasswordWithValidEmail");
        ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage();
        forgottenPasswordPage.navigateToForgottenPasswordPage();
        forgottenPasswordPage.EnterYourEmail(getTestData("email"));
        forgottenPasswordPage.assertMessageShownForConfirmationLinkSentToEmail();
    }

    @Test
    public void testForgottenPasswordWithInValidEmail() {
        LogsUtils.info("start of testForgottenPasswordWithInValidEmail");
        ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage();
        forgottenPasswordPage.navigateToForgottenPasswordPage();
        forgottenPasswordPage.EnterYourEmail(getTestData("invalidEmail"));
        forgottenPasswordPage.assertMessageShownforEMailnotFoundInrecords();
    }


}
