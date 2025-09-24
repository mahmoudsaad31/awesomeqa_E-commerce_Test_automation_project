package com.awesomeqa.pages;

import com.awesomeqa.utils.BrowserActions;
import com.awesomeqa.utils.ElementActions;
import com.awesomeqa.utils.Validations;
import com.awesomeqa.utils.data_Reader.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ContactUsPage {

    // locators
    private By yourNameField = By.id("input-name");
    private By EmailField = By.id("input-email");
    private By enquiryField = By.id("input-enquiry");
    private By submitButton = By.cssSelector("[value='Submit']");
    private By pageMSG = By.cssSelector("#content p");
    private By invalidEmailMSG = RelativeLocator.with(By.tagName("div")).straightBelow(By.id("input-email"));

// constructor

    public ContactUsPage() {
    }

//actions

    public void navigateToContactUsPage() {
        BrowserActions.navigateToURL(PropertiesUtils.getPropertyValue("ContactUs"));
    }

    public void enterYourName(String name) {
        ElementActions.sendData(yourNameField, name);
    }

    public void enterEmail(String email) {
        ElementActions.sendData(EmailField, email);
    }

    public void enterEnquiry(String enquiry) {
        ElementActions.sendData(enquiryField, enquiry);
    }

    public void clickSubmit() {
        ElementActions.clickElement(submitButton);
    }

    public void fillContactUsForm(String name, String email, String enquiry) {
        enterYourName(name);
        enterEmail(email);
        enterEnquiry(enquiry);
        clickSubmit();
    }

    // validations


    public String getMSG(By locator) {
        return ElementActions.getData(locator);
    }

    public void assertCofimatiomMessage() {
        Validations.validateEquals(getMSG(pageMSG), PropertiesUtils.getPropertyValue("contactUs_MSG"));
    }


    public void assertMessageAppearedWhenUsingInValidEmail() {
        Validations.validateEquals(getMSG(invalidEmailMSG), PropertiesUtils.getPropertyValue("invalid_email_MSG"));
    }
}




