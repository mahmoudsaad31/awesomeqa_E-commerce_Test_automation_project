package com.awesomeqa.utils;

import io.qameta.allure.Step;
import org.testng.Assert;

public class Validations {

    public Validations() {

    }

    @Step("Validate True")
    public static void validateTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    @Step("Validate False")
    public static void validateFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    @Step("Validate Equals")
    public static void validateEquals(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    @Step("Validate Not Equals")
    public static void validateNotEquals(String actual, String expected) {
        Assert.assertNotEquals(actual, expected);
    }

    @Step("Validate Page Url: {expected}")
    public static void validatePageUrl(String expected) {
        Assert.assertEquals(BrowserActions.getPageURL(), expected);
    }

    @Step("Validate Page Title: {expected}")
    public static void validatePageTitle(String expected) {
        Assert.assertEquals(BrowserActions.getPageTitle(), expected);
    }

    @Step("Validate Contains: {expected}")
    public static void validateContains(String actual, String expected) {
        Assert.assertTrue(actual.contains(expected));
    }


}
