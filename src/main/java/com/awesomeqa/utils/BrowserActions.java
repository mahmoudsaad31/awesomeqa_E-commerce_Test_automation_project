package com.awesomeqa.utils;

import com.awesomeqa.drivers.DriverManager;
import com.awesomeqa.utils.report.LogsUtils;
import io.qameta.allure.Step;

public class BrowserActions {

    //constructor

    public BrowserActions() {
    }

    @Step("Navigating to URL: {url}")
    public static void navigateToURL(String url) {
        DriverManager.getDriver().get(url);
        LogsUtils.info("Navigated to URL: ", url);
    }


    @Step("Getting current page URL")
    public static String getPageURL() {
        LogsUtils.info("Current URL: ", DriverManager.getDriver().getCurrentUrl());
        return DriverManager.getDriver().getCurrentUrl();

    }

    @Step("Getting page title")
    public static String getPageTitle() {
        LogsUtils.info("Page title: ", DriverManager.getDriver().getTitle());
        return DriverManager.getDriver().getTitle();
    }

    // refresh
    @Step("Refreshing the page")
    public static void refreshPge() {
        DriverManager.getDriver().navigate().refresh();
        LogsUtils.info("Refreshing the page");
    }

    // refresh
    @Step("navigate back")
    public static void navigateBack() {
        DriverManager.getDriver().navigate().back();
        LogsUtils.info("navigate back");
    }

    //close browser
    @Step("Closing the browser")
    public static void closeBrowser() {
        LogsUtils.info("Closing the browser");
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit(); // 🚀 Ensure this is called
        }
    }
}
