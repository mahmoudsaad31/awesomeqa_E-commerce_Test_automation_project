package com.awesomeqa;

import com.awesomeqa.pages.ContactUsPage;
import org.testng.annotations.Test;

public class TestContactUsFeature extends TestBase {

    @Test
    public void testContactUsFeature() {
        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.navigateToContactUsPage();
        contactUsPage.fillContactUsForm(getTestData("firstname"), getTestData("email"), getTestData("EnquiryMsg"));
        contactUsPage.assertCofimatiomMessage();
    }

    @Test
    public void testContactUsFeatureWithInValidEmail() {
        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.navigateToContactUsPage();
        contactUsPage.fillContactUsForm(getTestData("firstname"), getTestData("invalidEmail"), getTestData("EnquiryMsg"));
        contactUsPage.assertMessageAppearedWhenUsingInValidEmail();
    }


}
