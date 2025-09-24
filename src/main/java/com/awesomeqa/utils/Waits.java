package com.awesomeqa.utils;

import com.awesomeqa.drivers.DriverManager;
import com.awesomeqa.utils.report.LogsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {


    //constructor
    public Waits() {
    }

    
    public static void waitforElementToBeVisible(By locator) {
        LogsUtils.info("Waiting for element to be visible: ", locator.toString());
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitforElementToBeINVisible(By locator) {
        LogsUtils.info("Waiting for element to be Invisible: ", locator.toString());
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)).
                until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitforElementToBeClickable(By locator) {
        LogsUtils.info("Waiting for element to be clickable: ", locator.toString());
        waitforElementToBeVisible(locator);
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForTextToBe(By locator, String value) {
        LogsUtils.info("Waiting element: ", locator.toString(), "to change text to be", value);
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)).
                until(ExpectedConditions.textToBe(locator, value));
    }

    public static void sleepForCertainTime(int timeOutInMilliSeconds) {
        try {
            Thread.sleep(timeOutInMilliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

