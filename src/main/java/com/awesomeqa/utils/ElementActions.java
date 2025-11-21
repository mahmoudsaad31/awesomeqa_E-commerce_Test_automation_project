package com.awesomeqa.utils;

import com.awesomeqa.drivers.DriverManager;
import com.awesomeqa.utils.report.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {


    //constructor
    public ElementActions() {
    }

    //send keys
    @Step("Sending data: {data} to the element: {locator}")
    public static void sendData(By locator, String data) {
        Waits.waitforElementToBeVisible(locator);
        scrollToElement(locator);
        findElement(locator).clear();
        findElement(locator).sendKeys(data);

        LogsUtils.info("Data entered: ", data, " in the field: ", locator.toString());

    }

    //gettext
    @Step("Getting text from the element: {locator}")
    public static String getData(By locator) {
        Waits.waitforElementToBeVisible(locator);
        scrollToElement(locator);
        LogsUtils.info("Getting text from the element: ", locator.toString(), " Text: ", findElement(locator).getText());
        return findElement(locator).getText();
    }

    //find element
    public static WebElement findElement(By locator) {
        LogsUtils.info("Finding element: ", locator.toString());
        return DriverManager.getDriver().findElement(locator);
    }

    //scroll to element
    @Step("Scrolling to the element: {0}")
    public static void scrollToElement(By locator) {
        //code
        LogsUtils.info("Scrolling to the element: ", locator.toString());
        ((JavascriptExecutor) DriverManager.getDriver()).
                executeScript("arguments[0].scrollIntoView(true);", findElement(locator));
    }

    @Step("Clicking on the element: {locator}")
    public static void clickElement(By locator) {
        Waits.waitforElementToBeClickable(locator);
        scrollToElement(locator);
        findElement(locator).click();
        LogsUtils.info("Clicked on the element: ", locator.toString());
    }

    // get text from input field
    public static String getTextFromInputField(By locator) {
        Waits.waitforElementToBeVisible(locator);
        scrollToElement(locator);
        LogsUtils.info("Getting text from the input field: ", locator.toString(), " Text: ", findElement(locator).getDomAttribute("value"));
        return findElement(locator).getDomAttribute("value");
    }

    // get html source text from element
    public static String getHtmlSourceTextFromElement(By locator) {
        Waits.waitforElementToBeVisible(locator);
        scrollToElement(locator);
        LogsUtils.info("Getting html source text from element: ", locator.toString());
        return findElement(locator).getAttribute("innerHTML");
    }

    public static void selectFromDropDownList(By locator, String text) {
        Waits.waitforElementToBeVisible(locator);
        new Select(findElement(locator)).selectByVisibleText(text);
    }


}